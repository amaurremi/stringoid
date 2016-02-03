package mobi.beyondpod.rsscore.rss.parsers;

import java.util.HashMap;
import org.xml.sax.XMLReader;

public class RootParser
  extends ParserBase
{
  public FeedParseData ParseData;
  
  public RootParser(XMLReader paramXMLReader, FeedParseData paramFeedParseData)
  {
    super(paramXMLReader);
    this.ParseData = paramFeedParseData;
    this._handlers.put("rss", new RssFeedParser(this));
    this._handlers.put("feed", new AtomFeedParser(this));
    this._handlers.put("opml", new OpmlFeedParser(this));
    this._handlers.put("rdf:RDF", new RdfFeedParser(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/RootParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */