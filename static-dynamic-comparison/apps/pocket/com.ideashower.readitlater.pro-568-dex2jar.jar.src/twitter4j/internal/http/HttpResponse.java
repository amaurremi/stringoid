package twitter4j.internal.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONObject;

public abstract class HttpResponse
{
  private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
  protected final HttpClientConfiguration CONF;
  protected InputStream is;
  private JSONObject json = null;
  private JSONArray jsonArray = null;
  protected String responseAsString = null;
  protected int statusCode;
  private boolean streamConsumed = false;
  
  HttpResponse()
  {
    this.CONF = ConfigurationContext.getInstance();
  }
  
  public HttpResponse(HttpClientConfiguration paramHttpClientConfiguration)
  {
    this.CONF = paramHttpClientConfiguration;
  }
  
  private void disconnectForcibly()
  {
    try
    {
      disconnect();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public JSONArray asJSONArray()
  {
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
    //   35: invokevirtual 69	twitter4j/internal/http/HttpResponse:asReader	()Ljava/io/Reader;
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: astore_1
    //   43: aload_0
    //   44: new 71	twitter4j/internal/org/json/JSONArray
    //   47: dup
    //   48: new 73	twitter4j/internal/org/json/JSONTokener
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 76	twitter4j/internal/org/json/JSONTokener:<init>	(Ljava/io/Reader;)V
    //   56: invokespecial 79	twitter4j/internal/org/json/JSONArray:<init>	(Ltwitter4j/internal/org/json/JSONTokener;)V
    //   59: putfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 52	twitter4j/internal/http/HttpResponse:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   70: invokeinterface 85 1 0
    //   75: ifeq +129 -> 204
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   85: aload_0
    //   86: getfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   89: iconst_1
    //   90: invokevirtual 89	twitter4j/internal/org/json/JSONArray:toString	(I)Ljava/lang/String;
    //   93: invokevirtual 93	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 98	java/io/Reader:close	()V
    //   104: aload_0
    //   105: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   108: aload_0
    //   109: getfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   112: areturn
    //   113: aload 4
    //   115: astore_2
    //   116: aload 5
    //   118: astore_1
    //   119: aload_0
    //   120: new 71	twitter4j/internal/org/json/JSONArray
    //   123: dup
    //   124: aload_0
    //   125: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   128: invokespecial 102	twitter4j/internal/org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   131: putfield 44	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   134: goto -72 -> 62
    //   137: astore_3
    //   138: aload_2
    //   139: astore_1
    //   140: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   143: invokevirtual 105	twitter4j/internal/logging/Logger:isDebugEnabled	()Z
    //   146: ifeq +118 -> 264
    //   149: aload_2
    //   150: astore_1
    //   151: new 107	twitter4j/TwitterException
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
    //   195: invokevirtual 98	java/io/Reader:close	()V
    //   198: aload_0
    //   199: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
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
    //   242: invokevirtual 93	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
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
    //   266: new 107	twitter4j/TwitterException
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
    //   279	1	1	localIOException1	java.io.IOException
    //   283	1	1	localIOException2	java.io.IOException
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
  {
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
    //   35: invokevirtual 69	twitter4j/internal/http/HttpResponse:asReader	()Ljava/io/Reader;
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: astore_1
    //   43: aload_0
    //   44: new 130	twitter4j/internal/org/json/JSONObject
    //   47: dup
    //   48: new 73	twitter4j/internal/org/json/JSONTokener
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 76	twitter4j/internal/org/json/JSONTokener:<init>	(Ljava/io/Reader;)V
    //   56: invokespecial 131	twitter4j/internal/org/json/JSONObject:<init>	(Ltwitter4j/internal/org/json/JSONTokener;)V
    //   59: putfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 52	twitter4j/internal/http/HttpResponse:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   70: invokeinterface 85 1 0
    //   75: ifeq +102 -> 177
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   85: aload_0
    //   86: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   89: iconst_1
    //   90: invokevirtual 132	twitter4j/internal/org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   93: invokevirtual 93	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 98	java/io/Reader:close	()V
    //   104: aload_0
    //   105: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   108: aload_0
    //   109: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   112: areturn
    //   113: aload 4
    //   115: astore_2
    //   116: aload 5
    //   118: astore_1
    //   119: aload_0
    //   120: new 130	twitter4j/internal/org/json/JSONObject
    //   123: dup
    //   124: aload_0
    //   125: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   128: invokespecial 133	twitter4j/internal/org/json/JSONObject:<init>	(Ljava/lang/String;)V
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
    //   149: new 107	twitter4j/TwitterException
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
    //   168: invokevirtual 98	java/io/Reader:close	()V
    //   171: aload_0
    //   172: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
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
    //   215: invokevirtual 93	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   218: goto -122 -> 96
    //   221: aload_3
    //   222: astore_2
    //   223: aload_3
    //   224: astore_1
    //   225: aload_0
    //   226: getfield 42	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   229: invokevirtual 134	twitter4j/internal/org/json/JSONObject:toString	()Ljava/lang/String;
    //   232: astore 4
    //   234: goto -27 -> 207
    //   237: aload_2
    //   238: astore_1
    //   239: new 107	twitter4j/TwitterException
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
    //   277	1	1	localIOException1	java.io.IOException
    //   281	1	1	localIOException2	java.io.IOException
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
  
  public Reader asReader()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.is, "UTF-8"));
      return localBufferedReader;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new InputStreamReader(this.is);
  }
  
  public InputStream asStream()
  {
    if (this.streamConsumed) {
      throw new IllegalStateException("Stream has already been consumed.");
    }
    return this.is;
  }
  
  /* Error */
  public String asString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   4: ifnonnull +186 -> 190
    //   7: aload_0
    //   8: invokevirtual 161	twitter4j/internal/http/HttpResponse:asStream	()Ljava/io/InputStream;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +29 -> 42
    //   16: aload_1
    //   17: ifnull +7 -> 24
    //   20: aload_1
    //   21: invokevirtual 164	java/io/InputStream:close	()V
    //   24: iconst_0
    //   25: ifeq +11 -> 36
    //   28: new 166	java/lang/NullPointerException
    //   31: dup
    //   32: invokespecial 167	java/lang/NullPointerException:<init>	()V
    //   35: athrow
    //   36: aload_0
    //   37: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   40: aconst_null
    //   41: areturn
    //   42: new 138	java/io/BufferedReader
    //   45: dup
    //   46: new 140	java/io/InputStreamReader
    //   49: dup
    //   50: aload_1
    //   51: ldc -112
    //   53: invokespecial 147	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   56: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_3
    //   60: new 109	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   67: astore 4
    //   69: aload_3
    //   70: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +67 -> 142
    //   78: aload 4
    //   80: aload_2
    //   81: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc -84
    //   86: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: goto -21 -> 69
    //   93: astore 4
    //   95: aload_3
    //   96: astore_2
    //   97: aload 4
    //   99: astore_3
    //   100: new 107	twitter4j/TwitterException
    //   103: dup
    //   104: aload_3
    //   105: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   108: aload_3
    //   109: invokespecial 125	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: athrow
    //   113: astore 4
    //   115: aload_2
    //   116: astore_3
    //   117: aload 4
    //   119: astore_2
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 164	java/io/InputStream:close	()V
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 174	java/io/BufferedReader:close	()V
    //   136: aload_0
    //   137: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   140: aload_2
    //   141: athrow
    //   142: aload_0
    //   143: aload 4
    //   145: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: putfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   151: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   154: aload_0
    //   155: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   158: invokevirtual 93	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: invokevirtual 164	java/io/InputStream:close	()V
    //   165: aload_0
    //   166: iconst_1
    //   167: putfield 40	twitter4j/internal/http/HttpResponse:streamConsumed	Z
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 164	java/io/InputStream:close	()V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 174	java/io/BufferedReader:close	()V
    //   186: aload_0
    //   187: invokespecial 100	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   190: aload_0
    //   191: getfield 38	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   194: areturn
    //   195: astore_1
    //   196: goto -172 -> 24
    //   199: astore_1
    //   200: goto -164 -> 36
    //   203: astore_1
    //   204: goto -26 -> 178
    //   207: astore_1
    //   208: goto -22 -> 186
    //   211: astore_1
    //   212: goto -84 -> 128
    //   215: astore_1
    //   216: goto -80 -> 136
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_3
    //   224: goto -104 -> 120
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_3
    //   230: goto -110 -> 120
    //   233: astore_2
    //   234: goto -114 -> 120
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_1
    //   242: goto -142 -> 100
    //   245: astore_3
    //   246: aconst_null
    //   247: astore_2
    //   248: goto -148 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	HttpResponse
    //   11	164	1	localInputStream	InputStream
    //   195	1	1	localIOException1	java.io.IOException
    //   199	1	1	localIOException2	java.io.IOException
    //   203	1	1	localIOException3	java.io.IOException
    //   207	1	1	localIOException4	java.io.IOException
    //   211	1	1	localIOException5	java.io.IOException
    //   215	1	1	localIOException6	java.io.IOException
    //   221	21	1	localObject1	Object
    //   73	68	2	localObject2	Object
    //   219	1	2	localObject3	Object
    //   227	1	2	localObject4	Object
    //   233	1	2	localObject5	Object
    //   239	9	2	localObject6	Object
    //   59	171	3	localObject7	Object
    //   237	1	3	localIOException7	java.io.IOException
    //   245	1	3	localIOException8	java.io.IOException
    //   67	12	4	localStringBuilder	StringBuilder
    //   93	5	4	localIOException9	java.io.IOException
    //   113	31	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   60	69	93	java/io/IOException
    //   69	74	93	java/io/IOException
    //   78	90	93	java/io/IOException
    //   142	170	93	java/io/IOException
    //   100	113	113	finally
    //   20	24	195	java/io/IOException
    //   28	36	199	java/io/IOException
    //   174	178	203	java/io/IOException
    //   182	186	207	java/io/IOException
    //   124	128	211	java/io/IOException
    //   132	136	215	java/io/IOException
    //   7	12	219	finally
    //   42	60	227	finally
    //   60	69	233	finally
    //   69	74	233	finally
    //   78	90	233	finally
    //   142	170	233	finally
    //   7	12	237	java/io/IOException
    //   42	60	245	java/io/IOException
  }
  
  public abstract void disconnect();
  
  public abstract String getResponseHeader(String paramString);
  
  public abstract Map getResponseHeaderFields();
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String toString()
  {
    return "HttpResponse{statusCode=" + this.statusCode + ", responseAsString='" + this.responseAsString + '\'' + ", is=" + this.is + ", streamConsumed=" + this.streamConsumed + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/http/HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */