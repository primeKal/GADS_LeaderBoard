package com.kalu.gadsleaderboard.Utility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String url="https://docs.google.com/forms/d/e/";
    private static  Retrofit.Builder retrofitbuilder=new Retrofit.Builder().
                 baseUrl(url).
                 addConverterFactory(GsonConverterFactory.create());
    private static Retrofit kRetrofit=retrofitbuilder.build();
    public static <s> s buildservice(Class<s> serviceType){
        return kRetrofit.create(serviceType);
    }

}
