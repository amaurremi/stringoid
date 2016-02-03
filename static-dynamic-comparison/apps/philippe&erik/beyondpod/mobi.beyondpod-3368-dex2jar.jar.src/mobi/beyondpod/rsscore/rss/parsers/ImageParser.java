package mobi.beyondpod.rsscore.rss.parsers;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class ImageParser
{
  static String[] _InvalidUrls = { "api.tweetmeme.com", "ads.pheedo.com", "share-buttons" };
  private static Pattern imgRegex = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
  
  public static void CheckAndAddImageUrl(ArrayList<String> paramArrayList, String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = paramString.toLowerCase(Locale.US);
    } while (!str.startsWith("http"));
    String[] arrayOfString = _InvalidUrls;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramArrayList.add(paramString);
        return;
      }
      if (str.contains(arrayOfString[i])) {
        break;
      }
      i += 1;
    }
  }
  
  public static ArrayList<String> ParseImagesFromStringWithParser(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Html.fromHtml(paramString, new Html.ImageGetter()
    {
      public Drawable getDrawable(String paramAnonymousString)
      {
        ImageParser.CheckAndAddImageUrl(ImageParser.this, paramAnonymousString);
        return null;
      }
    }, null);
    return localArrayList;
  }
  
  public static ArrayList<String> ParseImagesFromStringWithRegEx(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = imgRegex.matcher(paramString);
    for (;;)
    {
      if (!paramString.find()) {
        return localArrayList;
      }
      CheckAndAddImageUrl(localArrayList, paramString.group(1));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/ImageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */