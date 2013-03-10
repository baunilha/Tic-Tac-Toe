package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class DrawingView extends View implements OnTouchListener {
	
	// Initiate x and y to get finger position on the phone
	float x=0;
	float y=0;
	
	// Initiate Canvas
	Canvas canvas;
	
	// Create the Paint
	private Paint paint = new Paint();
	private Path path = new Path();
	
	// Initiate button
	public Button btnReset;
	public LayoutParams params;

	public DrawingView(Context context) {
		super(context);
		
		setOnTouchListener(this);
		
		// Create button
		btnReset = new Button(context);
		btnReset.setText("New Game");
		
		// Put button on the layout
		params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		btnReset.setLayoutParams(params);
		
		// Set onClick Event for the button
		btnReset.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Resets the screen after the button is clicked
				path.reset();
				// Calls the onDraw() method
				postInvalidate();
			}
		});
	}
	
	
	@Override
	protected void onDraw(Canvas canvas){
		// Set path style
		paint.setAntiAlias(true);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(20f);
		paint.setStrokeJoin(Paint.Join.ROUND);

		canvas.drawPath(path, paint);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		int action = event.getAction();			
		
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				// Get x and y position when user first click the screen
				x = event.getX();
				y = event.getY();
				// Move starting point for the path where user's finger is
				path.moveTo(x, y);			
				return true;
				
			case MotionEvent.ACTION_MOVE:
				// Get x and y position while moving
				x = event.getX();
				y = event.getY();
				// draw line while user moves his finger on the screen
				path.lineTo(x, y);				
				break;
			
			case MotionEvent.ACTION_UP:
				break;
			
			default:
				return false;
		}
		postInvalidate();
		return true;
	}
}
