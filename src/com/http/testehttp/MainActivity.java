package com.http.testehttp;

import helper.JSONHelper;

import java.util.List;

import model.Parlamentar;

import controller.ParlamentarController;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RequisicaoTask task = new RequisicaoTask();
		
		task.execute();
	}
	
	private class RequisicaoTask extends AsyncTask<String, String, String> {
		
		private static final String LOGS = "Testando";
		
		List<Parlamentar> parlamentares;
		
		@Override
		protected String doInBackground( String... params )
		{
			ParlamentarController controller = new ParlamentarController();
			
			String resultado = controller.requisicao(params[0]);
			parlamentares = JSONHelper.listaParlamentarFromJSON(resultado);
			
			return null;
		}
		
		protected void onPostExecute(final String result) {
			
			super.onPostExecute(result);
			
			Parlamentar p = parlamentares.get(0);
			
			Log.i(LOGS, "AQUI");
			Log.i(LOGS, "Parlamentar: " + p.getNome());
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
