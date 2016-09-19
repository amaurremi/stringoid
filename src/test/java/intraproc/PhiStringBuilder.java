package intraproc;

public class PhiStringBuilder {

    public static void main(String[] args) {
        String http = "http://";
        String domain1 = "phi-string-builder-1.com";
        String domain2 = "phi-string-builder-2.com";
        String url1 = new StringBuilder(http).append(domain1).toString();
        String url2 = new StringBuilder(http).append(domain2).toString();
        StringBuilder sb = args == null ? new StringBuilder(url1) : new StringBuilder(url2);
        sb.append("/path");

        Assertions.shouldContainHttp("phi-string-builder-1.com/path");
        Assertions.shouldContainHttp("phi-string-builder-2.com/path");
    }
}
