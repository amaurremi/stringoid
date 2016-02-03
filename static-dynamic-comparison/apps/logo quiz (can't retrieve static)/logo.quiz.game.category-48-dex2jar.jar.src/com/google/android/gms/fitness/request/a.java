package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class a
  extends k.a
{
  private final BleScanCallback TU;
  
  private a(BleScanCallback paramBleScanCallback)
  {
    this.TU = ((BleScanCallback)n.i(paramBleScanCallback));
  }
  
  public void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    this.TU.onDeviceFound(paramBleDevice);
  }
  
  public void onScanStopped()
    throws RemoteException
  {
    this.TU.onScanStopped();
  }
  
  public static class a
  {
    private static final a TV = new a();
    private final Map<BleScanCallback, a> TW = new HashMap();
    
    public static a iV()
    {
      return TV;
    }
    
    public a a(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.TW)
      {
        a locala2 = (a)this.TW.get(paramBleScanCallback);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a(paramBleScanCallback, null);
          this.TW.put(paramBleScanCallback, locala1);
        }
        return locala1;
      }
    }
    
    public a b(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.TW)
      {
        a locala = (a)this.TW.get(paramBleScanCallback);
        if (locala != null) {
          return locala;
        }
        paramBleScanCallback = new a(paramBleScanCallback, null);
        return paramBleScanCallback;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */