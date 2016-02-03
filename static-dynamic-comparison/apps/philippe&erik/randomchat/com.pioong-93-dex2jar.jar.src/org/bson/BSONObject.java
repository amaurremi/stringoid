package org.bson;

import java.util.Map;
import java.util.Set;

public abstract interface BSONObject
{
  public abstract boolean containsField(String paramString);
  
  @Deprecated
  public abstract boolean containsKey(String paramString);
  
  public abstract Object get(String paramString);
  
  public abstract Set<String> keySet();
  
  public abstract Object put(String paramString, Object paramObject);
  
  public abstract void putAll(Map paramMap);
  
  public abstract void putAll(BSONObject paramBSONObject);
  
  public abstract Object removeField(String paramString);
  
  public abstract Map toMap();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */