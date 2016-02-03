package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.kc;
import com.google.android.gms.internal.km;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.lh;
import com.google.android.gms.internal.lj.a;
import java.util.List;

public abstract class FitnessSensorService
  extends Service
{
  public static final String SERVICE_ACTION = "com.google.android.gms.fitness.service.FitnessSensorService";
  private a UP;
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(paramIntent.getAction()))
    {
      if (Log.isLoggable("FitnessSensorService", 3)) {
        Log.d("FitnessSensorService", "Intent " + paramIntent + " received by " + getClass().getName());
      }
      return this.UP.asBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.UP = new a(this, null);
  }
  
  public abstract List<DataSource> onFindDataSources(List<DataType> paramList);
  
  public abstract boolean onRegister(FitnessSensorServiceRequest paramFitnessSensorServiceRequest);
  
  public abstract boolean onUnregister(DataSource paramDataSource);
  
  private static class a
    extends lj.a
  {
    private final FitnessSensorService UQ;
    
    private a(FitnessSensorService paramFitnessSensorService)
    {
      this.UQ = paramFitnessSensorService;
    }
    
    private void jK()
      throws SecurityException
    {
      int i = Binder.getCallingUid();
      if (kc.hI())
      {
        ((AppOpsManager)this.UQ.getSystemService("appops")).checkPackage(i, "com.google.android.gms");
        return;
      }
      String[] arrayOfString = this.UQ.getPackageManager().getPackagesForUid(i);
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label73;
          }
          if (arrayOfString[i].equals("com.google.android.gms")) {
            break;
          }
          i += 1;
        }
      }
      label73:
      throw new SecurityException("Unauthorized caller");
    }
    
    public void a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, ks paramks)
      throws RemoteException
    {
      jK();
      if (this.UQ.onRegister(paramFitnessSensorServiceRequest))
      {
        paramks.k(Status.Jo);
        return;
      }
      paramks.k(new Status(13));
    }
    
    public void a(lf paramlf, km paramkm)
      throws RemoteException
    {
      jK();
      paramkm.a(new DataSourcesResult(this.UQ.onFindDataSources(paramlf.getDataTypes()), Status.Jo));
    }
    
    public void a(lh paramlh, ks paramks)
      throws RemoteException
    {
      jK();
      if (this.UQ.onUnregister(paramlh.getDataSource()))
      {
        paramks.k(Status.Jo);
        return;
      }
      paramks.k(new Status(13));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/service/FitnessSensorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */