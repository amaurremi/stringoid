package com.flurry.android;

import java.util.Map;

final class af
{
  final String bu;
  final Map<String, String> bv;
  final cw bw;
  
  af(String paramString, Map<String, String> paramMap, cw paramcw)
  {
    this.bu = paramString;
    this.bv = paramMap;
    this.bw = paramcw;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action=");
    localStringBuilder.append(this.bu);
    localStringBuilder.append(",params=");
    localStringBuilder.append(this.bv);
    localStringBuilder.append(",");
    localStringBuilder.append(this.bw);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */