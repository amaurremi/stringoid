package oauth.signpost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import oauth.signpost.http.HttpParameters;

public class a {
    private static final com.google.a.a.a.a.a a = new com.google.a.a.a.a.a("-._~", false);

    public static String a(String paramString) {
        if (paramString == null) {
            return "";
        }
        return a.a(paramString);
    }

    public static HttpParameters a(InputStream paramInputStream)
            throws IOException {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
        StringBuilder localStringBuilder = new StringBuilder();
        for (paramInputStream = localBufferedReader.readLine(); paramInputStream != null; paramInputStream = localBufferedReader.readLine()) {
            localStringBuilder.append(paramInputStream);
        }
        return c(localStringBuilder.toString());
    }

    public static void a(String paramString1, String paramString2) {
        if (System.getProperty("debug") != null) {
            System.out.println("[SIGNPOST] " + paramString1 + ": " + paramString2);
        }
    }

    public static String b(String paramString) {
        if (paramString == null) {
            return "";
        }
        try {
            paramString = URLDecoder.decode(paramString, "UTF-8");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            throw new RuntimeException(paramString.getMessage(), paramString);
        }
    }

    public static HttpParameters c(String paramString) {
        HttpParameters localHttpParameters = new HttpParameters();
        if (d(paramString)) {
            return localHttpParameters;
        }
        String[] arrayOfString = paramString.split("\\&");
        int j = arrayOfString.length;
        int i = 0;
        if (i < j) {
            paramString = arrayOfString[i];
            int k = paramString.indexOf('=');
            String str;
            if (k < 0) {
                str = b(paramString);
            }
            for (paramString = null; ; paramString = b(paramString.substring(k + 1))) {
                localHttpParameters.put(str, paramString);
                i += 1;
                break;
                str = b(paramString.substring(0, k));
            }
        }
        return localHttpParameters;
    }

    public static boolean d(String paramString) {
        return (paramString == null) || (paramString.length() == 0);
    }

    public static HttpParameters e(String paramString) {
        HttpParameters localHttpParameters = new HttpParameters();
        if ((paramString == null) || (!paramString.startsWith("OAuth "))) {
        }
        for (; ; ) {
            return localHttpParameters;
            paramString = paramString.substring("OAuth ".length()).split(",");
            int j = paramString.length;
            int i = 0;
            while (i < j) {
                String[] arrayOfString = paramString[i].split("=");
                localHttpParameters.put(arrayOfString[0].trim(), arrayOfString[1].replace("\"", "").trim());
                i += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */