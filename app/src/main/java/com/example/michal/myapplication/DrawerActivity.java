package com.example.michal.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.michal.myapplication.Data.User;
import com.example.michal.myapplication.NavigationDrawer.DrawerHandler;
import com.example.michal.myapplication.fragment.ScanFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;

/**
 * Created by Mariusz on 2015-05-20.
 */
@EActivity(R.layout.activity_drawer)
public class DrawerActivity extends ActionBarActivity {

    public final String LOG_TAG = this.getClass().getSimpleName();

    @Extra
    User user;

    @Bean
    DrawerHandler drawerHandler;

    @AfterViews
    void init() {
        drawerHandler.init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerHandler.getDrawerToggle().syncState();
    }

    @OptionsItem(android.R.id.home)
    public boolean drawerToggleSelected(MenuItem item) {
        return drawerHandler.drawerToggleSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        getSupportActionBar().setTitle(titleId);
    }

    @OnActivityResult(49374)
    void onResult(int resultCode, Intent data) {
        try {
            String result = data.getStringExtra("SCAN_RESULT");
            //((ScanFragment_) getSupportFragmentManager().getFragments().get(0)).setWynikText(result);
            //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            DrawerActivity_.intent(this).user(user).start();
            this.finish();
            PlanDoKoncaTygodniaDlaSaliActivity_.intent(this).sala(result).user(user).start();
        }
        catch(NullPointerException e) {
            ((ScanFragment_) getSupportFragmentManager().getFragments().get(0)).setWynikText("Błąd podczas skanowania.\nSpróbuj ponownie, używając przycisku poniżej.");
            Toast.makeText(this, "Błąd skanowania.", Toast.LENGTH_LONG).show();
        }
    }

    public void testC25k()
    {
        String result = "C-25k";
        //((ScanFragment_) getSupportFragmentManager().getFragments().get(0)).setWynikText(result);
        //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        DrawerActivity_.intent(this).start();
        this.finish();
        PlanDoKoncaTygodniaDlaSaliActivity_.intent(this).sala(result).user(user).start();
    }
}
