package in.sunil.mvvmpracticesbysunil.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import in.sunil.mvvmpracticesbysunil.models.LoginResponseBean;
import in.sunil.mvvmpracticesbysunil.repositories.LoginRepository;

public class LoginViewModel extends AndroidViewModel {

    private LoginRepository mLoginRepository;
    private LiveData<LoginResponseBean> loginResponseBeanLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        mLoginRepository = new LoginRepository();
        loginResponseBeanLiveData = mLoginRepository.getLoginResponseLiveData();
    }

    public void preformLogin(String username, String password) {
        mLoginRepository.performLogin(username, password);

    }

    public LiveData<LoginResponseBean> getLoginResponseLiveData() {
        return loginResponseBeanLiveData;
    }
}
