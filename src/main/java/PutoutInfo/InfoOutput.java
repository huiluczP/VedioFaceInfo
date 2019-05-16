package PutoutInfo;

import Distance.FaceToPerson;
import Faceget.Person;
import Faceget.PersonList;

import java.util.ArrayList;
import java.util.List;

public class InfoOutput {

    //计算并获取所有路人数据
    public WalkWayInfo getInfoByTime(int time, ArrayList<PersonList> personlists){
        WalkWayInfo whole=new WalkWayInfo();
        for(int i=0;i<personlists.size();i++){
            int timenow=time*i;
            PersonList temple=personlists.get(i);
            List<Person> person= FaceToPerson.toPersonOut(temple);
            PersonPerTime ppt=new PersonPerTime();
            ppt.setTime(timenow);
            ppt.setPersons(person);
            whole.getTimeLists().add(ppt);
        }
        return whole;
    }
}
