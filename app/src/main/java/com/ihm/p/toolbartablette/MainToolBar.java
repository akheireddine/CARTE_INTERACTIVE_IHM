package com.ihm.p.toolbartablette;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihm.p.toolbartablette.courses.CoursesFragment;
import com.ihm.p.toolbartablette.menucarte.CarteFragment;
import com.ihm.p.toolbartablette.plats_preferes.PrefereFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainToolBar extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public static TextView total_selectionne;
    public static TextView a_regler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tool_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        DataBase.command_not_sended.put("Entrees",new ArrayList<Integer>());
        DataBase.command_not_sended.put("Plats",new ArrayList<Integer>());
        DataBase.command_not_sended.put("Desserts",new ArrayList<Integer>());

        DataBase.command_sended.put("Entrees",new ArrayList<Integer>());
        DataBase.command_sended.put("Plats",new ArrayList<Integer>());
        DataBase.command_sended.put("Desserts",new ArrayList<Integer>());

        DataBase.command_aliment.put("Legumes",new ArrayList<Integer>());
        DataBase.command_aliment.put("Fruits",new ArrayList<Integer>());
        DataBase.command_aliment.put("Laitiers",new ArrayList<Integer>());

        total_selectionne = (TextView)findViewById(R.id.total_selection);
        a_regler = (TextView)findViewById(R.id.a_regler);




        Button b_authentification = (Button)findViewById(R.id.authentification);
        b_authentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainToolBar.this);
                System.out.println(" ________________________________________IM HERE man in dialog");
                mbuilder.setMessage("Scanner votre code QR au dos de votre Carte fidélité.")
                        .setPositiveButton("Scanner",null)
                        .setNegativeButton("Annuler",null);
                AlertDialog alert = mbuilder.create();
                alert.show();
            }

        });



        Button b_appel = (Button)findViewById(R.id.appel_serveur);
        b_appel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainToolBar.this);
                mbuilder.setMessage("Confirmer l'appel pour un serveur ?")
                        .setPositiveButton("Oui",null)
                        .setNegativeButton("Annuler",null);
                AlertDialog alert = mbuilder.create();
                alert.show();
            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_tool_bar, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {
                case 0:
                    return new HistoriqueFragment();
                case 1:
                    return new PrefereFragment();
                case 2:
                    return new CarteFragment();
                case 3:
                    return new CoursesFragment();
                case 4:
                    return new RecapitulatifFragment();
                default:
                    return new CarteFragment();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }
    }
}
