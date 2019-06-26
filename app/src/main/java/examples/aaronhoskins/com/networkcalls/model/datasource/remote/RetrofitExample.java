package examples.aaronhoskins.com.networkcalls.model.datasource.remote;

import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RetrofitExample {
    public static final String BASE_URL = "https://randomuser.me/";
    public static final String PATH = "api/";
    public static final String QUERY_RESULT_AMOUNT = "results";
    public static final String QUERY_GENDER = "gender";
    public Retrofit getRetrofitInstance() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RandomMeApiService getService() {
        return getRetrofitInstance().create(RandomMeApiService.class);
    }

    public interface RandomMeApiService{
        @GET(PATH)
        Call<RandomMeResponse> getRandomMeResponce(@Query(QUERY_RESULT_AMOUNT)String numOfUsers,
                                                   @Query(QUERY_GENDER) String gender);

        @GET("{id}/")
        Call<RandomMeResponse> getRandomMeResponce(
                @Path("id") String id,
                @Query(QUERY_RESULT_AMOUNT)String numOfUsers,
                @Query(QUERY_GENDER) String gender);
    }
}
