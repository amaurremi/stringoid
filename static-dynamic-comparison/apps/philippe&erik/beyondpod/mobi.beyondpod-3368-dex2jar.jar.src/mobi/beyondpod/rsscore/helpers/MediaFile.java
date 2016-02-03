package mobi.beyondpod.rsscore.helpers;

import android.webkit.URLUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MediaFile
{
  public static final int FILE_TYPE_3GPP = 23;
  public static final int FILE_TYPE_3GPP2 = 24;
  public static final int FILE_TYPE_AMR = 4;
  public static final int FILE_TYPE_AWB = 5;
  public static final int FILE_TYPE_BMP = 34;
  public static final int FILE_TYPE_EXTERNAL_DATA = 100;
  public static final int FILE_TYPE_FLV = 26;
  public static final int FILE_TYPE_GIF = 32;
  public static final int FILE_TYPE_IMY = 13;
  public static final int FILE_TYPE_JPEG = 31;
  public static final int FILE_TYPE_M3U = 41;
  public static final int FILE_TYPE_M4A = 2;
  public static final int FILE_TYPE_M4V = 22;
  public static final int FILE_TYPE_MID = 11;
  public static final int FILE_TYPE_MP3 = 1;
  public static final int FILE_TYPE_MP4 = 21;
  public static final int FILE_TYPE_OGG = 7;
  public static final int FILE_TYPE_PLS = 42;
  public static final int FILE_TYPE_PNG = 33;
  public static final int FILE_TYPE_SMF = 12;
  public static final int FILE_TYPE_WAV = 3;
  public static final int FILE_TYPE_WBMP = 35;
  public static final int FILE_TYPE_WMA = 6;
  public static final int FILE_TYPE_WMV = 25;
  public static final int FILE_TYPE_WPL = 43;
  private static final int FIRST_AUDIO_FILE_TYPE = 1;
  private static final int FIRST_IMAGE_FILE_TYPE = 31;
  private static final int FIRST_MIDI_FILE_TYPE = 11;
  private static final int FIRST_PLAYLIST_FILE_TYPE = 41;
  private static final int FIRST_VIDEO_FILE_TYPE = 21;
  private static final int LAST_AUDIO_FILE_TYPE = 7;
  private static final int LAST_IMAGE_FILE_TYPE = 35;
  private static final int LAST_MIDI_FILE_TYPE = 13;
  private static final int LAST_PLAYLIST_FILE_TYPE = 43;
  private static final int LAST_VIDEO_FILE_TYPE = 26;
  public static final String UNKNOWN_STRING = "<unknown>";
  private static HashMap<Integer, String> sExtensionTypeMap;
  public static String sFileExtensions;
  private static HashMap<String, MediaFileType> sFileTypeMap = new HashMap();
  private static HashMap<String, Integer> sMimeTypeMap = new HashMap();
  
  static
  {
    sExtensionTypeMap = new HashMap();
    addFileType("MP3", 1, "audio/mpeg");
    addFileType("M4A", 2, "audio/mp4");
    addFileType("WAV", 3, "audio/x-wav");
    addFileType("AMR", 4, "audio/amr");
    addFileType("AWB", 5, "audio/amr-wb");
    addFileType("WMA", 6, "audio/x-ms-wma");
    addFileType("OGA", 7, "application/ogg");
    addFileType("OGG", 7, "application/ogg");
    addFileType("MID", 11, "audio/midi");
    addFileType("MIDI", 11, "audio/midi");
    addFileType("XMF", 11, "audio/midi");
    addFileType("RTTTL", 11, "audio/midi");
    addFileType("SMF", 12, "audio/sp-midi");
    addFileType("IMY", 13, "audio/imelody");
    addFileType("RTX", 11, "audio/midi");
    addFileType("OTA", 11, "audio/midi");
    addFileType("MP4", 21, "video/mp4");
    addFileType("M4V", 22, "video/mp4");
    addFileType("M4V", 22, "video/quicktime");
    addFileType("3GP", 23, "video/3gpp");
    addFileType("3GPP", 23, "video/3gpp");
    addFileType("3G2", 24, "video/3gpp2");
    addFileType("3GPP2", 24, "video/3gpp2");
    addFileType("WMV", 25, "video/x-ms-wmv");
    addFileType("FLV", 26, "application/x-shockwave-flash");
    addFileType("SWF", 26, "application/x-shockwave-flash");
    addFileType("JPG", 31, "image/jpeg");
    addFileType("JPEG", 31, "image/jpeg");
    addFileType("GIF", 32, "image/gif");
    addFileType("PNG", 33, "image/png");
    addFileType("BMP", 34, "image/x-ms-bmp");
    addFileType("WBMP", 35, "image/vnd.wap.wbmp");
    addFileType("M3U", 41, "audio/x-mpegurl");
    addFileType("PLS", 42, "audio/x-scpls");
    addFileType("WPL", 43, "application/vnd.ms-wpl");
    addFileType("PDF", 100, "application/pdf");
    addFileType("DOC", 100, "application/msword");
    addFileType("XLS", 100, "application/vnd.ms-excel");
    addFileType("PPT", 100, "application/vnd.ms-powerpoint");
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = sFileTypeMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        sFileExtensions = localStringBuilder.toString();
        return;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append((String)localIterator.next());
    }
  }
  
  public static String ConvertToStreamableMimeType(String paramString1, String paramString2, String paramString3)
  {
    if (IsStreamableMimeType(paramString1)) {
      return paramString1;
    }
    paramString1 = null;
    if (!StringUtils.IsNullOrEmpty(paramString2)) {
      paramString1 = GuessMimeTypeOfUrl(paramString2);
    }
    while (StringUtils.IsNullOrEmpty(paramString1))
    {
      return "audio/*";
      if (!StringUtils.IsNullOrEmpty(paramString3)) {
        paramString1 = GuessMimeTypeOfUrl(paramString2);
      }
    }
    return paramString1;
  }
  
  public static String GuessMimeTypeOfUrl(String paramString)
  {
    Object localObject = null;
    String str = URLUtil.guessFileName(paramString, null, null);
    paramString = (String)localObject;
    if (!StringUtils.IsNullOrEmpty(str)) {
      paramString = getMimeType(str);
    }
    return paramString;
  }
  
  public static boolean IsStreamableMimeType(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    while ((!paramString.startsWith("audio")) && (!paramString.startsWith("video")) && (!"application/x-shockwave-flash".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  public static int MapMimeToContentType(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return -1;
    }
    if ((paramString.startsWith("audio")) || (paramString.equals("application/ogg")) || (paramString.equals("application/x-ogg"))) {
      return 1;
    }
    if (paramString.startsWith("video")) {
      return 2;
    }
    if (paramString.startsWith("image")) {
      return 3;
    }
    return 0;
  }
  
  static void addFileType(String paramString1, int paramInt, String paramString2)
  {
    sFileTypeMap.put(paramString1, new MediaFileType(paramInt, paramString2));
    sMimeTypeMap.put(paramString2, Integer.valueOf(paramInt));
    sExtensionTypeMap.put(Integer.valueOf(paramInt), paramString1);
  }
  
  public static String getFileExtensionForType(int paramInt)
  {
    return (String)sExtensionTypeMap.get(Integer.valueOf(paramInt));
  }
  
  public static MediaFileType getFileType(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    if (i < 0) {
      return null;
    }
    return (MediaFileType)sFileTypeMap.get(paramString.substring(i + 1).toUpperCase());
  }
  
  public static int getFileTypeForMimeType(String paramString)
  {
    if (paramString == null) {}
    Integer localInteger;
    do
    {
      return 0;
      localInteger = (Integer)sMimeTypeMap.get(paramString);
      if (localInteger == null)
      {
        if (paramString.startsWith("video")) {
          return 21;
        }
        if (paramString.startsWith("audio")) {
          return 1;
        }
      }
    } while (localInteger == null);
    return localInteger.intValue();
  }
  
  public static String getMimeType(String paramString)
  {
    MediaFileType localMediaFileType = getFileType(paramString);
    paramString = localMediaFileType;
    if (localMediaFileType == null) {
      paramString = (MediaFileType)sFileTypeMap.get("MP3");
    }
    return paramString.mimeType;
  }
  
  public static boolean isAudioFileType(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 1)
    {
      bool1 = bool2;
      if (paramInt <= 7) {}
    }
    else if (paramInt >= 11)
    {
      bool1 = bool2;
      if (paramInt <= 13) {}
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean isImageFileType(int paramInt)
  {
    return (paramInt == 100) || ((paramInt >= 31) && (paramInt <= 35));
  }
  
  public static boolean isPlayListFileType(int paramInt)
  {
    return (paramInt >= 41) && (paramInt <= 43);
  }
  
  public static boolean isVideoFileType(int paramInt)
  {
    return (paramInt >= 21) && (paramInt <= 26);
  }
  
  public static String mapMediaRssMediumToMime(String paramString)
  {
    if ("image".equals(paramString)) {
      return "image/jpeg";
    }
    if ("audio".equals(paramString)) {
      return "audio/mpeg";
    }
    if ("video".equals(paramString)) {
      return "video/mp4";
    }
    return "image/jpeg";
  }
  
  public static class MediaFileType
  {
    public int fileType;
    public String mimeType;
    
    MediaFileType(int paramInt, String paramString)
    {
      this.fileType = paramInt;
      this.mimeType = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/MediaFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */