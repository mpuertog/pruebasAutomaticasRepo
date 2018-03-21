package co.edu.uniandes.testrunner.client;

import co.edu.uniandes.testrunner.loader.Loader;
import co.edu.uniandes.testrunner.loader.json.JsonLoader;
import co.edu.uniandes.testrunner.loader.pojo.LighthousePOJO;

public class LoaderClient {

	public static void main(String[] args) {
		Loader loader = new JsonLoader();
		LighthousePOJO pojo = (LighthousePOJO) loader.loadFromFile("lighthouse-results.json");
		System.out.println(pojo.getUserAgent());
		System.out.println(pojo.getInitialUrl());
		System.out.println(pojo.getCategories());
		System.out.println(pojo.getServiceWorker());
		System.out.println(pojo.getWorksOffline());
	}

}
