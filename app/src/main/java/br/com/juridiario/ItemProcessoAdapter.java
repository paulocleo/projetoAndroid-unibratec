package br.com.juridiario;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PCAC on 19/10/2016.
 */
public class ItemProcessoAdapter extends ArrayAdapter<ItemProcesso> {


    public ItemProcessoAdapter(Context context, List<ItemProcesso> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;

        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_processo, parent, false);
        }

        ItemProcesso itemProcesso = getItem(position);

        TextView mNumeroProcesso = (TextView) itemView.findViewById(R.id.textNumeroProcessoItem);
        mNumeroProcesso.setText(itemProcesso.getNumeroProcesso());

        return itemView;
    }
}
