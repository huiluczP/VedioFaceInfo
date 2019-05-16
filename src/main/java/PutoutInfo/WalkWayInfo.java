package PutoutInfo;

import java.util.ArrayList;
import java.util.List;

public class WalkWayInfo {
    private List<PersonPerTime> TimeLists;

    public List<PersonPerTime> getTimeLists() {
        return TimeLists;
    }

    public void setTimeLists(List<PersonPerTime> timeLists) {
        TimeLists = timeLists;
    }

    public WalkWayInfo(){
        TimeLists=new ArrayList<PersonPerTime>();
    }
}
