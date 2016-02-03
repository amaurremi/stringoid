package com.ideashower.readitlater.f;

import java.util.List;
import org.apache.a.c.k;
import org.apache.http.Header;

public class b
{
  private String b;
  private boolean c;
  private byte[] d;
  private List e;
  private String f;
  private String g = "text/html";
  private boolean h = false;
  private int i;
  private Header[] j;
  
  public b(a parama) {}
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
    this.c = true;
  }
  
  public void a(List paramList)
  {
    this.e = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.h = paramBoolean;
    this.i = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public void a(Header[] paramArrayOfHeader)
  {
    this.j = paramArrayOfHeader;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public byte[] b()
  {
    return this.d;
  }
  
  public List c()
  {
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    String str = this.g.toLowerCase();
    if (str.contains("html")) {}
    while ((str.equals("text/plain")) || (str.equals("text/javascript"))) {
      return false;
    }
    return true;
  }
  
  public boolean h()
  {
    return k.h(this.g, "image/");
  }
  
  public int i()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */