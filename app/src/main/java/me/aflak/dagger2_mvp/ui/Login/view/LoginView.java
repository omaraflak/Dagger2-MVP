package me.aflak.dagger2_mvp.ui.Login.view;

/**
 * Created by Omar on 16/02/2017.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError(String error);
    void setPasswordError(String error);
    void navigateToHome();
}
