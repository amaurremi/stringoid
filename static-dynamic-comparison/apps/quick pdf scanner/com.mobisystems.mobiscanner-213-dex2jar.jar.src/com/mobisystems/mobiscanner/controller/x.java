package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.util.concurrent.atomic.AtomicInteger;

public class x
  extends bb
{
  private long aAa;
  private String aCB;
  
  public x(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aCB = paramBundle.getString("DOC_NEW_NAME");
    this.aAa = paramBundle.getLong("DOC_CONTEXT_ID", -1L);
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = new DocumentModel();
      this.aGa = OperationStatus.avC;
      this.aGc.getAndIncrement();
      e(Integer.valueOf(0));
      if (!paramVarArgs.b(this.aAa, this.aCB.trim())) {
        this.aGa = OperationStatus.avO;
      }
      e(Integer.valueOf(this.aGd.get()));
      this.aFZ.putString("DOC_NEW_NAME", this.aCB);
      paramVarArgs = this.aFZ;
      return paramVarArgs;
    }
    finally {}
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(1);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */