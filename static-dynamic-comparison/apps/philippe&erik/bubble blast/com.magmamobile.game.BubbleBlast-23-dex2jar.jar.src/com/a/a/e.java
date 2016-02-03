package com.a.a;

import android.content.Context;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class e
  extends a
{
  private String[] d;
  
  public e(Context paramContext, c paramc, String[] paramArrayOfString)
  {
    super(paramContext, paramc);
    this.d = paramArrayOfString;
  }
  
  private void g()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fbconnect", "1");
    localHashMap.put("connect_display", "touch");
    localHashMap.put("api_key", this.a.e());
    localHashMap.put("session_key", this.a.i());
    localHashMap.put("next", "fbconnect://success");
    localHashMap.put("cancel", "fbconnect://cancel");
    int j = this.d.length;
    String str = "";
    int i = 0;
    if (i < j)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str).append(this.d[i]);
      if (i == j - 1) {}
      for (str = "";; str = ",")
      {
        str = str;
        i += 1;
        break;
      }
    }
    localHashMap.put("ext_perm", str);
    try
    {
      a("http://www.facebook.com/connect/prompt_permissions.php", "GET", localHashMap, null);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  protected void a()
  {
    g();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */