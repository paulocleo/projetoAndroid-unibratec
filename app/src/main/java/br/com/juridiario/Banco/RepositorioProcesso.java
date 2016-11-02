package br.com.juridiario.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.juridiario.ItemProcesso;


/**
 * Created by PCAC on 16/09/2016.
 */
public class RepositorioProcesso {

    private static final String SCRIPT_DB_CREATE =
            "CREATE TABLE "+ ProcessoContract.NOME_TABELA + "(" +
                    ProcessoContract.ID_PROCESSO          + " integer primary key autoincrement," +
                    ProcessoContract.NUM_PROCESSO         + " text not null," +
                    ProcessoContract.DES_ADVOGADO         + " text not null," +
                    ProcessoContract.PROCESSO_TEXTO       + " text not null," +
                    ProcessoContract.DES_EDICAO           + " text not null," +
                    ProcessoContract.DES_EDICAO_COMPLETA  + " )";

    private static final String SCRIPT_DB_DELETE = "DROP TABLE IF EXISTS "+ ProcessoContract.NOME_TABELA;
    private SQLiteDatabase db;
    private BancoHelper dbHelper;

    public RepositorioProcesso(Context ctx) {
        dbHelper = new BancoHelper(ctx, ProcessoContract.NOME_BANCO, 1, SCRIPT_DB_CREATE, SCRIPT_DB_DELETE);
    }

    public long inserir(ItemProcesso processo) {
        ContentValues cv = new ContentValues();
        long id = -1;
        try {
            cv.put(ProcessoContract.NUM_PROCESSO, processo.getNumeroProcesso());
            cv.put(ProcessoContract.DES_ADVOGADO, processo.getDesAdvogado());
            cv.put(ProcessoContract.PROCESSO_TEXTO, processo.getProcessoTexto());
            cv.put(ProcessoContract.DES_EDICAO, processo.getDesEdicao());
            cv.put(ProcessoContract.DES_EDICAO_COMPLETA, processo.getDesEdicaoCompleta());

            db = dbHelper.getWritableDatabase();
            id = db.insert(ProcessoContract.NOME_TABELA, null, cv);
            db.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return id;
    }

    public List<ItemProcesso> listarProcessosBaseSqLite() {

        List<ItemProcesso> lista = new ArrayList<>();

        try {
            String[] columns = new String[]
                    {
                            ProcessoContract.ID_PROCESSO,
                            ProcessoContract.NUM_PROCESSO,
                            ProcessoContract.DES_ADVOGADO,
                            ProcessoContract.PROCESSO_TEXTO,
                            ProcessoContract.DES_EDICAO,
                            ProcessoContract.DES_EDICAO_COMPLETA
                    };
            db = dbHelper.getWritableDatabase();
            Cursor c = db.query(ProcessoContract.NOME_TABELA, columns, null, null, null, null, ProcessoContract.ID_PROCESSO);

            c.moveToFirst();
            while (!c.isAfterLast()) {
                ItemProcesso processo = fillProcesso(c);
                lista.add(processo);
                c.moveToNext();
            }
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }


        return lista;
    }

    private ItemProcesso fillProcesso(Cursor c) {
        ItemProcesso processo = new ItemProcesso();

        processo.setCodId(c.getInt(0));
        processo.setNumeroProcesso(c.getString(1));
        processo.setDesAdvogado(c.getString(2));
        processo.setProcessoTexto(c.getString(3));
        processo.setDesEdicao(c.getString(4));
        processo.setDesEdicaoCompleta(c.getString(5));

        return processo;
    }
}
