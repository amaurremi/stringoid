package com.google.api.client.googleapis.media;

import com.google.api.client.http.ab;
import com.google.api.client.http.d;
import com.google.api.client.http.e;
import com.google.api.client.http.h;
import com.google.api.client.http.i;
import com.google.api.client.http.j;
import com.google.api.client.http.n;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.s;
import com.google.api.client.http.t;
import com.google.api.client.http.w;
import com.google.api.client.http.y;
import com.google.api.client.util.x;
import com.google.api.client.util.z;
import java.io.InputStream;
import java.util.Arrays;

public final class MediaHttpUploader
{
  z ZG = z.aef;
  private UploadState ZM = UploadState.aai;
  private final com.google.api.client.http.b ZN;
  private final r ZO;
  private final w ZP;
  private j ZQ;
  private long ZR;
  private boolean ZS;
  private String ZT = "POST";
  private n ZU = new n();
  private q ZV;
  private InputStream ZW;
  @Deprecated
  private boolean ZX = false;
  private boolean ZY;
  private a ZZ;
  String aaa = "*";
  private long aab;
  private int aac = 10485760;
  private Byte aad;
  private long aae;
  private int aaf;
  private byte[] aag;
  private boolean aah;
  
  public MediaHttpUploader(com.google.api.client.http.b paramb, w paramw, s params)
  {
    this.ZN = ((com.google.api.client.http.b)x.ad(paramb));
    this.ZP = ((w)x.ad(paramw));
    if (params == null) {}
    for (paramb = paramw.xS();; paramb = paramw.a(params))
    {
      this.ZO = paramb;
      return;
    }
  }
  
  private void a(UploadState paramUploadState)
  {
    this.ZM = paramUploadState;
    if (this.ZZ != null) {
      this.ZZ.a(this);
    }
  }
  
  private t b(i parami)
  {
    a(UploadState.aal);
    Object localObject1 = this.ZN;
    if (this.ZQ != null)
    {
      localObject1 = new ab().d(Arrays.asList(new j[] { this.ZQ, this.ZN }));
      parami.put("uploadType", "multipart");
    }
    for (;;)
    {
      parami = this.ZO.a(this.ZT, parami, (j)localObject1);
      parami.xC().putAll(this.ZU);
      parami = e(parami);
      try
      {
        if (wQ()) {
          this.aab = wR();
        }
        a(UploadState.aam);
        return parami;
      }
      finally
      {
        parami.disconnect();
      }
      parami.put("uploadType", "media");
    }
  }
  
  private long bz(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    return Long.parseLong(paramString.substring(paramString.indexOf('-') + 1)) + 1L;
  }
  
  /* Error */
  private t c(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 208	com/google/api/client/googleapis/media/MediaHttpUploader:d	(Lcom/google/api/client/http/i;)Lcom/google/api/client/http/t;
    //   5: astore_1
    //   6: aload_1
    //   7: invokevirtual 211	com/google/api/client/http/t:xL	()Z
    //   10: ifne +5 -> 15
    //   13: aload_1
    //   14: areturn
    //   15: new 145	com/google/api/client/http/i
    //   18: dup
    //   19: aload_1
    //   20: invokevirtual 212	com/google/api/client/http/t:xC	()Lcom/google/api/client/http/n;
    //   23: invokevirtual 216	com/google/api/client/http/n:getLocation	()Ljava/lang/String;
    //   26: invokespecial 219	com/google/api/client/http/i:<init>	(Ljava/lang/String;)V
    //   29: astore 9
    //   31: aload_1
    //   32: invokevirtual 188	com/google/api/client/http/t:disconnect	()V
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 92	com/google/api/client/googleapis/media/MediaHttpUploader:ZN	Lcom/google/api/client/http/b;
    //   40: invokevirtual 223	com/google/api/client/http/b:getInputStream	()Ljava/io/InputStream;
    //   43: putfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   46: aload 9
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   53: invokevirtual 230	java/io/InputStream:markSupported	()Z
    //   56: ifne +31 -> 87
    //   59: aload 9
    //   61: astore_1
    //   62: aload_0
    //   63: invokespecial 172	com/google/api/client/googleapis/media/MediaHttpUploader:wQ	()Z
    //   66: ifeq +21 -> 87
    //   69: aload_0
    //   70: new 232	java/io/BufferedInputStream
    //   73: dup
    //   74: aload_0
    //   75: getfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   78: invokespecial 235	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: putfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   84: aload 9
    //   86: astore_1
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 102	com/google/api/client/googleapis/media/MediaHttpUploader:ZO	Lcom/google/api/client/http/r;
    //   92: aload_1
    //   93: aconst_null
    //   94: invokevirtual 238	com/google/api/client/http/r:a	(Lcom/google/api/client/http/i;Lcom/google/api/client/http/j;)Lcom/google/api/client/http/q;
    //   97: putfield 240	com/google/api/client/googleapis/media/MediaHttpUploader:ZV	Lcom/google/api/client/http/q;
    //   100: aload_0
    //   101: invokespecial 243	com/google/api/client/googleapis/media/MediaHttpUploader:wS	()V
    //   104: aload_0
    //   105: getfield 68	com/google/api/client/googleapis/media/MediaHttpUploader:ZX	Z
    //   108: ifeq +88 -> 196
    //   111: aload_0
    //   112: getfield 240	com/google/api/client/googleapis/media/MediaHttpUploader:ZV	Lcom/google/api/client/http/q;
    //   115: new 245	com/google/api/client/googleapis/media/c
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 247	com/google/api/client/googleapis/media/c:<init>	(Lcom/google/api/client/googleapis/media/MediaHttpUploader;)V
    //   123: invokevirtual 250	com/google/api/client/http/q:a	(Lcom/google/api/client/http/c;)Lcom/google/api/client/http/q;
    //   126: pop
    //   127: aload_0
    //   128: invokespecial 172	com/google/api/client/googleapis/media/MediaHttpUploader:wQ	()Z
    //   131: ifeq +81 -> 212
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 240	com/google/api/client/googleapis/media/MediaHttpUploader:ZV	Lcom/google/api/client/http/q;
    //   139: invokespecial 252	com/google/api/client/googleapis/media/MediaHttpUploader:d	(Lcom/google/api/client/http/q;)Lcom/google/api/client/http/t;
    //   142: astore 9
    //   144: aload 9
    //   146: invokevirtual 211	com/google/api/client/http/t:xL	()Z
    //   149: ifeq +88 -> 237
    //   152: aload_0
    //   153: aload_0
    //   154: invokespecial 176	com/google/api/client/googleapis/media/MediaHttpUploader:wR	()J
    //   157: putfield 178	com/google/api/client/googleapis/media/MediaHttpUploader:aab	J
    //   160: aload_0
    //   161: getfield 92	com/google/api/client/googleapis/media/MediaHttpUploader:ZN	Lcom/google/api/client/http/b;
    //   164: invokevirtual 255	com/google/api/client/http/b:xm	()Z
    //   167: ifeq +10 -> 177
    //   170: aload_0
    //   171: getfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   174: invokevirtual 258	java/io/InputStream:close	()V
    //   177: aload_0
    //   178: getstatic 181	com/google/api/client/googleapis/media/MediaHttpUploader$UploadState:aam	Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;
    //   181: invokespecial 122	com/google/api/client/googleapis/media/MediaHttpUploader:a	(Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;)V
    //   184: aload 9
    //   186: areturn
    //   187: astore 9
    //   189: aload_1
    //   190: invokevirtual 188	com/google/api/client/http/t:disconnect	()V
    //   193: aload 9
    //   195: athrow
    //   196: new 260	com/google/api/client/googleapis/media/b
    //   199: dup
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 240	com/google/api/client/googleapis/media/MediaHttpUploader:ZV	Lcom/google/api/client/http/q;
    //   205: invokespecial 263	com/google/api/client/googleapis/media/b:<init>	(Lcom/google/api/client/googleapis/media/MediaHttpUploader;Lcom/google/api/client/http/q;)V
    //   208: pop
    //   209: goto -82 -> 127
    //   212: aload_0
    //   213: getfield 265	com/google/api/client/googleapis/media/MediaHttpUploader:aah	Z
    //   216: ifne -82 -> 134
    //   219: aload_0
    //   220: getfield 240	com/google/api/client/googleapis/media/MediaHttpUploader:ZV	Lcom/google/api/client/http/q;
    //   223: new 267	com/google/api/client/http/h
    //   226: dup
    //   227: invokespecial 268	com/google/api/client/http/h:<init>	()V
    //   230: invokevirtual 271	com/google/api/client/http/q:a	(Lcom/google/api/client/http/k;)Lcom/google/api/client/http/q;
    //   233: pop
    //   234: goto -100 -> 134
    //   237: aload 9
    //   239: invokevirtual 275	com/google/api/client/http/t:getStatusCode	()I
    //   242: sipush 308
    //   245: if_icmpeq +6 -> 251
    //   248: aload 9
    //   250: areturn
    //   251: aload 9
    //   253: invokevirtual 212	com/google/api/client/http/t:xC	()Lcom/google/api/client/http/n;
    //   256: invokevirtual 216	com/google/api/client/http/n:getLocation	()Ljava/lang/String;
    //   259: astore 10
    //   261: aload 10
    //   263: ifnull +13 -> 276
    //   266: new 145	com/google/api/client/http/i
    //   269: dup
    //   270: aload 10
    //   272: invokespecial 219	com/google/api/client/http/i:<init>	(Ljava/lang/String;)V
    //   275: astore_1
    //   276: aload_0
    //   277: aload 9
    //   279: invokevirtual 212	com/google/api/client/http/t:xC	()Lcom/google/api/client/http/n;
    //   282: invokevirtual 278	com/google/api/client/http/n:xs	()Ljava/lang/String;
    //   285: invokespecial 280	com/google/api/client/googleapis/media/MediaHttpUploader:bz	(Ljava/lang/String;)J
    //   288: lstore_2
    //   289: lload_2
    //   290: aload_0
    //   291: getfield 178	com/google/api/client/googleapis/media/MediaHttpUploader:aab	J
    //   294: lsub
    //   295: lstore 4
    //   297: lload 4
    //   299: lconst_0
    //   300: lcmp
    //   301: iflt +96 -> 397
    //   304: lload 4
    //   306: aload_0
    //   307: getfield 282	com/google/api/client/googleapis/media/MediaHttpUploader:aaf	I
    //   310: i2l
    //   311: lcmp
    //   312: ifgt +85 -> 397
    //   315: iconst_1
    //   316: istore 8
    //   318: iload 8
    //   320: invokestatic 286	com/google/api/client/util/x:aw	(Z)V
    //   323: aload_0
    //   324: getfield 282	com/google/api/client/googleapis/media/MediaHttpUploader:aaf	I
    //   327: i2l
    //   328: lload 4
    //   330: lsub
    //   331: lstore 6
    //   333: aload_0
    //   334: invokespecial 172	com/google/api/client/googleapis/media/MediaHttpUploader:wQ	()Z
    //   337: ifeq +72 -> 409
    //   340: lload 6
    //   342: lconst_0
    //   343: lcmp
    //   344: ifle +33 -> 377
    //   347: aload_0
    //   348: getfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   351: invokevirtual 289	java/io/InputStream:reset	()V
    //   354: lload 4
    //   356: aload_0
    //   357: getfield 225	com/google/api/client/googleapis/media/MediaHttpUploader:ZW	Ljava/io/InputStream;
    //   360: lload 4
    //   362: invokevirtual 293	java/io/InputStream:skip	(J)J
    //   365: lcmp
    //   366: ifne +37 -> 403
    //   369: iconst_1
    //   370: istore 8
    //   372: iload 8
    //   374: invokestatic 286	com/google/api/client/util/x:aw	(Z)V
    //   377: aload_0
    //   378: lload_2
    //   379: putfield 178	com/google/api/client/googleapis/media/MediaHttpUploader:aab	J
    //   382: aload_0
    //   383: getstatic 120	com/google/api/client/googleapis/media/MediaHttpUploader$UploadState:aal	Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;
    //   386: invokespecial 122	com/google/api/client/googleapis/media/MediaHttpUploader:a	(Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;)V
    //   389: aload 9
    //   391: invokevirtual 188	com/google/api/client/http/t:disconnect	()V
    //   394: goto -307 -> 87
    //   397: iconst_0
    //   398: istore 8
    //   400: goto -82 -> 318
    //   403: iconst_0
    //   404: istore 8
    //   406: goto -34 -> 372
    //   409: lload 6
    //   411: lconst_0
    //   412: lcmp
    //   413: ifne -36 -> 377
    //   416: aload_0
    //   417: aconst_null
    //   418: putfield 295	com/google/api/client/googleapis/media/MediaHttpUploader:aag	[B
    //   421: goto -44 -> 377
    //   424: astore_1
    //   425: aload 9
    //   427: invokevirtual 188	com/google/api/client/http/t:disconnect	()V
    //   430: aload_1
    //   431: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	MediaHttpUploader
    //   0	432	1	parami	i
    //   288	91	2	l1	long
    //   295	66	4	l2	long
    //   331	79	6	l3	long
    //   316	89	8	bool	boolean
    //   29	156	9	localObject	Object
    //   187	239	9	localt	t
    //   259	12	10	str	String
    // Exception table:
    //   from	to	target	type
    //   15	31	187	finally
    //   144	177	424	finally
    //   177	184	424	finally
    //   237	248	424	finally
    //   251	261	424	finally
    //   266	276	424	finally
    //   276	297	424	finally
    //   304	315	424	finally
    //   318	340	424	finally
    //   347	369	424	finally
    //   372	377	424	finally
    //   377	389	424	finally
    //   416	421	424	finally
  }
  
  /* Error */
  private t d(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 298	com/google/api/client/googleapis/media/MediaHttpUploader$UploadState:aaj	Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;
    //   4: invokespecial 122	com/google/api/client/googleapis/media/MediaHttpUploader:a	(Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;)V
    //   7: aload_1
    //   8: ldc -115
    //   10: ldc_w 300
    //   13: invokevirtual 149	com/google/api/client/http/i:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 124	com/google/api/client/googleapis/media/MediaHttpUploader:ZQ	Lcom/google/api/client/http/j;
    //   21: ifnonnull +94 -> 115
    //   24: new 302	com/google/api/client/http/e
    //   27: dup
    //   28: invokespecial 303	com/google/api/client/http/e:<init>	()V
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 102	com/google/api/client/googleapis/media/MediaHttpUploader:ZO	Lcom/google/api/client/http/r;
    //   36: aload_0
    //   37: getfield 61	com/google/api/client/googleapis/media/MediaHttpUploader:ZT	Ljava/lang/String;
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 154	com/google/api/client/http/r:a	(Ljava/lang/String;Lcom/google/api/client/http/i;Lcom/google/api/client/http/j;)Lcom/google/api/client/http/q;
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 66	com/google/api/client/googleapis/media/MediaHttpUploader:ZU	Lcom/google/api/client/http/n;
    //   50: ldc_w 305
    //   53: aload_0
    //   54: getfield 92	com/google/api/client/googleapis/media/MediaHttpUploader:ZN	Lcom/google/api/client/http/b;
    //   57: invokevirtual 308	com/google/api/client/http/b:getType	()Ljava/lang/String;
    //   60: invokevirtual 312	com/google/api/client/http/n:h	(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/http/n;
    //   63: pop
    //   64: aload_0
    //   65: invokespecial 172	com/google/api/client/googleapis/media/MediaHttpUploader:wQ	()Z
    //   68: ifeq +21 -> 89
    //   71: aload_0
    //   72: getfield 66	com/google/api/client/googleapis/media/MediaHttpUploader:ZU	Lcom/google/api/client/http/n;
    //   75: ldc_w 314
    //   78: aload_0
    //   79: invokespecial 176	com/google/api/client/googleapis/media/MediaHttpUploader:wR	()J
    //   82: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokevirtual 312	com/google/api/client/http/n:h	(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/http/n;
    //   88: pop
    //   89: aload_1
    //   90: invokevirtual 160	com/google/api/client/http/q:xC	()Lcom/google/api/client/http/n;
    //   93: aload_0
    //   94: getfield 66	com/google/api/client/googleapis/media/MediaHttpUploader:ZU	Lcom/google/api/client/http/n;
    //   97: invokevirtual 164	com/google/api/client/http/n:putAll	(Ljava/util/Map;)V
    //   100: aload_0
    //   101: aload_1
    //   102: invokespecial 168	com/google/api/client/googleapis/media/MediaHttpUploader:e	(Lcom/google/api/client/http/q;)Lcom/google/api/client/http/t;
    //   105: astore_1
    //   106: aload_0
    //   107: getstatic 321	com/google/api/client/googleapis/media/MediaHttpUploader$UploadState:aak	Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;
    //   110: invokespecial 122	com/google/api/client/googleapis/media/MediaHttpUploader:a	(Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;)V
    //   113: aload_1
    //   114: areturn
    //   115: aload_0
    //   116: getfield 124	com/google/api/client/googleapis/media/MediaHttpUploader:ZQ	Lcom/google/api/client/http/j;
    //   119: astore_2
    //   120: goto -88 -> 32
    //   123: astore_2
    //   124: aload_1
    //   125: invokevirtual 188	com/google/api/client/http/t:disconnect	()V
    //   128: aload_2
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	MediaHttpUploader
    //   0	130	1	parami	i
    //   31	89	2	localObject1	Object
    //   123	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   106	113	123	finally
  }
  
  private t d(q paramq)
  {
    new com.google.api.client.googleapis.b().b(paramq);
    paramq.as(false);
    return paramq.xJ();
  }
  
  private t e(q paramq)
  {
    if (this.ZX) {
      paramq.a(new com.google.api.client.http.f());
    }
    if ((!this.aah) && (!(paramq.xz() instanceof e))) {
      paramq.a(new h());
    }
    return d(paramq);
  }
  
  private boolean wQ()
  {
    return wR() >= 0L;
  }
  
  private long wR()
  {
    if (!this.ZS)
    {
      this.ZR = this.ZN.getLength();
      this.ZS = true;
    }
    return this.ZR;
  }
  
  private void wS()
  {
    if (wQ()) {}
    Object localObject;
    for (int i = (int)Math.min(this.aac, wR() - this.aab); wQ(); i = this.aac)
    {
      this.ZW.mark(i);
      localObject = com.google.api.client.util.f.a(this.ZW, i);
      localObject = new y(this.ZN.getType(), (InputStream)localObject).at(true).y(i).au(false);
      this.aaa = String.valueOf(wR());
      this.aaf = i;
      this.ZV.c((j)localObject);
      if (i != 0) {
        break label391;
      }
      this.ZV.xC().bR("bytes */0");
      return;
    }
    int j;
    label154:
    int m;
    int k;
    if (this.aag == null) {
      if (this.aad == null)
      {
        j = i + 1;
        this.aag = new byte[i + 1];
        if (this.aad == null) {
          break label457;
        }
        this.aag[0] = this.aad.byteValue();
        m = 0;
        k = j;
        j = m;
      }
    }
    for (;;)
    {
      label191:
      m = com.google.api.client.util.f.a(this.ZW, this.aag, i + 1 - k, k);
      if (m < k)
      {
        j = Math.max(0, m) + j;
        i = j;
        if (this.aad != null)
        {
          i = j + 1;
          this.aad = null;
        }
        j = i;
        if (this.aaa.equals("*")) {
          this.aaa = String.valueOf(this.aab + i);
        }
      }
      for (j = i;; j = i)
      {
        localObject = new d(this.ZN.getType(), this.aag, 0, j);
        this.aae = (this.aab + j);
        i = j;
        break;
        j = i;
        break label154;
        j = (int)(this.aae - this.aab);
        System.arraycopy(this.aag, this.aaf - j, this.aag, 0, j);
        if (this.aad != null) {
          this.aag[j] = this.aad.byteValue();
        }
        k = i - j;
        break label191;
        this.aad = Byte.valueOf(this.aag[i]);
      }
      label391:
      this.ZV.xC().bR("bytes " + this.aab + "-" + (this.aab + i - 1L) + "/" + this.aaa);
      return;
      label457:
      k = j;
      j = 0;
    }
  }
  
  public MediaHttpUploader a(j paramj)
  {
    this.ZQ = paramj;
    return this;
  }
  
  public MediaHttpUploader a(n paramn)
  {
    this.ZU = paramn;
    return this;
  }
  
  public t a(i parami)
  {
    if (this.ZM == UploadState.aai) {}
    for (boolean bool = true;; bool = false)
    {
      x.av(bool);
      if (!this.ZY) {
        break;
      }
      return b(parami);
    }
    return c(parami);
  }
  
  public MediaHttpUploader am(boolean paramBoolean)
  {
    this.aah = paramBoolean;
    return this;
  }
  
  public MediaHttpUploader bA(String paramString)
  {
    if ((paramString.equals("POST")) || (paramString.equals("PUT"))) {}
    for (boolean bool = true;; bool = false)
    {
      x.av(bool);
      this.ZT = paramString;
      return this;
    }
  }
  
  void wT()
  {
    x.h(this.ZV, "The current request should not be null");
    this.ZV.c(new e());
    n localn = this.ZV.xC();
    StringBuilder localStringBuilder = new StringBuilder().append("bytes */");
    if (wQ()) {}
    for (Object localObject = Long.valueOf(wR());; localObject = "*")
    {
      localn.bR(localObject);
      return;
    }
  }
  
  public static enum UploadState
  {
    private UploadState() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/media/MediaHttpUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */