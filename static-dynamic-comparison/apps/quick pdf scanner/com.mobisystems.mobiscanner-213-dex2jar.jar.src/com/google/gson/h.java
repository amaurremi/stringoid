package com.google.gson;

import com.google.gson.stream.b;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class h
{
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      b localb = new b((Writer)localObject);
      localb.setLenient(true);
      com.google.gson.internal.h.b(this, localb);
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
  
  public k zA()
  {
    if (zw()) {
      return (k)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  Boolean zB()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public Number zo()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String zp()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double zq()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long zr()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int zs()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean zt()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean zu()
  {
    return this instanceof f;
  }
  
  public boolean zv()
  {
    return this instanceof j;
  }
  
  public boolean zw()
  {
    return this instanceof k;
  }
  
  public boolean zx()
  {
    return this instanceof i;
  }
  
  public j zy()
  {
    if (zv()) {
      return (j)this;
    }
    throw new IllegalStateException("Not a JSON Object: " + this);
  }
  
  public f zz()
  {
    if (zu()) {
      return (f)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */