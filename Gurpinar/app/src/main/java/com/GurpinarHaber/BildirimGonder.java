package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class BildirimGonder extends AppCompatActivity {

    ImageView imageViewDuyuruGorseli;
    TextView bildirimBasligi, bildirimAciklamasi;
    private String strJson, apiUrl = "http://gilaburu.site/Gurpinar/bildirimGetir.php";

    private OkHttpClient client;
    private Response response;
    private RequestBody requestBody;
    private Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirim_gonder);

        imageViewDuyuruGorseli = findViewById(R.id.imageViewDuyuruGorseli);
        bildirimBasligi = findViewById(R.id.bildirimBasligi);
        bildirimAciklamasi = findViewById(R.id.bildirimAciklamasi);

        client = new OkHttpClient();
        new GetUserDataRequest().execute();

    }
    public class GetUserDataRequest extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            request = new Request.Builder().url(apiUrl).build();
            try {
                response = client.newCall(request).execute();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            try {
                strJson = response.body().string();
                updateUserData(strJson);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void updateUserData(String strJson) {
        try {
            JSONArray parent = new JSONArray(strJson);
            JSONObject child =parent.getJSONObject(0);

            String imgUrl =child.getString("haber_fotografi");
            String haberFotografi =child.getString("haber_basligi");
            String haberIcerigi =child.getString("haber_icerigi");
            Glide.with(this).load(imgUrl).into(imageViewDuyuruGorseli);

            bildirimBasligi.setText(haberFotografi);
            bildirimAciklamasi.setText(haberIcerigi);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent geriGit = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(geriGit);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onUserLeaveHint() {
        finish();
        super.onUserLeaveHint();
    }

}