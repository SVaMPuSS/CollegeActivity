package com.example.collegeactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class EventAdapter extends ArrayAdapter<Events> {
    private Activity activity;

    public EventAdapter(Context context, int resource, List<Events> objects, Activity a) {
        super( context, resource, objects );
        this.activity = a;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        Events ev = getItem( position );
        convertView = LayoutInflater.from( getContext() ).inflate( R.layout.my_simple_item,null );
        TextView tvName = convertView.findViewById( R.id.tvEventName );
        tvName.setText( ev.getName() );
        TextView tvStart = convertView.findViewById( R.id.tvEventTimeStart );
        tvStart.setText( ev.getDateStart() );
        TextView tvEnd = convertView.findViewById( R.id.tvEventTimeEnd );
        tvEnd.setText( ev.getDateEnd() );
        Button bChange = convertView.findViewById( R.id.bItemChange );
        bChange.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), MainActivity2.class);
                intent.putExtra( "ID", position);
                intent.putExtra(Events.class.getSimpleName(), ev);
                activity.startActivityForResult(intent, 1);
            }
        } );

        Button bDelete = convertView.findViewById( R.id.bItemDelete );
        bDelete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               remove( getItem(position) );
               notifyDataSetChanged();
            }
        } );
        return convertView;
    }
}
