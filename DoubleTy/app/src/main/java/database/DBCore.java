package database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Berg on 26/04/16.
 */
public class DBCore extends SQLiteOpenHelper {

    private static final String NAMEDB = "DoubleTy";
    private static final int VERSION = 10;

    private DBCode code;

    public DBCore(Context context){
        super(context,NAMEDB,null,VERSION);
        code = new DBCode();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(String s: code.createTables()){
            db.execSQL("CREATE TABLE " + s);
        }for(String s: code.insertTables()){
            db.execSQL("INSERT INTO " + s );
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE pergunta");
        db.execSQL("DROP TABLE resposta");

    }
}
