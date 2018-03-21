package co.edu.uniandes.testrunner.client;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;

import co.edu.uniandes.testrunner.loader.Loader;
import co.edu.uniandes.testrunner.loader.json.CalabashJsonLoader;
import co.edu.uniandes.testrunner.loader.json.LightHouseJsonLoader;
import co.edu.uniandes.testrunner.loader.pojo.POJO;
import co.edu.uniandes.testrunner.report.PDFCreator;

public class ReportClient {

	public static void main(String[] args) {

		Loader loaderLighthouse = new LightHouseJsonLoader();
		Loader loaderCalabash = new CalabashJsonLoader();
		List<POJO> pojoList = new ArrayList<POJO>();
		pojoList.add(loaderLighthouse.loadFromFile("lighthouse-results.json"));
		pojoList.add(loaderCalabash.loadFromFile("calendula.json"));

		PDFCreator pdfCreator = new PDFCreator();

		try {
			pdfCreator.createDocument(pojoList);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

}
