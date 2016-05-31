package debug;

public class Append {

    public static void main(String[] args) {
        String url = "http://www.append.com";
        StringBuilder sb = new StringBuilder(url);
        sb.append("/path");

        System.out.println(sb);

        Assertions.shouldContainHttp("www.append.com/path");
    }
}

// 4 = new SB(2)
// 7 = 4.append(8)