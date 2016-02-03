package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Status;

abstract class d
  extends AppStateManager.a<AppStateManager.StateListResult>
{
  public AppStateManager.StateListResult a(final Status paramStatus)
  {
    new AppStateManager.StateListResult()
    {
      public AppStateBuffer getStateBuffer()
      {
        return new AppStateBuffer(null);
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/appstate/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */