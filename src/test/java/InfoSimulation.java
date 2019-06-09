import Faceget.JSONChange;
import Faceget.Person;
import PutoutInfo.PersonPerTime;
import PutoutInfo.WalkWayInfo;

import java.util.ArrayList;
import java.util.List;

public class InfoSimulation {
    public static void main(String []args){
        List<Person> persons1=new ArrayList<Person>();
        Person person1=new Person();
        person1.setAge("20");
        person1.setGender("female");
        person1.setPlacex(20);
        person1.setPlacey(20);
        persons1.add(person1);

        List<Person> persons2=new ArrayList<Person>();
        Person person2=new Person();
        person2.setAge("20");
        person2.setGender("female");
        person2.setPlacex(20);
        person2.setPlacey(25);
        persons2.add(person2);

        List<Person> persons3=new ArrayList<Person>();
        Person person3=new Person();
        person3.setAge("20");
        person3.setGender("female");
        person3.setPlacex(20);
        person3.setPlacey(30);
        persons3.add(person3);

        List<PersonPerTime> ppts=new ArrayList<PersonPerTime>();
        PersonPerTime ppt1 = new PersonPerTime();
        ppt1.setTime(0);
        ppt1.setPersons(persons1);
        ppts.add(ppt1);

        PersonPerTime ppt2 = new PersonPerTime();
        ppt2.setTime(1);
        ppt2.setPersons(persons2);
        ppts.add(ppt2);

        PersonPerTime ppt3 = new PersonPerTime();
        ppt3.setTime(2);
        ppt3.setPersons(persons3);
        ppts.add(ppt3);

        WalkWayInfo wwi=new WalkWayInfo();
        wwi.setTimeLists(ppts);
        try {
            String result=JSONChange.objToJson(wwi);
            System.out.println(result);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
