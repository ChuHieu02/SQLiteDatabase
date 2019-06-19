package com.chuhieu.sqlite_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chuhieu.sqlite_database.DAO.NguoiDungDao;
import com.chuhieu.sqlite_database.model.Nguoidung;

public class NguoiDungActivity extends AppCompatActivity {
    EditText edtaikhoan,edmatkhau,edphone,edhoten;
    NguoiDungDao nguoiDungDao;
    Nguoidung nguoidung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);

        edtaikhoan=findViewById(R.id.edtaikhoan);
        edmatkhau=findViewById(R.id.edmatkhau);
        edphone=findViewById(R.id.edphone);
        edhoten=findViewById(R.id.edhoten);
    }

    public void themnguoidung(View view) {
        nguoiDungDao= new NguoiDungDao(NguoiDungActivity.this);
         nguoidung = new Nguoidung(
                 edhoten.getText().toString(),
                 edphone.getText().toString(),
                 edtaikhoan.getText().toString(),
                 edmatkhau.getText().toString());
         if (nguoiDungDao.insertNguoiDung(nguoidung)==1)
         {
             Toast.makeText(getApplicationContext(),"Them Thanh Cong",
                     Toast.LENGTH_LONG).show();
         }else {
             Toast.makeText(getApplicationContext(),"Co loi xay ra",
                     Toast.LENGTH_LONG).show();
         }
    }
}
