import java.io.*;
import java.util.Base64;

public class imageCovertBase64
{
    public static String imageToBase64(String path) //生成base64
    {
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(data);
    }

    public static boolean base64ToImage(String base64Str, String path) //base64转图片
    {
        if (base64Str == null){
            return false;
        }
        try {
            byte[] bytes = Base64.getDecoder().decode(base64Str);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            File img = new File(path);
            if (!img.getParentFile().exists()) {
                img.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
