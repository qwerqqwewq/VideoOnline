package com.zte.video.utils;

import com.zte.video.entity.Type;
import com.zte.video.entity.Video;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author helloboy
 * Date:2019-06-26 11:05
 * Description:<描述>
 */
public class MediaUtils {

    /**
     * 视频转码
     * @param ffmpegPath    转码工具的存放路径
     * @param upFilePath    用于指定要转换格式的文件,要截图的视频源文件
     * @param codcFilePath    格式转换后的的文件保存路径
     * @param mediaPicPath    截图保存路径
     * @param videoTime 视频时长，用于输出
     * @return 转码与截图是否成功
     * @throws Exception
     */
    public static boolean executeCodecs(String ffmpegPath, String upFilePath, String codcFilePath, String mediaPicPath,StringBuffer videoTime)throws Exception {
        // 创建一个List集合来保存转换视频文件为flv格式的命令
        List<String> convert = new ArrayList<String>();
        // 添加转换工具路径
        convert.add(ffmpegPath);
        // 添加参数＂-i＂，该参数指定要转换的文件
        convert.add("-i");
        // 添加要转换格式的视频文件的路径
        convert.add(upFilePath);
        //指定转换的质量
        convert.add("-qscale");
        convert.add("6");
        //设置音频码率
        convert.add("-ab");
        convert.add("64");
        //设置声道数
        convert.add("-ac");
        convert.add("2");
        //设置声音的采样频率
        convert.add("-ar");
        convert.add("22050");
        //设置帧频
        convert.add("-r");
        convert.add("24");
        // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
        convert.add("-y");
        convert.add(codcFilePath);

        // 创建一个List集合来保存从视频中截取图片的命令
        List<String> cutpic = new ArrayList<String>();
        cutpic.add(ffmpegPath);
        cutpic.add("-i");
        // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
        cutpic.add(upFilePath);
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        // 添加参数＂-ss＂，该参数指定截取的起始时间
        cutpic.add("-ss");
        // 添加起始时间为第17秒
        cutpic.add("3");
        // 添加参数＂-t＂，该参数指定持续时间
        cutpic.add("-t");
        // 添加持续时间为1毫秒
        cutpic.add("0.001");
        // 添加参数＂-s＂，该参数指定截取的图片大小
        cutpic.add("-s");
        // 添加截取的图片大小为350*240
        cutpic.add("350*240");
        // 添加截取的图片的保存路径
        cutpic.add(mediaPicPath);

        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command(convert);
            builder.redirectErrorStream(true);
            Process p = builder.start();

            videoTime.append(getVideoTime(p));
            System.out.println(videoTime);

            builder.command(cutpic);
            builder.redirectErrorStream(true);
            // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
            //因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
            builder.start();
        } catch (Exception e) {
            mark = false;
            e.printStackTrace();
        }
        return mark;
    }

    /**
     * 从request请求中上传文件
     * @param request servlet请求
     * @param video Video 的bean实例 在方法中将被填写
     * @return 回复值
     * @throws Exception
     */
    public static Map uploadMedia(HttpServletRequest request,Video video)
            throws Exception
    {

        //获取表单域
        //提供解析时的一些缺省配置
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置缓存路径
        String repoPath = request.getServletContext().getRealPath("videos")+"/temp";
        factory.setRepository(new File(repoPath));
        // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
        factory.setSizeThreshold(1024 * 1024);

        //创建一个解析器,分析InputStream,该解析器会将分析的结果封装成一个FileItem对象的集合
        //一个FileItem对象对应一个表单域
        ServletFileUpload sfu = new ServletFileUpload(factory);

        Map map = new HashMap(16);
        boolean flag = false;

        try {
            List<FileItem> items = sfu.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem item = items.get(i);
                //判断是否是视频
                if (item.isFormField()) {
                    //不是
                    //普通表单域
                    String paramName = item.getFieldName();
                    String paramValue = new String(item.getString().getBytes("ISO8859-1"),"UTF-8");
                    System.out.println("参数名称为:" + paramName + ", 对应的参数值为: " + paramValue);

                    if("title".equals(paramName)){
                        video.setTitle(paramValue);
                    }
                    if("intro".equals(paramName)){
                        video.setIntro(paramValue);
                    }
                    if("typeId".equals(paramName)) {
                        Type type = new Type();
                        type.setId(Integer.parseInt(paramValue));
                        video.setType(type);
                    }

                } else {
                    //是
                    //获取保存文件路径
                    ServletContext servletContext = request.getServletContext();
                    String basePath = servletContext.getRealPath("videos");
                    //获得文件路径
                    String fileUrl = item.getName();
                    //截取文件格式
                    String fileType = fileUrl.substring(fileUrl.lastIndexOf("."));
                    //产生唯一的识别码
                    String serialName = String.valueOf(System.currentTimeMillis());
                    //待转码的文件
                    File uploadFile = new File(basePath + "/temp/" + serialName + fileType);
                    item.write(uploadFile);
                    //如果视频大小大于500M
                    if (item.getSize() > 500 * 1024 * 1024) {
                        map.put("msg", "上传失败！上传的文件过大，系统最大允许500M");
                        System.out.println("上传失败！上传的文件过大，系统最大允许500M");
                        break;
                    }
                    //设置转换为flv格式后文件的保存路径
                    String codcFilePath = basePath + "/" + serialName + ".mp4";
                    //设置上传视频截图的保存路径
                    String mediaPicPath = basePath + "/images" +File.separator+ serialName + ".jpg";

                    //设置视频路径，视频路径为相对路径
                    video.setVideoPath("videos/"+serialName + ".mp4");
                    video.setPicPath("videos/images/" + serialName + ".jpg");

                    // 获取配置的转换工具（ffmpeg.exe）的存放路径
                    String ffmpegPath = request.getServletContext().getRealPath("/tools/ffmpeg.exe");
                    //转码并获得视频时长
                    StringBuffer videoTime = new StringBuffer("");
                    flag = executeCodecs(ffmpegPath, uploadFile.getAbsolutePath(), codcFilePath, mediaPicPath, videoTime);
                    System.out.println("参数名 视频转码后的时长 "+videoTime);
                    video.setVideoTime(videoTime.toString());
                    System.out.println("参数名 转码flag "+flag);
                    if (flag && map.get("msg")!=null) {
                        //如果转码成功且未超大小
                        map.put("msg", "上传成功");
                        System.out.println("上传成功");
                    }
                    //结束
                }
            }
        } catch (Exception e) {
            map.put("msg", "发生错误,上传失败");
            System.out.println("发生错误,上传失败");
            flag = false;
            e.printStackTrace();
        }finally {
            map.put("upload", flag);
        }
        return map;
        //End of function
    }

    public static String getVideoTime(final Process p) throws IOException {

        //从输入流中读取视频信息
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        //从视频信息中解析时长
        String regexDuration = "Duration: (.*), start";
        Pattern pattern = Pattern.compile(regexDuration);
        Matcher m = pattern.matcher(sb.toString());
        if (m.find()) {
            return m.group(1);
        }
        return "未知长度";
    }

    /**
     * 更改时长格式
     * 格式:"00:00:10.68"
     * @param timeLen 字符串型的时间长度
     * @return
     */
    private static int getTimeLen(String timeLen){
        int min=0;
        String strs[] = timeLen.split(":");
        if (strs[0].compareTo("0") > 0) {
            //秒
            min+=Integer.valueOf(strs[0])*60*60;
        }
        if(strs[1].compareTo("0")>0){
            min+=Integer.valueOf(strs[1])*60;
        }
        if(strs[2].compareTo("0")>0){
            min+=Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }
}
