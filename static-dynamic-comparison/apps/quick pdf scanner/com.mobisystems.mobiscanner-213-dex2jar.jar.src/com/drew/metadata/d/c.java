package com.drew.metadata.d;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.a;
import com.drew.metadata.d;
import java.util.GregorianCalendar;

public class c
{
  private void a(a parama, com.drew.metadata.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = paramInt2 | paramInt1 << 8;
    label61:
    String[] arrayOfString2;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      if (paramInt4 < 1)
      {
        parama = "";
        if (!paramb.Y(paramInt1)) {
          break label251;
        }
        arrayOfString2 = paramb.getStringArray(paramInt1);
        if (arrayOfString2 != null) {
          break label226;
        }
        localObject = new String[1];
      }
      break;
    }
    for (;;)
    {
      localObject[(localObject.length - 1)] = parama;
      paramb.a(paramInt1, (String[])localObject);
      return;
      paramb.setInt(paramInt1, parama.P(paramInt3));
      return;
      paramb.setInt(paramInt1, parama.N(paramInt3));
      return;
      if (paramInt4 < 8) {
        break;
      }
      localObject = parama.getString(paramInt3, paramInt4);
      try
      {
        paramb.a(paramInt1, new GregorianCalendar(Integer.parseInt(((String)localObject).substring(0, 4)), Integer.parseInt(((String)localObject).substring(4, 6)) - 1, Integer.parseInt(((String)localObject).substring(6, 8))).getTime());
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      break;
      parama = parama.a(paramInt3, paramInt4, System.getProperty("file.encoding"));
      break label61;
      label226:
      String[] arrayOfString1 = new String[arrayOfString2.length + 1];
      System.arraycopy(arrayOfString2, 0, arrayOfString1, 0, arrayOfString2.length);
    }
    label251:
    paramb.setString(paramInt1, parama);
  }
  
  public void a(a parama, d paramd)
  {
    paramd = (b)paramd.a(b.class);
    int i = 0;
    for (;;)
    {
      if (i < parama.getLength()) {}
      int j;
      try
      {
        j = parama.N(i);
        if (j != 28)
        {
          paramd.c("Invalid start to IPTC tag");
          return;
        }
      }
      catch (BufferBoundsException parama)
      {
        paramd.c("Unable to read starting byte of IPTC tag");
        return;
      }
      if (i + 5 >= parama.getLength())
      {
        paramd.c("Too few bytes remain for a valid IPTC tag");
        return;
      }
      i += 1;
      int k = i + 1;
      int m;
      try
      {
        i = parama.N(i);
        j = k + 1;
        k = parama.N(k);
        m = parama.P(j);
        j += 2;
        if (j + m > parama.getLength())
        {
          paramd.c("Data for tag extends beyond end of IPTC segment");
          return;
        }
      }
      catch (BufferBoundsException parama)
      {
        paramd.c("IPTC data segment ended mid-way through tag descriptor");
        return;
      }
      try
      {
        a(parama, paramd, i, k, j, m);
        i = j + m;
      }
      catch (BufferBoundsException parama)
      {
        paramd.c("Error processing IPTC tag");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */