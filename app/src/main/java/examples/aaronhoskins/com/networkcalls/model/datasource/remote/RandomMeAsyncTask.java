package examples.aaronhoskins.com.networkcalls.model.datasource.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;

public class RandomMeAsyncTask extends AsyncTask<Void, String, RandomMeResponse> {
    @Override
    protected RandomMeResponse doInBackground(Void... voids) {
        HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
        String responseFromRandomMe = httpUrlConnection.getJsonFromRandomUser();
        Log.d("TAG", responseFromRandomMe);
        Gson gson = new Gson();
        RandomMeResponse response = gson.fromJson(responseFromRandomMe, RandomMeResponse.class);
        return response;
    }

    @Override
    protected void onPostExecute(RandomMeResponse randomMeResponse) {
        super.onPostExecute(randomMeResponse);
        for(int i = 0; i < randomMeResponse.getResults().size() ; i++) {
            Log.d("TAG", randomMeResponse.getResults().get(i).getName().getFirst());
            Gson gson = new Gson();
            String nameJson = gson.toJson(randomMeResponse.getResults().get(i).getName());
            Log.d("TAG", nameJson);
        }
    }
}
