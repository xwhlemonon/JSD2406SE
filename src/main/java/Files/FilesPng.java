package Files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesPng {
    public static final String PNG_PATH = "./new";

    public static void main(String[] args) throws IOException {
        File path = new File(PNG_PATH);
        File png = new File(PNG_PATH, "demo.png");
        File pngNew = new File(PNG_PATH, "pic02.png");
        if (!path.exists() || !path.isDirectory()) {
            System.out.println(path.mkdirs());
            return;
        }
        if (!png.exists()) {
            return;
        }
        if (!pngNew.exists()) {
            System.out.println(pngNew.createNewFile());
        }
        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(png.toPath()));
        BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(pngNew.toPath()));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }
}
