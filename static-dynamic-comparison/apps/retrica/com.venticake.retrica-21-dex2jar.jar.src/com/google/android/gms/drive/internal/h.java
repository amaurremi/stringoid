package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.hm;

public class h
{
  private String HY;
  protected MetadataChangeSet IA;
  private Integer IB;
  private final int IC;
  private DriveId Ia;
  
  public h(int paramInt)
  {
    this.IC = paramInt;
  }
  
  public void a(DriveId paramDriveId)
  {
    this.Ia = ((DriveId)hm.f(paramDriveId));
  }
  
  public void a(MetadataChangeSet paramMetadataChangeSet)
  {
    this.IA = ((MetadataChangeSet)hm.f(paramMetadataChangeSet));
  }
  
  public void aM(String paramString)
  {
    this.HY = ((String)hm.f(paramString));
  }
  
  public void aS(int paramInt)
  {
    this.IB = Integer.valueOf(paramInt);
  }
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    hm.b(this.IA, "Must provide initial metadata to CreateFileActivityBuilder.");
    hm.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    paramGoogleApiClient = ((r)paramGoogleApiClient.a(Drive.yH)).gp();
    if (this.IB == null) {}
    for (int i = -1;; i = this.IB.intValue()) {
      try
      {
        paramGoogleApiClient = paramGoogleApiClient.a(new CreateFileIntentSenderRequest(this.IA.gm(), i, this.HY, this.Ia, this.IC));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */