package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.berg.doublety.entidades.Pergunta;
import com.example.berg.doublety.entidades.Resposta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berg on 26/04/16.
 */
public class DBController {

    private DBCore dbCore;
    private SQLiteDatabase database;

    public DBController(Context context) {
        dbCore = new DBCore(context);
    }

    public List<Pergunta> getPerguntaTipo(String tipo) {
        database = dbCore.getReadableDatabase();
        List<Pergunta> perguntas = new ArrayList<>();
        String[] coluns = new String[]{"id" , "texto" , "tipo"};
        Cursor cursor = database.query("pergunta" , coluns, "tipo = ?" , new String[]{"" + tipo.toLowerCase()}, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Pergunta p = new Pergunta();
                p.setId(cursor.getLong(0));
                p.setTexto(cursor.getString(1));
                p.setTipo(cursor.getString(2));
                p.setAlternativas(getRespostas(cursor.getLong(0)));

                perguntas.add(p);
            } while (cursor.moveToNext());
        }
        cursor.close();
        dbCore.close();
        return perguntas;
    }

    private List<Resposta> getRespostas(long id){
        database = dbCore.getReadableDatabase();
        List<Resposta> respostas = new ArrayList<>();
        String[] coluns = new String[]{"_id","texto","status","idPergunta"};
        Cursor cursor = database.query("resposta", coluns, "idPergunta = ?", new String[]{""+id}, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Resposta resposta = new Resposta();
                Log.i("db", ""+cursor.getCount());
                resposta.setId(cursor.getLong(0));
                resposta.setTexto(cursor.getString(1));
                resposta.setStatus(cursor.getString(2).equalsIgnoreCase("true"));
                respostas.add(resposta);
            }while (cursor.moveToNext());
        }
        cursor.close();
        dbCore.close();
        return respostas;
    }

    public Pergunta buscarPerguntaPorId(long id) {
        database = dbCore.getReadableDatabase();
        Pergunta p = new Pergunta();
        String[] coluns = new String[]{"id" , "texto" , "tipo"};
        Cursor cursor = database.query("pergunta" , coluns, "id = ?" , new String[]{"" + id}, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                p.setId(cursor.getLong(0));
                p.setTexto(cursor.getString(1));
                p.setTipo(cursor.getString(2));
                p.setAlternativas(getRespostas(cursor.getLong(0)));

            } while (cursor.moveToNext());
        }
        cursor.close();
        dbCore.close();
        return p;
    }
}
