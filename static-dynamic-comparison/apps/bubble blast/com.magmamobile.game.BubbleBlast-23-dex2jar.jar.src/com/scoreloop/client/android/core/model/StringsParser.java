package com.scoreloop.client.android.core.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsParser
{
  public Map<String, String> a(InputStream paramInputStream)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject = Pattern.compile("^\\s*\"(.*)\"\\s*=\\s*\"(.*)\"\\s*;\\s*$");
      Matcher localMatcher = ((Pattern)localObject).matcher("");
      localMatcher.usePattern((Pattern)localObject);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      for (paramInputStream = localBufferedReader.readLine();; paramInputStream = localBufferedReader.readLine())
      {
        localObject = localHashMap;
        if (paramInputStream == null) {
          break;
        }
        localMatcher.reset(paramInputStream);
        if (localMatcher.matches()) {
          localHashMap.put(localMatcher.group(1), localMatcher.group(2));
        }
      }
      return (Map<String, String>)localObject;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      localObject = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/StringsParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */