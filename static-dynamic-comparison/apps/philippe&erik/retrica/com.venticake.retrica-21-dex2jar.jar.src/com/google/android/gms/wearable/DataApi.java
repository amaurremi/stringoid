package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface DataApi
{
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener);
  
  public abstract PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, Asset paramAsset);
  
  public abstract PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, DataItemAsset paramDataItemAsset);
  
  public abstract PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, PutDataRequest paramPutDataRequest);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/DataApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */