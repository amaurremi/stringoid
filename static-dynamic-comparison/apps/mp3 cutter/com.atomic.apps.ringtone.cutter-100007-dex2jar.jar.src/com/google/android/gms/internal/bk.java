package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;

public final class bk
  extends cE
{
  private int b;
  
  public bk(Context paramContext, b paramb, c paramc, int paramInt)
  {
    super(paramContext, paramb, paramc, new String[0]);
    this.b = paramInt;
  }
  
  protected final String a()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected final void a(cW paramcW, cI paramcI)
  {
    Bundle localBundle = new Bundle();
    paramcW.g(paramcI, this.b, h().getPackageName(), localBundle);
  }
  
  protected final String b()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public final bo c()
  {
    return (bo)super.i();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */