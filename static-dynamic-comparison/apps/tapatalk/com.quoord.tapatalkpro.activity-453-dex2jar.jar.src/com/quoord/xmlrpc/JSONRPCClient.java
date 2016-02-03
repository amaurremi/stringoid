package com.quoord.xmlrpc;

import android.content.Context;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.UserAgent;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class JSONRPCClient {
    public static final int CALLMETHOD = 1;
    public static String tag = "XMLRPCClient";
    private HttpClient client;
    HttpEntity entity;
    ForumStatus forumStatus;
    private String isLogin;
    private SAXParser mSaxParser;
    private XMLReader mSaxReader;
    private URI mUri = null;
    HttpPost postMethod;
    HttpResponse response;

    public JSONRPCClient(String paramString) {
        this(URI.create(paramString));
    }

    public JSONRPCClient(URI paramURI) {
        this.mUri = paramURI;
        this.client = getThreadSafeHttpClient(this.mUri.toString());
        try {
            SAXParserFactory.newInstance().setValidating(false);
            this.mSaxParser = SAXParserFactory.newInstance().newSAXParser();
            this.mSaxReader = this.mSaxParser.getXMLReader();
            return;
        } catch (ParserConfigurationException paramURI) {
            paramURI.printStackTrace();
            return;
        } catch (SAXException paramURI) {
            paramURI.printStackTrace();
        }
    }

    public JSONRPCClient(URI paramURI, ForumStatus paramForumStatus) {
        this.mUri = paramURI;
        this.forumStatus = paramForumStatus;
        this.client = getThreadSafeHttpClient(this.mUri.toString());
        try {
            SAXParserFactory.newInstance().setValidating(false);
            this.mSaxParser = SAXParserFactory.newInstance().newSAXParser();
            this.mSaxReader = this.mSaxParser.getXMLReader();
            return;
        } catch (ParserConfigurationException paramURI) {
            paramURI.printStackTrace();
            return;
        } catch (SAXException paramURI) {
            paramURI.printStackTrace();
        }
    }

    public JSONRPCClient(URL paramURL) {
        this(URI.create(paramURL.toExternalForm()));
    }

    private Object callXMLRPC(String paramString, Object[] paramArrayOfObject)
            throws Exception {
        return null;
    }

    public static DefaultHttpClient getThreadSafeHttpClient(String paramString) {
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        try {
            if (paramString.startsWith("https")) {
                localObject = KeyStore.getInstance(KeyStore.getDefaultType());
                ((KeyStore) localObject).load(null, null);
                localObject = new MySSLSocketFactory((KeyStore) localObject);
                ((SSLSocketFactory) localObject).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                localSchemeRegistry.register(new Scheme("https", (SocketFactory) localObject, 443));
            }
            Object localObject = new BasicHttpParams();
            HttpProtocolParams.setVersion((HttpParams) localObject, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset((HttpParams) localObject, "UTF-8");
            localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            if (paramString.contains("android-log.tapatalk.com")) {
                HttpConnectionParams.setConnectionTimeout((HttpParams) localObject, 7000);
                HttpConnectionParams.setSoTimeout((HttpParams) localObject, 7000);
            }
            return new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams) localObject, localSchemeRegistry), (HttpParams) localObject);
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
    }

    public Object call(String paramString, Object[] paramArrayOfObject)
            throws Exception {
        return callXMLRPC(paramString, paramArrayOfObject);
    }

    public String getLoginStatus() {
        return this.isLogin;
    }

    /* Error */
    public Object parse()
            throws Exception {
        // Byte code:
        //   0: aload_0
        //   1: getfield 217	com/quoord/xmlrpc/JSONRPCClient:response	Lorg/apache/http/HttpResponse;
        //   4: ifnonnull +5 -> 9
        //   7: aconst_null
        //   8: areturn
        //   9: aload_0
        //   10: getfield 217	com/quoord/xmlrpc/JSONRPCClient:response	Lorg/apache/http/HttpResponse;
        //   13: ldc -37
        //   15: invokeinterface 225 2 0
        //   20: astore 4
        //   22: aload 4
        //   24: ifnull +12 -> 36
        //   27: iconst_0
        //   28: istore_1
        //   29: iload_1
        //   30: aload 4
        //   32: arraylength
        //   33: if_icmplt +243 -> 276
        //   36: aload_0
        //   37: getfield 217	com/quoord/xmlrpc/JSONRPCClient:response	Lorg/apache/http/HttpResponse;
        //   40: ldc -29
        //   42: invokeinterface 225 2 0
        //   47: astore 4
        //   49: aload 4
        //   51: ifnull +22 -> 73
        //   54: aload 4
        //   56: arraylength
        //   57: ifle +16 -> 73
        //   60: aload_0
        //   61: aload 4
        //   63: iconst_0
        //   64: aaload
        //   65: invokeinterface 232 1 0
        //   70: invokevirtual 235	com/quoord/xmlrpc/JSONRPCClient:setLoginStatus	(Ljava/lang/String;)V
        //   73: aload_0
        //   74: getfield 217	com/quoord/xmlrpc/JSONRPCClient:response	Lorg/apache/http/HttpResponse;
        //   77: ldc -19
        //   79: invokeinterface 225 2 0
        //   84: astore 4
        //   86: aload 4
        //   88: ifnull +22 -> 110
        //   91: aload 4
        //   93: arraylength
        //   94: ifle +16 -> 110
        //   97: aload_0
        //   98: aload 4
        //   100: iconst_0
        //   101: aaload
        //   102: invokeinterface 232 1 0
        //   107: invokevirtual 235	com/quoord/xmlrpc/JSONRPCClient:setLoginStatus	(Ljava/lang/String;)V
        //   110: aload_0
        //   111: getfield 217	com/quoord/xmlrpc/JSONRPCClient:response	Lorg/apache/http/HttpResponse;
        //   114: invokeinterface 241 1 0
        //   119: astore 4
        //   121: aload_0
        //   122: getfield 217	com/quoord/xmlrpc/JSONRPCClient:response	Lorg/apache/http/HttpResponse;
        //   125: ldc -13
        //   127: invokeinterface 225 2 0
        //   132: astore 5
        //   134: iconst_0
        //   135: istore_1
        //   136: aload 5
        //   138: arraylength
        //   139: istore_2
        //   140: iload_1
        //   141: iload_2
        //   142: if_icmplt +190 -> 332
        //   145: aload 4
        //   147: invokestatic 248	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
        //   150: invokevirtual 251	java/lang/String:trim	()Ljava/lang/String;
        //   153: astore 5
        //   155: aload_0
        //   156: getfield 253	com/quoord/xmlrpc/JSONRPCClient:postMethod	Lorg/apache/http/client/methods/HttpPost;
        //   159: invokevirtual 258	org/apache/http/client/methods/HttpPost:abort	()V
        //   162: aload_0
        //   163: getfield 62	com/quoord/xmlrpc/JSONRPCClient:client	Lorg/apache/http/client/HttpClient;
        //   166: invokeinterface 264 1 0
        //   171: invokeinterface 269 1 0
        //   176: aload_0
        //   177: getfield 62	com/quoord/xmlrpc/JSONRPCClient:client	Lorg/apache/http/client/HttpClient;
        //   180: invokeinterface 264 1 0
        //   185: invokeinterface 272 1 0
        //   190: aload 4
        //   192: invokeinterface 277 1 0
        //   197: aload_0
        //   198: getfield 279	com/quoord/xmlrpc/JSONRPCClient:entity	Lorg/apache/http/HttpEntity;
        //   201: invokeinterface 277 1 0
        //   206: aload 5
        //   208: areturn
        //   209: astore 6
        //   211: aload 6
        //   213: invokevirtual 207	java/lang/Exception:printStackTrace	()V
        //   216: aload 5
        //   218: areturn
        //   219: astore 5
        //   221: aload_0
        //   222: getfield 253	com/quoord/xmlrpc/JSONRPCClient:postMethod	Lorg/apache/http/client/methods/HttpPost;
        //   225: invokevirtual 258	org/apache/http/client/methods/HttpPost:abort	()V
        //   228: aload_0
        //   229: getfield 62	com/quoord/xmlrpc/JSONRPCClient:client	Lorg/apache/http/client/HttpClient;
        //   232: invokeinterface 264 1 0
        //   237: invokeinterface 272 1 0
        //   242: aload 4
        //   244: invokeinterface 277 1 0
        //   249: aload_0
        //   250: getfield 279	com/quoord/xmlrpc/JSONRPCClient:entity	Lorg/apache/http/HttpEntity;
        //   253: invokeinterface 277 1 0
        //   258: aload 5
        //   260: invokevirtual 207	java/lang/Exception:printStackTrace	()V
        //   263: aload 5
        //   265: athrow
        //   266: astore 4
        //   268: aload 4
        //   270: invokevirtual 207	java/lang/Exception:printStackTrace	()V
        //   273: aload 4
        //   275: athrow
        //   276: aload 4
        //   278: iload_1
        //   279: aaload
        //   280: invokeinterface 232 1 0
        //   285: ifnull +107 -> 392
        //   288: aload 4
        //   290: iload_1
        //   291: aaload
        //   292: invokeinterface 232 1 0
        //   297: invokevirtual 283	java/lang/String:length	()I
        //   300: ifle +92 -> 392
        //   303: aload_0
        //   304: new 285	java/util/StringTokenizer
        //   307: dup
        //   308: aload 4
        //   310: iload_1
        //   311: aaload
        //   312: invokeinterface 232 1 0
        //   317: ldc_w 287
        //   320: invokespecial 290	java/util/StringTokenizer:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   323: invokevirtual 293	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
        //   326: invokevirtual 296	com/quoord/xmlrpc/JSONRPCClient:setCookie	(Ljava/lang/String;)V
        //   329: goto +63 -> 392
        //   332: aload 5
        //   334: iload_1
        //   335: aaload
        //   336: invokeinterface 232 1 0
        //   341: ldc_w 298
        //   344: invokevirtual 301	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   347: istore_3
        //   348: iload_3
        //   349: ifeq +6 -> 355
        //   352: goto -207 -> 145
        //   355: iload_1
        //   356: iconst_1
        //   357: iadd
        //   358: istore_1
        //   359: goto -223 -> 136
        //   362: astore 6
        //   364: aload 6
        //   366: invokevirtual 207	java/lang/Exception:printStackTrace	()V
        //   369: goto -172 -> 197
        //   372: astore 4
        //   374: aload 4
        //   376: invokevirtual 207	java/lang/Exception:printStackTrace	()V
        //   379: goto -130 -> 249
        //   382: astore 4
        //   384: aload 4
        //   386: invokevirtual 207	java/lang/Exception:printStackTrace	()V
        //   389: goto -131 -> 258
        //   392: iload_1
        //   393: iconst_1
        //   394: iadd
        //   395: istore_1
        //   396: goto -367 -> 29
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	399	0	this	JSONRPCClient
        //   28	368	1	i	int
        //   139	4	2	j	int
        //   347	2	3	bool	boolean
        //   20	223	4	localObject1	Object
        //   266	43	4	localException1	Exception
        //   372	3	4	localException2	Exception
        //   382	3	4	localException3	Exception
        //   132	85	5	localObject2	Object
        //   219	114	5	localException4	Exception
        //   209	3	6	localException5	Exception
        //   362	3	6	localException6	Exception
        // Exception table:
        //   from	to	target	type
        //   197	206	209	java/lang/Exception
        //   145	190	219	java/lang/Exception
        //   211	216	219	java/lang/Exception
        //   364	369	219	java/lang/Exception
        //   0	7	266	java/lang/Exception
        //   9	22	266	java/lang/Exception
        //   29	36	266	java/lang/Exception
        //   36	49	266	java/lang/Exception
        //   54	73	266	java/lang/Exception
        //   73	86	266	java/lang/Exception
        //   91	110	266	java/lang/Exception
        //   110	134	266	java/lang/Exception
        //   136	140	266	java/lang/Exception
        //   221	242	266	java/lang/Exception
        //   258	266	266	java/lang/Exception
        //   276	329	266	java/lang/Exception
        //   332	348	266	java/lang/Exception
        //   374	379	266	java/lang/Exception
        //   384	389	266	java/lang/Exception
        //   190	197	362	java/lang/Exception
        //   242	249	372	java/lang/Exception
        //   249	258	382	java/lang/Exception
    }

    public Object parse(ContentHandler paramContentHandler, boolean paramBoolean)
            throws Exception {
        for (; ; ) {
            int i;
            try {
                if (this.response == null) {
                    return null;
                }
                Object localObject = this.response.getHeaders("Set-Cookie");
                if (localObject != null) {
                    i = 0;
                    if (i < localObject.length) {
                    }
                } else {
                    localObject = this.response.getHeaders("Mobiquo_is_login");
                    if ((localObject != null) && (localObject.length > 0)) {
                        setLoginStatus(localObject[0].getValue());
                    }
                    localObject = this.response.getHeaders("mobiquologin");
                    if ((localObject != null) && (localObject.length > 0)) {
                        setLoginStatus(localObject[0].getValue());
                    }
                    if ((this.forumStatus == null) || (Boolean.parseBoolean(this.isLogin) == this.forumStatus.isLogin()) || (!this.forumStatus.isLogin()) || (paramBoolean)) {
                        continue;
                    }
                    return null;
                }
                if ((localObject[i].getValue() != null) && (localObject[i].getValue().length() > 0)) {
                    setCookie(new StringTokenizer(localObject[i].getValue(), ";").nextToken());
                    break label337;
                    localObject = this.response.getEntity();
                    Header[] arrayOfHeader = this.response.getHeaders("Content-Encoding");
                    int j = 0;
                    i = 0;
                    if (i >= arrayOfHeader.length) {
                        i = j;
                        if (i != 0) {
                            localObject = new GZIPInputStream(((HttpEntity) localObject).getContent());
                            this.mSaxReader.setContentHandler(paramContentHandler);
                            this.mSaxReader.parse(new InputSource((InputStream) localObject));
                            return null;
                        }
                    } else {
                        if (!arrayOfHeader[i].getValue().equalsIgnoreCase("gzip")) {
                            break label344;
                        }
                        i = 1;
                        continue;
                    }
                    localObject = ((HttpEntity) localObject).getContent();
                    continue;
                }
                i += 1;
            } catch (Exception paramContentHandler) {
                paramContentHandler.printStackTrace();
                throw paramContentHandler;
            }
            label337:
            continue;
            label344:
            i += 1;
        }
    }

    public void retrive()
            throws Exception {
        if (this.postMethod == null) {
            return;
        }
        this.response = null;
        try {
            this.response = this.client.execute(this.postMethod);
            return;
        } catch (Exception localException) {
            throw localException;
        }
    }

    public void send(HashMap paramHashMap, Context paramContext)
            throws Exception {
        if (!this.mUri.isAbsolute()) {
            this.mUri = URI.create("http://" + this.mUri.toString().toLowerCase());
        }
        Object localObject;
        if (this.mUri.getPort() > 0) {
            localObject = "http://" + this.mUri.getHost().toLowerCase() + ":" + this.mUri.getPort() + this.mUri.getPath();
            localObject = URI.create(((String) localObject).replace(" ", "%20").trim());
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("method", paramHashMap.get("method"));
            localJSONObject.put("params", new JSONObject((HashMap) paramHashMap.get("params")));
            this.entity = new JSONEntity(localJSONObject);
            this.postMethod = new HttpPost((URI) localObject);
            this.postMethod.setEntity(this.entity);
            UserAgent.setHTTPPostHeader(paramContext, this.postMethod, this.forumStatus);
            if ((this.forumStatus != null) && (this.forumStatus.isContentType())) {
                this.postMethod.addHeader("Content-Type", "text/xml");
            }
            if ((this.forumStatus != null) && (this.forumStatus.isRequestZip())) {
                this.postMethod.addHeader("Content-Encoding", "gzip");
            }
            if ((this.forumStatus != null) && (this.forumStatus.getUseZip())) {
                break label457;
            }
            this.postMethod.addHeader("Accept-Encoding", "none");
        }
        for (; ; ) {
            this.postMethod.addHeader("Mobiquo_id", "4");
            this.postMethod.addHeader("mobiquoid", "4");
            this.postMethod.addHeader("Accept", "*/*");
            HttpProtocolParams.setUseExpectContinue(this.postMethod.getParams(), false);
            return;
            if (this.mUri.toString().startsWith("https")) {
                localObject = "https://" + this.mUri.getHost().toLowerCase() + this.mUri.getPath();
                break;
            }
            localObject = "http://" + this.mUri.getHost().toLowerCase() + this.mUri.getPath();
            break;
            label457:
            this.postMethod.addHeader("Accept-Encoding", "gzip");
        }
    }

    public void setCookie(String paramString) {
        paramString = paramString.split("=");
        if (this.forumStatus == null) {
        }
        HashMap localHashMap;
        do {
            return;
            localHashMap = this.forumStatus.cookies;
        } while (paramString.length != 2);
        localHashMap.put(paramString[0], paramString[1]);
    }

    public void setLoginStatus(String paramString) {
        this.isLogin = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/JSONRPCClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */