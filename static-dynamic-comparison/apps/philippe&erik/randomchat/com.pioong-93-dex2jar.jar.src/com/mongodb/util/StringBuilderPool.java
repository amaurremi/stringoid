package com.mongodb.util;

public class StringBuilderPool
  extends SimplePool<StringBuilder>
{
  public StringBuilderPool(String paramString, int paramInt)
  {
    super("StringBuilderPool-" + paramString, paramInt);
  }
  
  public StringBuilder createNew()
  {
    return new StringBuilder();
  }
  
  protected long memSize(StringBuilder paramStringBuilder)
  {
    return paramStringBuilder.length() * 2;
  }
  
  public boolean ok(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder.length() > getMaxSize()) {
      return false;
    }
    paramStringBuilder.setLength(0);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/StringBuilderPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */