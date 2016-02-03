package mobi.beyondpod.rsscore.rss.parsers.json;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.rsscore.rss.parsers.ParserBase;
import mobi.beyondpod.rsscore.rss.parsers.ParserUtils;
import mobi.beyondpod.rsscore.rss.parsers.ParserUtils.TooManyItemsException;

public class FeedlyJsonParser
{
  private TimeSpan _LockCutOff = TimeSpan.fromDays(31.0D);
  private FeedParseData _ParseData;
  JsonReader _Reader;
  
  public FeedlyJsonParser(FeedParseData paramFeedParseData)
  {
    this._ParseData = paramFeedParseData;
  }
  
  protected static void HandleEndOfRssFeedItem(FeedParseData paramFeedParseData, RssFeedItem paramRssFeedItem)
    throws IOException
  {
    ParserUtils.HandleEndOfRssFeedItem(paramFeedParseData, paramRssFeedItem);
    if (paramFeedParseData.RssFeed.Items.size() >= paramFeedParseData.MaxItemsToParse) {
      throw new IOException("Feed has too many items! Loaded the first " + paramFeedParseData.MaxItemsToParse, new ParserUtils.TooManyItemsException());
    }
  }
  
  private boolean isStarred(ArrayList<Tag> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    do
    {
      if (!paramArrayList.hasNext()) {
        return false;
      }
    } while (!((Tag)paramArrayList.next()).Id.endsWith("global.saved"));
    return true;
  }
  
