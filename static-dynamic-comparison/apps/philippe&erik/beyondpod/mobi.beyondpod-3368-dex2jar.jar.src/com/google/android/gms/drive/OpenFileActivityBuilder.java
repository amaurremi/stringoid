package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.o;
import com.google.android.gms.internal.eg;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String qL;
  private DriveId qM;
  private String[] qW;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    eg.b(this.qW, "setMimeType(String[]) must be called on this builder before calling build()");
    eg.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    paramGoogleApiClient = ((j)paramGoogleApiClient.a(Drive.jO)).cN();
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.a(new OpenFileIntentSenderRequest(this.qL, this.qW, this.qM));
      return paramGoogleApiClient;
    }
    catch (RemoteException paramGoogleApiClient)
    {
      throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.qM = ((DriveId)eg.f(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.qL = ((String)eg.f(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      eg.b(bool, "mimeTypes may not be null and must contain at least one value");
      this.qW = paramArrayOfString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/OpenFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */