package br.com.juridiario.Fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.juridiario.Banco.RepositorioProcesso;
import br.com.juridiario.ItemProcesso;
//import br.com.juridiario.ItemProcessoAdapter;
import br.com.juridiario.ItemProcessoAdapter;
import br.com.juridiario.Provider.ProcessoCursorAdapter;
//import br.com.juridiario.Provider.ProcessoProvider;
import br.com.juridiario.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProcessoListFragment extends Fragment {

    ItemProcessoAdapter adapter;
//    ProcessoCursorAdapter adapter;

    public ProcessoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RepositorioProcesso banco = new RepositorioProcesso(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_processo_list, container, false);

        List<ItemProcesso> listaMeusProcessos = banco.listarProcessosBaseSqLite();

        ListView mListaMeusProcessos = (ListView) view.findViewById(R.id.ListaMeusProcessos);

//        listaMeusProcessos.add(new ItemProcesso("Meu processo 1"));
//        listaMeusProcessos.add(new ItemProcesso("Meu processo 2"));

            adapter = new ItemProcessoAdapter(getContext(), listaMeusProcessos);
//        adapter = new ProcessoCursorAdapter(getActivity(), null);

        mListaMeusProcessos.setAdapter(adapter);

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);

       // getActivity().getSupportLoaderManager().initLoader(0, null, this);

        return view;
    }
}
