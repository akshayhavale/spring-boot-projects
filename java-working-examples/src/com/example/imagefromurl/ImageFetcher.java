package com.example.imagefromurl;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFetcher {

	public static void main(String[] args) throws IOException {
//		URL url = new URL("https://ibb.co/47bxyQ8");
//		InputStream in = new BufferedInputStream(url.openStream());
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		byte[] buf = new byte[1024];
//		int n = 0;
//		while (-1 != (n = in.read(buf))) {
//			out.write(buf, 0, n);
//		}
//		out.close();
//		in.close();
//		byte[] response = out.toByteArray();
//		
//		
//		FileOutputStream fos = new FileOutputStream("/Users/akshayhavale/Downloads/check/check.jpg");
//		fos.write(response);
//		fos.close();
		
		
		
		Image image = null;
        try {
            URL url = new URL("https://ibb.co/47bxyQ8");
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
        
        
        
	}
	

}
