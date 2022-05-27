package com.example.registropelis.OpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQliteHelper extends SQLiteOpenHelper {
    public ConexionSQliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Utilidades.CREATE_TABLE_Usuario);
        sqLiteDatabase.execSQL(Utilidades.CREATE_TABLE_Ventas);
        sqLiteDatabase.execSQL(Utilidades.CREATE_TABLE_RegistroPelis);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLE_NAME_USUARIO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLE_NAME_VENTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLE_NAME_REGISTROPELIS);
        onCreate(sqLiteDatabase);
    }
}
