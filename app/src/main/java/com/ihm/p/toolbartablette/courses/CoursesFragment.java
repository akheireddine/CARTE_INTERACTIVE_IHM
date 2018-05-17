package com.ihm.p.toolbartablette.courses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ihm.p.toolbartablette.R;

public class CoursesFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.courses_fargment, container, false);


        Button b_legumes = (Button)rootView.findViewById(R.id.legumes);
        b_legumes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                LegumesFragment ef = new LegumesFragment();
                ft.replace(R.id.defile_aliment,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Button b_fruits = (Button)rootView.findViewById(R.id.fruits);
        b_fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FruitFragment ef = new FruitFragment();
                ft.replace(R.id.defile_aliment,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Button b_laitiers = (Button)rootView.findViewById(R.id.produitslait);
        b_laitiers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                LaitiersFragment ef = new LaitiersFragment();
                ft.replace(R.id.defile_aliment,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });



        return rootView;
    }
}
