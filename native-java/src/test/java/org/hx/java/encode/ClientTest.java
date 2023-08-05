package org.hx.java.encode;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ClientTest {

    public static final String STRING_CODE = "\\001";

    @SneakyThrows
    @Test
    public void name() {
        System.out.println(STRING_CODE);
        byte[] b1 = STRING_CODE.getBytes(); // 按系统默认编码转换，不推荐
        byte[] b2 = STRING_CODE.getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b3 = STRING_CODE.getBytes("GBK");
        System.out.println(b3);// 按GBK编码转换
        byte[] b4 = STRING_CODE.getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        System.out.println(b4);

        String s1 = new String(b1, "GBK"); // 按GBK转换
        System.out.println(s1);
        String s2 = new String(b1, StandardCharsets.UTF_8); // 按UTF-8转换
        System.out.println(s2);
    }

    @Test
    public void getSystemEncode() {
        // 获取当前系统编码
        System.out.println("系统默认编码：" + System.getProperty("file.encoding"));

    }

    @SneakyThrows
    @Test
    public void testWriteFile() {
        File f = new File(getDirectory() + File.separator + "test.txt");
        // 实例化输出流
        OutputStream out = new FileOutputStream(f);
        // 指定ISO8859-1编码
        byte b[] = "\\001".getBytes(StandardCharsets.UTF_16);
        // 保存转码之后的数据
        out.write(b);
        // 关闭输出流
        out.close();
    }


    @Test
    public void getFile() {
        System.out.println(getDirectory());
    }

    private String getDirectory() {
        String path = this.getClass().getClassLoader().getResource("log4j2-test.xml").getPath();
        String s = path.replaceAll("\\/", "\\\\\\\\");
        File directory = new File(path);//参数为空
        String courseFile = null;
        return directory.getParent();
    }
}