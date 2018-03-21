package co.edu.uniandes.testrunner.report;

import java.util.List;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;

import co.edu.uniandes.testrunner.loader.pojo.LighthousePOJO;
import co.edu.uniandes.testrunner.loader.pojo.POJO;
import co.edu.uniandes.testrunner.util.ApplicationConstants;
import co.edu.uniandes.testrunner.util.ReportConstants;

public class PDFCreator {

	public final static Font SMALL_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
	public final static Font NORMAL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

	public static void addMetaData(Document document, String sqlXMLFileName) {
		document.addTitle(ReportConstants.REPORT_TITLE);
		document.addSubject(ReportConstants.REPORT_SUBJECT);
		document.addAuthor(ReportConstants.REPORT_AUTHOR);
	}

	public static void addContent(Document document, List<POJO> dataObjList) throws DocumentException {

		for (POJO pojo : dataObjList) {

			switch (pojo.getClass().getSimpleName()) {
			case ApplicationConstants.LIGHTHOUSE_POJO:
				LighthousePOJO lighthousePojo = (LighthousePOJO) pojo;
				Paragraph title = new Paragraph("Resultados Lighthouse", FontFactory.getFont(FontFactory.HELVETICA, 18,
						Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
				Chapter chapter = new Chapter(title, 1);
				chapter.setNumberDepth(0);

				Paragraph subtitle = new Paragraph("URL Analizada:",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section = chapter.addSection(subtitle);
				Paragraph someSectionText = new Paragraph(lighthousePojo.getInitialUrl());
				section.add(someSectionText);

				Paragraph subtitle2 = new Paragraph("Navegador Utilizado:",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section2 = chapter.addSection(subtitle2);
				Paragraph someSectionText2 = new Paragraph(lighthousePojo.getUserAgent());
				section2.add(someSectionText2);

				Paragraph subtitle3 = new Paragraph("Versión de Google Lighthouse:",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section3 = chapter.addSection(subtitle3);
				Paragraph someSectionText3 = new Paragraph(lighthousePojo.getLighthouseVersion());
				section3.add(someSectionText3);

				Paragraph subtitle4 = new Paragraph("Navegación Offline:",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section4 = chapter.addSection(subtitle4);
				Paragraph someSectionText4 = new Paragraph(lighthousePojo.getWorksOffline());
				section4.add(someSectionText4);

				Paragraph subtitle5 = new Paragraph("Información del Service Worker:",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
				Section section5 = chapter.addSection(subtitle5);
				Paragraph someSectionText5 = new Paragraph(lighthousePojo.getServiceWorker());
				section5.add(someSectionText5);

				Paragraph subtitle6 = new Paragraph("Calificación Lighthouse:",
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

	public static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static Paragraph getParagraph() {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(PDFCreator.NORMAL_FONT);
		addEmptyLine(paragraph, 1);
		return paragraph;
	}

}