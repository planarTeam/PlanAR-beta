package com.example.michal.myapplication.fragment;

import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import com.example.michal.myapplication.DrawerActivity_;
import com.example.michal.myapplication.R;
import com.google.zxing.integration.android.IntentIntegrator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Mariusz on 2015-05-21.
 */
@EFragment(R.layout.fragment_scan)
public class ScanFragment extends Fragment {

    @ViewById
    TextView wynik;

    @ViewById
    Button skanuj;

    @AfterViews
    void init(){
        getActivity().setTitle(R.string.title_scan);
        skanowanie();

        // do szybkiego testowania, efekt jak skan QR "C-25k"
        //((DrawerActivity_) getActivity()).testC25k();
    }

    @Click
    void skanujClicked()
    {
        skanowanie();
    }

    void skanowanie()
    {
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Zeskanuj identyfikator sali");
        integrator.initiateScan();
    }

    public void setWynikText(String in)
    {
        wynik.setText(in);
    }

}
