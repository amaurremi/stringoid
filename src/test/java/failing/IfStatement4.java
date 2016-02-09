package failing;

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

        intraProcTestPrograms.Assertions.shouldContainHttp("a.com/a");
        intraProcTestPrograms.Assertions.shouldContainHttp("a.com/c/a");
    }
}
