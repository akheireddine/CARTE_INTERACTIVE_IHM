package com.ihm.p.toolbartablette.courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihm.p.toolbartablette.R;

/**
 * Created by 3502069 on 12/05/18.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    private final int [] images;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        System.out.println("_____________________________ IMAGES ____________"+this.images);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.simple_item_aliment, parent, false);
            mViewHolder.img = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.img.setImageResource(images[position]);

////            view = new View(context);
//            view = layoutInflater.inflate(R.layout.simple_item_aliment,null);
//
//            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
//            imageView.setImageResource(images[position]);
//             return view;

        return convertView;
    }

    static class ViewHolder{

        ImageView img;
        TextView name;
        TextView price;

    }
}