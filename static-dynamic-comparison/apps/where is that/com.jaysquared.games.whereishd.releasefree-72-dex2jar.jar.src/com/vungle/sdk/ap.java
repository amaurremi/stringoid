package com.vungle.sdk;

final class ap
{
  public static final int[] a = { 10, 30, 30, 60, 60, 120 };
  private int b = 0;
  private int c = 0;
  private int d = a[0];
  private String e = null;
  private String f = null;
  private a g = null;
  private String h = null;
  private b i = null;
  private String j = null;
  
  public ap(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public ap(String paramString1, String paramString2, String paramString3)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.h = paramString3;
  }
  
  public final void a()
  {
    this.g = new a((byte)0);
    this.g.a(this.e, this.f, this.h);
  }
  
  public final void a(b paramb)
  {
    this.i = paramb;
  }
  
  public final void a(String paramString)
  {
    this.j = paramString;
  }
  
  public final boolean b()
  {
    int k = this.b + 1;
    this.b = k;
    if (k <= 3) {}
    for (k = 1; k == 0; k = 0) {
      return false;
    }
    new StringBuilder("Downloading file (").append(this.g.e).append(") again... Retry #").append(this.b);
    this.g = new a((byte)0);
    this.g.a(this.e, this.f, this.h);
    return true;
  }
  
  public final boolean c()
  {
    if (this.g != null) {
      return this.g.a();
    }
    return false;
  }
  
  public final String d()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.g != null)
    {
      a locala = this.g;
      localObject1 = localObject2;
      if (locala.a()) {
        localObject1 = locala.c;
      }
    }
    return (String)localObject1;
  }
  
  private final class a
  {
    boolean a = false;
    boolean b = true;
    String c;
    String d = null;
    String e = null;
    boolean f = false;
    
    private a() {}
    
    /* Error */
    protected final Boolean a(String... paramVarArgs)
    {
      // Byte code:
      //   0: new 44	java/net/URL
      //   3: dup
      //   4: aload_1
      //   5: iconst_0
      //   6: aaload
      //   7: invokespecial 47	java/net/URL:<init>	(Ljava/lang/String;)V
      //   10: astore_3
      //   11: aload_3
      //   12: invokevirtual 51	java/net/URL:getFile	()Ljava/lang/String;
      //   15: getstatic 56	java/io/File:separator	Ljava/lang/String;
      //   18: invokevirtual 62	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   21: astore 4
      //   23: aload_0
      //   24: aload 4
      //   26: aload 4
      //   28: arraylength
      //   29: iconst_1
      //   30: isub
      //   31: aaload
      //   32: putfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   35: aload_0
      //   36: aload_0
      //   37: getfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   40: ldc 64
      //   42: invokestatic 70	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   45: putfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   48: aload_0
      //   49: getfield 20	com/vungle/sdk/ap$a:g	Lcom/vungle/sdk/ap;
      //   52: invokestatic 73	com/vungle/sdk/ap:a	(Lcom/vungle/sdk/ap;)Ljava/lang/String;
      //   55: ifnull +34 -> 89
      //   58: aload_0
      //   59: new 75	java/lang/StringBuilder
      //   62: dup
      //   63: invokespecial 76	java/lang/StringBuilder:<init>	()V
      //   66: aload_0
      //   67: getfield 20	com/vungle/sdk/ap$a:g	Lcom/vungle/sdk/ap;
      //   70: invokestatic 73	com/vungle/sdk/ap:a	(Lcom/vungle/sdk/ap;)Ljava/lang/String;
      //   73: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: aload_0
      //   77: getfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   80: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   86: putfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   89: new 53	java/io/File
      //   92: dup
      //   93: aload_1
      //   94: iconst_1
      //   95: aaload
      //   96: aload_0
      //   97: getfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   100: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: astore 4
      //   105: aload_0
      //   106: aload 4
      //   108: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   111: putfield 91	com/vungle/sdk/ap$a:c	Ljava/lang/String;
      //   114: aload_1
      //   115: arraylength
      //   116: iconst_3
      //   117: if_icmplt +10 -> 127
      //   120: aload_0
      //   121: aload_1
      //   122: iconst_2
      //   123: aaload
      //   124: putfield 29	com/vungle/sdk/ap$a:d	Ljava/lang/String;
      //   127: aload_3
      //   128: invokevirtual 95	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   131: astore_1
      //   132: aload_1
      //   133: sipush 5000
      //   136: invokevirtual 101	java/net/URLConnection:setConnectTimeout	(I)V
      //   139: aload_1
      //   140: sipush 5000
      //   143: invokevirtual 104	java/net/URLConnection:setReadTimeout	(I)V
      //   146: aload_1
      //   147: invokevirtual 107	java/net/URLConnection:connect	()V
      //   150: new 109	java/io/BufferedInputStream
      //   153: dup
      //   154: aload_1
      //   155: invokevirtual 113	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
      //   158: invokespecial 116	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   161: astore_1
      //   162: new 75	java/lang/StringBuilder
      //   165: dup
      //   166: ldc 118
      //   168: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   171: aload_0
      //   172: getfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   175: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: pop
      //   179: new 121	java/io/FileOutputStream
      //   182: dup
      //   183: aload 4
      //   185: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   188: astore_3
      //   189: sipush 2048
      //   192: newarray <illegal type>
      //   194: astore 4
      //   196: aload_1
      //   197: aload 4
      //   199: invokevirtual 130	java/io/InputStream:read	([B)I
      //   202: istore_2
      //   203: iload_2
      //   204: iconst_m1
      //   205: if_icmpeq +56 -> 261
      //   208: aload_3
      //   209: aload 4
      //   211: iconst_0
      //   212: iload_2
      //   213: invokevirtual 136	java/io/OutputStream:write	([BII)V
      //   216: goto -20 -> 196
      //   219: astore_1
      //   220: new 75	java/lang/StringBuilder
      //   223: dup
      //   224: ldc -118
      //   226: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   229: aload_1
      //   230: invokevirtual 141	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   233: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   236: pop
      //   237: aload_0
      //   238: iconst_1
      //   239: putfield 33	com/vungle/sdk/ap$a:f	Z
      //   242: iconst_0
      //   243: invokestatic 147	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   246: areturn
      //   247: astore 4
      //   249: ldc -107
      //   251: ldc -105
      //   253: aload 4
      //   255: invokestatic 156	com/vungle/sdk/av:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   258: goto -210 -> 48
      //   261: aload_3
      //   262: invokevirtual 159	java/io/OutputStream:flush	()V
      //   265: aload_3
      //   266: invokevirtual 162	java/io/OutputStream:close	()V
      //   269: aload_1
      //   270: invokevirtual 163	java/io/InputStream:close	()V
      //   273: new 75	java/lang/StringBuilder
      //   276: dup
      //   277: ldc -91
      //   279: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   282: aload_0
      //   283: getfield 31	com/vungle/sdk/ap$a:e	Ljava/lang/String;
      //   286: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   289: pop
      //   290: iconst_1
      //   291: invokestatic 147	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   294: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	295	0	this	a
      //   0	295	1	paramVarArgs	String[]
      //   202	11	2	i	int
      //   10	256	3	localObject1	Object
      //   21	189	4	localObject2	Object
      //   247	7	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
      // Exception table:
      //   from	to	target	type
      //   0	35	219	java/lang/Exception
      //   35	48	219	java/lang/Exception
      //   48	89	219	java/lang/Exception
      //   89	127	219	java/lang/Exception
      //   127	196	219	java/lang/Exception
      //   196	203	219	java/lang/Exception
      //   208	216	219	java/lang/Exception
      //   249	258	219	java/lang/Exception
      //   261	290	219	java/lang/Exception
      //   35	48	247	java/io/UnsupportedEncodingException
    }
    
    public final void a(String paramString1, String paramString2, String paramString3)
    {
      new Thread(new aq(this, paramString1, paramString2, paramString3), "VungleDownloadThread").start();
    }
    
    public final boolean a()
    {
      return (this.a) && (this.b);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */