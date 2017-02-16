package me.aflak.dagger2_mvp.ui.Login.data;

import javax.inject.Singleton;

import dagger.Component;
import me.aflak.dagger2_mvp.data.module.AppModule;
import me.aflak.dagger2_mvp.ui.Login.view.LoginActivity;

/**
 * Created by Omar on 16/02/2017.
 */
@Singleton
@Component (modules = {LoginModule.class, AppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
