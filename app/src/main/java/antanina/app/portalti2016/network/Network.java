package antanina.app.portalti2016.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    public static Retrofit request() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
     return new Retrofit.Builder()
             .baseUrl("http://35.186.145.167:1337/")
             .client(client)
             .addConverterFactory(GsonConverterFactory.create())
             .build();
    }
}

