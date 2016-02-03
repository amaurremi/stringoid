package mobi.beyondpod.ui.core.volley;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.media.MediaMetadataRetriever;
import com.android.volley.Cache.Entry;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.core.MusicUtils;

public class ImageRequestTrack
  extends ImageRequestFeed
{
  private static final long IMAGE_EXPIRATION_IN_DAYS_URL_FEED = 864000000L;
  private static final long IMAGE_EXPIRATION_IN_DAYS_VIR_FEED = 2592000000L;
  private static final String TAG = ImageRequestTrack.class.getSimpleName();
  private final Track mTrack;
  
  public ImageRequestTrack(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener, Track paramTrack, Feed paramFeed)
  {
    super(paramString, paramListener, paramInt1, paramInt2, paramConfig, paramErrorListener, paramFeed);
    this.mTrack = paramTrack;
  }
  
  private void setResponseExpiration(Response<Bitmap> paramResponse, long paramLong)
  {
    if (paramResponse.cacheEntry != null)
    {
      paramResponse.cacheEntry.ttl = (System.currentTimeMillis() + paramLong);
      paramResponse.cacheEntry.softTtl = paramResponse.cacheEntry.ttl;
    }
  }
  
  protected Response<Bitmap> doParse(NetworkResponse paramNetworkResponse)
  {
    if ((!Configuration.ShowPodcastThumbnails()) || (paramNetworkResponse.data != null) || (StringUtils.IsNullOrEmpty(getUrl())) || (!getUrl().startsWith("episode://"))) {
      return super.doParse(paramNetworkResponse);
    }
    Bitmap localBitmap = null;
    Response localResponse = null;
    Object localObject2 = null;
    Object localObject1 = localBitmap;
    int i;
    for (;;)
    {
      try
      {
        this.mTrack.EnsureTrackHasContentTypeAndImage();
        localObject1 = localBitmap;
        if (this.mTrack.getParentFeed().getType() != 1) {
          continue;
        }
        i = 1;
        localObject1 = localBitmap;
        int j = this.mTrack.ContentType();
        switch (j)
        {
        default: 
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        CoreHelper.WriteTraceEntry(TAG, "Failed to retreive episode image! " + localException.getMessage());
        continue;
        l = 864000000L;
        continue;
        localObject1 = localBitmap;
        localObject3 = MusicUtils.getArtwork(BeyondPodApplication.GetInstance(), this.mTrack, this.mMaxWidth, this.mMaxHeight, 0);
        localObject1 = localObject3;
        continue;
        localObject1 = localBitmap;
        localObject3 = localResponse;
        if (CoreHelper.ApiLevel() < 18) {
          break label506;
        }
      }
      if (localObject1 == null) {
        break label538;
      }
      return Response.success(localObject1, null);
      i = 0;
    }
    localObject1 = localBitmap;
    if (CoreHelper.ApiLevel() >= 10)
    {
      localObject1 = localBitmap;
      localObject2 = new MediaMetadataRetriever();
      localObject1 = localBitmap;
      ((MediaMetadataRetriever)localObject2).setDataSource(this.mTrack.TrackPath());
      localObject1 = localBitmap;
      localObject2 = ((MediaMetadataRetriever)localObject2).getEmbeddedPicture();
      if (localObject2 != null)
      {
        localObject1 = localBitmap;
        localObject2 = super.doParse(new NetworkResponse((byte[])localObject2));
        localObject1 = localBitmap;
        if (((Response)localObject2).isSuccess()) {
          if (i != 0)
          {
            l = 2592000000L;
            localObject1 = localBitmap;
            setResponseExpiration((Response)localObject2, l);
            return (Response<Bitmap>)localObject2;
          }
        }
      }
    }
    localObject1 = localBitmap;
    Object localObject3 = new MediaMetadataRetriever();
    localObject1 = localBitmap;
    ((MediaMetadataRetriever)localObject3).setDataSource(this.mTrack.TrackPath());
    localObject1 = localBitmap;
    localBitmap = MusicUtils.sizeAndFrame(((MediaMetadataRetriever)localObject3).getFrameAtTime(), null, this.mMaxWidth, this.mMaxHeight);
    localObject3 = localBitmap;
    if (localBitmap != null)
    {
      localObject1 = localBitmap;
      localObject3 = new ByteArrayOutputStream();
      localObject1 = localBitmap;
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject3);
      localObject1 = localBitmap;
      localBitmap.recycle();
      localObject1 = localBitmap;
      localResponse = super.doParse(new NetworkResponse(((ByteArrayOutputStream)localObject3).toByteArray()));
      localObject1 = localBitmap;
      localObject3 = localBitmap;
      if (localResponse.isSuccess()) {
        if (i == 0) {
          break label544;
        }
      }
    }
    label506:
    label538:
    label544:
    for (long l = 2592000000L;; l = 864000000L)
    {
      localObject1 = localBitmap;
      setResponseExpiration(localResponse, l);
      return localResponse;
      localObject1 = localObject3;
      localObject3 = MusicUtils.getVideoArtwork(BeyondPodApplication.GetInstance(), this.mTrack, null, this.mMaxWidth, this.mMaxHeight);
      localObject1 = localObject3;
      break;
      return super.doParse(paramNetworkResponse);
    }
  }
  
  public Bitmap getEpisodeImageQuick()
  {
    return (Bitmap)doParse(new NetworkResponse(null)).result;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageRequestTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */