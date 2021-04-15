package in.sunil.mvvmpracticesbysunil.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;

import in.sunil.mvvmpracticesbysunil.MainActivity;
import in.sunil.mvvmpracticesbysunil.R;
import in.sunil.mvvmpracticesbysunil.models.LoginResponseBean;
import in.sunil.mvvmpracticesbysunil.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText et_Username;
    private TextInputEditText et_Password;
    private Button btn_SignIn;
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        et_Username = (TextInputEditText) findViewById(R.id.et_UserName);
        et_Password = (TextInputEditText) findViewById(R.id.et_Password);
        btn_SignIn = (Button) findViewById(R.id.btn_SignIn);

        et_Username.setText("9951424167");
        et_Password.setText("admin@123");

        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mLoginViewModel.init();

        mLoginViewModel.getLoginResponseLiveData().observe(this, new Observer<LoginResponseBean>() {
            @Override
            public void onChanged(@Nullable LoginResponseBean loginResponseBean) {
                if (loginResponseBean != null) {
                    Toast.makeText(LoginActivity.this, "" + loginResponseBean.awcName, Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });

        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_Username.getEditableText().toString();
                String password = et_Password.getEditableText().toString();

                loginUser(userName, password);
            }
        });

    }

    private void loginUser(String userName, String password) {
        mLoginViewModel.preformLogin(userName, password);
    }


}
