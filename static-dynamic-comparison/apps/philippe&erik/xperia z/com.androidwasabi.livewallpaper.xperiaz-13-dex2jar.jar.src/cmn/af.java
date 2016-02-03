package cmn;

final class af
  extends g
{
  private final ae d;
  private final String e;
  
  public af(ae paramae, String paramString)
  {
    this.d = paramae;
    this.e = paramString;
  }
  
  /* Error */
  private ag c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	cmn/af:d	Lcmn/ae;
    //   4: invokestatic 28	cmn/ae:a	(Lcmn/ae;)Lcmn/ak;
    //   7: astore_2
    //   8: new 30	org/apache/http/client/methods/HttpGet
    //   11: dup
    //   12: aload_0
    //   13: getfield 17	cmn/af:e	Ljava/lang/String;
    //   16: invokespecial 33	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_2
    //   21: ifnull +216 -> 237
    //   24: new 35	java/util/concurrent/Exchanger
    //   27: dup
    //   28: invokespecial 36	java/util/concurrent/Exchanger:<init>	()V
    //   31: astore_1
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 17	cmn/af:e	Ljava/lang/String;
    //   37: new 38	cmn/ah
    //   40: dup
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 41	cmn/ah:<init>	(Lcmn/af;Ljava/util/concurrent/Exchanger;)V
    //   46: invokevirtual 46	cmn/ak:a	(Ljava/lang/Object;Lcmn/ai;)V
    //   49: aload_1
    //   50: aconst_null
    //   51: invokevirtual 50	java/util/concurrent/Exchanger:exchange	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 52	[B
    //   57: astore_1
    //   58: aload_1
    //   59: ifnonnull +175 -> 234
    //   62: invokestatic 57	cmn/aq:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   65: aload_3
    //   66: invokevirtual 63	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   69: astore_3
    //   70: aload_3
    //   71: invokeinterface 69 1 0
    //   76: invokeinterface 75 1 0
    //   81: sipush 404
    //   84: if_icmpne +27 -> 111
    //   87: new 77	cmn/ag
    //   90: dup
    //   91: aconst_null
    //   92: new 79	java/io/IOException
    //   95: dup
    //   96: ldc 81
    //   98: invokespecial 82	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   101: invokespecial 85	cmn/ag:<init>	([BLjava/lang/Throwable;)V
    //   104: astore_1
    //   105: aload_3
    //   106: invokestatic 90	cmn/c:a	(Lorg/apache/http/HttpResponse;)V
    //   109: aload_1
    //   110: areturn
    //   111: new 92	org/apache/http/entity/BufferedHttpEntity
    //   114: dup
    //   115: aload_3
    //   116: invokeinterface 96 1 0
    //   121: invokespecial 99	org/apache/http/entity/BufferedHttpEntity:<init>	(Lorg/apache/http/HttpEntity;)V
    //   124: invokevirtual 103	org/apache/http/entity/BufferedHttpEntity:getContent	()Ljava/io/InputStream;
    //   127: astore_1
    //   128: new 105	java/io/ByteArrayOutputStream
    //   131: dup
    //   132: invokespecial 106	java/io/ByteArrayOutputStream:<init>	()V
    //   135: astore 4
    //   137: ldc 107
    //   139: newarray <illegal type>
    //   141: astore 5
    //   143: aload_1
    //   144: invokevirtual 112	java/io/InputStream:available	()I
    //   147: ifle +38 -> 185
    //   150: aload 4
    //   152: aload 5
    //   154: iconst_0
    //   155: aload_1
    //   156: aload 5
    //   158: invokevirtual 116	java/io/InputStream:read	([B)I
    //   161: invokevirtual 120	java/io/ByteArrayOutputStream:write	([BII)V
    //   164: goto -21 -> 143
    //   167: astore_1
    //   168: aload_3
    //   169: invokestatic 90	cmn/c:a	(Lorg/apache/http/HttpResponse;)V
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: new 77	cmn/ag
    //   178: dup
    //   179: aconst_null
    //   180: aload_1
    //   181: invokespecial 85	cmn/ag:<init>	([BLjava/lang/Throwable;)V
    //   184: areturn
    //   185: aload 4
    //   187: invokevirtual 124	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   190: astore_1
    //   191: aload_2
    //   192: ifnull +26 -> 218
    //   195: aload 4
    //   197: invokevirtual 127	java/io/ByteArrayOutputStream:size	()I
    //   200: aload_2
    //   201: invokevirtual 129	cmn/ak:a	()I
    //   204: iconst_2
    //   205: idiv
    //   206: if_icmpge +12 -> 218
    //   209: aload_2
    //   210: aload_0
    //   211: getfield 17	cmn/af:e	Ljava/lang/String;
    //   214: aload_1
    //   215: invokevirtual 132	cmn/ak:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   218: aload_3
    //   219: invokestatic 90	cmn/c:a	(Lorg/apache/http/HttpResponse;)V
    //   222: new 77	cmn/ag
    //   225: dup
    //   226: aload_1
    //   227: aconst_null
    //   228: invokespecial 85	cmn/ag:<init>	([BLjava/lang/Throwable;)V
    //   231: astore_1
    //   232: aload_1
    //   233: areturn
    //   234: goto -12 -> 222
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -181 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	af
    //   31	125	1	localObject1	Object
    //   167	6	1	localObject2	Object
    //   174	7	1	localThrowable	Throwable
    //   190	49	1	localObject3	Object
    //   7	203	2	localak	ak
    //   19	200	3	localObject4	Object
    //   135	61	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   141	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   70	105	167	finally
    //   111	143	167	finally
    //   143	164	167	finally
    //   185	191	167	finally
    //   195	218	167	finally
    //   24	58	174	java/lang/Throwable
    //   62	70	174	java/lang/Throwable
    //   105	109	174	java/lang/Throwable
    //   168	174	174	java/lang/Throwable
    //   218	222	174	java/lang/Throwable
    //   222	232	174	java/lang/Throwable
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */