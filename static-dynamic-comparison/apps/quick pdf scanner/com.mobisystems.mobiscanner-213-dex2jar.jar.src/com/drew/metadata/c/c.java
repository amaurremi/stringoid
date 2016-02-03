package com.drew.metadata.c;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.a;
import com.drew.metadata.d;
import java.util.Calendar;
import java.util.TimeZone;

public class c
{
  private void a(com.drew.metadata.b paramb, int paramInt, a parama)
  {
    int i = parama.S(paramInt);
    if (i != 0) {
      paramb.setString(paramInt, ao(i));
    }
  }
  
  private void a(b paramb, int paramInt, a parama)
  {
    int i = parama.P(paramInt);
    int j = parama.P(paramInt + 2);
    int k = parama.P(paramInt + 4);
    int m = parama.P(paramInt + 6);
    int n = parama.P(paramInt + 8);
    int i1 = parama.P(paramInt + 10);
    parama = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    parama.set(i, j, k, m, n, i1);
    paramb.a(paramInt, parama.getTime());
  }
  
  public static String ao(int paramInt)
  {
    return new String(new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF00 & paramInt) >> 8), (byte)(paramInt & 0xFF) });
  }
  
  private void b(com.drew.metadata.b paramb, int paramInt, a parama)
  {
    int i = parama.S(paramInt);
    if (i != 0) {
      paramb.setInt(paramInt, i);
    }
  }
  
  private void c(com.drew.metadata.b paramb, int paramInt, a parama)
  {
    long l = parama.T(paramInt);
    if (l != 0L) {
      paramb.setLong(paramInt, l);
    }
  }
  
  public void a(a parama, d paramd)
  {
    paramd = (b)paramd.a(b.class);
    try
    {
      paramd.setInt(0, parama.S(0));
      a(paramd, 4, parama);
      b(paramd, 8, parama);
      a(paramd, 12, parama);
      a(paramd, 16, parama);
      a(paramd, 20, parama);
      a(paramd, 24, parama);
      a(paramd, 36, parama);
      a(paramd, 40, parama);
      b(paramd, 44, parama);
      a(paramd, 48, parama);
      int i = parama.S(52);
      if (i != 0)
      {
        if (i > 538976288) {
          break label269;
        }
        paramd.setInt(52, i);
      }
      for (;;)
      {
        b(paramd, 64, parama);
        c(paramd, 56, parama);
        paramd.setObject(68, new float[] { parama.U(68), parama.U(72), parama.U(76) });
        int j = parama.S(128);
        paramd.setInt(128, j);
        i = 0;
        while (i < j)
        {
          int k = i * 12 + 132;
          paramd.a(parama.S(k), parama.m(parama.S(k + 4), parama.S(k + 8)));
          i += 1;
        }
        label269:
        paramd.setString(52, ao(i));
      }
      return;
    }
    catch (BufferBoundsException parama)
    {
      paramd.c(String.format("Reading ICC Header %s:%s", new Object[] { parama.getClass().getSimpleName(), parama.getMessage() }));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */