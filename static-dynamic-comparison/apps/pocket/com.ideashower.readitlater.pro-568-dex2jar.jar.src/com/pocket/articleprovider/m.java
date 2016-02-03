package com.pocket.articleprovider;

import android.content.Context;
import android.util.Log;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.pocket.f.b;
import com.pocket.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class m
  implements a
{
  public static String a = "ProviderCommunicationManager";
  private static m d;
  private static k f;
  String b;
  HashMap c = new HashMap();
  private final Context e;
  private f g;
  private boolean h;
  private String i;
  
  public m(Context paramContext)
  {
    this.e = paramContext;
    b(paramContext);
  }
  
  public m(Context paramContext, k paramk)
  {
    this.e = paramContext;
    f = paramk;
    b(paramContext);
  }
  
  public static m a(Context paramContext)
  {
    if (d == null) {
      d = new m(paramContext);
    }
    return d;
  }
  
  public static m a(Context paramContext, k paramk)
  {
    if (d == null) {
      d = new m(paramContext, paramk);
    }
    return d;
  }
  
  private void b(Context paramContext)
  {
    this.h = true;
    f.a(paramContext, this, new j()
    {
      public void a()
      {
        m.a(m.this, c.z);
      }
      
      public void a(int paramAnonymousInt)
      {
        m.a(m.this, false);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put(c.a, c.k);
          localJSONObject.put(c.I, paramAnonymousInt);
          m.h().a(localJSONObject.toString());
          return;
        }
        catch (JSONException localJSONException)
        {
          com.ideashower.readitlater.util.e.a(localJSONException);
        }
      }
      
      public void a(f paramAnonymousf)
      {
        m.a(m.this, false);
        m.a(m.this, paramAnonymousf);
        m.a(m.this, c.i);
      }
      
      public void b()
      {
        m.a(m.this, false);
        m.a(m.this, c.A);
      }
    });
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject().put(c.a, paramString).toString();
      f.a(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      com.ideashower.readitlater.util.e.a(paramString);
    }
  }
  
  private void d(int paramInt)
  {
    byte[] arrayOfByte = (byte[])this.c.get(String.valueOf(paramInt));
    if ((arrayOfByte != null) && (f != null)) {
      f.a(arrayOfByte);
    }
  }
  
  public static void e()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.y);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.l);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void a(float paramFloat)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.o);
      localJSONObject.put(c.H, paramFloat);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.h);
      localJSONObject.put(c.I, paramInt);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void a(com.pocket.f.a parama)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.g);
      localJSONObject.put(c.F, b.a(parama));
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException parama)
    {
      com.ideashower.readitlater.util.e.a(parama);
    }
  }
  
  /* Error */
  public void a(final String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 159	com/pocket/articleprovider/m:b	Ljava/lang/String;
    //   6: ifnull +39 -> 45
    //   9: aload_1
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 159	com/pocket/articleprovider/m:b	Ljava/lang/String;
    //   15: invokevirtual 163	java/lang/String:length	()I
    //   18: ifle +27 -> 45
    //   21: aload_1
    //   22: astore_2
    //   23: aload_0
    //   24: getfield 159	com/pocket/articleprovider/m:b	Ljava/lang/String;
    //   27: aload_1
    //   28: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifne +14 -> 45
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 159	com/pocket/articleprovider/m:b	Ljava/lang/String;
    //   39: ldc -87
    //   41: invokevirtual 173	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: putfield 159	com/pocket/articleprovider/m:b	Ljava/lang/String;
    //   50: new 84	org/json/JSONObject
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 175	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: getstatic 88	com/pocket/f/c:a	Ljava/lang/String;
    //   63: invokevirtual 179	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +49 -> 117
    //   71: aload_2
    //   72: getstatic 182	com/pocket/f/c:C	Ljava/lang/String;
    //   75: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +93 -> 171
    //   81: aload_1
    //   82: getstatic 185	com/pocket/f/c:Q	Ljava/lang/String;
    //   85: invokevirtual 188	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   88: ifeq +14 -> 102
    //   91: aload_0
    //   92: aload_1
    //   93: getstatic 185	com/pocket/f/c:Q	Ljava/lang/String;
    //   96: invokevirtual 191	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 193	com/pocket/articleprovider/m:i	Ljava/lang/String;
    //   102: new 195	com/ideashower/readitlater/db/operation/action/o
    //   105: dup
    //   106: iconst_1
    //   107: aload_0
    //   108: invokevirtual 198	com/pocket/articleprovider/m:d	()Lcom/ideashower/readitlater/db/operation/action/UiContext;
    //   111: invokespecial 201	com/ideashower/readitlater/db/operation/action/o:<init>	(ZLcom/ideashower/readitlater/db/operation/action/UiContext;)V
    //   114: invokevirtual 204	com/ideashower/readitlater/db/operation/action/o:j	()V
    //   117: aload_0
    //   118: invokevirtual 207	com/pocket/articleprovider/m:f	()Z
    //   121: ifne +84 -> 205
    //   124: new 84	org/json/JSONObject
    //   127: dup
    //   128: invokespecial 85	org/json/JSONObject:<init>	()V
    //   131: astore_1
    //   132: aload_1
    //   133: getstatic 88	com/pocket/f/c:a	Ljava/lang/String;
    //   136: getstatic 210	com/pocket/f/c:x	Ljava/lang/String;
    //   139: invokevirtual 92	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   142: pop
    //   143: getstatic 49	com/pocket/articleprovider/m:f	Lcom/pocket/articleprovider/k;
    //   146: aload_1
    //   147: invokevirtual 96	org/json/JSONObject:toString	()Ljava/lang/String;
    //   150: invokeinterface 101 2 0
    //   155: pop
    //   156: return
    //   157: astore_1
    //   158: aload_1
    //   159: invokestatic 106	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   162: return
    //   163: astore_3
    //   164: aload_3
    //   165: invokestatic 106	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   168: goto -66 -> 102
    //   171: aload_2
    //   172: getstatic 213	com/pocket/f/c:D	Ljava/lang/String;
    //   175: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifeq -61 -> 117
    //   181: new 195	com/ideashower/readitlater/db/operation/action/o
    //   184: dup
    //   185: iconst_0
    //   186: aload_0
    //   187: invokevirtual 198	com/pocket/articleprovider/m:d	()Lcom/ideashower/readitlater/db/operation/action/UiContext;
    //   190: invokespecial 201	com/ideashower/readitlater/db/operation/action/o:<init>	(ZLcom/ideashower/readitlater/db/operation/action/UiContext;)V
    //   193: invokevirtual 204	com/ideashower/readitlater/db/operation/action/o:j	()V
    //   196: goto -79 -> 117
    //   199: astore_1
    //   200: aload_1
    //   201: invokestatic 106	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   204: return
    //   205: aload_0
    //   206: getfield 52	com/pocket/articleprovider/m:g	Lcom/pocket/articleprovider/f;
    //   209: ifnonnull +19 -> 228
    //   212: aload_0
    //   213: getfield 72	com/pocket/articleprovider/m:h	Z
    //   216: ifne +12 -> 228
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 44	com/pocket/articleprovider/m:e	Landroid/content/Context;
    //   224: invokespecial 46	com/pocket/articleprovider/m:b	(Landroid/content/Context;)V
    //   227: return
    //   228: new 10	com/pocket/articleprovider/m$2
    //   231: dup
    //   232: aload_0
    //   233: aload_2
    //   234: aload_1
    //   235: invokespecial 216	com/pocket/articleprovider/m$2:<init>	(Lcom/pocket/articleprovider/m;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   238: invokestatic 221	com/ideashower/readitlater/a/g:a	(Ljava/lang/Runnable;)V
    //   241: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	m
    //   0	242	1	paramString	String
    //   1	233	2	str	String
    //   163	2	3	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   50	67	157	org/json/JSONException
    //   91	102	163	org/json/JSONException
    //   124	156	199	org/json/JSONException
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new JSONObject();
      paramString.put(c.a, c.w);
      paramString.put(c.S, paramInt3);
      if (f != null) {
        f.a(paramString.toString());
      }
      paramString = new byte[paramArrayOfByte.length + 1];
      System.arraycopy(new byte[] { 73 }, 0, paramString, 0, 1);
      System.arraycopy(paramArrayOfByte, 0, paramString, 1, paramArrayOfByte.length);
      this.c.put(String.valueOf(paramInt3), paramString);
      return;
    }
    catch (JSONException paramString)
    {
      com.ideashower.readitlater.util.e.a(paramString);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = b.a(paramArrayList);
    try
    {
      paramArrayList.put(c.J, paramInt1);
      paramArrayList.put(c.K, paramInt2);
      if (f != null) {
        f.a(paramArrayList.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localException);
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayList = b.a(paramArrayList);
    try
    {
      paramArrayList.put(c.L, paramInt2);
      paramArrayList.put(c.M, paramInt3);
      if (f != null) {
        f.a(paramArrayList.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localException);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.u);
      localJSONObject.put(c.N, paramBoolean);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.m);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.n);
      localJSONObject.put(c.G, paramInt);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void b(com.pocket.f.a parama)
  {
    if ((com.pocket.c.e.b(true)) || (!parama.j())) {}
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put(c.a, c.r);
        localJSONObject.put(c.F, b.a(parama));
        if (f != null) {
          f.a(localJSONObject.toString());
        }
        return;
      }
      catch (JSONException parama)
      {
        com.ideashower.readitlater.util.e.a(parama);
        return;
      }
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put(c.a, c.d);
        localJSONObject.put(c.F, b.a(parama));
        if (f != null)
        {
          f.a(localJSONObject.toString());
          return;
        }
      }
      catch (JSONException parama)
      {
        com.ideashower.readitlater.util.e.a(parama);
      }
    }
  }
  
  public void c()
  {
    if (!com.pocket.c.e.b(true)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.e);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      com.ideashower.readitlater.util.e.a(localJSONException);
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == -5) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(c.a, c.x);
      if (f != null) {
        f.a(localJSONObject.toString());
      }
      g();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localJSONException);
      }
    }
  }
  
  public UiContext d()
  {
    return UiContext.a(this.i);
  }
  
  public boolean f()
  {
    return as.l();
  }
  
  public void g()
  {
    if (this.g != null)
    {
      this.g.a();
      this.g = null;
      d = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */