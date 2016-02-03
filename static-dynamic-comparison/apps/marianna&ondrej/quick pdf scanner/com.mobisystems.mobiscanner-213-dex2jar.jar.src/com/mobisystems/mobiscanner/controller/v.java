package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import java.util.concurrent.atomic.AtomicInteger;

public class v
  extends bb
{
  private long[] aAd;
  private boolean aCw = false;
  private b axZ;
  
  public v(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aAd = paramBundle.getLongArray("DOCUMENTS");
    this.axZ = new b(paramBundle);
    this.aCw = paramBoolean;
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    int i = 0;
    label151:
    for (;;)
    {
      try
      {
        paramVarArgs = new DocumentModel();
        this.aGa = OperationStatus.avC;
        long[] arrayOfLong = this.aAd;
        int j = arrayOfLong.length;
        long l;
        if (i < j)
        {
          l = arrayOfLong[i];
          this.aGc.getAndIncrement();
          e(Integer.valueOf(0));
          if (!paramVarArgs.a(l, this.axZ))
          {
            this.aGa = OperationStatus.avN;
            e(Integer.valueOf(this.aGd.get()));
            if (!isCancelled()) {
              break label151;
            }
          }
        }
        else
        {
          paramVarArgs = paramVarArgs.ae(this.aAd[0]);
          if (paramVarArgs != null) {
            paramVarArgs.p(this.aFZ);
          }
          paramVarArgs = this.aFZ;
          return paramVarArgs;
        }
        if (this.aCw)
        {
          paramVarArgs.aF(l);
          continue;
          i += 1;
        }
      }
      finally {}
    }
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(this.aAd.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */