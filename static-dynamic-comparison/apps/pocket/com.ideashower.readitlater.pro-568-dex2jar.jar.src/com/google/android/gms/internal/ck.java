package com.google.android.gms.internal;

import com.google.android.gms.b.a.b.a;
import com.google.android.gms.b.a.b.f;
import com.google.android.gms.b.a.b.g;
import com.google.android.gms.common.data.d;
import com.google.android.gms.common.data.e;

public final class ck
  extends e
  implements a
{
  public ck(d paramd, int paramInt)
  {
    super(paramd, paramInt);
  }
  
  public String b()
  {
    return d("displayName");
  }
  
  public String c()
  {
    return d("personId");
  }
  
  public int d()
  {
    return bz.a(d("objectType"));
  }
  
  public String e()
  {
    return d("url");
  }
  
  public a f()
  {
    return new fv(b(), c(), (fv.c)q(), d(), e());
  }
  
  public int o()
  {
    return 0;
  }
  
  public f q()
  {
    return new fv.c(d("image"));
  }
  
  public g u()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */