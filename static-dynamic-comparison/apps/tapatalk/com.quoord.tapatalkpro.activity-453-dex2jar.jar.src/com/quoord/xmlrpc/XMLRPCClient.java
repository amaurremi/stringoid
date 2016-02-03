package com.quoord.xmlrpc;

import android.content.Context;
import android.content.res.Resources;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.UserAgent;
import com.quoord.tools.ForumHttpStatus;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
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
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.kxml2.io.KXmlParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XMLRPCClient {
    public static final int CALLMETHOD = 1;
    public static String tag = "XMLRPCClient";
    private HttpClient client;
    HttpEntity entity;
    ForumHttpStatus httpStatus;
    private String isLogin;
    private String mMethodName;
    private SAXParser mSaxParser;
    private XMLReader mSaxReader;
    private URI mUri = null;
    private XmlRpcParser parser;
    HttpPost postMethod;
    public HttpResponse response;
    private Object result;
    private KXmlParser xp;

    public XMLRPCClient(String paramString) {
        this(URI.create(paramString));
    }

    public XMLRPCClient(URI paramURI) {
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

    public XMLRPCClient(URI paramURI, ForumHttpStatus paramForumHttpStatus) {
        this.mUri = paramURI;
        this.httpStatus = paramForumHttpStatus;
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

    public XMLRPCClient(URL paramURL) {
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
                return new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams) localObject, localSchemeRegistry), (HttpParams) localObject);
            }
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
                continue;
                HttpConnectionParams.setConnectionTimeout(localException, 7000);
                HttpConnectionParams.setSoTimeout(localException, 10000);
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
        //   1: getfield 224	com/quoord/xmlrpc/XMLRPCClient:response	Lorg/apache/http/HttpResponse;
        //   4: ifnonnull +5 -> 9
        //   7: aconst_null
        //   8: areturn
        //   9: aload_0
        //   10: getfield 224	com/quoord/xmlrpc/XMLRPCClient:response	Lorg/apache/http/HttpResponse;
        //   13: ldc -30
        //   15: invokeinterface 232 2 0
        //   20: astore_3
        //   21: aload_3
        //   22: ifnull +11 -> 33
        //   25: iconst_0
        //   26: istore_1
        //   27: iload_1
        //   28: aload_3
        //   29: arraylength
        //   30: if_icmplt +269 -> 299
        //   33: aload_0
        //   34: getfield 224	com/quoord/xmlrpc/XMLRPCClient:response	Lorg/apache/http/HttpResponse;
        //   37: ldc -22
        //   39: invokeinterface 232 2 0
        //   44: astore_3
        //   45: aload_3
        //   46: ifnull +20 -> 66
        //   49: aload_3
        //   50: arraylength
        //   51: ifle +15 -> 66
        //   54: aload_0
        //   55: aload_3
        //   56: iconst_0
        //   57: aaload
        //   58: invokeinterface 239 1 0
        //   63: invokevirtual 242	com/quoord/xmlrpc/XMLRPCClient:setLoginStatus	(Ljava/lang/String;)V
        //   66: aload_0
        //   67: getfield 224	com/quoord/xmlrpc/XMLRPCClient:response	Lorg/apache/http/HttpResponse;
        //   70: ldc -12
        //   72: invokeinterface 232 2 0
        //   77: astore_3
        //   78: aload_3
        //   79: ifnull +20 -> 99
        //   82: aload_3
        //   83: arraylength
        //   84: ifle +15 -> 99
        //   87: aload_0
        //   88: aload_3
        //   89: iconst_0
        //   90: aaload
        //   91: invokeinterface 239 1 0
        //   96: invokevirtual 242	com/quoord/xmlrpc/XMLRPCClient:setLoginStatus	(Ljava/lang/String;)V
        //   99: aload_0
        //   100: getfield 224	com/quoord/xmlrpc/XMLRPCClient:response	Lorg/apache/http/HttpResponse;
        //   103: invokeinterface 248 1 0
        //   108: astore 5
        //   110: aload_0
        //   111: getfield 224	com/quoord/xmlrpc/XMLRPCClient:response	Lorg/apache/http/HttpResponse;
        //   114: ldc -6
        //   116: invokeinterface 232 2 0
        //   121: astore_3
        //   122: iconst_0
        //   123: istore_2
        //   124: iconst_0
        //   125: istore_1
        //   126: iload_1
        //   127: aload_3
        //   128: arraylength
        //   129: if_icmplt +223 -> 352
        //   132: iload_2
        //   133: istore_1
        //   134: iload_1
        //   135: ifeq +239 -> 374
        //   138: new 252	java/util/zip/GZIPInputStream
        //   141: dup
        //   142: aload 5
        //   144: invokeinterface 258 1 0
        //   149: invokespecial 261	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
        //   152: astore_3
        //   153: aload_3
        //   154: astore 4
        //   156: aload_0
        //   157: new 263	org/kxml2/io/KXmlParser
        //   160: dup
        //   161: invokespecial 264	org/kxml2/io/KXmlParser:<init>	()V
        //   164: putfield 266	com/quoord/xmlrpc/XMLRPCClient:xp	Lorg/kxml2/io/KXmlParser;
        //   167: aload_3
        //   168: astore 4
        //   170: aload_0
        //   171: getfield 266	com/quoord/xmlrpc/XMLRPCClient:xp	Lorg/kxml2/io/KXmlParser;
        //   174: new 268	java/io/InputStreamReader
        //   177: dup
        //   178: aload_3
        //   179: invokespecial 269	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   182: invokevirtual 273	org/kxml2/io/KXmlParser:setInput	(Ljava/io/Reader;)V
        //   185: aload_3
        //   186: astore 4
        //   188: aload_0
        //   189: new 275	com/quoord/xmlrpc/XmlRpcParser
        //   192: dup
        //   193: aload_0
        //   194: getfield 266	com/quoord/xmlrpc/XMLRPCClient:xp	Lorg/kxml2/io/KXmlParser;
        //   197: invokespecial 278	com/quoord/xmlrpc/XmlRpcParser:<init>	(Lorg/kxml2/io/KXmlParser;)V
        //   200: putfield 280	com/quoord/xmlrpc/XMLRPCClient:parser	Lcom/quoord/xmlrpc/XmlRpcParser;
        //   203: aload_3
        //   204: astore 4
        //   206: aload_0
        //   207: aload_0
        //   208: getfield 280	com/quoord/xmlrpc/XMLRPCClient:parser	Lcom/quoord/xmlrpc/XmlRpcParser;
        //   211: invokevirtual 283	com/quoord/xmlrpc/XmlRpcParser:parseResponse	()Ljava/lang/Object;
        //   214: putfield 285	com/quoord/xmlrpc/XMLRPCClient:result	Ljava/lang/Object;
        //   217: aload_3
        //   218: astore 4
        //   220: aload_0
        //   221: aconst_null
        //   222: putfield 280	com/quoord/xmlrpc/XMLRPCClient:parser	Lcom/quoord/xmlrpc/XmlRpcParser;
        //   225: aload_3
        //   226: astore 4
        //   228: aload_0
        //   229: getfield 287	com/quoord/xmlrpc/XMLRPCClient:postMethod	Lorg/apache/http/client/methods/HttpPost;
        //   232: invokevirtual 292	org/apache/http/client/methods/HttpPost:abort	()V
        //   235: aload_3
        //   236: astore 4
        //   238: aload_0
        //   239: getfield 69	com/quoord/xmlrpc/XMLRPCClient:client	Lorg/apache/http/client/HttpClient;
        //   242: invokeinterface 298 1 0
        //   247: invokeinterface 303 1 0
        //   252: aload_3
        //   253: astore 4
        //   255: aload_0
        //   256: getfield 69	com/quoord/xmlrpc/XMLRPCClient:client	Lorg/apache/http/client/HttpClient;
        //   259: invokeinterface 298 1 0
        //   264: invokeinterface 306 1 0
        //   269: aload_3
        //   270: invokevirtual 311	java/io/InputStream:close	()V
        //   273: aload 5
        //   275: invokeinterface 314 1 0
        //   280: aload_0
        //   281: getfield 316	com/quoord/xmlrpc/XMLRPCClient:entity	Lorg/apache/http/HttpEntity;
        //   284: invokeinterface 314 1 0
        //   289: aload_3
        //   290: astore 4
        //   292: aload_0
        //   293: getfield 285	com/quoord/xmlrpc/XMLRPCClient:result	Ljava/lang/Object;
        //   296: astore_3
        //   297: aload_3
        //   298: areturn
        //   299: aload_3
        //   300: iload_1
        //   301: aaload
        //   302: invokeinterface 239 1 0
        //   307: ifnull +210 -> 517
        //   310: aload_3
        //   311: iload_1
        //   312: aaload
        //   313: invokeinterface 239 1 0
        //   318: invokevirtual 320	java/lang/String:length	()I
        //   321: ifle +196 -> 517
        //   324: aload_0
        //   325: new 322	java/util/StringTokenizer
        //   328: dup
        //   329: aload_3
        //   330: iload_1
        //   331: aaload
        //   332: invokeinterface 239 1 0
        //   337: ldc_w 324
        //   340: invokespecial 327	java/util/StringTokenizer:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   343: invokevirtual 330	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
        //   346: invokevirtual 333	com/quoord/xmlrpc/XMLRPCClient:setCookie	(Ljava/lang/String;)V
        //   349: goto +168 -> 517
        //   352: aload_3
        //   353: iload_1
        //   354: aaload
        //   355: invokeinterface 239 1 0
        //   360: ldc_w 335
        //   363: invokevirtual 338	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   366: ifeq +158 -> 524
        //   369: iconst_1
        //   370: istore_1
        //   371: goto -237 -> 134
        //   374: aload 5
        //   376: invokeinterface 258 1 0
        //   381: astore_3
        //   382: goto -229 -> 153
        //   385: astore 6
        //   387: aconst_null
        //   388: astore 4
        //   390: aconst_null
        //   391: astore_3
        //   392: aload 6
        //   394: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   397: goto -124 -> 273
        //   400: astore_3
        //   401: aload_0
        //   402: getfield 287	com/quoord/xmlrpc/XMLRPCClient:postMethod	Lorg/apache/http/client/methods/HttpPost;
        //   405: invokevirtual 292	org/apache/http/client/methods/HttpPost:abort	()V
        //   408: aload_0
        //   409: aconst_null
        //   410: putfield 280	com/quoord/xmlrpc/XMLRPCClient:parser	Lcom/quoord/xmlrpc/XmlRpcParser;
        //   413: aload_0
        //   414: getfield 69	com/quoord/xmlrpc/XMLRPCClient:client	Lorg/apache/http/client/HttpClient;
        //   417: invokeinterface 298 1 0
        //   422: invokeinterface 306 1 0
        //   427: aload 4
        //   429: invokevirtual 311	java/io/InputStream:close	()V
        //   432: aload 5
        //   434: invokeinterface 314 1 0
        //   439: aload_0
        //   440: getfield 316	com/quoord/xmlrpc/XMLRPCClient:entity	Lorg/apache/http/HttpEntity;
        //   443: invokeinterface 314 1 0
        //   448: aload_3
        //   449: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   452: aload_3
        //   453: athrow
        //   454: astore_3
        //   455: aload_3
        //   456: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   459: aload_3
        //   460: athrow
        //   461: astore 6
        //   463: aload_3
        //   464: astore 4
        //   466: aload 6
        //   468: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   471: goto -191 -> 280
        //   474: astore 6
        //   476: aload_3
        //   477: astore 4
        //   479: aload 6
        //   481: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   484: goto -195 -> 289
        //   487: astore 4
        //   489: aload 4
        //   491: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   494: goto -62 -> 432
        //   497: astore 4
        //   499: aload 4
        //   501: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   504: goto -65 -> 439
        //   507: astore 4
        //   509: aload 4
        //   511: invokevirtual 214	java/lang/Exception:printStackTrace	()V
        //   514: goto -66 -> 448
        //   517: iload_1
        //   518: iconst_1
        //   519: iadd
        //   520: istore_1
        //   521: goto -494 -> 27
        //   524: iload_1
        //   525: iconst_1
        //   526: iadd
        //   527: istore_1
        //   528: goto -402 -> 126
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	531	0	this	XMLRPCClient
        //   26	502	1	i	int
        //   123	10	2	j	int
        //   20	372	3	localObject1	Object
        //   400	53	3	localException1	Exception
        //   454	23	3	localException2	Exception
        //   154	324	4	localObject2	Object
        //   487	3	4	localException3	Exception
        //   497	3	4	localException4	Exception
        //   507	3	4	localException5	Exception
        //   108	325	5	localHttpEntity	HttpEntity
        //   385	8	6	localException6	Exception
        //   461	6	6	localException7	Exception
        //   474	6	6	localException8	Exception
        // Exception table:
        //   from	to	target	type
        //   269	273	385	java/lang/Exception
        //   156	167	400	java/lang/Exception
        //   170	185	400	java/lang/Exception
        //   188	203	400	java/lang/Exception
        //   206	217	400	java/lang/Exception
        //   220	225	400	java/lang/Exception
        //   228	235	400	java/lang/Exception
        //   238	252	400	java/lang/Exception
        //   255	269	400	java/lang/Exception
        //   292	297	400	java/lang/Exception
        //   392	397	400	java/lang/Exception
        //   466	471	400	java/lang/Exception
        //   479	484	400	java/lang/Exception
        //   0	7	454	java/lang/Exception
        //   9	21	454	java/lang/Exception
        //   27	33	454	java/lang/Exception
        //   33	45	454	java/lang/Exception
        //   49	66	454	java/lang/Exception
        //   66	78	454	java/lang/Exception
        //   82	99	454	java/lang/Exception
        //   99	122	454	java/lang/Exception
        //   126	132	454	java/lang/Exception
        //   138	153	454	java/lang/Exception
        //   299	349	454	java/lang/Exception
        //   352	369	454	java/lang/Exception
        //   374	382	454	java/lang/Exception
        //   401	427	454	java/lang/Exception
        //   448	454	454	java/lang/Exception
        //   489	494	454	java/lang/Exception
        //   499	504	454	java/lang/Exception
        //   509	514	454	java/lang/Exception
        //   273	280	461	java/lang/Exception
        //   280	289	474	java/lang/Exception
        //   427	432	487	java/lang/Exception
        //   432	439	497	java/lang/Exception
        //   439	448	507	java/lang/Exception
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
                    if ((this.httpStatus == null) || (Boolean.parseBoolean(this.isLogin) == this.httpStatus.isLogin()) || (!this.httpStatus.isLogin()) || (paramBoolean)) {
                        continue;
                    }
                    return null;
                }
                if ((localObject[i].getValue() != null) && (localObject[i].getValue().length() > 0)) {
                    setCookie(new StringTokenizer(localObject[i].getValue(), ";").nextToken());
                    break label341;
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
                            break label348;
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
            label341:
            continue;
            label348:
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

    public void send(String paramString, Object[] paramArrayOfObject, Context paramContext)
            throws Exception {
        this.mMethodName = paramString;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        XmlWriter localXmlWriter = new XmlWriter(new OutputStreamWriter(localByteArrayOutputStream));
        new XmlRpcWriter(localXmlWriter).writeCall(paramString, paramArrayOfObject);
        localXmlWriter.flush();
        this.entity = new ByteArrayEntity(localByteArrayOutputStream.toByteArray());
        try {
            localByteArrayOutputStream.close();
            if (!this.mUri.isAbsolute()) {
                this.mUri = URI.create("http://" + this.mUri.toString().toLowerCase());
            }
            if (this.mUri.getPort() > 0) {
                if (this.mUri.toString().startsWith("https")) {
                    paramArrayOfObject = "https://" + this.mUri.getHost().toLowerCase() + ":" + this.mUri.getPort() + this.mUri.getPath();
                    this.postMethod = new HttpPost(URI.create(paramArrayOfObject.replace(" ", "%20").trim()));
                    this.postMethod.setEntity(this.entity);
                    UserAgent.setHTTPPostHeader(paramContext, this.postMethod, this.httpStatus);
                    if ((this.httpStatus != null) && (this.httpStatus.isContentType())) {
                        this.postMethod.addHeader("Content-Type", "text/xml");
                    }
                    if ((this.httpStatus != null) && (this.httpStatus.isRequestZip())) {
                        this.postMethod.addHeader("Content-Encoding", "gzip");
                    }
                    if ((this.httpStatus != null) && (this.httpStatus.getUseZip())) {
                        break label617;
                    }
                    this.postMethod.addHeader("Accept-Encoding", "none");
                    label338:
                    if (!paramContext.getResources().getBoolean(2131558409)) {
                        break label633;
                    }
                    this.postMethod.addHeader("Mobiquo_id", "4");
                    this.postMethod.addHeader("mobiquoid", "4");
                    label377:
                    this.postMethod.addHeader("Accept", "*/*");
                    paramArrayOfObject = this.postMethod.getParams();
                    if ((this.httpStatus == null) || (paramString.equals("login")) || (paramString.equals("authorize_user")) || (paramString.equals("get_config"))) {
                        break label662;
                    }
                    paramString = this.httpStatus.getCookie();
                    if (paramString != null) {
                        this.postMethod.setHeader("Cookie", paramString);
                    }
                }
            }
            for (; ; ) {
                HttpProtocolParams.setUseExpectContinue(paramArrayOfObject, false);
                return;
                paramArrayOfObject = "http://" + this.mUri.getHost().toLowerCase() + ":" + this.mUri.getPort() + this.mUri.getPath();
                break;
                if (this.mUri.toString().startsWith("https")) {
                    paramArrayOfObject = "https://" + this.mUri.getHost().toLowerCase() + this.mUri.getPath();
                    break;
                }
                paramArrayOfObject = "http://" + this.mUri.getHost().toLowerCase() + this.mUri.getPath();
                break;
                label617:
                this.postMethod.addHeader("Accept-Encoding", "gzip");
                break label338;
                label633:
                this.postMethod.addHeader("Mobiquo_id", "5");
                this.postMethod.addHeader("mobiquoid", "5");
                break label377;
                label662:
                this.postMethod.setHeader("Cookie", "tapatalk = 1");
            }
        } catch (Exception paramArrayOfObject) {
            for (; ; ) {
            }
        }
    }

    public void setCookie(String paramString) {
        paramString = paramString.split("=");
        if (this.httpStatus == null) {
        }
        HashMap localHashMap;
        do {
            return;
            localHashMap = this.httpStatus.getCookies();
        } while (paramString.length != 2);
        localHashMap.put(paramString[0], paramString[1]);
    }

    public void setLoginStatus(String paramString) {
        this.isLogin = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/XMLRPCClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */