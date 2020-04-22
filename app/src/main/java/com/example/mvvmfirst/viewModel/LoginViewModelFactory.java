package com.example.mvvmfirst.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmfirst.Interface.LoginCallBack;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginCallBack loginCallBack;

    public LoginViewModelFactory(LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(loginCallBack);
    }


}
