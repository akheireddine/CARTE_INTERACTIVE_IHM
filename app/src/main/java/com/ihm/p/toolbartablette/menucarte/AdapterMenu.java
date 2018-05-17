package com.ihm.p.toolbartablette.menucarte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihm.p.toolbartablette.R;

/**
 * Created by 3502069 on 11/05/18.
 */

public class AdapterMenu extends ArrayAdapter<String> {

    String[] nameFood;
    String[] prix;
//    String[] description;
    int[] imgs;
    Context context;

    public AdapterMenu(Context context, String[] nameFood, String[]prix, int[] imgs){
        super(context, R.layout.listeview_item_plat);
        this.nameFood = nameFood;
        this.prix = prix;
//        this.description = description;
        this.imgs = imgs;
        this.context = context;
    }

    public int getCount(){
        return nameFood.length;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listeview_item_plat, parent, false);
            mViewHolder.img = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.name = (TextView) convertView.findViewById(R.id.nameView);
            mViewHolder.price = (TextView) convertView.findViewById(R.id.prixView);
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.img.setImageResource(imgs[position]);
        mViewHolder.name.setText(nameFood[position]);
        mViewHolder.price.setText(prix[position]);

        return convertView;
    }


    static class ViewHolder{

        ImageView img;
        TextView name;
        TextView price;

    }

}
