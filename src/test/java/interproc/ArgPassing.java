package interproc;


public class ArgPassing {

    public static void main(String[] args) {
        f("http://", 1);

        Assertions.shouldContainHttp("arg-passing.com");
        Assertions.shouldContainHttp("arg-passing.com1");
    }

    static void f(String prefix, int x) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("arg-passing.com");
        g(sb, x);
    }
    
    static void g(StringBuilder sb, int x) {
        sb.append(x);
    }
}
