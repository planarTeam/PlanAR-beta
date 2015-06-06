package com.example.michal.myapplication.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.michal.myapplication.Data.KomentWydL;
import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.ItemView.CommentWydItemView;
import com.example.michal.myapplication.ItemView.CommentWydItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damiank on 2015-05-31.
 */
@EBean
public class CommentWydaListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<KomentarzWydarzenie> com = new ArrayList<KomentarzWydarzenie>();

    public CommentWydaListAdapter() {
    }

    @Override
    public int getCount() {
        return com.size();
    }

    @Override
    public KomentarzWydarzenie getItem(int i) {
        return com.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommentWydItemView commentWydItemView;
        if (convertView == null) {
            commentWydItemView = CommentWydItemView_.build(context);
        } else {
            commentWydItemView = (CommentWydItemView) convertView;
        }

        commentWydItemView.bind(getItem(position));

        return commentWydItemView;
    }


    public void updateComWyd(KomentWydL komentWydL) {
        com.clear();
        com.addAll(komentWydL.records);
        notifyDataSetChanged();
    }
}
