package mobi.beyondpod.ui.core.volley;

import android.content.Context;
import android.util.AttributeSet;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import java.util.ArrayList;
import mobi.beyondpod.R.drawable;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class FadingNetworkImageViewTrack
  extends FadingNetworkImageViewFeed
{
  private RssFeedItem mRssItem;
  private Track mTrack;
  
  public FadingNetworkImageViewTrack(Context paramContext)
  {
    super(paramContext);
  }
  
  public FadingNetworkImageViewTrack(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FadingNetworkImageViewTrack(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static int GetDefaultImage(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case -1: 
    case 0: 
    case 1: 
      return R.drawable.podcast_list_audio_bg;
    case 2: 
      return R.drawable.podcast_list_movie_bg;
    }
    return R.drawable.podcast_list_image_bg;
  }
  
  public static String generateItemImageUrl(RssFeedItem paramRssFeedItem)
  {
    String str1;
    if (!paramRssFeedItem.IsItemImageUsingParentFeedImage())
    {
      String str2 = paramRssFeedItem.SelectedItemImageUrl();
      str1 = str2;
      if (StringUtils.IsNullOrEmpty(str2))
      {
        str1 = str2;
        if (paramRssFeedItem.ItemImageUrls().size() > 0) {
          str1 = (String)paramRssFeedItem.ItemImageUrls().get(0);
        }
      }
      if (StringUtils.IsNullOrEmpty(str1)) {
        paramRssFeedItem.setSelectedItemImageUrlToUseParentFeedImage();
      }
    }
    else
    {
      return null;
    }
    paramRssFeedItem.setSelectedItemImageUrl(str1);
    return str1;
  }
  
  public static String getEpisodeImageUrl(Track paramTrack)
  {
    return String.format("episode://%s", new Object[] { paramTrack.TrackPath() });
  }
  
  protected ImageLoader.ImageContainer getImageContainer()
  {
    return ((ImageLoaderTrack)this.mImageLoader).get(this.mUrl, this.mTrack, this.mFeed, this.mImageListener, this.mMaxImageWidth, this.mMaxImageHeight);
  }
  
  protected void imageError(VolleyError paramVolleyError)
  {
    if (this.mRssItem != null) {
      this.mRssItem.setSelectedItemImageUrlToUseParentFeedImage();
    }
    super.imageError(paramVolleyError);
  }
  
  public void setRssItem(RssFeedItem paramRssFeedItem, Feed paramFeed, ImageLoader paramImageLoader)
  {
    this.mRssItem = paramRssFeedItem;
    this.mFeed = paramFeed;
    super.setImageUrl(generateItemImageUrl(paramRssFeedItem), paramImageLoader);
  }
  
  public void setTrack(Track paramTrack, ImageLoader paramImageLoader)
  {
    this.mTrack = paramTrack;
    this.mFeed = paramTrack.getParentFeed();
    super.setImageUrl(getEpisodeImageUrl(paramTrack), paramImageLoader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/FadingNetworkImageViewTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */