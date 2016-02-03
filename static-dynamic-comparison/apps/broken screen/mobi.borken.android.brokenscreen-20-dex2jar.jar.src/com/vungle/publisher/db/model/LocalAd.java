package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.vungle.publisher.ap;
import com.vungle.publisher.as;
import com.vungle.publisher.at.a;
import com.vungle.publisher.at.b;
import com.vungle.publisher.bj;
import com.vungle.publisher.bk;
import com.vungle.publisher.cl;
import com.vungle.publisher.di;
import com.vungle.publisher.inject.annotations.AdTempDirectory;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalAd
  extends Ad<LocalAd, LocalVideo, RequestLocalAdResponse>
{
  Long p;
  String q;
  LocalArchive r;
  public int s;
  LocalArchive t;
  int u;
  boolean v;
  boolean w;
  @Inject
  Factory x;
  
  private LocalArchive B()
  {
    return this.x.b(this, false);
  }
  
  public final boolean A()
  {
    return bk.a(q());
  }
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = super.a(paramBoolean);
    localContentValues.put("expiration_timestamp_seconds", this.p);
    localContentValues.put("parent_path", this.q);
    localContentValues.put("prepare_retry_count", Integer.valueOf(this.s));
    localContentValues.put("delete_local_content_attempts", Integer.valueOf(this.u));
    return localContentValues;
  }
  
  public final void a(Ad.a parama)
  {
    Ad.a locala = this.f;
    super.a(parama);
    if ((parama != locala) && (parama != Ad.a.b))
    {
      int i = this.s;
      Logger.v("VunglePrepare", "resetting prepare_retry_count from " + i + " to 0 for " + u());
      this.s = 0;
    }
  }
  
  public final void a(String paramString)
  {
    this.q = paramString;
    this.j = null;
  }
  
  public final as b(at.b paramb)
  {
    switch (1.a[paramb.ordinal()])
    {
    default: 
      return (as)super.a(paramb);
    case 1: 
      return B();
    case 2: 
      return (as)j();
    }
    return w();
  }
  
  public final String k()
    throws SQLException
  {
    String str = super.k();
    if (this.r != null) {
      this.r.o();
    }
    if (this.t != null) {
      this.t.o();
    }
    return str;
  }
  
  public final int l()
  {
    int i = super.l();
    if (i == 1)
    {
      if (this.t != null) {
        this.t.l();
      }
      if (this.r != null) {
        this.r.l();
      }
    }
    return i;
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "expiration_timestamp_seconds", this.p);
    cl.a(localStringBuilder, "parent_path", this.q);
    cl.a(localStringBuilder, "prepare_retry_count", Integer.valueOf(this.s));
    cl.a(localStringBuilder, "delete_local_content_attempts", Integer.valueOf(this.u));
    return localStringBuilder;
  }
  
  public final String q()
  {
    if (this.j == null) {
      this.j = bk.a(new Object[] { this.q, ((String)this.n).replace("|", "_") });
    }
    return this.j;
  }
  
  public final LocalArchive w()
  {
    return this.x.a(this, false);
  }
  
  public final as[] x()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = B();
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = (LocalVideo)j();
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = w();
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    return (as[])localArrayList.toArray(new as[localArrayList.size()]);
  }
  
  public final boolean y()
  {
    boolean bool = false;
    LocalArchive localLocalArchive1 = B();
    LocalVideo localLocalVideo = (LocalVideo)j();
    LocalArchive localLocalArchive2 = w();
    int i;
    int j;
    if (localLocalArchive1 != null)
    {
      i = 1;
      if (localLocalVideo == null) {
        break label232;
      }
      j = 1;
      label38:
      if (localLocalArchive2 == null) {
        break label237;
      }
    }
    label232:
    label237:
    for (int k = 1;; k = 0)
    {
      if ((i != 0) || (j != 0) || (k != 0)) {
        bool = true;
      }
      String str = u();
      if (!bool) {
        break label242;
      }
      if (i != 0) {
        Logger.v("VunglePrepare", str + " has " + at.b.c + ": " + localLocalArchive1.l.c);
      }
      if (j != 0) {
        Logger.v("VunglePrepare", str + " has " + at.b.a + ": " + localLocalVideo.f.c);
      }
      if (k != 0) {
        Logger.v("VunglePrepare", str + " has " + at.b.b + ": " + localLocalArchive2.l.c);
      }
      return bool;
      i = 0;
      break;
      j = 0;
      break label38;
    }
    label242:
    a(Ad.a.c);
    return bool;
  }
  
  final boolean z()
  {
    int j = 0;
    boolean bool2 = true;
    as[] arrayOfas = x();
    int k = arrayOfas.length;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i < k)
      {
        if (!arrayOfas[i].B()) {
          bool1 = false;
        }
      }
      else
      {
        if (bool1) {
          break label101;
        }
        a(Ad.a.a);
        arrayOfas = x();
        k = arrayOfas.length;
        i = j;
        while (i < k)
        {
          arrayOfas[i].a(at.a.a);
          i += 1;
        }
      }
      i += 1;
    }
    l();
    label101:
    return bool1;
  }
  
  @Singleton
  public static class Factory
    extends Ad.Factory<LocalAd, LocalVideo, RequestLocalAdResponse>
  {
    @AdTempDirectory
    @Inject
    Provider<String> c;
    @Inject
    LocalArchive.Factory d;
    @Inject
    di e;
    @Inject
    Provider<LocalAd> f;
    @Inject
    LocalVideo.Factory g;
    
    private int a(List<LocalAd> paramList, boolean paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LocalAd localLocalAd = (LocalAd)paramList.next();
        int i = localLocalAd.u;
        localLocalAd.u = (i + 1);
        if ((localLocalAd.A()) || (i >= 3))
        {
          localArrayList.add(localLocalAd);
        }
        else
        {
          Logger.w("VungleDatabase", "unable to delete files for " + localLocalAd.u() + " attempt " + i);
          localLocalAd.l();
        }
      }
      if (paramBoolean) {
        return localArrayList.size();
      }
      return super.a(localArrayList);
    }
    
    private LocalAd a(LocalAd paramLocalAd, Cursor paramCursor, boolean paramBoolean)
    {
      super.a(paramLocalAd, paramCursor, paramBoolean);
      paramLocalAd.p = ap.e(paramCursor, "expiration_timestamp_seconds");
      paramLocalAd.a(ap.f(paramCursor, "parent_path"));
      paramLocalAd.s = ap.d(paramCursor, "prepare_retry_count").intValue();
      paramLocalAd.u = ap.d(paramCursor, "delete_local_content_attempts").intValue();
      if (paramBoolean)
      {
        a(paramLocalAd, paramBoolean);
        b(paramLocalAd, paramBoolean);
      }
      return paramLocalAd;
    }
    
    private LocalAd f()
    {
      return (LocalAd)this.f.get();
    }
    
    public final int a(LocalAd paramLocalAd, RequestLocalAdResponse paramRequestLocalAdResponse)
    {
      paramLocalAd.p = paramRequestLocalAdResponse.s;
      return super.a(paramLocalAd, paramRequestLocalAdResponse);
    }
    
    public final int a(List<LocalAd> paramList)
    {
      return a(paramList, false);
    }
    
    public final LocalAd a(RequestLocalAdResponse paramRequestLocalAdResponse)
      throws bj
    {
      LocalAd localLocalAd = (LocalAd)super.a(paramRequestLocalAdResponse);
      localLocalAd.p = paramRequestLocalAdResponse.s;
      localLocalAd.a((String)this.c.get());
      localLocalAd.t = this.d.a(localLocalAd, paramRequestLocalAdResponse, at.b.c);
      localLocalAd.r = this.d.a(localLocalAd, paramRequestLocalAdResponse, at.b.b);
      localLocalAd.a(Ad.a.a);
      localLocalAd.g = Ad.b.a;
      return localLocalAd;
    }
    
    final LocalArchive a(LocalAd paramLocalAd, boolean paramBoolean)
    {
      if (paramLocalAd.v) {
        return paramLocalAd.r;
      }
      LocalArchive localLocalArchive = (LocalArchive)this.d.a((String)paramLocalAd.n, at.b.b, paramBoolean);
      paramLocalAd.r = localLocalArchive;
      paramLocalAd.v = true;
      return localLocalArchive;
    }
    
    final LocalArchive b(LocalAd paramLocalAd, boolean paramBoolean)
    {
      if (paramLocalAd.w) {
        return paramLocalAd.t;
      }
      LocalArchive localLocalArchive = (LocalArchive)this.d.a((String)paramLocalAd.n, at.b.c, paramBoolean);
      paramLocalAd.t = localLocalArchive;
      paramLocalAd.w = true;
      return localLocalArchive;
    }
    
    /* Error */
    public final LocalAd c()
    {
      // Byte code:
      //   0: new 63	java/lang/StringBuilder
      //   3: dup
      //   4: ldc -11
      //   6: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   9: getstatic 214	com/vungle/publisher/db/model/Ad$b:a	Lcom/vungle/publisher/db/model/Ad$b;
      //   12: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   15: ldc -6
      //   17: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: getstatic 252	com/vungle/publisher/db/model/Ad$a:e	Lcom/vungle/publisher/db/model/Ad$a;
      //   23: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   26: ldc -2
      //   28: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   31: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   34: astore_3
      //   35: ldc 61
      //   37: new 63	java/lang/StringBuilder
      //   40: dup
      //   41: ldc_w 256
      //   44: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   47: aload_3
      //   48: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   54: invokestatic 258	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   57: aload_0
      //   58: getfield 261	com/vungle/publisher/db/model/LocalAd$Factory:b	Lcom/vungle/publisher/db/DatabaseHelper;
      //   61: invokevirtual 267	com/vungle/publisher/db/DatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   64: ldc_w 269
      //   67: aconst_null
      //   68: ldc_w 271
      //   71: iconst_2
      //   72: anewarray 180	java/lang/String
      //   75: dup
      //   76: iconst_0
      //   77: getstatic 214	com/vungle/publisher/db/model/Ad$b:a	Lcom/vungle/publisher/db/model/Ad$b;
      //   80: invokevirtual 272	com/vungle/publisher/db/model/Ad$b:toString	()Ljava/lang/String;
      //   83: aastore
      //   84: dup
      //   85: iconst_1
      //   86: getstatic 252	com/vungle/publisher/db/model/Ad$a:e	Lcom/vungle/publisher/db/model/Ad$a;
      //   89: invokevirtual 273	com/vungle/publisher/db/model/Ad$a:toString	()Ljava/lang/String;
      //   92: aastore
      //   93: aconst_null
      //   94: aconst_null
      //   95: ldc_w 275
      //   98: ldc_w 277
      //   101: invokevirtual 283	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   104: astore 4
      //   106: aload 4
      //   108: invokeinterface 288 1 0
      //   113: istore_1
      //   114: iload_1
      //   115: tableswitch	default:+214->329, 0:+88->203, 1:+129->244
      //   136: new 290	android/database/SQLException
      //   139: dup
      //   140: new 63	java/lang/StringBuilder
      //   143: dup
      //   144: invokespecial 291	java/lang/StringBuilder:<init>	()V
      //   147: iload_1
      //   148: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   151: ldc_w 293
      //   154: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: aload_3
      //   158: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   164: invokespecial 294	android/database/SQLException:<init>	(Ljava/lang/String;)V
      //   167: athrow
      //   168: astore 5
      //   170: aconst_null
      //   171: astore_3
      //   172: ldc 61
      //   174: ldc_w 296
      //   177: aload 5
      //   179: invokestatic 299	com/vungle/publisher/log/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   182: aload_3
      //   183: astore 5
      //   185: aload 4
      //   187: ifnull +13 -> 200
      //   190: aload 4
      //   192: invokeinterface 302 1 0
      //   197: aload_3
      //   198: astore 5
      //   200: aload 5
      //   202: areturn
      //   203: ldc 61
      //   205: new 63	java/lang/StringBuilder
      //   208: dup
      //   209: ldc_w 304
      //   212: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   215: aload_3
      //   216: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   219: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   222: invokestatic 258	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   225: aconst_null
      //   226: astore_3
      //   227: aload_3
      //   228: astore 5
      //   230: aload 4
      //   232: ifnull -32 -> 200
      //   235: aload 4
      //   237: invokeinterface 302 1 0
      //   242: aload_3
      //   243: areturn
      //   244: aload 4
      //   246: invokeinterface 307 1 0
      //   251: ifeq +73 -> 324
      //   254: aload_0
      //   255: aload_0
      //   256: invokespecial 241	com/vungle/publisher/db/model/LocalAd$Factory:f	()Lcom/vungle/publisher/db/model/LocalAd;
      //   259: aload 4
      //   261: iconst_1
      //   262: invokespecial 168	com/vungle/publisher/db/model/LocalAd$Factory:a	(Lcom/vungle/publisher/db/model/LocalAd;Landroid/database/Cursor;Z)Lcom/vungle/publisher/db/model/LocalAd;
      //   265: astore_3
      //   266: aload_3
      //   267: invokevirtual 310	com/vungle/publisher/db/model/LocalAd:z	()Z
      //   270: istore_2
      //   271: iload_2
      //   272: ifne +49 -> 321
      //   275: aconst_null
      //   276: astore_3
      //   277: goto -50 -> 227
      //   280: astore_3
      //   281: aconst_null
      //   282: astore 4
      //   284: aload 4
      //   286: ifnull +10 -> 296
      //   289: aload 4
      //   291: invokeinterface 302 1 0
      //   296: aload_3
      //   297: athrow
      //   298: astore_3
      //   299: goto -15 -> 284
      //   302: astore_3
      //   303: goto -19 -> 284
      //   306: astore 5
      //   308: aconst_null
      //   309: astore 4
      //   311: aconst_null
      //   312: astore_3
      //   313: goto -141 -> 172
      //   316: astore 5
      //   318: goto -146 -> 172
      //   321: goto -94 -> 227
      //   324: aconst_null
      //   325: astore_3
      //   326: goto -99 -> 227
      //   329: goto -193 -> 136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	Factory
      //   113	35	1	i	int
      //   270	2	2	bool	boolean
      //   34	243	3	localObject1	Object
      //   280	17	3	localObject2	Object
      //   298	1	3	localObject3	Object
      //   302	1	3	localObject4	Object
      //   312	14	3	localObject5	Object
      //   104	206	4	localCursor	Cursor
      //   168	10	5	localException1	Exception
      //   183	46	5	localObject6	Object
      //   306	1	5	localException2	Exception
      //   316	1	5	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   106	114	168	java/lang/Exception
      //   136	168	168	java/lang/Exception
      //   203	225	168	java/lang/Exception
      //   244	266	168	java/lang/Exception
      //   35	106	280	finally
      //   106	114	298	finally
      //   136	168	298	finally
      //   203	225	298	finally
      //   244	266	298	finally
      //   266	271	298	finally
      //   172	182	302	finally
      //   35	106	306	java/lang/Exception
      //   266	271	316	java/lang/Exception
    }
    
    public final int d()
    {
      Logger.d("VungleDatabase", "deleting expired " + Ad.b.a + " ad records without pending reports");
      Object localObject = new String[2];
      localObject[0] = Ad.b.a.toString();
      localObject[1] = String.valueOf(System.currentTimeMillis());
      List localList = a("ad", "type = ? AND expiration_timestamp_seconds <= ? AND id NOT IN (SELECT DISTINCT ad_id FROM ad_report)", (String[])localObject, null);
      localObject = a("ad", "type = ? AND expiration_timestamp_seconds <= ? AND id IN (SELECT DISTINCT ad_id FROM ad_report)", (String[])localObject, null);
      int i = a(localList, false);
      return a((List)localObject, true) + i;
    }
    
    public final int e()
    {
      List localList = a("ad", "type = ? AND id NOT IN (SELECT DISTINCT ad_id FROM ad_report) ORDER BY insert_timestamp_seconds DESC LIMIT ? OFFSET ?", new String[] { Ad.b.a.toString(), Integer.toString(Integer.MAX_VALUE), Integer.toString(4) }, null);
      int i = localList.size();
      Logger.d("VungleDatabase", "deleting " + i + " extra " + Ad.b.a + " ad records to reach target size 4");
      return a(localList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */