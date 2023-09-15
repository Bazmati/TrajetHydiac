package com.example.trajethydiac3.dal.util;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trajethydiac3.bo.Trajet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "trajet.db";
    private static final int DATABASE_VERSION = 2;




    // Définissez la structure de votre base de données dans le constructeur
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableUser = "CREATE TABLE User (user_id INTEGER PRIMARY KEY AUTOINCREMENT, former_id INTEGER, name TEXT, firstname TEXT, pseudo TEXT, phone_pro TEXT, email_pro EMAIL, status TEXT);";
        String createTableTravel = "CREATE TABLE Trajet (id INTEGER PRIMARY KEY AUTOINCREMENT, date_start DATETIME, date_end DATETIME, distance DOUBLE, type TEXT);";
        String createTableCar = "CREATE TABLE Car (id_car INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, registration TEXT, mile INTEGER);";

        db.execSQL(createTableUser);
        db.execSQL(createTableTravel);
        db.execSQL(createTableCar);
        Log.i ("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Trajet");
        db.execSQL("DROP TABLE IF EXISTS Car");

        onCreate(db);
        Log.i ("DATABASE", "onUpgrade invoked");
    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void insertTrajet(Trajet trajet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date_start", trajet.getDateStart().toString());
        values.put("date_end", trajet.getDateEnd().toString());
        values.put("distance", trajet.getDistance());
        values.put("type", trajet.getType());

        db.insert("Trajet", null, values);
        db.close();
        Log.i("DATABASE", "insertScore invoked");
    }

    /** public List<Trajet> getAllTrajets(){
        List<Trajet> trajets = new ArrayList<>();
        String strSql = "select * from Trajet";
        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String dateStartStr = cursor.getString(cursor.getColumnIndex("date_start"));
            String dateEndStr = cursor.getString(cursor.getColumnIndex("date_end"));
            double distance = cursor.getDouble(cursor.getColumnIndex("distance"));
            String type = cursor.getString(cursor.getColumnIndex("type"));

            // Convertir les chaînes en LocalDateTime (assurez-vous d'avoir la logique de conversion)
            LocalDateTime dateStart = LocalDateTime.parse(dateStartStr, formatter);
            LocalDateTime dateEnd = LocalDateTime.parse(dateStartStr, formatter);


            Trajet trajet = new Trajet(id, dateStart, dateEnd, distance, type);
            trajets.add(trajet);
        }

        cursor.close();
        return trajets;
    }*/
}
