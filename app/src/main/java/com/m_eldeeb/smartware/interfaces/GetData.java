package com.m_eldeeb.smartware.interfaces;



import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by melde on 6/12/2017.
 */

public interface GetData {
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(
            @Field("name") String name,

            @Field("email") String email,
            @Field("phone") String phone,
            @Field("course") String course,
            @Field("faculty") String faculity,
            @Field("grade") String grade

            )
            ;

    @FormUrlEncoded
    @POST("contact")
    Call<ResponseBody> contact(
            @Field(" name") String name,

            @Field(" email") String email,
            @Field(" subject") String subject,
            @Field(" message") String message

    )
            ;


}
