package com.huazi.generator.common.util;

import java.net.URISyntaxException;

public class ResourceUtil {
    public static String resourcePath(String path){
        return ResourceUtil.class.getResource(path).getPath();
    }

    public static String projectPath(){
        return System.getProperty("user.dir");
    }

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("args = [" + projectPath() + "]");
        System.out.println("args = [" + projectPath().replace("\\","/") + "]");
    }
}
