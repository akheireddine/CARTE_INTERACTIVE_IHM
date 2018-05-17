package com.ihm.p.toolbartablette.plats_preferes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ihm.p.toolbartablette.R;

public class PlatPrefereFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.prefere_plat_fragment, container, false);

        return rootView;
    }
}
