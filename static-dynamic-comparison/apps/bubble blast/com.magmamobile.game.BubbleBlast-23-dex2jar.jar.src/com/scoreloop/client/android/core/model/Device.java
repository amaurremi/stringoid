package com.scoreloop.client.android.core.model;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

public class Device
{
  private Context a;
  private String b;
  private State c = State.UNKNOWN;
  
  public String a()
  {
    return this.b;
  }
  
  void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(State paramState)
  {
    this.c = paramState;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return Build.MODEL;
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return "Android";
  }
  
  public String e()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String f()
  {
    if (this.a == null) {
      throw new IllegalStateException("please use setAndroidContext before calling this method");
    }
    return ((TelephonyManager)this.a.getSystemService("phone")).getDeviceId();
  }
  
  public JSONObject g()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", this.b);
    localJSONObject.put("uuid", f());
    localJSONObject.put("name", c());
    localJSONObject.put("system_name", d());
    localJSONObject.put("system_version", e());
    localJSONObject.put("model", b());
    return localJSONObject;
  }
  
  public static enum State
  {
    private final int a;
    
    private State(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int intValue()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */