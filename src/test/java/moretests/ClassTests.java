package moretests;

/**
 * Created by witternj on 10/12/16.
 */
public class ClassTests {

    public static class User {
        String name;

        User (String name) {
            this.name = name;
        }

        public String getName () {
            return this.name;
        }

        public void setName (String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String url = "http://api.test.com/v1";
        StringBuilder sb = new StringBuilder(url);


        User user = new User("erikwittern");

        sb.append("?").append(createQuery("name", user.getName()));

//        System.out.println(sb.toString());

        Assertions.shouldContainHttp("api.test.com/v1");
        Assertions.shouldContainHttp("api.test.com/v1?");
        Assertions.shouldContainHttp("api.test.com/v1?name=erikwittern");
    }

    static String createQuery (String key, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append(key).append("=").append(value);
        return sb.toString();
    }

}
