package com.example.michal.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michal.myapplication.Adapter.TerminListAdapter;
import com.example.michal.myapplication.Data.Termin;
import com.example.michal.myapplication.Data.TerminL;
import com.example.michal.myapplication.Data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

@EActivity(R.layout.activity_plan_na_tydzien)
public class PlanDoKoncaTygodniaDlaSaliActivity extends Activity {


    ProgressDialog progressDialog;

    @Extra
    String sala;

    @Extra
    User user;

    @ViewById
    ListView list;

    @ViewById
    TextView tytul;

    @Bean
    TerminListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;

    @AfterViews
    void init() {
        //Toast.makeText(this, sala, Toast.LENGTH_LONG).show();
        tytul.setText(sala);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Ładowanie...");
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        list.setAdapter(adapter);

        Calendar dzisiajCal=Calendar.getInstance();
        Calendar zaTydzienCal=Calendar.getInstance();
        zaTydzienCal.add(Calendar.DATE, 7);

        // TRZEBA dodać 1 do miesiąca, bo numeracja zaczyna się od 0 dla stycznia!
        String dzisiaj = ((Integer)dzisiajCal.get(Calendar.YEAR)).toString()+ "-"+(dzisiajCal.get(Calendar.MONTH)+1)+ "-"+dzisiajCal.get(Calendar.DAY_OF_MONTH)+ " "+dzisiajCal.get(Calendar.HOUR)+ ":"+dzisiajCal.get(Calendar.MINUTE);
        String zaTydzien = ((Integer)zaTydzienCal.get(Calendar.YEAR)).toString()+ "-"+(zaTydzienCal.get(Calendar.MONTH)+1)+ "-"+zaTydzienCal.get(Calendar.DAY_OF_MONTH);

        try {
            restBackgroundTask.getPlanDoKoncaTygodnia("sala=\"" + sala + "\" and terminRozpoczecia>=\"" + dzisiaj + "\" and terminRozpoczecia<\"" + zaTydzien + "\"");
        }
        catch (Exception e){
            Toast.makeText(this,"co?", Toast.LENGTH_LONG).show();
        }
    }

    @ItemClick
    void listItemClicked(Termin item)
    {
        ReadCommentActivity_.intent(this).wyda(item.wydarzenie).user(user).start();
    }

    public void updatePlanNaTydzien(TerminL plan) {
        progressDialog.dismiss();
        adapter.updateTermin(plan);
    }

    public void showError(Exception e) {
        progressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

}
