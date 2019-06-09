package Distance;

import Faceget.Face_list;

//计算位置类
public class DistanceCal {

    //考虑输入人脸参数和摄像头固定参数
    //返回数组包括相对x坐标和相对y坐标
    double focalLength=2.1;//焦距
    double px=0;//镜头x坐标
    double py=0;//镜头y坐标
    double dpi=96;//相机dpi(?)

    //vx0镜头左上顶点x方向矢量分量
    //vy0镜头左上顶点y方向矢量分量
    //vz0镜头左上顶点z方向矢量分量
    //vx1镜头右上顶点x方向矢量分量
    //vy1镜头右上顶点y方向矢量分量
    //vz1镜头右上顶点z方向矢量分量
    //vx2镜头左下顶点x方向矢量分量
    //vy2镜头左下顶点y方向矢量分量
    //vz2镜头左下顶点z方向矢量分量
    //vx3镜头右下顶点x方向矢量分量
    //vy3镜头右下顶点y方向矢量分量
    //vz3镜头右下顶点z方向矢量分量
    double vx0=6;
    double vy0=3.2;
    double vz0=2.4;
    double vx1=6;
    double vy1=-3.2;
    double vz1=2.4;
    double vx2=6;
    double vy2=3.2;
    double vz2=-2.4;
    double vx3=6;
    double vy3=-3.2;
    double vz3=-2.4;

    //faceWidth 人脸像素宽
    //oldFaceWidth 年龄对应实际宽
    //通过facelist类来获取
    double coefficient=30;

    //通过年龄分段返回人脸实际长度
    private double calOldFaceLength(double age){
        if (age<20)
            return 20;
        else
            return 20;
    }

    public double[] calPlace(double picwidth, double picheight, Face_list face){
        //左侧占比和上侧占比
        double locationLeft=(face.getLocation().getLeft()+(face.getLocation().getWidth()/2))/picwidth;
        double locationTop=(face.getLocation().getTop()+(face.getLocation().getHeight()/2))/picheight;

        double x=0.0,y=0.0;
        double vx=0.0,vy=0.0,vz=0.0;
        double distance=0.0;

        vx=getVx(vx0,vx1,vx2,vx3,locationLeft,locationTop);
        vy=getVy(vy0,vy1,vy2,vy3,locationLeft,locationTop);
        vz=getVz(vz0,vz1,vz2,vz3,locationLeft,locationTop);
        distance=getDistance(focalLength,face.getLocation().getWidth(),calOldFaceLength(face.getAge()),dpi,coefficient);
        x=getPositionX(px,vx,vy,vz,distance);
        y=getPositionY(py,vx,vy,vz,distance);

        double a[]={0,0};
        a[0]=-y;
        a[1]=x;
        return a;
    }

    double getVx(double vx0, double vx1, double vx2, double vx3, double locationLeft, double locationTop)
    {
        double vx = 0.0;
        vx=(1-locationTop)*(locationLeft*vx1 + (1 - locationLeft)*vx0) + locationTop*(locationLeft*vx3 + (1 - locationLeft)*vx2);
        return vx;
    }
    double getVy(double vy0, double vy1, double vy2, double vy3, double locationLeft, double locationTop)
    {
        double vy = 0.0;
        vy = (1 - locationTop)*(locationLeft*vy1 + (1 - locationLeft)*vy0) + locationTop*(locationLeft*vy3 + (1 - locationLeft)*vy2);
        return vy;
    }
    double getVz(double vz0, double vz1, double vz2, double vz3, double locationLeft, double locationTop)
    {
        double vz = 0.0;
        vz = (1 - locationTop)*(locationLeft*vz1 + (1 - locationLeft)*vz0) + locationTop*(locationLeft*vz3 + (1 - locationLeft)*vz2);
        return vz;
    }

    double getDistance(double focalLength, double faceWidth, double oldFaceWidth,double dpi,double coefficient)
    {
        double distance = 0.0;
        distance = coefficient*focalLength*1.0*oldFaceWidth / 1.0 /(faceWidth/dpi*2.54);
        return distance;
    }

    double getPositionX(double px, double vx, double vy, double vz, double distance)
    {
        double x=0.0;
        x = px + distance*vx *1.0/ Math.sqrt(vx*vx + vy*vy + vz*vz);
        return x;
    }


    double getPositionY(double py, double vx, double vy, double vz, double distance)
    {
        double y=0.0;
        y=py+ distance*vy*1.0 / Math.sqrt(vx*vx + vy*vy + vz*vz);
        return y;
    }
}
