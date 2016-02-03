package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ac;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class kw
  implements BleApi
{
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final BleDevice paramBleDevice)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(new b(paramBleDevice), localb, str);
      }
    });
  }
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(new b(paramString), localb, str);
      }
    });
  }
  
  public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new kj.a()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kw.a locala = new kw.a(this, null);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(locala, str);
      }
      
      protected BleDevicesResult w(Status paramAnonymousStatus)
      {
        return BleDevicesResult.D(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, final StartBleScanRequest paramStartBleScanRequest)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(paramStartBleScanRequest, localb, str);
      }
    });
  }
  
  public PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, final BleScanCallback paramBleScanCallback)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        ac localac = new ac(paramBleScanCallback);
        paramAnonymouskj.iT().a(localac, localb, str);
      }
    });
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return unclaimBleDevice(paramGoogleApiClient, paramBleDevice.getAddress());
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new kj.c()
    {
      protected void a(kj paramAnonymouskj)
        throws RemoteException
      {
        kj.b localb = new kj.b(this);
        String str = paramAnonymouskj.getContext().getPackageName();
        paramAnonymouskj.iT().a(new UnclaimBleDeviceRequest(paramString), localb, str);
      }
    });
  }
  
  private static class a
    extends le.a
  {
    private final BaseImplementation.b<BleDevicesResult> De;
    
    private a(BaseImplementation.b<BleDevicesResult> paramb)
    {
      this.De = paramb;
    }
    
    public void a(BleDevicesResult paramBleDevicesResult)
    {
      this.De.b(paramBleDevicesResult);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */