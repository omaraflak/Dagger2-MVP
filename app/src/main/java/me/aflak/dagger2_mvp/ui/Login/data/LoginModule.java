package me.aflak.dagger2_mvp.ui.Login.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.aflak.dagger2_mvp.data.model.ObjectManager;
import me.aflak.dagger2_mvp.ui.Login.interactor.LoginInteractor;
import me.aflak.dagger2_mvp.ui.Login.interactor.LoginInteractorImpl;
import me.aflak.dagger2_mvp.ui.Login.presenter.LoginPresenter;
import me.aflak.dagger2_mvp.ui.Login.presenter.LoginPresenterImpl;
import me.aflak.dagger2_mvp.ui.Login.view.LoginView;

/**
 * Created by Omar on 16/02/2017.
 */
@Module
public class LoginModule {
    private final LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Singleton
    @Provides
    public LoginView provideLoginView(){
        return view;
    }

    @Singleton
    @Provides
    public LoginPresenter provideLoginPresenter(LoginView loginView, ObjectManager objectManager){
        return new LoginPresenterImpl(loginView, objectManager);
    }
}
