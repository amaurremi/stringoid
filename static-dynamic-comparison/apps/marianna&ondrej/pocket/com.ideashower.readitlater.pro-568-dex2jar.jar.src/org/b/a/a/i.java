package org.b.a.a;

public class i
  extends b
{
  private int a;
  private int b;
  private byte c;
  private byte d;
  private b e = null;
  private b f = null;
  
  public i()
  {
    d();
  }
  
  protected static boolean a(byte paramByte)
  {
    paramByte &= 0xFF;
    return (paramByte == 234) || (paramByte == 237) || (paramByte == 239) || (paramByte == 243) || (paramByte == 245);
  }
  
  protected static boolean b(byte paramByte)
  {
    paramByte &= 0xFF;
    return (paramByte == 235) || (paramByte == 238) || (paramByte == 240) || (paramByte == 244);
  }
  
  public String a()
  {
    int i = this.a - this.b;
    if (i >= 5) {
      return org.b.a.b.t;
    }
    if (i <= -5) {
      return org.b.a.b.f;
    }
    float f1 = this.e.b() - this.f.b();
    if (f1 > 0.01F) {
      return org.b.a.b.t;
    }
    if (f1 < -0.01F) {
      return org.b.a.b.f;
    }
    if (i < 0) {
      return org.b.a.b.f;
    }
    return org.b.a.b.t;
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (c() == c.c) {
      return c.c;
    }
    int i = paramInt1;
    if (i < paramInt1 + paramInt2)
    {
      byte b1 = paramArrayOfByte[i];
      if (b1 == 32) {
        if (this.d != 32)
        {
          if (!a(this.c)) {
            break label90;
          }
          this.a += 1;
        }
      }
      for (;;)
      {
        this.d = this.c;
        this.c = b1;
        i += 1;
        break;
        label90:
        if (b(this.c))
        {
          this.b += 1;
          continue;
          if ((this.d == 32) && (a(this.c)) && (b1 != 32)) {
            this.b += 1;
          }
        }
      }
    }
    return c.a;
  }
  
  public void a(b paramb1, b paramb2)
  {
    this.e = paramb1;
    this.f = paramb2;
  }
  
  public float b()
  {
    return 0.0F;
  }
  
  public c c()
  {
    if ((this.e.c() == c.c) && (this.f.c() == c.c)) {
      return c.c;
    }
    return c.a;
  }
  
  public void d()
  {
    this.a = 0;
    this.b = 0;
    this.c = 32;
    this.d = 32;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */