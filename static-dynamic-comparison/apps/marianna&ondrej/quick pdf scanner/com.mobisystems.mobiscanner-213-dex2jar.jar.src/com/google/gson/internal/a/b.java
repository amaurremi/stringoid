package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.m;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import java.math.BigDecimal;

public final class b
  extends m<BigDecimal>
{
  public void a(com.google.gson.stream.b paramb, BigDecimal paramBigDecimal)
  {
    paramb.a(paramBigDecimal);
  }
  
  public BigDecimal f(a parama)
  {
    if (parama.zN() == JsonToken.ahQ)
    {
      parama.nextNull();
      return null;
    }
    try
    {
      parama = new BigDecimal(parama.nextString());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new JsonSyntaxException(parama);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */