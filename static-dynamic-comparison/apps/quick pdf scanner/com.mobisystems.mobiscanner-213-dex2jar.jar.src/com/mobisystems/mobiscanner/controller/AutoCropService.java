package com.mobisystems.mobiscanner.controller;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import com.mobisystems.mobiscanner.common.util.b;
import com.mobisystems.mobiscanner.common.util.h;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.util.ArrayList;
import java.util.List;

public class AutoCropService
  extends Service
{
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  ArrayList<Long> axM;
  private boolean axN = false;
  
  public void U(long paramLong)
  {
    apd.dl("onPageProcessed pageId = " + paramLong);
    this.axM.remove(Long.valueOf(paramLong));
    if (this.axM.isEmpty()) {
      stopSelf();
    }
    while (this.axN) {
      return;
    }
    new a(this, ((Long)this.axM.get(0)).longValue()).execute(new Void[0]);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    apd.dl(" autoCrop service onCreate ");
    this.axM = new ArrayList();
  }
  
  public void onDestroy()
  {
    apd.dl("autoCrop service onDestroy");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    apd.dl(" autoCrop service onStartCommand id " + paramInt2 + ": " + paramIntent);
    if (paramIntent == null)
    {
      U(-1L);
      return 2;
    }
    long l = paramIntent.getLongExtra("AUTO_CROP_SERVICE_PAGE_ID", -1L);
    if (l > 0L)
    {
      this.axM.add(Long.valueOf(l));
      if (!this.axN) {
        new a(this, l).execute(new Void[0]);
      }
    }
    return 1;
  }
  
  private class a
    extends AsyncTask<Void, Void, Void>
    implements ad
  {
    private final long axO;
    private ac axP;
    private boolean axQ = false;
    private final Context mContext;
    
    a(Context paramContext, long paramLong)
    {
      this.mContext = paramContext;
      this.axO = paramLong;
      AutoCropService.a(AutoCropService.this, true);
    }
    
    public void El() {}
    
    public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, List<b> paramList, int paramInt)
    {
      AutoCropService.CZ().dl("onPostLSD");
      DocumentModel localDocumentModel = new DocumentModel();
      localDocumentModel.a(this.axO, paramList);
      localDocumentModel.e(this.axO, 1);
    }
    
    public void a(com.mobisystems.mobiscanner.model.c paramc)
    {
      AutoCropService.CZ().dl("onSetCropMatrixFinished");
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      this.axP = new ac(new DocumentModel().ao(this.axO), this.mContext, this, this.axO);
      this.axP.f(true, true);
      return null;
    }
    
    public void m(List<h> paramList)
    {
      AutoCropService.a(AutoCropService.this, false);
      if (this.axO > 0L)
      {
        DocumentModel localDocumentModel = new DocumentModel();
        if (paramList.size() > 0)
        {
          h localh = (h)paramList.get(0);
          localDocumentModel.a(this.axO, localh);
        }
      }
      if (paramList.size() <= 0)
      {
        if (this.axQ)
        {
          AutoCropService.this.U(this.axO);
          return;
        }
        this.axQ = true;
        this.axP.f(false, false);
        return;
      }
      AutoCropService.CZ().dl("onQuadInfoAvailable");
      AutoCropService.this.U(this.axO);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/AutoCropService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */