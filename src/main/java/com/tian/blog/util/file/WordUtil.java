package com.tian.blog.util.file;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordUtil {

    private static String filePath;

    /**
     * html内容生成word文档
     * @param content ：html内容
     */
    public static void generateHtmlToWord(String content) {
        FileOutputStream fos = null;
        filePath = "d:/test.doc";
        try {
            fos = new FileOutputStream(new File(filePath));
            POIFSFileSystem fileSystem = new POIFSFileSystem();
            fileSystem.createDocument(new ByteArrayInputStream(content.getBytes("GBK")), "WordDocument");
            fileSystem.writeFilesystem(fos);
            System.out.println("已生成 : " + filePath);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        generateHtmlToWord("<html><body><h1>上</h1></body></html>");
    }
}
