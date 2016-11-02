package br.com.juridiario;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.juridiario.Banco.RepositorioProcesso;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        final ItemProcesso processo = (ItemProcesso) getIntent().getSerializableExtra("PROCESSO");

        TextView mtextEdicao = (TextView)findViewById(R.id.textEdicao);
        TextView mtextNomeAdvogado = (TextView)findViewById(R.id.textNomeAdvogado);
        TextView mtextDescProcesso = (TextView)findViewById(R.id.textDescProcesso);

        mtextEdicao.setText(processo.getDesEdicao());
        mtextNomeAdvogado.setText(processo.getDesAdvogado());
        mtextDescProcesso.setText(processo.getProcessoTexto());

        ImageButton mImgButton = (ImageButton) findViewById(R.id.btnSalvarProcesso);

        mImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RepositorioProcesso banco = new RepositorioProcesso(getBaseContext());

                banco.inserir(processo);
                Toast.makeText(DetalheActivity.this, "Processo salvo com sucesso", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
