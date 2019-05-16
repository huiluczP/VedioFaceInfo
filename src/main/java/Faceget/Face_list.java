package Faceget;

public class Face_list {
    private String face_token;
    private double age;
    private Location location;
    private Gender gender;
    private Angle angle;
    private double face_probability;

    public double getFace_probability() {
        return face_probability;
    }

    public void setFace_probability(double face_probability) {
        this.face_probability = face_probability;
    }

    public Angle getAngle() {
        return angle;
    }

    public void setAngle(Angle angle) {
        this.angle = angle;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
