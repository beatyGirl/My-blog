package com.tian.blog.util.file;

import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfUtil {

    private static String filePath;

    /**
     * html内容生成pdf文档
     * http://blog.csdn.net/zdtwyjp/article/details/5769353
     * @param content
     */
    public static void generateHtmlToPdf(String content) {
        FileOutputStream fos = null;
        filePath = "d:/test.pdf";
        try {
            fos = new FileOutputStream(new File(filePath));

            ITextRenderer renderer = new ITextRenderer();
            //解决中文问题
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.setDocumentFromString(content);
            renderer.layout();
            renderer.createPDF(fos);
            System.out.println("生成成功：" + filePath);
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
        StringBuffer content = new StringBuffer();
        content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"" +
                " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        content.append("<html xmlns=\"http://www.w3.org/1999/xhtml\"><head>" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +
                "<style type=\"text/css\" >body {font-family: SimSun;}</style>" +
                "</head><body>");
        content.append("<h1>上</h1></body></html>");
        generateHtmlToPdf(content.toString());
    }
}
