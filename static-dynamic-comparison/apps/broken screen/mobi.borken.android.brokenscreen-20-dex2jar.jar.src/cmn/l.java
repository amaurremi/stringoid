package cmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l
{
  private final Map a = new HashMap();
  private r b;
  
  public final void a(String paramString, p paramp)
  {
    synchronized (this.a)
    {
      Object localObject = (List)this.a.get(paramString);
      if (localObject != null)
      {
        ((List)localObject).add(paramp);
        i = 1;
        if (i == 0) {
          new a(this, paramString).a(new Void[] { null });
        }
        return;
      }
      localObject = new ArrayList();
      ((List)localObject).add(paramp);
      this.a.put(paramString, localObject);
      int i = 0;
    }
  }
  
  private static final class a
    extends ag
  {
    private final l a;
    private final String b;
    
    public a(l paraml, String paramString)
    {
      this.a = paraml;
      this.b = paramString;
    }
    
    /* Error */
    private l.b c()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	cmn/l$a:a	Lcmn/l;
      //   4: invokestatic 27	cmn/l:a	(Lcmn/l;)Lcmn/r;
      //   7: astore_2
      //   8: aload_2
      //   9: ifnull +263 -> 272
      //   12: new 29	java/util/concurrent/Exchanger
      //   15: dup
      //   16: invokespecial 30	java/util/concurrent/Exchanger:<init>	()V
      //   19: astore_1
      //   20: aload_2
      //   21: aload_0
      //   22: getfield 19	cmn/l$a:b	Ljava/lang/String;
      //   25: new 32	cmn/m
      //   28: dup
      //   29: aload_0
      //   30: aload_1
      //   31: invokespecial 35	cmn/m:<init>	(Lcmn/l$a;Ljava/util/concurrent/Exchanger;)V
      //   34: invokevirtual 40	cmn/r:a	(Ljava/lang/Object;Lcmn/p;)V
      //   37: aload_1
      //   38: aconst_null
      //   39: invokevirtual 44	java/util/concurrent/Exchanger:exchange	(Ljava/lang/Object;)Ljava/lang/Object;
      //   42: checkcast 46	[B
      //   45: astore_1
      //   46: aload_1
      //   47: ifnonnull +222 -> 269
      //   50: aload_0
      //   51: getfield 19	cmn/l$a:b	Ljava/lang/String;
      //   54: ldc 48
      //   56: invokevirtual 54	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   59: ifeq +79 -> 138
      //   62: new 56	java/lang/StringBuilder
      //   65: dup
      //   66: ldc 58
      //   68: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   71: aload_0
      //   72: getfield 19	cmn/l$a:b	Ljava/lang/String;
      //   75: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   81: astore_1
      //   82: invokestatic 74	cmn/z:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
      //   85: new 76	org/apache/http/client/methods/HttpGet
      //   88: dup
      //   89: aload_1
      //   90: invokespecial 77	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
      //   93: invokevirtual 83	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
      //   96: astore_3
      //   97: aload_3
      //   98: invokeinterface 89 1 0
      //   103: invokeinterface 95 1 0
      //   108: sipush 404
      //   111: if_icmpne +35 -> 146
      //   114: new 97	cmn/l$b
      //   117: dup
      //   118: aconst_null
      //   119: new 99	java/io/IOException
      //   122: dup
      //   123: ldc 101
      //   125: invokespecial 102	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   128: invokespecial 105	cmn/l$b:<init>	([BLjava/lang/Throwable;)V
      //   131: astore_1
      //   132: aload_3
      //   133: invokestatic 110	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
      //   136: aload_1
      //   137: areturn
      //   138: aload_0
      //   139: getfield 19	cmn/l$a:b	Ljava/lang/String;
      //   142: astore_1
      //   143: goto -61 -> 82
      //   146: new 112	org/apache/http/entity/BufferedHttpEntity
      //   149: dup
      //   150: aload_3
      //   151: invokeinterface 116 1 0
      //   156: invokespecial 119	org/apache/http/entity/BufferedHttpEntity:<init>	(Lorg/apache/http/HttpEntity;)V
      //   159: invokevirtual 123	org/apache/http/entity/BufferedHttpEntity:getContent	()Ljava/io/InputStream;
      //   162: astore_1
      //   163: new 125	java/io/ByteArrayOutputStream
      //   166: dup
      //   167: invokespecial 126	java/io/ByteArrayOutputStream:<init>	()V
      //   170: astore 4
      //   172: ldc 127
      //   174: newarray <illegal type>
      //   176: astore 5
      //   178: aload_1
      //   179: invokevirtual 132	java/io/InputStream:available	()I
      //   182: ifle +38 -> 220
      //   185: aload 4
      //   187: aload 5
      //   189: iconst_0
      //   190: aload_1
      //   191: aload 5
      //   193: invokevirtual 136	java/io/InputStream:read	([B)I
      //   196: invokevirtual 140	java/io/ByteArrayOutputStream:write	([BII)V
      //   199: goto -21 -> 178
      //   202: astore_1
      //   203: aload_3
      //   204: invokestatic 110	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
      //   207: aload_1
      //   208: athrow
      //   209: astore_1
      //   210: new 97	cmn/l$b
      //   213: dup
      //   214: aconst_null
      //   215: aload_1
      //   216: invokespecial 105	cmn/l$b:<init>	([BLjava/lang/Throwable;)V
      //   219: areturn
      //   220: aload 4
      //   222: invokevirtual 144	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   225: astore_1
      //   226: aload_2
      //   227: ifnull +26 -> 253
      //   230: aload 4
      //   232: invokevirtual 147	java/io/ByteArrayOutputStream:size	()I
      //   235: aload_2
      //   236: invokevirtual 149	cmn/r:a	()I
      //   239: iconst_2
      //   240: idiv
      //   241: if_icmpge +12 -> 253
      //   244: aload_2
      //   245: aload_0
      //   246: getfield 19	cmn/l$a:b	Ljava/lang/String;
      //   249: aload_1
      //   250: invokevirtual 152	cmn/r:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   253: aload_3
      //   254: invokestatic 110	cmn/ac:a	(Lorg/apache/http/HttpResponse;)V
      //   257: new 97	cmn/l$b
      //   260: dup
      //   261: aload_1
      //   262: aconst_null
      //   263: invokespecial 105	cmn/l$b:<init>	([BLjava/lang/Throwable;)V
      //   266: astore_1
      //   267: aload_1
      //   268: areturn
      //   269: goto -12 -> 257
      //   272: aconst_null
      //   273: astore_1
      //   274: goto -228 -> 46
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	277	0	this	a
      //   19	172	1	localObject1	Object
      //   202	6	1	localObject2	Object
      //   209	7	1	localThrowable	Throwable
      //   225	49	1	localObject3	Object
      //   7	238	2	localr	r
      //   96	158	3	localHttpResponse	org.apache.http.HttpResponse
      //   170	61	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   176	16	5	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   97	132	202	finally
      //   146	178	202	finally
      //   178	199	202	finally
      //   220	226	202	finally
      //   230	253	202	finally
      //   12	46	209	java/lang/Throwable
      //   50	82	209	java/lang/Throwable
      //   82	97	209	java/lang/Throwable
      //   132	136	209	java/lang/Throwable
      //   138	143	209	java/lang/Throwable
      //   203	209	209	java/lang/Throwable
      //   253	257	209	java/lang/Throwable
      //   257	267	209	java/lang/Throwable
    }
  }
  
  public static final class b
  {
    private final byte[] a;
    private final Throwable b;
    
    public b(byte[] paramArrayOfByte, Throwable paramThrowable)
    {
      this.a = paramArrayOfByte;
      this.b = paramThrowable;
    }
    
    public final byte[] a()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */