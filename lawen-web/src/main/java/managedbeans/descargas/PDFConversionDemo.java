/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.descargas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named(value = "PDFconversion" )
@ApplicationScoped
public class PDFConversionDemo {
public static void main(String[] args) {
		  try
		  {
			//Read file using PdfReader
			PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

			//Modify file using PdfReader
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("HelloWorld-modified.pdf"));

			Image image = Image.getInstance("temp.png");
			image.scaleAbsolute(100, 50);
			image.setAbsolutePosition(100f, 700f);

			for(int i=1; i<= pdfReader.getNumberOfPages(); i++)
			{
				PdfContentByte content = pdfStamper.getUnderContent(i);
				content.addImage(image);
			}

			pdfStamper.close();

		  } catch (IOException e) {
			e.printStackTrace();
		  } catch (DocumentException e) {
			e.printStackTrace();
		  }
		}
}