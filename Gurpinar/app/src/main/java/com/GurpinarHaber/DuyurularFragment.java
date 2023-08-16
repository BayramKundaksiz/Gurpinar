package com.GurpinarHaber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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


public class DuyurularFragment extends Fragment implements IDuyurularOtobusSaatleri, IDuyurularOnemliGunDetaylar {

    RecyclerView recyclerViewOtobus,recyclerViewOnemliGunler;
    View duyurularFragment;
    TextView duyurularFragmentShowcase,duyurularFragmentShowcase2,textViewOtobus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        duyurularFragment = inflater.inflate(R.layout.fragment_duyurular, container, false);
        duyurularFragmentShowcase = duyurularFragment.findViewById(R.id.duyurularFragmentShowcase);
        duyurularFragmentShowcase2 = duyurularFragment.findViewById(R.id.duyurularFragmentShowcase2);
        textViewOtobus = duyurularFragment.findViewById(R.id.textViewOtobus);

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(50); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "dfgdfg");

        sequence.setConfig(config);

        sequence.addSequenceItem(duyurularFragmentShowcase2,
                "Burası duyuruların bulunduğu yerdir, duyurulmasını istediğiniz konular burada paylaşılır\n" +
                        "\n(Düğün, sünnet, mevlit, cenaze vs.)\n" +
                        "\nDetayları görmek için görselleri tıklamanız yeterlidir", "Geçmek için bu yazıyı tıklayınız");

        sequence.addSequenceItem(textViewOtobus,
                "Güncel otobüs saatleri burada mevcuttur. Büyütmek için tıklayabilirsiniz", "Geçmek için bu yazıyı tıklayınız");

        sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
                    @Override
                    public void onDismiss(MaterialShowcaseView itemView, int position) {
                        Toast.makeText(getActivity(), "Lütfen aşağıdaki iş-alım-satım yazısına tıklayın", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


        sequence.start();





            recyclerViewOtobus = duyurularFragment.findViewById(R.id.recyclerViewOtobus);

        recyclerViewOnemliGunler = duyurularFragment.findViewById(R.id.recyclerViewOnemliGunler);

        recyclerViewOnemliGunler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        recyclerViewOtobus.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));






        onemliGunDuyurulari();

        otobusBilgileriniAl();

        return duyurularFragment;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("DUYURULAR");

    }



    public void onemliGunDuyurulari() {

        Call<List<DuyurularOnemliGunConstructor>> call = DuyurularOnemliGunController
                .getInstance()
                .getapi().duyurularOnemliGunGetir();

        call.enqueue(new Callback<List<DuyurularOnemliGunConstructor>>() {
            @Override
            public void onResponse(Call<List<DuyurularOnemliGunConstructor>> call, Response<List<DuyurularOnemliGunConstructor>> response) {
                List<DuyurularOnemliGunConstructor> onemliGunDuyuru = response.body();
                DuyurularOnemliGunAdapter onemliGunAdapter = new DuyurularOnemliGunAdapter(onemliGunDuyuru,DuyurularFragment.this::onItemClick,getContext());
                recyclerViewOnemliGunler.setAdapter(onemliGunAdapter);

            }

            @Override
            public void onFailure(Call<List<DuyurularOnemliGunConstructor>> call, Throwable t) {
                Toast.makeText(getContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();

            }
        });
    }


    public void otobusBilgileriniAl() {

        Call<List<DuyurularOtobusConstructor>> call = DuyurularOtobusController
                .getInstance()
                .getapi().duyurularOtobus();

        call.enqueue(new Callback<List<DuyurularOtobusConstructor>>() {
            @Override
            public void onResponse(Call<List<DuyurularOtobusConstructor>> call, Response<List<DuyurularOtobusConstructor>> response) {
                List<DuyurularOtobusConstructor> duyuruOtobus = response.body();
                DuyurularOtobusAdapter duyuruAdapter = new DuyurularOtobusAdapter(duyuruOtobus,DuyurularFragment.this::onItemClick,getContext());
                recyclerViewOtobus.setAdapter(duyuruAdapter);

            }

            @Override
            public void onFailure(Call<List<DuyurularOtobusConstructor>> call, Throwable t) {
                Toast.makeText(getContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public void onItemClick(int position) {

    }


}