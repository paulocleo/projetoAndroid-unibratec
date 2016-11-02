package br.com.juridiario;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String URL_SERVICO = "https://jsondiario.herokuapp.com/rest/json/processos/%s";
    public static final String NOME_ADVOGADO = "bruno";
    boolean naoCarregouLista = false;

    private ItemProcessoAdapter adapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exibirPopUpEspera();
                new EventoTask().execute();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ListView mLista = (ListView) findViewById(R.id.lista);

        adapter = new ItemProcessoAdapter(this, new ArrayList<ItemProcesso>());

        mLista.setAdapter(adapter);
        mLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                intent.putExtra("PROCESSO", (ItemProcesso) adapterView.getItemAtPosition(position));
                startActivity(intent);
            }
        });

        this.exibirPopUpEspera();
        new EventoTask().execute();

        if(naoCarregouLista){
            Toast.makeText(this, "Ops! Servidor muito lento, tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void exibirPopUpEspera(){
        //INICIO - EXIBINDO POPUP DE ESPERA
        dialog = new ProgressDialog(this);
        dialog.setMessage("@string/");
        dialog.setTitle("JuriDiario");
        dialog.show();
        //FIM - EXIBINDO POPUP DE ESPERA
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.item_menu_meus_processos) {
            Intent intent = new Intent(MainActivity.this, ProcessoSalvoActivity.class);
            startActivity(intent);
            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class EventoTask extends AsyncTask<Void, Void, List<ItemProcesso>>{

        @Override
        protected List<ItemProcesso> doInBackground(Void... voids) {

            List<ItemProcesso> lista = new ArrayList<>();
            OkHttpClient client = new OkHttpClient();
            try{
                String url = String.format(URL_SERVICO, NOME_ADVOGADO);
                Request request = new Request.Builder().url(url).build();
                Response response = null;

                response = client.newCall(request).execute();
                String jsonList = response.body().string();
                return JsonUtil.fromJson(jsonList);

            }catch (SocketTimeoutException timeout){
                timeout.printStackTrace();

            }catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ItemProcesso> listaProcessos) {
            if(listaProcessos != null){
                adapter.addAll(listaProcessos);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }else{
                naoCarregouLista = true;
                dialog.dismiss();
            }
        }
    }
}
