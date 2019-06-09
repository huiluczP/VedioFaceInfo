/*
    视频处理产生personlist集合
    infooutput处理集合产生walkway
    jackson处理walkway输出json信息
 */

import Distance.DistanceCal;
import Faceget.FaceInfo;
import Faceget.JSONChange;
import Faceget.PersonList;
import PutoutInfo.InfoOutputAdapter;
import PutoutInfo.WalkWayInfo;
import org.bytedeco.javacpp.opencv_core;

import java.util.ArrayList;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;

public class WholeTest {
    public static void main(String []args){
        //间隔时间
        int pertime=1;

        String pic="E:/学校/作业/创新实践/test2.jpg";
        opencv_core.IplImage Image = cvLoadImage(pic,1);
        if(Image!=null)
            System.out.println(Image.width()+","+Image.height());

        double width=4032;
        double height=3024;

        /*
        //首先获取对应照片大小，之后进行person转换
        */

        String base= imageCovertBase64.imageToBase64(pic);
        ArrayList<String> pics=new ArrayList<String>();
        pics.add(base);

        //面部信息获取类
        FaceInfo faceAdapter=new FaceInfo();
        ArrayList<PersonList> personlists=faceAdapter.getPicinfo(pics);

        //面部信息转化为数据类
        InfoOutputAdapter adapter=new InfoOutputAdapter();
        WalkWayInfo info=adapter.getInfoByTime(pertime,personlists,new DistanceCal(),width,height);

        //Json显示
        try {
            String result= JSONChange.objToJson(info);
            System.out.println(result);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
