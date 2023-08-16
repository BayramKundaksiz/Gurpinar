package com.GurpinarHaber;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;


public class AnasayfaFragment extends Fragment implements IAnasayfaDetaylari {


    RecyclerView recyclerView;
    View v;
    TextView textViewTanitim, textViewMesajHakkında;
    SwipeRefreshLayout swipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_anasayfa, container, false);

        recyclerView = v.findViewById(R.id.recyclerView);
        textViewTanitim = v.findViewById(R.id.textViewTanitim);
        textViewMesajHakkında = v.findViewById(R.id.textViewMesajHakkında);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        processData();

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(50);

        /*swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           processData();

                       }
                   }
        );*/


        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "543543");

        sequence.setConfig(config);

        sequence.addSequenceItem(textViewTanitim,
                "Burası anasayfadır, genel haberler burada gösterilir. \n\nDetayları görmek için görselleri tıklamanız yeterlidir", "Geçmek için bu yazıyı tıklayınız");

        sequence.addSequenceItem(textViewMesajHakkında,
                "İletişim yazısından bana ulaşabileceğiniz adresler mevcuttur", "Geçmek için bu yazıyı tıklayınız");

        sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
                    @Override
                    public void onDismiss(MaterialShowcaseView itemView, int position) {
                        Toast.makeText(getActivity(), "Lütfen aşağıdaki duyurular yazısına tıklayın", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        sequence.start();



    return v;

    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("ANASAYFA");

    }

    public void processData() {

        Call<List<ResponseModel>> call = ApiController
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                List<ResponseModel> data = response.body();

                MyAdapter adapter = new MyAdapter(data,AnasayfaFragment.this::onItemClick,getContext());
                recyclerView.setAdapter(adapter);
                //swipe.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

                Toast.makeText(getContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();
                //swipe.setRefreshing(false);
            }
        });

    }


    @Override
    public void onItemClick(int position) {


    }

    /*@Override
    public void onRefresh() {
       processData();
    }*/
}