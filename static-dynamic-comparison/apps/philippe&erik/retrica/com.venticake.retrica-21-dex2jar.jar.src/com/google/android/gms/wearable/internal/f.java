package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

public final class f
  implements DataApi
{
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener, final IntentFilter[] paramArrayOfIntentFilter)
  {
    paramGoogleApiClient.a(new az()
    {
      public Status a(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramDataListener, paramArrayOfIntentFilter);
      }
    });
  }
  
  private void a(Asset paramAsset)
  {
    if (paramAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (paramAsset.getDigest() == null) {
      throw new IllegalArgumentException("invalid asset");
    }
    if (paramAsset.getData() != null) {
      throw new IllegalArgumentException("invalid asset");
    }
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    return a(paramGoogleApiClient, paramDataListener, null);
  }
  
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new az()
    {
      protected DataApi.DeleteDataItemsResult a(Status paramAnonymousStatus)
      {
        return new f.b(paramAnonymousStatus, 0);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.c(this, paramUri);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new az()
    {
      protected DataApi.DataItemResult a(Status paramAnonymousStatus)
      {
        return new f.a(paramAnonymousStatus, null);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramUri);
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new az()
    {
      protected DataItemBuffer a(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.af(paramAnonymousStatus.getStatusCode()));
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.o(this);
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new az()
    {
      protected DataItemBuffer a(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.af(paramAnonymousStatus.getStatusCode()));
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.b(this, paramUri);
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final Asset paramAsset)
  {
    a(paramAsset);
    paramGoogleApiClient.a(new az()
    {
      protected DataApi.GetFdForAssetResult a(Status paramAnonymousStatus)
      {
        return new f.c(paramAnonymousStatus, null);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramAsset);
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final DataItemAsset paramDataItemAsset)
  {
    paramGoogleApiClient.a(new az()
    {
      protected DataApi.GetFdForAssetResult a(Status paramAnonymousStatus)
      {
        return new f.c(paramAnonymousStatus, null);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramDataItemAsset);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    paramGoogleApiClient.a(new az()
    {
      public DataApi.DataItemResult a(Status paramAnonymousStatus)
      {
        return new f.a(paramAnonymousStatus, null);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramPutDataRequest);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener)
  {
    paramGoogleApiClient.a(new az()
    {
      public Status a(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramDataListener);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */