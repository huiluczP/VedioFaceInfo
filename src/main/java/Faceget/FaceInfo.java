package Faceget;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

//通过api获取人脸信息集合
public class FaceInfo
{
    public static final String APP_ID = "15777694";
    public static final String API_KEY = "wwGNqV5lqhK2HsoXnho59B5f";
    public static final String SECRET_KEY = "tDPkipSES3gLUMIz9tBYsgcobiGorIOz";
    private AipFace client;
    public FaceInfo()
    {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    }

    //获取一系列图片信息
    public ArrayList<PersonList> getPicinfo(ArrayList<String> pics)//参数为图片base64码
    {
        ArrayList<PersonList> personLists=new ArrayList<PersonList>();
        for(int i=0;i<pics.size();i++)
        {
            String base=pics.get(i);

            HashMap<String, String> options = new HashMap<String, String>();
            options.put("face_field", "age");//获取年龄
            options.put("face_field", "gender");//获取性别
            JSONObject res = client.detect(base,"BASE64", options);
            System.out.println(res.toString());

            Object result=res.get("result");
            String resultstr=result.toString();
            System.out.println(resultstr);

            try {
                PersonList per = (PersonList) JSONChange.jsonToObj(new PersonList(), resultstr);
                personLists.add(per);
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        }
        return personLists;
    }
}
