package com.example.michal.myapplication.fragment;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import com.example.michal.myapplication.R;
/**
 * Created by Mariusz on 2015-05-21.
 */
@EFragment(R.layout.fragment_aboutapp)
public class AboutAppFragment extends Fragment {

    @AfterViews
    void init(){
        getActivity().setTitle(R.string.title_aboutapp);
    }

}
