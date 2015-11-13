package intraProcTestPrograms;

public class IfStatement4 {

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("http://a.com");
        StringBuilder b = new StringBuilder("http://b.com");
        StringBuilder c;
        if (args == null) {
            c = a;
        } else {
            c = b;
        }
        c.append("/c");
        a.append("/a");

        Assertions.shouldContainHttp("a.com/a");
        Assertions.shouldContainHttp("a.com/c/a");
    }
}
