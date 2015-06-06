package com.example.michal.myapplication.NavigationDrawer;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.michal.myapplication.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Mariusz on 2015-05-20.
 */
@EViewGroup(R.layout.drawer_list_item)
public class DrawerItemView extends LinearLayout {

    @ViewById
    ImageView icon;

    @ViewById
    TextView name;

    public DrawerItemView(Context context) {
        super(context);
    }

    public void bind(DrawerItem drawerItem) {
        icon.setImageResource(drawerItem.getIconResId());
        name.setText(drawerItem.getTitleResId());
    }
}
