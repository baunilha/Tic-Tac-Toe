package com.example.tictactoe;

import android.app.Activity;
import android.os.Bundle;

public class OtherActivity extends Activity {
	
	//String bg = "TicTacToe/assets/drawable/bg.png"; 
	
	// If the drawing is the only thing on the screen:
	// Declare reference to new Drawing Object
	DrawingView drawingView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setBackgroundDrawableResource(R.drawable.bg);
		
		//setContentView(R.layout.other_activity);
		
		// If the drawing is the only thing on the screen:
		// Create a new Draw
		drawingView = new DrawingView(this);
		// Show new Draw
		setContentView(drawingView);	
		addContentView(drawingView.btnReset, drawingView.params);
	}
	
	@Override
	protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	finish();
	}

}
