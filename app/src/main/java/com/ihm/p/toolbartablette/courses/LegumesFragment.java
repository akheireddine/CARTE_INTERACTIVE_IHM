package com.ihm.p.toolbartablette.courses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.ihm.p.toolbartablette.DataBase;
import com.ihm.p.toolbartablette.menucarte.DescriptionPlatFragment;
import com.ihm.p.toolbartablette.R;

/**
 * Created by 3502069 on 12/05/18.
 */

public class LegumesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.grid_aliments, container, false);



        GridView gridView = (GridView) rootView.findViewById(R.id.gridAliment);
        GridAdapter gridAdapter = new GridAdapter(getActivity(),DataBase.imgLegumes);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle bundle = new Bundle();
                bundle.putString("index",String.valueOf(i));
                bundle.putString("type","Legumes");

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DescriptionAliment ef = new DescriptionAliment();
                ef.setArguments(bundle);
                ft.replace(R.id.aliment_description,ef);
                ft.commit();
            }
        });



        return rootView;
    }
}
