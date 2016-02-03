package mobi.beyondpod.rsscore.rss.entities;

import android.webkit.MimeTypeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;

public class RssEnclosure
{
  public final String DownloadPath;
  public long Duration;
  public RssFeedItem Parent;
  public String TempTitle;
  public String Type;
  public String Url;
  private int _EnclosureID = 0;
  private Long _Length;
  private ArrayList<ExtendedEncoding> m_ExtendedEncodingInfo;
  private String m_FileName;
  private final boolean m_ForceUniqueEnclosureNames;
  String m_FullPath;
  private String m_ParentItemId;
  Date m_PubDate;
  
  public RssEnclosure(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, Date paramDate, String paramString6)
  {
    this.Url = paramString1;
    this.Type = paramString4;
    this.m_FileName = paramString3;
    this.DownloadPath = paramString2;
    this.m_ParentItemId = paramString5;
    setEnclosureFileLength(Long.valueOf(paramLong));
    this.m_PubDate = paramDate;
    this.m_ForceUniqueEnclosureNames = false;
    this.TempTitle = paramString6;
  }
  
  public RssEnclosure(String paramString, boolean paramBoolean)
  {
    this.Url = "";
    this.Type = "";
    if (paramString != null) {}
    for (;;)
    {
      this.DownloadPath = paramString;
      this.m_ForceUniqueEnclosureNames = paramBoolean;
      return;
      paramString = "";
    }
  }
  
  private String TryGuessEnclosureExtension()
  {
    Object localObject2 = MimeTypeMap.getFileExtensionFromUrl(this.Url);
    Object localObject1 = localObject2;
    if (StringUtils.IsNullOrEmpty((String)localObject2))
    {
      localObject1 = localObject2;
      if (!StringUtils.IsNullOrEmpty(this.Type))
      {
        localObject2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(this.Type);
        localObject1 = localObject2;
        if (StringUtils.IsNullOrEmpty((String)localObject2)) {
          localObject1 = MediaFile.getFileExtensionForType(MediaFile.getFileTypeForMimeType(this.Type));
        }
      }
    }
    if (!StringUtils.IsNullOrEmpty((String)localObject1))
    {
      localObject2 = localObject1;
      if (!"mpga".equals(localObject1)) {}
    }
    else
    {
      localObject2 = "mp3";
    }
    return (String)localObject2;
  }
  
  public void AddExtendedEncoding(ExtendedEncoding paramExtendedEncoding)
  {
    if (this.m_ExtendedEncodingInfo == null) {
      this.m_ExtendedEncodingInfo = new ArrayList();
    }
    this.m_ExtendedEncodingInfo.add(paramExtendedEncoding);
  }
  
  public String Description()
  {
    if ((this.Parent != null) && (this.Parent.Description != null)) {
      return this.Parent.ShortTaglessDescription();
    }
    return "";
  }
  
  public boolean Downloaded()
  {
    Track localTrack = GetLocalEnclosureTrack();
    if (localTrack != null) {
      return localTrack.IsFullyDownloaded();
    }
    return false;
  }
  
  public StringBuilder DumpEnclosure()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Episode Details");
    Object localObject2 = GetLocalEnclosureTrack();
    Object localObject1;
    if (localObject2 == null)
    {
      if (this.Duration > 0L)
      {
        localObject1 = CoreHelper.FormatTimeAsString(this.Duration, true);
        if (EnclosureFileLength() == null) {
          break label122;
        }
      }
      label122:
      for (localObject2 = EnclosureSizeAsString();; localObject2 = "N/A")
      {
        localStringBuilder.append(String.format("\n  • Type: %s\n  • Size: %s\n  • Duration: %s\n  • Url: %s\n  • Download Path: %s\n\n", new Object[] { this.Type, localObject2, localObject1, this.Url, LocalFileName() }));
        if (Configuration.EnableLoggingInProduction()) {
          break label273;
        }
        return localStringBuilder;
        localObject1 = "N/A";
        break;
      }
    }
    label150:
    String str;
    long l1;
    long l2;
    long l3;
    if (((Track)localObject2).getTotalTime() > 0L)
    {
      localObject1 = CoreHelper.FormatTimeAsString(((Track)localObject2).getTotalTime(), true);
      str = this.Type;
      l1 = ((Track)localObject2).getSizeOnDisk();
      l2 = ((Track)localObject2).getDownloadedPortion();
      l3 = ((Track)localObject2).getDownloadSize();
      if (!((Track)localObject2).IsRemoteEpisode()) {
        break label266;
      }
    }
    label266:
    for (localObject2 = "Remote";; localObject2 = "Local")
    {
      localStringBuilder.append(String.format("\n  • Type: %s\n  • File Size: %s\n  • Downloaded: %s of %s\n  • Duration: %s\n  • Added by: %s Device\n  • Url: %s\n  • Download Path: %s\n\n", new Object[] { str, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), localObject1, localObject2, this.Url, LocalFileName() }));
      break;
      localObject1 = "N/A";
      break label150;
    }
    label273:
    if ((this.m_ExtendedEncodingInfo != null) && (this.m_ExtendedEncodingInfo.size() > 0)) {
      localObject1 = this.m_ExtendedEncodingInfo.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        localStringBuilder.append("-------------------\n" + Description());
        return localStringBuilder;
      }
      localObject2 = (ExtendedEncoding)((Iterator)localObject1).next();
      localStringBuilder.append(String.format("\n---- %s Info ---\n", new Object[] { ((ExtendedEncoding)localObject2).Type }));
      localStringBuilder.append(String.format(" * Mime Type: %s\n", new Object[] { ((ExtendedEncoding)localObject2).MimeType }));
      localStringBuilder.append(String.format(" * Codec: %s (%s)\n", new Object[] { ((ExtendedEncoding)localObject2).Format, ((ExtendedEncoding)localObject2).CodecID }));
      if ("Video".equals(((ExtendedEncoding)localObject2).Type))
      {
        localStringBuilder.append(String.format(" * Width: %s\n", new Object[] { Integer.valueOf(((ExtendedEncoding)localObject2).Width) }));
        localStringBuilder.append(String.format(" * Height: %s\n", new Object[] { Integer.valueOf(((ExtendedEncoding)localObject2).Height) }));
        localStringBuilder.append(String.format(" * Display Aspect Ratio: %s\n", new Object[] { ((ExtendedEncoding)localObject2).DisplayAspectRatio }));
        localStringBuilder.append(String.format(" * Frame Rate: %s (%s)\n", new Object[] { ((ExtendedEncoding)localObject2).FrameRate, ((ExtendedEncoding)localObject2).FrameRateMode }));
        localStringBuilder.append(String.format(" * Standard: %s\n", new Object[] { ((ExtendedEncoding)localObject2).Standard }));
      }
      localStringBuilder.append(String.format(" * Bitrate: %s (%s)\n", new Object[] { ((ExtendedEncoding)localObject2).BitrateString, ((ExtendedEncoding)localObject2).BitRateMode }));
      localStringBuilder.append(String.format(" * Duration: %s (%s)\n", new Object[] { Long.valueOf(((ExtendedEncoding)localObject2).Duration), CoreHelper.FormatTimeAsString(((ExtendedEncoding)localObject2).Duration) }));
      localStringBuilder.append(String.format(" * File Size: %s (%s)\n", new Object[] { Long.valueOf(((ExtendedEncoding)localObject2).FileSize), CoreHelper.GetFileLengthAsString(Long.valueOf(((ExtendedEncoding)localObject2).FileSize)) }));
      localStringBuilder.append(String.format(" * File Size String: %s\n", new Object[] { ((ExtendedEncoding)localObject2).FileSizeString }));
    }
  }
  
  public int EnclosureAlternativeID()
  {
    return LocalFileName().hashCode();
  }
  
  public Long EnclosureFileLength()
  {
    return this._Length;
  }
  
  public int EnclosureID()
  {
    if ((this._EnclosureID == 0) && (!StringUtils.IsNullOrEmpty(ParentItemID()))) {
      if (!RssFeedItem.IsGreaderId(ParentItemID())) {
        break label58;
      }
    }
    label58:
    for (this._EnclosureID = ParentItemID().hashCode();; this._EnclosureID = StringUtils.SafeParseInt(ParentItemID(), 0))
    {
      if (this._EnclosureID == 0) {
        this._EnclosureID = EnclosureRelativePathID();
      }
      return this._EnclosureID;
    }
  }
  
  public int EnclosureOldMountID()
  {
    if (LocalFileName().startsWith("/mnt")) {
      return LocalFileName().substring(4).hashCode();
    }
    return EnclosureAlternativeID();
  }
  
  public int EnclosureRelativePathID()
  {
    return RelativeLocalFileName().hashCode();
  }
  
  public String EnclosureSizeAsString()
  {
    return CoreHelper.GetFileLengthAsString(EnclosureFileLength());
  }
  
  public String FileName()
  {
    if (this.m_FileName == null)
    {
      localObject = FeedRepository.GetFeedById(this.Parent.OriginatingFeedID());
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (Object localObject = ((Feed)localObject).getName();; localObject = "")
    {
      this.m_FileName = CoreHelper.CreateFileNameFromUrl(this.Url, this.m_ForceUniqueEnclosureNames, (String)localObject, this.Parent.ItemID(), this.Type);
      return this.m_FileName;
    }
  }
  
  public Track GetLocalEnclosureTrack()
  {
    return FeedRepository.GetTrackByPathOrUrl(LocalFileName(), this.Url);
  }
  
  public boolean IsAllowed()
  {
    if (!Configuration.getHideUnsupportedFileTypes()) {
      return true;
    }
    return Track.IsSupportedExtension(TryGuessEnclosureExtension());
  }
  
  public boolean IsEnclosureInHistory()
  {
    return EnclosureDownloadHistory.HasEntryFor(this);
  }
  
  public boolean IsIgnorable()
  {
    if (StringUtils.IsNullOrEmpty(this.Url)) {}
    while (this.Url.indexOf("gravatar.com") >= 0) {
      return true;
    }
    return false;
  }
  
  public String LocalFileName()
  {
    if (this.m_FullPath == null) {
      this.m_FullPath = new File(this.DownloadPath, FileName()).getPath();
    }
    return this.m_FullPath;
  }
  
  public String ParentItemID()
  {
    if (this.m_ParentItemId == null) {
      if (this.Parent == null) {
        break label30;
      }
    }
    label30:
    for (this.m_ParentItemId = this.Parent.ItemID();; this.m_ParentItemId = "") {
      return this.m_ParentItemId;
    }
  }
  
  public int PlayableState()
  {
    return PlayableState(GetLocalEnclosureTrack());
  }
  
  public int PlayableState(Track paramTrack)
  {
    int i = 6;
    if (paramTrack != null)
    {
      if ((paramTrack.getDownloadStatus() == 2) || (paramTrack.getDownloadStatus() == 1) || (paramTrack.getDownloadStatus() == 6)) {
        i = 5;
      }
      do
      {
        return i;
        if (!paramTrack.HasDownloadStarted()) {
          break label62;
        }
        if (!paramTrack.IsFullyDownloaded()) {
          break;
        }
      } while (paramTrack.getCurrentPlayState() == 1);
      return 0;
      return 1;
      label62:
      if (paramTrack.getCurrentPlayState() == 1) {
        return 7;
      }
      return 2;
    }
    if (IsEnclosureInHistory()) {
      return 3;
    }
    return 4;
  }
  
  public Date PubDate()
  {
    if ((this.m_PubDate == null) && (this.Parent != null)) {
      this.m_PubDate = this.Parent.PubDate();
    }
    return this.m_PubDate;
  }
  
  public String RelativeLocalFileName()
  {
    return FeedRepository.ConvertToRelativePath(LocalFileName());
  }
  
  public void ResetParentItemId()
  {
    this.m_ParentItemId = null;
    this._EnclosureID = 0;
  }
  
  void VerifyAndFixEnclosure()
  {
    MediaFile.MediaFileType localMediaFileType;
    if ((!StringUtils.IsNullOrEmpty(this.Type)) && (!StringUtils.IsNullOrEmpty(this.Url)) && (MediaFile.isImageFileType(MediaFile.getFileTypeForMimeType(this.Type))))
    {
      localMediaFileType = MediaFile.getFileType(this.Url);
      if (localMediaFileType != null)
      {
        if (!MediaFile.isAudioFileType(localMediaFileType.fileType)) {
          break label63;
        }
        this.Type = "audio/mpeg";
      }
    }
    label63:
    while (!MediaFile.isVideoFileType(localMediaFileType.fileType)) {
      return;
    }
    this.Type = "video/mp4";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject instanceof RssEnclosure)) {}
      for (;;)
      {
        paramObject = (RssEnclosure)paramObject;
        if (paramObject != null) {
          break;
        }
        return false;
        paramObject = null;
      }
    } while ((this.Url != null) && (this.Url.equals(((RssEnclosure)paramObject).Url)) && (this.DownloadPath != null) && (this.DownloadPath.equals(((RssEnclosure)paramObject).DownloadPath)));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (!this.Url.equals(null)) {}
    for (int i = this.Url.hashCode();; i = 0)
    {
      if (!this.DownloadPath.equals(null)) {
        j = this.DownloadPath.hashCode();
      }
      return i + j * 29;
    }
  }
  
  public void setEnclosureFileLength(Long paramLong)
  {
    this._Length = paramLong;
  }
  
  public static class ExtendedEncoding
  {
    public String BitRateMode;
    public int Bitrate;
    public String BitrateString;
    public String CodecID;
    public String DisplayAspectRatio;
    public long Duration;
    public long FileSize;
    public String FileSizeString;
    public String Format;
    public String FrameRate;
    public String FrameRateMode;
    public int Height;
    public String MimeType;
    public String Standard;
    public String Type;
    public int Width;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/entities/RssEnclosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */