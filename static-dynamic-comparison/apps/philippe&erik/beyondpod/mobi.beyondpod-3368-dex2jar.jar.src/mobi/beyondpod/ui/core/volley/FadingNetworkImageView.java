package mobi.beyondpod.ui.core.volley;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class FadingNetworkImageView
  extends ImageView
{
  protected static final int ANIMATION_FADE_IN_TIME = 100;
  protected static final int HALF_FADE_IN_TIME = 50;
  protected static ImageLoader.ImageListener _prefetchImageListener = new ImageLoader.ImageListener()
  {
    public void onErrorResponse(VolleyError paramAnonymousVolleyError) {}
    
    public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean) {}
  };
  protected static final ColorDrawable transparentDrawable = new ColorDrawable(17170445);
  protected int mDefaultImageId;
  protected int mErrorImageId;
  protected boolean mFadeInImage = true;
  protected ImageLoader.ImageContainer mImageContainer;
  protected ImageLoader.ImageListener mImageListener = new ImageLoader.ImageListener()
  {
    public void onErrorResponse(VolleyError paramAnonymousVolleyError)
    {
      FadingNetworkImageView.this.imageError(paramAnonymousVolleyError);
    }
    
    public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
    {
      FadingNetworkImageView.this.imageSuccess(paramAnonymousImageContainer, paramAnonymousBoolean);
    }
  };
  protected ImageLoader mImageLoader;
  protected boolean mIsInLayoutPass;
  protected int mMaxImageHeight = 0;
  protected int mMaxImageWidth = 0;
  protected String mUrl;
  
  public FadingNetworkImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FadingNetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FadingNetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void prefetchImage(String paramString, ImageLoader paramImageLoader, int paramInt1, int paramInt2)
  {
    paramImageLoader.get(paramString, _prefetchImageListener, paramInt1, paramInt2);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  protected ImageLoader.ImageContainer getImageContainer()
  {
    return this.mImageLoader.get(this.mUrl, this.mImageListener, this.mMaxImageWidth, this.mMaxImageHeight);
  }
  
  protected void imageError(VolleyError paramVolleyError)
  {
    if (this.mErrorImageId != 0) {
      setImageResource(this.mErrorImageId);
    }
  }
  
  protected void imageSuccess(final ImageLoader.ImageContainer paramImageContainer, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mIsInLayoutPass)) {
      post(new Runnable()
      {
        public void run()
        {
          FadingNetworkImageView.this.imageSuccess(paramImageContainer, false);
        }
      });
    }
    do
    {
      return;
      if (paramImageContainer.getBitmap() != null)
      {
        if ((BitmapCache.getBitmapSize(paramImageContainer.getBitmap()) > 2048) || (this.mErrorImageId == 0))
        {
          paramImageContainer = paramImageContainer.getBitmap();
          Resources localResources = getContext().getResources();
          if ((this.mFadeInImage) && (!paramBoolean)) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            setImageBitmap(this, paramImageContainer, localResources, paramBoolean);
            return;
          }
        }
        loadedImageIsBad();
        return;
      }
    } while (this.mDefaultImageId == 0);
    setImageResource(this.mDefaultImageId);
  }
  
  protected void loadImageIfNecessary(boolean paramBoolean)
  {
    int j = getWidth();
    int k = getHeight();
    int i;
    if ((getLayoutParams() != null) && (getLayoutParams().height == -2) && (getLayoutParams().width == -2))
    {
      i = 1;
      if ((j != 0) || (k != 0) || (i != 0)) {
        break label63;
      }
    }
    label63:
    do
    {
      return;
      i = 0;
      break;
      if ((TextUtils.isEmpty(this.mUrl)) || (this.mUrl == null))
      {
        if (this.mImageContainer != null)
        {
          this.mImageContainer.cancelRequest();
          this.mImageContainer = null;
        }
        if (this.mErrorImageId != 0)
        {
          setImageResource(this.mErrorImageId);
          return;
        }
        setImageBitmap(null);
        return;
      }
      if ((this.mImageContainer == null) || (this.mImageContainer.getRequestUrl() == null)) {
        break label167;
      }
    } while (this.mImageContainer.getRequestUrl().equals(this.mUrl));
    this.mImageContainer.cancelRequest();
    setImageBitmap(null);
    label167:
    this.mIsInLayoutPass = paramBoolean;
    this.mImageContainer = getImageContainer();
  }
  
  protected void loadedImageIsBad()
  {
    setImageResource(this.mErrorImageId);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mImageContainer != null)
    {
      this.mImageContainer.cancelRequest();
      setImageBitmap(null);
      this.mImageContainer = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    loadImageIfNecessary(true);
  }
  
  public void setDefaultImageResId(int paramInt)
  {
    this.mDefaultImageId = paramInt;
  }
  
  public void setErrorImageResId(int paramInt)
  {
    this.mErrorImageId = paramInt;
  }
  
  public void setFadeInImage(boolean paramBoolean)
  {
    this.mFadeInImage = paramBoolean;
  }
  
  @TargetApi(12)
  protected void setImageBitmap(final ImageView paramImageView, final Bitmap paramBitmap, Resources paramResources, boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 12))
    {
      paramResources = paramImageView.animate().alpha(0.5F);
      if (paramImageView.getDrawable() == null) {}
      for (;;)
      {
        paramResources.setDuration(i).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramImageView.setImageBitmap(paramBitmap);
            paramImageView.animate().alpha(1.0F).setDuration(50L).setListener(null);
          }
        });
        return;
        i = 50;
      }
    }
    if (paramBoolean)
    {
      if (paramImageView.getDrawable() != null) {}
      for (Object localObject = paramImageView.getDrawable();; localObject = transparentDrawable)
      {
        paramBitmap = new TransitionDrawable(new Drawable[] { localObject, new BitmapDrawable(paramResources, paramBitmap) });
        paramImageView.setImageDrawable(paramBitmap);
        paramBitmap.startTransition(100);
        return;
      }
    }
    paramImageView.setImageBitmap(paramBitmap);
  }
  
  public void setImageUrl(String paramString, ImageLoader paramImageLoader)
  {
    this.mUrl = paramString;
    this.mImageLoader = paramImageLoader;
    loadImageIfNecessary(false);
  }
  
  public void setMaxImageSize(int paramInt1, int paramInt2)
  {
    this.mMaxImageWidth = paramInt1;
    this.mMaxImageHeight = paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/FadingNetworkImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */