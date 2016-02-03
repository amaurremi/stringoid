package com.google.api.client.json.gson;

import com.google.api.client.json.d;
import com.google.api.client.json.g;
import com.google.api.client.util.x;
import java.io.EOFException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class b
  extends g
{
  private final a acI;
  private final com.google.gson.stream.a acJ;
  private List<String> acK = new ArrayList();
  private com.google.api.client.json.JsonToken acL;
  private String acM;
  
  b(a parama, com.google.gson.stream.a parama1)
  {
    this.acI = parama;
    this.acJ = parama1;
    parama1.setLenient(true);
  }
  
  private void yB()
  {
    if ((this.acL == com.google.api.client.json.JsonToken.acA) || (this.acL == com.google.api.client.json.JsonToken.acB)) {}
    for (boolean bool = true;; bool = false)
    {
      x.av(bool);
      return;
    }
  }
  
  public void close()
  {
    this.acJ.close();
  }
  
  public d getFactory()
  {
    return this.acI;
  }
  
  public float getFloatValue()
  {
    yB();
    return Float.valueOf(this.acM).floatValue();
  }
  
  public int getIntValue()
  {
    yB();
    return Integer.valueOf(this.acM).intValue();
  }
  
  public String getText()
  {
    return this.acM;
  }
  
  public com.google.api.client.json.JsonToken ym()
  {
    if (this.acL != null) {
      switch (1.act[this.acL.ordinal()])
      {
      }
    }
    try
    {
      for (;;)
      {
        com.google.gson.stream.JsonToken localJsonToken = this.acJ.zN();
        switch (1.acN[localJsonToken.ordinal()])
        {
        default: 
          this.acM = null;
          this.acL = null;
          return this.acL;
          this.acJ.beginArray();
          this.acK.add(null);
          continue;
          this.acJ.beginObject();
          this.acK.add(null);
        }
      }
    }
    catch (EOFException localEOFException)
    {
      for (;;)
      {
        Object localObject = com.google.gson.stream.JsonToken.ahR;
        continue;
        this.acM = "[";
        this.acL = com.google.api.client.json.JsonToken.acu;
        continue;
        this.acM = "]";
        this.acL = com.google.api.client.json.JsonToken.acv;
        this.acK.remove(this.acK.size() - 1);
        this.acJ.endArray();
        continue;
        this.acM = "{";
        this.acL = com.google.api.client.json.JsonToken.acw;
        continue;
        this.acM = "}";
        this.acL = com.google.api.client.json.JsonToken.acx;
        this.acK.remove(this.acK.size() - 1);
        this.acJ.endObject();
        continue;
        if (this.acJ.nextBoolean())
        {
          this.acM = "true";
          this.acL = com.google.api.client.json.JsonToken.acC;
        }
        else
        {
          this.acM = "false";
          this.acL = com.google.api.client.json.JsonToken.acD;
          continue;
          this.acM = "null";
          this.acL = com.google.api.client.json.JsonToken.acE;
          this.acJ.nextNull();
          continue;
          this.acM = this.acJ.nextString();
          this.acL = com.google.api.client.json.JsonToken.acz;
          continue;
          this.acM = this.acJ.nextString();
          if (this.acM.indexOf('.') == -1) {}
          for (localObject = com.google.api.client.json.JsonToken.acA;; localObject = com.google.api.client.json.JsonToken.acB)
          {
            this.acL = ((com.google.api.client.json.JsonToken)localObject);
            break;
          }
          this.acM = this.acJ.nextName();
          this.acL = com.google.api.client.json.JsonToken.acy;
          this.acK.set(this.acK.size() - 1, this.acM);
        }
      }
    }
  }
  
  public com.google.api.client.json.JsonToken yn()
  {
    return this.acL;
  }
  
  public String yo()
  {
    if (this.acK.isEmpty()) {
      return null;
    }
    return (String)this.acK.get(this.acK.size() - 1);
  }
  
  public g yp()
  {
    if (this.acL != null) {}
    switch (1.act[this.acL.ordinal()])
    {
    default: 
      return this;
    case 1: 
      this.acJ.skipValue();
      this.acM = "]";
      this.acL = com.google.api.client.json.JsonToken.acv;
      return this;
    }
    this.acJ.skipValue();
    this.acM = "}";
    this.acL = com.google.api.client.json.JsonToken.acx;
    return this;
  }
  
  public byte yq()
  {
    yB();
    return Byte.valueOf(this.acM).byteValue();
  }
  
  public short yr()
  {
    yB();
    return Short.valueOf(this.acM).shortValue();
  }
  
  public long ys()
  {
    yB();
    return Long.valueOf(this.acM).longValue();
  }
  
  public double yt()
  {
    yB();
    return Double.valueOf(this.acM).doubleValue();
  }
  
  public BigInteger yu()
  {
    yB();
    return new BigInteger(this.acM);
  }
  
  public BigDecimal yv()
  {
    yB();
    return new BigDecimal(this.acM);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/gson/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */