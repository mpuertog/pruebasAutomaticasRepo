package co.edu.uniandes.testrunner.loader.json;

import org.json.JSONObject;

import co.edu.uniandes.testrunner.loader.Loader;
import co.edu.uniandes.testrunner.loader.pojo.LighthousePOJO;
import co.edu.uniandes.testrunner.loader.pojo.POJO;
import co.edu.uniandes.testrunner.util.LighthouseJsonKeys;

public class JsonLoader extends Loader {

	private LighthousePOJO pojo;
	private String jsonString;

	@Override
	public POJO loadFromFile(String fileName) {
		try {
			pojo = new LighthousePOJO();
			jsonString = readFile(fileName);
			JSONObject jsonObject = new JSONObject(jsonString);

			pojo.setInitialUrl(jsonObject.getString(LighthouseJsonKeys.INITIAL_URL));
			pojo.setScore(jsonObject.getFloat(LighthouseJsonKeys.SCORE));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pojo;
	}

}
