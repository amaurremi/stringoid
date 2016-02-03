package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.n;
import com.google.android.gms.drive.internal.u;
import com.google.android.gms.internal.fq;
import java.io.IOException;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private Contents EA;
  private String EB;
  private DriveId EC;
  private MetadataChangeSet Ez;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    fq.b(this.Ez, "Must provide initial metadata to CreateFileActivityBuilder.");
    fq.b(this.EA, "Must provide initial contents to CreateFileActivityBuilder.");
    try
    {
      this.EA.getParcelFileDescriptor().close();
      this.EA.close();
      fq.a(paramGoogleApiClient.isConnected(), "Client must be connected");
      paramGoogleApiClient = ((n)paramGoogleApiClient.a(Drive.wx)).fE();
      try
      {
        paramGoogleApiClient = paramGoogleApiClient.a(new CreateFileIntentSenderRequest(this.Ez.fD(), this.EA.fA(), this.EB, this.EC));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.EC = ((DriveId)fq.f(paramDriveId));
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.EB = ((String)fq.f(paramString));
    return this;
  }
  
  public CreateFileActivityBuilder setInitialContents(Contents paramContents)
  {
    this.EA = ((Contents)fq.f(paramContents));
    return this;
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.Ez = ((MetadataChangeSet)fq.f(paramMetadataChangeSet));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */