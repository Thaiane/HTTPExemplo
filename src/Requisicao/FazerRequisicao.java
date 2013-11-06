package Requisicao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;




public class FazerRequisicao {
	
	
	
	public String fazerRequisicao(String url){
	
	String resultado = null;
    
    HttpClient httpclient = new DefaultHttpClient();
     
    HttpResponse response;
    
    try {

        response = httpclient.execute(new HttpGet(url));
         
        InputStream is = response.getEntity().getContent();
         
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder content = new StringBuilder();
         
        String linha;
     
        while ((linha = reader.readLine()) != null) {
            content.append(linha);
        }

        reader.close();
        is.close();
                         
        resultado = content.toString();
     
    }
    catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
     
    return resultado;

	}
}
