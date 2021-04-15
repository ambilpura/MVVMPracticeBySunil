package in.sunil.mvvmpracticesbysunil.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import in.sunil.mvvmpracticesbysunil.apis.ApiUtils;
import in.sunil.mvvmpracticesbysunil.apis.MyApi;
import in.sunil.mvvmpracticesbysunil.models.LoginResponseBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private static final String BASE_URL = "http://beulahsoftware.com/UDIDAPI/api/";

    private MyApi myApi;
    private MutableLiveData<LoginResponseBean> loginResponseBeanLiveData;


    public void performLogin(String userName, String password) {
        loginResponseBeanLiveData = new MutableLiveData<>();

        myApi = ApiUtils.getUserService();

        Call call = myApi.performLogin(userName, password);
        call.enqueue(new Callback<LoginResponseBean>() {

            @Override
            public void onResponse(Call<LoginResponseBean> call, Response<LoginResponseBean> response) {

                if (response.isSuccessful()) {
                    loginResponseBeanLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponseBean> call, Throwable t) {
                loginResponseBeanLiveData.postValue(null);
            }
        });


    }

    public LiveData<LoginResponseBean> getLoginResponseLiveData() {
        return loginResponseBeanLiveData;
    }
}
