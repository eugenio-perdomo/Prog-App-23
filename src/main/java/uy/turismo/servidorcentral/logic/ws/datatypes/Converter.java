package uy.turismo.servidorcentral.logic.ws.datatypes;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class Converter {
	
	
	public static byte[] convertImageToArray(BufferedImage i) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
        	ImageIO.write(i, "png", baos);
        	return baos.toByteArray();
			
		} catch (Exception e) {
			System.err.println("Error al convertir imagen: " + e.getMessage());
		}
        
        return null;
	}
	
	public static String convertDateToString(LocalDate d) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return d.format(format);
	}
	
	public static String convertDateTimeToString(LocalDateTime dt) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		return dt.format(format);
		
	}
}
