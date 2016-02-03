package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import java.util.concurrent.atomic.AtomicInteger;

public class ah
  extends bb
{
  private long aAh;
  private b aDO;
  
  public ah(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aDO = new b(paramBundle);
    this.aAh = paramBundle.getLong("NEW_DOC_ID");
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    try
    {
      this.mLog.dl("Async task started");
      this.aGa = OperationStatus.avM;
      paramVarArgs = null;
      DocumentModel localDocumentModel = new DocumentModel();
      long l = localDocumentModel.f(this.aDO.getId(), this.aAh);
      if (l >= 0L) {
        paramVarArgs = localDocumentModel.ae(l);
      }
      e(Integer.valueOf(this.aGe.get() + 1));
      if (paramVarArgs != null)
      {
        paramVarArgs.p(this.aFZ);
        this.aGa = OperationStatus.avC;
      }
      paramVarArgs = this.aFZ;
      return paramVarArgs;
    }
    finally {}
  }
  
  protected void onPreExecute()
  {
    this.aGd.set(1);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */