package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;

public class Range
{
  private int a;
  private int b;
  
  @PublishedFor__1_0_0
  public Range(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("length & location must be >= 0");
    }
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("location must be >= 0");
    }
    this.b = paramInt;
  }
  
  int b()
  {
    return this.b + this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (!(paramObject instanceof Range)) {
        return super.equals(paramObject);
      }
      paramObject = (Range)paramObject;
    } while ((a() != ((Range)paramObject).a()) || (b() != ((Range)paramObject).b()));
    return true;
  }
  
  @PublishedFor__1_0_0
  public int getLength()
  {
    return this.a;
  }
  
  @PublishedFor__1_0_0
  public int getLocation()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return new Integer(a()).hashCode() ^ new Integer(b()).hashCode();
  }
  
  public String toString()
  {
    return " [" + a() + ", " + b() + "] ";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */