package interproc;
public class FieldReadWrite {

    private String url = getDomain();
    private static String fullUrl;

    public static void main(String[] args) {
        FieldReadWrite frw = new FieldReadWrite();
        frw.url = new StringBuilder(frw.url).append("/path1").toString();
        f();

        System.out.println(fullUrl);

        Assertions.shouldContainHttp("field-read-write.com/path1/path2");
    }

    static void f() {
        FieldReadWrite frw = new FieldReadWrite();
        fullUrl = new StringBuilder(frw.url).append("/path2").toString();
    }

    String getDomain() {
        return "http://field-read-write.com";
    }
}

///// main()
///// constants: 11 = path1
//
// 2 = new FRW
// 7 = new SB
// 9 = getField url
// 7(9)
// 6 = 7.append(11)
// 5 = 6.toString
// putfield url = 5
// f()


///// f()
///// constants: 10 -> /path2hg
//
// 1 = new FR
// FR()
// 6 = new SB
// 8 = getfield url
// SB(8)
// 5 = 6.append(10)
// 4 = 6.toString

///// FRW.init
//
// invokespecial Object.init
// 4 = getDomain
// putfield url = 4