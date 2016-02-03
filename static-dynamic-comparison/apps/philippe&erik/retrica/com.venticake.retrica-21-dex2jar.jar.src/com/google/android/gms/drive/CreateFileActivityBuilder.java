package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final h HF = new h(0);
  private Contents HG;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    hm.b(this.HG, "Must provide initial contents to CreateFileActivityBuilder.");
    try
    {
      this.HG.getParcelFileDescriptor().close();
      this.HG.close();
      return this.HF.build(paramGoogleApiClient);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.HF.a(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.HF.aM(paramString);
    return this;
  }
  
  public CreateFileActivityBuilder setInitialContents(Contents paramContents)
  {
    this.HG = ((Contents)hm.f(paramContents));
    this.HF.aS(this.HG.getRequestId());
    return this;
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.HF.a(paramMetadataChangeSet);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */