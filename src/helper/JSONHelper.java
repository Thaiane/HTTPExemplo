package helper;

import java.util.List;

import model.Parlamentar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONHelper {
	
	public static List<Parlamentar> listaParlamentarFromJSON(String str) {
		
		Gson gson = new Gson();
		
		List<Parlamentar> lista = gson.fromJson(str, new TypeToken<List<Parlamentar>>(){}.getType());
		
		return lista;
	}
}
