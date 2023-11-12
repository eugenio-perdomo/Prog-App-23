package uy.turismo.servidorcentral.logic.datatypes;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class Converter {

	public static BufferedImage convertArrayToBI(byte[] imgArray) {

		BufferedImage image = null;
		
		try{
			if(imgArray == null) {
				throw new NullPointerException("No hay imagen");
			}
           	InputStream inptuStream = new ByteArrayInputStream(imgArray);
           	image = ImageIO.read(inptuStream);
				
				 
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return image;
	}
	
	public static LocalDate convertStringToLD(String strDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(strDate, format);
	}
	
	public static LocalDateTime convertstringToLDT(String strDateTime) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		return LocalDateTime.parse(strDateTime, format);
	}
}
