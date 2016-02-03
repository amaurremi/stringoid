package com.mobisystems.mobiscanner.controller;

import android.os.AsyncTask;
import com.mobisystems.mobiscanner.common.util.h;
import com.mobisystems.mobiscanner.model.DocumentModel;

class bf
  extends AsyncTask<Long, Void, Void>
{
  private h aGm;
  
  bf(h paramh)
  {
    this.aGm = paramh;
  }
  
  protected Void e(Long... paramVarArgs)
  {
    long l = paramVarArgs[0].longValue();
    new DocumentModel().a(l, this.aGm);
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */