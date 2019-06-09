package Distance;

import Faceget.Face_list;
import Faceget.Person;
import Faceget.PersonList;

import java.util.ArrayList;
import java.util.List;

public class FaceToPerson {

    //输入为某时刻的personlist,包含数个面部信息，根据location和size计算对应相对位置，最终返回Person集合
    public static List<Person> toPersonOut(PersonList personlist,DistanceCal distance,double width,double height){
        List<Person> persons=new ArrayList<Person>();
        for(Face_list face:personlist.getFace_list())
        {
            //填入脸部数据，可修改
            Person person=new Person(String.valueOf(face.getAge()),face.getGender().getType(),face.getLocation().getHeight(),face.getLocation().getWidth());
            person.setFace(face);
            person.setCal(distance);

            double picwidth=width;
            double picheight=height;
            //调用位置计算,参数为对应的照片宽度和高度
            person.calplace(picwidth,picheight);
            persons.add(person);
        }
        return persons;
    }

}
