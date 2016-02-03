package com.magmamobile.mmusia.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.magmamobile.mmusia.MCommon;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ImageLoader
{
  private static ImageLoader _instance;
  private boolean _busy = false;
  private Bitmap _missing;
  private Queue<Group> _queue = new LinkedList();
  private DownloadThread _thread;
  private HashMap<String, Bitmap> _urlToBitmap = new HashMap();
  
  public static ImageLoader getInstance()
  {
    if (_instance == null) {
      _instance = new ImageLoader();
    }
    return _instance;
  }
  
  private void loadNext()
  {
    Iterator localIterator = this._queue.iterator();
    Group localGroup;
    if ((!this._busy) && (localIterator.hasNext()))
    {
      this._busy = true;
      localGroup = (Group)localIterator.next();
      localIterator.remove();
      if (this._urlToBitmap.get(localGroup.url) == null) {
        break label143;
      }
      if (localGroup.image != null)
      {
        if (!MCommon.isSDKAPI4Mini()) {
          break label112;
        }
        ImageSetterSDK4.setImage(new BitmapDrawable((Bitmap)this._urlToBitmap.get(localGroup.url)), localGroup.image);
      }
    }
    for (;;)
    {
      this._busy = false;
      loadNext();
      return;
      label112:
      ImageSetterSDK3.setImage(new BitmapDrawable((Bitmap)this._urlToBitmap.get(localGroup.url)), localGroup.image);
    }
    label143:
    this._thread = new DownloadThread(localGroup);
    this._thread.start();
  }
  
  private void onLoad()
  {
    Group localGroup;
    if (this._thread != null)
    {
      localGroup = this._thread.group;
      if (localGroup.bitmap == null) {
        break label112;
      }
      if (localGroup.cache) {
        this._urlToBitmap.put(localGroup.url, localGroup.bitmap);
      }
      if (localGroup.image != null)
      {
        if (!MCommon.isSDKAPI4Mini()) {
          break label91;
        }
        ImageSetterSDK4.setImage(new BitmapDrawable(localGroup.bitmap), localGroup.image);
      }
    }
    for (;;)
    {
      this._thread = null;
      this._busy = false;
      loadNext();
      return;
      label91:
      ImageSetterSDK3.setImage(new BitmapDrawable(localGroup.bitmap), localGroup.image);
      continue;
      label112:
      if ((this._missing != null) && (localGroup.image != null)) {
        if (MCommon.isSDKAPI4Mini()) {
          ImageSetterSDK4.setImage(new BitmapDrawable(this._missing), localGroup.image);
        } else {
          ImageSetterSDK3.setImage(new BitmapDrawable(this._missing), localGroup.image);
        }
      }
    }
  }
  
  public void cancel()
  {
    clearQueue();
    if (this._thread != null)
    {
      this._thread.disconnect();
      this._thread = null;
    }
  }
  
  public void clearCache()
  {
    this._urlToBitmap = new HashMap();
  }
  
  public void clearQueue()
  {
    this._queue = new LinkedList();
  }
  
  public Bitmap get(String paramString)
  {
    return (Bitmap)this._urlToBitmap.get(paramString);
  }
  
  public void load(ImageView paramImageView, String paramString)
  {
    load(paramImageView, paramString, false);
  }
  
  public void load(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    if (this._urlToBitmap.get(paramString) != null)
    {
      if (paramImageView != null)
      {
        if (MCommon.isSDKAPI4Mini()) {
          ImageSetterSDK4.setImage(new BitmapDrawable((Bitmap)this._urlToBitmap.get(paramString)), paramImageView);
        }
      }
      else {
        return;
      }
      ImageSetterSDK3.setImage(new BitmapDrawable((Bitmap)this._urlToBitmap.get(paramString)), paramImageView);
      return;
    }
    queue(paramImageView, paramString, paramBoolean);
  }
  
  public void queue(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this._queue.iterator();
    if (paramImageView != null) {
      if (!localIterator.hasNext()) {
        label24:
        break label86;
      }
    }
    for (;;)
    {
      this._queue.add(new Group(paramImageView, paramString, null, paramBoolean));
      loadNext();
      return;
      if (!((Group)localIterator.next()).image.equals(paramImageView)) {
        break;
      }
      localIterator.remove();
      continue;
      if (paramString != null) {
        label86:
        if (localIterator.hasNext())
        {
          if (!((Group)localIterator.next()).url.equals(paramString)) {
            break label24;
          }
          localIterator.remove();
        }
      }
    }
  }
  
  public void setMissingBitmap(Bitmap paramBitmap)
  {
    this._missing = paramBitmap;
  }
  
  private class DownloadThread
    extends Thread
  {
    private HttpURLConnection _conn;
    public ImageLoader.Group group;
    final Runnable threadCallback = new Runnable()
    {
      public void run()
      {
        ImageLoader.this.onLoad();
      }
    };
    final Handler threadHandler = new Handler();
    
    public DownloadThread(ImageLoader.Group paramGroup)
    {
      this.group = paramGroup;
    }
    
    public void disconnect()
    {
      if (this._conn != null) {
        this._conn.disconnect();
      }
    }
    
    public void run()
    {
      InputStream localInputStream2 = null;
      this._conn = null;
      InputStream localInputStream1 = localInputStream2;
      try
      {
        this._conn = ((HttpURLConnection)new URL(this.group.url).openConnection());
        localInputStream1 = localInputStream2;
        this._conn.setDoInput(true);
        localInputStream1 = localInputStream2;
        this._conn.connect();
        localInputStream1 = localInputStream2;
        localInputStream2 = this._conn.getInputStream();
        localInputStream1 = localInputStream2;
        this.group.bitmap = BitmapFactory.decodeStream(localInputStream2);
        localInputStream1 = localInputStream2;
        localInputStream2.close();
        localInputStream1 = localInputStream2;
        this._conn.disconnect();
        localInputStream1 = null;
        localInputStream2 = null;
        this._conn = null;
        localInputStream1 = localInputStream2;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      if (localInputStream1 != null) {}
      try
      {
        localInputStream1.close();
        disconnect();
        this._conn = null;
        this.threadHandler.post(this.threadCallback);
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
  }
  
  private class Group
  {
    public Bitmap bitmap;
    public boolean cache;
    public ImageView image;
    public String url;
    
    public Group(ImageView paramImageView, String paramString, Bitmap paramBitmap, boolean paramBoolean)
    {
      this.image = paramImageView;
      this.url = paramString;
      this.bitmap = paramBitmap;
      this.cache = paramBoolean;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/image/ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */