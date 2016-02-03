package com.google.android.gms.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.common.api.Status;

final class oi
  implements Cast.ApplicationConnectionResult
{
  private final Status a;
  private final ApplicationMetadata b;
  private final String c;
  private final String d;
  private final boolean e;
  
  public oi(Status paramStatus)
  {
    this(paramStatus, null, null, null, false);
  }
  
  public oi(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramStatus;
    this.b = paramApplicationMetadata;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramBoolean;
  }
  
  public ApplicationMetadata getApplicationMetadata()
  {
    return this.b;
  }
  
  public String getApplicationStatus()
  {
    return this.c;
  }
  
  public String getSessionId()
  {
    return this.d;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
  
  public boolean getWasLaunched()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/oi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */