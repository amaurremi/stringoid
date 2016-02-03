package org.jsoup.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import org.jsoup.parser.Parser;

public class Entities
{
  private static final Map base;
  private static final Map baseByVal;
  private static final Map full;
  private static final Map fullByVal;
  private static final Pattern strictUnescapePattern;
  private static final Pattern unescapePattern = Pattern.compile("&(#(x|X)?([0-9a-fA-F]+)|[a-zA-Z]+\\d*);?");
  private static final Object[][] xhtmlArray;
  private static final Map xhtmlByVal;
  
  static
  {
    strictUnescapePattern = Pattern.compile("&(#(x|X)?([0-9a-fA-F]+)|[a-zA-Z]+\\d*);");
    xhtmlArray = new Object[][] { { "quot", Integer.valueOf(34) }, { "amp", Integer.valueOf(38) }, { "apos", Integer.valueOf(39) }, { "lt", Integer.valueOf(60) }, { "gt", Integer.valueOf(62) } };
    xhtmlByVal = new HashMap();
    base = loadEntities("entities-base.properties");
    baseByVal = toCharacterKey(base);
    full = loadEntities("entities-full.properties");
    fullByVal = toCharacterKey(full);
    Object[][] arrayOfObject = xhtmlArray;
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object[] arrayOfObject1 = arrayOfObject[i];
      char c = (char)((Integer)arrayOfObject1[1]).intValue();
      xhtmlByVal.put(Character.valueOf(c), (String)arrayOfObject1[0]);
      i += 1;
    }
  }
  
  static String escape(String paramString, CharsetEncoder paramCharsetEncoder, Entities.EscapeMode paramEscapeMode)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() * 2);
    paramEscapeMode = paramEscapeMode.getMap();
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      int k = paramString.codePointAt(i);
      char c;
      if (k < 65536)
      {
        c = (char)k;
        if (paramEscapeMode.containsKey(Character.valueOf(c))) {
          localStringBuilder.append('&').append((String)paramEscapeMode.get(Character.valueOf(c))).append(';');
        }
      }
      for (;;)
      {
        i = Character.charCount(k) + i;
        break;
        if (paramCharsetEncoder.canEncode(c))
        {
          localStringBuilder.append(c);
        }
        else
        {
          localStringBuilder.append("&#x").append(Integer.toHexString(k)).append(';');
          continue;
          String str = new String(Character.toChars(k));
          if (paramCharsetEncoder.canEncode(str)) {
            localStringBuilder.append(str);
          } else {
            localStringBuilder.append("&#x").append(Integer.toHexString(k)).append(';');
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  static String escape(String paramString, Document.OutputSettings paramOutputSettings)
  {
    return escape(paramString, paramOutputSettings.encoder(), paramOutputSettings.escapeMode());
  }
  
  public static Character getCharacterByName(String paramString)
  {
    return (Character)full.get(paramString);
  }
  
  public static boolean isBaseNamedEntity(String paramString)
  {
    return base.containsKey(paramString);
  }
  
  public static boolean isNamedEntity(String paramString)
  {
    return full.containsKey(paramString);
  }
  
  private static Map loadEntities(String paramString)
  {
    Object localObject = new Properties();
    HashMap localHashMap = new HashMap();
    try
    {
      InputStream localInputStream = Entities.class.getResourceAsStream(paramString);
      ((Properties)localObject).load(localInputStream);
      localInputStream.close();
      paramString = ((Properties)localObject).entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        char c = (char)Integer.parseInt((String)((Map.Entry)localObject).getValue(), 16);
        localHashMap.put((String)((Map.Entry)localObject).getKey(), Character.valueOf(c));
      }
      return localIOException;
    }
    catch (IOException localIOException)
    {
      throw new MissingResourceException("Error loading entities resource: " + localIOException.getMessage(), "Entities", paramString);
    }
  }
  
  private static Map toCharacterKey(Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      Character localCharacter = (Character)((Map.Entry)localObject).getValue();
      localObject = (String)((Map.Entry)localObject).getKey();
      if (localHashMap.containsKey(localCharacter))
      {
        if (((String)localObject).toLowerCase().equals(localObject)) {
          localHashMap.put(localCharacter, localObject);
        }
      }
      else {
        localHashMap.put(localCharacter, localObject);
      }
    }
    return localHashMap;
  }
  
  static String unescape(String paramString)
  {
    return unescape(paramString, false);
  }
  
  static String unescape(String paramString, boolean paramBoolean)
  {
    return Parser.unescapeEntities(paramString, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Entities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */