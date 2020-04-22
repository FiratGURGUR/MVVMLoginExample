package com.example.mvvmfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmfirst.Interface.LoginCallBack;
import com.example.mvvmfirst.databinding.ActivityMainBinding;
import com.example.mvvmfirst.viewModel.LoginViewModel;
import com.example.mvvmfirst.viewModel.LoginViewModelFactory;

public class MainActivity extends AppCompatActivity implements LoginCallBack {
    //MVVM Data Binding
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(
                this,new LoginViewModelFactory(this))
                .get(LoginViewModel.class)
        );

    }

    @Override
    public void onSucces(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
