package PutoutInfo;

import Faceget.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonPerTime {
    private int time;//当前时间
    private List<Person> persons;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public PersonPerTime() {
        persons=new ArrayList<Person>();
    }
}
