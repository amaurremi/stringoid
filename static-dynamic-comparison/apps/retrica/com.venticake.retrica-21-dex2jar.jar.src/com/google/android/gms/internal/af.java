package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;

public class af
  implements ae
{
  private final ex lN;
  
  public af(Context paramContext, ev paramev)
  {
    this.lN = ex.a(paramContext, new al(), false, false, null, paramev);
  }
  
  public void a(final ae.a parama)
  {
    this.lN.cb().a(new ey.a()
    {
      public void a(ex paramAnonymousex)
      {
        parama.aE();
      }
    });
  }
  
  public void a(String paramString, bc parambc)
  {
    this.lN.cb().a(paramString, parambc);
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.lN.a(paramString, paramJSONObject);
  }
  
  public void d(String paramString)
  {
    this.lN.loadUrl(paramString);
  }
  
  public void e(String paramString)
  {
    this.lN.cb().a(paramString, null);
  }
  
  public void pause()
  {
    eo.a(this.lN);
  }
  
  public void resume()
  {
    eo.b(this.lN);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */