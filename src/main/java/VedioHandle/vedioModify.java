package VedioHandle;

import org.bytedeco.javacv.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class vedioModify
{
    public void testCamera() throws InterruptedException, FrameGrabber.Exception {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        while (true) {
            if (!canvas.isDisplayable()) {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(-1);//退出
            }

            Frame frame = grabber.grab();

            canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            Thread.sleep(50);//50毫秒刷新一次图像
        }
    }
    public ArrayList<String> vedioprocess(String vediopath,int time)
    {
        ArrayList<String> picpathes=new ArrayList<String>();

        int index=0;//图片序号
        Frame frame = null;
        FFmpegFrameGrabber ffg = new FFmpegFrameGrabber(vediopath);//视频帧处理
        try {
            ffg.start();
            int ftp = ffg.getLengthInFrames();//总帧数
            double t=ftp / ffg.getFrameRate() / time;
            System.out.println(ffg.grabKeyFrame());
            System.out.println("时长 " + t);

            BufferedImage bImage = null;
            System.out.println("开始运行视频提取帧，耗时较长");

            //截取每秒末尾的图片
            while (index < t-1) {
                //文件绝对路径+名字
                String fileName = vediopath.substring(0,vediopath.lastIndexOf("/")) + "/img_"+"aaa"+index+ ".jpg";
                System.out.println(fileName);
                picpathes.add(fileName);
                //文件储存对象
               File outPut = new File(fileName);
                //获取帧
                for(int i=0;i<ffg.getFrameRate();i++)
                        frame = ffg.grabImage();
                if (frame != null) {
                    ImageIO.write(FrameToBufferedImage(frame), "jpg", outPut);
                }
                index++;
            }
            System.out.println("============运行结束============");
            System.out.println(ffg.getImageHeight()+" "+ffg.getImageWidth());
            ffg.stop();
        } catch (IOException E) {
            System.out.println(E.toString());
        }
        finally{
            return picpathes;
        }
    }

    public static BufferedImage FrameToBufferedImage(Frame frame)
    {
        //创建BufferedImage对象
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        System.out.println(bufferedImage.getHeight()+" "+bufferedImage.getWidth() );
        return bufferedImage;
    }

}
