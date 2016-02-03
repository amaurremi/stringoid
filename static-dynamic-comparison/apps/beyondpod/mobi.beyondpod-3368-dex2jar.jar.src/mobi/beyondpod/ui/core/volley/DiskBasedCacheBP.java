package mobi.beyondpod.ui.core.volley;

import com.android.volley.toolbox.DiskBasedCache;
import java.io.File;
import java.util.Map;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;

public class DiskBasedCacheBP
  extends DiskBasedCache
{
  private static final String DEFAULT_CACHE_DIR = "img";
  private static final String TAG = DiskBasedCacheBP.class.getSimpleName();
  static File _CacheDir = new File(BeyondPodApplication.GetInstance().getExternalCacheDir(), "img");
  
  public DiskBasedCacheBP(int paramInt)
  {
    super(_CacheDir, paramInt);
  }
  
  public static int deleteCachedFiles()
  {
    File[] arrayOfFile = _CacheDir.listFiles();
    int i = 0;
    int k = 0;
    int j;
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      j = 0;
      i = k;
      if (j < m) {}
    }
    else
    {
      return i;
    }
    File localFile = arrayOfFile[j];
    k = i;
    if (localFile.isFile()) {
      if (!localFile.delete()) {
        break label71;
      }
    }
    label71:
    for (k = 0;; k = 1)
    {
      k = i + k;
      j += 1;
      i = k;
      break;
    }
  }
  
  public static boolean deleteFileForKey(String paramString)
  {
    int i = paramString.length() / 2;
    paramString = String.valueOf(paramString.substring(0, i).hashCode()) + String.valueOf(paramString.substring(i).hashCode());
    return FileUtils.DeleteFileIfExists(_CacheDir + "/" + paramString);
  }
  
  public File getFileForKey(String paramString)
  {
    return super.getFileForKey(paramString);
  }
  
  public void initialize()
  {
    super.initialize();
    CoreHelper.WriteTraceEntryInDebug(TAG, "Loaded " + this.mEntries.size() + " episode image cache entries. Cache size: " + CoreHelper.GetFileLengthAsString(Long.valueOf(this.mTotalSize)) + " (" + (int)((float)this.mTotalSize / this.mMaxCacheSizeInBytes * 100.0F) + "% full). Cache location:" + this.mRootDirectory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/DiskBasedCacheBP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */