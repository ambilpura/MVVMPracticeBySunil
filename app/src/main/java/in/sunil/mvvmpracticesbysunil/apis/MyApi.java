package in.sunil.mvvmpracticesbysunil.apis;

import in.sunil.mvvmpracticesbysunil.models.LoginResponseBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyApi {
    @FormUrlEncoded
    @POST("Users/Login")
    Call<LoginResponseBean> performLogin (@Field("mobileNumber") String mobileNumber, @Field("password") String password);
}
