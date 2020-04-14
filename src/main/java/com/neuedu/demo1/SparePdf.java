package com.neuedu.demo1;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SparePdf {

    public static void main(String[] args) {
        String url = "E://test/333.pdf";
        try {
            pdfToP(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String str = "   abc    \r\n        def   \r\n    ghi    mnopq      r       s ";
//        StringTokenizer pas = new StringTokenizer(str," ");
//
//        str = ""; //这里清空了str，但StringTokenizer对象中已经保留了原来字符串的内容。
//        while (pas.hasMoreTokens()) {
//            String s = pas.nextToken();
//            str = str + s + " ";
//        }
//        System.out.println("[" + str.trim() + "]");

    }

    public static void pdfToT(String url) {
        //创建PdfDocument实例

        PdfDocument doc = new PdfDocument();

        //加载PDF文件

        doc.loadFromFile(url);

        //创建StringBuilder实例

        StringBuilder sb = new StringBuilder();

        PdfPageBase page;

        //遍历PDF页面，获取每个页面的文本并添加到StringBuilder对象

        for (int i = 0; i < doc.getPages().getCount(); i++) {

            page = doc.getPages().get(i);

            sb.append(page.extractText(true));

        }
        System.out.println(sb.toString());

        FileWriter writer;

        try {

            //将StringBuilder对象中的文本写入到文本文件

            writer = new FileWriter("E://test/222.txt");

            writer.write(sb.toString());

            writer.flush();

        } catch (IOException e) {

            e.printStackTrace();

        }

        doc.close();

    }

    public static void pdfToP(String url) throws IOException {
        //创建PdfDocument实例

        PdfDocument doc = new PdfDocument();

        //定义一个int型变量
        int index = 0;

        //实例化StringBuilder类
        StringBuilder sb = new StringBuilder();

        //加载PDF文件
        doc.loadFromFile(url);

        //遍历PDF文档中每页
        PdfPageBase page;

        Pattern p = Pattern.compile("(\r?\n(\\s*\r?\n)+)");

        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // 实例化一个Spire.Pdf.PdfPageBase对象
            page = doc.getPages().get(i);
            //调用extractText()方法提取文本
            sb.append(page.extractText(true));
            FileWriter writer;
            try {
                //将StringBuilder对象中的文本写入到txt
                writer = new FileWriter("E://test/333.txt");
                Matcher m = p.matcher(sb.toString());
                writer.write(m.replaceAll(" ")
                        .replaceAll(" +", " ")
                        .replaceAll("Evaluation Warning : The document was created with Spire.PDF for Java.", ""));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //调用extractImages方法获取图片
//            if(page.extractImages() != null){
//                for (BufferedImage image : page.extractImages()) {
//                    //指定输出图片名，指定图片格式
//                    File output = new File("E://test/" + String.format("Image_%d.png", index++));
//                    ImageIO.write(image, "PNG", output);
//                }
//            }

        }
        doc.close();

    }

}
