package com.example.collegeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Events ev;
    int id = -1;

    private TypeEventAdapter TEAdapter;
    private ArrayList<TypeEvent> TEList;

    private TypeEvent te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );


        TEList = new ArrayList<TypeEvent>();
        TEList.add( new TypeEvent(0,"asdasd", Color.BLUE ) );
        TEList.add( new TypeEvent(1,"asdasd2", Color.RED ) );
        TEList.add( new TypeEvent(2,"asdasd3", Color.GREEN ) );
        TEList.add( new TypeEvent(3,"asdasd1", Color.CYAN ) );
        TEAdapter = new TypeEventAdapter( this,0,TEList );
        TEAdapter.sort( TypeEvent.CompareByName );
        Spinner sp = findViewById( R.id.sEventType );
        sp.setAdapter( TEAdapter );




        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            id = bundle.getInt( "ID" );
            ev = (Events)bundle.getSerializable( Events.class.getSimpleName() );
            ((TextView)findViewById( R.id.etEventName )).setText( ev.getName() );
            ((TextView)findViewById( R.id.etEventDate )).setText( ev.getDate() );
            ((TextView)findViewById( R.id.etEventDateStart )).setText( ev.getDateStart() );
            ((TextView)findViewById( R.id.etEventDateStop )).setText( ev.getDateEnd() );
            ((TextView)findViewById( R.id.etEventLocation )).setText( ev.getLocation() );
            sp.setSelection( TEAdapter.getPositionById( ev.getEventId() ) );
        }


        ((Button)findViewById( R.id.bOk )).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultCode;
                Intent intent = new Intent();
                if(v.getId() == R.id.bOk){
                    intent.putExtra( "ID",id );
                    ev.setName( ((TextView)findViewById( R.id.etEventName )).getText().toString() );
                    ev.setDate( ((TextView)findViewById( R.id.etEventDate )).getText().toString() );
                    ev.setDateStart( ((TextView)findViewById( R.id.etEventDateStart )).getText().toString() );
                    ev.setDateEnd( ((TextView)findViewById( R.id.etEventDateStop )).getText().toString() );
                    ev.setLocation( ((TextView)findViewById( R.id.etEventLocation )).getText().toString() );
                    ev.setEventId( ((TypeEvent)sp.getSelectedItem()).getId() );
                    intent.putExtra( Events.class.getSimpleName(),ev );
                    resultCode = RESULT_OK;
                }else {
                    resultCode = RESULT_CANCELED;
                }
                setResult( resultCode,intent );
                finish();
            }
        } );

    }
}