package com.google.gson.internal.a;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  extends a
{
  private static final Reader afH = new Reader()
  {
    public void close()
    {
      throw new AssertionError();
    }
    
    public int read(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new AssertionError();
    }
  };
  private static final Object afI = new Object();
  private final List<Object> afJ;
  
  private void a(JsonToken paramJsonToken)
  {
    if (zN() != paramJsonToken) {
      throw new IllegalStateException("Expected " + paramJsonToken + " but was " + zN());
    }
  }
  
  private Object zO()
  {
    return this.afJ.get(this.afJ.size() - 1);
  }
  
  private Object zP()
  {
    return this.afJ.remove(this.afJ.size() - 1);
  }
  
  public void beginArray()
  {
    a(JsonToken.ahI);
    com.google.gson.f localf = (com.google.gson.f)zO();
    this.afJ.add(localf.iterator());
  }
  
  public void beginObject()
  {
    a(JsonToken.ahK);
    j localj = (j)zO();
    this.afJ.add(localj.entrySet().iterator());
  }
  
  public void close()
  {
    this.afJ.clear();
    this.afJ.add(afI);
  }
  
  public void endArray()
  {
    a(JsonToken.ahJ);
    zP();
    zP();
  }
  
  public void endObject()
  {
    a(JsonToken.ahL);
    zP();
    zP();
  }
  
  public boolean hasNext()
  {
    JsonToken localJsonToken = zN();
    return (localJsonToken != JsonToken.ahL) && (localJsonToken != JsonToken.ahJ);
  }
  
  public boolean nextBoolean()
  {
    a(JsonToken.ahP);
    return ((k)zP()).zt();
  }
  
  public double nextDouble()
  {
    JsonToken localJsonToken = zN();
    if ((localJsonToken != JsonToken.ahO) && (localJsonToken != JsonToken.ahN)) {
      throw new IllegalStateException("Expected " + JsonToken.ahO + " but was " + localJsonToken);
    }
    double d = ((k)zO()).zq();
    if ((!isLenient()) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
      throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
    }
    zP();
    return d;
  }
  
  public int nextInt()
  {
    JsonToken localJsonToken = zN();
    if ((localJsonToken != JsonToken.ahO) && (localJsonToken != JsonToken.ahN)) {
      throw new IllegalStateException("Expected " + JsonToken.ahO + " but was " + localJsonToken);
    }
    int i = ((k)zO()).zs();
    zP();
    return i;
  }
  
  public long nextLong()
  {
    JsonToken localJsonToken = zN();
    if ((localJsonToken != JsonToken.ahO) && (localJsonToken != JsonToken.ahN)) {
      throw new IllegalStateException("Expected " + JsonToken.ahO + " but was " + localJsonToken);
    }
    long l = ((k)zO()).zr();
    zP();
    return l;
  }
  
  public String nextName()
  {
    a(JsonToken.ahM);
    Map.Entry localEntry = (Map.Entry)((Iterator)zO()).next();
    this.afJ.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }
  
  public void nextNull()
  {
    a(JsonToken.ahQ);
    zP();
  }
  
  public String nextString()
  {
    JsonToken localJsonToken = zN();
    if ((localJsonToken != JsonToken.ahN) && (localJsonToken != JsonToken.ahO)) {
      throw new IllegalStateException("Expected " + JsonToken.ahN + " but was " + localJsonToken);
    }
    return ((k)zP()).zp();
  }
  
  public void skipValue()
  {
    if (zN() == JsonToken.ahM)
    {
      nextName();
      return;
    }
    zP();
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public JsonToken zN()
  {
    if (this.afJ.isEmpty()) {
      return JsonToken.ahR;
    }
    Object localObject = zO();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.afJ.get(this.afJ.size() - 2) instanceof j;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool) {
          return JsonToken.ahM;
        }
        this.afJ.add(((Iterator)localObject).next());
        return zN();
      }
      if (bool) {
        return JsonToken.ahL;
      }
      return JsonToken.ahJ;
    }
    if ((localObject instanceof j)) {
      return JsonToken.ahK;
    }
    if ((localObject instanceof com.google.gson.f)) {
      return JsonToken.ahI;
    }
    if ((localObject instanceof k))
    {
      localObject = (k)localObject;
      if (((k)localObject).zE()) {
        return JsonToken.ahN;
      }
      if (((k)localObject).zC()) {
        return JsonToken.ahP;
      }
      if (((k)localObject).zD()) {
        return JsonToken.ahO;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof i)) {
      return JsonToken.ahQ;
    }
    if (localObject == afI) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public void zQ()
  {
    a(JsonToken.ahM);
    Map.Entry localEntry = (Map.Entry)((Iterator)zO()).next();
    this.afJ.add(localEntry.getValue());
    this.afJ.add(new k((String)localEntry.getKey()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */