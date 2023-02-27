package com.example.tleng2023.configuracion;

public class Transacciones
{
    // Nombre de la bd
    public static final String NameDatabase = "TLENG";

    // Creacion de tabla y objetos
    public static final String tablaperson = "personas";

    /* Campos de la tabla personas */
    public static String id = "id";
    public static String nombres = "nombres";
    public static String apellidos = "apellidos";
    public static String edad = "edad";
    public static String correo = "correo";

    // Consultas SQL DDL
    public static String CreateTBPersonas = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT )";

    public static String DropTBPersonas = "DROP TABLE IF EXISTS personas";
}
