package com.google.android.gms.internal;

import android.content.Context;
import java.util.HashSet;

final class dz
{
  public final dy a;
  public final String b;
  public final Context c;
  public final dl d;
  public final dx e;
  public o f;
  public bI g;
  public ak h;
  public bA i;
  public bB j;
  public x k;
  public aU l;
  public bG m = null;
  private HashSet n = null;
  
  public dz(Context paramContext, ak paramak, String paramString, dx paramdx)
  {
    if (paramak.e) {
      this.a = null;
    }
    for (;;)
    {
      this.h = paramak;
      this.b = paramString;
      this.c = paramContext;
      this.d = new dl(df.a(paramdx.b, paramContext));
      this.e = paramdx;
      return;
      this.a = new dy(paramContext);
      this.a.setMinimumWidth(paramak.g);
      this.a.setMinimumHeight(paramak.d);
      this.a.setVisibility(4);
    }
  }
  
  public final HashSet a()
  {
    return this.n;
  }
  
  public final void a(HashSet paramHashSet)
  {
    this.n = paramHashSet;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */