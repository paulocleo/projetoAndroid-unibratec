package br.com.juridiario;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import br.com.juridiario.Fragment.ProcessoListFragment;
//import br.com.juridiario.Provider.ProcessoProvider;

public class ProcessoSalvoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processo_salvo);

        ProcessoPagerAdapter processoPagerAdapter = new ProcessoPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(processoPagerAdapter);


    }

    class ProcessoPagerAdapter extends FragmentPagerAdapter{

        public ProcessoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ProcessoListFragment processoListFragment = new ProcessoListFragment();

            return processoListFragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
