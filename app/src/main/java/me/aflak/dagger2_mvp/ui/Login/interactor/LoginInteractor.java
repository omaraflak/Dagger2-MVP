package me.aflak.dagger2_mvp.ui.Login.interactor;

import me.aflak.dagger2_mvp.data.model.ObjectManager;
import me.aflak.dagger2_mvp.data.model.User;

/**
 * Created by Omar on 16/02/2017.
 */

public interface LoginInteractor {
    interface LoginCallback {
        void onUsernameError(String error);
        void onPasswordError(String error);
        void onSuccess(User user);
    }

    void login(String username, String password, LoginCallback callback);
    void saveUser(User user, ObjectManager objectManager);
}
