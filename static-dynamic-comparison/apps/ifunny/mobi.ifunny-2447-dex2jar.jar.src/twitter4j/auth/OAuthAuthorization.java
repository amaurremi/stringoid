package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.Logger;
import twitter4j.RequestMethod;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

public class OAuthAuthorization
        implements Serializable, Authorization, OAuthSupport {
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final HttpParameter OAUTH_SIGNATURE_METHOD = new HttpParameter("oauth_signature_method", "HMAC-SHA1");
    private static final Random RAND = new Random();
    private static transient HttpClient http;
    private static final Logger logger = Logger.getLogger(OAuthAuthorization.class);
    private static final long serialVersionUID = -886869424811858868L;
    private final Configuration conf;
    private String consumerKey = "";
    private String consumerSecret;
    private OAuthToken oauthToken = null;
    private String realm = null;

    public OAuthAuthorization(Configuration paramConfiguration) {
        this.conf = paramConfiguration;
        http = HttpClientFactory.getInstance(paramConfiguration.getHttpClientConfiguration());
        setOAuthConsumer(paramConfiguration.getOAuthConsumerKey(), paramConfiguration.getOAuthConsumerSecret());
        if ((paramConfiguration.getOAuthAccessToken() != null) && (paramConfiguration.getOAuthAccessTokenSecret() != null)) {
            setOAuthAccessToken(new AccessToken(paramConfiguration.getOAuthAccessToken(), paramConfiguration.getOAuthAccessTokenSecret()));
        }
    }

    static String constructRequestURL(String paramString) {
        int i = paramString.indexOf("?");
        String str1 = paramString;
        if (-1 != i) {
            str1 = paramString.substring(0, i);
        }
        i = str1.indexOf("/", 8);
        String str2 = str1.substring(0, i).toLowerCase();
        int j = str2.indexOf(":", 8);
        paramString = str2;
        if (-1 != j) {
            if ((!str2.startsWith("http://")) || (!str2.endsWith(":80"))) {
                break label110;
            }
            paramString = str2.substring(0, j);
        }
        for (; ; ) {
            return paramString + str1.substring(i);
            label110:
            paramString = str2;
            if (str2.startsWith("https://")) {
                paramString = str2;
                if (str2.endsWith(":443")) {
                    paramString = str2.substring(0, j);
                }
            }
        }
    }

    public static String encodeParameters(List<HttpParameter> paramList) {
        return encodeParameters(paramList, "&", false);
    }

    public static String encodeParameters(List<HttpParameter> paramList, String paramString, boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            HttpParameter localHttpParameter = (HttpParameter) paramList.next();
            if (!localHttpParameter.isFile()) {
                if (localStringBuilder.length() != 0) {
                    if (paramBoolean) {
                        localStringBuilder.append("\"");
                    }
                    localStringBuilder.append(paramString);
                }
                localStringBuilder.append(HttpParameter.encode(localHttpParameter.getName())).append("=");
                if (paramBoolean) {
                    localStringBuilder.append("\"");
                }
                localStringBuilder.append(HttpParameter.encode(localHttpParameter.getValue()));
            }
        }
        if ((localStringBuilder.length() != 0) && (paramBoolean)) {
            localStringBuilder.append("\"");
        }
        return localStringBuilder.toString();
    }

    private void ensureTokenIsAvailable() {
        if (this.oauthToken == null) {
            throw new IllegalStateException("No Token available.");
        }
    }

    private static String normalizeRequestParameters(List<HttpParameter> paramList) {
        Collections.sort(paramList);
        return encodeParameters(paramList);
    }

    static String normalizeRequestParameters(HttpParameter[] paramArrayOfHttpParameter) {
        return normalizeRequestParameters(toParamList(paramArrayOfHttpParameter));
    }

    private void parseGetParameters(String paramString, List<HttpParameter> paramList) {
        int i = 0;
        int j = paramString.indexOf("?");
        if (-1 != j) {
            paramString.split("&");
            paramString = paramString.substring(j + 1).split("&");
        }
        for (; ; ) {
            try {
                j = paramString.length;
                if (i < j) {
                    String[] arrayOfString = paramString[i].split("=");
                    if (arrayOfString.length == 2) {
                        paramList.add(new HttpParameter(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8")));
                    } else {
                        paramList.add(new HttpParameter(URLDecoder.decode(arrayOfString[0], "UTF-8"), ""));
                    }
                }
            } catch (UnsupportedEncodingException paramString) {
            }
            return;
            i += 1;
        }
    }

    private static List<HttpParameter> toParamList(HttpParameter[] paramArrayOfHttpParameter) {
        ArrayList localArrayList = new ArrayList(paramArrayOfHttpParameter.length);
        localArrayList.addAll(Arrays.asList(paramArrayOfHttpParameter));
        return localArrayList;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof OAuthSupport)) {
                return false;
            }
            paramObject = (OAuthAuthorization) paramObject;
            if (this.consumerKey != null) {
                if (this.consumerKey.equals(((OAuthAuthorization) paramObject).consumerKey)) {
                }
            } else {
                while (((OAuthAuthorization) paramObject).consumerKey != null) {
                    return false;
                }
            }
            if (this.consumerSecret != null) {
                if (this.consumerSecret.equals(((OAuthAuthorization) paramObject).consumerSecret)) {
                }
            } else {
                while (((OAuthAuthorization) paramObject).consumerSecret != null) {
                    return false;
                }
            }
            if (this.oauthToken == null) {
                break;
            }
        } while (this.oauthToken.equals(((OAuthAuthorization) paramObject).oauthToken));
        for (; ; ) {
            return false;
            if (((OAuthAuthorization) paramObject).oauthToken == null) {
                break;
            }
        }
    }

    String generateAuthorizationHeader(String paramString1, String paramString2, HttpParameter[] paramArrayOfHttpParameter, String paramString3, String paramString4, OAuthToken paramOAuthToken) {
        HttpParameter[] arrayOfHttpParameter = paramArrayOfHttpParameter;
        if (paramArrayOfHttpParameter == null) {
            arrayOfHttpParameter = new HttpParameter[0];
        }
        paramArrayOfHttpParameter = new ArrayList(5);
        paramArrayOfHttpParameter.add(new HttpParameter("oauth_consumer_key", this.consumerKey));
        paramArrayOfHttpParameter.add(OAUTH_SIGNATURE_METHOD);
        paramArrayOfHttpParameter.add(new HttpParameter("oauth_timestamp", paramString4));
        paramArrayOfHttpParameter.add(new HttpParameter("oauth_nonce", paramString3));
        paramArrayOfHttpParameter.add(new HttpParameter("oauth_version", "1.0"));
        if (paramOAuthToken != null) {
            paramArrayOfHttpParameter.add(new HttpParameter("oauth_token", paramOAuthToken.getToken()));
        }
        paramString3 = new ArrayList(paramArrayOfHttpParameter.size() + arrayOfHttpParameter.length);
        paramString3.addAll(paramArrayOfHttpParameter);
        if (!HttpParameter.containsFile(arrayOfHttpParameter)) {
            paramString3.addAll(toParamList(arrayOfHttpParameter));
        }
        parseGetParameters(paramString2, paramString3);
        paramString1 = new StringBuilder(paramString1).append("&").append(HttpParameter.encode(constructRequestURL(paramString2))).append("&");
        paramString1.append(HttpParameter.encode(normalizeRequestParameters(paramString3)));
        paramString1 = paramString1.toString();
        logger.debug("OAuth base string: ", paramString1);
        paramString1 = generateSignature(paramString1, paramOAuthToken);
        logger.debug("OAuth signature: ", paramString1);
        paramArrayOfHttpParameter.add(new HttpParameter("oauth_signature", paramString1));
        if (this.realm != null) {
            paramArrayOfHttpParameter.add(new HttpParameter("realm", this.realm));
        }
        return "OAuth " + encodeParameters(paramArrayOfHttpParameter, ",", true);
    }

    String generateAuthorizationHeader(String paramString1, String paramString2, HttpParameter[] paramArrayOfHttpParameter, OAuthToken paramOAuthToken) {
        long l = System.currentTimeMillis() / 1000L;
        return generateAuthorizationHeader(paramString1, paramString2, paramArrayOfHttpParameter, String.valueOf(RAND.nextInt() + l), String.valueOf(l), paramOAuthToken);
    }

    public List<HttpParameter> generateOAuthSignatureHttpParams(String paramString1, String paramString2) {
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = RAND.nextInt();
        ArrayList localArrayList1 = new ArrayList(5);
        localArrayList1.add(new HttpParameter("oauth_consumer_key", this.consumerKey));
        localArrayList1.add(OAUTH_SIGNATURE_METHOD);
        localArrayList1.add(new HttpParameter("oauth_timestamp", l1));
        localArrayList1.add(new HttpParameter("oauth_nonce", l2 + l1));
        localArrayList1.add(new HttpParameter("oauth_version", "1.0"));
        if (this.oauthToken != null) {
            localArrayList1.add(new HttpParameter("oauth_token", this.oauthToken.getToken()));
        }
        ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
        localArrayList2.addAll(localArrayList1);
        parseGetParameters(paramString2, localArrayList2);
        paramString1 = new StringBuilder(paramString1).append("&").append(HttpParameter.encode(constructRequestURL(paramString2))).append("&");
        paramString1.append(HttpParameter.encode(normalizeRequestParameters(localArrayList2)));
        localArrayList1.add(new HttpParameter("oauth_signature", generateSignature(paramString1.toString(), this.oauthToken)));
        return localArrayList1;
    }

    String generateSignature(String paramString) {
        return generateSignature(paramString, null);
    }

    /* Error */
    String generateSignature(String paramString, OAuthToken paramOAuthToken) {
        // Byte code:
        //   0: ldc 14
        //   2: invokestatic 358	javax/crypto/Mac:getInstance	(Ljava/lang/String;)Ljavax/crypto/Mac;
        //   5: astore 5
        //   7: aload_2
        //   8: ifnonnull +62 -> 70
        //   11: new 360	javax/crypto/spec/SecretKeySpec
        //   14: dup
        //   15: new 148	java/lang/StringBuilder
        //   18: dup
        //   19: invokespecial 149	java/lang/StringBuilder:<init>	()V
        //   22: aload_0
        //   23: getfield 275	twitter4j/auth/OAuthAuthorization:consumerSecret	Ljava/lang/String;
        //   26: invokestatic 203	twitter4j/HttpParameter:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   29: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   32: ldc -89
        //   34: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   40: invokevirtual 364	java/lang/String:getBytes	()[B
        //   43: ldc 14
        //   45: invokespecial 367	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
        //   48: astore_3
        //   49: aload 5
        //   51: aload_3
        //   52: invokevirtual 371	javax/crypto/Mac:init	(Ljava/security/Key;)V
        //   55: aload 5
        //   57: aload_1
        //   58: invokevirtual 364	java/lang/String:getBytes	()[B
        //   61: invokevirtual 375	javax/crypto/Mac:doFinal	([B)[B
        //   64: astore_1
        //   65: aload_1
        //   66: invokestatic 380	twitter4j/BASE64Encoder:encode	([B)Ljava/lang/String;
        //   69: areturn
        //   70: aload_2
        //   71: invokevirtual 384	twitter4j/auth/OAuthToken:getSecretKeySpec	()Ljavax/crypto/spec/SecretKeySpec;
        //   74: astore 4
        //   76: aload 4
        //   78: astore_3
        //   79: aload 4
        //   81: ifnonnull -32 -> 49
        //   84: new 360	javax/crypto/spec/SecretKeySpec
        //   87: dup
        //   88: new 148	java/lang/StringBuilder
        //   91: dup
        //   92: invokespecial 149	java/lang/StringBuilder:<init>	()V
        //   95: aload_0
        //   96: getfield 275	twitter4j/auth/OAuthAuthorization:consumerSecret	Ljava/lang/String;
        //   99: invokestatic 203	twitter4j/HttpParameter:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   102: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: ldc -89
        //   107: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: aload_2
        //   111: invokevirtual 387	twitter4j/auth/OAuthToken:getTokenSecret	()Ljava/lang/String;
        //   114: invokestatic 203	twitter4j/HttpParameter:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   117: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   120: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   123: invokevirtual 364	java/lang/String:getBytes	()[B
        //   126: ldc 14
        //   128: invokespecial 367	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
        //   131: astore_3
        //   132: aload_2
        //   133: aload_3
        //   134: invokevirtual 391	twitter4j/auth/OAuthToken:setSecretKeySpec	(Ljavax/crypto/spec/SecretKeySpec;)V
        //   137: goto -88 -> 49
        //   140: astore_1
        //   141: getstatic 55	twitter4j/auth/OAuthAuthorization:logger	Ltwitter4j/Logger;
        //   144: ldc_w 393
        //   147: aload_1
        //   148: invokevirtual 397	twitter4j/Logger:error	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   151: new 399	java/lang/AssertionError
        //   154: dup
        //   155: aload_1
        //   156: invokespecial 402	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   159: athrow
        //   160: astore_1
        //   161: getstatic 55	twitter4j/auth/OAuthAuthorization:logger	Ltwitter4j/Logger;
        //   164: ldc_w 404
        //   167: aload_1
        //   168: invokevirtual 397	twitter4j/Logger:error	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   171: new 399	java/lang/AssertionError
        //   174: dup
        //   175: aload_1
        //   176: invokespecial 402	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
        //   179: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	180	0	this	OAuthAuthorization
        //   0	180	1	paramString	String
        //   0	180	2	paramOAuthToken	OAuthToken
        //   48	86	3	localObject	Object
        //   74	6	4	localSecretKeySpec	javax.crypto.spec.SecretKeySpec
        //   5	51	5	localMac	javax.crypto.Mac
        // Exception table:
        //   from	to	target	type
        //   0	7	140	java/security/InvalidKeyException
        //   11	49	140	java/security/InvalidKeyException
        //   49	65	140	java/security/InvalidKeyException
        //   70	76	140	java/security/InvalidKeyException
        //   84	137	140	java/security/InvalidKeyException
        //   0	7	160	java/security/NoSuchAlgorithmException
        //   11	49	160	java/security/NoSuchAlgorithmException
        //   49	65	160	java/security/NoSuchAlgorithmException
        //   70	76	160	java/security/NoSuchAlgorithmException
        //   84	137	160	java/security/NoSuchAlgorithmException
    }

    public String getAuthorizationHeader(HttpRequest paramHttpRequest) {
        return generateAuthorizationHeader(paramHttpRequest.getMethod().name(), paramHttpRequest.getURL(), paramHttpRequest.getParameters(), this.oauthToken);
    }

    public AccessToken getOAuthAccessToken() {
        ensureTokenIsAvailable();
        if ((this.oauthToken instanceof AccessToken)) {
            return (AccessToken) this.oauthToken;
        }
        this.oauthToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), null, this, null));
        return (AccessToken) this.oauthToken;
    }

    public AccessToken getOAuthAccessToken(String paramString) {
        ensureTokenIsAvailable();
        this.oauthToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), new HttpParameter[]{new HttpParameter("oauth_verifier", paramString)}, this, null));
        return (AccessToken) this.oauthToken;
    }

    public AccessToken getOAuthAccessToken(String paramString1, String paramString2) {
        try {
            String str2 = this.conf.getOAuthAccessTokenURL();
            String str1 = str2;
            if (str2.indexOf("http://") == 0) {
                str1 = "https://" + str2.substring(7);
            }
            this.oauthToken = new AccessToken(http.post(str1, new HttpParameter[]{new HttpParameter("x_auth_username", paramString1), new HttpParameter("x_auth_password", paramString2), new HttpParameter("x_auth_mode", "client_auth")}, this, null));
            paramString1 = (AccessToken) this.oauthToken;
            return paramString1;
        } catch (TwitterException paramString1) {
            throw new TwitterException("The screen name / password combination seems to be invalid.", paramString1, paramString1.getStatusCode());
        }
    }

    public AccessToken getOAuthAccessToken(RequestToken paramRequestToken) {
        this.oauthToken = paramRequestToken;
        return getOAuthAccessToken();
    }

    public AccessToken getOAuthAccessToken(RequestToken paramRequestToken, String paramString) {
        this.oauthToken = paramRequestToken;
        return getOAuthAccessToken(paramString);
    }

    public RequestToken getOAuthRequestToken() {
        return getOAuthRequestToken(null, null);
    }

    public RequestToken getOAuthRequestToken(String paramString) {
        return getOAuthRequestToken(paramString, null);
    }

    public RequestToken getOAuthRequestToken(String paramString1, String paramString2) {
        if ((this.oauthToken instanceof AccessToken)) {
            throw new IllegalStateException("Access token already available.");
        }
        ArrayList localArrayList = new ArrayList();
        if (paramString1 != null) {
            localArrayList.add(new HttpParameter("oauth_callback", paramString1));
        }
        if (paramString2 != null) {
            localArrayList.add(new HttpParameter("x_auth_access_type", paramString2));
        }
        this.oauthToken = new RequestToken(http.post(this.conf.getOAuthRequestTokenURL(), (HttpParameter[]) localArrayList.toArray(new HttpParameter[localArrayList.size()]), this, null), this);
        return (RequestToken) this.oauthToken;
    }

    public int hashCode() {
        int k = 0;
        int i;
        if (this.consumerKey != null) {
            i = this.consumerKey.hashCode();
            if (this.consumerSecret == null) {
                break label64;
            }
        }
        label64:
        for (int j = this.consumerSecret.hashCode(); ; j = 0) {
            if (this.oauthToken != null) {
                k = this.oauthToken.hashCode();
            }
            return (j + i * 31) * 31 + k;
            i = 0;
            break;
        }
    }

    public boolean isEnabled() {
        return (this.oauthToken != null) && ((this.oauthToken instanceof AccessToken));
    }

    public void setOAuthAccessToken(AccessToken paramAccessToken) {
        this.oauthToken = paramAccessToken;
    }

    public void setOAuthConsumer(String paramString1, String paramString2) {
        if (paramString1 != null) {
            this.consumerKey = paramString1;
            if (paramString2 == null) {
                break label25;
            }
        }
        for (; ; ) {
            this.consumerSecret = paramString2;
            return;
            paramString1 = "";
            break;
            label25:
            paramString2 = "";
        }
    }

    public void setOAuthRealm(String paramString) {
        this.realm = paramString;
    }

    public String toString() {
        return "OAuthAuthorization{consumerKey='" + this.consumerKey + '\'' + ", consumerSecret='******************************************'" + ", oauthToken=" + this.oauthToken + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/auth/OAuthAuthorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */