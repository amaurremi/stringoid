package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;

public class g
{
  private final bW a;
  
  public g(Context paramContext, dx paramdx)
  {
    this.a = bW.a(paramContext, new ak(), false, false, null, paramdx);
  }
  
  public void a(h paramh)
  {
    this.a.f().a(new i(this, paramh));
  }
  
  public void a(String paramString)
  {
    this.a.loadUrl(paramString);
  }
  
  public void a(String paramString, R paramR)
  {
    this.a.f().a(paramString, paramR);
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.a(paramString, paramJSONObject);
  }
  
  public void b(String paramString)
  {
    this.a.f().a(paramString, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */