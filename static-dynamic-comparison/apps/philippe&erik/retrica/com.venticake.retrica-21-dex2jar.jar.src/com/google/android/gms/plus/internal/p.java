package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.d;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.model.moments.MomentBuffer;

final class p
  extends hb<d>.d<a.d<Moments.LoadMomentsResult>>
  implements Moments.LoadMomentsResult
{
  private final Status b;
  private final String c;
  private final String d;
  private MomentBuffer e;
  
  public p(a.d<Moments.LoadMomentsResult> paramd, Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
  {
    super(paramd, paramStatus, paramString1);
    this.b = paramDataHolder;
    this.c = paramString2;
    String str;
    this.d = str;
  }
  
  protected void a(a.d<Moments.LoadMomentsResult> paramd, DataHolder paramDataHolder)
  {
    if (paramDataHolder != null) {}
    for (paramDataHolder = new MomentBuffer(paramDataHolder);; paramDataHolder = null)
    {
      this.e = paramDataHolder;
      paramd.a(this);
      return;
    }
  }
  
  public MomentBuffer getMomentBuffer()
  {
    return this.e;
  }
  
  public String getNextPageToken()
  {
    return this.c;
  }
  
  public Status getStatus()
  {
    return this.b;
  }
  
  public String getUpdated()
  {
    return this.d;
  }
  
  public void release()
  {
    if (this.e != null) {
      this.e.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */