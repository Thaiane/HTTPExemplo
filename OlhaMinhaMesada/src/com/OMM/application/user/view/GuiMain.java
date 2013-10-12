package com.OMM.application.user.view;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuiMain extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_main);
		
		Button btn = (Button)findViewById(R.id.button1);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                    	
                    	mp.start();                        
                    	Intent mudarTela = new Intent(GuiMain.this, GuiParlamentar.class);
            		    startActivity(mudarTela);
            		    GuiMain.this.finish();
                    }
                });
        
        Button sobre = (Button)findViewById(R.id.button2);
        final MediaPlayer mpl = MediaPlayer.create(this, R.raw.click);
        sobre.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                    	
                    	mpl.start();
                    	Intent mudarTela = new Intent(GuiMain.this, GuiSobre.class);
            		    startActivity(mudarTela);
            		    GuiMain.this.finish();
                    }
                });
		
	}
	
	
	
	

}
