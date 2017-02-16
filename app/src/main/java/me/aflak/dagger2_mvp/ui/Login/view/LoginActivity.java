package me.aflak.dagger2_mvp.ui.Login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.aflak.dagger2_mvp.R;
import me.aflak.dagger2_mvp.data.module.AppModule;
import me.aflak.dagger2_mvp.ui.Login.data.DaggerLoginComponent;
import me.aflak.dagger2_mvp.ui.Login.data.LoginModule;
import me.aflak.dagger2_mvp.ui.Login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.activity_login_username) EditText username;
    @BindView(R.id.activity_login_password) EditText password;
    @BindView(R.id.activity_login_progress) ProgressBar progressBar;

    @Inject LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .loginModule(new LoginModule(this))
                .build().inject(this);

    }

    @OnClick(R.id.activity_login_connect)
    public void connect(){
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError(String error) {
        username.setError(error);
    }

    @Override
    public void setPasswordError(String error) {
        password.setError(error);
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}