package examples.aaronhoskins.com.networkcalls.model.datasource.remote;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpExample {
    public void getAsyncResponse() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient returnClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        Request request = new Request.Builder().url("https://randomuser.me/api/?results=50&gender=female").build();
        returnClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                RandomMeResponse randomMeResponse =
                        gson.fromJson(response.body().string(), RandomMeResponse.class);
                EventBus.getDefault().post(randomMeResponse);
                //Log.d("TAG", response.body().string());
            }
        });
    }

    public void getSyncResponse(){
        OkHttpClient returnClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://randomuser.me/api/?results=5").build();

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                    Response response = returnClient.newCall(request).execute();
                    Log.d("TAG", response.body().string());
                    } catch (Exception e) {

                    }
                }
            });
           thread.start();

    }
}
