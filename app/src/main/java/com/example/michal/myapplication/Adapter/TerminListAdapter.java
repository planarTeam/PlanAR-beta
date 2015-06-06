package com.example.michal.myapplication.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.michal.myapplication.Data.Termin;
import com.example.michal.myapplication.Data.TerminL;
import com.example.michal.myapplication.ItemView.TerminItemView;
import com.example.michal.myapplication.ItemView.TerminItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damiank on 2015-05-31.
 */
@EBean
public class TerminListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Termin> com = new ArrayList<Termin>();

    public TerminListAdapter() {
    }

    @Override
    public int getCount() {
        return com.size();
    }

    @Override
    public Termin getItem(int i) {
        return com.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TerminItemView terminItemView;
        if (convertView == null) {
            terminItemView = TerminItemView_.build(context);
        } else {
            terminItemView = (TerminItemView) convertView;
        }

        terminItemView.bind(getItem(position));

        return terminItemView;
    }


    public void updateTermin(TerminL terminL) {
        com.clear();
        com.addAll(terminL.records);
        notifyDataSetChanged();
    }
}
