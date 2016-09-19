package interproc;


public class StringParamStatic {

    public static void main(String[] args) {
        f("http://", 1);
    }

    static void f(String prefix, int x) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("string-param-static.com");
        sb.append(x);
        System.out.println(sb);

        Assertions.shouldContainHttp("string-param-static.com");
        Assertions.shouldContainHttp("string-param-static.com1");
    }
}


// OUTDATED
// main
// f(3, 4)         // 3 -> "http://"

// f()
// 3 = new SB
// 3 = SB(1)
// 6 = 3.append(7)