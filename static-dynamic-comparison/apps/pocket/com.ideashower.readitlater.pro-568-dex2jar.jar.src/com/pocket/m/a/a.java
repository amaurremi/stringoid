package com.pocket.m.a;

import com.ideashower.readitlater.d.d;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static ConcurrentHashMap n = new ConcurrentHashMap();
  protected final c a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final URL f;
  private final String g;
  private final String h;
  private String i;
  private final int j;
  private final Object k = new Object();
  private String l;
  private String m;
  private final Object o = new Object();
  private ArrayList p;
  private b q;
  
  public a(String paramString, URL paramURL, int paramInt, boolean paramBoolean, c paramc)
  {
    this.a = paramc;
    if ((paramString == null) || (paramURL == null)) {
      throw new com.ideashower.readitlater.b.e("Assets literal cannot be null");
    }
    this.f = paramURL;
    this.j = paramInt;
    paramString = new URL(paramURL, paramString.trim());
    if ((!paramString.getProtocol().equals("http")) && (!paramString.getProtocol().equals("https"))) {
      throw new com.ideashower.readitlater.b.e("Assets may have a http or https protocol");
    }
    this.b = paramString.toString();
    if (this.b.toLowerCase().contains("data:")) {
      throw new com.ideashower.readitlater.b.e("Data urls are not allowed");
    }
    paramURL = c(this.b);
    paramString = paramURL;
    if (paramBoolean)
    {
      paramString = paramURL;
      if (this.j == 2) {
        paramString = a(paramURL, ".css");
      }
    }
    Object localObject = l.b(paramString);
    paramInt = ((String)localObject).lastIndexOf("/");
    if (paramInt == -1)
    {
      paramString = (String)localObject;
      paramInt = paramString.lastIndexOf(".");
      if (paramInt != -1) {
        break label318;
      }
      paramc = "";
      paramURL = paramString;
      paramString = paramc;
    }
    for (;;)
    {
      paramc = paramString;
      if (paramBoolean)
      {
        paramc = paramString;
        if (this.j == 2) {
          paramc = ".css";
        }
      }
      this.g = paramURL;
      this.h = paramc;
      paramURL = new ArrayList();
      paramString = ((String)localObject).split(File.separator);
      if (paramString.length <= 50) {
        break label344;
      }
      throw new com.ideashower.readitlater.b.e("Subdirectory depth too deep: " + (String)localObject);
      paramString = ((String)localObject).substring(paramInt + 1, ((String)localObject).length());
      break;
      label318:
      paramURL = paramString.substring(paramInt, paramString.length());
      paramc = paramString.substring(0, paramInt);
      paramString = paramURL;
      paramURL = paramc;
    }
    label344:
    Collections.addAll(paramURL, paramString);
    paramURL.remove(0);
    paramURL.remove(0);
    this.c = ((String)paramURL.get(0));
    paramURL.remove(0);
    localObject = new StringBuilder(((String)localObject).length()).append(this.a.c()).append(File.separator).append(this.c);
    int i1 = paramURL.size();
    paramString = "";
    Iterator localIterator = paramURL.iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      paramc = (String)localIterator.next();
      if (i1 - 1 == paramInt) {
        paramString = ((StringBuilder)localObject).toString();
      }
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append(File.separator);
      paramURL = paramc;
      if (paramc.length() > 100) {
        paramURL = paramc.substring(0, 100);
      }
      localStringBuilder.append(paramURL);
      paramInt += 1;
    }
    this.d = ((StringBuilder)localObject).toString();
    this.e = paramString;
  }
  
  public static a a(String paramString)
  {
    return a(paramString, 1, l.c());
  }
  
  public static a a(String paramString, int paramInt, c paramc)
  {
    try
    {
      paramc = new a(paramString, new URL(paramString), paramInt, false, paramc);
      return paramc;
    }
    catch (MalformedURLException paramc)
    {
      a(paramc, paramString);
      return null;
    }
    catch (com.ideashower.readitlater.b.e paramc)
    {
      for (;;)
      {
        a(paramc, paramString);
      }
    }
  }
  
  public static a a(String paramString, URL paramURL, int paramInt, boolean paramBoolean, c paramc)
  {
    try
    {
      paramURL = new a(paramString, paramURL, paramInt, paramBoolean, paramc);
      return paramURL;
    }
    catch (MalformedURLException paramURL)
    {
      a(paramURL, paramString);
      return null;
    }
    catch (com.ideashower.readitlater.b.e paramURL)
    {
      for (;;)
      {
        a(paramURL, paramString);
      }
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i1 = paramString1.lastIndexOf(".");
    String str = paramString1;
    if (i1 >= 0) {
      str = paramString1.substring(0, i1);
    }
    return str.concat(paramString2);
  }
  
  private static void a(Exception paramException, String paramString)
  {
    if ((paramException instanceof MalformedURLException)) {}
    while ((paramException instanceof com.ideashower.readitlater.b.e)) {
      return;
    }
    com.ideashower.readitlater.util.e.a(paramException);
  }
  
  private static String c(String paramString)
  {
    String str3 = paramString;
    String str1;
    int i1;
    String str2;
    String str4;
    if (paramString.indexOf("?") >= 0)
    {
      str1 = "";
      i1 = paramString.lastIndexOf("/");
      if (i1 >= 0) {
        break label122;
      }
      str2 = paramString;
      i1 = str2.indexOf("?");
      str3 = paramString;
      if (i1 >= 0)
      {
        str4 = str2.substring(i1 + 1, str2.length());
        str3 = str2.substring(0, i1);
        i1 = str3.lastIndexOf(".");
        if (i1 < 0) {
          break label144;
        }
      }
    }
    label122:
    label144:
    for (paramString = str3.substring(i1);; paramString = "")
    {
      str2 = str3;
      if (i1 >= 0) {
        str2 = str3.substring(0, i1);
      }
      str3 = str1.concat(File.separator).concat(str2).concat(str4).concat(paramString);
      return str3;
      str1 = paramString.substring(0, i1);
      str2 = paramString.substring(i1 + 1, paramString.length());
      break;
    }
  }
  
  public String a()
  {
    synchronized (this.k)
    {
      Object localObject3;
      if (this.l != null)
      {
        localObject3 = this.l;
        return (String)localObject3;
      }
      ??? = this.f.toString();
      if ((a)n.get(???) == null)
      {
        ??? = a((String)???, this.f, this.j, false, this.a);
        localObject3 = new ArrayList();
        Collections.addAll((Collection)localObject3, ((a)???).b().split(File.separator));
        ((ArrayList)localObject3).remove(((ArrayList)localObject3).size() - 1);
        localObject3 = ((ArrayList)localObject3).iterator();
        ??? = "";
        if (!((Iterator)localObject3).hasNext()) {
          break label145;
        }
        String str = (String)((Iterator)localObject3).next();
        ??? = ((String)???).concat("../");
      }
    }
    return b();
    label145:
    synchronized (this.k)
    {
      this.l = ((String)???).concat(b());
      ??? = this.l;
      return (String)???;
    }
  }
  
  public void a(d paramd)
  {
    synchronized (this.o)
    {
      if (this.p == null) {
        this.p = new ArrayList();
      }
      this.p.add(paramd);
      return;
    }
  }
  
  public void a(b paramb)
  {
    this.q = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.o)
    {
      if (this.p == null) {
        return;
      }
      Iterator localIterator = this.p.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).a(this, paramBoolean);
      }
    }
    this.p.clear();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.q != null) {
      this.q.a(paramArrayOfByte);
    }
  }
  
  public String b()
  {
    synchronized (this.k)
    {
      if (this.m != null)
      {
        str = this.m;
        return str;
      }
      this.m = this.d.replace(this.a.a() + File.separator, "");
      String str = this.m;
      return str;
    }
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public String i()
  {
    if (this.i != null) {
      return this.i;
    }
    return "UTF-8";
  }
  
  public boolean j()
  {
    return l.a(this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */