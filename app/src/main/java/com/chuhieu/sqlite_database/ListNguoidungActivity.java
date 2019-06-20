package com.chuhieu.sqlite_database;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chuhieu.sqlite_database.DAO.NguoiDungDao;
import com.chuhieu.sqlite_database.adapter.NguoidungAdapter;
import com.chuhieu.sqlite_database.model.Nguoidung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoidungActivity extends AppCompatActivity {

    public List<Nguoidung>nguoidungList=new ArrayList<>();
    NguoiDungDao nguoiDungDao;
    NguoidungAdapter nguoidungAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoidung);
//        To day is the beautiful

        recyclerView = findViewById(R.id.rcview);
        nguoiDungDao= new NguoiDungDao(ListNguoidungActivity.this);
        nguoidungList=nguoiDungDao.getallNguoiDung();
        nguoidungAdapter= new NguoidungAdapter(nguoidungList,ListNguoidungActivity.this);
//thiet lap linerlayout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//them adapter vao rv
        recyclerView.setAdapter(nguoidungAdapter);

//floatActionbutton
        FloatingActionButton floatingActionButton = findViewById(R.id.flbtnadd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListNguoidungActivity.this,NguoiDungActivity.class));
            }
        });
    }



}
