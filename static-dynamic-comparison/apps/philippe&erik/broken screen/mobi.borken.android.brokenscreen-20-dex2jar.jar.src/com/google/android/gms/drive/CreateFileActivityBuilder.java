package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.internal.hn;
import java.io.IOException;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final h HC = new h(0);
  private Contents HD;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    hn.b(this.HD, "Must provide initial contents to CreateFileActivityBuilder.");
    try
    {
      this.HD.getParcelFileDescriptor().close();
      this.HD.close();
      return this.HC.build(paramGoogleApiClient);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.HC.a(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.HC.aM(paramString);
    return this;
  }
  
  public CreateFileActivityBuilder setInitialContents(Contents paramContents)
  {
    this.HD = ((Contents)hn.f(paramContents));
    this.HC.aS(this.HD.getRequestId());
    return this;
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.HC.a(paramMetadataChangeSet);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */