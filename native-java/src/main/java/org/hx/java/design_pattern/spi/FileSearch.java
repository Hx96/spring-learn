package org.hx.java.design_pattern.spi;

import java.util.List;

/**
 * @author kyle
 */
public class FileSearch implements Search {

    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索 "+keyword);
        return null;
    }
}
