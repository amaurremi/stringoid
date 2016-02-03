package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
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
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class f
  implements DataApi
{
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener, final IntentFilter[] paramArrayOfIntentFilter)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramDataListener, paramArrayOfIntentFilter);
      }
      
      public Status d(Status paramAnonymousStatus)
      {
        return new Status(13);
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
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.c(this, paramUri);
      }
      
      protected DataApi.DeleteDataItemsResult as(Status paramAnonymousStatus)
      {
        return new f.b(paramAnonymousStatus, 0);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramUri);
      }
      
      protected DataApi.DataItemResult aq(Status paramAnonymousStatus)
      {
        return new f.a(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.o(this);
      }
      
      protected DataItemBuffer ar(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.af(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.b(this, paramUri);
      }
      
      protected DataItemBuffer ar(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.af(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final Asset paramAsset)
  {
    a(paramAsset);
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramAsset);
      }
      
      protected DataApi.GetFdForAssetResult at(Status paramAnonymousStatus)
      {
        return new f.c(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final DataItemAsset paramDataItemAsset)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramDataItemAsset);
      }
      
      protected DataApi.GetFdForAssetResult at(Status paramAnonymousStatus)
      {
        return new f.c(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramPutDataRequest);
      }
      
      public DataApi.DataItemResult aq(Status paramAnonymousStatus)
      {
        return new f.a(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramDataListener);
      }
      
      public Status d(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
    });
  }
  
  public static class a
    implements DataApi.DataItemResult
  {
    private final DataItem alE;
    private final Status yw;
    
    public a(Status paramStatus, DataItem paramDataItem)
    {
      this.yw = paramStatus;
      this.alE = paramDataItem;
    }
    
    public DataItem getDataItem()
    {
      return this.alE;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  public static class b
    implements DataApi.DeleteDataItemsResult
  {
    private final int alF;
    private final Status yw;
    
    public b(Status paramStatus, int paramInt)
    {
      this.yw = paramStatus;
      this.alF = paramInt;
    }
    
    public int getNumDeleted()
    {
      return this.alF;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  public static class c
    implements DataApi.GetFdForAssetResult
  {
    private final ParcelFileDescriptor alG;
    private final Status yw;
    
    public c(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.yw = paramStatus;
      this.alG = paramParcelFileDescriptor;
    }
    
    public ParcelFileDescriptor getFd()
    {
      return this.alG;
    }
    
    public InputStream getInputStream()
    {
      return new ParcelFileDescriptor.AutoCloseInputStream(this.alG);
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public void release()
    {
      try
      {
        this.alG.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */