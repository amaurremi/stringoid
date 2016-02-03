package com.pocket.o;

import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.ac;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.g.k;
import java.util.ArrayList;

public class c
{
  public static void a(d paramd)
  {
    final ArrayList localArrayList = new ArrayList();
    j local1 = new j()
    {
      protected void c_()
      {
        c.this.addAll(x());
      }
    };
    local1.a(new com.ideashower.readitlater.g.l()
    {
      public void a() {}
      
      public void a(k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        c.this.a(localArrayList);
      }
    }, true);
    local1.f();
  }
  
  public static void a(String paramString, UiContext paramUiContext)
  {
    new com.ideashower.readitlater.db.operation.action.l(paramString, paramUiContext).j();
  }
  
  public static void a(String paramString1, String paramString2, UiContext paramUiContext)
  {
    new ac(paramString1, paramString2, paramUiContext).j();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */