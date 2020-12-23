package co.edu.ufps.domicilios_app.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constant {
    static final String URL_BACKEND = "http://192.168.1.1:8080/";

    public static Retrofit getRetrofit () {
        return new Retrofit.Builder().baseUrl(URL_BACKEND)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
