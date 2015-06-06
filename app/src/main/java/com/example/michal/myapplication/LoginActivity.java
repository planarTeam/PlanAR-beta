package com.example.michal.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.michal.myapplication.Data.EmailAndPassword;
import com.example.michal.myapplication.Data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Mariusz on 2015-05-25.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends ActionBarActivity {

    @Bean
    @NonConfigurationInstance
    RestLoginBackgroundTask restLoginBackgroundTask;

    @ViewById
    EditText email;

    @ViewById
    EditText password;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Logowanie...");
        ringProgressDialog.setIndeterminate(true);
    }

    @Click
    void loginClicked()    {
        ringProgressDialog.show();
        EmailAndPassword emailAndPassword = new EmailAndPassword();
        emailAndPassword.email = email.getText().toString(); //"stefan@test.pl";
        emailAndPassword.password = password.getText().toString(); //"test";
        restLoginBackgroundTask.login(emailAndPassword);
    }

    @Click(R.id.register)
    void registerClicked(){
        startActivity(new Intent(this, RegisterActivity_.class));
    }

    public void loginSuccess(User user) {
        ringProgressDialog.dismiss();
        DrawerActivity_.intent(this).user(user).start();
       // Toast.makeText(this, "Witaj ponownie " + email.getText(), Toast.LENGTH_LONG).show();
        finish();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

}