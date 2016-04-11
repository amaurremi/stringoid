package interproc;

public class StringReturn2 {

    public static void main(String[] args) {
        String domain = getDomain();
        StringBuilder sb = new StringBuilder(domain);
        sb.append("/path");

        System.out.println(sb);

        Assertions.shouldContainHttp("string-return-2.com");
        Assertions.shouldContainHttp("string-return-2.com/path");
    }

    static String getDomain() {
        StringBuilder sb = new StringBuilder("http://string-return-2.com");
        return sb.toString();
//        return "http://string-param-and-return.com";
    }
}

//    main {
//        2 = getDomain
//        4 = new SB
//        4.append 2
//        4.append 8
//    }
//
//    getDomain {
//        1 = new SB
//        1.append 3
//        5 = 1.toString
//        return 5
//    }