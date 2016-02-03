package twitter4j.internal.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONObject;

public abstract class HttpResponse {
    private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
    protected final HttpClientConfiguration CONF;
    protected InputStream is;
    private JSONObject json = null;
    private JSONArray jsonArray = null;
    protected String responseAsString = null;
    protected int statusCode;
    private boolean streamConsumed = false;

    HttpResponse() {
        this.CONF = ConfigurationContext.getInstance();
    }

    public HttpResponse(HttpClientConfiguration paramHttpClientConfiguration) {
        this.CONF = paramHttpClientConfiguration;
    }

    private void disconnectForcibly() {
        try {
            disconnect();
            return;
        } catch (Exception localException) {
        }
    }

    /* Error */
    public JSONArray asJSONArray()
            throws twitter4j.TwitterException {
        // Byte code:
        //   0: aload_0
        //   1: getfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
        //   4: ifnonnull +104 -> 108
        //   7: aconst_null
        //   8: astore 4
        //   10: aconst_null
        //   11: astore 5
        //   13: aconst_null
        //   14: astore_3
        //   15: aload 4
        //   17: astore_2
        //   18: aload 5
        //   20: astore_1
        //   21: aload_0
        //   22: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   25: ifnonnull +88 -> 113
        //   28: aload 4
        //   30: astore_2
        //   31: aload 5
        //   33: astore_1
        //   34: aload_0
        //   35: invokevirtual 71	twitter4j/internal/http/HttpResponse:asReader	()Ljava/io/Reader;
        //   38: astore_3
        //   39: aload_3
        //   40: astore_2
        //   41: aload_3
        //   42: astore_1
        //   43: aload_0
        //   44: new 73	twitter4j/internal/org/json/JSONArray
        //   47: dup
        //   48: new 75	twitter4j/internal/org/json/JSONTokener
        //   51: dup
        //   52: aload_3
        //   53: invokespecial 78	twitter4j/internal/org/json/JSONTokener:<init>	(Ljava/io/Reader;)V
        //   56: invokespecial 81	twitter4j/internal/org/json/JSONArray:<init>	(Ltwitter4j/internal/org/json/JSONTokener;)V
        //   59: putfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
        //   62: aload_3
        //   63: astore_2
        //   64: aload_3
        //   65: astore_1
        //   66: aload_0
        //   67: getfield 52	twitter4j/internal/http/HttpResponse:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
        //   70: invokeinterface 87 1 0
        //   75: ifeq +129 -> 204
        //   78: aload_3
        //   79: astore_2
        //   80: aload_3
        //   81: astore_1
        //   82: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
        //   85: aload_0
        //   86: getfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
        //   89: iconst_1
        //   90: invokevirtual 91	twitter4j/internal/org/json/JSONArray:toString	(I)Ljava/lang/String;
        //   93: invokevirtual 95	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
        //   96: aload_3
        //   97: ifnull +7 -> 104
        //   100: aload_3
        //   101: invokevirtual 100	java/io/Reader:close	()V
        //   104: aload_0
        //   105: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   108: aload_0
        //   109: getfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
        //   112: areturn
        //   113: aload 4
        //   115: astore_2
        //   116: aload 5
        //   118: astore_1
        //   119: aload_0
        //   120: new 73	twitter4j/internal/org/json/JSONArray
        //   123: dup
        //   124: aload_0
        //   125: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   128: invokespecial 104	twitter4j/internal/org/json/JSONArray:<init>	(Ljava/lang/String;)V
        //   131: putfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
        //   134: goto -72 -> 62
        //   137: astore_3
        //   138: aload_2
        //   139: astore_1
        //   140: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
        //   143: invokevirtual 107	twitter4j/internal/logging/Logger:isDebugEnabled	()Z
        //   146: ifeq +118 -> 264
        //   149: aload_2
        //   150: astore_1
        //   151: new 63	twitter4j/TwitterException
        //   154: dup
        //   155: new 109	java/lang/StringBuilder
        //   158: dup
        //   159: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   162: aload_3
        //   163: invokevirtual 114	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
        //   166: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: ldc 120
        //   171: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   174: aload_0
        //   175: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   178: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   181: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   184: aload_3
        //   185: invokespecial 125	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   188: athrow
        //   189: astore_2
        //   190: aload_1
        //   191: ifnull +7 -> 198
        //   194: aload_1
        //   195: invokevirtual 100	java/io/Reader:close	()V
        //   198: aload_0
        //   199: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   202: aload_2
        //   203: athrow
        //   204: aload_3
        //   205: astore_2
        //   206: aload_3
        //   207: astore_1
        //   208: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
        //   211: astore 5
        //   213: aload_3
        //   214: astore_2
        //   215: aload_3
        //   216: astore_1
        //   217: aload_0
        //   218: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   221: ifnull +27 -> 248
        //   224: aload_3
        //   225: astore_2
        //   226: aload_3
        //   227: astore_1
        //   228: aload_0
        //   229: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   232: astore 4
        //   234: aload_3
        //   235: astore_2
        //   236: aload_3
        //   237: astore_1
        //   238: aload 5
        //   240: aload 4
        //   242: invokevirtual 95	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
        //   245: goto -149 -> 96
        //   248: aload_3
        //   249: astore_2
        //   250: aload_3
        //   251: astore_1
        //   252: aload_0
        //   253: getfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
        //   256: invokevirtual 126	twitter4j/internal/org/json/JSONArray:toString	()Ljava/lang/String;
        //   259: astore 4
        //   261: goto -27 -> 234
        //   264: aload_2
        //   265: astore_1
        //   266: new 63	twitter4j/TwitterException
        //   269: dup
        //   270: aload_3
        //   271: invokevirtual 114	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
        //   274: aload_3
        //   275: invokespecial 125	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   278: athrow
        //   279: astore_1
        //   280: goto -176 -> 104
        //   283: astore_1
        //   284: goto -86 -> 198
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	287	0	this	HttpResponse
        //   20	246	1	localObject1	Object
        //   279	1	1	localIOException1	IOException
        //   283	1	1	localIOException2	IOException
        //   17	133	2	localObject2	Object
        //   189	14	2	localObject3	Object
        //   205	60	2	localJSONException1	twitter4j.internal.org.json.JSONException
        //   14	87	3	localReader	Reader
        //   137	138	3	localJSONException2	twitter4j.internal.org.json.JSONException
        //   8	252	4	str	String
        //   11	228	5	localLogger	Logger
        // Exception table:
        //   from	to	target	type
        //   21	28	137	twitter4j/internal/org/json/JSONException
        //   34	39	137	twitter4j/internal/org/json/JSONException
        //   43	62	137	twitter4j/internal/org/json/JSONException
        //   66	78	137	twitter4j/internal/org/json/JSONException
        //   82	96	137	twitter4j/internal/org/json/JSONException
        //   119	134	137	twitter4j/internal/org/json/JSONException
        //   208	213	137	twitter4j/internal/org/json/JSONException
        //   217	224	137	twitter4j/internal/org/json/JSONException
        //   228	234	137	twitter4j/internal/org/json/JSONException
        //   238	245	137	twitter4j/internal/org/json/JSONException
        //   252	261	137	twitter4j/internal/org/json/JSONException
        //   21	28	189	finally
        //   34	39	189	finally
        //   43	62	189	finally
        //   66	78	189	finally
        //   82	96	189	finally
        //   119	134	189	finally
        //   140	149	189	finally
        //   151	189	189	finally
        //   208	213	189	finally
        //   217	224	189	finally
        //   228	234	189	finally
        //   238	245	189	finally
        //   252	261	189	finally
        //   266	279	189	finally
        //   100	104	279	java/io/IOException
        //   194	198	283	java/io/IOException
    }

    /* Error */
    public JSONObject asJSONObject()
            throws twitter4j.TwitterException {
        // Byte code:
        //   0: aload_0
        //   1: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
        //   4: ifnonnull +104 -> 108
        //   7: aconst_null
        //   8: astore 4
        //   10: aconst_null
        //   11: astore 5
        //   13: aconst_null
        //   14: astore_3
        //   15: aload 4
        //   17: astore_2
        //   18: aload 5
        //   20: astore_1
        //   21: aload_0
        //   22: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   25: ifnonnull +88 -> 113
        //   28: aload 4
        //   30: astore_2
        //   31: aload 5
        //   33: astore_1
        //   34: aload_0
        //   35: invokevirtual 71	twitter4j/internal/http/HttpResponse:asReader	()Ljava/io/Reader;
        //   38: astore_3
        //   39: aload_3
        //   40: astore_2
        //   41: aload_3
        //   42: astore_1
        //   43: aload_0
        //   44: new 131	twitter4j/internal/org/json/JSONObject
        //   47: dup
        //   48: new 75	twitter4j/internal/org/json/JSONTokener
        //   51: dup
        //   52: aload_3
        //   53: invokespecial 78	twitter4j/internal/org/json/JSONTokener:<init>	(Ljava/io/Reader;)V
        //   56: invokespecial 132	twitter4j/internal/org/json/JSONObject:<init>	(Ltwitter4j/internal/org/json/JSONTokener;)V
        //   59: putfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
        //   62: aload_3
        //   63: astore_2
        //   64: aload_3
        //   65: astore_1
        //   66: aload_0
        //   67: getfield 52	twitter4j/internal/http/HttpResponse:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
        //   70: invokeinterface 87 1 0
        //   75: ifeq +102 -> 177
        //   78: aload_3
        //   79: astore_2
        //   80: aload_3
        //   81: astore_1
        //   82: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
        //   85: aload_0
        //   86: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
        //   89: iconst_1
        //   90: invokevirtual 133	twitter4j/internal/org/json/JSONObject:toString	(I)Ljava/lang/String;
        //   93: invokevirtual 95	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
        //   96: aload_3
        //   97: ifnull +7 -> 104
        //   100: aload_3
        //   101: invokevirtual 100	java/io/Reader:close	()V
        //   104: aload_0
        //   105: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   108: aload_0
        //   109: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
        //   112: areturn
        //   113: aload 4
        //   115: astore_2
        //   116: aload 5
        //   118: astore_1
        //   119: aload_0
        //   120: new 131	twitter4j/internal/org/json/JSONObject
        //   123: dup
        //   124: aload_0
        //   125: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   128: invokespecial 134	twitter4j/internal/org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   131: putfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
        //   134: goto -72 -> 62
        //   137: astore_3
        //   138: aload_2
        //   139: astore_1
        //   140: aload_0
        //   141: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   144: ifnonnull +93 -> 237
        //   147: aload_2
        //   148: astore_1
        //   149: new 63	twitter4j/TwitterException
        //   152: dup
        //   153: aload_3
        //   154: invokevirtual 114	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
        //   157: aload_3
        //   158: invokespecial 125	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   161: athrow
        //   162: astore_2
        //   163: aload_1
        //   164: ifnull +7 -> 171
        //   167: aload_1
        //   168: invokevirtual 100	java/io/Reader:close	()V
        //   171: aload_0
        //   172: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   175: aload_2
        //   176: athrow
        //   177: aload_3
        //   178: astore_2
        //   179: aload_3
        //   180: astore_1
        //   181: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
        //   184: astore 5
        //   186: aload_3
        //   187: astore_2
        //   188: aload_3
        //   189: astore_1
        //   190: aload_0
        //   191: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   194: ifnull +27 -> 221
        //   197: aload_3
        //   198: astore_2
        //   199: aload_3
        //   200: astore_1
        //   201: aload_0
        //   202: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   205: astore 4
        //   207: aload_3
        //   208: astore_2
        //   209: aload_3
        //   210: astore_1
        //   211: aload 5
        //   213: aload 4
        //   215: invokevirtual 95	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
        //   218: goto -122 -> 96
        //   221: aload_3
        //   222: astore_2
        //   223: aload_3
        //   224: astore_1
        //   225: aload_0
        //   226: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
        //   229: invokevirtual 135	twitter4j/internal/org/json/JSONObject:toString	()Ljava/lang/String;
        //   232: astore 4
        //   234: goto -27 -> 207
        //   237: aload_2
        //   238: astore_1
        //   239: new 63	twitter4j/TwitterException
        //   242: dup
        //   243: new 109	java/lang/StringBuilder
        //   246: dup
        //   247: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   250: aload_3
        //   251: invokevirtual 114	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
        //   254: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: ldc 120
        //   259: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   262: aload_0
        //   263: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   266: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   269: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   272: aload_3
        //   273: invokespecial 125	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   276: athrow
        //   277: astore_1
        //   278: goto -174 -> 104
        //   281: astore_1
        //   282: goto -111 -> 171
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	285	0	this	HttpResponse
        //   20	219	1	localObject1	Object
        //   277	1	1	localIOException1	IOException
        //   281	1	1	localIOException2	IOException
        //   17	131	2	localObject2	Object
        //   162	14	2	localObject3	Object
        //   178	60	2	localJSONException1	twitter4j.internal.org.json.JSONException
        //   14	87	3	localReader	Reader
        //   137	136	3	localJSONException2	twitter4j.internal.org.json.JSONException
        //   8	225	4	str	String
        //   11	201	5	localLogger	Logger
        // Exception table:
        //   from	to	target	type
        //   21	28	137	twitter4j/internal/org/json/JSONException
        //   34	39	137	twitter4j/internal/org/json/JSONException
        //   43	62	137	twitter4j/internal/org/json/JSONException
        //   66	78	137	twitter4j/internal/org/json/JSONException
        //   82	96	137	twitter4j/internal/org/json/JSONException
        //   119	134	137	twitter4j/internal/org/json/JSONException
        //   181	186	137	twitter4j/internal/org/json/JSONException
        //   190	197	137	twitter4j/internal/org/json/JSONException
        //   201	207	137	twitter4j/internal/org/json/JSONException
        //   211	218	137	twitter4j/internal/org/json/JSONException
        //   225	234	137	twitter4j/internal/org/json/JSONException
        //   21	28	162	finally
        //   34	39	162	finally
        //   43	62	162	finally
        //   66	78	162	finally
        //   82	96	162	finally
        //   119	134	162	finally
        //   140	147	162	finally
        //   149	162	162	finally
        //   181	186	162	finally
        //   190	197	162	finally
        //   201	207	162	finally
        //   211	218	162	finally
        //   225	234	162	finally
        //   239	277	162	finally
        //   100	104	277	java/io/IOException
        //   167	171	281	java/io/IOException
    }

    public Reader asReader() {
        try {
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.is, "UTF-8"));
            return localBufferedReader;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        return new InputStreamReader(this.is);
    }

    public InputStream asStream() {
        if (this.streamConsumed) {
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return this.is;
    }

    /* Error */
    public String asString()
            throws twitter4j.TwitterException {
        // Byte code:
        //   0: aload_0
        //   1: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   4: ifnonnull +207 -> 211
        //   7: aconst_null
        //   8: astore 5
        //   10: aconst_null
        //   11: astore 6
        //   13: aconst_null
        //   14: astore 4
        //   16: aconst_null
        //   17: astore_2
        //   18: aload 5
        //   20: astore_3
        //   21: aload_0
        //   22: invokevirtual 162	twitter4j/internal/http/HttpResponse:asStream	()Ljava/io/InputStream;
        //   25: astore_1
        //   26: aload_1
        //   27: ifnonnull +29 -> 56
        //   30: aload_1
        //   31: ifnull +7 -> 38
        //   34: aload_1
        //   35: invokevirtual 165	java/io/InputStream:close	()V
        //   38: iconst_0
        //   39: ifeq +11 -> 50
        //   42: new 167	java/lang/NullPointerException
        //   45: dup
        //   46: invokespecial 168	java/lang/NullPointerException:<init>	()V
        //   49: athrow
        //   50: aload_0
        //   51: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   54: aconst_null
        //   55: areturn
        //   56: aload 5
        //   58: astore_3
        //   59: aload_1
        //   60: astore_2
        //   61: aload_1
        //   62: astore 4
        //   64: new 139	java/io/BufferedReader
        //   67: dup
        //   68: new 141	java/io/InputStreamReader
        //   71: dup
        //   72: aload_1
        //   73: ldc -111
        //   75: invokespecial 148	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   78: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   81: astore 5
        //   83: new 109	java/lang/StringBuilder
        //   86: dup
        //   87: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   90: astore_3
        //   91: aload 5
        //   93: invokevirtual 171	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   96: astore_2
        //   97: aload_2
        //   98: ifnull +64 -> 162
        //   101: aload_3
        //   102: aload_2
        //   103: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: ldc -83
        //   108: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   111: pop
        //   112: goto -21 -> 91
        //   115: astore_2
        //   116: aload 5
        //   118: astore_3
        //   119: aload_2
        //   120: astore 5
        //   122: aload_1
        //   123: astore_2
        //   124: new 63	twitter4j/TwitterException
        //   127: dup
        //   128: aload 5
        //   130: invokevirtual 174	java/io/IOException:getMessage	()Ljava/lang/String;
        //   133: aload 5
        //   135: invokespecial 125	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   138: athrow
        //   139: astore_1
        //   140: aload_2
        //   141: ifnull +7 -> 148
        //   144: aload_2
        //   145: invokevirtual 165	java/io/InputStream:close	()V
        //   148: aload_3
        //   149: ifnull +7 -> 156
        //   152: aload_3
        //   153: invokevirtual 175	java/io/BufferedReader:close	()V
        //   156: aload_0
        //   157: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   160: aload_1
        //   161: athrow
        //   162: aload_0
        //   163: aload_3
        //   164: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   167: putfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   170: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
        //   173: aload_0
        //   174: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   177: invokevirtual 95	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
        //   180: aload_1
        //   181: invokevirtual 165	java/io/InputStream:close	()V
        //   184: aload_0
        //   185: iconst_1
        //   186: putfield 40	twitter4j/internal/http/HttpResponse:streamConsumed	Z
        //   189: aload_1
        //   190: ifnull +7 -> 197
        //   193: aload_1
        //   194: invokevirtual 165	java/io/InputStream:close	()V
        //   197: aload 5
        //   199: ifnull +8 -> 207
        //   202: aload 5
        //   204: invokevirtual 175	java/io/BufferedReader:close	()V
        //   207: aload_0
        //   208: invokespecial 102	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
        //   211: aload_0
        //   212: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
        //   215: areturn
        //   216: astore_1
        //   217: goto -179 -> 38
        //   220: astore_1
        //   221: goto -171 -> 50
        //   224: astore_1
        //   225: goto -28 -> 197
        //   228: astore_1
        //   229: goto -22 -> 207
        //   232: astore_2
        //   233: goto -85 -> 148
        //   236: astore_2
        //   237: goto -81 -> 156
        //   240: astore 4
        //   242: aload 5
        //   244: astore_3
        //   245: aload_1
        //   246: astore_2
        //   247: aload 4
        //   249: astore_1
        //   250: goto -110 -> 140
        //   253: astore 5
        //   255: aload 6
        //   257: astore_3
        //   258: aload 4
        //   260: astore_1
        //   261: goto -139 -> 122
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	264	0	this	HttpResponse
        //   25	98	1	localInputStream	InputStream
        //   139	55	1	localObject1	Object
        //   216	1	1	localIOException1	IOException
        //   220	1	1	localIOException2	IOException
        //   224	1	1	localIOException3	IOException
        //   228	18	1	localIOException4	IOException
        //   249	12	1	localObject2	Object
        //   17	86	2	localObject3	Object
        //   115	5	2	localIOException5	IOException
        //   123	22	2	localObject4	Object
        //   232	1	2	localIOException6	IOException
        //   236	1	2	localIOException7	IOException
        //   246	1	2	localObject5	Object
        //   20	238	3	localObject6	Object
        //   14	49	4	localObject7	Object
        //   240	19	4	localObject8	Object
        //   8	235	5	localObject9	Object
        //   253	1	5	localIOException8	IOException
        //   11	245	6	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   83	91	115	java/io/IOException
        //   91	97	115	java/io/IOException
        //   101	112	115	java/io/IOException
        //   162	189	115	java/io/IOException
        //   21	26	139	finally
        //   64	83	139	finally
        //   124	139	139	finally
        //   34	38	216	java/io/IOException
        //   42	50	220	java/io/IOException
        //   193	197	224	java/io/IOException
        //   202	207	228	java/io/IOException
        //   144	148	232	java/io/IOException
        //   152	156	236	java/io/IOException
        //   83	91	240	finally
        //   91	97	240	finally
        //   101	112	240	finally
        //   162	189	240	finally
        //   21	26	253	java/io/IOException
        //   64	83	253	java/io/IOException
    }

    public abstract void disconnect()
            throws IOException;

    public abstract String getResponseHeader(String paramString);

    public abstract Map<String, List<String>> getResponseHeaderFields();

    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return "HttpResponse{statusCode=" + this.statusCode + ", responseAsString='" + this.responseAsString + '\'' + ", is=" + this.is + ", streamConsumed=" + this.streamConsumed + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */