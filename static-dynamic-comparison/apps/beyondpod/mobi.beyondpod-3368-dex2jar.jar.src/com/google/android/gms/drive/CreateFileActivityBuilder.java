package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.o;
import com.google.android.gms.internal.eg;
import java.io.IOException;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private MetadataChangeSet qJ;
  private Contents qK;
  private String qL;
  private DriveId qM;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    eg.b(this.qK, "Must provide initial contents to CreateFileActivityBuilder.");
    try
    {
      this.qK.getParcelFileDescriptor().close();
      this.qK.close();
      eg.a(paramGoogleApiClient.isConnected(), "Client must be connected");
      paramGoogleApiClient = ((j)paramGoogleApiClient.a(Drive.jO)).cN();
      try
      {
        paramGoogleApiClient = paramGoogleApiClient.a(new CreateFileIntentSenderRequest(this.qJ.cM(), this.qK.cJ(), this.qL, this.qM));
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
    this.qM = ((DriveId)eg.f(paramDriveId));
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.qL = ((String)eg.f(paramString));
    return this;
  }
  
  public CreateFileActivityBuilder setInitialContents(Contents paramContents)
  {
    this.qK = ((Contents)eg.f(paramContents));
    return this;
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.qJ = ((MetadataChangeSet)eg.f(paramMetadataChangeSet));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */