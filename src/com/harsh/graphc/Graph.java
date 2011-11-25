package com.harsh.graphc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Graph extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	try{
        super.onCreate(savedInstanceState);
        Bundle val=getIntent().getExtras();
        float sl=val.getFloat("slope"),in=val.getFloat("inter");
        final Context curContext=this;
        setContentView(new GraphView(curContext,sl,in));

    	}
    	catch(Exception e)
    	{
    	Toast err=Toast.makeText(this,(CharSequence)"Incorrect Values Entered. Enter Again.", Toast.LENGTH_LONG);
		  err.show();

    	}
}}