package com.GurpinarHaber;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;


public class BildirimlerFragment extends Fragment implements IUstaDetaylari, IBildirimlerAlimSatimInterface {

    RecyclerView recyclerViewBildirimlerUstalar, recyclerViewBildirimlerAlimSatim;
    View viewBildirimler;
    TextView textViewBildirimTanitim, textViewUstalar, textViewUrunler;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        viewBildirimler = inflater.inflate(R.layout.fragment_bildirimler, container, false);

        recyclerViewBildirimlerUstalar = viewBildirimler.findViewById(R.id.recyclerViewBildirimlerUstalar);
        recyclerViewBildirimlerAlimSatim = viewBildirimler.findViewById(R.id.recyclerViewBildirimlerAlimSatim);
        textViewBildirimTanitim = viewBildirimler.findViewById(R.id.textViewBildirimTanitim);
        textViewUrunler = viewBildirimler.findViewById(R.id.textViewUrunler);
        textViewUstalar = viewBildirimler.findViewById(R.id.textViewUstalar);
        recyclerViewBildirimlerUstalar.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerViewBildirimlerAlimSatim.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "asdasd");

        sequence.setConfig(config);

        sequence.addSequenceItem(textViewUstalar,
                "Burada köyümüzde bulunan ustaların bilgisi görüntülenecek olup şehir içi ve şehir dışı işlerde önceliğin bizim köyümüzdeki ustalara verilmesi sağlanacaktır"
                        , "Geçmek için bu yazıyı tıklayınız");

        sequence.addSequenceItem(textViewBildirimTanitim,
                "Burada ise sizler tarafından ücretli/ücretsiz eşya, malzeme, " +
                        "ürün vs alım satımı yapılacaktır. (Süt, gilaburu, ders kitapları, hikaye kitapları vs.)" +
                        "Ürün alım - satımı yapmak için iletişim kısmından ulaşabilirsiniz... ", "Geçmek için bu yazıyı tıklayınız");



        sequence.start();


        UstalariGetir();
        AlimSatimGetir();

        return viewBildirimler;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("İŞ - ALIM - SATIM");

    }

    public void UstalariGetir() {

        Call<List<BildirimlerUstalarConstructor>> call = BildirimlerUstalarController
                .getInstance()
                .getapi()
                .ustalariGetir();

        call.enqueue(new Callback<List<BildirimlerUstalarConstructor>>() {
            @Override
            public void onResponse(Call<List<BildirimlerUstalarConstructor>> call, Response<List<BildirimlerUstalarConstructor>> response) {
                List<BildirimlerUstalarConstructor> bildirimlerUstalarConstructors = response.body();

                BildirimlerUstalarAdapter adapter = new BildirimlerUstalarAdapter(bildirimlerUstalarConstructors,BildirimlerFragment.this::onItemClick,getContext());
                recyclerViewBildirimlerUstalar.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<BildirimlerUstalarConstructor>> call, Throwable t) {
                Toast.makeText(getContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void AlimSatimGetir() {

        Call<List<BildirimlerAlimSatimConstructor>> call = BildirimlerAlimSatimController
                .getInstance()
                .getapi()
                .alimSatimGetir();

        call.enqueue(new Callback<List<BildirimlerAlimSatimConstructor>>() {
            @Override
            public void onResponse(Call<List<BildirimlerAlimSatimConstructor>> call, Response<List<BildirimlerAlimSatimConstructor>> response) {
                List<BildirimlerAlimSatimConstructor> bildirimlerAlimSatimConstructors = response.body();

                BildirimlerAlimSatimAdapter adapter = new BildirimlerAlimSatimAdapter(bildirimlerAlimSatimConstructors,BildirimlerFragment.this::onItemClick,getContext());
                recyclerViewBildirimlerAlimSatim.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<BildirimlerAlimSatimConstructor>> call, Throwable t) {
                Toast.makeText(getContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();

            }
        });

    }





    @Override
    public void onItemClick(int position) {

    }
}