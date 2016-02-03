package com.a.a;

import android.content.Context;
import com.scoreloop.client.android.core.utils.Logger;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
{
  private static final String d = b.class.getSimpleName();
  private f e;
  private h f = new a(null);
  private boolean g;
  
  public b(Context paramContext, c paramc)
  {
    super(paramContext, paramc);
  }
  
  private void b(String paramString)
  {
    this.e = f.a(this.a, this.f);
    HashMap localHashMap = new HashMap();
    localHashMap.put("auth_token", paramString);
    if (this.a.f() != null) {
      localHashMap.put("generate_session_secret", "1");
    }
    if (this.a.g() != null)
    {
      this.e.b(this.a.g(), localHashMap);
      return;
    }
    this.e.a("facebook.auth.getSession", localHashMap);
  }
  
  private void g()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fbconnect", "1");
    localHashMap.put("connect_display", "touch");
    localHashMap.put("api_key", this.a.e());
    localHashMap.put("next", "fbconnect://success");
    try
    {
      if (this.g) {}
      for (boolean bool = false;; bool = true)
      {
        a("http://www.facebook.com/login.php", "GET", localHashMap, null, bool);
        return;
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  protected void a()
  {
    this.g = true;
    g();
  }
  
  protected void a(URI paramURI)
  {
    paramURI = paramURI.getQuery();
    int j = paramURI.indexOf("auth_token=");
    int i;
    if (j != -1)
    {
      i = paramURI.indexOf("&");
      j += "auth_token=".length();
      if (i != -1) {
        break label53;
      }
    }
    label53:
    for (paramURI = paramURI.substring(j);; paramURI = paramURI.substring(j, i - j))
    {
      if (paramURI != null) {
        b(paramURI);
      }
      return;
    }
  }
  
  protected void b()
  {
    if (this.e == null)
    {
      Logger.a(d, "This should not be null, at least on iPhone it is not...");
      return;
    }
    this.e.e();
  }
  
  private class a
    implements h
  {
    private a() {}
    
    public void a(f paramf) {}
    
    public void a(f paramf, Object paramObject)
    {
      paramf = null;
      try
      {
        Object localObject = (JSONObject)paramObject;
        long l = ((JSONObject)localObject).getLong("uid");
        paramObject = ((JSONObject)localObject).getString("session_key");
        String str = ((JSONObject)localObject).getString("secret");
        localObject = Long.valueOf(((JSONObject)localObject).getLong("expires"));
        if (localObject != null) {
          paramf = new Date(((Long)localObject).longValue() * 1000L);
        }
        b.a(b.this, null);
        b.this.a.a(b.this.c, Long.valueOf(l), (String)paramObject, str, paramf);
        b.this.a.b(b.this.c);
        b.this.a(true);
        return;
      }
      catch (JSONException paramf)
      {
        paramf.printStackTrace();
      }
    }
    
    public void a(f paramf, Throwable paramThrowable)
    {
      b.a(b.this, null);
      if ((paramThrowable instanceof i))
      {
        if ((b.a(b.this)) && (((i)paramThrowable).a() == 100))
        {
          b.a(b.this, false);
          b.b(b.this);
        }
        return;
      }
      b.this.a(paramThrowable);
    }
    
    public void b(f paramf) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */