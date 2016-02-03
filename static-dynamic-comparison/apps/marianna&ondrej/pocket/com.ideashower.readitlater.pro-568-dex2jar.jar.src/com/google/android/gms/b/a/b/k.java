package com.google.android.gms.b.a.b;

import android.os.Bundle;
import com.google.android.gms.common.data.d;
import com.google.android.gms.common.data.f;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.fv;

public final class k
  extends com.google.android.gms.common.data.a
{
  private final f b;
  
  public k(d paramd)
  {
    super(paramd);
    if ((paramd.f() != null) && (paramd.f().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.b = new f(paramd, fv.CREATOR);
      return;
    }
    this.b = null;
  }
  
  public a b(int paramInt)
  {
    if (this.b != null) {
      return (a)this.b.b(paramInt);
    }
    return new ck(this.a, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/b/a/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */