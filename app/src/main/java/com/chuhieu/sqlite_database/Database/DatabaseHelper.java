package com.chuhieu.sqlite_database.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chuhieu.sqlite_database.DAO.NguoiDungDao;

public class DatabaseHelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME= "dbBookmanager";
    public static final int   VERSION= 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(NguoiDungDao.SQL_Nguoi_Dung);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NguoiDungDao.TABLE_NAME);
    }

}
