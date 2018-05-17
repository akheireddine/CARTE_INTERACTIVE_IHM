package com.ihm.p.toolbartablette.plats_preferes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ihm.p.toolbartablette.R;
import com.ihm.p.toolbartablette.menucarte.DessertFragment;
import com.ihm.p.toolbartablette.menucarte.PlatPrincipalFragment;

public class PrefereFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.prefere_fragment, container, false);



        Button b_entree = (Button) rootView.findViewById(R.id.entrees);
        b_entree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                EntreesPrefereFragment ef = new EntreesPrefereFragment();
                ft.replace(R.id.tableau_plat_prefere,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Button b_plat = (Button) rootView.findViewById(R.id.viandes);
        b_plat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                PlatPrefereFragment ef = new PlatPrefereFragment();
                ft.replace(R.id.tableau_plat_prefere,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Button b_dessert = (Button) rootView.findViewById(R.id.desserts);
        b_dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DessertPrefereFragment ef = new DessertPrefereFragment();
                ft.replace(R.id.tableau_plat_prefere,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return rootView;
    }
}