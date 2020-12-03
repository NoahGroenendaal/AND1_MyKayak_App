package com.example.mykayak_v2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KayakRepository {

    private static KayakRepository instance;
    private MutableLiveData<ApiKayak> apikayak;

    private KayakRepository(){
        apikayak = new MutableLiveData<>();
    }

    public static synchronized KayakRepository getInstance(){
        if (instance == null){
            instance = new KayakRepository();
        }
        return instance;
    }

    public LiveData<ApiKayak> getKayak(){
        return apikayak;
    }

    public void updateKayak(String kayakName){
        KayakApi kayakApi = ServiceGenerator.getKayakApi();
        Call<KayakResponse> call = KayakApi.getKayak(kayakName);
        call.enqueue(new Callback<KayakResponse>() {
            @Override
            public void onResponse(Call<KayakResponse> call, Response<KayakResponse> response) {
                if (response.code() == 200){
                    apikayak.setValue(response.body().getKayak());
                }
            }

            @Override
            public void onFailure(Call<KayakResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");

            }
        });
    }
}
