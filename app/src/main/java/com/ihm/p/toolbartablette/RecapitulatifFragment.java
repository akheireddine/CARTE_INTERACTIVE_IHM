package com.ihm.p.toolbartablette;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class RecapitulatifFragment extends Fragment {

    private TableLayout tl_plat;
    private TableLayout tl_aliment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recap_fragment, container, false);
        tl_plat = (TableLayout) rootView.findViewById(R.id.table_recap);
        tl_aliment = (TableLayout) rootView.findViewById(R.id.courses_recap);


        TableRow new_tr;
        for(int i : DataBase.command_not_sended.get("Entrees")) {

            new_tr = addTableRowToRecap(DataBase.nameEntrees[i],DataBase.priceEntrees[i],false);
            setButtonTableRow("Entrees",new_tr,i);

        }

        for(int i : DataBase.command_not_sended.get("Plats")) {
            new_tr = addTableRowToRecap(DataBase.namePlat[i],DataBase.pricePlat[i],false);
            setButtonTableRow("Plats",new_tr,i);

        }

        for(int i : DataBase.command_not_sended.get("Desserts")) {
            new_tr = addTableRowToRecap(DataBase.nameDesserts[i],DataBase.priceDesserts[i],false);
            setButtonTableRow("Desserts",new_tr,i);
        }




        for(int i : DataBase.command_sended.get("Entrees")) {
            addTableRowToRecap(DataBase.nameEntrees[i],DataBase.priceEntrees[i],true);
        }

        for(int i : DataBase.command_sended.get("Plats")) {
            addTableRowToRecap(DataBase.namePlat[i],DataBase.pricePlat[i],true);
        }

        for(int i : DataBase.command_sended.get("Desserts")) {
            addTableRowToRecap(DataBase.nameDesserts[i],DataBase.priceDesserts[i],true);
        }






        Boolean is_course = false;

        for(int i: DataBase.command_aliment.get("Legumes")){
            new_tr = addTableRowToRecapAliment(DataBase.nameLegumes[i],DataBase.priceLegumes[i]);
            setButtonTableRowAliment("Legumes",new_tr,i);

            is_course = true;
        }

        for(int i: DataBase.command_aliment.get("Fruits")){
            new_tr = addTableRowToRecapAliment(DataBase.nameFruits[i],DataBase.priceFruits[i]);
            setButtonTableRowAliment("Fruits",new_tr,i);

            is_course = true;
        }

        for(int i: DataBase.command_aliment.get("Laitiers")){
            new_tr = addTableRowToRecapAliment(DataBase.nameLaitiers[i],DataBase.priceLaitiers[i]);
            setButtonTableRowAliment("Laitiers",new_tr,i);

            is_course = true;
        }


        Button b_payer = (Button)rootView.findViewById(R.id.payer);
        if(is_course)
            b_payer.setText("Payez votre repas & courses");



        b_payer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t_a_regler = MainToolBar.a_regler.getText().toString();
                Float a_regler=(float)0;
                if(!t_a_regler.equals(""))
                   a_regler = Float.parseFloat(t_a_regler);
                String msg ="       Vous n'avez rien commandé.";
                if(a_regler>0)
                    msg ="Motant total de votre commande est de : "+a_regler+" €. \n Un Serveur vous apporte l'addition.";
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(getActivity());
                mbuilder.setMessage(msg)
                        .setPositiveButton("OK",null);
                AlertDialog alert = mbuilder.create();
                alert.show();
            }

        });

        return rootView;
    }


    private TableRow addTableRowToRecap(String name_plat, String price_plat,boolean sended){

        final TableRow tr = new TableRow(getActivity());
        LayoutInflater infl =  (LayoutInflater)getActivity().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View rowView = infl.inflate(R.layout.item_recap_plat,tr,true);
        TextView name = (TextView)rowView.findViewById(R.id.name_plat_row);
        name.setText(name_plat);
        TextView price = (TextView) rowView.findViewById(R.id.price_plat);
        price.setText(price_plat);

        if(sended){
            TextView status = (TextView)rowView.findViewById(R.id.command_status);
            status.setText("Attente : 5 min");
            ImageButton remove_button = (ImageButton)rowView.findViewById(R.id.imageButtonRemove);
            ImageButton send_button = (ImageButton)rowView.findViewById(R.id.command_send);
            remove_button.setVisibility(View.GONE);
            send_button.setVisibility(View.GONE);
        }

        tl_plat.addView(rowView);

        return tr;

    }


    public TableRow addTableRowToRecapAliment(String name_aliment, String price_aliment){
        TableRow tr = new TableRow(getActivity());
        LayoutInflater infl =  (LayoutInflater)getActivity().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View rowView = infl.inflate(R.layout.itemp_recap_aliment,tr,true);
        TextView name = (TextView)rowView.findViewById(R.id.name_aliment_row);
        name.setText(name_aliment);

        TextView price = (TextView) rowView.findViewById(R.id.price_aliment);
        price.setText(price_aliment);


        tl_aliment.addView(rowView);

        return tr;
    }


    public void setButtonTableRow(final String type,final TableRow tr,final int i) {
        final ImageButton remove_button = (ImageButton) tr.findViewById(R.id.imageButtonRemove);
        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr.setVisibility(View.GONE);
                DataBase.removeCommandNotSended(type, i);
                Float t_total_selection =  Float.parseFloat(MainToolBar.total_selectionne.getText().toString());
                Float prix = Float.parseFloat(((TextView) tr.findViewById(R.id.price_plat)).getText().toString());
                MainToolBar.total_selectionne.setText(String.valueOf(t_total_selection - prix));
            }
        });

        final ImageButton send_button = (ImageButton) tr.findViewById(R.id.command_send);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_button.setVisibility(View.GONE);
                remove_button.setVisibility(View.GONE);
                TextView stat = (TextView) tr.findViewById(R.id.command_status);
                stat.setText("Attente : 5 min");
                String t_a_regler = MainToolBar.a_regler.getText().toString();
                Float a_regler = (float)0;
                if(!t_a_regler.equals(""))
                    a_regler =  Float.parseFloat(t_a_regler);
                Float total_selection = Float.parseFloat(MainToolBar.total_selectionne.getText().toString());
                Float prix = Float.parseFloat(((TextView) tr.findViewById(R.id.price_plat)).getText().toString());

                MainToolBar.a_regler.setText(String.valueOf(a_regler + prix));
                MainToolBar.total_selectionne.setText(String.valueOf(total_selection - prix));

            }
        });
    }

    public void setButtonTableRowAliment(final String type,final TableRow tr,final int i ){
        final ImageButton remove_button = (ImageButton) tr.findViewById(R.id.imageButtonRemove_aliment);
        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr.setVisibility(View.GONE);
                DataBase.removeCommandAliment(type, i);
                Float a_regler =  Float.parseFloat(MainToolBar.a_regler.getText().toString());
                Float prix = Float.parseFloat(((TextView) tr.findViewById(R.id.price_aliment)).getText().toString());
                MainToolBar.a_regler.setText(String.valueOf(a_regler - prix));


            }
        });

    }


}
