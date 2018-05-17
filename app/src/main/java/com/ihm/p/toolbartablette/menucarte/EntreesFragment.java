package com.ihm.p.toolbartablette.menucarte;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ihm.p.toolbartablette.DataBase;
import com.ihm.p.toolbartablette.R;

public class EntreesFragment extends android.support.v4.app.Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.listview_menu, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.ListMenu);
        AdapterMenu adapterMenu = new AdapterMenu(rootView.getContext(), DataBase.nameEntrees,DataBase.priceEntrees,DataBase.imgEntrees);
        listView.setAdapter(adapterMenu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle bundle = new Bundle();
                bundle.putString("name",DataBase.nameEntrees[i]);
                bundle.putString("price",DataBase.priceEntrees[i]);
                bundle.putString("img",String.valueOf(DataBase.imgEntrees[i]));
                bundle.putString("index",String.valueOf(i));
                bundle.putString("type","Entrees");

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DescriptionPlatFragment ef = new DescriptionPlatFragment();
                ef.setArguments(bundle);
                ft.replace(R.id.plat_description,ef);
                ft.commit();
            }
        });

        return rootView;
    }
}
