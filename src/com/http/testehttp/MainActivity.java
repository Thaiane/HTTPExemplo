package com.http.testehttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView output;

	private ProgressDialog progressDialog;

	private final Handler handler = new Handler() {

		@Override
		public void handleMessage(final Message msg) {
			progressDialog.dismiss();
			String bundleResult = msg.getData().getString("RESPONSE");
			output.setText(bundleResult);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.output = (TextView) findViewById(R.id.status);
		
		performHTTPRequest();
		
		
		// todo: arrumar output

	}

	private void performHTTPRequest(){
		
		final ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
			
			public String handleResponse(HttpResponse response) throws IOException{
				StatusLine status = response.getStatusLine();
				
				HttpEntity entity = response.getEntity();
				String result = null;
				//todo: refatorar, extrair método/objeto
				
				BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null){
					sb.append(line + "\n");
				}
				
				br.close();
				result = sb.toString();
				
				Message message = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString("RESPONSE", result);
				message.setData(bundle);
				handler.sendMessage(message);
				
				return result;				
			}
		};
		
		this.progressDialog = ProgressDialog.show(this, "Working", "fazendo a parada...");
		
		new Thread(){
			
			public void run(){
				try{
					DefaultHttpClient client = new DefaultHttpClient();
					HttpGet httpMethod = new HttpGet("http://192.168.1.8:8080/OlhaMinhaMesadaServer/parlamentar?nome=Paulo");
					client.execute(httpMethod, responseHandler);					
					
				}catch (ClientProtocolException e){
					//do sth
				}catch (IOException e){
					//do sth else
				}
			}
		}.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
