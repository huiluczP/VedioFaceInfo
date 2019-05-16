package Faceget;

import java.util.List;

public class PersonList {
    private int face_num;
    private List<Face_list> face_list;

    public int getFace_num() {
        return face_num;
    }

    public void setFace_num(int face_num) {
        this.face_num = face_num;
    }

    public List<Face_list> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<Face_list> face_list) {
        this.face_list = face_list;
    }
}
