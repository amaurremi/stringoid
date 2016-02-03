package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.util.concurrent.atomic.AtomicInteger;

public class az
  extends bb
{
  private long[] aDR;
  
  public az(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aDR = paramBundle.getLongArray("PAGES");
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    try
    {
      this.mLog.dl("Async task started");
      paramVarArgs = new DocumentModel();
      long[] arrayOfLong = this.aDR;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        paramVarArgs.al(arrayOfLong[i]);
        i += 1;
      }
      paramVarArgs = this.aFZ;
      return paramVarArgs;
    }
    finally {}
  }
  
  protected void onPreExecute()
  {
    this.aGd.set(this.aDR.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */