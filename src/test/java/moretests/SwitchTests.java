package moretests;

import interproc.StringBuilderParam;

/**
 * Created by witternj on 10/26/16.
 */
public class SwitchTests {
    public static void main(String[] args) {
        String baseUrl = "https://api.test.com";
        String basePath = "/v1";

        StringBuilder sb = new StringBuilder(baseUrl);

        sb = appendToSb(sb, basePath);

        sb = appendToSbCases(sb, "users");

        Assertions.shouldContainHttp("api.test.com/v1");
        Assertions.shouldContainHttp("api.test.com/v1/users");
        Assertions.shouldContainHttp("api.test.com/v1/products");
    }

    public static StringBuilder appendToSb (StringBuilder sb, String element) {
        return sb.append(element);
    }

    public static StringBuilder appendToSbCases (StringBuilder sb, String condition) {
        switch (condition) {
            case "users":
                sb.append("/users");
                break;
            case "products":
                sb.append("/products");
                break;
            default:
                break;
        }
        return sb;
    }

}
