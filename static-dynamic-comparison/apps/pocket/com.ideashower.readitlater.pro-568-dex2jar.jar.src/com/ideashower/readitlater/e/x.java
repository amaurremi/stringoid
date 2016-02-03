package com.ideashower.readitlater.e;

import android.text.format.DateUtils;
import com.ideashower.readitlater.util.m;

public class x
  extends c
{
  private static long k;
  protected final int c;
  protected final int d;
  protected final String e;
  protected final String f;
  protected final long g;
  protected int h;
  protected boolean i;
  protected long j;
  
  static {}
  
  public x(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt3, boolean paramBoolean)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong1;
    this.j = paramLong2;
    this.h = paramInt3;
    this.i = paramBoolean;
  }
  
  public static void k()
  {
    k = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public long f()
  {
    return this.g;
  }
  
  public int g()
  {
    return this.h;
  }
  
  public String h()
  {
    long l = f() * 1000L;
    if (m.a(l) < 60000L) {
      return "just now";
    }
    return DateUtils.getRelativeTimeSpanString(l, System.currentTimeMillis(), 60000L, 524288).toString();
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  public long j()
  {
    if (g() == 2) {
      return this.j;
    }
    return 0L;
  }
  
  public boolean l()
  {
    if (g() == 2) {}
    while (g() == 3) {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    return "SharedItem [ShareId=" + this.c + ", FriendId=" + this.d + ", Comment=" + this.e + ", Quote=" + this.f + ", TimeShared=" + this.g + ", Status=" + this.h + ", Viewed=" + this.i + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */