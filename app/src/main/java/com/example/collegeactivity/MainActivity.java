package com.example.collegeactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    private EventAdapter adapter;
    private ArrayList<Events> list;

    private TypeEventAdapter TEAdapter;
    private ArrayList<TypeEvent> TEList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        String format = "16:03";
        Events e = new Events(1,1,1,"name",format,format,format,"sasa",1);
        list = new ArrayList<Events>();
        list.add( e );
        list.add( e );
        list.add( e );
        adapter = new EventAdapter(this,0,list, this );
        ((ListView)findViewById( R.id.lvEvent )).setAdapter( adapter );


        TEList = new ArrayList<TypeEvent>();
        TEList.add( new TypeEvent(0,"asdasd", Color.BLUE ) );
        TEList.add( new TypeEvent(1,"asdasd2", Color.RED ) );
        TEList.add( new TypeEvent(2,"asdasd3", Color.GREEN ) );
        TEList.add( new TypeEvent(3,"asdasd1", Color.CYAN ) );
        TEAdapter = new TypeEventAdapter( this,0,TEList );
        TEAdapter.sort( TypeEvent.CompareByName );
        ((Spinner)findViewById( R.id.sType )).setAdapter( TEAdapter );

        ((Button)findViewById( R.id.bAdd )).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        } );
    }

    public void startSecondActivity(){
        Intent intent = new Intent( this, MainActivity2.class);
        Events e = new Events(0,0,0,"name","","","","",0);
        intent.putExtra( "ID", -1);
        intent.putExtra(Events.class.getSimpleName(), e);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            Events ev =(Events)data.getSerializableExtra( Events.class.getSimpleName() );
            int pos =data.getIntExtra( "ID",-1 );
            if(pos != -1){
                list.set(pos,ev);
            }else {
                adapter.add( ev );
            }
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText( this, "vse ploho", Toast.LENGTH_SHORT ).show();
        }
        super.onActivityResult( requestCode, resultCode, data );
    }
}