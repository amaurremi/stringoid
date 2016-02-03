package com.inmobi.androidsdk.impl.imai.db;

import com.inmobi.androidsdk.impl.imai.IMAICore;

public class ClickData
{
  private long a;
  private String b;
  private boolean c;
  private int d;
  private boolean e;
  private long f;
  
  public ClickData() {}
  
  public ClickData(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    setClickId(IMAICore.getRandomNumber());
    setClickUrl(paramString);
    setFollowRedirect(paramBoolean1);
    setPingWv(paramBoolean2);
    setRetryCount(paramInt);
    setTimestamp(System.currentTimeMillis());
  }
  
  public long getClickId()
  {
    return this.a;
  }
  
  public String getClickUrl()
  {
    return this.b;
  }
  
  public int getRetryCount()
  {
    return this.d;
  }
  
  public long getTimestamp()
  {
    return this.f;
  }
  
  public boolean isFollowRedirects()
  {
    return this.e;
  }
  
  public boolean isPingWv()
  {
    return this.c;
  }
  
  public void setClickId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setClickUrl(String paramString)
  {
    this.b = paramString;
  }
  
  public void setFollowRedirect(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setPingWv(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setRetryCount(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.f = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/db/ClickData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */