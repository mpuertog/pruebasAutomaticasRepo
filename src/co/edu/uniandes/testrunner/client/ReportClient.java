package co.edu.uniandes.testrunner.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.uniandes.testrunner.loader.Loader;
import co.edu.uniandes.testrunner.loader.json.JsonLoader;
import co.edu.uniandes.testrunner.loader.pojo.POJO;
import co.edu.uniandes.testrunner.report.HeaderFooter;
import co.edu.uniandes.testrunner.report.PDFCreator;

public class ReportClient {
	private static final String TITLE = "TestReport";

	public static final String PDF_EXTENSION = ".pdf";

	public static void main(String[] args) {

		Document document = null;
		Loader loader = new JsonLoader();
		List<POJO> pojoList = new ArrayList<POJO>();
		pojoList.add(loader.loadFromFile("lighthouse-results.json"));

		try {
			document = new Document(PageSize.A4);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(TITLE + PDF_EXTENSION)));
			HeaderFooter event = new HeaderFooter();
			event.setHeader("Reporte de ejecución de pruebas");
			writer.setPageEvent(event);
			document.open();
			PDFCreator.addMetaData(document, TITLE);
			PDFCreator.addContent(document, pojoList);
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != document) {
				document.close();
			}
		}
	}

}
