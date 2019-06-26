package examples.aaronhoskins.com.networkcalls.model.datasource.remote.rxjava;

import examples.aaronhoskins.com.networkcalls.model.datasource.remote.RetrofitExample;
import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitHelper {
    public static final String BASE_URL = "https://randomuser.me/";
    public static final String PATH = "api/";
    public static final String QUERY_RESULT_AMOUNT = "results";
    public static final String QUERY_GENDER = "gender";

    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public RandomUserService getRandomUserService() {
        return getRetrofitInstance().create(RandomUserService.class);
    }


    interface RandomUserService {
        @GET(PATH)
        Observable<RandomMeResponse> getRandomMeResponce(@Query(QUERY_RESULT_AMOUNT)String numOfUsers,
                                                         @Query(QUERY_GENDER) String gender);
    }
}
