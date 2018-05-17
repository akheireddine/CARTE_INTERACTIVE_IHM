package com.ihm.p.toolbartablette.menucarte;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihm.p.toolbartablette.DataBase;
import com.ihm.p.toolbartablette.MainToolBar;
import com.ihm.p.toolbartablette.R;

import org.w3c.dom.Text;

/**
 * Created by 3502069 on 11/05/18.
 */

public class DescriptionPlatFragment  extends android.support.v4.app.Fragment {

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.descriptif_plat, container, false);
        Bundle bundle = getArguments();
        String nameFood = bundle.getString("name");
        final String prix = bundle.getString("price");
        int image = Integer.parseInt(bundle.getString("img"));
        final int index = Integer.parseInt(bundle.getString("index"));
        final String type = bundle.getString("type");

        ImageView img = (ImageView) rootView.findViewById(R.id.imageViewDescription);
        TextView name = (TextView) rootView.findViewById(R.id.titreDescription);
        TextView price = (TextView) rootView.findViewById(R.id.prixDescription);

        name.setText(nameFood);
        price.setText("Prix : "+prix);
        img.setImageResource(image);

        Button b_immediat = (Button) rootView.findViewById(R.id.commande_immediat);
        b_immediat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mbuilder = new AlertDialog.Builder(getActivity());
                mbuilder.setMessage("Confirmer votre commande ? Le plat sera immediatement envoyé en cuisine !")
                        .setPositiveButton("Envoyer en cuisine !", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DataBase.addSendedCommand(type,index);
                                TextView t_a_regler = MainToolBar.a_regler;
                                String value_reglement = t_a_regler.getText().toString();
                                float total_regler = Float.parseFloat(prix);
                                if(!value_reglement.equals(""))
                                    total_regler += Float.parseFloat(value_reglement);
                                t_a_regler.setText(String.valueOf(total_regler));
                            }
                        }).setNegativeButton("Annuler",null);

                AlertDialog dialog = mbuilder.create();
                dialog.show();

            }
        });


        Button b_add_command = (Button) rootView.findViewById(R.id.ajouter_a_commande);
        b_add_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase.addNotSendedCommand(type,index);

                TextView t_total_selection = MainToolBar.total_selectionne;
                String value_selection = t_total_selection.getText().toString();

                float total_selection = Float.parseFloat(prix);

                if (!value_selection.equals(""))
                    total_selection += Float.parseFloat(value_selection);
                t_total_selection.setText(String.valueOf(total_selection));
            }
        });


        return rootView;
    }
}