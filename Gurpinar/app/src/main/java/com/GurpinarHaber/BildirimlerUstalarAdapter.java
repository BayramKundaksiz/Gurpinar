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

public class BildirimlerUstalarAdapter extends RecyclerView.Adapter<BildirimlerUstalarAdapter.myviewholder>
{

    List<BildirimlerUstalarConstructor> ustaBilgileri;

    private final IUstaDetaylari iUstaDetaylari;

    Context context;

    public BildirimlerUstalarAdapter(List<BildirimlerUstalarConstructor> ustaBilgileri, IUstaDetaylari iUstaDetaylari, Context context) {
        this.ustaBilgileri = ustaBilgileri;
        this.iUstaDetaylari = iUstaDetaylari;
        this.context = context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ustadetaylari,parent,false);
        return new myviewholder(view,iUstaDetaylari);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(ustaBilgileri.get(position).getUstaismi());
        holder.t2.setText(ustaBilgileri.get(position).getUstabilgisi());
        Glide.with(holder.t1.getContext())
                .load("http://gilaburu.site/Gurpinar/bildirimler/ustalar/" +ustaBilgileri.get(position).getUstaninfotografi()).into(holder.img);



    }

    @Override
    public int getItemCount() {
        return null!=ustaBilgileri?ustaBilgileri.size():0;

    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView, IUstaDetaylari iUstaDetaylari) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (iUstaDetaylari != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);
                        iUstaDetaylari.onItemClick(position);

                        Intent intent = new Intent(context,BildirimlerUstaDetaylari.class);

                        intent.putExtra("ustaAdi",ustaBilgileri.get(position).getUstaismi());
                        intent.putExtra("ustaAlani",ustaBilgileri.get(position).getUstabilgisi());
                        intent.putExtra("ustaninGorseli",ustaBilgileri.get(position).getUstaninfotografi());

                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}