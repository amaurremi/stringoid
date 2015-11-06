package intraProcTestPrograms;

public class ConstantUrl {

    public static void main(String[] args) {
        String url = "http://www.constant-url.com";
        System.out.println(url);

        Assertions.shouldContainHttp("www.constant-url.com");
    }
}
