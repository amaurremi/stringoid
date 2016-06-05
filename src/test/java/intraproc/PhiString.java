package intraproc;

public class PhiString {

    public static void main(String[] args) {
        String http = "http://";
        String domain = args[0] == null ? "phi-string.com" : "phi-string.ca";
        StringBuilder sb = new StringBuilder();
        sb.append(http);
        sb.append(domain);
        sb.append("/path");

        Assertions.shouldContainHttp("phi-string.com/path");
        Assertions.shouldContainHttp("phi-string.ca/path");
    }
}

// 11 = new SB
// 11 = SB(8)
// 14 = 11.append(2)
// 16 = 11.append(3)
// 18 = 11.append(19)

// 2 = "http://"
// 9 = "phi-string.com"
// 10 = "phi-string.ca"
// 19 = "path"