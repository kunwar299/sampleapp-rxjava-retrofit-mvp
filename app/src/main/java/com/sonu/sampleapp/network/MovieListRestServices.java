package com.sonu.sampleapp.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sonu.sampleapp.utils.Utils.BASE_URL;
import static com.sonu.sampleapp.utils.Utils.DEFAULT_CONNECT_TIMEOUT_IN_MS;
import static com.sonu.sampleapp.utils.Utils.DEFAULT_READ_TIMEOUT_IN_MS;
import static com.sonu.sampleapp.utils.Utils.DEFAULT_WRITE_TIMEOUT_IN_MS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class MovieListRestServices {
    private static Retrofit retrofit = null;
   public static Retrofit getData()
   {
       HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
       logging.setLevel(HttpLoggingInterceptor.Level.BODY);

       OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder()
               .connectTimeout(DEFAULT_CONNECT_TIMEOUT_IN_MS, MILLISECONDS)
               .writeTimeout(DEFAULT_WRITE_TIMEOUT_IN_MS, MILLISECONDS)
               .readTimeout(DEFAULT_READ_TIMEOUT_IN_MS, MILLISECONDS);
       oktHttpClient.addInterceptor(logging);
       oktHttpClient.addInterceptor(new Interceptor() {
           @Override
           public Response intercept(Chain chain) throws IOException {
               Request original = chain.request();
               Request request = original.newBuilder()
                       .method(original.method(), original.body())
                       .build();
               return chain.proceed(request);
           }
       });
       if (retrofit == null) {
           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .addConverterFactory(GsonConverterFactory.create())
                   .client(oktHttpClient.build())
                   .build();
       }
       return retrofit;
   }
}


