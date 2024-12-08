package com.stackroute.groundservice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageUtil {
    public static String encodeImageToBase64(String imagePath) throws IOException {
        File file = new File(imagePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] imageBytes = new byte[(int) file.length()];
        fileInputStream.read(imageBytes);
        fileInputStream.close();

        // Encode the image to base64
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}

