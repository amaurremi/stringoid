package failing.intra;

public class IfStatementOndrejExample {

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

        debug.Assertions.shouldContainHttp("a.com/a");
        debug.Assertions.shouldContainHttp("a.com/c/a");
    }
}