  private AlternateLink readAlternateLink(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginObject();
    AlternateLink localAlternateLink = new AlternateLink(null);
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return localAlternateLink;
      }
      String str = paramJsonReader.nextName();
      if (str.equals("href")) {
        localAlternateLink.Href = paramJsonReader.nextString();
      } else if (str.equals("type")) {
        localAlternateLink.Type = paramJsonReader.nextString();
      } else {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private ArrayList<AlternateLink> readAlternateLinks(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginArray();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endArray();
        return localArrayList;
      }
      localArrayList.add(readAlternateLink(paramJsonReader));
    }
  }
  
  private void readEnclosure(JsonReader paramJsonReader, RssFeedItem paramRssFeedItem)
    throws IOException
  {
    RssEnclosure localRssEnclosure = new RssEnclosure(this._ParseData.EnclosureDownloadPath, this._ParseData.ForceUniqueEnclosureNames);
    paramJsonReader.beginObject();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        paramRssFeedItem.SetEnclosure(localRssEnclosure);
        return;
      }
      String str = paramJsonReader.nextName();
      if (str.equals("href")) {
        localRssEnclosure.Url = paramJsonReader.nextString();
      } else if (str.equals("length")) {
        localRssEnclosure.setEnclosureFileLength(Long.valueOf(paramJsonReader.nextLong()));
      } else if (str.equals("type")) {
        localRssEnclosure.Type = paramJsonReader.nextString();
      } else {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private void readEnclosures(JsonReader paramJsonReader, RssFeedItem paramRssFeedItem)
    throws IOException
  {
    paramJsonReader.beginArray();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endArray();
        return;
      }
      readEnclosure(paramJsonReader, paramRssFeedItem);
    }
  }
  
  private void readFeedItems(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginArray();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endArray();
        return;
      }
      readItem(paramJsonReader);
    }
  }
  
  private void readItem(JsonReader paramJsonReader)
    throws IOException
  {
    RssFeedItem localRssFeedItem = new RssFeedItem(this._ParseData.RssFeed);
    paramJsonReader.beginObject();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        setReadLockedIfNeeded(localRssFeedItem);
        localRssFeedItem.setInGoogleReadingList();
        ParserUtils.HandleEndOfRssFeedItem(this._ParseData, localRssFeedItem);
        return;
      }
      Object localObject = paramJsonReader.nextName();
      if (((String)localObject).equals("title"))
      {
        localRssFeedItem.Title = ParserBase.CleanRTLDivs(paramJsonReader.nextString());
      }
      else if (((String)localObject).equals("published"))
      {
        localRssFeedItem.setPubDate(new Date(paramJsonReader.nextLong()));
      }
      else if ((((String)localObject).equals("updated")) && (localRssFeedItem.PubDate() == null))
      {
        localRssFeedItem.setPubDate(new Date(paramJsonReader.nextLong()));
      }
      else if (((String)localObject).equals("alternate"))
      {
        localObject = readAlternateLinks(paramJsonReader);
        if (((ArrayList)localObject).size() > 0) {
          localRssFeedItem.Link = ((AlternateLink)((ArrayList)localObject).get(0)).Href;
        }
      }
      else if (((String)localObject).equals("tags"))
      {
        if (isStarred(readTags(paramJsonReader))) {
          localRssFeedItem.setGoogleStarred();
        }
      }
      else if (((String)localObject).equals("id"))
      {
        localRssFeedItem.OriginatingItemId = paramJsonReader.nextString();
        localRssFeedItem.Guid = localRssFeedItem.OriginatingItemId;
      }
      else if (((String)localObject).equals("origin"))
      {
        readItemOrigin(paramJsonReader, localRssFeedItem);
      }
      else if (((String)localObject).equals("unread"))
      {
        if (!paramJsonReader.nextBoolean()) {
          localRssFeedItem.setGoogleRead();
        }
      }
      else if ((((String)localObject).equals("summary")) && (this._ParseData.ParseLevel == 0))
      {
        readItemContent(paramJsonReader, localRssFeedItem, true);
      }
      else if ((((String)localObject).equals("content")) && (this._ParseData.ParseLevel == 0))
      {
        readItemContent(paramJsonReader, localRssFeedItem, false);
      }
      else if ((((String)localObject).equals("enclosure")) && ((this._ParseData.ParseLevel == 2) || (this._ParseData.ParseLevel == 0)))
      {
        readEnclosures(paramJsonReader, localRssFeedItem);
      }
      else
      {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private void readItemContent(JsonReader paramJsonReader, RssFeedItem paramRssFeedItem, boolean paramBoolean)
    throws IOException
  {
    paramJsonReader.beginObject();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return;
      }
      if (paramJsonReader.nextName().equals("content"))
      {
        String str = paramJsonReader.nextString();
        if (!StringUtils.IsNullOrEmpty(str)) {
          if (paramBoolean)
          {
            if (StringUtils.IsNullOrEmpty(paramRssFeedItem.Description)) {
              paramRssFeedItem.Description = str;
            }
          }
          else {
            paramRssFeedItem.Description = str;
          }
        }
      }
      else
      {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private void readItemOrigin(JsonReader paramJsonReader, RssFeedItem paramRssFeedItem)
    throws IOException
  {
    paramJsonReader.beginObject();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return;
      }
      String str = paramJsonReader.nextName();
      if (str.equals("streamId")) {
        paramRssFeedItem.OriginatingFeed = paramJsonReader.nextString();
      } else if (str.equals("title")) {
        paramRssFeedItem.OriginatingFeedTitle = ParserBase.CleanRTLDivs(paramJsonReader.nextString());
      } else {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private void readRootObject(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginObject();
    this._ParseData.ParsedFeedType = 6;
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return;
      }
      Object localObject = paramJsonReader.nextName();
      if (((String)localObject).equals("title"))
      {
        this._ParseData.RssFeed.Title = paramJsonReader.nextString();
      }
      else
      {
        if (((String)localObject).equals("direction"))
        {
          localObject = paramJsonReader.nextString();
          RssFeed localRssFeed = this._ParseData.RssFeed;
          if ((localObject != null) && ("rtl".equals(localObject))) {}
          for (boolean bool = true;; bool = false)
          {
            localRssFeed.RTL = bool;
            break;
          }
        }
        if (((String)localObject).equals("updated"))
        {
          this._ParseData.RssFeed.PubDate = new Date(paramJsonReader.nextLong());
        }
        else if (((String)localObject).equals("alternate"))
        {
          localObject = readAlternateLinks(paramJsonReader);
          if (((ArrayList)localObject).size() > 0) {
            this._ParseData.RssFeed.Link = ((AlternateLink)((ArrayList)localObject).get(0)).Href;
          }
        }
        else if (((String)localObject).equals("items"))
        {
          readFeedItems(paramJsonReader);
        }
        else
        {
          paramJsonReader.skipValue();
        }
      }
    }
  }
  
  private Tag readTag(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginObject();
    Tag localTag = new Tag(null);
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endObject();
        return localTag;
      }
      String str = paramJsonReader.nextName();
      if (str.equals("id")) {
        localTag.Id = paramJsonReader.nextString();
      } else if (str.equals("label")) {
        localTag.Label = paramJsonReader.nextString();
      } else {
        paramJsonReader.skipValue();
      }
    }
  }
  
  private ArrayList<Tag> readTags(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.beginArray();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (!paramJsonReader.hasNext())
      {
        paramJsonReader.endArray();
        return localArrayList;
      }
      localArrayList.add(readTag(paramJsonReader));
    }
  }
  
  private void setReadLockedIfNeeded(RssFeedItem paramRssFeedItem)
  {
    if (paramRssFeedItem.PubDate() == null) {}
    while ((!paramRssFeedItem.IsGoogleRead()) || (!paramRssFeedItem.PubDate().before(this._LockCutOff.SubstractFrom(new Date())))) {
      return;
    }
    paramRssFeedItem.IsGoogleReadLocked = true;
  }
  
  public void parse(JsonReader paramJsonReader)
    throws IOException
  {
    readRootObject(paramJsonReader);
  }
  
  private static class AlternateLink
  {
    public String Href;
    public String Type;
  }
  
  private static class Tag
  {
    public String Id;
    public String Label;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/json/FeedlyJsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */