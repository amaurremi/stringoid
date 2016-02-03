package com.pocket.d;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.FacebookAuthActivity;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.f.d;
import com.ideashower.readitlater.h.i;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class k
  extends e
{
  private static k j;
  private final f i;
  
  public k(Context paramContext, b paramb, f paramf)
  {
    super(paramContext, paramb);
    this.i = paramf;
  }
  
  public static void b(String paramString)
  {
    i.b().a(com.ideashower.readitlater.h.a.bt, paramString).a();
    j.f();
    j = null;
  }
  
  private String s()
  {
    return i.a(com.ideashower.readitlater.h.a.bs);
  }
  
  private String t()
  {
    String str2 = null;
    Object localObject = i.a(com.ideashower.readitlater.h.a.bt);
    String str1 = str2;
    if (localObject != null)
    {
      localObject = com.ideashower.readitlater.util.l.a(com.ideashower.readitlater.f.a.a(new d("https://graph.facebook.com/me?access_token=" + (String)localObject, 0), false, false).a());
      str1 = str2;
      if (localObject != null)
      {
        str2 = ((ObjectNode)localObject).get("id").asText();
        str1 = str2;
        if (str2 != null)
        {
          i.b().a(com.ideashower.readitlater.h.a.bs, str2).a();
          str1 = str2;
        }
      }
    }
    return str1;
  }
  
  public int c()
  {
    return 2131493264;
  }
  
  protected int d()
  {
    return 2130837522;
  }
  
  protected void e()
  {
    if (g.k())
    {
      j = this;
      FacebookAuthActivity.c(this.i.m());
      return;
    }
    new AlertDialog.Builder(k()).setTitle(2131493071).setMessage(2131493093).setPositiveButton(2131492924, null).show();
  }
  
  public String o()
  {
    return "facebook";
  }
  
  protected String r()
  {
    String str2 = s();
    String str1 = str2;
    if (str2 == null) {
      str1 = t();
    }
    if (str1 != null) {
      return "https://graph.facebook.com/" + str1 + "/picture?width=1000&height=1000";
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */