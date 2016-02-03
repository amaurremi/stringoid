package com.ideashower.readitlater.a.a;

import android.content.SharedPreferences;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.node.ObjectNode;

public class d
{
  private final HashMap a;
  private final ObjectNode b;
  private final ObjectNode c;
  private final SharedPreferences d;
  
  public d(ObjectNode paramObjectNode1, ObjectNode paramObjectNode2, SharedPreferences paramSharedPreferences)
  {
    this.b = paramObjectNode1;
    this.a = new HashMap();
    paramObjectNode1 = paramObjectNode1.getFields();
    while (paramObjectNode1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramObjectNode1.next();
      this.a.put(localEntry.getKey(), new e((ObjectNode)localEntry.getValue()));
    }
    this.c = paramObjectNode2;
    this.d = paramSharedPreferences;
  }
  
  private boolean d(String paramString)
  {
    return this.d.getBoolean("promptedFor_".concat(a.a(paramString)), false);
  }
  
  private boolean e(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramString == null) {
      return bool2;
    }
    Object localObject = a(paramString);
    if (localObject != null) {}
    for (localObject = ((e)localObject).b();; localObject = paramString)
    {
      if (localObject != null) {
        bool1 = this.d.getBoolean(a.a((String)localObject), false);
      }
      bool2 = bool1;
      if (bool1) {
        break;
      }
      bool2 = bool1;
      if (!paramString.toLowerCase().startsWith("www.")) {
        break;
      }
      return e(paramString.substring(4));
    }
  }
  
  public e a(String paramString)
  {
    Object localObject = null;
    String str = l.a(this.c, paramString.toLowerCase(), null);
    paramString = (String)localObject;
    if (str != null) {
      paramString = (e)this.a.get(str);
    }
    return paramString;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList(this.a.values());
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(e paramAnonymouse1, e paramAnonymouse2)
      {
        return paramAnonymouse1.b().compareToIgnoreCase(paramAnonymouse2.b());
      }
    });
    return localArrayList;
  }
  
  public e b(String paramString)
  {
    e locale = a(paramString);
    if ((locale != null) && (!e(paramString)) && (!d(paramString))) {
      return locale;
    }
    return null;
  }
  
  public boolean c(String paramString)
  {
    return e(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */