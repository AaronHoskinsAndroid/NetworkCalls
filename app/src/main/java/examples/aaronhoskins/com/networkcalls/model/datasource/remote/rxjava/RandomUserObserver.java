package examples.aaronhoskins.com.networkcalls.model.datasource.remote.rxjava;

import android.util.Log;

import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RandomUserObserver implements Observer<RandomMeResponse> {
    public final String TAG = this.getClass().getSimpleName();
    Callback callback;
    RandomMeResponse randomMeResponse;
    public RandomUserObserver(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(RandomMeResponse randomMeResponse) {
        this.randomMeResponse = randomMeResponse;
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: ", e);
    }

    @Override
    public void onComplete() {
        callback.getRandomUserResponse(randomMeResponse);
    }
}
