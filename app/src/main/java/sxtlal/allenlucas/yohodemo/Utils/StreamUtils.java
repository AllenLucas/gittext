package sxtlal.allenlucas.yohodemo.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class StreamUtils {
    public static String getStringFromSteam(InputStream inputStream) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while (((line = br.readLine()) != null)) {
            sb.append(line);
        }
        return sb.toString();
    }
}
