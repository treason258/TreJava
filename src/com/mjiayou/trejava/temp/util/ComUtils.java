package com.mjiayou.trejava.temp.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;

import javax.imageio.ImageIO;

public class ComUtils {
//	/**
//	 * 裁剪图片
//	 */
//	public static BufferedImage cropImage(BufferedImage inputImage, PointF cropCenter, float cropRadius) {
//		int x = (int) (cropCenter.x - cropRadius);
//		int y = (int) (cropCenter.y - cropRadius);
//		int targetWidth = (int) (cropRadius * 2);
//		int targetHeight = (int) (cropRadius * 2);
//		return cropImage(inputImage, x, y, targetWidth, targetHeight);
//	}

	/**
	 * 裁剪图片
	 */
	public static BufferedImage cropImage(BufferedImage inputImage, int x, int y, int targetWidth, int targetHeight) {
		try {
			int srcWidth = inputImage.getWidth();
			int srcHeight = inputImage.getHeight();

			if (srcWidth >= targetWidth && srcHeight >= targetHeight) {
				Image image = inputImage.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				ImageFilter cropFilter = new CropImageFilter(x, y, targetWidth, targetHeight);
				FilteredImageSource filteredImageSource = new FilteredImageSource(image.getSource(), cropFilter);
				Image tempImage = Toolkit.getDefaultToolkit().createImage(filteredImageSource);

				BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
				Graphics graphice = outputImage.getGraphics();
				graphice.drawImage(tempImage, 0, 0, null);// 绘制图片
				graphice.dispose();

				return outputImage;
			} else {
				return inputImage;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 保存图片
	 * 
	 * @param filePath
	 *            "/Users/treason/Downloads/img/" OR "src/img/"
	 */
	public static void savaImage(BufferedImage inputImage, String filePath, String filename) {
		try {
			File path = new File(filePath);
			if (!path.exists()) {
				path.mkdirs();
			}

			ImageIO.write(inputImage, "jpg", new File(path.getPath() + "/" + filename));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 保存图片
	 */
	public static void savaImage(BufferedImage inputImage, String filePath, String filename, int targetWidth, int targetHeight) {
		try {
			BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_BGR);

			Graphics2D graphice2D = (Graphics2D) outputImage.getGraphics();
			graphice2D.drawImage(inputImage, 0, 0, targetWidth, targetHeight, null); // 画图
			graphice2D.dispose();
			outputImage.flush();

			savaImage(outputImage, filePath, filename);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
