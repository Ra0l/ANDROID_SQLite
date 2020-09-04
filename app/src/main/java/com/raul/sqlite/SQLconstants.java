package com.raul.sqlite;

public class SQLconstants {

    //Niombre de la base de datos
    public static final String DB = "bdusuarios.db";

    //Nombre de la tabla
    public static final String tableUsuarios = "usuarios";

    //Nombred de las columnas
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_EDAD = "edad";
    public static final String COLUMN_CORREO = "correo";

    //sentencias sql
    public static final String SQL_CREATE_TABLE_USUARIOS = "CREATE TABLE " + tableUsuarios + "(" +
            COLUMN_ID + " TEXT PRIMARY KEY," +
            COLUMN_NOMBRE + " TEXT," +
            COLUMN_EDAD + " INT," +
            COLUMN_CORREO + " TEXT" + ")";

    //clausula de busqueda
    public static final String SEARCH_BY_ID = "id=?";

    //clusula eliminar
    public static final String WHEREID_CLAUSE = "id=?";

    //Sentencia eliminar tabla
    public static  final String SQL_DELETE = "DROP_TABLE " + tableUsuarios;

    public static final String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_NOMBRE,COLUMN_EDAD,COLUMN_CORREO};




}
