package com.google.android.gms.internal;

import android.content.Context;
import java.util.HashSet;

final class qm
{
  public final qk a;
  public final String b;
  public final Context c;
  public final k d;
  public final ev e;
  public ap f;
  public em g;
  public al h;
  public ef i;
  public eg j;
  public as k;
  public dg l;
  public dc m;
  public cz n;
  public ek o = null;
  public boolean p = false;
  private HashSet<eg> q = null;
  
  public qm(Context paramContext, al paramal, String paramString, ev paramev)
  {
    if (paramal.mf) {
      this.a = null;
    }
    for (;;)
    {
      this.h = paramal;
      this.b = paramString;
      this.c = paramContext;
      this.e = paramev;
      this.d = new k(new ql(this));
      return;
      this.a = new qk(paramContext);
      this.a.setMinimumWidth(paramal.widthPixels);
      this.a.setMinimumHeight(paramal.heightPixels);
      this.a.setVisibility(4);
    }
  }
  
  public HashSet<eg> a()
  {
    return this.q;
  }
  
  public void a(HashSet<eg> paramHashSet)
  {
    this.q = paramHashSet;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/qm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */