package mobi.beyondpod.ui.core.volley;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.core.FeedImageCache;

public class ImageRequestFeed
  extends ImageRequest
{
  private static final String TAG = ImageRequestFeed.class.getSimpleName();
  Feed mFeed;
  
  public ImageRequestFeed(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener, Feed paramFeed)
  {
    super(paramString, paramListener, paramInt1, paramInt2, paramConfig, paramErrorListener);
    this.mFeed = paramFeed;
  }
  
  private Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if ((j < paramInt2) || (i < paramInt1))
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "+++ Loaded image is too small - " + i + " x " + j + " for feed: " + this.mFeed.getName() + ". Ignoring...");
      return null;
    }
    paramInt1 = getResizedDimension(this.mMaxWidth, this.mMaxHeight, i, j);
    paramInt2 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, j, i);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = findBestSampleSize(i, j, paramInt1, paramInt2);
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte.getWidth() != paramInt1) || (paramArrayOfByte.getHeight() != paramInt2)))
    {
      localObject = Bitmap.createScaledBitmap(paramArrayOfByte, paramInt1, paramInt2, true);
      paramArrayOfByte.recycle();
      paramArrayOfByte = (byte[])localObject;
    }
    for (;;)
    {
      return paramArrayOfByte;
    }
  }
  
  private Bitmap decodeFile(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if ((j < paramInt2) || (i < paramInt1))
    {
      CoreHelper.WriteTraceEntryInDebug(TAG, "+++ Loaded image is too small - " + i + " x " + j + " for feed: " + this.mFeed.getName() + ". Ignoring...");
      return null;
    }
    paramInt1 = getResizedDimension(this.mMaxWidth, this.mMaxHeight, i, j);
    paramInt2 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, j, i);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = findBestSampleSize(i, j, paramInt1, paramInt2);
    paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if ((paramString != null) && ((paramString.getWidth() != paramInt1) || (paramString.getHeight() != paramInt2)))
    {
      localObject = Bitmap.createScaledBitmap(paramString, paramInt1, paramInt2, true);
      paramString.recycle();
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
    }
  }
  
  protected Response<Bitmap> doParse(NetworkResponse paramNetworkResponse)
  {
    String str = null;
    Object localObject = str;
    if (paramNetworkResponse.data != null)
    {
      localObject = str;
      if (paramNetworkResponse.data.length > 0) {
        localObject = decodeByteArray(paramNetworkResponse.data, 45, 45);
      }
    }
    if (localObject != null) {
      return Response.success(localObject, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
    }
    if ((localObject == null) && (this.mFeed != null))
    {
      str = FeedImageCache.GetExistingFeedImagePath(this.mFeed);
      if (!StringUtils.IsNullOrEmpty(str)) {
        localObject = decodeFile(str, 20, 20);
      }
      if (localObject != null) {
        return Response.success(localObject, null);
      }
    }
    return Response.error(new ParseError(paramNetworkResponse));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageRequestFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */