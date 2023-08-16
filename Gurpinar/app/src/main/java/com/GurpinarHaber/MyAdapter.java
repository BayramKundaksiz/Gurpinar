package com.GurpinarHaber;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>
{

    List<ResponseModel> data;

    private final IAnasayfaDetaylari iAnasayfaDetaylari;

    Context context;

    public MyAdapter(List<ResponseModel> data, IAnasayfaDetaylari iOtobusSaatleriInterface, Context context) {
        this.data = data;
        this.iAnasayfaDetaylari = iOtobusSaatleriInterface;
        this.context = context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view,iAnasayfaDetaylari);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(data.get(position).getName());
        holder.t2.setText(data.get(position).getDesig());
        Glide.with(holder.t1.getContext())
                .load("http://gilaburu.site/Gurpinar/resimler/" +data.get(position).getImage()).into(holder.img);



    }

    @Override
    public int getItemCount() {
        return null!=data?data.size():0;

    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView, IAnasayfaDetaylari iOtobusSaatleriInterface) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (iOtobusSaatleriInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);
                        iOtobusSaatleriInterface.onItemClick(position);

                        Intent intent = new Intent(context,AnasayfaDetaylari.class);

                        intent.putExtra("name",data.get(position).getName());
                        intent.putExtra("detaylar",data.get(position).getDesig());
                        intent.putExtra("resim",data.get(position).getImage());



                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}