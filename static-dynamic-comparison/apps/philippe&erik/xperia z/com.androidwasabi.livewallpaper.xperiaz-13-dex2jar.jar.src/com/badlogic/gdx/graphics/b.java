package com.badlogic.gdx.graphics;

import com.badlogic.gdx.utils.i;

public class b
{
  public static final b a = new b(0.0F, 0.0F, 0.0F, 0.0F);
  public static final b b = new b(1.0F, 1.0F, 1.0F, 1.0F);
  public static final b c = new b(0.0F, 0.0F, 0.0F, 1.0F);
  public static final b d = new b(1.0F, 0.0F, 0.0F, 1.0F);
  public static final b e = new b(0.0F, 1.0F, 0.0F, 1.0F);
  public static final b f = new b(0.0F, 0.0F, 1.0F, 1.0F);
  public static final b g = new b(0.75F, 0.75F, 0.75F, 1.0F);
  public static final b h = new b(0.5F, 0.5F, 0.5F, 1.0F);
  public static final b i = new b(0.25F, 0.25F, 0.25F, 1.0F);
  public static final b j = new b(1.0F, 0.68F, 0.68F, 1.0F);
  public static final b k = new b(1.0F, 0.78F, 0.0F, 1.0F);
  public static final b l = new b(1.0F, 1.0F, 0.0F, 1.0F);
  public static final b m = new b(1.0F, 0.0F, 1.0F, 1.0F);
  public static final b n = new b(0.0F, 1.0F, 1.0F, 1.0F);
  @Deprecated
  public static b o = new b();
  public float p;
  public float q;
  public float r;
  public float s;
  
  public b() {}
  
  public b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.p = paramFloat1;
    this.q = paramFloat2;
    this.r = paramFloat3;
    this.s = paramFloat4;
    a();
  }
  
  public static int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)(paramFloat1 * 255.0F) << 24 | (int)(paramFloat2 * 255.0F) << 16 | (int)(paramFloat3 * 255.0F) << 8 | (int)(paramFloat4 * 255.0F);
  }
  
  public b a()
  {
    if (this.p < 0.0F)
    {
      this.p = 0.0F;
      if (this.q >= 0.0F) {
        break label75;
      }
      this.q = 0.0F;
      label28:
      if (this.r >= 0.0F) {
        break label92;
      }
      this.r = 0.0F;
      label42:
      if (this.s >= 0.0F) {
        break label109;
      }
      this.s = 0.0F;
    }
    label75:
    label92:
    label109:
    while (this.s <= 1.0F)
    {
      return this;
      if (this.p <= 1.0F) {
        break;
      }
      this.p = 1.0F;
      break;
      if (this.q <= 1.0F) {
        break label28;
      }
      this.q = 1.0F;
      break label28;
      if (this.r <= 1.0F) {
        break label42;
      }
      this.r = 1.0F;
      break label42;
    }
    this.s = 1.0F;
    return this;
  }
  
  public float b()
  {
    return i.a((int)(this.s * 255.0F) << 24 | (int)(this.r * 255.0F) << 16 | (int)(this.q * 255.0F) << 8 | (int)(this.p * 255.0F));
  }
  
  public int c()
  {
    return (int)(this.s * 255.0F) << 24 | (int)(this.r * 255.0F) << 16 | (int)(this.q * 255.0F) << 8 | (int)(this.p * 255.0F);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (b)paramObject;
    } while (c() == ((b)paramObject).c());
    return false;
  }
  
  public int hashCode()
  {
    int i4 = 0;
    int i1;
    int i2;
    if (this.p != 0.0F)
    {
      i1 = i.a(this.p);
      if (this.q == 0.0F) {
        break label95;
      }
      i2 = i.a(this.q);
      label37:
      if (this.r == 0.0F) {
        break label100;
      }
    }
    label95:
    label100:
    for (int i3 = i.a(this.r);; i3 = 0)
    {
      if (this.s != 0.0F) {
        i4 = i.a(this.s);
      }
      return (i3 + (i2 + i1 * 31) * 31) * 31 + i4;
      i1 = 0;
      break;
      i2 = 0;
      break label37;
    }
  }
  
  public String toString()
  {
    for (String str = Integer.toHexString((int)(this.p * 255.0F) << 24 | (int)(this.q * 255.0F) << 16 | (int)(this.r * 255.0F) << 8 | (int)(this.s * 255.0F)); str.length() < 8; str = "0" + str) {}
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */