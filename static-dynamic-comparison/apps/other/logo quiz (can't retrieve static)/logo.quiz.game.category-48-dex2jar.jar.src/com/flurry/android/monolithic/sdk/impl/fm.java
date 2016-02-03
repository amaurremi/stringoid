package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import com.flurry.android.impl.appcloud.AppCloudModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class fm
{
  protected String a = "";
  protected String b = "";
  protected HashMap<String, String> c = new HashMap();
  protected String d;
  protected String e;
  protected String f;
  
  public float a(String paramString)
  {
    try
    {
      if (this.c.containsKey(paramString))
      {
        float f1 = Float.parseFloat((String)this.c.get(paramString));
        return f1;
      }
      return 0.0F;
    }
    catch (Exception paramString) {}
    return 0.0F;
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected void a(fr paramfr)
  {
    try
    {
      hm localhm = new hm(this.a);
      go.a().b(localhm, new fo(this, paramfr));
      return;
    }
    catch (Exception paramfr)
    {
      paramfr.printStackTrace();
    }
  }
  
  public void a(hw paramhw)
    throws Exception
  {
    Object localObject = new hk(this.a);
    ((hk)localObject).a(b());
    if ((this.e != null) && (!this.e.equals(""))) {
      ((hk)localObject).a("username", this.e);
    }
    if ((this.f != null) && (!this.f.equals(""))) {
      ((hk)localObject).a("password", this.f);
    }
    if ((this.d != null) && (!this.d.equals(""))) {
      ((hk)localObject).a("email", this.d);
    }
    if (TextUtils.isEmpty(this.a))
    {
      hm localhm = new hm(null);
      localObject = ((hk)localObject).a();
      int i = 0;
      while (i < ((Vector)localObject).size())
      {
        localhm.a(((NameValuePair)((Vector)localObject).get(i)).getName(), ((NameValuePair)((Vector)localObject).get(i)).getValue());
        i += 1;
      }
      go.a().a(localhm, new fn(this, paramhw));
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramString.equals("code")) || (paramString.equals("note"))) {
      return;
    }
    if (this.c.containsKey(paramString))
    {
      this.c.remove(paramString);
      this.c.put(paramString, paramObject.toString());
      return;
    }
    this.c.put(paramString, paramObject.toString());
  }
  
  protected void a(String paramString1, String paramString2, hx paramhx)
  {
    hm localhm = new hm(this.a);
    localhm.a(paramString1, paramString2);
    go.a().c(localhm, new fp(this, paramhx));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONObject.has("username")) {
          this.e = paramJSONObject.getString("username");
        }
        if (paramJSONObject.has("email")) {
          this.d = paramJSONObject.getString("email");
        }
        if (!paramJSONObject.has("_id")) {
          break label108;
        }
        this.a = paramJSONObject.getString("_id");
      }
      catch (JSONException paramJSONObject)
      {
        String str1;
        String str2;
        paramJSONObject.printStackTrace();
      }
      if (i < paramJSONObject.length())
      {
        str1 = paramJSONObject.names().getString(i);
        str2 = paramJSONObject.getString(str1);
        this.c.put(str1, str2);
        i += 1;
      }
      else
      {
        return;
        label108:
        i = 0;
      }
    }
  }
  
  public Vector<NameValuePair> b()
  {
    Vector localVector = new Vector();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((!str.startsWith("_")) && (!str.equals("username")) && (!str.equals("email")) && (!str.equals("code")) && (!str.equals("note"))) {
        localVector.add(new BasicNameValuePair(str, (String)localEntry.getValue()));
      }
    }
    return localVector;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public void c(String paramString)
  {
    int j = 0;
    if (go.b().c().b(paramString)) {}
    for (hk localhk1 = go.b().c().a(paramString);; localhk1 = null)
    {
      if (go.b().b().b(paramString)) {}
      for (hk localhk2 = go.b().b().a(paramString);; localhk2 = null)
      {
        if ((localhk1 == null) && (localhk2 == null)) {}
        for (;;)
        {
          return;
          b(paramString);
          int i;
          if (localhk2 != null)
          {
            i = 0;
            while (i < localhk2.a().size())
            {
              a(((NameValuePair)localhk2.a().get(i)).getName(), ((NameValuePair)localhk2.a().get(i)).getValue());
              i += 1;
            }
          }
          if (localhk1 != null)
          {
            i = j;
            while (i < localhk1.a().size())
            {
              a(((NameValuePair)localhk1.a().get(i)).getName(), ((NameValuePair)localhk1.a().get(i)).getValue());
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    if (TextUtils.isEmpty(this.a)) {
      return false;
    }
    return AppCloudModule.getInstance().b().a(this.a);
  }
  
  public void d()
  {
    int i = 0;
    while (i < b().size())
    {
      String str1 = ((NameValuePair)b().get(i)).getName();
      String str2 = ((NameValuePair)b().get(i)).getValue();
      go.b().b().c(str1, str2, this.a, this.b);
      i += 1;
    }
  }
  
  public String toString()
  {
    String str = "" + "id : " + this.a + " ; ";
    Vector localVector = b();
    int i = 0;
    while (i < localVector.size())
    {
      str = str + "\n( key : value ) = ( " + ((NameValuePair)localVector.get(i)).getName() + " : " + ((NameValuePair)localVector.get(i)).getValue() + " )";
      i += 1;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */