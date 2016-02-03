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

public class ImageLoader
{
  FileCache fileCache;
  private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
  MemoryCache memoryCache = new MemoryCache();
  PhotosLoader photoLoaderThread = new PhotosLoader();
  PhotosQueue photosQueue = new PhotosQueue();
  ExecutorService service = Executors.newFixedThreadPool(5);
  final int stub_id = 2130837719;
  
  public ImageLoader(Context paramContext)
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
  
  public void DisplayImage(String paramString, Activity paramActivity, ImageView paramImageView)
  {
    this.imageViews.put(paramImageView, paramString);
    Bitmap localBitmap = this.memoryCache.get(paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    queuePhoto(paramString, paramActivity, paramImageView);
    paramImageView.setImageResource(2130837719);
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
      //   1: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   4: getfield 26	com/troll/adapter/ImageLoader:photosQueue	Lcom/troll/adapter/ImageLoader$PhotosQueue;
      //   7: invokestatic 32	com/troll/adapter/ImageLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageLoader$PhotosQueue;)Ljava/util/Stack;
      //   10: invokevirtual 38	java/util/Stack:size	()I
      //   13: ifne +31 -> 44
      //   16: aload_0
      //   17: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   20: getfield 26	com/troll/adapter/ImageLoader:photosQueue	Lcom/troll/adapter/ImageLoader$PhotosQueue;
      //   23: invokestatic 32	com/troll/adapter/ImageLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageLoader$PhotosQueue;)Ljava/util/Stack;
      //   26: astore_3
      //   27: aload_3
      //   28: monitorenter
      //   29: aload_0
      //   30: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   33: getfield 26	com/troll/adapter/ImageLoader:photosQueue	Lcom/troll/adapter/ImageLoader$PhotosQueue;
      //   36: invokestatic 32	com/troll/adapter/ImageLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageLoader$PhotosQueue;)Ljava/util/Stack;
      //   39: invokevirtual 43	java/lang/Object:wait	()V
      //   42: aload_3
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   48: getfield 26	com/troll/adapter/ImageLoader:photosQueue	Lcom/troll/adapter/ImageLoader$PhotosQueue;
      //   51: invokestatic 32	com/troll/adapter/ImageLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageLoader$PhotosQueue;)Ljava/util/Stack;
      //   54: invokevirtual 38	java/util/Stack:size	()I
      //   57: istore_1
      //   58: iload_1
      //   59: ifeq +143 -> 202
      //   62: aload_0
      //   63: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   66: getfield 26	com/troll/adapter/ImageLoader:photosQueue	Lcom/troll/adapter/ImageLoader$PhotosQueue;
      //   69: invokestatic 32	com/troll/adapter/ImageLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageLoader$PhotosQueue;)Ljava/util/Stack;
      //   72: astore 4
      //   74: aload 4
      //   76: monitorenter
      //   77: aload_0
      //   78: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   81: getfield 26	com/troll/adapter/ImageLoader:photosQueue	Lcom/troll/adapter/ImageLoader$PhotosQueue;
      //   84: invokestatic 32	com/troll/adapter/ImageLoader$PhotosQueue:access$0	(Lcom/troll/adapter/ImageLoader$PhotosQueue;)Ljava/util/Stack;
      //   87: invokevirtual 47	java/util/Stack:pop	()Ljava/lang/Object;
      //   90: checkcast 49	com/troll/adapter/ImageLoader$PhotoToLoad
      //   93: astore_3
      //   94: aload 4
      //   96: monitorexit
      //   97: aload_3
      //   98: ifnull +104 -> 202
      //   101: aload_0
      //   102: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   105: aload_3
      //   106: getfield 53	com/troll/adapter/ImageLoader$PhotoToLoad:url	Ljava/lang/String;
      //   109: invokestatic 56	com/troll/adapter/ImageLoader:access$0	(Lcom/troll/adapter/ImageLoader;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   112: astore 4
      //   114: aload_0
      //   115: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   118: getfield 60	com/troll/adapter/ImageLoader:memoryCache	Lcom/troll/adapter/MemoryCache;
      //   121: aload_3
      //   122: getfield 53	com/troll/adapter/ImageLoader$PhotoToLoad:url	Ljava/lang/String;
      //   125: aload 4
      //   127: invokevirtual 66	com/troll/adapter/MemoryCache:put	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
      //   130: aload_0
      //   131: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   134: invokestatic 70	com/troll/adapter/ImageLoader:access$1	(Lcom/troll/adapter/ImageLoader;)Ljava/util/Map;
      //   137: aload_3
      //   138: getfield 74	com/troll/adapter/ImageLoader$PhotoToLoad:imageView	Landroid/widget/ImageView;
      //   141: invokeinterface 80 2 0
      //   146: checkcast 82	java/lang/String
      //   149: astore 5
      //   151: aload 5
      //   153: ifnull +49 -> 202
      //   156: aload 5
      //   158: aload_3
      //   159: getfield 53	com/troll/adapter/ImageLoader$PhotoToLoad:url	Ljava/lang/String;
      //   162: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   165: ifeq +37 -> 202
      //   168: new 88	com/troll/adapter/ImageLoader$BitmapDisplayer
      //   171: dup
      //   172: aload_0
      //   173: getfield 13	com/troll/adapter/ImageLoader$PhotosLoader:this$0	Lcom/troll/adapter/ImageLoader;
      //   176: aload 4
      //   178: aload_3
      //   179: getfield 74	com/troll/adapter/ImageLoader$PhotoToLoad:imageView	Landroid/widget/ImageView;
      //   182: invokespecial 91	com/troll/adapter/ImageLoader$BitmapDisplayer:<init>	(Lcom/troll/adapter/ImageLoader;Landroid/graphics/Bitmap;Landroid/widget/ImageView;)V
      //   185: astore 4
      //   187: aload_3
      //   188: getfield 74	com/troll/adapter/ImageLoader$PhotoToLoad:imageView	Landroid/widget/ImageView;
      //   191: invokevirtual 97	android/widget/ImageView:getContext	()Landroid/content/Context;
      //   194: checkcast 99	android/app/Activity
      //   197: aload 4
      //   199: invokevirtual 103	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   202: invokestatic 107	java/lang/Thread:interrupted	()Z
      //   205: istore_2
      //   206: iload_2
      //   207: ifeq -207 -> 0
      //   210: return
      //   211: astore 4
      //   213: aload_3
      //   214: monitorexit
      //   215: aload 4
      //   217: athrow
      //   218: astore_3
      //   219: return
      //   220: astore_3
      //   221: aconst_null
      //   222: astore_3
      //   223: goto -129 -> 94
      //   226: astore_3
      //   227: aload 4
      //   229: monitorexit
      //   230: aload_3
      //   231: athrow
      //   232: astore_3
      //   233: goto -31 -> 202
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	236	0	this	PhotosLoader
      //   57	2	1	i	int
      //   205	2	2	bool	boolean
      //   26	188	3	localObject1	Object
      //   218	1	3	localInterruptedException	InterruptedException
      //   220	1	3	localException1	Exception
      //   222	1	3	localObject2	Object
      //   226	5	3	localObject3	Object
      //   232	1	3	localException2	Exception
      //   211	17	4	localObject5	Object
      //   149	8	5	str	String
      // Exception table:
      //   from	to	target	type
      //   29	44	211	finally
      //   213	215	211	finally
      //   0	29	218	java/lang/InterruptedException
      //   44	58	218	java/lang/InterruptedException
      //   62	77	218	java/lang/InterruptedException
      //   101	151	218	java/lang/InterruptedException
      //   156	202	218	java/lang/InterruptedException
      //   202	206	218	java/lang/InterruptedException
      //   215	218	218	java/lang/InterruptedException
      //   230	232	218	java/lang/InterruptedException
      //   77	94	220	java/lang/Exception
      //   77	94	226	finally
      //   94	97	226	finally
      //   227	230	226	finally
      //   62	77	232	java/lang/Exception
      //   101	151	232	java/lang/Exception
      //   156	202	232	java/lang/Exception
      //   230	232	232	java/lang/Exception
    }
  }
  
  class PhotosQueue
  {
    private Stack<ImageLoader.PhotoToLoad> photosToLoad = new Stack();
    
    PhotosQueue() {}
    
    public void Clean(ImageView paramImageView)
    {
      int i = 0;
      for (;;)
      {
        if (i >= this.photosToLoad.size()) {
          return;
        }
        if (((ImageLoader.PhotoToLoad)this.photosToLoad.get(i)).imageView == paramImageView) {
          this.photosToLoad.remove(i);
        } else {
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/adapter/ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */