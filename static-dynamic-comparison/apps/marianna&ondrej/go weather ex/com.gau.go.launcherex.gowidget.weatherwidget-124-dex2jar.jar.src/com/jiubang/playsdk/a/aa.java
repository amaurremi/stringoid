package com.jiubang.playsdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.a.a.o;
import com.android.a.s;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.g.i;
import com.jiubang.playsdk.g.j;
import com.jiubang.playsdk.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class aa
{
  private static volatile aa c = null;
  public i a;
  private d b;
  private SparseArray d;
  private com.jiubang.playsdk.main.c e;
  private boolean f = false;
  private Context g;
  private boolean h = false;
  private com.jiubang.playsdk.g.f i;
  
  public static aa a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new aa();
      }
      return c;
    }
    finally {}
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() < 3)) {
      return paramList;
    }
    int j = paramList.size();
    Object localObject = new Random(System.currentTimeMillis());
    HashSet localHashSet = new HashSet();
    while (localHashSet.size() < 3) {
      localHashSet.add(Integer.valueOf(((Random)localObject).nextInt(j)));
    }
    localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(paramList.get(((Integer)((Iterator)localObject).next()).intValue()));
    }
    return localArrayList;
  }
  
  private s d(Context paramContext)
  {
    String str1 = "volley/0";
    try
    {
      String str2 = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str2, 0);
      paramContext = str2 + "/" + paramContext.versionCode;
      paramContext = new com.android.a.a.a(new z(AndroidHttpClient.newInstance(paramContext)));
      paramContext = new s(new o(), paramContext, 2);
      paramContext.a();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
  
  public a a(Context paramContext, com.jiubang.playsdk.e.a parama)
  {
    if ((paramContext == null) || (parama == null)) {
      return new a();
    }
    a locala = new a();
    locala.b(parama.c());
    locala.c(parama.j());
    locala.a(parama.i());
    locala.b(parama.t());
    locala.a(parama.b());
    locala.h(parama.e());
    locala.a(parama.d());
    if (parama.a() == 0L) {
      locala.d(com.jiubang.playsdk.f.a.a(paramContext, a(parama)));
    }
    for (;;)
    {
      locala.e(parama.k());
      return locala;
      locala.d(String.valueOf(parama.a()));
    }
  }
  
  public com.jiubang.playsdk.e.d a(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public com.jiubang.playsdk.main.c a(int paramInt)
  {
    if (this.d == null) {
      this.d = new SparseArray();
    }
    com.jiubang.playsdk.main.c localc = (com.jiubang.playsdk.main.c)this.d.get(paramInt);
    if (localc != null) {}
    return localc;
  }
  
  public String a(com.jiubang.playsdk.e.a parama)
  {
    Object localObject;
    if (parama == null) {
      localObject = "";
    }
    String str;
    do
    {
      return (String)localObject;
      str = parama.p();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    switch (parama.f())
    {
    case 23: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 34: 
    case 35: 
    default: 
      return "";
    case 21: 
    case 24: 
      return "com.gau.go.launcherex";
    case 22: 
      return "com.jiubang.goscreenlock";
    case 25: 
    case 26: 
      return "com.jb.gosms";
    case 31: 
    case 32: 
    case 33: 
    case 36: 
      return "com.gau.go.launcherex.gowidget.weatherwidget";
    }
    return "com.jb.gokeyboard";
  }
  
  public void a(int paramInt, k paramk)
  {
    new u(this.g, paramk, paramInt).a();
  }
  
  public void a(int paramInt, com.jiubang.playsdk.main.c paramc)
  {
    if (this.d == null) {
      this.d = new SparseArray();
    }
    if (paramc == this.d.get(paramInt)) {
      return;
    }
    this.d.put(paramInt, paramc);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, k paramk)
  {
    this.b.a(paramLong, paramInt1, paramInt2, paramInt3, paramk);
  }
  
  public void a(long paramLong, k paramk)
  {
    this.b.a(paramLong, paramk);
  }
  
  public void a(Context paramContext)
  {
    if (this.f) {
      return;
    }
    this.g = paramContext.getApplicationContext();
    l.a(this.g);
    j.a(this.g);
    s locals = d(this.g);
    this.b = new d(this.g, locals, new n());
    this.f = true;
    this.i = new com.jiubang.playsdk.g.f(paramContext);
    this.a = new i();
  }
  
  public void a(Context paramContext, int paramInt, long paramLong)
  {
    if (this.e != null)
    {
      this.e.c(paramContext, com.jiubang.playsdk.g.a.a(paramInt));
      com.jiubang.playsdk.f.a.a(paramContext, this.e.o(), this.e.o(), paramLong);
    }
  }
  
  public void a(Context paramContext, e parame, long paramLong)
  {
    int k = 0;
    int j = 0;
    int m = 1;
    if ((parame == null) || (paramContext == null)) {}
    for (;;)
    {
      return;
      com.jiubang.playsdk.e.a locala = parame.f();
      int n = parame.d();
      com.jiubang.playsdk.main.c localc = a().b();
      if (n == 2)
      {
        if (!com.jiubang.playsdk.g.a.b(paramContext, parame.e())) {
          j = 1;
        }
        k = j;
        if (localc == null) {
          break label214;
        }
        com.jiubang.playsdk.f.a.c(this.g, localc.o(), locala.b(), localc.r(), locala.a(), locala.t());
      }
      while ((j != 0) && (localc != null))
      {
        com.jiubang.playsdk.f.a.a(paramContext, localc.o(), locala.b(), localc.r(), paramLong, parame.c());
        localc.a(paramContext, parame);
        return;
        j = m;
        if (n == 3)
        {
          j = k;
          if (!com.jiubang.playsdk.g.a.c(paramContext, parame.e())) {
            j = 1;
          }
          k = j;
          if (localc != null)
          {
            com.jiubang.playsdk.f.a.c(this.g, localc.o(), locala.b(), localc.r(), locala.a(), locala.t());
            k = j;
          }
          label214:
          j = k;
        }
      }
    }
  }
  
  public void a(k paramk)
  {
    this.b.a(paramk);
  }
  
  public void a(com.jiubang.playsdk.main.c paramc)
  {
    if (paramc != null)
    {
      this.e = paramc;
      a(paramc.o(), paramc);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, k paramk)
  {
    this.b.a(paramString, paramInt1, paramInt2, paramk);
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramInt == 2) {}
    for (paramString = e(paramString);; paramString = d(paramString)) {
      return com.jiubang.playsdk.g.a.a(paramContext, paramInt, paramString);
    }
  }
  
  public x b(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public com.jiubang.playsdk.main.c b()
  {
    return this.e;
  }
  
  public String b(Context paramContext)
  {
    if (this.e == null) {
      return "";
    }
    return this.e.d(paramContext);
  }
  
  public List c(Context paramContext)
  {
    Object localObject;
    if ((this.e == null) || (this.e.u() == 0))
    {
      localObject = new ArrayList();
      return (List)localObject;
    }
    InputStream localInputStream = paramContext.getResources().openRawResource(this.e.u());
    for (;;)
    {
      try
      {
        paramContext = com.jiubang.playsdk.e.f.b(new String(com.jiubang.playsdk.g.c.a(localInputStream)));
        if (paramContext != null)
        {
          paramContext = a(paramContext.a);
          localObject = paramContext;
          if (localInputStream == null) {
            break;
          }
          try
          {
            localInputStream.close();
            return paramContext;
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            return paramContext;
          }
        }
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        if (localInputStream == null) {
          continue;
        }
        try
        {
          localInputStream.close();
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
        continue;
      }
      catch (y paramContext)
      {
        paramContext.printStackTrace();
        if (localInputStream == null) {
          continue;
        }
        try
        {
          localInputStream.close();
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (localInputStream == null) {
          break label170;
        }
      }
      try
      {
        localInputStream.close();
        return new ArrayList();
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    try
    {
      localInputStream.close();
      label170:
      throw paramContext;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    this.b.a();
  }
  
  public boolean c(String paramString)
  {
    return this.b.c(paramString);
  }
  
  public Context d()
  {
    return this.g;
  }
  
  public String d(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public int e()
  {
    if (this.e == null) {
      return 80;
    }
    return this.e.o();
  }
  
  public String e(String paramString)
  {
    return this.a.a(e(), paramString);
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public boolean f(String paramString)
  {
    return this.i.a(paramString);
  }
  
  public String g(String paramString)
  {
    return this.i.b(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */