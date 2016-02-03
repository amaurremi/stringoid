package com.venticake.retrica.view.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LazyImageView
  extends FrameLayout
{
  private int loadedImageHeight = 0;
  private int loadedImageWidth = 0;
  public LazyImageView.LoadingFinishListner loadingFinishListner = null;
  private Bitmap mBitmap = null;
  private float[] mCropRegion = { 0.0F, 0.0F, 1.0F, 1.0F };
  private Thread mImageLoadThread = null;
  private ProgressBar mImageProgressBar;
  private ImageView mImageView;
  private boolean mLoaded = false;
  private Handler mMainHandler = null;
  private String mURLString = null;
  public LazyImageView.URILoadingFinishListner uriLoadingFinishListner = null;
  
  public LazyImageView(Context paramContext)
  {
    super(paramContext);
    _initialize(paramContext);
  }
  
  public LazyImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    _initialize(paramContext);
  }
  
  public LazyImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    _initialize(paramContext);
  }
  
  private Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  private BitmapDrawable getProperBitmapDrawable(Bitmap paramBitmap, int paramInt)
  {
    int i4 = getWidth();
    int i3 = getHeight();
    int i;
    int j;
    int i1;
    int n;
    int k;
    label324:
    Object localObject;
    label335:
    int m;
    if (paramInt > 4)
    {
      i = paramBitmap.getHeight();
      j = paramBitmap.getWidth();
      setLoadedImageWidth(i);
      setLoadedImageHeight(j);
      Log.i("retrica", "orientation = " + Integer.toString(paramInt));
      Log.i("retrica", "original width = " + Integer.toString(i));
      Log.i("retrica", "original height = " + Integer.toString(j));
      Log.i("retrica", "bounding = " + Integer.toString(i4) + ", " + Integer.toString(i3));
      Log.i("retrica", "imageSize = " + i + ", " + j);
      i1 = 0;
      n = 0;
      if ((this.mCropRegion == null) || ((this.mCropRegion[0] <= 0.0F) && (this.mCropRegion[1] <= 0.0F) && (this.mCropRegion[2] >= 1.0F) && (this.mCropRegion[3] >= 1.0F))) {
        break label1133;
      }
      Log.i("retrica", "cropRegion: " + this.mCropRegion[0] + ", " + this.mCropRegion[1] + ", " + this.mCropRegion[2] + ", " + this.mCropRegion[3]);
      if (paramInt <= 4) {
        break label849;
      }
      k = 0;
      if (k != 0) {
        break label855;
      }
      localObject = this.mCropRegion;
      i1 = Math.round(localObject[0] * i);
      n = Math.round(localObject[1] * j);
      m = Math.round((localObject[2] - localObject[0]) * i);
      k = Math.round((localObject[3] - localObject[1]) * j);
    }
    for (;;)
    {
      Log.i("retrica", "cr: " + i1 + ", " + n + ", " + m + ", " + k);
      int i2 = i4;
      if (i4 == 0) {
        i2 = m;
      }
      if (i3 == 0) {
        i3 = k;
      }
      for (;;)
      {
        float f1 = i2 / m;
        float f2 = i3 / k;
        float f3 = Math.min(f1, f2);
        Log.i("retrica", "xScale = " + Float.toString(f1));
        Log.i("retrica", "yScale = " + Float.toString(f2));
        Log.i("retrica", "scale = " + Float.toString(f3));
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f3, f3);
        switch (paramInt)
        {
        case 1: 
        default: 
          label640:
          System.gc();
          if (paramInt <= 4) {
            break;
          }
        }
        for (;;)
        {
          try
          {
            Log.i("retrica", "hjh" + i1 + ", " + n + ", " + m + ", " + k);
            paramBitmap = Bitmap.createBitmap(paramBitmap, n, i1, k, m, (Matrix)localObject, true);
          }
          catch (Exception localException1)
          {
            label849:
            label855:
            k = i;
            paramBitmap = null;
            localException1.printStackTrace();
            Log.i("Retrica", "hjh reloaded LazyImageView");
            loadImage(this.mURLString);
            m = j;
            continue;
          }
          try
          {
            k = paramBitmap.getWidth();
          }
          catch (Exception localException2)
          {
            k = i;
            continue;
          }
          try
          {
            m = paramBitmap.getHeight();
            System.gc();
            paramBitmap = new BitmapDrawable(getResources(), paramBitmap);
            Log.i("retrica", "scaled : " + Integer.toString(i) + " x " + Integer.toString(j));
            Log.i("retrica", "scaled : output (ori: " + paramInt + ") " + Integer.toString(k) + " x " + Integer.toString(m));
            return paramBitmap;
          }
          catch (Exception localException3)
          {
            continue;
          }
          i = paramBitmap.getWidth();
          j = paramBitmap.getHeight();
          break;
          k = 1;
          break label324;
          localObject = new float[4];
          localObject[0] = this.mCropRegion[1];
          localObject[1] = this.mCropRegion[0];
          localObject[2] = this.mCropRegion[3];
          localObject[3] = this.mCropRegion[2];
          break label335;
          ((Matrix)localObject).postScale(-1.0F, 1.0F);
          break label640;
          ((Matrix)localObject).postRotate(180.0F);
          break label640;
          ((Matrix)localObject).postRotate(180.0F);
          ((Matrix)localObject).postScale(-1.0F, 1.0F);
          break label640;
          ((Matrix)localObject).postRotate(90.0F);
          ((Matrix)localObject).postScale(-1.0F, 1.0F);
          break label640;
          ((Matrix)localObject).postRotate(90.0F);
          break label640;
          ((Matrix)localObject).postRotate(-90.0F);
          ((Matrix)localObject).postScale(-1.0F, 1.0F);
          break label640;
          ((Matrix)localObject).postRotate(-90.0F);
          break label640;
          Log.i("retrica", "hjh" + i1 + ", " + n + ", " + m + ", " + k);
          paramBitmap = Bitmap.createBitmap(paramBitmap, i1, n, m, k, (Matrix)localObject, true);
        }
      }
      label1133:
      k = j;
      m = i;
    }
  }
  
  private BitmapDrawable getProperBitmapDrawable(Uri paramUri)
  {
    Object localObject3 = null;
    if (!new File(paramUri.getPath()).exists()) {}
    for (;;)
    {
      return null;
      try
      {
        Bitmap localBitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), paramUri);
        if (this.uriLoadingFinishListner != null) {
          this.uriLoadingFinishListner.onURILoadingFinish(localBitmap);
        }
        if (localBitmap == null) {
          continue;
        }
        try
        {
          ExifInterface localExifInterface = new ExifInterface(paramUri.getPath());
          localObject3 = localExifInterface;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            Object localObject1;
            Object localObject2;
            localIOException2.printStackTrace();
            continue;
            int i = 1;
          }
        }
        if (localObject3 != null)
        {
          i = ((ExifInterface)localObject3).getAttributeInt("Orientation", 1);
          Log.d("retrica", "filename: " + paramUri.getPath() + ", orientation: " + i);
          return getProperBitmapDrawable(localBitmap, i);
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          localObject1 = null;
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localIOException1.printStackTrace();
          localObject2 = null;
        }
      }
    }
  }
  
  public void _initialize(Context paramContext)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    this.mImageView = new ImageView(paramContext);
    addView(this.mImageView, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    this.mImageProgressBar = new ProgressBar(paramContext);
    this.mImageProgressBar.setIndeterminate(true);
    addView(this.mImageProgressBar, localLayoutParams);
  }
  
  public void cancelLoading()
  {
    if (this.mImageLoadThread == null) {
      return;
    }
    this.mImageLoadThread.interrupt();
  }
  
  public void deleteImage()
  {
    cancelLoading();
    Drawable localDrawable = this.mImageView.getDrawable();
    if ((localDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)localDrawable).getBitmap().recycle();
    }
    this.mImageView.setImageResource(17170445);
  }
  
  public Bitmap getBitmap()
  {
    return ((BitmapDrawable)this.mImageView.getDrawable()).getBitmap();
  }
  
  public int getLoadedImageHeight()
  {
    return this.loadedImageHeight;
  }
  
  public int getLoadedImageWidth()
  {
    return this.loadedImageWidth;
  }
  
  public void hideImageLoadingProgress()
  {
    this.mImageProgressBar.setVisibility(4);
  }
  
  public boolean isLoaded()
  {
    return this.mLoaded;
  }
  
  public void loadImage()
  {
    if (this.mImageLoadThread != null) {
      cancelLoading();
    }
    Log.d("retrica", "lazyImageView size: " + getWidth() + ", " + getHeight());
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        Log.d("retrica", "load from mURLString: " + LazyImageView.this.mURLString);
        if (LazyImageView.this.mBitmap != null) {}
        for (final BitmapDrawable localBitmapDrawable = LazyImageView.this.getProperBitmapDrawable(LazyImageView.this.mBitmap, 1); localBitmapDrawable != null; localBitmapDrawable = LazyImageView.this.getProperBitmapDrawable(Uri.parse(LazyImageView.this.mURLString)))
        {
          LazyImageView.this.getMainHandler().post(new Runnable()
          {
            public void run()
            {
              Log.d("retrica", "drawable: " + localBitmapDrawable.getBounds());
              try
              {
                LazyImageView.this.mImageView.setImageDrawable(localBitmapDrawable);
                LazyImageView.this.hideImageLoadingProgress();
                LazyImageView.this.mLoaded = true;
                if (LazyImageView.this.loadingFinishListner != null)
                {
                  LazyImageView.LoadingFinishListner localLoadingFinishListner = LazyImageView.this.loadingFinishListner;
                  if (localBitmapDrawable == null)
                  {
                    Bitmap localBitmap1 = null;
                    localLoadingFinishListner.onLoadingFinish(localBitmap1);
                  }
                }
                else
                {
                  return;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                  Log.d("retrica", "Cannot set Image Drawable: " + localBitmapDrawable);
                  continue;
                  Bitmap localBitmap2 = localBitmapDrawable.getBitmap();
                }
              }
            }
          });
          return;
        }
        LazyImageView.this.getMainHandler().post(new Runnable()
        {
          public void run()
          {
            LazyImageView.this.hideImageLoadingProgress();
          }
        });
      }
    };
    showImageLoadingProgress();
    this.mImageLoadThread = new Thread(local1);
    this.mImageLoadThread.start();
  }
  
  public void loadImage(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    loadImage();
  }
  
  public void loadImage(String paramString)
  {
    this.mURLString = paramString;
    loadImage();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mImageView.setImageBitmap(paramBitmap);
  }
  
  public void setCropRegion(float[] paramArrayOfFloat)
  {
    this.mCropRegion = paramArrayOfFloat;
  }
  
  public void setLoadedImageHeight(int paramInt)
  {
    this.loadedImageHeight = paramInt;
  }
  
  public void setLoadedImageWidth(int paramInt)
  {
    this.loadedImageWidth = paramInt;
  }
  
  public void setOnLoadingFinishListner(LazyImageView.LoadingFinishListner paramLoadingFinishListner)
  {
    this.loadingFinishListner = paramLoadingFinishListner;
  }
  
  public void setOnURILoadingFinishListner(LazyImageView.URILoadingFinishListner paramURILoadingFinishListner)
  {
    this.uriLoadingFinishListner = paramURILoadingFinishListner;
  }
  
  public void showImageLoadingProgress()
  {
    this.mImageProgressBar.setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/LazyImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */