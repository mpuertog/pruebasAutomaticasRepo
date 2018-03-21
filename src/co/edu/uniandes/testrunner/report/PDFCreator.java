package co.edu.uniandes.testrunner.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.uniandes.testrunner.loader.pojo.LighthousePOJO;
import co.edu.uniandes.testrunner.loader.pojo.POJO;
import co.edu.uniandes.testrunner.util.ApplicationConstants;
import co.edu.uniandes.testrunner.util.ReportConstants;

/**
 * Clase que recibe una lista de {@link POJO} con la información recolectada
 * tras la ejecución de las pruebas y permite exportar a PDF
 * 
 * @author ms.puerto@uniandes.edu.co
 *
 */
public class PDFCreator {

	public final static Font SMALL_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
	public final static Font NORMAL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

	private Document document;
	private HeaderFooter event;
	private PdfWriter writer;

	/**
	 * Crea un PDF con el reporte de las pruebas ejecutadas
	 * 
	 * @param pojoList
	 *            {@link List} de {@link POJO} con la información recolectada tras
	 *            la ejecución de las pruebas
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public void createDocument(List<POJO> pojoList) throws DocumentException, FileNotFoundException {
		document = new Document(PageSize.A4);
		event = new HeaderFooter();
		writer = PdfWriter.getInstance(document, new FileOutputStream(new File(ReportConstants.REPORT_FILLENAME)));
		event.setHeader(ReportConstants.REPORT_HEADER);
		writer.setPageEvent(event);
		document.open();

		PDFCreator.addMetaData(document, ReportConstants.REPORT_TITLE);
		PDFCreator.addContent(document, pojoList);
	}

	/**
	 * Agrega los metadatos al PDF creado
	 * 
	 * @param document
	 * @param sqlXMLFileName
	 */
	public static void addMetaData(Document document, String sqlXMLFileName) {
		document.addTitle(ReportConstants.REPORT_TITLE);
		document.addSubject(ReportConstants.REPORT_SUBJECT);
		document.addAuthor(ReportConstants.REPORT_AUTHOR);
	}

	/**
	 * Ensambla el contenido del PDF
	 * 
	 * @param document
	 * @param dataObjList
	 * @throws DocumentException
	 */
	public static void addContent(Document document, List<POJO> dataObjList) throws DocumentException {

		for (POJO pojo : dataObjList) {

			switch (pojo.getClass().getSimpleName()) {
			case ApplicationConstants.LIGHTHOUSE_POJO:
				LighthousePOJO lighthousePojo = (LighthousePOJO) pojo;
				Paragraph title = new Paragraph(ReportConstants.REPORT_RESULTS, FontFactory
						.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
				Chapter chapter = new Chapter(title, 1);
				chapter.setNumberDepth(0);

				Paragraph subtitle = new Paragraph(ReportConstants.REPORT_URL,
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section = chapter.addSection(subtitle);
				Paragraph someSectionText = new Paragraph(lighthousePojo.getInitialUrl());
				section.add(someSectionText);

				Paragraph subtitle2 = new Paragraph(ReportConstants.REPORT_BROWSER,
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section2 = chapter.addSection(subtitle2);
				Paragraph someSectionText2 = new Paragraph(lighthousePojo.getUserAgent());
				section2.add(someSectionText2);

				Paragraph subtitle3 = new Paragraph(ReportConstants.REPORT_LIGHTHOUSE_VER,
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section3 = chapter.addSection(subtitle3);
				Paragraph someSectionText3 = new Paragraph(lighthousePojo.getLighthouseVersion());
				section3.add(someSectionText3);

				Paragraph subtitle4 = new Paragraph(ReportConstants.REPORT_OFFLINE,
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section4 = chapter.addSection(subtitle4);
				Paragraph someSectionText4 = new Paragraph(lighthousePojo.getWorksOffline());
				section4.add(someSectionText4);

				Paragraph subtitle5 = new Paragraph(ReportConstants.REPORT_SERVICE_WORKER,
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section5 = chapter.addSection(subtitle5);
				Paragraph someSectionText5 = new Paragraph(lighthousePojo.getServiceWorker());
				section5.add(someSectionText5);

				Paragraph subtitle6 = new Paragraph(ReportConstants.REPORT_LIGHTHOUSE_SCORE,
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section6 = chapter.addSection(subtitle6);
				Paragraph someSectionText6 = new Paragraph(lighthousePojo.getCategories().toString());
				section6.add(someSectionText6);

				document.add(chapter);
				break;
			default:
				break;
			}
			document.close();
		}
	}

	/**
	 * Facilita la escritura de una nueva linea en el PDF
	 * 
	 * @param paragraph
	 * @param number
	 */
	public static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(ApplicationConstants.WHITE_SPACE));
		}
	}

	/**
	 * Facilita la creación de un nuevo {@link Paragraph}
	 * 
	 * @return {@link Paragraph} nuevo
	 */
	public static Paragraph getParagraph() {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(PDFCreator.NORMAL_FONT);
		addEmptyLine(paragraph, 1);
		return paragraph;
	}

}