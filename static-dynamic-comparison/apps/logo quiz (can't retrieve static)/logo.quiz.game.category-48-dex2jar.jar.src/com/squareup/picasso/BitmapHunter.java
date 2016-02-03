package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

abstract class BitmapHunter
  implements Runnable
{
  private static final Object DECODE_LOCK = new Object();
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal()
  {
    protected StringBuilder initialValue()
    {
      return new StringBuilder("Picasso-");
    }
  };
  Action action;
  List<Action> actions;
  final Cache cache;
  final Request data;
  final Dispatcher dispatcher;
  Exception exception;
  int exifRotation;
  Future<?> future;
  final String key;
  Picasso.LoadedFrom loadedFrom;
  final Picasso picasso;
  Bitmap result;
  final boolean skipMemoryCache;
  final Stats stats;
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    this.picasso = paramPicasso;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.stats = paramStats;
    this.key = paramAction.getKey();
    this.data = paramAction.getRequest();
    this.skipMemoryCache = paramAction.skipCache;
    this.action = paramAction;
  }
  
  static Bitmap applyCustomTransformations(List<Transformation> paramList, Bitmap paramBitmap)
  {
    int i = 0;
    int j = paramList.size();
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      Transformation localTransformation;
      if (i < j)
      {
        localTransformation = (Transformation)paramList.get(i);
        localBitmap = localTransformation.transform(paramBitmap);
        if (localBitmap == null)
        {
          paramBitmap = new StringBuilder().append("Transformation ").append(localTransformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            paramBitmap.append(((Transformation)paramList.next()).key()).append('\n');
          }
          Picasso.HANDLER.post(new Runnable()
          {
            public void run()
            {
              throw new NullPointerException(this.val$builder.toString());
            }
          });
          localBitmap = null;
        }
      }
      else
      {
        return localBitmap;
      }
      if ((localBitmap == paramBitmap) && (paramBitmap.isRecycled()))
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new IllegalStateException("Transformation " + this.val$transformation.key() + " returned input Bitmap but recycled it.");
          }
        });
        return null;
      }
      if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new IllegalStateException("Transformation " + this.val$transformation.key() + " mutated input Bitmap but failed to recycle the original.");
          }
        });
        return null;
      }
      paramBitmap = localBitmap;
      i += 1;
    }
  }
  
  static void calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    if ((paramInt4 > paramInt2) || (paramInt3 > paramInt1))
    {
      i = (int)Math.floor(paramInt4 / paramInt2);
      paramInt1 = (int)Math.floor(paramInt3 / paramInt1);
      if (i >= paramInt1) {
        break label56;
      }
    }
    for (;;)
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      return;
      label56:
      i = paramInt1;
    }
  }
  
  static void calculateInSampleSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    calculateInSampleSize(paramInt1, paramInt2, paramOptions.outWidth, paramOptions.outHeight, paramOptions);
  }
  
  static BitmapFactory.Options createBitmapOptions(Request paramRequest)
  {
    boolean bool = paramRequest.hasSize();
    if (paramRequest.config != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = null;
      if ((bool) || (i != 0))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = bool;
        localObject = localOptions;
        if (i != 0)
        {
          localOptions.inPreferredConfig = paramRequest.config;
          localObject = localOptions;
        }
      }
      return (BitmapFactory.Options)localObject;
    }
  }
  
  static BitmapHunter forRequest(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, Downloader paramDownloader)
  {
    if (paramAction.getRequest().resourceId != 0) {
      return new ResourceBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    Uri localUri = paramAction.getRequest().uri;
    String str = localUri.getScheme();
    if ("content".equals(str))
    {
      if ((ContactsContract.Contacts.CONTENT_URI.getHost().equals(localUri.getHost())) && (!localUri.getPathSegments().contains("photo"))) {
        return new ContactsPhotoBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      }
      if ("media".equals(localUri.getAuthority())) {
        return new MediaStoreBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      }
      return new ContentStreamBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    if ("file".equals(str))
    {
      if ((!localUri.getPathSegments().isEmpty()) && ("android_asset".equals(localUri.getPathSegments().get(0)))) {
        return new AssetBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      }
      return new FileBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    if ("android.resource".equals(str)) {
      return new ResourceBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    return new NetworkBitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, paramDownloader);
  }
  
  static boolean requiresInSampleSize(BitmapFactory.Options paramOptions)
  {
    return (paramOptions != null) && (paramOptions.inJustDecodeBounds);
  }
  
  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt)
  {
    int i4 = paramBitmap.getWidth();
    int i5 = paramBitmap.getHeight();
    int i6 = 0;
    int i2 = 0;
    int i7 = 0;
    int i3 = 0;
    int j = i4;
    int i = i5;
    Object localObject = new Matrix();
    int i1 = i6;
    int k = i7;
    int m = j;
    int n = i;
    int i8;
    int i9;
    float f1;
    float f2;
    float f3;
    if (paramRequest.needsMatrixTransform())
    {
      i8 = paramRequest.targetWidth;
      i9 = paramRequest.targetHeight;
      f1 = paramRequest.rotationDegrees;
      if (f1 != 0.0F)
      {
        if (!paramRequest.hasRotationPivot) {
          break label239;
        }
        ((Matrix)localObject).setRotate(f1, paramRequest.rotationPivotX, paramRequest.rotationPivotY);
      }
      if (!paramRequest.centerCrop) {
        break label283;
      }
      f2 = i8 / i4;
      f3 = i9 / i5;
      if (f2 <= f3) {
        break label248;
      }
      f1 = f2;
      i = (int)Math.ceil(i5 * (f3 / f2));
      k = (i5 - i) / 2;
      m = j;
      j = i2;
      label177:
      ((Matrix)localObject).preScale(f1, f1);
      n = i;
      i1 = j;
    }
    for (;;)
    {
      if (paramInt != 0) {
        ((Matrix)localObject).preRotate(paramInt);
      }
      localObject = Bitmap.createBitmap(paramBitmap, i1, k, m, n, (Matrix)localObject, true);
      paramRequest = paramBitmap;
      if (localObject != paramBitmap)
      {
        paramBitmap.recycle();
        paramRequest = (Request)localObject;
      }
      return paramRequest;
      label239:
      ((Matrix)localObject).setRotate(f1);
      break;
      label248:
      f1 = f3;
      m = (int)Math.ceil(i4 * (f2 / f3));
      j = (i4 - m) / 2;
      k = i3;
      break label177;
      label283:
      if (paramRequest.centerInside)
      {
        f1 = i8 / i4;
        f2 = i9 / i5;
        if (f1 < f2) {}
        for (;;)
        {
          ((Matrix)localObject).preScale(f1, f1);
          i1 = i6;
          k = i7;
          m = j;
          n = i;
          break;
          f1 = f2;
        }
      }
      i1 = i6;
      k = i7;
      m = j;
      n = i;
      if (i8 != 0)
      {
        i1 = i6;
        k = i7;
        m = j;
        n = i;
        if (i9 != 0) {
          if (i8 == i4)
          {
            i1 = i6;
            k = i7;
            m = j;
            n = i;
            if (i9 == i5) {}
          }
          else
          {
            ((Matrix)localObject).preScale(i8 / i4, i9 / i5);
            i1 = i6;
            k = i7;
            m = j;
            n = i;
          }
        }
      }
    }
  }
  
  static void updateThreadName(Request paramRequest)
  {
    paramRequest = paramRequest.getName();
    StringBuilder localStringBuilder = (StringBuilder)NAME_BUILDER.get();
    localStringBuilder.ensureCapacity("Picasso-".length() + paramRequest.length());
    localStringBuilder.replace("Picasso-".length(), localStringBuilder.length(), paramRequest);
    Thread.currentThread().setName(localStringBuilder.toString());
  }
  
  void attach(Action paramAction)
  {
    boolean bool = this.picasso.loggingEnabled;
    Request localRequest = paramAction.request;
    if (this.action == null)
    {
      this.action = paramAction;
      if (bool)
      {
        if ((this.actions != null) && (!this.actions.isEmpty())) {
          break label65;
        }
        Utils.log("Hunter", "joined", localRequest.logId(), "to empty hunter");
      }
    }
    label65:
    do
    {
      return;
      Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
      return;
      if (this.actions == null) {
        this.actions = new ArrayList(3);
      }
      this.actions.add(paramAction);
    } while (!bool);
    Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
  }
  
  boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.action == null) {
      if (this.actions != null)
      {
        bool1 = bool2;
        if (!this.actions.isEmpty()) {}
      }
      else
      {
        bool1 = bool2;
        if (this.future != null)
        {
          bool1 = bool2;
          if (this.future.cancel(false)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  abstract Bitmap decode(Request paramRequest)
    throws IOException;
  
  void detach(Action paramAction)
  {
    if (this.action == paramAction) {
      this.action = null;
    }
    for (;;)
    {
      if (this.picasso.loggingEnabled) {
        Utils.log("Hunter", "removed", paramAction.request.logId(), Utils.getLogIdsForHunter(this, "from "));
      }
      return;
      if (this.actions != null) {
        this.actions.remove(paramAction);
      }
    }
  }
  
  Action getAction()
  {
    return this.action;
  }
  
  List<Action> getActions()
  {
    return this.actions;
  }
  
  Request getData()
  {
    return this.data;
  }
  
  Exception getException()
  {
    return this.exception;
  }
  
  String getKey()
  {
    return this.key;
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return this.loadedFrom;
  }
  
  Picasso getPicasso()
  {
    return this.picasso;
  }
  
  Bitmap getResult()
  {
    return this.result;
  }
  
  Bitmap hunt()
    throws IOException
  {
    if (!this.skipMemoryCache)
    {
      localObject1 = this.cache.get(this.key);
      if (localObject1 != null)
      {
        this.stats.dispatchCacheHit();
        this.loadedFrom = Picasso.LoadedFrom.MEMORY;
        if (this.picasso.loggingEnabled) {
          Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
        }
        return (Bitmap)localObject1;
      }
    }
    Object localObject3 = decode(this.data);
    Object localObject1 = localObject3;
    if (localObject3 != null)
    {
      if (this.picasso.loggingEnabled) {
        Utils.log("Hunter", "decoded", this.data.logId());
      }
      this.stats.dispatchBitmapDecoded((Bitmap)localObject3);
      if (!this.data.needsTransformation())
      {
        localObject1 = localObject3;
        if (this.exifRotation == 0) {
          break label281;
        }
      }
    }
    synchronized (DECODE_LOCK)
    {
      if (!this.data.needsMatrixTransform())
      {
        localObject1 = localObject3;
        if (this.exifRotation == 0) {}
      }
      else
      {
        localObject3 = transformResult(this.data, (Bitmap)localObject3, this.exifRotation);
        localObject1 = localObject3;
        if (this.picasso.loggingEnabled)
        {
          Utils.log("Hunter", "transformed", this.data.logId());
          localObject1 = localObject3;
        }
      }
      localObject3 = localObject1;
      if (this.data.hasCustomTransformations())
      {
        localObject1 = applyCustomTransformations(this.data.transformations, (Bitmap)localObject1);
        localObject3 = localObject1;
        if (this.picasso.loggingEnabled)
        {
          Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
          localObject3 = localObject1;
        }
      }
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        this.stats.dispatchBitmapTransformed((Bitmap)localObject3);
        localObject1 = localObject3;
      }
      label281:
      return (Bitmap)localObject1;
    }
  }
  
  boolean isCancelled()
  {
    return (this.future != null) && (this.future.isCancelled());
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/squareup/picasso/BitmapHunter:data	Lcom/squareup/picasso/Request;
    //   4: invokestatic 530	com/squareup/picasso/BitmapHunter:updateThreadName	(Lcom/squareup/picasso/Request;)V
    //   7: aload_0
    //   8: getfield 63	com/squareup/picasso/BitmapHunter:picasso	Lcom/squareup/picasso/Picasso;
    //   11: getfield 394	com/squareup/picasso/Picasso:loggingEnabled	Z
    //   14: ifeq +16 -> 30
    //   17: ldc_w 401
    //   20: ldc_w 532
    //   23: aload_0
    //   24: invokestatic 535	com/squareup/picasso/Utils:getLogIdsForHunter	(Lcom/squareup/picasso/BitmapHunter;)Ljava/lang/String;
    //   27: invokestatic 491	com/squareup/picasso/Utils:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 537	com/squareup/picasso/BitmapHunter:hunt	()Landroid/graphics/Bitmap;
    //   35: putfield 466	com/squareup/picasso/BitmapHunter:result	Landroid/graphics/Bitmap;
    //   38: aload_0
    //   39: getfield 466	com/squareup/picasso/BitmapHunter:result	Landroid/graphics/Bitmap;
    //   42: ifnonnull +21 -> 63
    //   45: aload_0
    //   46: getfield 65	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   49: aload_0
    //   50: invokevirtual 543	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   53: invokestatic 382	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: ldc_w 545
    //   59: invokevirtual 389	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   62: return
    //   63: aload_0
    //   64: getfield 65	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   67: aload_0
    //   68: invokevirtual 548	com/squareup/picasso/Dispatcher:dispatchComplete	(Lcom/squareup/picasso/BitmapHunter;)V
    //   71: goto -18 -> 53
    //   74: astore_1
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 456	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   80: aload_0
    //   81: getfield 65	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   84: aload_0
    //   85: invokevirtual 543	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   88: invokestatic 382	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   91: ldc_w 545
    //   94: invokevirtual 389	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: aload_1
    //   101: putfield 456	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   104: aload_0
    //   105: getfield 65	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   108: aload_0
    //   109: invokevirtual 551	com/squareup/picasso/Dispatcher:dispatchRetry	(Lcom/squareup/picasso/BitmapHunter;)V
    //   112: invokestatic 382	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   115: ldc_w 545
    //   118: invokevirtual 389	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   121: return
    //   122: astore_1
    //   123: new 553	java/io/StringWriter
    //   126: dup
    //   127: invokespecial 554	java/io/StringWriter:<init>	()V
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 69	com/squareup/picasso/BitmapHunter:stats	Lcom/squareup/picasso/Stats;
    //   135: invokevirtual 558	com/squareup/picasso/Stats:createSnapshot	()Lcom/squareup/picasso/StatsSnapshot;
    //   138: new 560	java/io/PrintWriter
    //   141: dup
    //   142: aload_2
    //   143: invokespecial 563	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   146: invokevirtual 569	com/squareup/picasso/StatsSnapshot:dump	(Ljava/io/PrintWriter;)V
    //   149: aload_0
    //   150: new 571	java/lang/RuntimeException
    //   153: dup
    //   154: aload_2
    //   155: invokevirtual 572	java/io/StringWriter:toString	()Ljava/lang/String;
    //   158: aload_1
    //   159: invokespecial 575	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: putfield 456	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   165: aload_0
    //   166: getfield 65	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   169: aload_0
    //   170: invokevirtual 543	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   173: invokestatic 382	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   176: ldc_w 545
    //   179: invokevirtual 389	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   182: return
    //   183: astore_1
    //   184: aload_0
    //   185: aload_1
    //   186: putfield 456	com/squareup/picasso/BitmapHunter:exception	Ljava/lang/Exception;
    //   189: aload_0
    //   190: getfield 65	com/squareup/picasso/BitmapHunter:dispatcher	Lcom/squareup/picasso/Dispatcher;
    //   193: aload_0
    //   194: invokevirtual 543	com/squareup/picasso/Dispatcher:dispatchFailed	(Lcom/squareup/picasso/BitmapHunter;)V
    //   197: invokestatic 382	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   200: ldc_w 545
    //   203: invokevirtual 389	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   206: return
    //   207: astore_1
    //   208: invokestatic 382	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   211: ldc_w 545
    //   214: invokevirtual 389	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   217: aload_1
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	BitmapHunter
    //   74	3	1	localResponseException	Downloader.ResponseException
    //   98	3	1	localIOException	IOException
    //   122	37	1	localOutOfMemoryError	OutOfMemoryError
    //   183	3	1	localException	Exception
    //   207	11	1	localObject	Object
    //   130	25	2	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   0	30	74	com/squareup/picasso/Downloader$ResponseException
    //   30	53	74	com/squareup/picasso/Downloader$ResponseException
    //   63	71	74	com/squareup/picasso/Downloader$ResponseException
    //   0	30	98	java/io/IOException
    //   30	53	98	java/io/IOException
    //   63	71	98	java/io/IOException
    //   0	30	122	java/lang/OutOfMemoryError
    //   30	53	122	java/lang/OutOfMemoryError
    //   63	71	122	java/lang/OutOfMemoryError
    //   0	30	183	java/lang/Exception
    //   30	53	183	java/lang/Exception
    //   63	71	183	java/lang/Exception
    //   0	30	207	finally
    //   30	53	207	finally
    //   63	71	207	finally
    //   75	88	207	finally
    //   99	112	207	finally
    //   123	173	207	finally
    //   184	197	207	finally
  }
  
  protected void setExifRotation(int paramInt)
  {
    this.exifRotation = paramInt;
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    return false;
  }
  
  boolean shouldSkipMemoryCache()
  {
    return this.skipMemoryCache;
  }
  
  boolean supportsReplay()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/BitmapHunter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */