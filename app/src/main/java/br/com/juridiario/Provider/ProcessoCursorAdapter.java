package br.com.juridiario.Provider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import br.com.juridiario.Banco.BancoHelper;
import br.com.juridiario.Banco.ProcessoContract;
import br.com.juridiario.R;

/**
 * Created by PCAC on 20/10/2016.
 */
public class ProcessoCursorAdapter extends SimpleCursorAdapter {

    private static final int LAYOUT = R.layout.item_processo;

    public ProcessoCursorAdapter(Context context, Cursor cursor) {
        super(context, LAYOUT, cursor, ProcessoContract.ALL_COLUMNS, null, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(LAYOUT, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView mNumeroProcesso = (TextView) view.findViewById(R.id.textNumeroProcessoItem);
        mNumeroProcesso.setText(cursor.getColumnIndex(ProcessoContract.NUM_PROCESSO));
    }
}
