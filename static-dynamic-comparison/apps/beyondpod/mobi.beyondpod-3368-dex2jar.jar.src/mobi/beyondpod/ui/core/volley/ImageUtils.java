package mobi.beyondpod.ui.core.volley;

import android.graphics.Bitmap;
import mobi.beyondpod.rsscore.Track;

public class ImageUtils
{
  public static Bitmap LoadEpisodeImage(Track paramTrack, int paramInt1, int paramInt2)
  {
    if (paramTrack == null) {
      return null;
    }
    paramInt1 = Math.min(paramInt1, paramInt2);
    if ((!paramTrack.IsFullyDownloaded()) || (paramTrack.ContentType() == 2)) {}
    for (paramTrack = new ImageRequestTrack(FadingNetworkImageViewTrack.getFeedImageUrl(paramTrack.getParentFeed()), null, paramInt1, paramInt1, null, null, null, paramTrack.getParentFeed());; paramTrack = new ImageRequestTrack(FadingNetworkImageViewTrack.getEpisodeImageUrl(paramTrack), null, paramInt1, paramInt1, null, null, paramTrack, paramTrack.getParentFeed())) {
      return paramTrack.getEpisodeImageQuick();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */