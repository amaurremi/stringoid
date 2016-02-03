package com.jiubang.playsdk.a;

import com.jiubang.playsdk.e.d;
import java.util.LinkedHashMap;

public class x
{
  private long a = -1L;
  private int b;
  private int c;
  private LinkedHashMap d = new LinkedHashMap();
  
  public long a()
  {
    return this.a;
  }
  
  public d a(long paramLong)
  {
    return (d)this.d.get(Long.valueOf(paramLong));
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(d paramd)
  {
    this.d.put(Long.valueOf(paramd.a()), paramd);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.a = paramLong;
  }
  
  public String toString()
  {
    return "KtpPageDataBean [mTypeId=" + this.a + ", mPageId=" + this.b + ", mData=" + this.d + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */