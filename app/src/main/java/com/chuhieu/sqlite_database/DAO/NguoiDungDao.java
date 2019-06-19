package com.chuhieu.sqlite_database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.chuhieu.sqlite_database.Database.DatabaseHelper;
import com.chuhieu.sqlite_database.model.Nguoidung;

public class NguoiDungDao {
    public DatabaseHelper databaseHelper;
    public SQLiteDatabase db;
    public static final String TABLE_NAME ="nguoidung";
    private static final String TAIKHOAN ="UserName";
    private static final String MATKHAU ="passWords";
    private static final String PHONE ="phone";
    private static final String HOTEN ="hoten";
//cau lenh tao bang
    public  static  final String SQL_Nguoi_Dung="CREATE TABLE "+TABLE_NAME +" (" +
            TAIKHOAN +" TEXT primary key, "+
            MATKHAU + " TEXT, "+
            PHONE +" TEXT, "+
            HOTEN +" TEXT)";
// cap quyen` ghi du lieu
    public NguoiDungDao(Context context ){
        databaseHelper = new DatabaseHelper(context);
        db=databaseHelper.getWritableDatabase();
    }
//    ham` them nguoi` dung
    public int insertNguoiDung(Nguoidung nguoidung){
        ContentValues values = new ContentValues();
        values.put(NguoiDungDao.TAIKHOAN,nguoidung.getUserName());
        values.put(NguoiDungDao.MATKHAU,nguoidung.getPassWords());
        values.put(NguoiDungDao.PHONE,nguoidung.getPhone());
        values.put(NguoiDungDao.HOTEN,nguoidung.getHoten());

        try {
            if (db.insert(TABLE_NAME,null,values)<0){

                return -1;
            }

        }catch (Exception ex){
            Log.e("Nguoidungdao",ex.getMessage());
        }

        return 1;
    }

}
