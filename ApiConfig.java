package retrofit;

import android.util.Log;

import androidx.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    @NonNull
    public static ApiService getApiService() {
        // Membuat interceptor untuk logging
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        // Membuat OkHttpClient dengan interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        // Membuat objek Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restaurant-api.dicoding.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        // Membuat objek ApiService dari Retrofit
        ApiService apiService = retrofit.create(ApiService.class);

        // Log untuk memeriksa apakah objek ApiService adalah null
        Log.d("ApiConfig", "ApiService: " + apiService);

        return apiService;
    }
}