package com.pocket.m.b;

import com.ideashower.readitlater.e.o;
import java.util.ArrayList;

class j
{
  private String b;
  private o c;
  private final boolean d;
  private ArrayList e;
  
  public j(i parami, boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(o paramo)
  {
    this.c = paramo;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public o b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramString);
  }
  
  public ArrayList c()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */