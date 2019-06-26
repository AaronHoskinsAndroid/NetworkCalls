package examples.aaronhoskins.com.networkcalls.model.datasource.remote.rxjava;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RandomMeRepository {

    public void getRandomUsers(Callback callback) {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper
                .getRandomUserService()
                .getRandomMeResponce("5", "female")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RandomUserObserver(callback));
    }
}
