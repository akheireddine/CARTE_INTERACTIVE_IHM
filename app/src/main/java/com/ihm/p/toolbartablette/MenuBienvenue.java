package com.ihm.p.toolbartablette;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;


public class MenuBienvenue extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu_accueil);


        Button b = (Button) findViewById(R.id.button_manger);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MenuBienvenue.this, MainToolBar.class);
                startActivity(intent);
            }
          });
        }

}
