package com.example.michal.myapplication.NavigationDrawer;

import android.support.v4.app.Fragment;

/**
 * Created by Mariusz on 2015-05-20.
 */
public class DrawerItem {
    private int titleResId;
    private int iconResId;
    private Class<? extends Fragment> fragmentClass;

    public DrawerItem(int titleResId, int iconResId, Class<? extends Fragment> fragmentClass) {
        this.titleResId = titleResId;
        this.iconResId = iconResId;
        this.fragmentClass = fragmentClass;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }
}
