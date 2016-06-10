package interproc;

public class DynamicDispatch {

    public static void main(String[] args) {
        DynamicDispatch d = args == null ? new DynamicDispatchBaby() : new DynamicDispatch();
        String url = new StringBuilder(d.getDomain("http://")).append("/path").toString();

        System.out.println(url);

        Assertions.shouldContainHttp("dynamic-dispatch.com/path");
        Assertions.shouldContainHttp("dynamic-dispatch-baby.com/path");
    }

    String getDomain(String prefix) {
        return new StringBuilder(prefix).append("dynamic-dispatch.com").toString();
    }
}

class DynamicDispatchBaby extends DynamicDispatch {

    String getDomain(String prefix) {
        return new StringBuilder(prefix).append("dynamic-dispatch-baby.com").toString();
    }
}
