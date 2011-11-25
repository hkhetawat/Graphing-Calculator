package com.harsh.graphc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

public class GraphView extends View
{
	float sl,in;
	Context c;
	public GraphView(Context c,float sl,float in)
	{
		super(c);
		this.c=c;
		this.sl=sl;
		this.in=in;
	}
	@Override
	public void onDraw(Canvas canvas)
	{
		try{
		super.onDraw(canvas);
		Paint black=new Paint();
		black.setColor(Color.BLACK);
		canvas.drawColor(Color.WHITE);
		Paint gray=new Paint();
		gray.setColor(Color.LTGRAY);
		int j=3;
		for(int i=0;i<240;i=i+10)
		{	j++;
			canvas.drawLine(i,0,i,320,gray);
			if(j==4)
			{	
				canvas.drawText(""+((i-120)>0?(i-120):(120-i)),i-5,170,black);
				j=0;
			}
		}
		j=3;
		for(int i=0;i<320;i=i+10)
		{	j++;
			canvas.drawLine(0,i,240,i,gray);
			if(j==4)
			{	
				canvas.drawText(""+((i-160)>0?(i-160):(160-i)),120,i+5,black);
				j=0;
			}
		}
		canvas.drawLine(0, 160, 240, 160,black);
		canvas.drawLine(120, 0, 120, 320,black);
		float x=-120,y=0;
		while(x<=240)
		{
			y=x*sl+in;
			canvas.drawPoint(x+120, 160-y,black);
			x=(float) (x+0.01);
		}
		}
		catch(Exception e)
		{
			Toast err=Toast.makeText(c,(CharSequence)"Incorrect Values Entered. Enter Again.", Toast.LENGTH_LONG);
			  err.show();
		}
	}
}
