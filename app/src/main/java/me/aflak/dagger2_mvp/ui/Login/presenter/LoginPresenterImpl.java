package me.aflak.dagger2_mvp.ui.Login.presenter;

import android.util.Log;

import me.aflak.dagger2_mvp.data.model.ObjectManager;
import me.aflak.dagger2_mvp.data.model.User;
import me.aflak.dagger2_mvp.ui.Login.model.LoginInteractor;
import me.aflak.dagger2_mvp.ui.Login.model.LoginInteractorImpl;
import me.aflak.dagger2_mvp.ui.Login.view.LoginView;

/**
 * Created by Omar on 16/02/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.LoginCallback {
    private final LoginView view;
    private LoginInteractor interactor;
    private ObjectManager objectManager;

    public LoginPresenterImpl(LoginView view, ObjectManager objectManager) {
        this.view = view;
        this.objectManager = objectManager;
        this.interactor = new LoginInteractorImpl();
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
        interactor.saveUser(user, objectManager);

        if(view != null){
            view.navigateToHome();
        }
    }
}
