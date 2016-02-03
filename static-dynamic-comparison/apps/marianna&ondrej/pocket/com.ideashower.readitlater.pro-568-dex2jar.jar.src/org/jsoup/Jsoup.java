package org.jsoup;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class Jsoup
{
  public static String clean(String paramString1, String paramString2, Whitelist paramWhitelist)
  {
    paramString1 = parseBodyFragment(paramString1, paramString2);
    return new Cleaner(paramWhitelist).clean(paramString1).body().html();
  }
  
  public static String clean(String paramString1, String paramString2, Whitelist paramWhitelist, Document.OutputSettings paramOutputSettings)
  {
    paramString1 = parseBodyFragment(paramString1, paramString2);
    paramString1 = new Cleaner(paramWhitelist).clean(paramString1);
    paramString1.outputSettings(paramOutputSettings);
    return paramString1.body().html();
  }
  
  public static String clean(String paramString, Whitelist paramWhitelist)
  {
    return clean(paramString, "", paramWhitelist);
  }
  
  public static Connection connect(String paramString)
  {
    return HttpConnection.connect(paramString);
  }
  
  public static boolean isValid(String paramString, Whitelist paramWhitelist)
  {
    paramString = parseBodyFragment(paramString, "");
    return new Cleaner(paramWhitelist).isValid(paramString);
  }
  
  public static Document parse(File paramFile, String paramString)
  {
    return DataUtil.load(paramFile, paramString, paramFile.getAbsolutePath());
  }
  
  public static Document parse(File paramFile, String paramString1, String paramString2)
  {
    return DataUtil.load(paramFile, paramString1, paramString2);
  }
  
  public static Document parse(InputStream paramInputStream, String paramString1, String paramString2)
  {
    return DataUtil.load(paramInputStream, paramString1, paramString2);
  }
  
  public static Document parse(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser)
  {
    return DataUtil.load(paramInputStream, paramString1, paramString2, paramParser);
  }
  
  public static Document parse(String paramString)
  {
    return Parser.parse(paramString, "");
  }
  
  public static Document parse(String paramString1, String paramString2)
  {
    return Parser.parse(paramString1, paramString2);
  }
  
  public static Document parse(String paramString1, String paramString2, Parser paramParser)
  {
    return paramParser.parseInput(paramString1, paramString2);
  }
  
  public static Document parse(URL paramURL, int paramInt)
  {
    paramURL = HttpConnection.connect(paramURL);
    paramURL.timeout(paramInt);
    return paramURL.get();
  }
  
  public static Document parseBodyFragment(String paramString)
  {
    return Parser.parseBodyFragment(paramString, "");
  }
  
  public static Document parseBodyFragment(String paramString1, String paramString2)
  {
    return Parser.parseBodyFragment(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/Jsoup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */