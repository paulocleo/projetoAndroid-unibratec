//package br.com.juridiario.Provider;
//
//import android.content.ContentProvider;
//import android.content.ContentResolver;
//import android.content.ContentValues;
//import android.content.UriMatcher;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteQueryBuilder;
//import android.net.Uri;
//import android.support.annotation.Nullable;
//
//import java.net.URI;
//
//import br.com.juridiario.Banco.BancoHelper;
//import br.com.juridiario.Banco.ProcessoContract;
//
///**
// * Created by PCAC on 20/10/2016.
// */
//public class ProcessoProvider extends ContentProvider{
//    private static final String AUTHORITY = "br.com.juridiario";
//    private static final int TYPE_PROCESSOS_LIST = 0;
//    private static final int TYPE_PROCESSOS_BY_ID = 1;
//
//    private static final String PATH = "processos";
//    public static Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
//
//    public static Uri PROCESSOS_URI = BASE_URI.withAppendedPath(BASE_URI, PATH);
//
//    private static final int TYPE_GENERIC = 0;
//    private static final int TYPE_ID = 1;
//
//    private UriMatcher mMatcher;
//    private DBHelper dbHelper;
//
//    public ProcessoProvider() {
//        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//        mMatcher.addURI(AUTHORITY, PATH, TYPE_GENERIC);
//        mMatcher.addURI(AUTHORITY, PATH, TYPE_ID);
//    }
//
//    @Override
//    public boolean onCreate() {
//        dbHelper = new DBHelper(getContext());
//        return true;
//    }
//
//
//    @Nullable
//    @Override
//    public String getType(Uri uri) {
//        int uriType = mMatcher.match(uri);
//        switch (uriType){
//            case TYPE_GENERIC:
//                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + AUTHORITY;
//            case TYPE_ID:
//                return ContentResolver.CURSOR_ITEM_BASE_TYPE +"/"+ AUTHORITY;
//            default:
//                throw new IllegalArgumentException("Invalid Uri");
//        }
//    }
//
//    @Nullable
//    @Override
//    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//
//        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
//
//        queryBuilder.setTables(ProcessoContract.NOME_TABELA);
//
//        int uriType = mMatcher.match(uri);
//        Cursor cursor = null;
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        switch (uriType) {
//            case TYPE_PROCESSOS_LIST:
//                cursor = queryBuilder.query(db,
//                        projection,
//                        selection,
//                        selectionArgs, null, null, sortOrder);
//                break;
//            case TYPE_PROCESSOS_BY_ID:
//                queryBuilder.appendWhere(ProcessoContract.ID_PROCESSO + "= ?");
//
//                cursor = queryBuilder.query(
//                        db,
//                        projection,
//                        selection,
//                        new String[]{uri.getLastPathSegment()},
//                        null,
//                        null,
//                        null);
//                break;
//
//            default:
//                throw new IllegalArgumentException(
//                        "Unknow URI:" + uri);
//        }
//
//        cursor.setNotificationUri(
//                getContext().getContentResolver(), uri);
//
//        return cursor;
//    }
//
//    @Nullable
//    @Override
//    public Uri insert(Uri uri, ContentValues contentValues) {
//        return null;
//    }
//
//    @Override
//    public int delete(Uri uri, String s, String[] strings) {
//        return 0;
//    }
//
//    @Override
//    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
//        return 0;
//    }
//}
