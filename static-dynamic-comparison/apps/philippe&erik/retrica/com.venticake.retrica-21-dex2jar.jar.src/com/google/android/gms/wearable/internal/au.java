package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.e;
import com.google.android.gms.internal.hi;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class au
  extends hb<ad>
{
  private final ExecutorService agU = Executors.newCachedThreadPool();
  private final HashMap<DataApi.DataListener, av> ame = new HashMap();
  private final HashMap<MessageApi.MessageListener, av> amf = new HashMap();
  private final HashMap<NodeApi.NodeListener, av> amg = new HashMap();
  
  public au(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
  }
  
  private FutureTask<Boolean> a(final ParcelFileDescriptor paramParcelFileDescriptor, final byte[] paramArrayOfByte)
  {
    new FutureTask(new Callable()
    {
      /* Error */
      public Boolean a()
      {
        // Byte code:
        //   0: ldc 34
        //   2: iconst_3
        //   3: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   6: ifeq +31 -> 37
        //   9: ldc 34
        //   11: new 42	java/lang/StringBuilder
        //   14: dup
        //   15: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   18: ldc 45
        //   20: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: aload_0
        //   24: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   27: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   30: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   33: invokestatic 60	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   36: pop
        //   37: new 62	android/os/ParcelFileDescriptor$AutoCloseOutputStream
        //   40: dup
        //   41: aload_0
        //   42: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   45: invokespecial 65	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
        //   48: astore_1
        //   49: aload_1
        //   50: aload_0
        //   51: getfield 25	com/google/android/gms/wearable/internal/au$3:b	[B
        //   54: invokevirtual 69	android/os/ParcelFileDescriptor$AutoCloseOutputStream:write	([B)V
        //   57: aload_1
        //   58: invokevirtual 72	android/os/ParcelFileDescriptor$AutoCloseOutputStream:flush	()V
        //   61: ldc 34
        //   63: iconst_3
        //   64: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   67: ifeq +31 -> 98
        //   70: ldc 34
        //   72: new 42	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   79: ldc 74
        //   81: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   84: aload_0
        //   85: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   88: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   91: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   94: invokestatic 60	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   97: pop
        //   98: iconst_1
        //   99: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   102: astore_2
        //   103: ldc 34
        //   105: iconst_3
        //   106: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   109: ifeq +31 -> 140
        //   112: ldc 34
        //   114: new 42	java/lang/StringBuilder
        //   117: dup
        //   118: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   121: ldc 82
        //   123: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   126: aload_0
        //   127: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   130: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   133: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   136: invokestatic 60	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   139: pop
        //   140: aload_1
        //   141: invokevirtual 85	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   144: aload_2
        //   145: areturn
        //   146: astore_2
        //   147: ldc 34
        //   149: new 42	java/lang/StringBuilder
        //   152: dup
        //   153: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   156: ldc 87
        //   158: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: aload_0
        //   162: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   165: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   168: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   171: invokestatic 90	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
        //   174: pop
        //   175: ldc 34
        //   177: iconst_3
        //   178: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   181: ifeq +31 -> 212
        //   184: ldc 34
        //   186: new 42	java/lang/StringBuilder
        //   189: dup
        //   190: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   193: ldc 82
        //   195: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   198: aload_0
        //   199: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   202: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   205: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   208: invokestatic 60	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   211: pop
        //   212: aload_1
        //   213: invokevirtual 85	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   216: iconst_0
        //   217: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   220: areturn
        //   221: astore_2
        //   222: ldc 34
        //   224: iconst_3
        //   225: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   228: ifeq +31 -> 259
        //   231: ldc 34
        //   233: new 42	java/lang/StringBuilder
        //   236: dup
        //   237: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   240: ldc 82
        //   242: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   245: aload_0
        //   246: getfield 23	com/google/android/gms/wearable/internal/au$3:a	Landroid/os/ParcelFileDescriptor;
        //   249: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   252: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   255: invokestatic 60	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   258: pop
        //   259: aload_1
        //   260: invokevirtual 85	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   263: aload_2
        //   264: athrow
        //   265: astore_1
        //   266: goto -3 -> 263
        //   269: astore_1
        //   270: goto -54 -> 216
        //   273: astore_1
        //   274: aload_2
        //   275: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	276	0	this	3
        //   48	212	1	localAutoCloseOutputStream	android.os.ParcelFileDescriptor.AutoCloseOutputStream
        //   265	1	1	localIOException1	IOException
        //   269	1	1	localIOException2	IOException
        //   273	1	1	localIOException3	IOException
        //   102	43	2	localBoolean1	Boolean
        //   146	1	2	localIOException4	IOException
        //   221	54	2	localBoolean2	Boolean
        // Exception table:
        //   from	to	target	type
        //   49	98	146	java/io/IOException
        //   98	103	146	java/io/IOException
        //   49	98	221	finally
        //   98	103	221	finally
        //   147	175	221	finally
        //   222	259	265	java/io/IOException
        //   259	263	265	java/io/IOException
        //   175	212	269	java/io/IOException
        //   212	216	269	java/io/IOException
        //   103	140	273	java/io/IOException
        //   140	144	273	java/io/IOException
      }
    });
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", "onPostInitHandler: statusCode " + paramInt);
    }
    ad localad;
    Iterator localIterator;
    Map.Entry localEntry;
    if (paramInt == 0) {
      try
      {
        a local1 = new a()
        {
          public void a(Status paramAnonymousStatus) {}
        };
        if (Log.isLoggable("WearableClient", 2)) {
          Log.d("WearableClient", "onPostInitHandler: service " + paramIBinder);
        }
        localad = ad.a.by(paramIBinder);
        localIterator = this.ame.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: adding Data listener " + localEntry.getValue());
          }
          localad.a(local1, new b((av)localEntry.getValue()));
          continue;
          Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: done");
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: error while adding listener", localRemoteException);
      }
    }
    for (;;)
    {
      super.a(paramInt, paramIBinder, paramBundle);
      return;
      localIterator = this.amf.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (Log.isLoggable("WearableClient", 2)) {
          Log.d("WearableClient", "onPostInitHandler: adding Message listener " + localEntry.getValue());
        }
        localad.a(localRemoteException, new b((av)localEntry.getValue()));
      }
      localIterator = this.amg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (Log.isLoggable("WearableClient", 2)) {
          Log.d("WearableClient", "onPostInitHandler: adding Node listener " + localEntry.getValue());
        }
        localad.a(localRemoteException, new b((av)localEntry.getValue()));
      }
    }
  }
  
  public void a(final a.d<DataApi.DataItemResult> paramd, Uri paramUri)
  {
    ((ad)ft()).a(new a()
    {
      public void a(v paramAnonymousv)
      {
        paramd.a(new f.a(new Status(paramAnonymousv.statusCode), paramAnonymousv.alO));
      }
    }, paramUri);
  }
  
  public void a(final a.d<DataApi.GetFdForAssetResult> paramd, Asset paramAsset)
  {
    ((ad)ft()).a(new a()
    {
      public void a(x paramAnonymousx)
      {
        paramd.a(new f.c(new Status(paramAnonymousx.statusCode), paramAnonymousx.alP));
      }
    }, paramAsset);
  }
  
  public void a(a.d<Status> paramd, DataApi.DataListener paramDataListener)
  {
    synchronized (this.ame)
    {
      paramDataListener = (ac)this.ame.remove(paramDataListener);
      if (paramDataListener == null)
      {
        paramd.a(new Status(4002));
        return;
      }
    }
    a(paramd, paramDataListener);
  }
  
  public void a(final a.d<Status> paramd, final DataApi.DataListener paramDataListener, IntentFilter[] arg3)
  {
    av localav = av.a(paramDataListener, ???);
    synchronized (this.ame)
    {
      if (this.ame.get(paramDataListener) != null)
      {
        paramd.a(new Status(4001));
        return;
      }
      this.ame.put(paramDataListener, localav);
      ((ad)ft()).a(new a()new b
      {
        public void a(Status paramAnonymousStatus)
        {
          if (!paramAnonymousStatus.isSuccess()) {}
          synchronized (au.b(au.this))
          {
            au.b(au.this).remove(paramDataListener);
            paramd.a(paramAnonymousStatus);
            return;
          }
        }
      }, new b(localav));
      return;
    }
  }
  
  public void a(a.d<DataApi.GetFdForAssetResult> paramd, DataItemAsset paramDataItemAsset)
  {
    a(paramd, Asset.createFromRef(paramDataItemAsset.getId()));
  }
  
  public void a(a.d<Status> paramd, MessageApi.MessageListener paramMessageListener)
  {
    synchronized (this.amf)
    {
      paramMessageListener = (ac)this.amf.remove(paramMessageListener);
      if (paramMessageListener == null)
      {
        paramd.a(new Status(4002));
        return;
      }
      a(paramd, paramMessageListener);
    }
  }
  
  public void a(final a.d<Status> paramd, final MessageApi.MessageListener paramMessageListener, IntentFilter[] arg3)
  {
    av localav = av.a(paramMessageListener, ???);
    synchronized (this.amf)
    {
      if (this.amf.get(paramMessageListener) != null)
      {
        paramd.a(new Status(4001));
        return;
      }
      this.amf.put(paramMessageListener, localav);
      ((ad)ft()).a(new a()new b
      {
        public void a(Status paramAnonymousStatus)
        {
          if (!paramAnonymousStatus.isSuccess()) {}
          synchronized (au.c(au.this))
          {
            au.c(au.this).remove(paramMessageListener);
            paramd.a(paramAnonymousStatus);
            return;
          }
        }
      }, new b(localav));
      return;
    }
  }
  
  public void a(final a.d<Status> paramd, final NodeApi.NodeListener paramNodeListener)
  {
    av localav = av.a(paramNodeListener);
    synchronized (this.amg)
    {
      if (this.amg.get(paramNodeListener) != null)
      {
        paramd.a(new Status(4001));
        return;
      }
      this.amg.put(paramNodeListener, localav);
      ((ad)ft()).a(new a()new b
      {
        public void a(Status paramAnonymousStatus)
        {
          if (!paramAnonymousStatus.isSuccess()) {}
          synchronized (au.d(au.this))
          {
            au.d(au.this).remove(paramNodeListener);
            paramd.a(paramAnonymousStatus);
            return;
          }
        }
      }, new b(localav));
      return;
    }
  }
  
  public void a(a.d<DataApi.DataItemResult> paramd, PutDataRequest paramPutDataRequest)
  {
    Object localObject1 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Asset)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((((Asset)localObject2).getData() == null) && (((Asset)localObject2).getDigest() == null) && (((Asset)localObject2).getFd() == null) && (((Asset)localObject2).getUri() == null)) {
        throw new IllegalArgumentException("Put for " + paramPutDataRequest.getUri() + " contains invalid asset: " + localObject2);
      }
    }
    localObject1 = PutDataRequest.k(paramPutDataRequest.getUri());
    ((PutDataRequest)localObject1).setData(paramPutDataRequest.getData());
    Object localObject2 = new ArrayList();
    Iterator localIterator = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (Map.Entry)localIterator.next();
      Asset localAsset = (Asset)((Map.Entry)localObject3).getValue();
      if (localAsset.getData() == null) {
        ((PutDataRequest)localObject1).putAsset((String)((Map.Entry)localObject3).getKey(), (Asset)((Map.Entry)localObject3).getValue());
      } else {
        try
        {
          ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3)) {
            Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + localAsset + " read:" + arrayOfParcelFileDescriptor[0] + " write:" + arrayOfParcelFileDescriptor[1]);
          }
          ((PutDataRequest)localObject1).putAsset((String)((Map.Entry)localObject3).getKey(), Asset.createFromFd(arrayOfParcelFileDescriptor[0]));
          localObject3 = a(arrayOfParcelFileDescriptor[1], localAsset.getData());
          ((List)localObject2).add(localObject3);
          this.agU.submit((Runnable)localObject3);
        }
        catch (IOException paramd)
        {
          throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, paramd);
        }
      }
    }
    try
    {
      ((ad)ft()).a(new ay(paramd, (List)localObject2), (PutDataRequest)localObject1);
      return;
    }
    catch (NullPointerException paramd)
    {
      throw new IllegalStateException("Unable to putDataItem: " + paramPutDataRequest, paramd);
    }
  }
  
  public void a(final a.d<Status> paramd, ac paramac)
  {
    ((ad)ft()).a(new a()new ao
    {
      public void a(Status paramAnonymousStatus)
      {
        paramd.a(paramAnonymousStatus);
      }
    }, new ao(paramac));
  }
  
  public void a(final a.d<MessageApi.SendMessageResult> paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    ((ad)ft()).a(new a()
    {
      public void a(aq paramAnonymousaq)
      {
        paramd.a(new ae.a(new Status(paramAnonymousaq.statusCode), paramAnonymousaq.amc));
      }
    }, paramString1, paramString2, paramArrayOfByte);
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    paramhi.e(parame, 5089000, getContext().getPackageName());
  }
  
  public void b(final a.d<DataItemBuffer> paramd, Uri paramUri)
  {
    ((ad)ft()).b(new a()
    {
      public void Z(DataHolder paramAnonymousDataHolder)
      {
        paramd.a(new DataItemBuffer(paramAnonymousDataHolder));
      }
    }, paramUri);
  }
  
  public void b(a.d<Status> paramd, NodeApi.NodeListener paramNodeListener)
  {
    synchronized (this.amg)
    {
      paramNodeListener = (ac)this.amg.remove(paramNodeListener);
      if (paramNodeListener == null)
      {
        paramd.a(new Status(4002));
        return;
      }
      a(paramd, paramNodeListener);
    }
  }
  
  protected String bu()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  protected ad bz(IBinder paramIBinder)
  {
    return ad.a.by(paramIBinder);
  }
  
  public void c(final a.d<DataApi.DeleteDataItemsResult> paramd, Uri paramUri)
  {
    ((ad)ft()).c(new a()
    {
      public void a(p paramAnonymousp)
      {
        paramd.a(new f.b(new Status(paramAnonymousp.statusCode), paramAnonymousp.alL));
      }
    }, paramUri);
  }
  
  public void disconnect()
  {
    super.disconnect();
    this.ame.clear();
    this.amf.clear();
    this.amg.clear();
  }
  
  public void o(final a.d<DataItemBuffer> paramd)
  {
    ((ad)ft()).d(new a()
    {
      public void Z(DataHolder paramAnonymousDataHolder)
      {
        paramd.a(new DataItemBuffer(paramAnonymousDataHolder));
      }
    });
  }
  
  public void p(final a.d<NodeApi.GetLocalNodeResult> paramd)
  {
    ((ad)ft()).e(new a()
    {
      public void a(z paramAnonymousz)
      {
        paramd.a(new ah.b(new Status(paramAnonymousz.statusCode), paramAnonymousz.alQ));
      }
    });
  }
  
  public void q(final a.d<NodeApi.GetConnectedNodesResult> paramd)
  {
    ((ad)ft()).f(new a()
    {
      public void a(t paramAnonymoust)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(paramAnonymoust.alN);
        paramd.a(new ah.a(new Status(paramAnonymoust.statusCode), localArrayList));
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */