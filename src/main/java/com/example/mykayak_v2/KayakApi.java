package com.example.mykayak_v2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KayakApi {
    @GET("v3/0fe533ba-f79b-488a-aa4d-ea64407d182f/{name}")
    static Call<KayakResponse> getKayak(@Path("name") String name) {
        return null;
    }
}
