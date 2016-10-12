package moretests;

import java.util.ArrayList;

// this example tests that stringoid can construct URLs out of parameters and method-return values
public class ArrayListTests {

    public static void main(String[] args) {
        String domain = getDomain("http://");
        StringBuilder sb = new StringBuilder(domain);

        sb.append(getPath(20));

        sb.append(getQuery(2));

//        System.out.println(sb.toString());

        Assertions.shouldContainHttp("erik.com");
        Assertions.shouldContainHttp("erik.com/big");
        Assertions.shouldContainHttp("erik.com/big?first=one");
        Assertions.shouldContainHttp("erik.com/big?first=one&second=two");
    }

    static String getDomain(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("erik.com");
        return sb.toString();
    }

    static String getPath(int limit) {
        if (limit > 10) {
            return "/big";
        }
        return "";
    }

    static String getQuery(int limit) {
        StringBuilder sb = new StringBuilder();
        sb.append("?");

        ArrayList<String> paramKeys = getParamKeys();
        ArrayList<String> paramValues = getParamValues();

        if (limit > 2) {
            limit = 2;
        }
        for (int i = 0; i < limit; i++) {
            sb.append(paramKeys.get(i));
            sb.append("=");
            sb.append(paramValues.get(i));
            if (i < limit - 1) {
                sb.append("&");
            }
        }

        return sb.toString();
    }

    static ArrayList<String> getParamKeys () {
        ArrayList<String> list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        return list;
    }

    static ArrayList<String> getParamValues () {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        return list;
    }
}
