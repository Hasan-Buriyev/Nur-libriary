package com.oss.nur.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class EncodingDecoding {
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();
    public static String decoding(String path)  {
        try {
            String image = Files.readString(Path.of(path));
            return decoding(image);
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String encoding(String path) {
        try {
            byte[] image = Files.readAllBytes(Path.of(path));
            return encoder.encodeToString(image);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
