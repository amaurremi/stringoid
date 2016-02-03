package com.drew.metadata.jpeg;

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
      paramd.setString(0, parama.getString(0, (int)parama.getLength()));
      return;
    }
    catch (BufferBoundsException parama)
    {
      paramd.c("Exception reading JPEG comment string");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/jpeg/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */