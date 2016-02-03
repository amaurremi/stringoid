package org.a.a;

class e
  extends d
{
  private final byte a;
  private final transient k b;
  private final transient k c;
  
  e(String paramString, byte paramByte, k paramk1, k paramk2)
  {
    super(paramString);
    this.a = paramByte;
    this.b = paramk1;
    this.c = paramk2;
  }
  
  public c a(a parama)
  {
    parama = f.a(parama);
    switch (this.a)
    {
    default: 
      throw new InternalError();
    case 1: 
      return parama.K();
    case 2: 
      return parama.F();
    case 3: 
      return parama.I();
    case 4: 
      return parama.G();
    case 5: 
      return parama.E();
    case 6: 
      return parama.v();
    case 7: 
      return parama.C();
    case 8: 
      return parama.u();
    case 9: 
      return parama.A();
    case 10: 
      return parama.z();
    case 11: 
      return parama.x();
    case 12: 
      return parama.t();
    case 13: 
      return parama.r();
    case 14: 
      return parama.p();
    case 15: 
      return parama.q();
    case 16: 
      return parama.n();
    case 17: 
      return parama.m();
    case 18: 
      return parama.k();
    case 19: 
      return parama.j();
    case 20: 
      return parama.h();
    case 21: 
      return parama.g();
    case 22: 
      return parama.e();
    }
    return parama.d();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        break;
      }
    } while (this.a == ((e)paramObject).a);
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return 1 << this.a;
  }
  
  public k y()
  {
    return this.b;
  }
  
  public k z()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */