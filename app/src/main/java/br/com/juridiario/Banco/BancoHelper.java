package br.com.juridiario.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PCAC on 16/09/2016.
 */
public class BancoHelper extends SQLiteOpenHelper {

    private String scriptCreate;
    private String scriptDelete;

    public BancoHelper(Context context, String nameBD, int versaoBanco, String scriptCreate, String scriptDelete) {
        super(context, nameBD, null, versaoBanco);

        this.scriptCreate = scriptCreate;
        this.scriptDelete = scriptDelete;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.scriptCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptDelete);
        onCreate(db);
    }
}