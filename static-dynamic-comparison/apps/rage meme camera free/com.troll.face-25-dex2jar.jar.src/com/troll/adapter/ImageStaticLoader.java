package com.troll.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageStaticLoader
{
  FileCache fileCache;
  private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
  MemoryCache memoryCache = new MemoryCache();
  PhotosLoader photoLoaderThread = new PhotosLoader();
  PhotosQueue photosQueue = new PhotosQueue();
  ExecutorService service = Executors.newFixedThreadPool(5);
  final int stub_id = 2130837719;
  
  public ImageStaticLoader(Context paramContext)
  {
    this.photoLoaderThread.setPriority(4);
    this.fileCache = new FileCache(paramContext);
  }
  
  private Bitmap decodeFile(File paramFile)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(new FileInputStream(paramFile), null, localOptions);
      int k = localOptions.outWidth;
      int j = localOptions.outHeight;
      int i = 1;
      for (;;)
      {
        if ((k / 2 < 70) || (j / 2 < 70))
        {
          localOptions = new BitmapFactory.Options();
          localOptions.inSampleSize = i;
          return BitmapFactory.decodeStream(new FileInputStream(paramFile), null, localOptions);
        }
        k /= 2;
        j /= 2;
        i *= 2;
      }
      return null;
    }
    catch (FileNotFoundException paramFile) {}
  }
  
  private Bitmap getBitmap(String paramString)
  {
    File localFile = this.fileCache.getFile(paramString);
    Object localObject = decodeFile(localFile);
    if (localObject != null) {
      return (Bitmap)localObject;
    }
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(30000);
      paramString.setReadTimeout(30000);
      paramString = paramString.getInputStream();
      localObject = new FileOutputStream(localFile);
      Utils.CopyStream(paramString, (OutputStream)localObject);
      ((OutputStream)localObject).close();
      paramString = decodeFile(localFile);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void queuePhoto(String arg1, Activity paramActivity, ImageView paramImageView)
  {
    this.photosQueue.Clean(paramImageView);
    paramActivity = new PhotoToLoad(???, paramImageView);
    synchronized (this.photosQueue.photosToLoad)
    {
      this.photosQueue.photosToLoad.push(paramActivity);
      this.photosQueue.photosToLoad.notifyAll();
      if (this.photoLoaderThread.getState() == Thread.State.NEW) {
        this.service.execute(this.photoLoaderThread);
      }
      return;
    }
  }
  
  public void DisplayImage(Integer paramInteger, Activity paramActivity, ImageView paramImageView)
  {
    this.imageViews.put(paramImageView, null);
    paramImageView.setImageResource(paramInteger.intValue());
  }
  
  public void clearCache()
  {
    this.memoryCache.clear();
    this.fileCache.clear();
  }
  
  public void stopThread()
  {
    this.photoLoaderThread.interrupt();
  }
  
  class BitmapDisplayer
    implements Runnable
  {
    Bitmap bitmap;
    ImageView imageView;
    
    public BitmapDisplayer(Bitmap paramBitmap, ImageView paramImageView)
    {
      this.bitmap = paramBitmap;
      this.imageView = paramImageView;
    }
    
    public void run()
    {
      if (this.bitmap != null)
      {
        this.imageView.setImageBitmap(this.bitmap);
        return;
      }
      this.imageView.setImageResource(2130837719);
    }
  }
  
  private class PhotoToLoad
  {
    public ImageView imageView;
    public String url;
    
    public PhotoToLoad(String paramString, ImageView paramImageView)
    {
      this.url = paramString;
      this.imageView = paramImageView;
    }
  }
  
  class PhotosLoader
    extends Thread
  {
    PhotosLoader() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   4: getfield 24	com/troll/adapter/ImageStaticLoader:photosQueue	Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;
      //   7: invokestatic 30	com/troll/adapter/ImageStaticLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;)Ljava/util/Stack;
      //   10: invokevirtual 36	java/util/Stack:size	()I
      //   13: ifne +31 -> 44
      //   16: aload_0
      //   17: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   20: getfield 24	com/troll/adapter/ImageStaticLoader:photosQueue	Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;
      //   23: invokestatic 30	com/troll/adapter/ImageStaticLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;)Ljava/util/Stack;
      //   26: astore_2
      //   27: aload_2
      //   28: monitorenter
      //   29: aload_0
      //   30: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   33: getfield 24	com/troll/adapter/ImageStaticLoader:photosQueue	Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;
      //   36: invokestatic 30	com/troll/adapter/ImageStaticLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;)Ljava/util/Stack;
      //   39: invokevirtual 41	java/lang/Object:wait	()V
      //   42: aload_2
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   48: getfield 24	com/troll/adapter/ImageStaticLoader:photosQueue	Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;
      //   51: invokestatic 30	com/troll/adapter/ImageStaticLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;)Ljava/util/Stack;
      //   54: invokevirtual 36	java/util/Stack:size	()I
      //   57: ifeq +131 -> 188
      //   60: aload_0
      //   61: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   64: getfield 24	com/troll/adapter/ImageStaticLoader:photosQueue	Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;
      //   67: invokestatic 30	com/troll/adapter/ImageStaticLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;)Ljava/util/Stack;
      //   70: astore_3
      //   71: aload_3
      //   72: monitorenter
      //   73: aload_0
      //   74: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   77: getfield 24	com/troll/adapter/ImageStaticLoader:photosQueue	Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;
      //   80: invokestatic 30	com/troll/adapter/ImageStaticLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageStaticLoader$PhotosQueue;)Ljava/util/Stack;
      //   83: invokevirtual 45	java/util/Stack:pop	()Ljava/lang/Object;
      //   86: checkcast 47	com/troll/adapter/ImageStaticLoader$PhotoToLoad
      //   89: astore_2
      //   90: aload_3
      //   91: monitorexit
      //   92: aload_0
      //   93: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   96: aload_2
      //   97: getfield 51	com/troll/adapter/ImageStaticLoader$PhotoToLoad:url	Ljava/lang/String;
      //   100: invokestatic 54	com/troll/adapter/ImageStaticLoader:access$0	(Lcom/troll/adapter/ImageStaticLoader;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   103: astore_3
      //   104: aload_0
      //   105: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   108: getfield 58	com/troll/adapter/ImageStaticLoader:memoryCache	Lcom/troll/adapter/MemoryCache;
      //   111: aload_2
      //   112: getfield 51	com/troll/adapter/ImageStaticLoader$PhotoToLoad:url	Ljava/lang/String;
      //   115: aload_3
      //   116: invokevirtual 64	com/troll/adapter/MemoryCache:put	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
      //   119: aload_0
      //   120: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   123: invokestatic 68	com/troll/adapter/ImageStaticLoader:access$1	(Lcom/troll/adapter/ImageStaticLoader;)Ljava/util/Map;
      //   126: aload_2
      //   127: getfield 72	com/troll/adapter/ImageStaticLoader$PhotoToLoad:imageView	Landroid/widget/ImageView;
      //   130: invokeinterface 78 2 0
      //   135: checkcast 80	java/lang/String
      //   138: astore 4
      //   140: aload 4
      //   142: ifnull +46 -> 188
      //   145: aload 4
      //   147: aload_2
      //   148: getfield 51	com/troll/adapter/ImageStaticLoader$PhotoToLoad:url	Ljava/lang/String;
      //   151: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   154: ifeq +34 -> 188
      //   157: new 86	com/troll/adapter/ImageStaticLoader$BitmapDisplayer
      //   160: dup
      //   161: aload_0
      //   162: getfield 13	com/troll/adapter/ImageStaticLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageStaticLoader;
      //   165: aload_3
      //   166: aload_2
      //   167: getfield 72	com/troll/adapter/ImageStaticLoader$PhotoToLoad:imageView	Landroid/widget/ImageView;
      //   170: invokespecial 89	com/troll/adapter/ImageStaticLoader$BitmapDisplayer:<init>	(Lcom/troll/adapter/ImageStaticLoader;Landroid/graphics/Bitmap;Landroid/widget/ImageView;)V
      //   173: astore_3
      //   174: aload_2
      //   175: getfield 72	com/troll/adapter/ImageStaticLoader$PhotoToLoad:imageView	Landroid/widget/ImageView;
      //   178: invokevirtual 95	android/widget/ImageView:getContext	()Landroid/content/Context;
      //   181: checkcast 97	android/app/Activity
      //   184: aload_3
      //   185: invokevirtual 101	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   188: invokestatic 105	java/lang/Thread:interrupted	()Z
      //   191: istore_1
      //   192: iload_1
      //   193: ifeq -193 -> 0
      //   196: return
      //   197: astore_3
      //   198: aload_2
      //   199: monitorexit
      //   200: aload_3
      //   201: athrow
      //   202: astore_2
      //   203: return
      //   204: astore_2
      //   205: aload_3
      //   206: monitorexit
      //   207: aload_2
      //   208: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	209	0	this	PhotosLoader
      //   191	2	1	bool	boolean
      //   202	1	2	localInterruptedException	InterruptedException
      //   204	4	2	localObject2	Object
      //   197	9	3	localObject4	Object
      //   138	8	4	str	String
      // Exception table:
      //   from	to	target	type
      //   29	44	197	finally
      //   198	200	197	finally
      //   0	29	202	java/lang/InterruptedException
      //   44	73	202	java/lang/InterruptedException
      //   92	140	202	java/lang/InterruptedException
      //   145	188	202	java/lang/InterruptedException
      //   188	192	202	java/lang/InterruptedException
      //   200	202	202	java/lang/InterruptedException
      //   207	209	202	java/lang/InterruptedException
      //   73	92	204	finally
      //   205	207	204	finally
    }
  }
  
  class PhotosQueue
  {
    private Stack<ImageStaticLoader.PhotoToLoad> photosToLoad = new Stack();
    
    PhotosQueue() {}
    
    public void Clean(ImageView paramImageView)
    {
      int i = 0;
      for (;;)
      {
        if (i >= this.photosToLoad.size()) {
          return;
        }
        if (((ImageStaticLoader.PhotoToLoad)this.photosToLoad.get(i)).imageView == paramImageView) {
          this.photosToLoad.remove(i);
        } else {
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/adapter/ImageStaticLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */