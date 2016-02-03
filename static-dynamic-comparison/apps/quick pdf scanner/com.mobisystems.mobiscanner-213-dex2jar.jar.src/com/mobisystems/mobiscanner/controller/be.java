package com.mobisystems.mobiscanner.controller;

import android.os.AsyncTask;
import com.mobisystems.mobiscanner.common.util.b;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.util.List;

class be
  extends AsyncTask<Long, Void, Void>
{
  private List<b> aGl;
  
  be(List<b> paramList)
  {
    this.aGl = paramList;
  }
  
  protected Void e(Long... paramVarArgs)
  {
    long l = paramVarArgs[0].longValue();
    new DocumentModel().a(l, this.aGl);
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */