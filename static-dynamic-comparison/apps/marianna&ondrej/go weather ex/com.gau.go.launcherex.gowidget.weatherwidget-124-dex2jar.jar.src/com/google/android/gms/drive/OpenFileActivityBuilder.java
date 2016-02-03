package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.n;
import com.google.android.gms.drive.internal.u;
import com.google.android.gms.internal.fq;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String EB;
  private DriveId EC;
  private String[] EQ;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    fq.b(this.EQ, "setMimeType(String[]) must be called on this builder before calling build()");
    fq.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    paramGoogleApiClient = ((n)paramGoogleApiClient.a(Drive.wx)).fE();
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.a(new OpenFileIntentSenderRequest(this.EB, this.EQ, this.EC));
      return paramGoogleApiClient;
    }
    catch (RemoteException paramGoogleApiClient)
    {
      throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.EC = ((DriveId)fq.f(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.EB = ((String)fq.f(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      fq.b(bool, "mimeTypes may not be null and must contain at least one value");
      this.EQ = paramArrayOfString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/OpenFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */