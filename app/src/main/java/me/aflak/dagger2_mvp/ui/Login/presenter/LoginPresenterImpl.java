package me.aflak.dagger2_mvp.ui.Login.presenter;

import me.aflak.dagger2_mvp.entity.User;
import me.aflak.dagger2_mvp.ui.Login.interactor.LoginInteractor;
import me.aflak.dagger2_mvp.ui.Login.view.LoginView;

/**
 * Created by Omar on 16/02/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.LoginCallback {
    private final LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view, LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void login(String username, String password) {
        if(view != null){
            view.showProgress();
        }
        interactor.login(username, password, this);
    }

    @Override
    public void onUsernameError(String error) {
        if(view != null){
            view.hideProgress();
            view.setUsernameError(error);
        }
    }

    @Override
    public void onPasswordError(String error) {
        if(view != null){
            view.hideProgress();
            view.setPasswordError(error);
        }
    }

    @Override
    public void onSuccess(User user) {
        interactor.saveUser(user);

        if(view != null){
            view.navigateToHome();
        }
    }
}
