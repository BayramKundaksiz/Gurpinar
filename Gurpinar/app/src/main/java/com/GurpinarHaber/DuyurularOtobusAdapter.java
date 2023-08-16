package com.GurpinarHaber;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DuyurularOtobusAdapter extends RecyclerView.Adapter<DuyurularOtobusAdapter.myviewholder>
{

    List<DuyurularOtobusConstructor> duyurulariOtobusConstructors;

    private final IDuyurularOtobusSaatleri iDuyurularOtobusSaatleri;

    Context context;


    public DuyurularOtobusAdapter(List<DuyurularOtobusConstructor> duyurulariOtobusConstructors, IDuyurularOtobusSaatleri iDuyurularOtobusSaatleri, Context context) {
        this.duyurulariOtobusConstructors = duyurulariOtobusConstructors;
        this.iDuyurularOtobusSaatleri = iDuyurularOtobusSaatleri;
        this.context = context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.otobusduyuru,parent,false);
        return new myviewholder(view,iDuyurularOtobusSaatleri);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(duyurulariOtobusConstructors.get(position).getIsim());
        Glide.with(holder.t1.getContext()).load("http://gilaburu.site/Gurpinar/duyurular/OtobusSaatleri/" +duyurulariOtobusConstructors.get(position).getResim()).into(holder.img);


    }

    @Override
    public int getItemCount() {

        return null!=duyurulariOtobusConstructors?duyurulariOtobusConstructors.size():0;

    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView, IDuyurularOtobusSaatleri iDuyurularOtobusSaatleri) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (iDuyurularOtobusSaatleri != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);
                        iDuyurularOtobusSaatleri.onItemClick(position);

                        Intent intent = new Intent(context,OtobusDetaylari.class);

                        intent.putExtra("isim",duyurulariOtobusConstructors.get(position).getIsim());

                        intent.putExtra("otobus",duyurulariOtobusConstructors.get(position).getResim());



                        context.startActivity(intent);
                    }
                }
            });


        }
    }


}