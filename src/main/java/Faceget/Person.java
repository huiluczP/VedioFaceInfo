package Faceget;

import Distance.DistanceCal;

public class Person
{
    private String age;
    private String gender;
    private double x;//图片上位置
    private double y;
    private double placex;//实际位置(先考虑二维)
    private double placey;
    private DistanceCal cal;

    public void setCal(DistanceCal cal) {
        this.cal=cal;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPlacex() {
        return placex;
    }

    public void setPlacex(double placex) {
        this.placex = placex;
    }

    public double getPlacey() {
        return placey;
    }

    public void setPlacey(double placey) {
        this.placey = placey;
    }

    public Person(){}
    public Person(String age,String gender,double x,double y) {
        this.age=age;
        this.gender=gender;
        this.x=x;
        this.y=y;
    }

    //计算实际位置，输入图片大小等信息
    public void calplace(double width,double height) {
        int []a=cal.calPlace();
        placex=a[0];
        placey=a[1];
    }
}
