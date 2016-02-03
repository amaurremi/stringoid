package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.c.a;
import com.google.android.gms.common.c.b;

public class az
  extends cs<bc>
{
  private final int Dy;
  
  public az(Context paramContext, c.a parama, c.b paramb, int paramInt)
  {
    super(paramContext, parama, paramb, new String[0]);
    this.Dy = paramInt;
  }
  
  protected void a(cx paramcx, cs.d paramd)
  {
    Bundle localBundle = new Bundle();
    paramcx.g(paramd, this.Dy, getContext().getPackageName(), localBundle);
  }
  
  protected String nl()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  protected String nm()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  public bc pB()
  {
    return (bc)super.qr();
  }
  
  protected bc t(IBinder paramIBinder)
  {
    return bc.a.u(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */