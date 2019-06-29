package com.zte.video.utils;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author:helloboy
 * Date:2019-06-29 13:43
 * Description:<描述>
 */
public class LocalMedia {
    static private String base = "D:\\Program Files (x86)\\3DHGAME\\videos";

    static private Map<Integer,String> map;
    static int id;

    public static void main(String[] args) {
//递归显示C盘下所有文件夹及其中文件
        Map<Integer, String> myMap = getLocalMediaMap();
        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            System.out.println("id: " + entry.getKey() + " url: " + entry.getValue());
        }

    }

    static public Map<Integer,String> getLocalMediaMap(){
        File root = new File(base);
        map = new TreeMap<>();
        id = 0;
        try {
            showAllFiles(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    static private void showAllFiles(File dir) throws Exception{
        File[] fs = dir.listFiles();
        for(int i=0; i<fs.length; i++){
            if (fs[i].isDirectory()) {
                try {
                    showAllFiles(fs[i]);
                } catch (Exception e) {
                }
            } else {
                String relativePath = fs[i].getPath().replace(base + "\\","");
                if (relativePath.endsWith(".mp4")||relativePath.endsWith(".MP4")) {
                    map.put(id++, relativePath);
                }else {
//                    System.out.println("cannot resolve :" + relativePath);
                }
            }
        }
    }


}
