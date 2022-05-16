package com.example.de_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.de_api.network.ApiHandler;
import com.example.de_api.network.Mobile.MobilePost.MobilePostBody;
import com.example.de_api.network.Mobile.MobilePost.MobilePostResponce;
import com.example.de_api.network.SmartHome.RegisterMain.RegisterMainResponce;
import com.example.de_api.network.SmartHome.RegisterMainGet.RegisterMainGetResponce;
import com.example.de_api.network.service.ApiService;
import com.google.common.hash.Hashing;

import org.checkerframework.checker.units.qual.C;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiService service = ApiHandler.getInstance().getService();
    String s = "Competitor-3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin();
       // String str = "";
        //MessageDigest dig = MessageDigest.getInstance("SHA-256");
        //byte[] st1 = dig.digest(str.getBytes();
    }
    private void doMob(){
        AsyncTask.execute(()->{
            service.doMobilePostResponce(getMobileData()).enqueue(new Callback<MobilePostResponce>() {
                @Override
                public void onResponse(Call<MobilePostResponce> call, Response<MobilePostResponce> response) {

                }

                @Override
                public void onFailure(Call<MobilePostResponce> call, Throwable t) {

                }
            });
        });
    }
    private MobilePostBody getMobileData(){
        return new MobilePostBody("2", "2", "2");
    }

    private void doSUS(){
        AsyncTask.execute(()->{
            service.doResponceGet(s).enqueue(new Callback<List<RegisterMainGetResponce>>() {
                @Override
                public void onResponse(Call<List<RegisterMainGetResponce>> call, Response<List<RegisterMainGetResponce>> response) {
                    response.body().get(0).getAppId();
                }

                @Override
                public void onFailure(Call<List<RegisterMainGetResponce>> call, Throwable t) {

                }
            });
        });
    }

    private void doLogin(){
        AsyncTask.execute(()->{
            service.doResponce().enqueue(new Callback<RegisterMainResponce>() {
                @Override
                public void onResponse(Call<RegisterMainResponce> call, Response<RegisterMainResponce> response) {
                    if (response.isSuccessful()){
                        response.body().getAppId();
                    }
                }

                @Override
                public void onFailure(Call<RegisterMainResponce> call, Throwable t) {

                }
            });
        });
    }
}
