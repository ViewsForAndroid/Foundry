package com.viewsforandroid.foundry.sample.ui.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viewsforandroid.foundry.Foundry;
import com.viewsforandroid.foundry.FoundryFoundry;
import com.viewsforandroid.foundry.FoundryLayoutInflater;
import com.viewsforandroid.foundry.sample.R;

public class FoundryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Foundry foundry = new FoundryFoundry(getActivity().getAssets());
        FoundryLayoutInflater foundryInflater = new FoundryLayoutInflater(getActivity(), foundry);

        return foundryInflater.inflate(R.layout.fragment_foundry, container, false);
    }

}
