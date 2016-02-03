package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving.SupplementedResource;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ResourceLoaderSchedulerImpl
  implements Container.ResourceLoaderScheduler
{
  private static final boolean MAY_INTERRUPT_IF_RUNNING = true;
  private LoadCallback<Serving.SupplementedResource> mCallback;
  private boolean mClosed;
  private final String mContainerId;
  private final Context mContext;
  private CtfeHost mCtfeHost;
  private String mCtfeUrlPathAndQuery;
  private final ScheduledExecutorService mExecutor;
  private ScheduledFuture<?> mFuture;
  private final ResourceLoaderFactory mResourceLoaderFactory;
  
  public ResourceLoaderSchedulerImpl(Context paramContext, String paramString, CtfeHost paramCtfeHost)
  {
    this(paramContext, paramString, paramCtfeHost, null, null);
  }
  
  @VisibleForTesting
  ResourceLoaderSchedulerImpl(Context paramContext, String paramString, CtfeHost paramCtfeHost, ScheduledExecutorServiceFactory paramScheduledExecutorServiceFactory, ResourceLoaderFactory paramResourceLoaderFactory)
  {
    this.mCtfeHost = paramCtfeHost;
    this.mContext = paramContext;
    this.mContainerId = paramString;
    paramContext = paramScheduledExecutorServiceFactory;
    if (paramScheduledExecutorServiceFactory == null) {
      paramContext = new ScheduledExecutorServiceFactory()
      {
        public ScheduledExecutorService createExecutorService()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.mExecutor = paramContext.createExecutorService();
    if (paramResourceLoaderFactory == null)
    {
      this.mResourceLoaderFactory = new ResourceLoaderFactory()
      {
        public ResourceLoader createResourceLoader(CtfeHost paramAnonymousCtfeHost)
        {
          return new ResourceLoader(ResourceLoaderSchedulerImpl.this.mContext, ResourceLoaderSchedulerImpl.this.mContainerId, paramAnonymousCtfeHost);
        }
      };
      return;
    }
    this.mResourceLoaderFactory = paramResourceLoaderFactory;
  }
  
  private ResourceLoader createResourceLoader(String paramString)
  {
    ResourceLoader localResourceLoader = this.mResourceLoaderFactory.createResourceLoader(this.mCtfeHost);
    localResourceLoader.setLoadCallback(this.mCallback);
    localResourceLoader.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
    localResourceLoader.setPreviousVersion(paramString);
    return localResourceLoader;
  }
  
  private void ensureNotClosed()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  public void close()
  {
    try
    {
      ensureNotClosed();
      if (this.mFuture != null) {
        this.mFuture.cancel(false);
      }
      this.mExecutor.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  public void loadAfterDelay(long paramLong, String paramString)
  {
    try
    {
      Log.v("loadAfterDelay: containerId=" + this.mContainerId + " delay=" + paramLong);
      ensureNotClosed();
      if (this.mCallback == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.mFuture != null) {
      this.mFuture.cancel(false);
    }
    this.mFuture = this.mExecutor.schedule(createResourceLoader(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void setCtfeURLPathAndQuery(String paramString)
  {
    try
    {
      ensureNotClosed();
      this.mCtfeUrlPathAndQuery = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setLoadCallback(LoadCallback<Serving.SupplementedResource> paramLoadCallback)
  {
    try
    {
      ensureNotClosed();
      this.mCallback = paramLoadCallback;
      return;
    }
    finally
    {
      paramLoadCallback = finally;
      throw paramLoadCallback;
    }
  }
  
  static abstract interface ResourceLoaderFactory
  {
    public abstract ResourceLoader createResourceLoader(CtfeHost paramCtfeHost);
  }
  
  static abstract interface ScheduledExecutorServiceFactory
  {
    public abstract ScheduledExecutorService createExecutorService();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ResourceLoaderSchedulerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */