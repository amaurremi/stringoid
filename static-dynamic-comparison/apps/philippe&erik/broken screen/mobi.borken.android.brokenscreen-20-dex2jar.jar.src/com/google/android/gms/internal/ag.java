package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;

public class ag
  implements af
{
  private final ey lL;
  
  public ag(Context paramContext, ew paramew)
  {
    this.lL = ey.a(paramContext, new am(), false, false, null, paramew);
  }
  
  public void a(final af.a parama)
  {
    this.lL.bW().a(new ez.a()
    {
      public void a(ey paramAnonymousey)
      {
        parama.az();
      }
    });
  }
  
  public void a(String paramString, bd parambd)
  {
    this.lL.bW().a(paramString, parambd);
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.lL.a(paramString, paramJSONObject);
  }
  
  public void d(String paramString)
  {
    this.lL.loadUrl(paramString);
  }
  
  public void e(String paramString)
  {
    this.lL.bW().a(paramString, null);
  }
  
  public void pause()
  {
    ep.a(this.lL);
  }
  
  public void resume()
  {
    ep.b(this.lL);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */