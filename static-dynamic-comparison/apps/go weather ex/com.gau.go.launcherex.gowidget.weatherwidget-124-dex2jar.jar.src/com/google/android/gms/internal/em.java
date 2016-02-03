package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class em
{
  protected final er yY;
  private final String yZ;
  private et za;
  
  protected em(String paramString1, String paramString2, String paramString3)
  {
    eo.W(paramString1);
    this.yZ = paramString1;
    this.yY = new er(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      this.yY.ab(paramString3);
    }
  }
  
  public void U(String paramString) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public final void a(et paramet)
  {
    this.za = paramet;
    if (this.za == null) {
      dF();
    }
  }
  
  protected final void a(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.yY.a("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.za.a(this.yZ, paramString1, paramLong, paramString2);
  }
  
  protected final long dE()
  {
    return this.za.dD();
  }
  
  public void dF() {}
  
  public final String getNamespace()
  {
    return this.yZ;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */