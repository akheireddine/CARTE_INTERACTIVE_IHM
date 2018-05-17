package com.ihm.p.toolbartablette.menucarte;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ihm.p.toolbartablette.R;

import org.w3c.dom.Text;

public class CarteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.carte_fragment, container, false);



        Button b_entree = (Button) rootView.findViewById(R.id.entrees);
        b_entree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                EntreesFragment ef = new EntreesFragment();
                ft.replace(R.id.defile_plat,ef);
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
                PlatPrincipalFragment ef = new PlatPrincipalFragment();
                ft.replace(R.id.defile_plat,ef);
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
                DessertFragment ef = new DessertFragment();
                ft.replace(R.id.defile_plat,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Button b_boisson = (Button) rootView.findViewById(R.id.boissons);
        b_boisson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DessertFragment ef = new DessertFragment();
                ft.replace(R.id.defile_plat,ef);
                ft.addToBackStack(null);
                ft.commit();
            }
        });



        Button b_allergene = (Button) rootView.findViewById(R.id.alergenes);
//        b_allergene.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//                ListView listView = (ListView) view.findViewById(R.id.listview_allergene);
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.allergene_popup);
//                listView.setAdapter(adapter);
//                listView.setMultiChoiceModeListener();
//
//                listView.add()
//
//
//
//
//                AlertDialog.Builder mbuilder = new AlertDialog.Builder(getContext());
//                View mView = getLayoutInflater().inflate(R.layout.allergene_popup,null);
//
//            }
//        });




        return rootView;
    }



}
