import Distance.DistanceCal;
import Faceget.FaceInfo;
import Faceget.JSONChange;
import Faceget.PersonList;
import PutoutInfo.InfoOutputAdapter;
import PutoutInfo.WalkWayInfo;
import VedioHandle.vedioModify;

import java.util.ArrayList;

public class Vediotest {
    public static void main(String[] args){
        int time=1;//时间间隔(秒数)

        vedioModify vm=new vedioModify();
        String vediopath="E:/学校/作业/创新实践/vediotest.mp4";
        ArrayList<String> picpathes=vm.vedioprocess(vediopath,time);//处理视频

        //存放base码
        ArrayList<String> pics=new ArrayList<String>();
        for(String s:picpathes){
            System.out.println(s);
            String base= imageCovertBase64.imageToBase64(s);
            pics.add(base);
            System.out.println(base);
            System.out.println("------");
        }

        //面部信息获取类
        FaceInfo faceAdapter=new FaceInfo();
        ArrayList<PersonList> personlists=faceAdapter.getPicinfo(pics);

        //面部信息转化为数据类
        double width=1920;
        double height=1024;
        InfoOutputAdapter adapter=new InfoOutputAdapter();
        WalkWayInfo info=adapter.getInfoByTime(time,personlists,new DistanceCal(),width,height);

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
