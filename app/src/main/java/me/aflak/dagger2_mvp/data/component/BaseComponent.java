package me.aflak.dagger2_mvp.data.component;

import javax.inject.Singleton;

import dagger.Component;
import me.aflak.dagger2_mvp.data.module.AppModule;

/**
 * Created by Omar on 16/02/2017.
 */
@Singleton
@Component (modules = AppModule.class)
public interface BaseComponent {
    //void inject(AnotherActivity activity);
}
