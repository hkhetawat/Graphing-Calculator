package com.harsh.graphc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpressionPage extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context curContext=this;
        setContentView(R.layout.main);
        Button draw=(Button)this.findViewById(R.id.graph),draweq=(Button)this.findViewById(R.id.graph2);
        final EditText sl=(EditText)((Activity) curContext).findViewById(R.id.slope);
        sl.clearFocus();
        sl.setOnFocusChangeListener(new OnFocusChangeListener()
        {

			public void onFocusChange(View arg0, boolean arg1) {
				if(sl.getText().toString().equals("0.0*"))
				{
					sl.setText("0.0");
					sl.clearFocus();
				}
				else if(sl.getText().toString().equals("0.0"))
					sl.setText("");
			}
        	
        });
		final EditText in=(EditText)((Activity) curContext).findViewById(R.id.inter);
		  in.setOnFocusChangeListener(new OnFocusChangeListener()
	        {

				public void onFocusChange(View arg0, boolean arg1) {
					if(in.getText().toString().equals("0.0"))
						in.setText("");
				}
	        	
	        });
		  final EditText eq=(EditText)((Activity) curContext).findViewById(R.id.equ);
	        eq.clearFocus();
	        eq.setOnFocusChangeListener(new OnFocusChangeListener()
	        {

				public void onFocusChange(View arg0, boolean arg1) {
					if(eq.getText().toString().equals("x"))
						eq.setText("");
				}	
	        });
		  try{
        draw.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				try{
					Toast t=Toast.makeText(curContext,(CharSequence)"Working",Toast.LENGTH_SHORT);
					t.show();
					CharSequence so=sl.getText();
					String s=so.toString();
					Float fs=Float.valueOf(s);
					CharSequence it=in.getText();
					String y=it.toString();
					Float fy=Float.valueOf(y);
				Intent i=new Intent(curContext,Graph.class);
				Bundle val=new Bundle();
				val.putFloat("slope",fs);
				val.putFloat("inter",fy);
				i.putExtras(val);
			    startActivity(i);
				}catch(Exception e)
				{
					Toast te=Toast.makeText(curContext,(CharSequence)e,Toast.LENGTH_LONG);
					te.show();
				}
			}
		});
        
		  }
		  catch(Exception e)
		  {
			  Toast err=Toast.makeText(curContext,(CharSequence)"Incorrect Values Entered. Enter Again.", Toast.LENGTH_LONG);
			  err.show();
		  }
    }
}