package examples.aaronhoskins.com.networkcalls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import examples.aaronhoskins.com.networkcalls.model.datasource.remote.OkHttpExample;
import examples.aaronhoskins.com.networkcalls.model.datasource.remote.RetrofitExample;
import examples.aaronhoskins.com.networkcalls.model.datasource.remote.rxjava.Callback;
import examples.aaronhoskins.com.networkcalls.model.datasource.remote.rxjava.RandomMeRepository;
import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback {
    RecyclerView rvRandomUserRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRandomUserRecyclerView = findViewById(R.id.rvRandomMeList);
        RandomMeRepository randomMeRepository = new RandomMeRepository();
        randomMeRepository.getRandomUsers(this);
//        RandomMeAsyncTask randomMeAsyncTask = new RandomMeAsyncTask();
//        randomMeAsyncTask.execute();
//        OkHttpExample okHttpExample = new OkHttpExample();
//        okHttpExample.getAsyncResponse();
//        okHttpExample.getSyncResponse();

//        RetrofitExample retrofitExample = new RetrofitExample();
//        retrofitExample.getService().getRandomMeResponce("api", "5", "female" ).enqueue(new Callback<RandomMeResponse>() {
//            @Override
//            public void onResponse(Call<RandomMeResponse> call, Response<RandomMeResponse> response) {
//                RandomMeResponse randomMeResponse = response.body();
//                Log.d("TAG", randomMeResponse.getResults().get(0).getName().getFirst());
//            }
//
//            @Override
//            public void onFailure(Call<RandomMeResponse> call, Throwable t) {
//                Log.d("TAG", t.getMessage());
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        //EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //EventBus.getDefault().unregister(this);
    }

    private void populateRandomRecyclerView(RandomMeResponse randomMeResponse) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RandomMeRVAdapter adapter = new RandomMeRVAdapter(randomMeResponse.getResults());
        rvRandomUserRecyclerView.setLayoutManager(layoutManager);
        rvRandomUserRecyclerView.setAdapter(adapter);
    }

    @Override
    public void getRandomUserResponse(RandomMeResponse randomMeResponse) {
        populateRandomRecyclerView(randomMeResponse);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void randomUserEvent(RandomMeResponse event) {
//        populateRandomRecyclerView(event);
//    }
}
