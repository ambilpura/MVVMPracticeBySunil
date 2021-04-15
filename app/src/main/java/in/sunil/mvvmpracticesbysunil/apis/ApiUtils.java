package in.sunil.mvvmpracticesbysunil.apis;

public class ApiUtils {

    public static final String BASE_URL = "http://beulahsoftware.com/UDIDAPI/api/";

    public static MyApi getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(MyApi.class);
    }
}