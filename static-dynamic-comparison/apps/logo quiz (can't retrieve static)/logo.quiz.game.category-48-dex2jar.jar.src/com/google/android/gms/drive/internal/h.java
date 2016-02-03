package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class h
{
  private String No;
  private DriveId Nq;
  protected MetadataChangeSet Oa;
  private Integer Ob;
  private final int Oc;
  
  public h(int paramInt)
  {
    this.Oc = paramInt;
  }
  
  public void a(DriveId paramDriveId)
  {
    this.Nq = ((DriveId)n.i(paramDriveId));
  }
  
  public void a(MetadataChangeSet paramMetadataChangeSet)
  {
    this.Oa = ((MetadataChangeSet)n.i(paramMetadataChangeSet));
  }
  
  public void bi(String paramString)
  {
    this.No = ((String)n.i(paramString));
  }
  
  public void bk(int paramInt)
  {
    this.Ob = Integer.valueOf(paramInt);
  }
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    n.b(this.Oa, "Must provide initial metadata to CreateFileActivityBuilder.");
    n.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    paramGoogleApiClient = (q)paramGoogleApiClient.a(Drive.CU);
    this.Oa.hS().setContext(paramGoogleApiClient.getContext());
    paramGoogleApiClient = paramGoogleApiClient.hY();
    if (this.Ob == null) {}
    for (int i = -1;; i = this.Ob.intValue()) {
      try
      {
        paramGoogleApiClient = paramGoogleApiClient.a(new CreateFileIntentSenderRequest(this.Oa.hS(), i, this.No, this.Nq, this.Oc));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */