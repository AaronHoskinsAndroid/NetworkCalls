package examples.aaronhoskins.com.networkcalls.model.datasource.remote.rxjava;

import examples.aaronhoskins.com.networkcalls.model.randomme.RandomMeResponse;

public interface Callback {
    void getRandomUserResponse(RandomMeResponse randomMeResponse);
}
