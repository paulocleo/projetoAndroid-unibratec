package br.com.juridiario.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.juridiario.ItemProcesso;
import br.com.juridiario.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheProcessoFragment extends Fragment {

    public static DetalheProcessoFragment newInstance(ItemProcesso processo) {
        Bundle args = new Bundle();
        args.putSerializable("PROCESSO", processo);

        DetalheProcessoFragment detailProcessoFragment = new DetalheProcessoFragment();
        detailProcessoFragment.setArguments(args);
        return detailProcessoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe_processo, container, false);
    }

}
