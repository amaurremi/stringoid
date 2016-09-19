package interproc;


public class StringParamInstance {

    public static void main(String[] args) {
        StringParamInstance spi = new StringParamInstance();
        spi.f("http://", 1);
    }

    void f(String prefix, int x) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("string-param-instance.com");
        sb.append(x);
        System.out.println(sb);

        Assertions.shouldContainHttp("string-param-instance.com");
        Assertions.shouldContainHttp("string-param-instance.com1");
    }
}
