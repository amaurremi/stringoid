package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class nu<T>
  implements Result
{
  protected final T a;
  private final Status b;
  
  public nu(Status paramStatus, T paramT)
  {
    this.b = paramStatus;
    this.a = paramT;
  }
  
  public Status getStatus()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/nu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */