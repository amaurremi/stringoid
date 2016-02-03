package com.flurry.sdk;

import android.net.Uri;
import android.text.TextUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import org.apache.http.client.utils.URIUtils;

public class cf {
    private static final Pattern a = Pattern.compile("/");

    public static String a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
        }
        do {
            return null;
            paramString = f(paramString);
        } while (paramString == null);
        return paramString.toString();
    }

    public static String a(String paramString1, String paramString2) {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        }
        Object localObject1;
        do {
            do {
                do {
                    do {
                        do {
                            return paramString1;
                            localObject1 = f(paramString1);
                        } while (localObject1 == null);
                        localObject1 = ((URI) localObject1).normalize();
                        paramString2 = f(paramString2);
                    } while (paramString2 == null);
                    localObject2 = paramString2.normalize();
                } while ((((URI) localObject1).isOpaque()) || (((URI) localObject2).isOpaque()));
                paramString2 = ((URI) localObject1).getScheme();
                localObject3 = ((URI) localObject2).getScheme();
            }
            while (((localObject3 == null) && (paramString2 != null)) || ((localObject3 != null) && (!((String) localObject3).equals(paramString2))));
            paramString2 = ((URI) localObject1).getAuthority();
            localObject3 = ((URI) localObject2).getAuthority();
        }
        while (((localObject3 == null) && (paramString2 != null)) || ((localObject3 != null) && (!((String) localObject3).equals(paramString2))));
        Object localObject3 = ((URI) localObject1).getPath();
        paramString2 = ((URI) localObject2).getPath();
        localObject3 = a.split((CharSequence) localObject3, -1);
        paramString2 = a.split(paramString2, -1);
        int m = localObject3.length;
        int n = paramString2.length;
        int i = 0;
        StringBuilder localStringBuilder;
        boolean bool1;
        for (; ; ) {
            if ((i >= n) || (i >= m) || (!localObject3[i].equals(paramString2[i]))) {
                paramString2 = ((URI) localObject1).getQuery();
                localObject1 = ((URI) localObject1).getFragment();
                localStringBuilder = new StringBuilder();
                if ((i != n) || (i != m)) {
                    break label372;
                }
                String str = ((URI) localObject2).getQuery();
                localObject2 = ((URI) localObject2).getFragment();
                bool1 = TextUtils.equals(paramString2, str);
                boolean bool2 = TextUtils.equals((CharSequence) localObject1, (CharSequence) localObject2);
                if ((!bool1) || (!bool2)) {
                    break label324;
                }
                localObject1 = null;
                paramString2 = null;
                localObject2 = localObject1;
                localObject3 = paramString2;
                label293:
                paramString2 = a(null, null, localStringBuilder.toString(), (String) localObject3, (String) localObject2);
                if (paramString2 == null) {
                    break;
                }
                return paramString2.toString();
            }
            i += 1;
        }
        label324:
        if ((bool1) && (!TextUtils.isEmpty((CharSequence) localObject1))) {
        }
        for (Object localObject2 = null; ; localObject2 = paramString2) {
            if ((TextUtils.isEmpty((CharSequence) localObject2)) && (TextUtils.isEmpty((CharSequence) localObject1))) {
                localStringBuilder.append(localObject3[(m - 1)]);
                break;
                label372:
                int j = i;
                int k;
                for (; ; ) {
                    k = i;
                    if (j >= n - 1) {
                        break;
                    }
                    localStringBuilder.append("..");
                    localStringBuilder.append("/");
                    j += 1;
                }
                while (k < m - 1) {
                    localStringBuilder.append(localObject3[k]);
                    localStringBuilder.append("/");
                    k += 1;
                }
                if (k < m) {
                    localStringBuilder.append(localObject3[k]);
                }
                localObject3 = paramString2;
                localObject2 = localObject1;
                if (localStringBuilder.length() != 0) {
                    break label293;
                }
                localStringBuilder.append(".");
                localStringBuilder.append("/");
                localObject3 = paramString2;
                localObject2 = localObject1;
                break label293;
            }
            paramString2 = (String) localObject2;
            break;
        }
    }

    private static URI a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        try {
            if (TextUtils.isEmpty(paramString1)) {
            }
            for (; ; ) {
                return new URI(paramString1, paramString2, paramString3, paramString4, paramString5);
                paramString1 = paramString1.toLowerCase();
            }
            return null;
        } catch (URISyntaxException paramString1) {
        }
    }

    public static String b(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
        }
        URI localURI;
        do {
            do {
                do {
                    return paramString;
                    localURI = f(paramString);
                } while (localURI == null);
                localURI = localURI.normalize();
            } while (localURI.isOpaque());
            localURI = a(localURI.getScheme(), localURI.getAuthority(), "/", null, null);
        } while (localURI == null);
        return localURI.toString();
    }

    public static String c(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
        }
        URI localURI;
        do {
            do {
                do {
                    return paramString;
                    localURI = f(paramString);
                } while (localURI == null);
                localURI = localURI.normalize();
            } while (localURI.isOpaque());
            localURI = URIUtils.resolve(localURI, "./");
        } while (localURI == null);
        return localURI.toString();
    }

    public static boolean d(String paramString) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
            paramString = Uri.parse(paramString);
            bool1 = bool2;
            if (paramString.getScheme() != null) {
                bool1 = bool2;
                if (paramString.getScheme().equals("market")) {
                    bool1 = true;
                }
            }
        }
        return bool1;
    }

    public static boolean e(String paramString) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
            paramString = Uri.parse(paramString);
            bool1 = bool2;
            if (paramString.getHost() != null) {
                bool1 = bool2;
                if (paramString.getHost().equals("play.google.com")) {
                    bool1 = bool2;
                    if (paramString.getScheme() != null) {
                        bool1 = bool2;
                        if (paramString.getScheme().startsWith("http")) {
                            bool1 = true;
                        }
                    }
                }
            }
        }
        return bool1;
    }

    /* Error */
    private static URI f(String paramString) {
        // Byte code:
        //   0: new 32	java/net/URI
        //   3: dup
        //   4: aload_0
        //   5: invokespecial 137	java/net/URI:<init>	(Ljava/lang/String;)V
        //   8: astore_1
        //   9: aload_1
        //   10: astore_0
        //   11: aload_1
        //   12: ifnull +27 -> 39
        //   15: aload_1
        //   16: invokevirtual 48	java/net/URI:getScheme	()Ljava/lang/String;
        //   19: aload_1
        //   20: invokevirtual 57	java/net/URI:getAuthority	()Ljava/lang/String;
        //   23: aload_1
        //   24: invokevirtual 60	java/net/URI:getPath	()Ljava/lang/String;
        //   27: aload_1
        //   28: invokevirtual 67	java/net/URI:getQuery	()Ljava/lang/String;
        //   31: aload_1
        //   32: invokevirtual 70	java/net/URI:getFragment	()Ljava/lang/String;
        //   35: invokestatic 82	com/flurry/sdk/cf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/net/URI;
        //   38: astore_0
        //   39: aload_0
        //   40: areturn
        //   41: astore_0
        //   42: aconst_null
        //   43: areturn
        //   44: astore_0
        //   45: aload_1
        //   46: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	47	0	paramString	String
        //   8	38	1	localURI	URI
        // Exception table:
        //   from	to	target	type
        //   0	9	41	java/net/URISyntaxException
        //   15	39	44	java/net/URISyntaxException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */