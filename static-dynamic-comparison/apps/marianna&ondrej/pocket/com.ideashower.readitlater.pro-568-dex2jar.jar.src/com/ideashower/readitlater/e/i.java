package com.ideashower.readitlater.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

class i
{
  private final HashMap b;
  private final HashMap c = new HashMap();
  private Locale d;
  private String e;
  
  private i(g paramg, ObjectNode paramObjectNode)
  {
    paramg = new HashMap(paramObjectNode.size());
    paramObjectNode = paramObjectNode.getFields();
    while (paramObjectNode.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramObjectNode.next();
      String str = ((String)localEntry.getKey()).replace('-', '_');
      paramg.put(str, ((JsonNode)localEntry.getValue()).asText());
      a(str);
    }
    this.b = paramg;
  }
  
  private String a(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration().locale;
    if ((this.d != null) && (this.d == paramContext)) {
      return (String)this.b.get(this.e);
    }
    this.d = a(paramContext);
    this.e = b(this.d);
    return (String)this.b.get(this.e);
  }
  
  private Locale a(Locale paramLocale)
  {
    Locale localLocale = paramLocale;
    if (paramLocale == null)
    {
      paramLocale = Locale.getDefault();
      localLocale = paramLocale;
      if (paramLocale == null) {
        localLocale = Locale.ENGLISH;
      }
    }
    return localLocale;
  }
  
  private void a(String paramString)
  {
    String str1 = null;
    String[] arrayOfString = k.a(paramString, '_');
    String str4 = arrayOfString[0].toLowerCase();
    String str3;
    if (arrayOfString.length > 1)
    {
      str3 = arrayOfString[1].toLowerCase();
      str2 = str3;
      if (arrayOfString.length > 2) {
        str1 = arrayOfString[2].toLowerCase();
      }
    }
    for (String str2 = str3;; str2 = null)
    {
      if ((str2 != null) && (str1 != null)) {
        this.c.put(paramString, paramString);
      }
      if (str2 != null)
      {
        str1 = str4 + '_' + str2;
        this.c.put(str1, paramString);
      }
      this.c.put(str4, paramString);
      return;
    }
  }
  
  private String b(Locale paramLocale)
  {
    Object localObject = (String)k.f(paramLocale.getLanguage(), null);
    String str = (String)k.f(paramLocale.getCountry(), null);
    paramLocale = (String)k.f(paramLocale.getVariant(), null);
    if (localObject == null)
    {
      localObject = "en_US";
      return (String)localObject;
    }
    if ((str != null) && (paramLocale != null)) {}
    for (paramLocale = (String)this.c.get((String)localObject + '_' + str + '_' + paramLocale);; paramLocale = null)
    {
      if ((paramLocale == null) && (str != null)) {
        paramLocale = (String)this.c.get((String)localObject + '_' + str);
      }
      for (;;)
      {
        if (paramLocale == null) {
          paramLocale = (String)this.c.get(localObject);
        }
        for (;;)
        {
          localObject = paramLocale;
          if (paramLocale != null) {
            break;
          }
          return "en_US";
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */