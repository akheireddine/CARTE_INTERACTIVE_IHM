package com.ihm.p.toolbartablette.menucarte;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ihm.p.toolbartablette.DataBase;
import com.ihm.p.toolbartablette.R;

public class PlatPrincipalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.listview_menu, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.ListMenu);
        AdapterMenu adapterMenu = new AdapterMenu(rootView.getContext(), DataBase.namePlat,DataBase.pricePlat,DataBase.imgPlat);
        listView.setAdapter(adapterMenu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("name",DataBase.namePlat[i]);
                bundle.putString("price",DataBase.pricePlat[i]);
                bundle.putString("img",String.valueOf(DataBase.imgPlat[i]));
                bundle.putString("index",String.valueOf(i));
                bundle.putString("type","Plats");


                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DescriptionPlatFragment ef = new DescriptionPlatFragment();
                ef.setArguments(bundle);
                ft.add(R.id.plat_description,ef);
                ft.commit();
            }
        });

        return rootView;
    }
}
