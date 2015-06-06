package com.example.michal.myapplication.ItemView;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.michal.myapplication.Data.Termin;
import com.example.michal.myapplication.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.termin_item)
public class TerminItemView extends RelativeLayout {

    @ViewById
    TextView nazwa;

    @ViewById
    TextView prowadzacy;

    @ViewById
    TextView czas;

    public TerminItemView(Context context) {
        super(context);
    }

    public void bind(Termin termin) {
        nazwa.setText(termin.wydarzenie.nazwa);
        czas.setText(termin.terminRozpoczecia + " do "+termin.terminZakonczenia.substring(11));
    }

}
