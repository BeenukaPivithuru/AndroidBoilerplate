package com.nisala.androidboilerplate.data.remote;

import com.nisala.androidboilerplate.data.model.request.LoginRequest;
import com.nisala.androidboilerplate.data.model.response.LoginResponse;
import com.nisala.androidboilerplate.util.AndroidBoilerplateConstant;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by nisala on 12,October,2018
 */
public interface ApiService {
    int TIME_OUT_DURATION = 10;
    String ENDPOINT = "http://dunnmetal.sandbox6.elegant-media.com/api/v1/";

    @POST("auth/login")
    Observable<LoginResponse> loginUser(@Header(AndroidBoilerplateConstant.HEADER_PARA_API_KEY) String apikey, @Body LoginRequest loginUserRequest);

    class Creator {

        public static ApiService newApiService() {
            // Add the interceptor to OkHttpClient
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);// TODO: 16/02/2018 in the production level change to LEVEL.NONE

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor);

            OkHttpClient client = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            return retrofit.create(ApiService.class);
        }
    }
}
