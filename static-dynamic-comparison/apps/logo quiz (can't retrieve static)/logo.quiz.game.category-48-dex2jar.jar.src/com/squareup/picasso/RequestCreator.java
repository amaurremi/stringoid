package com.squareup.picasso;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator
{
  private static int nextId = 0;
  private final Request.Builder data;
  private boolean deferred;
  private Drawable errorDrawable;
  private int errorResId;
  private boolean noFade;
  private final Picasso picasso;
  private Drawable placeholderDrawable;
  private int placeholderResId;
  private boolean skipMemoryCache;
  
  RequestCreator()
  {
    this.picasso = null;
    this.data = new Request.Builder(null, 0);
  }
  
  RequestCreator(Picasso paramPicasso, Uri paramUri, int paramInt)
  {
    if (paramPicasso.shutdown) {
      throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }
    this.picasso = paramPicasso;
    this.data = new Request.Builder(paramUri, paramInt);
  }
  
  private Request createRequest(long paramLong)
  {
    int i = getRequestId();
    Request localRequest1 = this.data.build();
    localRequest1.id = i;
    localRequest1.started = paramLong;
    boolean bool = this.picasso.loggingEnabled;
    if (bool) {
      Utils.log("Main", "created", localRequest1.plainId(), localRequest1.toString());
    }
    Request localRequest2 = this.picasso.transformRequest(localRequest1);
    if (localRequest2 != localRequest1)
    {
      localRequest2.id = i;
      localRequest2.started = paramLong;
      if (bool) {
        Utils.log("Main", "changed", localRequest2.logId(), "into " + localRequest2);
      }
    }
    return localRequest2;
  }
  
  private static int getRequestId()
  {
    if (Utils.isMain())
    {
      int i = nextId;
      nextId = i + 1;
      return i;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AtomicInteger localAtomicInteger = new AtomicInteger();
    Picasso.HANDLER.post(new Runnable()
    {
      public void run()
      {
        this.val$id.set(RequestCreator.access$000());
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      return localAtomicInteger.get();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new RuntimeException(this.val$e);
          }
        });
      }
    }
  }
  
  private void performRemoteViewInto(RemoteViewsAction paramRemoteViewsAction)
  {
    if (!this.skipMemoryCache)
    {
      Bitmap localBitmap = this.picasso.quickMemoryCacheCheck(paramRemoteViewsAction.getKey());
      if (localBitmap != null)
      {
        paramRemoteViewsAction.complete(localBitmap, Picasso.LoadedFrom.MEMORY);
        return;
      }
    }
    if (this.placeholderResId != 0) {
      paramRemoteViewsAction.setImageResource(this.placeholderResId);
    }
    this.picasso.enqueueAndSubmit(paramRemoteViewsAction);
  }
  
  public RequestCreator centerCrop()
  {
    this.data.centerCrop();
    return this;
  }
  
  public RequestCreator centerInside()
  {
    this.data.centerInside();
    return this;
  }
  
  public RequestCreator config(Bitmap.Config paramConfig)
  {
    this.data.config(paramConfig);
    return this;
  }
  
  public RequestCreator error(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Error image resource invalid.");
    }
    if (this.errorDrawable != null) {
      throw new IllegalStateException("Error image already set.");
    }
    this.errorResId = paramInt;
    return this;
  }
  
  public RequestCreator error(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new IllegalArgumentException("Error image may not be null.");
    }
    if (this.errorResId != 0) {
      throw new IllegalStateException("Error image already set.");
    }
    this.errorDrawable = paramDrawable;
    return this;
  }
  
  public void fetch()
  {
    long l = System.nanoTime();
    if (this.deferred) {
      throw new IllegalStateException("Fit cannot be used with fetch.");
    }
    if (this.data.hasImage())
    {
      Object localObject = createRequest(l);
      String str = Utils.createKey((Request)localObject, new StringBuilder());
      localObject = new FetchAction(this.picasso, (Request)localObject, this.skipMemoryCache, str);
      this.picasso.submit((Action)localObject);
    }
  }
  
  public RequestCreator fit()
  {
    this.deferred = true;
    return this;
  }
  
  public Bitmap get()
    throws IOException
  {
    long l = System.nanoTime();
    Utils.checkNotMain();
    if (this.deferred) {
      throw new IllegalStateException("Fit cannot be used with get.");
    }
    if (!this.data.hasImage()) {
      return null;
    }
    Object localObject = createRequest(l);
    String str = Utils.createKey((Request)localObject, new StringBuilder());
    localObject = new GetAction(this.picasso, (Request)localObject, this.skipMemoryCache, str);
    return BitmapHunter.forRequest(this.picasso.context, this.picasso, this.picasso.dispatcher, this.picasso.cache, this.picasso.stats, (Action)localObject, this.picasso.dispatcher.downloader).hunt();
  }
  
  public void into(ImageView paramImageView)
  {
    into(paramImageView, null);
  }
  
  public void into(ImageView paramImageView, Callback paramCallback)
  {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramImageView == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (!this.data.hasImage())
    {
      this.picasso.cancelRequest(paramImageView);
      PicassoDrawable.setPlaceholder(paramImageView, this.placeholderResId, this.placeholderDrawable);
    }
    Request localRequest;
    String str;
    do
    {
      return;
      if (this.deferred)
      {
        if (this.data.hasSize()) {
          throw new IllegalStateException("Fit cannot be used with resize.");
        }
        int i = paramImageView.getWidth();
        int j = paramImageView.getHeight();
        if ((i == 0) || (j == 0))
        {
          PicassoDrawable.setPlaceholder(paramImageView, this.placeholderResId, this.placeholderDrawable);
          this.picasso.defer(paramImageView, new DeferredRequestCreator(this, paramImageView, paramCallback));
          return;
        }
        this.data.resize(i, j);
      }
      localRequest = createRequest(l);
      str = Utils.createKey(localRequest);
      if (this.skipMemoryCache) {
        break;
      }
      Bitmap localBitmap = this.picasso.quickMemoryCacheCheck(str);
      if (localBitmap == null) {
        break;
      }
      this.picasso.cancelRequest(paramImageView);
      PicassoDrawable.setBitmap(paramImageView, this.picasso.context, localBitmap, Picasso.LoadedFrom.MEMORY, this.noFade, this.picasso.indicatorsEnabled);
      if (this.picasso.loggingEnabled) {
        Utils.log("Main", "completed", localRequest.plainId(), "from " + Picasso.LoadedFrom.MEMORY);
      }
    } while (paramCallback == null);
    paramCallback.onSuccess();
    return;
    PicassoDrawable.setPlaceholder(paramImageView, this.placeholderResId, this.placeholderDrawable);
    paramImageView = new ImageViewAction(this.picasso, paramImageView, localRequest, this.skipMemoryCache, this.noFade, this.errorResId, this.errorDrawable, str, paramCallback);
    this.picasso.enqueueAndSubmit(paramImageView);
  }
  
  public void into(RemoteViews paramRemoteViews, int paramInt1, int paramInt2, Notification paramNotification)
  {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramRemoteViews == null) {
      throw new IllegalArgumentException("RemoteViews must not be null.");
    }
    if (paramNotification == null) {
      throw new IllegalArgumentException("Notification must not be null.");
    }
    if (this.deferred) {
      throw new IllegalStateException("Fit cannot be used with RemoteViews.");
    }
    if ((this.placeholderDrawable != null) || (this.errorDrawable != null)) {
      throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
    }
    Request localRequest = createRequest(l);
    String str = Utils.createKey(localRequest);
    performRemoteViewInto(new RemoteViewsAction.NotificationAction(this.picasso, localRequest, paramRemoteViews, paramInt1, paramInt2, paramNotification, this.skipMemoryCache, this.errorResId, str));
  }
  
  public void into(RemoteViews paramRemoteViews, int paramInt, int[] paramArrayOfInt)
  {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramRemoteViews == null) {
      throw new IllegalArgumentException("remoteViews must not be null.");
    }
    if (paramArrayOfInt == null) {
      throw new IllegalArgumentException("appWidgetIds must not be null.");
    }
    if (this.deferred) {
      throw new IllegalStateException("Fit cannot be used with remote views.");
    }
    if ((this.placeholderDrawable != null) || (this.errorDrawable != null)) {
      throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
    }
    Request localRequest = createRequest(l);
    String str = Utils.createKey(localRequest);
    performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(this.picasso, localRequest, paramRemoteViews, paramInt, paramArrayOfInt, this.skipMemoryCache, this.errorResId, str));
  }
  
  public void into(Target paramTarget)
  {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramTarget == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (this.deferred) {
      throw new IllegalStateException("Fit cannot be used with a Target.");
    }
    if (this.placeholderResId != 0) {}
    for (Drawable localDrawable = this.picasso.context.getResources().getDrawable(this.placeholderResId); !this.data.hasImage(); localDrawable = this.placeholderDrawable)
    {
      this.picasso.cancelRequest(paramTarget);
      paramTarget.onPrepareLoad(localDrawable);
      return;
    }
    Request localRequest = createRequest(l);
    String str = Utils.createKey(localRequest);
    if (!this.skipMemoryCache)
    {
      Bitmap localBitmap = this.picasso.quickMemoryCacheCheck(str);
      if (localBitmap != null)
      {
        this.picasso.cancelRequest(paramTarget);
        paramTarget.onBitmapLoaded(localBitmap, Picasso.LoadedFrom.MEMORY);
        return;
      }
    }
    paramTarget.onPrepareLoad(localDrawable);
    paramTarget = new TargetAction(this.picasso, paramTarget, localRequest, this.skipMemoryCache, this.errorResId, this.errorDrawable, str);
    this.picasso.enqueueAndSubmit(paramTarget);
  }
  
  public RequestCreator noFade()
  {
    this.noFade = true;
    return this;
  }
  
  public RequestCreator placeholder(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Placeholder image resource invalid.");
    }
    if (this.placeholderDrawable != null) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    this.placeholderResId = paramInt;
    return this;
  }
  
  public RequestCreator placeholder(Drawable paramDrawable)
  {
    if (this.placeholderResId != 0) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    this.placeholderDrawable = paramDrawable;
    return this;
  }
  
  public RequestCreator resize(int paramInt1, int paramInt2)
  {
    this.data.resize(paramInt1, paramInt2);
    return this;
  }
  
  public RequestCreator resizeDimen(int paramInt1, int paramInt2)
  {
    Resources localResources = this.picasso.context.getResources();
    return resize(localResources.getDimensionPixelSize(paramInt1), localResources.getDimensionPixelSize(paramInt2));
  }
  
  public RequestCreator rotate(float paramFloat)
  {
    this.data.rotate(paramFloat);
    return this;
  }
  
  public RequestCreator rotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.data.rotate(paramFloat1, paramFloat2, paramFloat3);
    return this;
  }
  
  public RequestCreator skipMemoryCache()
  {
    this.skipMemoryCache = true;
    return this;
  }
  
  public RequestCreator transform(Transformation paramTransformation)
  {
    this.data.transform(paramTransformation);
    return this;
  }
  
  RequestCreator unfit()
  {
    this.deferred = false;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/RequestCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */