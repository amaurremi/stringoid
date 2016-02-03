package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends h
  implements Iterable<h>
{
  private final List<h> aeM = new ArrayList();
  
  public void b(h paramh)
  {
    Object localObject = paramh;
    if (paramh == null) {
      localObject = i.aeN;
    }
    this.aeM.add(localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof f)) && (((f)paramObject).aeM.equals(this.aeM)));
  }
  
  public int hashCode()
  {
    return this.aeM.hashCode();
  }
  
  public Iterator<h> iterator()
  {
    return this.aeM.iterator();
  }
  
  public Number zo()
  {
    if (this.aeM.size() == 1) {
      return ((h)this.aeM.get(0)).zo();
    }
    throw new IllegalStateException();
  }
  
  public String zp()
  {
    if (this.aeM.size() == 1) {
      return ((h)this.aeM.get(0)).zp();
    }
    throw new IllegalStateException();
  }
  
  public double zq()
  {
    if (this.aeM.size() == 1) {
      return ((h)this.aeM.get(0)).zq();
    }
    throw new IllegalStateException();
  }
  
  public long zr()
  {
    if (this.aeM.size() == 1) {
      return ((h)this.aeM.get(0)).zr();
    }
    throw new IllegalStateException();
  }
  
  public int zs()
  {
    if (this.aeM.size() == 1) {
      return ((h)this.aeM.get(0)).zs();
    }
    throw new IllegalStateException();
  }
  
  public boolean zt()
  {
    if (this.aeM.size() == 1) {
      return ((h)this.aeM.get(0)).zt();
    }
    throw new IllegalStateException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */