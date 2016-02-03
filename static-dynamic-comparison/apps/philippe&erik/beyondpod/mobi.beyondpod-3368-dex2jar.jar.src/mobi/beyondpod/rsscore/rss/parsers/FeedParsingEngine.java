package mobi.beyondpod.rsscore.rss.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Date;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DetectEncoding;

public class FeedParsingEngine
{
  private static final String TAG = FeedParsingEngine.class.getSimpleName();
  private DetectEncoding de = new DetectEncoding(this.defaultEncoding);
  private String defaultEncoding = "utf-8";
  private String encoding;
  boolean error = false;
  
  public static void ParseFeedFile(File paramFile, FeedParseData paramFeedParseData)
  {
    new FeedParsingEngine().ParseFile(paramFile, paramFeedParseData);
  }
  
  /* Error */
  private static void ParseFeedJSONIntenral(InputStreamReader paramInputStreamReader, FeedParseData paramFeedParseData)
  {
    // Byte code:
    //   0: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   3: ldc 51
    //   5: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 62	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseStarted	()V
    //   12: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: new 70	mobi/beyondpod/rsscore/rss/parsers/json/FeedlyJsonParser
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 73	mobi/beyondpod/rsscore/rss/parsers/json/FeedlyJsonParser:<init>	(Lmobi/beyondpod/rsscore/rss/parsers/FeedParseData;)V
    //   24: new 75	com/google/gson/stream/JsonReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 78	com/google/gson/stream/JsonReader:<init>	(Ljava/io/Reader;)V
    //   32: invokevirtual 82	mobi/beyondpod/rsscore/rss/parsers/json/FeedlyJsonParser:parse	(Lcom/google/gson/stream/JsonReader;)V
    //   35: aload_0
    //   36: ifnull +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   43: aload_1
    //   44: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   47: lload_2
    //   48: lsub
    //   49: putfield 91	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseDuration	J
    //   52: aload_1
    //   53: invokevirtual 94	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseCompleted	()V
    //   56: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   59: ldc 96
    //   61: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: return
    //   65: astore 4
    //   67: aload_1
    //   68: aload 4
    //   70: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   81: aload_1
    //   82: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   85: lload_2
    //   86: lsub
    //   87: putfield 91	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseDuration	J
    //   90: aload_1
    //   91: invokevirtual 94	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseCompleted	()V
    //   94: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   97: ldc 96
    //   99: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: return
    //   103: astore_0
    //   104: aload_1
    //   105: getfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   108: ifnonnull -27 -> 81
    //   111: aload_1
    //   112: aload_0
    //   113: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   116: goto -35 -> 81
    //   119: astore 4
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   129: aload_1
    //   130: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   133: lload_2
    //   134: lsub
    //   135: putfield 91	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseDuration	J
    //   138: aload_1
    //   139: invokevirtual 94	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseCompleted	()V
    //   142: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   145: ldc 96
    //   147: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload 4
    //   152: athrow
    //   153: astore_0
    //   154: aload_1
    //   155: getfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   158: ifnonnull -29 -> 129
    //   161: aload_1
    //   162: aload_0
    //   163: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   166: goto -37 -> 129
    //   169: astore_0
    //   170: aload_1
    //   171: getfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   174: ifnonnull -131 -> 43
    //   177: aload_1
    //   178: aload_0
    //   179: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   182: goto -139 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramInputStreamReader	InputStreamReader
    //   0	185	1	paramFeedParseData	FeedParseData
    //   15	119	2	l	long
    //   65	4	4	localException	Exception
    //   119	32	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	35	65	java/lang/Exception
    //   77	81	103	java/lang/Exception
    //   16	35	119	finally
    //   67	73	119	finally
    //   125	129	153	java/lang/Exception
    //   39	43	169	java/lang/Exception
  }
  
  /* Error */
  private static void ParseFeedXMLIntenral(InputStreamReader paramInputStreamReader, FeedParseData paramFeedParseData)
  {
    // Byte code:
    //   0: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   3: ldc 103
    //   5: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokevirtual 62	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseStarted	()V
    //   12: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: invokestatic 109	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   19: invokevirtual 113	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   22: invokevirtual 119	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   25: astore 4
    //   27: new 121	mobi/beyondpod/rsscore/rss/parsers/RootParser
    //   30: dup
    //   31: aload 4
    //   33: aload_1
    //   34: invokespecial 124	mobi/beyondpod/rsscore/rss/parsers/RootParser:<init>	(Lorg/xml/sax/XMLReader;Lmobi/beyondpod/rsscore/rss/parsers/FeedParseData;)V
    //   37: astore 5
    //   39: aload 4
    //   41: aload 5
    //   43: invokeinterface 130 2 0
    //   48: aload 4
    //   50: aload 5
    //   52: invokeinterface 134 2 0
    //   57: aload 4
    //   59: ldc -120
    //   61: aload 5
    //   63: invokeinterface 140 3 0
    //   68: aload 4
    //   70: new 142	org/xml/sax/InputSource
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 143	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   78: invokeinterface 146 2 0
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   91: aload_1
    //   92: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   95: lload_2
    //   96: lsub
    //   97: putfield 91	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseDuration	J
    //   100: aload_1
    //   101: invokevirtual 94	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseCompleted	()V
    //   104: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   107: ldc -108
    //   109: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: return
    //   113: astore 4
    //   115: aload_1
    //   116: aload 4
    //   118: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   129: aload_1
    //   130: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   133: lload_2
    //   134: lsub
    //   135: putfield 91	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseDuration	J
    //   138: aload_1
    //   139: invokevirtual 94	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseCompleted	()V
    //   142: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   145: ldc -108
    //   147: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: return
    //   151: astore_0
    //   152: aload_1
    //   153: getfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   156: ifnonnull -27 -> 129
    //   159: aload_1
    //   160: aload_0
    //   161: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   164: goto -35 -> 129
    //   167: astore 4
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   177: aload_1
    //   178: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   181: lload_2
    //   182: lsub
    //   183: putfield 91	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseDuration	J
    //   186: aload_1
    //   187: invokevirtual 94	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:NotifyParseCompleted	()V
    //   190: getstatic 22	mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine:TAG	Ljava/lang/String;
    //   193: ldc -108
    //   195: invokestatic 57	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 4
    //   200: athrow
    //   201: astore_0
    //   202: aload_1
    //   203: getfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   206: ifnonnull -29 -> 177
    //   209: aload_1
    //   210: aload_0
    //   211: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   214: goto -37 -> 177
    //   217: astore_0
    //   218: aload_1
    //   219: getfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   222: ifnonnull -131 -> 91
    //   225: aload_1
    //   226: aload_0
    //   227: putfield 100	mobi/beyondpod/rsscore/rss/parsers/FeedParseData:ParseException	Ljava/lang/Exception;
    //   230: goto -139 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramInputStreamReader	InputStreamReader
    //   0	233	1	paramFeedParseData	FeedParseData
    //   15	167	2	l	long
    //   25	44	4	localXMLReader	org.xml.sax.XMLReader
    //   113	4	4	localException	Exception
    //   167	32	4	localObject	Object
    //   37	25	5	localRootParser	RootParser
    // Exception table:
    //   from	to	target	type
    //   16	83	113	java/lang/Exception
    //   125	129	151	java/lang/Exception
    //   16	83	167	finally
    //   115	121	167	finally
    //   173	177	201	java/lang/Exception
    //   87	91	217	java/lang/Exception
  }
  
  private void ParseFile(File paramFile, FeedParseData paramFeedParseData)
  {
    try
    {
      Object localObject = new FileInputStream(paramFile);
      CoreHelper.WriteTraceEntry(TAG, "Started level " + paramFeedParseData.ParseLevel + " parsing of " + paramFile.getName());
      if (this.encoding == null) {
        this.encoding = this.de.detect(paramFile.getPath());
      }
      this.de.stripBOM((InputStream)localObject);
      Charset.forName(this.de.alias(this.encoding)).newDecoder().onMalformedInput(CodingErrorAction.REPORT);
      localObject = new InputStreamReader((InputStream)localObject, this.encoding);
      if (this.de.isJson()) {
        ParseFeedJSONIntenral((InputStreamReader)localObject, paramFeedParseData);
      }
      for (;;)
      {
        paramFeedParseData.RssFeed.LastRetrievalDate = new Date(paramFile.lastModified());
        return;
        ParseFeedXMLIntenral((InputStreamReader)localObject, paramFeedParseData);
      }
      return;
    }
    catch (Exception paramFile)
    {
      paramFeedParseData.ParseException = paramFile;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/FeedParsingEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */