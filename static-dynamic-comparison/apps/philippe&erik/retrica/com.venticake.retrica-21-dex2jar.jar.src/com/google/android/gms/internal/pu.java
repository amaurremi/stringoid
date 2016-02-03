package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.a;
import com.google.android.gms.plus.model.moments.MomentBuffer;

abstract class pu
  extends Plus.a<Moments.LoadMomentsResult>
{
  public Moments.LoadMomentsResult a(final Status paramStatus)
  {
    new Moments.LoadMomentsResult()
    {
      public MomentBuffer getMomentBuffer()
      {
        return null;
      }
      
      public String getNextPageToken()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public String getUpdated()
      {
        return null;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */