package com.scoreloop.client.android.core.model;

import android.graphics.Bitmap;

public final class Award
{
  private AwardList a;
  private String b;
  private Money c;
  private int d;
  private Range e;
  private String f = "";
  private String g = "";
  private Bitmap h = null;
  private Bitmap i = null;
  
  Award(AwardList paramAwardList, String paramString, Range paramRange, int paramInt, Money paramMoney)
  {
    if ((paramAwardList == null) || (paramString == null) || (paramRange == null) || (paramInt < 0) || (paramMoney == null)) {
      throw new IllegalArgumentException();
    }
    this.a = paramAwardList;
    this.b = paramString;
    this.e = paramRange;
    this.d = paramInt;
    this.c = paramMoney;
  }
  
  public String a()
  {
    return this.b;
  }
  
  void a(Bitmap paramBitmap)
  {
    this.h = paramBitmap;
  }
  
  void a(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= b();
  }
  
  public int b()
  {
    return this.e.b();
  }
  
  void b(Bitmap paramBitmap)
  {
    this.i = paramBitmap;
  }
  
  void b(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean b(int paramInt)
  {
    return (c() <= paramInt) && (paramInt <= b());
  }
  
  public int c()
  {
    return this.e.getLocation();
  }
  
  AwardList d()
  {
    return this.a;
  }
  
  String e()
  {
    return "Award";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Award)paramObject;
      if (!this.a.a().equals(((Award)paramObject).a.a())) {
        return false;
      }
    } while (this.b.equals(((Award)paramObject).b));
    return false;
  }
  
  String f()
  {
    return "Award." + a() + ".achieved.png";
  }
  
  String g()
  {
    return "Award." + a() + ".unachieved.png";
  }
  
  String h()
  {
    return "Award." + a() + ".title";
  }
  
  public int hashCode()
  {
    return (this.a.a().hashCode() + 31) * 31 + this.b.hashCode();
  }
  
  String i()
  {
    return "Award." + a() + ".description";
  }
  
  public String toString()
  {
    return "Award [id=" + a() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Award.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */