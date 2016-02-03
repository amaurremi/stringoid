package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.ab;
import com.google.android.gms.drive.internal.q;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String No;
  private String[] Np;
  private DriveId Nq;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    n.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.Np == null) {
      this.Np = new String[0];
    }
    paramGoogleApiClient = ((q)paramGoogleApiClient.a(Drive.CU)).hY();
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.a(new OpenFileIntentSenderRequest(this.No, this.Np, this.Nq));
      return paramGoogleApiClient;
    }
    catch (RemoteException paramGoogleApiClient)
    {
      throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.Nq = ((DriveId)n.i(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.No = ((String)n.i(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "mimeTypes may not be null");
      this.Np = paramArrayOfString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/OpenFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */