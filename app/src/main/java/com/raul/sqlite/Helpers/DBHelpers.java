package com.raul.sqlite.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.raul.sqlite.SQLconstants;

public class DBHelpers extends SQLiteOpenHelper {

    //Constants
    public static final int DB_VERSION = 1;

    public DBHelpers(Context context){
        super(context, SQLconstants.DB,null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLconstants.SQL_CREATE_TABLE_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLconstants.SQL_DELETE);
        onCreate(sqLiteDatabase);
    }
}
