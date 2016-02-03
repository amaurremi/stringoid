package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.e.o;
import java.util.ArrayList;

public class ah
{
  private final String a;
  private final UiContext b;
  private final o c;
  private String d;
  private String e;
  private ArrayList f = new ArrayList();
  private ArrayList g = new ArrayList();
  
  public ah(String paramString, UiContext paramUiContext)
  {
    this.a = paramString;
    this.b = paramUiContext;
    this.c = null;
  }
  
  public ag a()
  {
    if (this.c != null) {
      return new ag(this, this.c);
    }
    return new ag(this, this.a);
  }
  
  public ah a(f paramf)
  {
    this.g.add(paramf);
    return this;
  }
  
  public ah a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public ah b(String paramString)
  {
    this.f.add(paramString);
    return this;
  }
  
  public ah c(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */