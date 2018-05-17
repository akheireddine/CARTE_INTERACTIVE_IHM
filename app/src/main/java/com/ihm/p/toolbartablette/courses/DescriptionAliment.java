package com.ihm.p.toolbartablette.courses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihm.p.toolbartablette.DataBase;
import com.ihm.p.toolbartablette.MainToolBar;
import com.ihm.p.toolbartablette.R;

import org.w3c.dom.Text;

/**
 * Created by 3502069 on 12/05/18.
 */

public class DescriptionAliment extends Fragment {

//    TextView kg_text;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.descriptif_aliment, container, false);

        Bundle bundle = getArguments();
        final int index = Integer.parseInt(bundle.getString("index"));
        final String type = bundle.getString("type");

        String nameFood = DataBase.getName(type,index);
        final String prix = DataBase.getPrice(type,index);
        int image = DataBase.getImg(type,index);

        ImageView img = (ImageView) rootView.findViewById(R.id.imageViewDescription);
        TextView name = (TextView) rootView.findViewById(R.id.titreDescription);
        TextView price = (TextView) rootView.findViewById(R.id.prixDescription);
//        kg_text  = (TextView)rootView.findViewById(R.id.nbKg);
//        final int nb_kg = Integer.parseInt(kg_text.getText().toString());

        name.setText(nameFood);
        price.setText("Prix : " + prix );
        img.setImageResource(image);

        Button b_add_aliment = (Button)rootView.findViewById(R.id.ajouter_aliment);
        b_add_aliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase.addAlimentToPanier(type, index);
                TextView t_a_regler = MainToolBar.a_regler;
                String value_regler = t_a_regler.getText().toString();
                float total_a_regler = Float.parseFloat(prix);
                if (!value_regler.equals(""))
                    total_a_regler += Float.parseFloat(value_regler);
                t_a_regler.setText(String.valueOf(total_a_regler));

            }
        });



//        ImageButton b_add_command = (ImageButton) rootView.findViewById(R.id.addAliment);
//        b_add_command.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                kg_text  = (TextView)rootView.findViewById(R.id.nbKg);
//                int nb_kg = Integer.parseInt(kg_text.getText().toString());
//                kg_text.setText(String.valueOf(nb_kg + 1));
//                DataBase.addAlimentToPanier(type, index,nb_kg+1);
//
//                TextView t_a_regler = MainToolBar.a_regler;
//                String value_regler = t_a_regler.getText().toString();
//                float total_a_regler = Float.parseFloat(prix);
//                if (!value_regler.equals(""))
//                    total_a_regler += Float.parseFloat(value_regler);
//                t_a_regler.setText(String.valueOf(total_a_regler));
//            }
//        });
//
//
//        ImageButton b_remove_command = (ImageButton) rootView.findViewById((R.id.deleteAliment));
//        b_remove_command.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                kg_text  = (TextView)rootView.findViewById(R.id.nbKg);
//                int nb_kg = Integer.parseInt(kg_text.getText().toString());
//
//                TextView t_a_regler = MainToolBar.a_regler;
//                String value_regler = t_a_regler.getText().toString();
//                float total_a_regler = Float.parseFloat(prix);
//                if ( nb_kg > 0) {
//                    DataBase.removeAlimentToPanier(type, index,nb_kg-1);
//                    total_a_regler = Float.parseFloat(value_regler) - total_a_regler;
//                    t_a_regler.setText(String.valueOf(total_a_regler));
//                    kg_text.setText(String.valueOf(nb_kg - 1));
//                }
//
//            }
//        });


        return rootView;
    }
}