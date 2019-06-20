package com.chuhieu.sqlite_database.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chuhieu.sqlite_database.DAO.NguoiDungDao;
import com.chuhieu.sqlite_database.R;
import com.chuhieu.sqlite_database.model.Nguoidung;

import java.util.List;
import java.util.zip.Inflater;

public class NguoidungAdapter extends RecyclerView.Adapter<NguoidungAdapter.NguoidungHolder> {
    private List<Nguoidung> nguoidungList;
    private Context context;
    private LayoutInflater layoutInflater;
    private NguoiDungDao nguoiDungDao;



//    Ham khoi tao
    public NguoidungAdapter(List<Nguoidung> nguoidungList, Context context) {
        this.nguoidungList = nguoidungList;
        this.context = context;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDao=new NguoiDungDao(context);

    }

// Tao view
    @NonNull
    @Override
    public NguoidungHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_nguoidung,parent,false);
        return new NguoidungHolder(view);


    }

//    gan du lieu
    @Override
    public void onBindViewHolder(@NonNull NguoidungHolder holder, final int position) {
       final   Nguoidung nguoidung = nguoidungList.get(position);
//        holder.tvtaikhoan.setText(nguoidung.getUserName());
//        holder.tvmakhau.setText(nguoidung.getPassWords());
        holder.tvphone.setText(nguoidung.getPhone());
        holder.tvhoten.setText(nguoidung.getHoten());
        holder.imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//lay vi tri item
                nguoidungList.get(position);
//xoa item trong database
                nguoiDungDao.deleteNguoiDungByID(nguoidungList.get(position).getUserName());
// xoa tren rececylview
                nguoidungList.remove(nguoidung);
// luu thay doi
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return nguoidungList.size();
    }

//
    public static  class NguoidungHolder extends RecyclerView.ViewHolder {
       public TextView tvtaikhoan,tvmakhau,tvphone,tvhoten;
       public ImageView imgnguoidung,imgclose;

        public NguoidungHolder(View itemView) {
            super(itemView);
            tvhoten=itemView.findViewById(R.id.tvhoten);
            tvphone=itemView.findViewById(R.id.tvphone);
//            tvmakhau=itemView.findViewById(R.id.tvmatkhau);
//            tvtaikhoan=itemView.findViewById(R.id.tvtaikhoan);

            imgnguoidung=itemView.findViewById(R.id.imagenguoidung);
            imgclose=itemView.findViewById(R.id.imageclose );
        }
    }
}
