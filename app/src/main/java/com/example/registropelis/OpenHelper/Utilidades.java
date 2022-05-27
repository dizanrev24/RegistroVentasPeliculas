package com.example.registropelis.OpenHelper;

public class Utilidades {


    public static final String TABLE_NAME_USUARIO = "Usuario";
    public static final String COLUMN_ID_USUARIO  = "id";
    public static final String COLUMN_CORREO_USUARIO = "correo";
    public static final String COLUMN_CONTRA_USUARIO = "contra";


    public static final String CREATE_TABLE_Usuario = "CREATE TABLE " + TABLE_NAME_USUARIO +
            " ( " + COLUMN_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CORREO_USUARIO + " TEXT," +
            COLUMN_CONTRA_USUARIO + " TEXT);";


    public static final String TABLE_NAME_VENTAS = "ventas";
    public static final String COLUMN_ID_VENTAS  = "id";
    public static final String COLUMN_CORREO_VENTAS = "correo";
    public static final String COLUMN_NOMBRE_VENTAS = "nombre";
    public static final String COLUMN_APELLIDO_VENTAS = "apellido";
    public static final String COLUMN_DIRECCION_VENTAS = "direccion";
    public static final String COLUMN_TELEFONO_VENTAS = "telefono";
    public static final String COLUMN_NOMBREPELI_VENTAS = "nombre_pelicula";
    public static final String COLUMN_CANTIDADVENDIDA_VENTAS = "cantidad_vendida";
    public static final String COLUMN_PRECIOPELI_VENTAS = "precio";

    public static final String CREATE_TABLE_Ventas = "CREATE TABLE " + TABLE_NAME_VENTAS +
            " ( " + COLUMN_ID_VENTAS + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CORREO_VENTAS + " TEXT," +
            COLUMN_NOMBRE_VENTAS + " TEXT," +
            COLUMN_APELLIDO_VENTAS + " TEXT," +
            COLUMN_DIRECCION_VENTAS + " TEXT," +
            COLUMN_TELEFONO_VENTAS + " TEXT," +
            COLUMN_NOMBREPELI_VENTAS + " TEXT," +
            COLUMN_CANTIDADVENDIDA_VENTAS + " TEXT," +
            COLUMN_PRECIOPELI_VENTAS + " TEXT);";


    public static final String TABLE_NAME_REGISTROPELIS = "registroPelis";
    public static final String COLUMN_ID_REGISTROPELIS  = "id";
    public static final String COLUMN_CODIGO_REGISTROPELIS = "codigo";
    public static final String COLUMN_NOMBRE_REGISTROPELIS = "nombre_pelicula";
    public static final String COLUMN_PRECIO_REGISTROPELIS = "precio_pelicula";
    public static final String COLUMN_EXISTENCIA_REGISTROPELIS = "existencia_pelicula";


    public static final String CREATE_TABLE_RegistroPelis = "CREATE TABLE " + TABLE_NAME_REGISTROPELIS +
            " ( " + COLUMN_ID_REGISTROPELIS + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CODIGO_REGISTROPELIS + " TEXT," +
            COLUMN_NOMBRE_REGISTROPELIS + " TEXT," +
            COLUMN_PRECIO_REGISTROPELIS + " TEXT," +
            COLUMN_EXISTENCIA_REGISTROPELIS + " TEXT);";
}
