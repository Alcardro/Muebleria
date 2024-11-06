package com.example.muebleria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "users.db"; // Nombre del archivo de la base de datos
    private static final String TABLE_NAME = "users"; // Nombre de la tabla donde guardaremos usuarios
    private static final String COL_USERNAME = "username"; // Columna para los nombres de usuario
    private static final String COL_PASSWORD = "password"; // Columna para las contraseñas

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1); // Creación de la base de datos
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT, " +
                COL_PASSWORD + " TEXT)"); // Crear la tabla "users" con columnas "username" y "password"
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Método para agregar un usuario a la base de datos
    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1; // Retorna true si se guarda correctamente
    }

    // Método para verificar el usuario y la contraseña
    public boolean validateUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                COL_USERNAME + "=? AND " + COL_PASSWORD + "=?", new String[]{username, password});
        boolean isValid = cursor.getCount() > 0; // Retorna true si encuentra coincidencia
        cursor.close();
        return isValid;
    }
}
