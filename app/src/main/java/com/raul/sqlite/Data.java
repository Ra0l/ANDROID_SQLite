package com.raul.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.raul.sqlite.Helpers.DBHelpers;
import com.raul.sqlite.POJOS.Usuario;

public class Data {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context){
        this.context = context;
        sqLiteOpenHelper = new DBHelpers(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void  close(){
        sqLiteOpenHelper.close();
    }

    //Instruccion inertar
    public void insertUsuario(Usuario usuario){
        ContentValues values = usuario.toValues();
        sqLiteDatabase.insert(SQLconstants.tableUsuarios,null,values);
    }

    //instruccion buscar
    public Usuario getUsuario(String id){
        Usuario usuario = new Usuario();
        String[] whereArgs = new String[]{id};

        Cursor cursor = sqLiteDatabase.query(SQLconstants.tableUsuarios,
                SQLconstants.ALL_COLUMNS,
                SQLconstants.SEARCH_BY_ID,
                whereArgs,
                null,null,null);

            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                // while (cursor.moveToNext()){
                usuario.setId(cursor.getString(cursor.getColumnIndex(SQLconstants.COLUMN_ID)));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLconstants.COLUMN_NOMBRE)));
                usuario.setEdad(cursor.getInt(cursor.getColumnIndex(SQLconstants.COLUMN_EDAD)));
                usuario.setCorreo(cursor.getString(cursor.getColumnIndex(SQLconstants.COLUMN_CORREO)));
                //}
            }

        return usuario;
    }

    //instruccion eliminar usuario
    public void deleteUser(String id){
        String[] whereArgs = new String[] {String.valueOf(id)};
        sqLiteDatabase.delete(SQLconstants.tableUsuarios,SQLconstants.WHEREID_CLAUSE,whereArgs);
    }

    //instruccion actualizar
    public void UpdateUser(String id, ContentValues contentValues){
        String[] whereArgs = new String[]{String.valueOf(id)};
         sqLiteDatabase.update(SQLconstants.tableUsuarios,
                contentValues,SQLconstants.SEARCH_BY_ID,whereArgs);
    }
}
