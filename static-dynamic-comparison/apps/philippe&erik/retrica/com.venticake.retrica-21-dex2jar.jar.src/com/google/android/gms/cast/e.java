package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;

abstract class e
  extends Cast.a<Cast.ApplicationConnectionResult>
{
  public Cast.ApplicationConnectionResult a(final Status paramStatus)
  {
    new Cast.ApplicationConnectionResult()
    {
      public ApplicationMetadata getApplicationMetadata()
      {
        return null;
      }
      
      public String getApplicationStatus()
      {
        return null;
      }
      
      public String getSessionId()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public boolean getWasLaunched()
      {
        return false;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */