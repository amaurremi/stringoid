package mobi.beyondpod.rsscore.rss.entities;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.parsers.ImageParser;
import mobi.beyondpod.sync.ChangeTracker;

public class RssFeedItem
  implements Comparable<RssFeedItem>
{
  private static final int DESCRIPTION_SNAPSHOT_SIZE = 500;
  public String Author;
  public String Category;
  public String Description;
  public String EnclosureDuration;
  public String Guid;
  public RssItemImage Image;
  public boolean IsGoogleReadLocked = false;
  public String Link;
  public String OriginalPubDateString;
  public String OriginatingFeed;
  public String OriginatingFeedTitle = "";
  public String OriginatingItemId;
  public String ShortDescription;
  public CharSequence Title;
  public boolean Visible = true;
  private ArrayList<RssEnclosure> _Enclosures = new ArrayList();
  private Boolean _GoogleRead;
  private Boolean _GoogleStarred;
  private Boolean _InGoogleReadingList;
  private Boolean _IsMockItem = Boolean.valueOf(false);
  private String _ItemId;
  private ArrayList<String> _ItemImageUrls;
  private UUID _OriginatingFeedID;
  private final RssFeed _ParentFeed;
  private Date _PubDate;
  private String _SelectedItemImageUrl;
  private String _TLPItemId;
  
  public RssFeedItem(UUID paramUUID, String paramString)
  {
    this._OriginatingFeedID = paramUUID;
    this._ItemId = paramString;
    this._ParentFeed = null;
  }
  
  public RssFeedItem(RssFeed paramRssFeed)
  {
    this.Title = "";
    this.Link = "";
    this.Description = "";
    this.Author = "";
    this._PubDate = null;
    this.Category = "";
    this._ParentFeed = paramRssFeed;
  }
  
  public static RssFeedItem BuildMockRssItem(String paramString1, String paramString2, String paramString3, String paramString4, Date paramDate, String paramString5, String paramString6, String paramString7, Long paramLong)
  {
    if (StringUtils.IsNullOrEmpty(paramString1)) {
      paramString1 = null;
    }
    Feed localFeed;
    Object localObject;
    do
    {
      return paramString1;
      localFeed = FeedRepository.GetFeedByUrl(paramString1);
      RssFeed localRssFeed = new RssFeed();
      if (localFeed != null) {
        break;
      }
      localObject = UUID.randomUUID();
      localRssFeed.FeedID = ((UUID)localObject);
      localRssFeed.Link = paramString1;
      localObject = new RssFeedItem(localRssFeed);
      ((RssFeedItem)localObject)._IsMockItem = Boolean.valueOf(true);
      ((RssFeedItem)localObject)._PubDate = paramDate;
      ((RssFeedItem)localObject).Title = paramString3;
      ((RssFeedItem)localObject).Link = paramString4;
      ((RssFeedItem)localObject).Description = paramString5;
      if (((RssFeedItem)localObject).Description == null) {
        ((RssFeedItem)localObject).Description = "";
      }
      ((RssFeedItem)localObject)._ItemId = paramString2;
      ((RssFeedItem)localObject)._OriginatingFeedID = localRssFeed.FeedID;
      paramString1 = (String)localObject;
    } while (StringUtils.IsNullOrEmpty(paramString6));
    if (localFeed == null)
    {
      paramString1 = "";
      label145:
      if (localFeed != null) {
        break label220;
      }
    }
    label220:
    for (boolean bool = false;; bool = localFeed.getForceUniqueTrackNames())
    {
      paramString1 = new RssEnclosure(paramString1, bool);
      paramString1.Url = paramString6;
      paramString1.Type = paramString7;
      paramString1.setEnclosureFileLength(paramLong);
      paramString1.Parent = ((RssFeedItem)localObject);
      ((RssFeedItem)localObject)._Enclosures.add(paramString1);
      return (RssFeedItem)localObject;
      localObject = localFeed.ID();
      break;
      paramString1 = localFeed.getFeedPath();
      break label145;
    }
  }
  
  public static RssFeedItem BuildMockRssItem(Feed paramFeed, RssFeed paramRssFeed, Track paramTrack)
  {
    if (paramTrack == null) {
      return null;
    }
    RssFeedItem localRssFeedItem = new RssFeedItem(paramRssFeed);
    localRssFeedItem._IsMockItem = Boolean.valueOf(true);
    localRssFeedItem._PubDate = paramTrack.getLastModifiedDate();
    localRssFeedItem.Title = paramTrack.DisplayName();
    localRssFeedItem.Link = paramTrack.TrackPostUrl();
    localRssFeedItem.Description = paramTrack.TrackDescription();
    if (localRssFeedItem.Description == null) {
      localRssFeedItem.Description = "";
    }
    localRssFeedItem._ItemId = paramTrack.RssItemID();
    localRssFeedItem._OriginatingFeedID = paramRssFeed.FeedID;
    paramFeed = new RssEnclosure(paramTrack.getUrl(), paramFeed.getFeedPath(), Path.GetFileName(paramTrack.TrackPath()), paramTrack.ContentMimeType(), paramTrack.RssItemID(), paramTrack.getDownloadSize(), paramTrack.getLastModifiedDate(), null);
    paramFeed.Parent = localRssFeedItem;
    localRssFeedItem._Enclosures.add(paramFeed);
    return localRssFeedItem;
  }
  
  private String GenerateFingerprintItemDigest()
  {
    int k = 0;
    int i;
    if (this.Title != null)
    {
      i = this.Title.hashCode();
      if (this.Link == null) {
        break label67;
      }
    }
    label67:
    for (int j = this.Link.hashCode();; j = 0)
    {
      if (PubDate() != null) {
        k = PubDate().hashCode();
      }
      return Integer.toString((i * 29 + j) * 29 + k);
      i = 0;
      break;
    }
  }
  
  private String GenerateGuidItemDigest()
  {
    if (StringUtils.IsNullOrEmpty(this.Guid)) {
      return "<N/A>";
    }
    return Integer.toString(this.Guid.hashCode());
  }
  
  private String GenerateItemID()
  {
    if ((StringUtils.IsNullOrEmpty(this.OriginatingFeed)) || (StringUtils.IsNullOrEmpty(this.OriginatingItemId)))
    {
      if (this._ParentFeed == null) {}
      for (int i = 1;; i = this._ParentFeed.ItemIDGenerationAlgorithm) {
        switch (i)
        {
        default: 
          return this._TLPItemId;
        }
      }
      if (StringUtils.IsNullOrEmpty(this.Guid)) {
        return this._TLPItemId;
      }
      return GenerateGuidItemDigest();
    }
    return this.OriginatingItemId + "|" + this.OriginatingFeed;
  }
  
  public static boolean IsGreaderId(String paramString)
  {
    return (paramString != null) && (paramString.length() > 11);
  }
  
  public void CreateItemSnapshot(PrintWriter paramPrintWriter)
  {
    Object localObject3 = Enclosure();
    String str3 = ItemID();
    String str4 = this._TLPItemId;
    String str5 = GenerateGuidItemDigest();
    String str6 = ItemStateHistory.GetItemIdUsedForStatus(this);
    boolean bool = getRead();
    String str7 = this.Guid;
    Object localObject1;
    CharSequence localCharSequence;
    String str8;
    long l;
    String str1;
    label90:
    String str2;
    label100:
    Object localObject2;
    if (this.Guid != null)
    {
      localObject1 = Integer.valueOf(this.Guid.hashCode());
      localCharSequence = this.Title;
      str8 = this.Link;
      l = PubDate().getTime();
      if (localObject3 != null) {
        break label226;
      }
      str1 = "NONE";
      if (localObject3 != null) {
        break label236;
      }
      str2 = "NONE";
      if (localObject3 != null) {
        break label246;
      }
      localObject2 = "N/A";
      label110:
      if (localObject3 != null) {
        break label259;
      }
    }
    label226:
    label236:
    label246:
    label259:
    for (localObject3 = "N/A";; localObject3 = Integer.valueOf(((RssEnclosure)localObject3).EnclosureAlternativeID()))
    {
      paramPrintWriter.print(String.format("ItemID:>%s<, TLPID:>%s<, GUIDID:>%s<, Read Status:%s, Read:%s === Guid:>%s< (%s), TLP [Title:>%s<, Link:>%s<, PubDate:>%s<], Enclosure File Name:>%s<, Enclosure URL:>%s<, In History: %s, EnclosureID:>%s<\r\n", new Object[] { str3, str4, str5, str6, Boolean.valueOf(bool), str7, localObject1, localCharSequence, str8, Long.valueOf(l), str1, str2, localObject2, localObject3 }));
      return;
      localObject1 = "N/A";
      break;
      str1 = ((RssEnclosure)localObject3).FileName();
      break label90;
      str2 = ((RssEnclosure)localObject3).Url;
      break label100;
      localObject2 = Boolean.valueOf(EnclosureDownloadHistory.HasEntryFor((RssEnclosure)localObject3));
      break label110;
    }
  }
  
  public CharSequence[] DumpEnclosures()
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[this._Enclosures.size()];
    int i = 0;
    if (i == this._Enclosures.size()) {
      return arrayOfCharSequence;
    }
    Object localObject = (RssEnclosure)this._Enclosures.get(i);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(((RssEnclosure)localObject).Type.replace("/", " - ")));
    if ((((RssEnclosure)localObject).EnclosureFileLength() != null) && (((RssEnclosure)localObject).EnclosureFileLength().longValue() > 0L)) {}
    for (localObject = " " + ((RssEnclosure)localObject).EnclosureSizeAsString();; localObject = "")
    {
      arrayOfCharSequence[i] = ((String)localObject);
      i += 1;
      break;
    }
  }
  
  public CharSequence DumpItemDetails()
  {
    StringBuilder localStringBuilder;
    boolean bool;
    int i;
    if (Enclosure() != null)
    {
      localStringBuilder = Enclosure().DumpEnclosure();
      localStringBuilder.append("\n");
      localStringBuilder.append("Post Details");
      bool = IsGreaderId(ItemID());
      localStringBuilder.append("\n  • Fingerprint Type: ");
      if (bool) {
        break label277;
      }
      if (this._ParentFeed != null) {
        break label255;
      }
      i = 1;
      label60:
      if (i != 2) {
        break label266;
      }
      localStringBuilder.append("GUID");
      label73:
      localStringBuilder.append("\n  • ItemID: ");
      localStringBuilder.append(ItemID());
      if (bool)
      {
        localStringBuilder.append(" (");
        localStringBuilder.append(ItemID().hashCode());
        localStringBuilder.append(")");
      }
      if ((this._IsMockItem.booleanValue()) || (bool)) {
        break label299;
      }
      if (this.Guid == null) {
        break label288;
      }
      localStringBuilder.append("\n  • GUID: ");
      localStringBuilder.append(this.Guid);
      localStringBuilder.append(" (");
      localStringBuilder.append(this.Guid.hashCode());
      localStringBuilder.append(")");
    }
    for (;;)
    {
      if (Enclosure() != null)
      {
        localStringBuilder.append("\n  • EnclosureID: ");
        localStringBuilder.append(Enclosure().EnclosureID());
        if (!bool)
        {
          localStringBuilder.append("\n  • ItemID Hash: ");
          localStringBuilder.append(ItemID().hashCode());
        }
      }
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      break;
      label255:
      i = this._ParentFeed.ItemIDGenerationAlgorithm;
      break label60;
      label266:
      localStringBuilder.append("TIP");
      break label73;
      label277:
      localStringBuilder.append("GReader");
      break label73;
      label288:
      localStringBuilder.append("\n  • GUID Not Avaialble!");
      continue;
      label299:
      if (this._IsMockItem.booleanValue()) {
        localStringBuilder.append("\n  • Episode is Archived");
      }
    }
  }
  
  public RssEnclosure Enclosure()
  {
    if (this._ParentFeed.IgnoreEnclosures) {}
    int i;
    do
    {
      return null;
      i = Math.min(this._ParentFeed.PreferredEnclosureIndex, this._Enclosures.size() - 1);
    } while (i < 0);
    return (RssEnclosure)this._Enclosures.get(i);
  }
  
  public boolean InGoogleReadingList()
  {
    return (this._InGoogleReadingList != null) && (this._InGoogleReadingList.booleanValue());
  }
  
  public boolean IsGoogleRead()
  {
    if (Configuration.IgnoreGoogleReaderReadStatus()) {}
    while ((this._GoogleRead == null) || (!this._GoogleRead.booleanValue())) {
      return false;
    }
    return true;
  }
  
  public boolean IsGoogleStarred()
  {
    return (this._GoogleStarred != null) && (this._GoogleStarred.booleanValue());
  }
  
  public boolean IsItemImageUsingParentFeedImage()
  {
    return (this._SelectedItemImageUrl != null) && (this._SelectedItemImageUrl.startsWith("#"));
  }
  
  public Boolean IsMockItem()
  {
    return this._IsMockItem;
  }
  
  public ArrayList<RssEnclosure> ItemEnclosures()
  {
    return this._Enclosures;
  }
  
  public String ItemID()
  {
    if (this._TLPItemId == null) {
      this._TLPItemId = GenerateFingerprintItemDigest();
    }
    if (this._ItemId == null) {
      this._ItemId = GenerateItemID();
    }
    return this._ItemId;
  }
  
  public ArrayList<String> ItemImageUrls()
  {
    if (this._ItemImageUrls != null) {
      return this._ItemImageUrls;
    }
    this._ItemImageUrls = new ArrayList();
    if (this.Image != null) {
      ImageParser.CheckAndAddImageUrl(this._ItemImageUrls, this.Image.Url);
    }
    if (this._Enclosures.size() > 0)
    {
      localObject = (RssEnclosure)this._Enclosures.get(0);
      if (MediaFile.isImageFileType(MediaFile.getFileTypeForMimeType(((RssEnclosure)localObject).Type))) {
        ImageParser.CheckAndAddImageUrl(this._ItemImageUrls, ((RssEnclosure)localObject).Url);
      }
    }
    Object localObject = ImageParser.ParseImagesFromStringWithRegEx(this.Description);
    this._ItemImageUrls.addAll((Collection)localObject);
    if (this._ItemImageUrls.size() == 0) {
      setSelectedItemImageUrlToUseParentFeedImage();
    }
    return this._ItemImageUrls;
  }
  
  public UUID OriginatingFeedID()
  {
    if (this._OriginatingFeedID != null) {
      return this._OriginatingFeedID;
    }
    return this._ParentFeed.FeedID;
  }
  
  public RssFeed ParentFeed()
  {
    return this._ParentFeed;
  }
  
  public Date PubDate()
  {
    if (this._PubDate == null)
    {
      if (StringUtils.IsNullOrEmpty(this.OriginalPubDateString)) {
        return null;
      }
      this.OriginalPubDateString = this.OriginalPubDateString.trim();
      if (this._ParentFeed._FeedItemDateFormat == null) {
        this._ParentFeed._FeedItemDateFormat = DateTime.TryFindFormatOfRFC822Time(this.OriginalPubDateString);
      }
      this._PubDate = DateTime.TryParseRFC822Time(this.OriginalPubDateString, this._ParentFeed._FeedItemDateFormat);
    }
    return this._PubDate;
  }
  
  public String ResolveOriginatingFeedTitle()
  {
    if (!StringUtils.EqualsIgnoreCase(this._ParentFeed.Title, this.OriginatingFeedTitle)) {
      return this.OriginatingFeedTitle;
    }
    return "";
  }
  
  public String SelectedItemImageUrl()
  {
    return this._SelectedItemImageUrl;
  }
  
  public void SetEnclosure(RssEnclosure paramRssEnclosure)
  {
    if (paramRssEnclosure.IsIgnorable()) {}
    RssEnclosure localRssEnclosure;
    do
    {
      return;
      paramRssEnclosure.VerifyAndFixEnclosure();
      Iterator localIterator = this._Enclosures.iterator();
      do
      {
        if (!localIterator.hasNext())
        {
          paramRssEnclosure.Parent = this;
          if (!paramRssEnclosure.IsAllowed()) {
            break;
          }
          this._Enclosures.add(paramRssEnclosure);
          return;
        }
        localRssEnclosure = (RssEnclosure)localIterator.next();
      } while (!paramRssEnclosure.Url.equals(localRssEnclosure.Url));
      if ((paramRssEnclosure.EnclosureFileLength() != null) && ((localRssEnclosure.EnclosureFileLength() == null) || (paramRssEnclosure.EnclosureFileLength().longValue() > localRssEnclosure.EnclosureFileLength().longValue()))) {
        localRssEnclosure.setEnclosureFileLength(paramRssEnclosure.EnclosureFileLength());
      }
    } while ((!StringUtils.IsNullOrEmpty(localRssEnclosure.Type)) || (StringUtils.IsNullOrEmpty(paramRssEnclosure.Type)));
    localRssEnclosure.Type = paramRssEnclosure.Type;
  }
  
  public void SetOriginatingFeedID(UUID paramUUID)
  {
    this._OriginatingFeedID = paramUUID;
  }
  
  public String ShortTaglessDescription()
  {
    if (this.ShortDescription == null) {
      this.ShortDescription = CoreHelper.CleanHtmlTags(this.Description, 500, false).toString();
    }
    return this.ShortDescription;
  }
  
  public void SyncDownloadedWithRead()
  {
    if (Enclosure() == null) {}
    boolean bool;
    do
    {
      Track localTrack;
      do
      {
        return;
        localTrack = Enclosure().GetLocalEnclosureTrack();
      } while ((localTrack != null) && (localTrack.Exists()));
      bool = Enclosure().IsEnclosureInHistory();
      if ((bool) && (!getRead())) {
        EnclosureDownloadHistory.RemoveEnclosure(Enclosure(), true);
      }
    } while ((bool) || (!getRead()));
    EnclosureDownloadHistory.AddEnclosure(Enclosure(), true);
  }
  
  public void SyncPlayedWithRead()
  {
    if (Enclosure() == null) {}
    Track localTrack;
    boolean bool;
    do
    {
      do
      {
        return;
        localTrack = Enclosure().GetLocalEnclosureTrack();
      } while (localTrack == null);
      bool = localTrack.IsPlayed();
      if ((bool) && (!getRead())) {
        localTrack.ClearPlayed();
      }
    } while ((bool) || (!getRead()));
    localTrack.MarkPlayed();
  }
  
  public CharSequence TaglessDescription()
  {
    return CoreHelper.CleanHtmlTags(this.Description, 500, true);
  }
  
  public void clearGoogleRead()
  {
    this._GoogleRead = null;
  }
  
  public int compareTo(RssFeedItem paramRssFeedItem)
  {
    if (paramRssFeedItem == null) {}
    do
    {
      return -1;
      if ((PubDate() == null) && (paramRssFeedItem.PubDate() == null)) {
        return 0;
      }
    } while (paramRssFeedItem.PubDate() == null);
    if (PubDate() == null) {
      return 1;
    }
    return paramRssFeedItem.PubDate().compareTo(PubDate());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof RssFeedItem)) {}
    for (;;)
    {
      return equals((RssFeedItem)paramObject);
      paramObject = null;
    }
  }
  
  public boolean equals(RssFeedItem paramRssFeedItem)
  {
    if (paramRssFeedItem == null) {}
    while (((this.Title != null) && (!this.Title.equals(paramRssFeedItem.Title))) || ((this.Link != null) && (!this.Link.equals(paramRssFeedItem.Link))) || ((PubDate() != null) && (!PubDate().equals(paramRssFeedItem.PubDate())))) {
      return false;
    }
    return true;
  }
  
  public boolean getRead()
  {
    if (ItemStateHistory.HasStatusFor(this)) {
      return ItemStateHistory.IsItemRead(this);
    }
    return IsGoogleRead();
  }
  
  public boolean getStarred()
  {
    if (ItemStateHistory.HasStatusFor(this)) {
      return ItemStateHistory.IsItemStarred(this);
    }
    return IsGoogleStarred();
  }
  
  public void rebuildItemId()
  {
    this._ItemId = null;
    ItemID();
    if (Enclosure() != null) {
      Enclosure().ResetParentItemId();
    }
  }
  
  public void setGoogleRead()
  {
    this._GoogleRead = Boolean.valueOf(true);
  }
  
  public void setGoogleStarred()
  {
    this._GoogleStarred = Boolean.valueOf(true);
  }
  
  public void setInGoogleReadingList()
  {
    this._InGoogleReadingList = Boolean.valueOf(true);
  }
  
  public void setPubDate(Date paramDate)
  {
    this._PubDate = paramDate;
  }
  
  public void setRead(boolean paramBoolean)
  {
    if (ItemID() == null) {
      break label7;
    }
    label7:
    while ((!paramBoolean) && (this.IsGoogleReadLocked) && (!Configuration.IgnoreGoogleReaderReadStatus())) {
      return;
    }
    if (paramBoolean)
    {
      ItemStateHistory.SetItemAsRead(this);
      ChangeTracker.AddLocalPostChange(12, this);
      label39:
      clearGoogleRead();
      if (!OriginatingFeedID().equals(this._ParentFeed.FeedID)) {
        break label101;
      }
      this._ParentFeed.SyncOwnerFeedReadStatus();
    }
    for (;;)
    {
      if (Configuration.SetAsDownloadedOnMarkRead()) {
        SyncDownloadedWithRead();
      }
      if (!Configuration.SetAsPlayedOnMarkRead()) {
        break;
      }
      SyncPlayedWithRead();
      return;
      ItemStateHistory.ClearItemReadStatus(this);
      ChangeTracker.AddLocalPostChange(13, this);
      break label39;
      label101:
      Feed localFeed = FeedRepository.GetFeedById(OriginatingFeedID());
      if (localFeed != null) {
        RssFeedCache.SyncFeedReadStatus(localFeed);
      }
    }
  }
  
  public void setSelectedItemImageUrl(String paramString)
  {
    this._SelectedItemImageUrl = paramString;
  }
  
  public void setSelectedItemImageUrlToUseParentFeedImage()
  {
    this._SelectedItemImageUrl = ("#" + OriginatingFeedID().toString());
  }
  
  public void setStarred(boolean paramBoolean)
  {
    if (ItemID() == null) {}
    while (!InGoogleReadingList()) {
      return;
    }
    if (paramBoolean)
    {
      ItemStateHistory.SetItemAsStarred(this);
      ChangeTracker.AddLocalPostChange(10, this);
    }
    for (;;)
    {
      this._GoogleStarred = null;
      return;
      ItemStateHistory.ClearItemStarredStatus(this);
      ChangeTracker.AddLocalPostChange(11, this);
    }
  }
  
  public String toString()
  {
    return String.format("%s (R:%s, S:%s, gR:%s, gS:%s) %s ", new Object[] { PubDate(), Boolean.valueOf(getRead()), Boolean.valueOf(getStarred()), this._GoogleRead, this._GoogleStarred, ItemID() });
  }
  
  public static class RssItemImage
  {
    public int Height = 0;
    public String Url;
    public int Width = 0;
    
    public boolean HasSize()
    {
      return (this.Width > 0) && (this.Height > 0);
    }
    
    public boolean IsValid()
    {
      return !StringUtils.IsNullOrEmpty(this.Url);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/entities/RssFeedItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */