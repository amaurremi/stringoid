package tmp;

public class AliasAnalysis {
    public static void main(String[] args) {

        StringBuilder a1 = new StringBuilder("http://a");
        StringBuilder a2 = new StringBuilder();
        StringBuilder a3 = new StringBuilder();
        StringBuilder a4 = new StringBuilder();
        while(args[0] == null) {
            StringBuilder a0 = new StringBuilder();
            a4 = a3.append("x");
            a3 = a2.append("y");
            a2 = a1.append("z");
            a1 = a0.append("a");
        }
//        Assertions.shouldContainHttp("a");
    }
}
