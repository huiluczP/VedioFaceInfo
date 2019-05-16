import Faceget.FaceInfo;
import Faceget.PersonList;
import VedioHandle.vedioModify;

import java.util.ArrayList;

public class picTest {
    public static void main(String []args)
    {
        int time=60;//时间间隔(秒数)
        vedioModify vm=new vedioModify();
        String vediopath="E:/学校/作业/创新实践/test.mp4";
        vm.vedioprocess(vediopath,time);//处理视频

        String base= imageCovertBase64.imageToBase64("E:/学校/作业/创新实践/img_0.jpg");
        System.out.println(base);

        ArrayList<String> pics=new ArrayList<String>();
        pics.add(base);
        FaceInfo face=new FaceInfo();
        ArrayList<PersonList> personlists=face.getPicinfo(pics);
        for(PersonList p:personlists)
            System.out.println(p.getFace_list().get(0).getFace_token());
    }
}
