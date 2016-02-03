package mobi.beyondpod.ui.core.volley;

import android.content.Context;
import android.util.AttributeSet;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.ui.core.FeedImageCache;

public class FadingNetworkImageViewFeed
  extends FadingNetworkImageView
{
  protected Feed mFeed = null;
  
  public FadingNetworkImageViewFeed(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FadingNetworkImageViewFeed(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FadingNetworkImageViewFeed(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String getFeedImageUrl(Feed paramFeed)
  {
    paramFeed = FeedImageCache.GetExistingFeedImagePath(paramFeed);
    if (paramFeed == null) {
      return null;
    }
    return String.format("file://%s", new Object[] { paramFeed });
  }
  
  protected ImageLoader.ImageContainer getImageContainer()
  {
    return ((ImageLoaderFeed)this.mImageLoader).get(this.mUrl, this.mFeed, this.mImageListener, this.mMaxImageWidth, this.mMaxImageHeight);
  }
  
  protected void imageError(VolleyError paramVolleyError)
  {
    super.imageError(paramVolleyError);
  }
  
  protected void imageSuccess(ImageLoader.ImageContainer paramImageContainer, boolean paramBoolean)
  {
    super.imageSuccess(paramImageContainer, paramBoolean);
  }
  
  protected void loadImageIfNecessary(boolean paramBoolean)
  {
    super.loadImageIfNecessary(paramBoolean);
  }
  
  public void setFeed(Feed paramFeed, ImageLoader paramImageLoader)
  {
    this.mFeed = paramFeed;
    setImageUrl(getFeedImageUrl(this.mFeed), paramImageLoader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/FadingNetworkImageViewFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */