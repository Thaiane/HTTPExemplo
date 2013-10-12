package com.OMM.application.user.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuiMain extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_main);
		
		Button sobre = (Button)findViewById(R.id.button1);
        sobre.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        
                    	Intent mudarTela = new Intent(GuiMain.this, GuiParlamentar.class);
            		    startActivity(mudarTela);
                    }
                });
		
	}
	
	
	
	

}
