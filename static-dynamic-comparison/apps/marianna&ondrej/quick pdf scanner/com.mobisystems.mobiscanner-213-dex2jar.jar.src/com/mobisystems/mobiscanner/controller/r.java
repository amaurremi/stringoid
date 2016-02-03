package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.a.b;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class r
  extends bb
{
  private long[] aAd;
  private b aAj;
  
  public r(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle, b paramb)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aAd = paramBundle.getLongArray("DOCUMENTS");
    this.aAj = paramb;
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        this.mLog.dl("Async PDF operation started, number of documents=" + this.aAd.length + ", action=" + this.aFY);
        this.aGa = OperationStatus.avE;
        try
        {
          paramVarArgs = d.ad(this.mContext);
          if (paramVarArgs != null)
          {
            this.aGa = OperationStatus.avF;
            String[] arrayOfString = new String[this.aAd.length];
            i = 0;
            localObject = arrayOfString;
            if (i < this.aAd.length)
            {
              this.mLog.dl("Start exporting of document ID:" + this.aAd[i]);
              this.aGc.getAndIncrement();
              e(Integer.valueOf(0));
              localObject = this.aAj.a(this.aAd[i], paramVarArgs, this);
              this.aGa = this.aAj.It();
              if (localObject != null) {
                arrayOfString[i] = ((File)localObject).getAbsolutePath();
              }
              this.mLog.dl("Finish exporting of document ID:" + this.aAd[i]);
              if (isCancelled()) {
                localObject = arrayOfString;
              }
            }
            else
            {
              this.aFZ.putStringArray("EXPORTED_FILES", (String[])localObject);
              paramVarArgs = this.aFZ;
              return paramVarArgs;
            }
          }
        }
        catch (IOException paramVarArgs)
        {
          int i;
          this.mLog.g("IO Exception exporting PDF", paramVarArgs);
          paramVarArgs = null;
          continue;
          i += 1;
          continue;
        }
        Object localObject = null;
      }
      finally {}
    }
  }
  
  protected void o(Bundle paramBundle)
  {
    this.mLog.dl("Async PDF operation onCancelled");
    String[] arrayOfString = paramBundle.getStringArray("EXPORTED_FILES");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str != null) {
          new File(str).delete();
        }
        i += 1;
      }
    }
    super.o(paramBundle);
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(this.aAd.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */