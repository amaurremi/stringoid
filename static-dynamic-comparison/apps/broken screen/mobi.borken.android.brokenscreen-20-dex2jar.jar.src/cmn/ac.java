package cmn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public final class ac
{
  private static final Map a = new ad();
  private final a b;
  private int c;
  
  public ac(a parama)
  {
    this.b = a.a(parama);
    this.c = 0;
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = (String)a.b(this.b).get(this.c) + paramString;
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a()
  {
    try
    {
      this.c = ((this.c + 1) % a.b(this.b).size());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse.getEntity() != null) {
      paramHttpResponse.getEntity().consumeContent();
    }
  }
  
  /* Error */
  public final byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 80	cmn/z:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3: astore 6
    //   5: iconst_0
    //   6: istore_3
    //   7: aconst_null
    //   8: astore 5
    //   10: iload_3
    //   11: iconst_3
    //   12: if_icmpge +321 -> 333
    //   15: new 82	org/apache/http/client/methods/HttpPost
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 84	cmn/ac:a	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokespecial 87	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   27: astore 7
    //   29: aload_2
    //   30: ifnull +60 -> 90
    //   33: aload 7
    //   35: ldc 89
    //   37: ldc 91
    //   39: invokevirtual 95	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: new 97	java/io/ByteArrayOutputStream
    //   45: dup
    //   46: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   49: astore 5
    //   51: new 100	java/util/zip/GZIPOutputStream
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 103	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore 8
    //   62: aload 8
    //   64: aload_2
    //   65: invokevirtual 107	java/util/zip/GZIPOutputStream:write	([B)V
    //   68: aload 8
    //   70: invokevirtual 110	java/util/zip/GZIPOutputStream:close	()V
    //   73: aload 7
    //   75: new 112	org/apache/http/entity/ByteArrayEntity
    //   78: dup
    //   79: aload 5
    //   81: invokevirtual 116	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   84: invokespecial 118	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   87: invokevirtual 122	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   90: aload 6
    //   92: aload 7
    //   94: invokevirtual 128	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   97: astore 8
    //   99: aload 8
    //   101: invokeinterface 132 1 0
    //   106: invokeinterface 137 1 0
    //   111: sipush 200
    //   114: if_icmpne +131 -> 245
    //   117: new 139	java/util/zip/GZIPInputStream
    //   120: dup
    //   121: aload 8
    //   123: invokeinterface 65 1 0
    //   128: invokeinterface 143 1 0
    //   133: invokespecial 146	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   136: astore 5
    //   138: new 97	java/io/ByteArrayOutputStream
    //   141: dup
    //   142: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   145: astore 9
    //   147: sipush 128
    //   150: newarray <illegal type>
    //   152: astore 10
    //   154: aload 5
    //   156: aload 10
    //   158: invokevirtual 150	java/util/zip/GZIPInputStream:read	([B)I
    //   161: istore 4
    //   163: iload 4
    //   165: iconst_m1
    //   166: if_icmpeq +59 -> 225
    //   169: aload 9
    //   171: aload 10
    //   173: iconst_0
    //   174: iload 4
    //   176: invokevirtual 153	java/io/ByteArrayOutputStream:write	([BII)V
    //   179: goto -25 -> 154
    //   182: astore 5
    //   184: aload 8
    //   186: invokestatic 155	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
    //   189: aload 5
    //   191: athrow
    //   192: astore 5
    //   194: aload 7
    //   196: invokevirtual 158	org/apache/http/client/methods/HttpPost:abort	()V
    //   199: aload_0
    //   200: invokespecial 160	cmn/ac:a	()V
    //   203: iload_3
    //   204: iconst_1
    //   205: iadd
    //   206: istore_3
    //   207: goto -197 -> 10
    //   210: astore 5
    //   212: new 75	java/io/IOException
    //   215: dup
    //   216: aload 5
    //   218: invokevirtual 161	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   221: invokespecial 162	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   224: athrow
    //   225: aload 5
    //   227: invokevirtual 163	java/util/zip/GZIPInputStream:close	()V
    //   230: aload 9
    //   232: invokevirtual 116	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   235: astore 5
    //   237: aload 8
    //   239: invokestatic 155	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
    //   242: aload 5
    //   244: areturn
    //   245: aload 8
    //   247: invokeinterface 132 1 0
    //   252: invokeinterface 137 1 0
    //   257: istore 4
    //   259: iload 4
    //   261: sipush 204
    //   264: if_icmpne +10 -> 274
    //   267: aload 8
    //   269: invokestatic 155	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
    //   272: aconst_null
    //   273: areturn
    //   274: aload 8
    //   276: invokeinterface 132 1 0
    //   281: invokeinterface 137 1 0
    //   286: sipush 500
    //   289: if_icmpge +47 -> 336
    //   292: new 75	java/io/IOException
    //   295: dup
    //   296: new 34	java/lang/StringBuilder
    //   299: dup
    //   300: ldc -91
    //   302: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload 8
    //   307: invokeinterface 132 1 0
    //   312: invokeinterface 137 1 0
    //   317: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 162	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   326: astore 5
    //   328: aload 8
    //   330: invokestatic 155	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
    //   333: aload 5
    //   335: athrow
    //   336: new 97	java/io/ByteArrayOutputStream
    //   339: dup
    //   340: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   343: astore 5
    //   345: aload 8
    //   347: invokeinterface 65 1 0
    //   352: aload 5
    //   354: invokeinterface 172 2 0
    //   359: new 75	java/io/IOException
    //   362: dup
    //   363: new 34	java/lang/StringBuilder
    //   366: dup
    //   367: ldc -91
    //   369: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   372: aload 8
    //   374: invokeinterface 132 1 0
    //   379: invokeinterface 137 1 0
    //   384: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokespecial 162	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   393: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	ac
    //   0	394	1	paramString	String
    //   0	394	2	paramArrayOfByte	byte[]
    //   6	201	3	i	int
    //   161	104	4	j	int
    //   8	147	5	localObject1	Object
    //   182	8	5	localObject2	Object
    //   192	1	5	localIOException	java.io.IOException
    //   210	16	5	localRuntimeException	RuntimeException
    //   235	118	5	localObject3	Object
    //   3	88	6	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   27	168	7	localHttpPost	org.apache.http.client.methods.HttpPost
    //   60	313	8	localObject4	Object
    //   145	86	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   152	20	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   99	154	182	finally
    //   154	163	182	finally
    //   169	179	182	finally
    //   225	237	182	finally
    //   245	259	182	finally
    //   274	328	182	finally
    //   336	394	182	finally
    //   90	99	192	java/io/IOException
    //   184	192	192	java/io/IOException
    //   212	225	192	java/io/IOException
    //   237	242	192	java/io/IOException
    //   267	272	192	java/io/IOException
    //   328	333	192	java/io/IOException
    //   90	99	210	java/lang/RuntimeException
  }
  
  public static final class a
  {
    private final List a = new ArrayList();
    
    public a(List paramList)
    {
      this.a.addAll(paramList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */