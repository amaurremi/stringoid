package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.panorama.Panorama;

abstract class pr<R extends Result>
  extends a.b<R, kg>
{
  protected pr()
  {
    super(Panorama.yH);
  }
  
  protected abstract void a(Context paramContext, ke paramke);
  
  protected final void a(kg paramkg)
  {
    a(paramkg.getContext(), (ke)paramkg.ft());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */