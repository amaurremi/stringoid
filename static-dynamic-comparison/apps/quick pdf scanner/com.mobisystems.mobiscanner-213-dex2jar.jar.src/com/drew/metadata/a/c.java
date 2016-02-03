package com.drew.metadata.a;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.a;
import com.drew.metadata.d;

public class c
{
  public void a(a parama, d paramd)
  {
    paramd = paramd.a(b.class);
    if (parama.getLength() != 12L)
    {
      paramd.c(String.format("Adobe JPEG data is expected to be 12 bytes long, not %d.", new Object[] { Long.valueOf(parama.getLength()) }));
      return;
    }
    try
    {
      parama.f(false);
      if (!parama.getString(0, 5).equals("Adobe"))
      {
        paramd.c("Invalid Adobe JPEG data header.");
        return;
      }
    }
    catch (BufferBoundsException parama)
    {
      paramd.c("Exif data segment ended prematurely");
      return;
    }
    paramd.setInt(0, parama.P(5));
    paramd.setInt(1, parama.P(7));
    paramd.setInt(2, parama.P(9));
    paramd.setInt(3, parama.O(11));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */