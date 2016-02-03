package com.mopub.nativeads;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

class ImageViewService
{
  private static final int VIEW_TAG_MOPUB_KEY = 817491827;
  
  static Long getImageViewUniqueId(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = getViewTag(paramImageView);
      if ((paramImageView instanceof Long)) {
        return (Long)paramImageView;
      }
    }
    return null;
  }
  
  static Object getViewTag(View paramView)
  {
    return paramView.getTag(817491827);
  }
  
  static void loadImageView(String paramString, ImageView paramImageView)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      paramImageView.setImageDrawable(null);
    } while (paramString == null);
    setImageViewUniqueId(paramImageView);
    long l = getImageViewUniqueId(paramImageView).longValue();
    ImageService.get(Arrays.asList(new String[] { paramString }), new MyImageViewServiceListener(paramString, paramImageView, l));
  }
  
  static void setImageViewUniqueId(ImageView paramImageView)
  {
    if (paramImageView != null) {
      setViewTag(paramImageView, Long.valueOf(com.mopub.common.util.Utils.generateUniqueId()));
    }
  }
  
  static void setViewTag(View paramView, Object paramObject)
  {
    paramView.setTag(817491827, paramObject);
  }
  
  private static class MyImageViewServiceListener
    implements ImageService.ImageServiceListener
  {
    private final WeakReference<ImageView> mImageView;
    private final long mUniqueId;
    private final String mUrl;
    
    MyImageViewServiceListener(String paramString, ImageView paramImageView, long paramLong)
    {
      this.mUrl = paramString;
      this.mImageView = new WeakReference(paramImageView);
      this.mUniqueId = paramLong;
    }
    
    public void onFail()
    {
      com.mopub.nativeads.util.Utils.MoPubLog("Failed to load image for ImageView");
    }
    
    public void onSuccess(Map<String, Bitmap> paramMap)
    {
      ImageView localImageView = (ImageView)this.mImageView.get();
      if ((localImageView == null) || (paramMap == null) || (!paramMap.containsKey(this.mUrl))) {}
      Long localLong;
      do
      {
        return;
        localLong = ImageViewService.getImageViewUniqueId(localImageView);
      } while ((localLong == null) || (this.mUniqueId != localLong.longValue()));
      localImageView.setImageBitmap((Bitmap)paramMap.get(this.mUrl));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/ImageViewService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */