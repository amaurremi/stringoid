package com.amazon.device.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class HttpURLConnectionWebRequest
        extends WebRequest {
    private static final String LOG_TAG = HttpURLConnectionWebRequest.class.getSimpleName();

    /* Error */
    private void writePostBody(HttpURLConnection paramHttpURLConnection)
            throws WebRequest.WebRequestException {
        // Byte code:
        //   0: new 30	java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
        //   7: astore 4
        //   9: aload_0
        //   10: getfield 34	com/amazon/device/ads/HttpURLConnectionWebRequest:requestBody	Ljava/lang/String;
        //   13: ifnull +83 -> 96
        //   16: aload 4
        //   18: aload_0
        //   19: getfield 34	com/amazon/device/ads/HttpURLConnectionWebRequest:requestBody	Ljava/lang/String;
        //   22: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   25: pop
        //   26: aload_0
        //   27: getfield 42	com/amazon/device/ads/HttpURLConnectionWebRequest:logRequestBodyEnabled	Z
        //   30: ifeq +30 -> 60
        //   33: aload_0
        //   34: invokevirtual 45	com/amazon/device/ads/HttpURLConnectionWebRequest:getRequestBody	()Ljava/lang/String;
        //   37: ifnull +23 -> 60
        //   40: aload_0
        //   41: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   44: ldc 50
        //   46: iconst_1
        //   47: anewarray 52	java/lang/Object
        //   50: dup
        //   51: iconst_0
        //   52: aload_0
        //   53: invokevirtual 45	com/amazon/device/ads/HttpURLConnectionWebRequest:getRequestBody	()Ljava/lang/String;
        //   56: aastore
        //   57: invokestatic 58	com/amazon/device/ads/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   60: aconst_null
        //   61: astore_2
        //   62: aconst_null
        //   63: astore_3
        //   64: new 60	java/io/OutputStreamWriter
        //   67: dup
        //   68: aload_1
        //   69: invokevirtual 66	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   72: ldc 68
        //   74: invokespecial 71	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   77: astore_1
        //   78: aload_1
        //   79: aload 4
        //   81: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   84: invokevirtual 78	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
        //   87: aload_1
        //   88: ifnull +7 -> 95
        //   91: aload_1
        //   92: invokevirtual 81	java/io/OutputStreamWriter:close	()V
        //   95: return
        //   96: aload_0
        //   97: getfield 85	com/amazon/device/ads/HttpURLConnectionWebRequest:postParameters	Ljava/util/HashMap;
        //   100: ifnull -74 -> 26
        //   103: aload_0
        //   104: getfield 85	com/amazon/device/ads/HttpURLConnectionWebRequest:postParameters	Ljava/util/HashMap;
        //   107: invokevirtual 91	java/util/HashMap:isEmpty	()Z
        //   110: ifne -84 -> 26
        //   113: aload_0
        //   114: getfield 85	com/amazon/device/ads/HttpURLConnectionWebRequest:postParameters	Ljava/util/HashMap;
        //   117: invokevirtual 95	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   120: invokeinterface 101 1 0
        //   125: astore_2
        //   126: aload_2
        //   127: invokeinterface 106 1 0
        //   132: ifeq +56 -> 188
        //   135: aload_2
        //   136: invokeinterface 110 1 0
        //   141: checkcast 112	java/util/Map$Entry
        //   144: astore_3
        //   145: aload 4
        //   147: aload_3
        //   148: invokeinterface 115 1 0
        //   153: checkcast 117	java/lang/String
        //   156: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: ldc 119
        //   161: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   164: aload_3
        //   165: invokeinterface 122 1 0
        //   170: checkcast 117	java/lang/String
        //   173: invokestatic 128	com/amazon/device/ads/Utils:getURLEncodedString	(Ljava/lang/String;)Ljava/lang/String;
        //   176: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: ldc -126
        //   181: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   184: pop
        //   185: goto -59 -> 126
        //   188: aload 4
        //   190: aload 4
        //   192: ldc -126
        //   194: invokevirtual 134	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
        //   197: invokevirtual 138	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
        //   200: pop
        //   201: goto -175 -> 26
        //   204: astore_1
        //   205: aload_0
        //   206: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   209: ldc -116
        //   211: iconst_1
        //   212: anewarray 52	java/lang/Object
        //   215: dup
        //   216: iconst_0
        //   217: aload_1
        //   218: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   221: aastore
        //   222: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   225: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   228: dup
        //   229: aload_0
        //   230: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   233: ldc -102
        //   235: aload_1
        //   236: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   239: athrow
        //   240: astore_2
        //   241: aload_3
        //   242: astore_1
        //   243: aload_2
        //   244: astore_3
        //   245: aload_1
        //   246: astore_2
        //   247: aload_0
        //   248: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   251: ldc -97
        //   253: iconst_1
        //   254: anewarray 52	java/lang/Object
        //   257: dup
        //   258: iconst_0
        //   259: aload_3
        //   260: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   263: aastore
        //   264: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   267: aload_1
        //   268: astore_2
        //   269: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   272: dup
        //   273: aload_0
        //   274: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   277: ldc -95
        //   279: aload_3
        //   280: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   283: athrow
        //   284: astore_1
        //   285: aload_2
        //   286: ifnull +7 -> 293
        //   289: aload_2
        //   290: invokevirtual 81	java/io/OutputStreamWriter:close	()V
        //   293: aload_1
        //   294: athrow
        //   295: astore_1
        //   296: aload_0
        //   297: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   300: ldc -116
        //   302: iconst_1
        //   303: anewarray 52	java/lang/Object
        //   306: dup
        //   307: iconst_0
        //   308: aload_1
        //   309: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   312: aastore
        //   313: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   316: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   319: dup
        //   320: aload_0
        //   321: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   324: ldc -102
        //   326: aload_1
        //   327: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   330: athrow
        //   331: astore_3
        //   332: aload_1
        //   333: astore_2
        //   334: aload_3
        //   335: astore_1
        //   336: goto -51 -> 285
        //   339: astore_3
        //   340: goto -95 -> 245
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	343	0	this	HttpURLConnectionWebRequest
        //   0	343	1	paramHttpURLConnection	HttpURLConnection
        //   61	75	2	localIterator	Iterator
        //   240	4	2	localIOException1	IOException
        //   246	88	2	localHttpURLConnection	HttpURLConnection
        //   63	217	3	localObject1	Object
        //   331	4	3	localObject2	Object
        //   339	1	3	localIOException2	IOException
        //   7	184	4	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   91	95	204	java/io/IOException
        //   64	78	240	java/io/IOException
        //   64	78	284	finally
        //   247	267	284	finally
        //   269	284	284	finally
        //   289	293	295	java/io/IOException
        //   78	87	331	finally
        //   78	87	339	java/io/IOException
    }

    /* Error */
    protected WebRequest.WebResponse doHttpNetworkCall(URL paramURL)
            throws WebRequest.WebRequestException {
        // Byte code:
        //   0: aload_0
        //   1: aload_1
        //   2: invokevirtual 170	com/amazon/device/ads/HttpURLConnectionWebRequest:openConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
        //   5: astore_1
        //   6: aload_0
        //   7: aload_1
        //   8: invokevirtual 173	com/amazon/device/ads/HttpURLConnectionWebRequest:setupRequestProperties	(Ljava/net/HttpURLConnection;)V
        //   11: aload_1
        //   12: invokevirtual 176	java/net/HttpURLConnection:connect	()V
        //   15: aload_0
        //   16: aload_1
        //   17: invokevirtual 180	com/amazon/device/ads/HttpURLConnectionWebRequest:prepareResponse	(Ljava/net/HttpURLConnection;)Lcom/amazon/device/ads/WebRequest$WebResponse;
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   26: ldc -74
        //   28: iconst_1
        //   29: anewarray 52	java/lang/Object
        //   32: dup
        //   33: iconst_0
        //   34: aload_1
        //   35: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   38: aastore
        //   39: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   42: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   45: dup
        //   46: aload_0
        //   47: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   50: ldc -72
        //   52: aload_1
        //   53: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   56: athrow
        //   57: astore_1
        //   58: aload_0
        //   59: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   62: ldc -70
        //   64: iconst_1
        //   65: anewarray 52	java/lang/Object
        //   68: dup
        //   69: iconst_0
        //   70: aload_1
        //   71: invokevirtual 187	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
        //   74: aastore
        //   75: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   78: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   81: dup
        //   82: aload_0
        //   83: getstatic 190	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_TIMEOUT	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   86: ldc -64
        //   88: aload_1
        //   89: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   92: athrow
        //   93: astore_1
        //   94: aload_0
        //   95: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   98: ldc -62
        //   100: iconst_1
        //   101: anewarray 52	java/lang/Object
        //   104: dup
        //   105: iconst_0
        //   106: aload_1
        //   107: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   110: aastore
        //   111: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   114: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   117: dup
        //   118: aload_0
        //   119: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   122: ldc -60
        //   124: aload_1
        //   125: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   128: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	129	0	this	HttpURLConnectionWebRequest
        //   0	129	1	paramURL	URL
        // Exception table:
        //   from	to	target	type
        //   0	6	21	java/io/IOException
        //   11	15	57	java/net/SocketTimeoutException
        //   11	15	93	java/io/IOException
    }

    protected String getSubLogTag() {
        return LOG_TAG;
    }

    protected HttpURLConnection openConnection(URL paramURL)
            throws IOException {
        return (HttpURLConnection) paramURL.openConnection();
    }

    /* Error */
    protected WebRequest.WebResponse prepareResponse(HttpURLConnection paramHttpURLConnection)
            throws WebRequest.WebRequestException {
        // Byte code:
        //   0: new 204	com/amazon/device/ads/WebRequest$WebResponse
        //   3: dup
        //   4: aload_0
        //   5: invokespecial 207	com/amazon/device/ads/WebRequest$WebResponse:<init>	(Lcom/amazon/device/ads/WebRequest;)V
        //   8: astore_2
        //   9: aload_2
        //   10: aload_0
        //   11: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   14: invokevirtual 210	com/amazon/device/ads/WebRequest$WebResponse:setLogTag	(Ljava/lang/String;)V
        //   17: aload_2
        //   18: aload_0
        //   19: getfield 213	com/amazon/device/ads/HttpURLConnectionWebRequest:logResponseEnabled	Z
        //   22: invokevirtual 217	com/amazon/device/ads/WebRequest$WebResponse:enableLog	(Z)V
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 221	java/net/HttpURLConnection:getResponseCode	()I
        //   30: invokevirtual 225	com/amazon/device/ads/WebRequest$WebResponse:setHttpStatusCode	(I)V
        //   33: aload_2
        //   34: aload_1
        //   35: invokevirtual 228	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
        //   38: invokevirtual 231	com/amazon/device/ads/WebRequest$WebResponse:setHttpStatus	(Ljava/lang/String;)V
        //   41: aload_2
        //   42: invokevirtual 234	com/amazon/device/ads/WebRequest$WebResponse:getHttpStatusCode	()I
        //   45: sipush 200
        //   48: if_icmpne +11 -> 59
        //   51: aload_2
        //   52: aload_1
        //   53: invokevirtual 238	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   56: invokevirtual 242	com/amazon/device/ads/WebRequest$WebResponse:setInputStream	(Ljava/io/InputStream;)V
        //   59: aload_2
        //   60: areturn
        //   61: astore_1
        //   62: aload_0
        //   63: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   66: ldc -12
        //   68: iconst_1
        //   69: anewarray 52	java/lang/Object
        //   72: dup
        //   73: iconst_0
        //   74: aload_1
        //   75: invokevirtual 187	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
        //   78: aastore
        //   79: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   82: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   85: dup
        //   86: aload_0
        //   87: getstatic 190	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_TIMEOUT	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   90: ldc -10
        //   92: aload_1
        //   93: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   96: athrow
        //   97: astore_1
        //   98: aload_0
        //   99: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   102: ldc -8
        //   104: iconst_1
        //   105: anewarray 52	java/lang/Object
        //   108: dup
        //   109: iconst_0
        //   110: aload_1
        //   111: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   114: aastore
        //   115: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   118: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   121: dup
        //   122: aload_0
        //   123: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   126: ldc -6
        //   128: aload_1
        //   129: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   132: athrow
        //   133: astore_1
        //   134: aload_0
        //   135: invokevirtual 48	com/amazon/device/ads/HttpURLConnectionWebRequest:getLogTag	()Ljava/lang/String;
        //   138: ldc -4
        //   140: iconst_1
        //   141: anewarray 52	java/lang/Object
        //   144: dup
        //   145: iconst_0
        //   146: aload_1
        //   147: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
        //   150: aastore
        //   151: invokestatic 146	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   154: new 26	com/amazon/device/ads/WebRequest$WebRequestException
        //   157: dup
        //   158: aload_0
        //   159: getstatic 152	com/amazon/device/ads/WebRequest$WebRequestStatus:NETWORK_FAILURE	Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   162: ldc -2
        //   164: aload_1
        //   165: invokespecial 157	com/amazon/device/ads/WebRequest$WebRequestException:<init>	(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   168: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	169	0	this	HttpURLConnectionWebRequest
        //   0	169	1	paramHttpURLConnection	HttpURLConnection
        //   8	52	2	localWebResponse	WebRequest.WebResponse
        // Exception table:
        //   from	to	target	type
        //   25	41	61	java/net/SocketTimeoutException
        //   25	41	97	java/io/IOException
        //   51	59	133	java/io/IOException
    }

    protected void setupRequestProperties(HttpURLConnection paramHttpURLConnection)
            throws WebRequest.WebRequestException {
        try {
            paramHttpURLConnection.setRequestMethod(getHttpMethod().name());
            Iterator localIterator = this.headers.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                if ((localEntry.getValue() != null) && (!((String) localEntry.getValue()).equals(""))) {
                    paramHttpURLConnection.setRequestProperty((String) localEntry.getKey(), (String) localEntry.getValue());
                }
            }
            paramHttpURLConnection.setConnectTimeout(getTimeout());
        } catch (ProtocolException paramHttpURLConnection) {
            Log.e(getLogTag(), "Invalid client protocol: %s", new Object[]{paramHttpURLConnection.getMessage()});
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", paramHttpURLConnection);
        }
        paramHttpURLConnection.setReadTimeout(getTimeout());
        logUrl(paramHttpURLConnection.getURL().toString());
        switch (getHttpMethod()) {
            default:
                return;
            case???:
            paramHttpURLConnection.setDoOutput(false);
            return;
        }
        paramHttpURLConnection.setDoOutput(true);
        writePostBody(paramHttpURLConnection);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/HttpURLConnectionWebRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */