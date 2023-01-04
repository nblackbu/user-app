package org.example;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("smile.jpg");
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "png", new File("smile.jpg"));

        //1.НАдо брать список форматов и проверять
        String[] extension = ImageIO.getWriterFileSuffixes();

        //2. Проверять, что файл находитя в списк енаших форматов
        ImageReader reader = null;
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
        if(iterator.hasNext()) reader = iterator.next();

        InputStream inputStream = new FileInputStream(new File("smile.jpeg"));
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        reader.setInput(imageInputStream, true);
        //считываем несколько изображений если это гиф
        BufferedImage bufferedImage = reader.read(reader.getNumImages(true));

    }
}