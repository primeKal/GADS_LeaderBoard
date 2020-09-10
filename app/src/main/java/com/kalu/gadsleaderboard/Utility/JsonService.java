package com.kalu.gadsleaderboard.Utility;

import com.kalu.gadsleaderboard.Models.Project;
import com.kalu.gadsleaderboard.Models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonService {

    @GET("hours")
    Call<List<Users>> getUsers();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Project> setProject(@Field("entry.1877115667") String name,
                             @Field("entry.1824927963") String email,
                             @Field("entry.2006916086") String lastname,
                             @Field("entry.284483984") String githublink);
}
