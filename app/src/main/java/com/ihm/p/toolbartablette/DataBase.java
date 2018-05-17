package com.ihm.p.toolbartablette;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by 3502069 on 12/05/18.
 */

public class DataBase {


    public static final String[] namePlat = {"Risotto à la volaille","Poulet sauce soja","Gigot d'agneau roti","Bio Burger"};
    public static final String[] pricePlat  = {"25.00","35.00","15.00","28.99","8.00"};
    public static final int[] imgPlat = {R.drawable.risotto_volaille,R.drawable.poulet_soja,R.drawable.gigot_agneau,R.drawable.bio_burger};


    public static final String[] nameEntrees = {"Salade César","Tartine chèvre miel","Soupe potiron","Salade lentilles végétarienne","Taboulé oriental"};
    public static final String[] priceEntrees  = {"15.00","15.00","10.00","10.00","8.00"};
    public static final int[] imgEntrees = {R.drawable.salade_cesar,R.drawable.chevre_miel,R.drawable.soupe_potiron,R.drawable.salade_lentille,R.drawable.taboule};

    public static final String[] nameDesserts = {"Banana Bread","Crème brulée","Brownie aux noix","Ile flottante"};
    public static final String[] priceDesserts  = {"8.00","7.00","9.00","11.00"};
    public static final int[] imgDesserts = {R.drawable.banana_bread,R.drawable.creme_brulee,R.drawable.brownie_noix,R.drawable.ile_flottante};


    public static final String[] nameLegumes = {"Pomme de terre","Radis","Courgette","Carotte"};
    public static final String[] priceLegumes  = {"1.00","2.00","2.50","1.50"};
    public static final int[] imgLegumes = {R.drawable.pomme_terre,R.drawable.radis,R.drawable.courgettes,R.drawable.carotte};


    public static final String[] nameFruits = {"Fruit de la passion","Banane","Orange","Mangue","Fraises","Ananas","Pommes"};
    public static final int[] imgFruits = {R.drawable.fruit_passion,R.drawable.bananes,R.drawable.orange,R.drawable.mangue,R.drawable.fraises,R.drawable.ananas,R.drawable.pommes};
    public static final String[] priceFruits  = {"2.00","1.50","1.50","2.00","2.50","2.00","1.50"};


    public static final String[] nameLaitiers = {"Fromage de chèvre","Fromage comté"};
    public static final String[] priceLaitiers  = {"5.00","4.00"};
    public static final int[] imgLaitiers = {R.drawable.fromage_chevre,R.drawable.fromage_comte};



    public static HashMap<String,List<Integer>> command_not_sended = new HashMap<String,List<Integer>>();
    public static HashMap<String,List<Integer>> command_sended = new HashMap<String,List<Integer>>();

    public static HashMap<String,List<Integer>> command_aliment = new HashMap<String,List<Integer>>();


    public static void removeCommandNotSended(String type,int i){
        List<Integer> list_commd = command_not_sended.remove(type);
        List<Integer>new_commd = new ArrayList<Integer>();
        for(int k =0; k<list_commd.size();k++) {
            if (list_commd.get(k) != i) {
                new_commd.add(i);
            }
        }
        command_not_sended.put(type,new_commd);
    }


    public static void addNotSendedCommand(String type, int i){
        List<Integer> list_commd = command_not_sended.remove(type);
        list_commd.add(i);
        command_not_sended.put(type,list_commd);
    }




    public static void addSendedCommand(String type,int i){
        List<Integer> list_commd = command_sended.remove(type);
        list_commd.add(i);
        command_sended.put(type,list_commd);
    }



    public static void removeCommandAliment(String type, int i){
        List<Integer> list_commd = command_aliment.remove(type);
        List<Integer>new_commd = new ArrayList<Integer>();
        for(int k =0; k<list_commd.size();k++) {
            if (list_commd.get(k) != i) {
                new_commd.add(i);
            }
        }
        command_aliment.put(type,new_commd);
    }







    public static void addAlimentToPanier(String type,int i){
        List<Integer> list_command = command_aliment.remove(type);
            list_command.add(i);
            command_aliment.put(type, list_command);
    }




    public static String getName(String type,int i){
        switch(type) {
            case "Legumes":
                return nameLegumes[i];
            case "Fruits":
                return nameFruits[i];
            case "Laitiers":
                return nameLaitiers[i];
            default:
                break;
        }
        System.out.println("NOT FOUND NAME");
        return "";
    }

    public static int getImg(String type,int i){
        switch(type) {
            case "Legumes":
                return imgLegumes[i];
            case "Fruits":
                return imgFruits[i];
            case "Laitiers":
                return imgLaitiers[i];
            default:
                break;
        }
        System.out.println("NOT FOUND IMG");

        return -1;
    }

    public static String getPrice(String type,int i){
        switch(type) {
            case "Legumes":
                System.out.println(" PRICE LEGUME YES "+i);
                return priceLegumes[i];
            case "Fruits":
                return priceFruits[i];
            case "Laitiers":
                return priceLaitiers[i];
            default:
                break;
        }
        System.out.println("NOT FOUND PRICE");

        return null;
    }


}
