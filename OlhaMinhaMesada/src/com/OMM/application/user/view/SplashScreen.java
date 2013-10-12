package com.OMM.application.user.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;


public class SplashScreen extends Activity {
	
	private final int DURACAO_DA_TELA = 4860;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		MediaPlayer splashSound = MediaPlayer.create(this, R.raw.splash);
		splashSound.start();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				
				Intent minhaAcao = new Intent(SplashScreen.this, GuiMain.class);
				
				SplashScreen.this.startActivity(minhaAcao);
				
				SplashScreen.this.finish();
				
			}
			
			}, DURACAO_DA_TELA);
		
		}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}