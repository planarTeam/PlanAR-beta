package com.example.michal.myapplication.ItemView;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by damiank on 2015-05-31.
 */

@EViewGroup(R.layout.comment_item)
public class CommentWydItemView extends RelativeLayout {

    @ViewById
    TextView text;

    @ViewById
    TextView ocena;

    public CommentWydItemView(Context context) {
        super(context);
    }

    public void bind(KomentarzWydarzenie komentarzWydarzenie) {
        text.setText(komentarzWydarzenie.tresc);
        if(komentarzWydarzenie.ocena!=null) ocena.setText("Ocena: "+komentarzWydarzenie.ocena.toString()+"/5");
        else ocena.setVisibility(INVISIBLE);
    }
}
