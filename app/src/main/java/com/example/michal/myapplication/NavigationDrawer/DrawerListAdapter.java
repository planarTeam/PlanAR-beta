package com.example.michal.myapplication.NavigationDrawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.michal.myapplication.LoginActivity_;
import com.example.michal.myapplication.R;
import com.example.michal.myapplication.fragment.AboutAppFragment_;
import com.example.michal.myapplication.fragment.ContactFragment_;
import com.example.michal.myapplication.fragment.HomeFragment_;
import com.example.michal.myapplication.fragment.OptionsFragment_;
import com.example.michal.myapplication.fragment.ScanFragment_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean

public class DrawerListAdapter extends BaseAdapter {
    @RootContext
    Context context;

    List<DrawerItem> items = new ArrayList<DrawerItem>();

    @AfterInject
    void init() {
        items.clear();
        items.add(new DrawerItem(R.string.title_home, R.drawable.icon_home, HomeFragment_.class));
        items.add(new DrawerItem(R.string.title_scan, R.drawable.icon_about, ScanFragment_.class));
        items.add(new DrawerItem(R.string.title_options, R.drawable.icon_about, OptionsFragment_.class));
        items.add(new DrawerItem(R.string.title_contact, R.drawable.icon_about, ContactFragment_.class));
        items.add(new DrawerItem(R.string.title_aboutapp, R.drawable.icon_about, AboutAppFragment_.class));
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerItemView drawerItemView;
        if (convertView == null) {
            drawerItemView = DrawerItemView_.build(context);
        } else {
            drawerItemView = (DrawerItemView) convertView;
        }
        drawerItemView.bind(getItem(position));
        return drawerItemView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public DrawerItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}