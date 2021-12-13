package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entity.Stock;

@Service
public class exportPdfServiceImpl implements exportPdfService {

		
		public  ByteArrayInputStream exportPDF(List<Stock> stocks) {
			{
				Document document =new Document();
				ByteArrayOutputStream out =new ByteArrayOutputStream();
			try {	
				PdfWriter.getInstance(document, out);
				document.open();
				
				//add text to pdf
				//font
				Font font=FontFactory.getFont(FontFactory.COURIER,16, BaseColor.BLACK);
				Paragraph paragraph=new Paragraph("Stocks List",font);
				paragraph.setAlignment(Element.ALIGN_CENTER);
				document.add(paragraph);
				document.add(Chunk.NEWLINE);
				
				//columns
				PdfPTable table = new PdfPTable(3);
				//titles
				Stream.of("LibelleStock","Qte","QteMin").forEach(headerTitle ->{
					PdfPCell header=new PdfPCell();
					Font headFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
					header.setBackgroundColor(BaseColor.LIGHT_GRAY);
					header.setHorizontalAlignment(Element.ALIGN_CENTER);
					header.setBorderWidth(1);
					header.setPhrase(new Phrase(headerTitle,headFont));
					table.addCell(header);
					
				});
				
				for(Stock st: stocks) {
				
					table.addCell(st.getLibelleStock());
				
				
					table.addCell(st.getQte().toString());
					
				
					table.addCell(st.getQteMin().toString());
				}
			document.add(table);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return new ByteArrayInputStream(out.toByteArray());
		}
}
}