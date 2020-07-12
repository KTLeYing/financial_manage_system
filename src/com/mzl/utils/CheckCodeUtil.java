package com.mzl.utils;

import com.sun.deploy.net.HttpResponse;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @ClassName :   CheckCodeUtil
 * @Description: 生成验证码工具类
 * @Author: 21989
 * @CreateDate: 2020/7/10 17:12
 * @Version: 1.0
 */
public class CheckCodeUtil {

    //随机对象
    private Random random = new Random();
    //随机字符串
    private String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int width = 96; //宽度
    private int height = 50; //高度
    private int lineSize = 50; //线数
    private int stringNum = 4;  //字符串的个数

    //随机生成图片
    public void getRanCode(HttpServletRequest request, HttpServletResponse response){
        //通知浏览器不要缓存
//        response.setHeader("Expires", "0");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");

        //创建图像缓冲区来缓存图像
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB );

        System.out.println("hhhhhh");
        //产生image的画笔graphices
        Graphics graphics = image.getGraphics();

        //画笔颜色
        graphics.setColor(getRanColor(50, 200));
        //填充框
        graphics.fillRect(0, 0, width, height);  //灰色的填充框

        // 设定图片边框
//        graphics.setColor(Color.GRAY);
//        graphics.drawRect(0, 0, width - 1, height - 1);

        //画笔重新换颜色(随机颜色)
//        graphics.setColor(getRanColor(50, 200));
        //绘制干扰线
        for (int i = 0; i < lineSize; i++) {
            graphics.setColor(getRanColor(50, 200));
            drawLine(graphics);

        }

        //绘制随机字符串
        String randomString = "";
        for (int i = 0; i < stringNum; i++) {
            randomString = drawString(graphics, randomString, i);
            System.out.println(randomString);
        }

        //创建一个session，用于保存验证码的值
        HttpSession session = request.getSession();
        //移除原来的会话,保证验证码一次性
        session.removeAttribute("checkCode");
        //设置新的验证码会话
        session.setAttribute("checkCode", randomString);

        //图像生效
        graphics.dispose();

        //将图片响应给浏览器
        try {
            ImageIO.write(image, "jpeg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //随机绘制字符串到图像，并返回字符串
    private String drawString(Graphics graphics, String randomString, int i) {
        graphics.setFont(getFont());
        graphics.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = getRandomString(random.nextInt(string.length()));
        System.out.println(rand);
        randomString = randomString + rand;
        graphics.translate(random.nextInt(3), random.nextInt(3));
        // 将认证码显示到图象中
        // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
        graphics.drawString(rand, width/5*i+8, height/2+5);  //此一条为正规通用的字符位置公式
//        graphics.drawString(rand, 13*i, 16);
//        graphics.drawString(rand, width/5*i,height/2);
//        graphics.drawString(rand, width/valcode.length()*i+2, 18);
//        graphics.drawString(rand, width/6 * (i + 1), 20);
        return randomString;
    }

    //随机
    private String getRandomString(int index) {
        return String.valueOf(string.charAt(index));
    }

    //设置字体
    private Font getFont() {
        return new Font("Fixedsys", Font.BOLD|Font.ITALIC, 26);
//        private String[] fontNames = { "宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312" };
//        Font[] fonts = {new Font("隶书",Font.BOLD,18),new Font("楷体",Font.BOLD,18),new Font("宋体",Font.BOLD,18),new Font("幼圆",Font.BOLD,18)};
//        g.setFont(new Font("宋体", Font.CENTER_BASELINE|Font.ITALIC, 25));
    }

    //画干扰线
    private void drawLine(Graphics graphics) {
        int x1 = random.nextInt(width);
        int y1 = random.nextInt(height);
        int x2 = random.nextInt(width);
        int y2 = random.nextInt(height);
        graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
//        graphics.drawLine(x1, y1, x2, y2);
//        int x2 = random.nextInt(width);
//        int y2 = random.nextInt(height);
    }

    //随机获取颜色
    private Color getRanColor(int fc, int bc) {
        //颜色值只能最大为255
        if (fc > 255){
            fc = 255;
        }
        if (bc > 255){
            bc = 255;
        }

        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);

//        int r = fc + random.nextInt(bc - fc);
//        int g = fc + random.nextInt(bc - fc);
//        int b = fc + random.nextInt(bc - fc);
        return new  Color(r, g, b);
    }

    //或 // 生成随机的颜色
    //    private Color randomColor() {
    //        int red = r.nextInt(150);
    //        int green = r.nextInt(150);
    //        int blue = r.nextInt(150);
    //        return new Color(red, green, blue);
    //    }




}
