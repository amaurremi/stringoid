package com.drew.metadata.e;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.a;
import com.drew.metadata.d;

public class c
{
  public void a(a parama, d paramd)
  {
    paramd = (b)paramd.a(b.class);
    try
    {
      paramd.setInt(5, parama.P(5));
      paramd.setInt(7, parama.N(7));
      paramd.setInt(8, parama.P(8));
      paramd.setInt(10, parama.P(10));
      return;
    }
    catch (BufferBoundsException parama)
    {
      paramd.c(parama.getMessage());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */