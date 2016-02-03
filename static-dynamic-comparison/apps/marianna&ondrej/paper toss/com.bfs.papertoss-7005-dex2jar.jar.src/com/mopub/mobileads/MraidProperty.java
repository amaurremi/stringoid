package com.mopub.mobileads;

abstract class MraidProperty
{
  private String sanitize(String paramString)
  {
    if (paramString != null) {
      return paramString.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
    }
    return "";
  }
  
  public abstract String toJsonPair();
  
  public String toString()
  {
    return sanitize(toJsonPair());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */