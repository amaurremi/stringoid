package com.mongodb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Args
{
  final Map<String, String> _options = new HashMap();
  final List<String> _params = new ArrayList();
  
  public Args(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      int k;
      if (str.startsWith("-"))
      {
        str = str.substring(1);
        k = str.indexOf("=");
        if (k < 0) {
          this._options.put(str, "");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this._options.put(str.substring(0, k), str.substring(k + 1));
        continue;
        this._params.add(str);
      }
    }
  }
  
  public String getOption(String paramString)
  {
    return (String)this._options.get(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this._options.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append('-').append(str);
      str = (String)this._options.get(str);
      if (str.length() != 0)
      {
        localStringBuilder.append('=');
        if (str.indexOf(" ") >= 0) {
          localStringBuilder.append('"').append(str).append('"');
        } else {
          localStringBuilder.append(str);
        }
      }
    }
    localIterator = this._params.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(' ');
      if (str.indexOf(" ") >= 0) {
        localStringBuilder.append('"').append(str).append('"');
      } else {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/Args.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */