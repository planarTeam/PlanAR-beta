package com.example.michal.myapplication;

import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.michal.myapplication.Adapter.CommentWydaListAdapter;
import com.example.michal.myapplication.Data.KomentWydL;
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
 * Created by damiank on 2015-05-31.
 */
@EActivity(R.layout.activity_ctlist)

public class ReadCommentActivity extends Activity {

    @Extra
    Wydarzenie wyda;

    @Extra
    User user;

    @ViewById
    ListView list;

    @ViewById
    Button dodaj;

    @Bean
    CommentWydaListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;

    @AfterViews
    void init() {


        list.setAdapter(adapter);

        try {
            restBackgroundTask.getComWydarzenie("idWydarzenia=" + wyda.id);
        }
        catch (Exception e){
            Toast.makeText(this,"co?", Toast.LENGTH_LONG).show();
        }


    }

    @Click
    void dodajClicked()
    {
        if(user!=null) {
            AddComentActivity_.intent(this).wydarzenie(wyda).user(user).start();
        }
        else {
            dodaj.setText("Musisz się zalogować!");
            dodaj.setEnabled(false);
        }
    }

    public void updateComWyd(KomentWydL comment) {

        adapter.updateComWyd(comment);
    }

    public void showError(Exception e) {

        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

}