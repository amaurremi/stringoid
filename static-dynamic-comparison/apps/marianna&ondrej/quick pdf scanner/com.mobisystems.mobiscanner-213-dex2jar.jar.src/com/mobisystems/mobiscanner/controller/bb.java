package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.a;
import com.mobisystems.mobiscanner.common.c;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bb
  extends AsyncTask<Void, Integer, Bundle>
  implements a<Integer>
{
  protected static final c apd = new c();
  protected bc<Bundle> aFX;
  protected String aFY;
  protected Bundle aFZ = new Bundle();
  protected OperationStatus aGa = OperationStatus.avB;
  protected AtomicInteger aGb = new AtomicInteger(100);
  protected AtomicInteger aGc = new AtomicInteger(0);
  protected AtomicInteger aGd = new AtomicInteger(100);
  protected AtomicInteger aGe = new AtomicInteger(0);
  protected Context mContext;
  protected final c mLog = new c(this);
  
  public bb(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    this.mContext = paramContext;
    this.aFX = parambc;
    this.aFY = paramString;
  }
  
  public Integer HE()
  {
    return Integer.valueOf(this.aGd.get());
  }
  
  public Integer HF()
  {
    return Integer.valueOf(this.aGe.get());
  }
  
  protected void a(Integer... paramVarArgs)
  {
    this.aFX.gi(this.aGb.get());
    this.aFX.gj(this.aGc.get());
    this.aFX.gk(this.aGd.get());
    this.aFX.gl(paramVarArgs[0].intValue());
  }
  
  public void e(Integer paramInteger)
  {
    this.aGe.set(paramInteger.intValue());
    publishProgress(new Integer[] { paramInteger });
  }
  
  public boolean isWorkCancelled()
  {
    return isCancelled();
  }
  
  protected void o(Bundle paramBundle)
  {
    this.aFX.az(paramBundle);
  }
  
  protected void onCancelled()
  {
    try
    {
      o(this.aFZ);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void onPreExecute()
  {
    this.aFX.gi(this.aGb.get());
    this.aFX.gl(this.aGc.get());
    this.aFX.gk(this.aGd.get());
    this.aFX.gl(this.aGe.get());
  }
  
  protected void s(Bundle paramBundle)
  {
    this.aFX.a(this.aGa, paramBundle);
  }
  
  protected void t(Bundle paramBundle)
  {
    o(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */