package com.drew.metadata.jpeg;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.a;
import com.drew.metadata.d;

public class f
{
  public void a(a parama, d paramd)
  {
    int i = 0;
    paramd = (e)paramd.a(e.class);
    try
    {
      paramd.setInt(0, parama.N(0));
      paramd.setInt(1, parama.P(1));
      paramd.setInt(3, parama.P(3));
      int k = parama.N(5);
      paramd.setInt(5, k);
      int j = 6;
      while (i < k)
      {
        int i1 = j + 1;
        int m = parama.N(j);
        int n = i1 + 1;
        i1 = parama.N(i1);
        j = n + 1;
        paramd.setObject(i + 6, new JpegComponent(m, i1, parama.N(n)));
        i += 1;
      }
      return;
    }
    catch (BufferBoundsException parama)
    {
      paramd.c(parama.getMessage());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/jpeg/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */