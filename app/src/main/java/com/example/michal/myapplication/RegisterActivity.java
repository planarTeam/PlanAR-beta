package com.example.michal.myapplication;


import android.app.ProgressDialog;
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
@EActivity(R.layout.activity_register)
public class RegisterActivity extends ActionBarActivity {


    @ViewById
    EditText name;
    @ViewById
    EditText last_name;
    @ViewById
    EditText email;
    @ViewById
    EditText password;
    @Bean
    @NonConfigurationInstance
    RestRegisterBackgroundTask restRegisterBackgroundTask;

    ProgressDialog ringProgressDialog;

    @Click(R.id.button_register)
    void registerButtonClicked(){
        ringProgressDialog.show();
        EmailAndPassword emailAndPassword= new EmailAndPassword();
        emailAndPassword.email = email.getText().toString();
        emailAndPassword.name = name.getText().toString();
        emailAndPassword.last_name=last_name.getText().toString();
        emailAndPassword.password=password.getText().toString();
        restRegisterBackgroundTask.register(emailAndPassword);

    }
    @AfterViews
    void init () {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("trwa rejestracja");
        ringProgressDialog.setIndeterminate(true);

    }
    public void registerSuccess(User user){
        ringProgressDialog.dismiss();
        DrawerActivity_.intent(this).extra("User",user).start();
        //Toast.makeText(this, "Witaj " + name.getText(), Toast.LENGTH_LONG).show();
        finish();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
