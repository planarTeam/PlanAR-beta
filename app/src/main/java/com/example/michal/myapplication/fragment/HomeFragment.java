package com.example.michal.myapplication.fragment;

import android.support.v4.app.Fragment;
import android.widget.Button;

import com.example.michal.myapplication.LoginActivity_;
import com.example.michal.myapplication.R;
import com.google.zxing.integration.android.IntentIntegrator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    @ViewById
    Button scan;

    @ViewById
    Button login;

    @AfterViews
    void init() {
        getActivity().setTitle(R.string.title_home);
    }

    @Click
    void scanClicked()
    {
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Zeskanuj identyfikator sali");
        integrator.initiateScan();
    }

    @Click
    void loginClicked()
    {
        LoginActivity_.intent(getActivity()).start();
        getActivity().finish();
    }
}
