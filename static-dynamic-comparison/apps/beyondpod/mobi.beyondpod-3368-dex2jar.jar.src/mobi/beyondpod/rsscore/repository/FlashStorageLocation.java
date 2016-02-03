package mobi.beyondpod.rsscore.repository;

import android.os.StatFs;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class FlashStorageLocation
{
  private static final String TAG = FlashStorageLocation.class.getSimpleName();
  StatFs _LocationStats;
  
  public FlashStorageLocation(String paramString)
  {
    try
    {
      this._LocationStats = new StatFs(paramString);
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "Unable to get the free space at location " + paramString, localException);
    }
  }
  
  public static boolean CheckIfSpaceIsAvailable(String paramString, long paramLong)
  {
    return new FlashStorageLocation(paramString).CheckIfSpaceIsAvailable(paramLong);
  }
  
  public static long GetFreeSpaceAtFeedDownloadPath(Feed paramFeed)
  {
    return new FlashStorageLocation(paramFeed.getFeedPath()).FreeSpace();
  }
  
  public boolean CheckIfSpaceIsAvailable(long paramLong)
  {
    return FreeSpace() > paramLong;
  }
  
  public long FreeSpace()
  {
    if (this._LocationStats == null) {
      return -1L;
    }
    return this._LocationStats.getAvailableBlocks() * this._LocationStats.getBlockSize();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/FlashStorageLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */