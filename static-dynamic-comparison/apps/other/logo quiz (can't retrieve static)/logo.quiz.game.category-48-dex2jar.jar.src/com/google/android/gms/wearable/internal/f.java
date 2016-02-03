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
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.a(this, paramDataListener, paramArrayOfIntentFilter);
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
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.c(this, paramUri);
      }
      
      protected DataApi.DeleteDataItemsResult aH(Status paramAnonymousStatus)
      {
        return new f.b(paramAnonymousStatus, 0);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.a(this, paramUri);
      }
      
      protected DataApi.DataItemResult aF(Status paramAnonymousStatus)
      {
        return new f.a(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.o(this);
      }
      
      protected DataItemBuffer aG(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.as(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.b(this, paramUri);
      }
      
      protected DataItemBuffer aG(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.as(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final Asset paramAsset)
  {
    a(paramAsset);
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.a(this, paramAsset);
      }
      
      protected DataApi.GetFdForAssetResult aI(Status paramAnonymousStatus)
      {
        return new f.c(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final DataItemAsset paramDataItemAsset)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.a(this, paramDataItemAsset);
      }
      
      protected DataApi.GetFdForAssetResult aI(Status paramAnonymousStatus)
      {
        return new f.c(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.a(this, paramPutDataRequest);
      }
      
      public DataApi.DataItemResult aF(Status paramAnonymousStatus)
      {
        return new f.a(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(aw paramAnonymousaw)
        throws RemoteException
      {
        paramAnonymousaw.a(this, paramDataListener);
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
    private final Status CM;
    private final DataItem avh;
    
    public a(Status paramStatus, DataItem paramDataItem)
    {
      this.CM = paramStatus;
      this.avh = paramDataItem;
    }
    
    public DataItem getDataItem()
    {
      return this.avh;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  public static class b
    implements DataApi.DeleteDataItemsResult
  {
    private final Status CM;
    private final int avi;
    
    public b(Status paramStatus, int paramInt)
    {
      this.CM = paramStatus;
      this.avi = paramInt;
    }
    
    public int getNumDeleted()
    {
      return this.avi;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  public static class c
    implements DataApi.GetFdForAssetResult
  {
    private final Status CM;
    private volatile InputStream XM;
    private volatile ParcelFileDescriptor avj;
    private volatile boolean mClosed = false;
    
    public c(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.CM = paramStatus;
      this.avj = paramParcelFileDescriptor;
    }
    
    public ParcelFileDescriptor getFd()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the file descriptor after release().");
      }
      return this.avj;
    }
    
    public InputStream getInputStream()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the input stream after release().");
      }
      if (this.avj == null) {
        return null;
      }
      if (this.XM == null) {
        this.XM = new ParcelFileDescriptor.AutoCloseInputStream(this.avj);
      }
      return this.XM;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
    
    public void release()
    {
      if (this.avj == null) {
        return;
      }
      if (this.mClosed) {
        throw new IllegalStateException("releasing an already released result.");
      }
      try
      {
        if (this.XM != null) {
          this.XM.close();
        }
        for (;;)
        {
          this.mClosed = true;
          this.avj = null;
          this.XM = null;
          return;
          this.avj.close();
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */