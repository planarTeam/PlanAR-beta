package com.example.michal.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.Data.User;
import com.example.michal.myapplication.Data.Wydarzenie;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Damian Kisielewski
 */
@EActivity(R.layout.activity_addcom)
public class AddComentActivity extends ActionBarActivity {

    @Extra
    User user;

    @Extra
    Wydarzenie wydarzenie;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;

    @ViewById
    EditText comment;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Logowanie...");
        ringProgressDialog.setIndeterminate(true);
    }

    @Click
    void dodajClicked()    {
        ringProgressDialog.show();
        KomentarzWydarzenie komentarzWydarzenie = new KomentarzWydarzenie();

        komentarzWydarzenie.tresc = comment.getText().toString();
        komentarzWydarzenie.ownerId = user.id;
        komentarzWydarzenie.idWydarzenia = wydarzenie.id;

        restBackgroundTask.addComWyd(komentarzWydarzenie, user.sessionId );
        ringProgressDialog.dismiss();
        Toast.makeText(this, "dodano komentarz", Toast.LENGTH_LONG).show();
        finish();
    }



    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

}