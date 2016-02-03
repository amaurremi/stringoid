package com.scoreloop.client.android.core.model;

public class NewsItem
{
  private String b;
  
  static
  {
    if (!NewsItem.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public String a()
  {
    if ((!a) && (this.b == null)) {
      throw new AssertionError();
    }
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    return a().equals(((NewsItem)paramObject).a());
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/NewsItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */