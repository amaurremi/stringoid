package com.google.android.gms.drive.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.m;

public abstract interface ab
  extends IInterface
{
  public abstract void a(OnContentsResponse paramOnContentsResponse);
  
  public abstract void a(OnDownloadProgressResponse paramOnDownloadProgressResponse);
  
  public abstract void a(OnDriveIdResponse paramOnDriveIdResponse);
  
  public abstract void a(OnListEntriesResponse paramOnListEntriesResponse);
  
  public abstract void a(OnListParentsResponse paramOnListParentsResponse);
  
  public abstract void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, m paramm);
  
  public abstract void a(OnMetadataResponse paramOnMetadataResponse);
  
  public abstract void a(OnResourceIdSetResponse paramOnResourceIdSetResponse);
  
  public abstract void a(OnStorageStatsResponse paramOnStorageStatsResponse);
  
  public abstract void a(OnSyncMoreResponse paramOnSyncMoreResponse);
  
  public abstract void o(Status paramStatus);
  
  public abstract void onSuccess();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */