package com.example.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {
	
	// Declare references
	Button startButton;
	TextView titleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// getWindow().setBackgroundDrawableResource(R.drawable.bg_front);
		setContentView(R.layout.activity_main);
		
		// Point the reference to its id
		startButton = (Button) this.findViewById(R.id.start_button);
		titleView = (TextView) this.findViewById(R.id.title_view);
		
		// Set a OnClickListener event
        startButton.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View clickedView) {
		// View in the LogCat if the button was clicked
		Log.v("MainActivity", "button was clicked!");
		
		// Create an Intent to go to the next page (activity) when the button is clicked
		Intent i = new Intent(this, OtherActivity.class);
		startActivity(i);
		
	}

}
