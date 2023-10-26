package uy.turismo.servidorcentral.logic.entities;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

import uy.turismo.servidorcentral.logic.daos.UserDAO;
import uy.turismo.servidorcentral.logic.daos.UserDAOImpl;

public class UserTest {

	@Test
	public void setImageTest() {
		UserDAO userDao = new UserDAOImpl();
		User user = userDao.findById(1L);
		User user2 = userDao.findById(1L);
		
		Boolean equality = user.equals(user2);
		System.out.println();
//		File file = new File("/home/prog-app/Imágenes/mirtha.png");
//		try {
//			BufferedImage image = ImageIO.read(file);
//			user.setImage(image);
//			
//		} catch (Exception e) {
//			System.err.println("Homar algo anda mal: " + e.getMessage());
//		}
	}
//	
//	@Test
//	public void imagesTest() {
//		try {
//			BufferedImage image = ImageIO.read(
//					new File("/home/prog-app/Imágenes/mirtha.png"));
//			File saveFile = new File("/home/prog-app/Escritorio/lachiqui.png");
//			
//			ImageIO.write(image, ".png", saveFile)
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//	}
	
	
}
