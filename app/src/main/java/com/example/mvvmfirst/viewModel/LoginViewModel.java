package com.example.mvvmfirst.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.example.mvvmfirst.Interface.LoginCallBack;
import com.example.mvvmfirst.Model.User;

public class LoginViewModel extends ViewModel {

    private User user;
    private LoginCallBack loginCallBack;

    public LoginViewModel(LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
        this.user = new User();
    }

    //Edittext ten email i alıp User'a bu emaili set ediyoruz.
    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    //Edittext ten password i alıp User'a bu sifresine set ediyoruz.
    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    //Login işlemi
    public void onLoginClicked(View view){

        int errorCode = user.isValidData();

        if (errorCode==0)
            loginCallBack.onError("Email adresi girmelisiniz");
        else if (errorCode == 1)
            loginCallBack.onError("Geçersiz mail adresi");
        else if (errorCode == 2)
            loginCallBack.onError("Şifre girmelisiniz");
        else if (errorCode == 3)
            loginCallBack.onError("Şifre en az 8 karakter olmalı");
        else
            loginCallBack.onError("Login Başarılı");

    }




}
