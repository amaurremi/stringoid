package com.google.gson.internal.a;

import com.google.gson.f;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.stream.b;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends b
{
  private static final Writer afK = new Writer()
  {
    public void close()
    {
      throw new AssertionError();
    }
    
    public void flush()
    {
      throw new AssertionError();
    }
    
    public void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new AssertionError();
    }
  };
  private static final k afL = new k("closed");
  private final List<h> afJ = new ArrayList();
  private String afM;
  private h afN = i.aeN;
  
  public g()
  {
    super(afK);
  }
  
  private void c(h paramh)
  {
    if (this.afM != null)
    {
      if ((!paramh.zx()) || (Am())) {
        ((j)zS()).a(this.afM, paramh);
      }
      this.afM = null;
      return;
    }
    if (this.afJ.isEmpty())
    {
      this.afN = paramh;
      return;
    }
    h localh = zS();
    if ((localh instanceof f))
    {
      ((f)localh).b(paramh);
      return;
    }
    throw new IllegalStateException();
  }
  
  private h zS()
  {
    return (h)this.afJ.get(this.afJ.size() - 1);
  }
  
  public b A(long paramLong)
  {
    c(new k(Long.valueOf(paramLong)));
    return this;
  }
  
  public b a(Number paramNumber)
  {
    if (paramNumber == null) {
      return zX();
    }
    if (!isLenient())
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d))) {
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramNumber);
      }
    }
    c(new k(paramNumber));
    return this;
  }
  
  public b az(boolean paramBoolean)
  {
    c(new k(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public b cL(String paramString)
  {
    if ((this.afJ.isEmpty()) || (this.afM != null)) {
      throw new IllegalStateException();
    }
    if ((zS() instanceof j))
    {
      this.afM = paramString;
      return this;
    }
    throw new IllegalStateException();
  }
  
  public b cM(String paramString)
  {
    if (paramString == null) {
      return zX();
    }
    c(new k(paramString));
    return this;
  }
  
  public void close()
  {
    if (!this.afJ.isEmpty()) {
      throw new IOException("Incomplete document");
    }
    this.afJ.add(afL);
  }
  
  public void flush() {}
  
  public b l(double paramDouble)
  {
    if ((!isLenient()) && ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))) {
      throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramDouble);
    }
    c(new k(Double.valueOf(paramDouble)));
    return this;
  }
  
  public h zR()
  {
    if (!this.afJ.isEmpty()) {
      throw new IllegalStateException("Expected one JSON element but was " + this.afJ);
    }
    return this.afN;
  }
  
  public b zT()
  {
    f localf = new f();
    c(localf);
    this.afJ.add(localf);
    return this;
  }
  
  public b zU()
  {
    if ((this.afJ.isEmpty()) || (this.afM != null)) {
      throw new IllegalStateException();
    }
    if ((zS() instanceof f))
    {
      this.afJ.remove(this.afJ.size() - 1);
      return this;
    }
    throw new IllegalStateException();
  }
  
  public b zV()
  {
    j localj = new j();
    c(localj);
    this.afJ.add(localj);
    return this;
  }
  
  public b zW()
  {
    if ((this.afJ.isEmpty()) || (this.afM != null)) {
      throw new IllegalStateException();
    }
    if ((zS() instanceof j))
    {
      this.afJ.remove(this.afJ.size() - 1);
      return this;
    }
    throw new IllegalStateException();
  }
  
  public b zX()
  {
    c(i.aeN);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */