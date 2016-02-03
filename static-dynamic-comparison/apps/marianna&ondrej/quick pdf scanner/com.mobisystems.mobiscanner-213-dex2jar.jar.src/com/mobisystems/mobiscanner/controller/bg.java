package com.mobisystems.mobiscanner.controller;

import android.graphics.Matrix;
import android.os.AsyncTask;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.c;

class bg
  extends AsyncTask<Void, Void, c>
{
  private ad aGn;
  private Matrix aGo;
  private long axO;
  
  public bg(long paramLong, Matrix paramMatrix, ad paramad)
  {
    this.aGn = paramad;
    this.axO = paramLong;
    this.aGo = new Matrix(paramMatrix);
  }
  
  public c b(Void... paramVarArgs)
  {
    paramVarArgs = null;
    DocumentModel localDocumentModel = new DocumentModel();
    if (localDocumentModel.a(this.axO, this.aGo)) {
      paramVarArgs = localDocumentModel.aj(this.axO);
    }
    return paramVarArgs;
  }
  
  public void b(c paramc)
  {
    if (this.aGn != null) {
      this.aGn.a(paramc);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */