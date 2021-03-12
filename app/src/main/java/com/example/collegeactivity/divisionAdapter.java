package com.example.collegeactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class divisionAdapter extends ArrayAdapter<division> {

    public divisionAdapter( Context context, int resource, List<division> objects) {
        super( context, resource, objects );
    }

    public int getPositionById(Integer id){
        int pos;
        for (pos = getCount()-1; pos>=0 &&((int)getItem(pos).getId() != id) ; pos--){ }
        return pos;
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        division te = getItem( position );
        convertView = LayoutInflater.from( getContext() ).inflate( android.R.layout.simple_spinner_item ,null);
        TextView tv = convertView.findViewById( android.R.id.text1 );
        tv.setText( te.getName() );
        return convertView;
    };

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
