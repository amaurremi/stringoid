package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class ld
  implements BleApi
{
  private static final Status TT = new Status(5007);
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return new kt(TT);
  }
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return new kt(TT);
  }
  
  public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    return new kt(BleDevicesResult.D(TT));
  }
  
  public PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest)
  {
    return new kt(TT);
  }
  
  public PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback)
  {
    return new kt(TT);
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return new kt(TT);
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return new kt(TT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */