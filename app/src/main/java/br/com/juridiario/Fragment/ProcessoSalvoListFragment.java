package br.com.juridiario.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.juridiario.Banco.RepositorioProcesso;
import br.com.juridiario.ItemProcesso;
import br.com.juridiario.ItemProcessoAdapter;
import br.com.juridiario.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProcessoSalvoListFragment extends Fragment {

    ItemProcessoAdapter adapter;

    public ProcessoSalvoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RepositorioProcesso banco = new RepositorioProcesso(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_processo_salvo_list, container, false);

        List<ItemProcesso> listaMeusProcessos = banco.listarProcessosBaseSqLite();

//        ListView mListaMeusProcessos = (ListView) view.findViewById(R.id.ListaMeusProcessos);
        RecyclerView mListaMeusProcessos = (RecyclerView) view.findViewById(R.id.ListaSalvoMeusProcessos);


//        listaMeusProcessos.add(new ItemProcesso("Meu processo 1"));
//        listaMeusProcessos.add(new ItemProcesso("Meu processo 2"));

        adapter = new ItemProcessoAdapter(getActivity(), listaMeusProcessos);
//        adapter = new ProcessoCursorAdapter(getActivity(), null);

        //mListaMeusProcessos.setAdapter(adapter);

        // getActivity().getSupportLoaderManager().initLoader(0, null, this);

        return view;
    }
}
