package com.example.mykayak_v2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PyranhaViewModel extends ViewModel {

    KayakRepository repository;

    public PyranhaViewModel(){
        repository = KayakRepository.getInstance();
    }

    LiveData<ApiKayak> getKayak(){
        return repository.getKayak();
    }

    public void updateKayak(String s){
        repository.updateKayak(s);
    }

    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<String> apimessage = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    public LiveData<String> getMessage(){
        return message;
    }

    public LiveData<String> getApimessage(){
        return apimessage;
    }

    //the loading thing
    public LiveData<Boolean> isLoading(){

        return isLoading;
    }

    public void retrieveData(){
        isLoading.setValue(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                message.postValue("Just a message, but tried for many hours to get the API message in here. But I  just can't figure it out");
                //apimessage.postValue(apimess);
                isLoading.postValue(false);
            }
        } ,1000);
    }

    //This part is also an attempt of making the API work
    String apimess;

    //Retrofit and API
    public void requestKayak(final String kayakName){
        KayakApi kayakApi = ServiceGenerator.getKayakApi();
        Call<KayakResponse> call = KayakApi.getKayak(kayakName);
        call.enqueue(new Callback<KayakResponse>() {
            @Override
            public void onResponse(Call<KayakResponse> call, Response<KayakResponse> response) {
                if (response.code() == 200) {
                    apimessage.setValue(String.valueOf(response.body().getKayak())); //updating LiveData
                    apimess = apimessage.getValue();
                }
            }

            @Override
            public void onFailure(Call<KayakResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong : (");
            }
        });
    }
}
