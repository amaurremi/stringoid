package com.google.gson.stream;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class b
  implements Closeable
{
  private boolean aeE;
  private boolean aeF;
  private final List<JsonScope> afJ = new ArrayList();
  private String ahT;
  private String ahU;
  private boolean ahn;
  private final Writer out;
  private String separator;
  
  public b(Writer paramWriter)
  {
    this.afJ.add(JsonScope.ahE);
    this.separator = ":";
    this.aeE = true;
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    this.out = paramWriter;
  }
  
  private JsonScope An()
  {
    return (JsonScope)this.afJ.get(this.afJ.size() - 1);
  }
  
  private void Ao()
  {
    if (this.ahU != null)
    {
      Aq();
      cP(this.ahU);
      this.ahU = null;
    }
  }
  
  private void Ap()
  {
    if (this.ahT == null) {}
    for (;;)
    {
      return;
      this.out.write("\n");
      int i = 1;
      while (i < this.afJ.size())
      {
        this.out.write(this.ahT);
        i += 1;
      }
    }
  }
  
  private void Aq()
  {
    JsonScope localJsonScope = An();
    if (localJsonScope == JsonScope.ahD) {
      this.out.write(44);
    }
    while (localJsonScope == JsonScope.ahB)
    {
      Ap();
      b(JsonScope.ahC);
      return;
    }
    throw new IllegalStateException("Nesting problem: " + this.afJ);
  }
  
  private b a(JsonScope paramJsonScope1, JsonScope paramJsonScope2, String paramString)
  {
    JsonScope localJsonScope = An();
    if ((localJsonScope != paramJsonScope2) && (localJsonScope != paramJsonScope1)) {
      throw new IllegalStateException("Nesting problem: " + this.afJ);
    }
    if (this.ahU != null) {
      throw new IllegalStateException("Dangling name: " + this.ahU);
    }
    this.afJ.remove(this.afJ.size() - 1);
    if (localJsonScope == paramJsonScope2) {
      Ap();
    }
    this.out.write(paramString);
    return this;
  }
  
  private b a(JsonScope paramJsonScope, String paramString)
  {
    aG(true);
    this.afJ.add(paramJsonScope);
    this.out.write(paramString);
    return this;
  }
  
  private void aG(boolean paramBoolean)
  {
    switch (1.ahy[An().ordinal()])
    {
    default: 
      throw new IllegalStateException("Nesting problem: " + this.afJ);
    case 1: 
      if ((!this.ahn) && (!paramBoolean)) {
        throw new IllegalStateException("JSON must start with an array or an object.");
      }
      b(JsonScope.ahF);
      return;
    case 2: 
      b(JsonScope.ahA);
      Ap();
      return;
    case 3: 
      this.out.append(',');
      Ap();
      return;
    case 4: 
      this.out.append(this.separator);
      b(JsonScope.ahD);
      return;
    }
    throw new IllegalStateException("JSON must have only one top-level value.");
  }
  
  private void b(JsonScope paramJsonScope)
  {
    this.afJ.set(this.afJ.size() - 1, paramJsonScope);
  }
  
  private void cP(String paramString)
  {
    this.out.write("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      int k = paramString.charAt(i);
      switch (k)
      {
      default: 
        if (k <= 31) {
          this.out.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        this.out.write(92);
        this.out.write(k);
        continue;
        this.out.write("\\t");
        continue;
        this.out.write("\\b");
        continue;
        this.out.write("\\n");
        continue;
        this.out.write("\\r");
        continue;
        this.out.write("\\f");
        continue;
        if (this.aeF)
        {
          this.out.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
        }
        else
        {
          this.out.write(k);
          continue;
          this.out.write(String.format("\\u%04x", new Object[] { Integer.valueOf(k) }));
          continue;
          this.out.write(k);
        }
      }
    }
    this.out.write("\"");
  }
  
  public b A(long paramLong)
  {
    Ao();
    aG(false);
    this.out.write(Long.toString(paramLong));
    return this;
  }
  
  public final boolean Al()
  {
    return this.aeF;
  }
  
  public final boolean Am()
  {
    return this.aeE;
  }
  
  public b a(Number paramNumber)
  {
    if (paramNumber == null) {
      return zX();
    }
    Ao();
    String str = paramNumber.toString();
    if ((!this.ahn) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
    }
    aG(false);
    this.out.append(str);
    return this;
  }
  
  public final void aE(boolean paramBoolean)
  {
    this.aeF = paramBoolean;
  }
  
  public final void aF(boolean paramBoolean)
  {
    this.aeE = paramBoolean;
  }
  
  public b az(boolean paramBoolean)
  {
    Ao();
    aG(false);
    Writer localWriter = this.out;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
  
  public b cL(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (this.ahU != null) {
      throw new IllegalStateException();
    }
    this.ahU = paramString;
    return this;
  }
  
  public b cM(String paramString)
  {
    if (paramString == null) {
      return zX();
    }
    Ao();
    aG(false);
    cP(paramString);
    return this;
  }
  
  public void close()
  {
    this.out.close();
    if (An() != JsonScope.ahF) {
      throw new IOException("Incomplete document");
    }
  }
  
  public void flush()
  {
    this.out.flush();
  }
  
  public boolean isLenient()
  {
    return this.ahn;
  }
  
  public b l(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramDouble);
    }
    Ao();
    aG(false);
    this.out.append(Double.toString(paramDouble));
    return this;
  }
  
  public final void setIndent(String paramString)
  {
    if (paramString.length() == 0)
    {
      this.ahT = null;
      this.separator = ":";
      return;
    }
    this.ahT = paramString;
    this.separator = ": ";
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.ahn = paramBoolean;
  }
  
  public b zT()
  {
    Ao();
    return a(JsonScope.ahz, "[");
  }
  
  public b zU()
  {
    return a(JsonScope.ahz, JsonScope.ahA, "]");
  }
  
  public b zV()
  {
    Ao();
    return a(JsonScope.ahB, "{");
  }
  
  public b zW()
  {
    return a(JsonScope.ahB, JsonScope.ahD, "}");
  }
  
  public b zX()
  {
    if (this.ahU != null)
    {
      if (this.aeE) {
        Ao();
      }
    }
    else
    {
      aG(false);
      this.out.write("null");
      return this;
    }
    this.ahU = null;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/stream/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */