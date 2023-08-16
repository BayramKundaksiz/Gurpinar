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

public class DuyurularOnemliGunAdapter extends RecyclerView.Adapter<DuyurularOnemliGunAdapter.myviewholder>
{

    List<DuyurularOnemliGunConstructor> duyurularOnemliGunConstructors;

    private final IDuyurularOnemliGunDetaylar iDuyurularOnemliGunDetaylar;

    Context context;

    public DuyurularOnemliGunAdapter(List<DuyurularOnemliGunConstructor> duyurularOnemliGunConstructors,
                                     IDuyurularOnemliGunDetaylar iDuyurularOnemliGunDetaylar,
    Context context) {
        this.duyurularOnemliGunConstructors = duyurularOnemliGunConstructors;
        this.iDuyurularOnemliGunDetaylar = iDuyurularOnemliGunDetaylar;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                                                                    // şimdi şöyle anlatıyım
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.onemligunler,parent,false);
        return new myviewholder(view,iDuyurularOnemliGunDetaylar);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(duyurularOnemliGunConstructors.get(position).getDuyuru_adi());
        holder.t2.setText(duyurularOnemliGunConstructors.get(position).getDuyuru_iletisim());
        Glide.with(holder.t1.getContext()).load("http://gilaburu.site/Gurpinar/duyurular/OnemliGunler/" +duyurularOnemliGunConstructors.get(position).getDuyuru_fotografi()).into(holder.img);

    }

    @Override
    public int getItemCount() {

        return null!=duyurularOnemliGunConstructors?duyurularOnemliGunConstructors.size():0;

    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView, IDuyurularOnemliGunDetaylar iDuyurularOnemliGunDetaylar) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (iDuyurularOnemliGunDetaylar != null){

                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);
                        iDuyurularOnemliGunDetaylar.onItemClick(position);
                        Intent intent = new Intent(context,OnemliGunDuyuruDetaylari.class);

                        intent.putExtra("duyuruadi",duyurularOnemliGunConstructors.get(position).getDuyuru_adi());
                        intent.putExtra("duyuruiletisim",duyurularOnemliGunConstructors.get(position).getDuyuru_iletisim());
                        intent.putExtra("duyuruResmi",duyurularOnemliGunConstructors.get(position).getDuyuru_fotografi());

                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}