package com.drew.metadata.f;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.a;
import com.drew.metadata.d;

public class f
{
  public void a(a parama, d paramd)
  {
    paramd = (e)paramd.a(e.class);
    try
    {
      if (parama.S(0) != 943870035)
      {
        paramd.c("Invalid PSD file signature");
        return;
      }
      int i = parama.P(4);
      if ((i != 1) && (i != 2))
      {
        paramd.c("Invalid PSD file version (must be 1 or 2)");
        return;
      }
    }
    catch (BufferBoundsException parama)
    {
      paramd.c("Unable to read PSD header");
      return;
    }
    paramd.setInt(1, parama.P(12));
    paramd.setInt(2, parama.S(14));
    paramd.setInt(3, parama.S(18));
    paramd.setInt(4, parama.P(22));
    paramd.setInt(5, parama.P(24));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */