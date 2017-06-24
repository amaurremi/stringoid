package moretests;

import java.util.HashMap;

/**
 * Created by witternj on 10/12/16.
 */
public class HashMapTests {
    public static void main(String[] args) {
        String url = "http://api.maps.com/v2";
        StringBuilder sb = new StringBuilder(url);

        HashMap<String, String> paramMap = getParamMap();

        sb.append("?").append(getQuery(paramMap));

        System.out.println(sb.toString());

        Assertions.shouldContainHttp("api.maps.com/v2");
        Assertions.shouldContainHttp("api.maps.com/v2?");
        //Assertions.shouldContainHttp("api.maps.com/v2?param1=value1&param2=value2");
    }

    public static String getQuery (HashMap<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();

        for (HashMap.Entry<String, String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append("=").append(value).append("&");
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static HashMap<String, String> getParamMap () {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("param1", "value1");
        map.put("param2", "value2");
        return map;
    }
}
