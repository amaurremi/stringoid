package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.gh;

public abstract class Cast$a<R extends Result>
  extends a.b<R, gh>
{
  public Cast$a()
  {
    super(Cast.yH);
  }
  
  public void N(int paramInt)
  {
    b(c(new Status(paramInt)));
  }
  
  public void c(int paramInt, String paramString)
  {
    b(c(new Status(paramInt, paramString, null)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/Cast$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */