package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.m;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.math.BigInteger;

public final class c
  extends m<BigInteger>
{
  public void a(b paramb, BigInteger paramBigInteger)
  {
    paramb.a(paramBigInteger);
  }
  
  public BigInteger g(a parama)
  {
    if (parama.zN() == JsonToken.ahQ)
    {
      parama.nextNull();
      return null;
    }
    try
    {
      parama = new BigInteger(parama.nextString());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new JsonSyntaxException(parama);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */