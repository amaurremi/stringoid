package com.mobisystems.mobiscanner.controller;

import android.os.AsyncTask;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.c;

class bh
  extends AsyncTask<Void, Void, c>
{
  private a aGp;
  private int aGq;
  private long axO;
  
  public bh(long paramLong, int paramInt, a parama)
  {
    this.aGp = parama;
    this.axO = paramLong;
    this.aGq = paramInt;
  }
  
  public c b(Void... paramVarArgs)
  {
    paramVarArgs = null;
    DocumentModel localDocumentModel = new DocumentModel();
    if (localDocumentModel.d(this.axO, this.aGq)) {
      paramVarArgs = localDocumentModel.aj(this.axO);
    }
    return paramVarArgs;
  }
  
  public void b(c paramc)
  {
    if (this.aGp != null) {
      this.aGp.d(paramc);
    }
  }
  
  public static abstract interface a
  {
    public abstract void d(c paramc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */