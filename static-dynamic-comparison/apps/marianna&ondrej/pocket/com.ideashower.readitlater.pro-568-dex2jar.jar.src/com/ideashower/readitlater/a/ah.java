package com.ideashower.readitlater.a;

import android.os.Bundle;
import com.ideashower.readitlater.db.operation.h;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.s;
import com.ideashower.readitlater.e.t;
import java.util.ArrayList;
import org.codehaus.jackson.node.ObjectNode;

public class ah
{
  private static final ArrayList a = new ArrayList();
  
  private static o a()
  {
    if (a.isEmpty()) {
      return null;
    }
    o localo = (o)a.get(0);
    a.clear();
    return localo;
  }
  
  public static o a(int paramInt, boolean paramBoolean)
  {
    o localo = a();
    Object localObject = localo;
    if (localo == null)
    {
      localObject = localo;
      if (paramBoolean)
      {
        localObject = new h(paramInt);
        ((h)localObject).d();
        localObject = ((h)localObject).e();
      }
    }
    return (o)localObject;
  }
  
  public static o a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("stateItemUniqueId");
    if (i != 0) {
      return a(i, true);
    }
    if (paramBundle.getString("stateItemJson") != null) {
      return s.a(paramBundle.getString("stateItemJson"));
    }
    return null;
  }
  
  public static void a(o paramo)
  {
    a.clear();
    a.add(paramo);
  }
  
  public static void a(o paramo, Bundle paramBundle)
  {
    if (paramo.f() > 0)
    {
      paramBundle.putInt("stateItemUniqueId", paramo.f());
      return;
    }
    paramBundle.putString("stateItemJson", t.a(paramo).toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */