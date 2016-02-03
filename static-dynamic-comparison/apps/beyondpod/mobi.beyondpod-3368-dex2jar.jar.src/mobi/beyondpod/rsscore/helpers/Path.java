package mobi.beyondpod.rsscore.helpers;

import java.io.File;

public class Path
{
  public static String Combine(String paramString1, String paramString2)
  {
    return paramString1 + File.separator + paramString2;
  }
  
  public static String GetExtension(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i + 1 == paramString.length())) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static String GetFileName(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i == -1) {
      return paramString;
    }
    if (i + 1 < paramString.length()) {
      return paramString.substring(i + 1, paramString.length());
    }
    return "";
  }
  
  public static String GetFileNameWithoutExtension(String paramString)
  {
    paramString = GetFileName(paramString);
    int j = paramString.lastIndexOf('.');
    int i = j;
    if (j < 0) {
      i = paramString.length();
    }
    return paramString.substring(0, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/Path.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */