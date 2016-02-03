package mobi.beyondpod.ui.core;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class TrackMetadataParser
{
  private static final String TAG = TrackMetadataParser.class.getSimpleName();
  
  @TargetApi(10)
  public static boolean LoadMetadataFor(Track paramTrack)
  {
    if (paramTrack == null) {
      CoreHelper.WriteTraceEntry(TAG, "Unable to load track metadata! Track is null! Ignoring...");
    }
    for (;;)
    {
      return false;
      CoreHelper.WriteTraceEntry(TAG, "Loading metadata for: '" + paramTrack.TrackPath());
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      if (!paramTrack.Exists())
      {
        CoreHelper.WriteTraceEntry(TAG, "File " + paramTrack.TrackPath() + " does not exist! Ignoring...");
        return false;
      }
      try
      {
        localMediaMetadataRetriever.setDataSource(paramTrack.TrackPath());
        String str2 = localMediaMetadataRetriever.extractMetadata(12);
        Object localObject = localMediaMetadataRetriever.extractMetadata(7);
        long l = StringUtils.SafeParseLong(localMediaMetadataRetriever.extractMetadata(9), -1L);
        if ((!StringUtils.IsNullOrEmpty((String)localObject)) && (!MusicUtils.IsTitleSameAsFileName(paramTrack, (String)localObject))) {
          paramTrack.setName((String)localObject);
        }
        if ((l > 0L) && (l < 72000000L)) {
          paramTrack.setTotalTime(l / 1000L);
        }
        String str1 = str2;
        if (!StringUtils.IsNullOrEmpty(str2))
        {
          str1 = str2;
          if (str2.startsWith("video"))
          {
            MediaFile.MediaFileType localMediaFileType = MediaFile.getFileType(paramTrack.TrackPath());
            str1 = str2;
            if (localMediaFileType.fileType == 2)
            {
              CoreHelper.WriteTraceEntry(TAG, "Seems like we detected mime incorrectly as: " + str2 + "! Patching to: " + localMediaFileType.mimeType);
              str1 = localMediaFileType.mimeType;
            }
          }
          paramTrack.setContentMimeType(str1);
        }
        str2 = TAG;
        localObject = new StringBuilder("Loaded metadata: ").append((String)localObject).append(", (").append(str1).append("). Total duration: ").append(l).append(" - ");
        if (l > 0L) {}
        for (str1 = CoreHelper.FormatTimeAsString(l / 1000L, true);; str1 = "N/A")
        {
          CoreHelper.WriteTraceEntry(str2, str1);
          return true;
        }
      }
      catch (Exception localException)
      {
        CoreHelper.WriteTraceEntry(TAG, "Failed to load metadata for " + paramTrack.getName() + ". Reason: " + localException.getMessage());
        return false;
      }
      finally
      {
        if (localMediaMetadataRetriever != null) {
          localMediaMetadataRetriever.release();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/TrackMetadataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */