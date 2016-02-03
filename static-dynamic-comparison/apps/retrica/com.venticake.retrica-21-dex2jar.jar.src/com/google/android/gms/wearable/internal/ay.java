package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

class ay
  extends a
{
  private final a.d<DataApi.DataItemResult> a;
  private final List<FutureTask<Boolean>> b;
  
  ay(a.d<DataApi.DataItemResult> paramd, List<FutureTask<Boolean>> paramList)
  {
    this.a = paramd;
    this.b = paramList;
  }
  
  public void a(am paramam)
  {
    this.a.a(new f.a(new Status(paramam.statusCode), paramam.alO));
    if (paramam.statusCode != 0)
    {
      paramam = this.b.iterator();
      while (paramam.hasNext()) {
        ((FutureTask)paramam.next()).cancel(true);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */