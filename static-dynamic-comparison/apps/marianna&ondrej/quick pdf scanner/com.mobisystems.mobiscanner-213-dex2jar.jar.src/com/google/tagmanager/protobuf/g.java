package com.google.tagmanager.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class g
{
  private static final g ajB = new g(true);
  private static volatile boolean ajz = false;
  private final Map<a, GeneratedMessageLite.e<?, ?>> ajA;
  
  g()
  {
    this.ajA = new HashMap();
  }
  
  private g(boolean paramBoolean)
  {
    this.ajA = Collections.emptyMap();
  }
  
  public static g Bu()
  {
    return ajB;
  }
  
  public <ContainingType extends n> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType paramContainingType, int paramInt)
  {
    return (GeneratedMessageLite.e)this.ajA.get(new a(paramContainingType, paramInt));
  }
  
  private static final class a
  {
    private final Object cE;
    private final int number;
    
    a(Object paramObject, int paramInt)
    {
      this.cE = paramObject;
      this.number = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.cE != ((a)paramObject).cE) || (this.number != ((a)paramObject).number));
      return true;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(this.cE) * 65535 + this.number;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */