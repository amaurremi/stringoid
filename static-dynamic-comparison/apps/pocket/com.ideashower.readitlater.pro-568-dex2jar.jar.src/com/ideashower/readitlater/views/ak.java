package com.ideashower.readitlater.views;

import android.os.Bundle;
import com.ideashower.readitlater.e.o;
import org.apache.a.c.k;

public class ak
{
  private final Bundle a;
  
  public ak(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public ak(o paramo, String paramString) {}
  
  public ak(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.a = new Bundle();
    paramString2 = (String)k.e(paramString2, "");
    this.a.putString("title", paramString2);
    this.a.putString("url", paramString1);
    this.a.putString("imageSrc", paramString3);
    this.a.putString("quote", paramString4);
    this.a.putInt("uniqueId", paramInt);
  }
  
  public String a()
  {
    return this.a.getString("title");
  }
  
  public String b()
  {
    return this.a.getString("url");
  }
  
  public int c()
  {
    return this.a.getInt("uniqueId");
  }
  
  public String d()
  {
    return this.a.getString("imageSrc");
  }
  
  public String e()
  {
    return this.a.getString("quote");
  }
  
  public Bundle f()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */