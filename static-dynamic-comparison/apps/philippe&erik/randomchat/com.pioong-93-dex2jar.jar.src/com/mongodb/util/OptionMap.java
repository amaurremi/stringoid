package com.mongodb.util;

import java.util.TreeMap;

public class OptionMap
  extends TreeMap<String, String>
{
  private static final long serialVersionUID = -4415279469780082174L;
  
  public int getInt(String paramString, int paramInt)
  {
    return StringParseUtil.parseIfInt((String)get(paramString), paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/OptionMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */