package org.a.a;

class l
  extends k
{
  private final byte m;
  
  l(String paramString, byte paramByte)
  {
    super(paramString);
    this.m = paramByte;
  }
  
  public j a(a parama)
  {
    parama = f.a(parama);
    switch (this.m)
    {
    default: 
      throw new InternalError();
    case 1: 
      return parama.J();
    case 2: 
      return parama.H();
    case 3: 
      return parama.y();
    case 4: 
      return parama.D();
    case 5: 
      return parama.B();
    case 6: 
      return parama.w();
    case 7: 
      return parama.s();
    case 8: 
      return parama.o();
    case 9: 
      return parama.l();
    case 10: 
      return parama.i();
    case 11: 
      return parama.f();
    }
    return parama.c();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof l)) {
        break;
      }
    } while (this.m == ((l)paramObject).m);
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return 1 << this.m;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */