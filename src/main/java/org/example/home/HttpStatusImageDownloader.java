package org.example.home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException {
        String url = new HttpStatusChecker().getStatusImage(code);
        try(InputStream in = new URL(url).openStream()) {
            if(!Files.exists(Path.of("cats"))){
                Files.createDirectories(Path.of("cats"));
            }

            String path = new StringBuilder(Utils.DIRECTORY_TO_SAVE).append(code).append(Utils.EXTENSION).toString();
            if(!new File(path).exists()){
                Files.copy(in, Paths.get(path));
            } else {
                System.out.println(String.format(Utils.FILE_ALREADY_EXIST_TEXT, code));
            }
        } catch (Exception e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    static void main(String[] args) {
        HttpStatusImageDownloader d = new HttpStatusImageDownloader();
        try {
            d.downloadStatusImage(200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
