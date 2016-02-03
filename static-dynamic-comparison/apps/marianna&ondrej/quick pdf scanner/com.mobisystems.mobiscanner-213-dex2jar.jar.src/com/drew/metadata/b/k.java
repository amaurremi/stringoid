package com.drew.metadata.b;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.Rational;
import com.drew.lang.a;
import java.util.HashSet;
import java.util.Set;

public class k
{
  private static final int[] gd = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  
  private void a(int paramInt1, Set<Integer> paramSet, int paramInt2, com.drew.metadata.d paramd, a parama)
  {
    com.drew.metadata.b localb = paramd.b(h.class);
    if (localb == null) {}
    String str1;
    do
    {
      return;
      str1 = localb.getString(271);
      String str2 = parama.getString(paramInt1, 3);
      String str3 = parama.getString(paramInt1, 4);
      String str4 = parama.getString(paramInt1, 5);
      String str5 = parama.getString(paramInt1, 6);
      String str6 = parama.getString(paramInt1, 7);
      String str7 = parama.getString(paramInt1, 8);
      String str8 = parama.getString(paramInt1, 12);
      if (("OLYMP".equals(str4)) || ("EPSON".equals(str4)) || ("AGFA".equals(str3)))
      {
        a(paramd.a(ac.class), paramSet, paramInt1 + 8, paramInt2, paramd, parama);
        return;
      }
      if ((str1 != null) && (str1.trim().toUpperCase().startsWith("NIKON")))
      {
        if ("Nikon".equals(str4))
        {
          switch (parama.N(paramInt1 + 6))
          {
          default: 
            localb.c("Unsupported Nikon makernote data ignored.");
            return;
          case 1: 
            a(paramd.a(y.class), paramSet, paramInt1 + 8, paramInt2, paramd, parama);
            return;
          }
          a(paramd.a(aa.class), paramSet, paramInt1 + 18, paramInt1 + 10, paramd, parama);
          return;
        }
        a(paramd.a(aa.class), paramSet, paramInt1, paramInt2, paramd, parama);
        return;
      }
      if (("SONY CAM".equals(str7)) || ("SONY DSC".equals(str7)))
      {
        a(paramd.a(ak.class), paramSet, paramInt1 + 12, paramInt2, paramd, parama);
        return;
      }
      if (("SIGMA\000\000\000".equals(str7)) || ("FOVEON\000\000".equals(str7)))
      {
        a(paramd.a(ai.class), paramSet, paramInt1 + 10, paramInt2, paramd, parama);
        return;
      }
      boolean bool;
      if ("SEMC MS\000\000\000\000\000".equals(str8))
      {
        bool = parama.ar();
        parama.f(true);
        a(paramd.a(am.class), paramSet, paramInt1 + 20, paramInt2, paramd, parama);
        parama.f(bool);
        return;
      }
      if ("KDK".equals(str2))
      {
        a(paramd.a(u.class), paramSet, paramInt1 + 20, paramInt2, paramd, parama);
        return;
      }
      if ("Canon".equalsIgnoreCase(str1))
      {
        a(paramd.a(b.class), paramSet, paramInt1, paramInt2, paramd, parama);
        return;
      }
      if ((str1 != null) && (str1.toUpperCase().startsWith("CASIO")))
      {
        if ("QVC\000\000\000".equals(str5))
        {
          a(paramd.a(f.class), paramSet, paramInt1 + 6, paramInt2, paramd, parama);
          return;
        }
        a(paramd.a(d.class), paramSet, paramInt1, paramInt2, paramd, parama);
        return;
      }
      if (("FUJIFILM".equals(str7)) || ("Fujifilm".equalsIgnoreCase(str1)))
      {
        bool = parama.ar();
        parama.f(false);
        int i = parama.S(paramInt1 + 8);
        a(paramd.a(q.class), paramSet, paramInt1 + i, paramInt2, paramd, parama);
        parama.f(bool);
        return;
      }
      if ((str1 != null) && (str1.toUpperCase().startsWith("MINOLTA")))
      {
        a(paramd.a(ac.class), paramSet, paramInt1, paramInt2, paramd, parama);
        return;
      }
      if ("KYOCERA".equals(str6))
      {
        a(paramd.a(w.class), paramSet, paramInt1 + 22, paramInt2, paramd, parama);
        return;
      }
      if ("Panasonic\000\000\000".equals(parama.getString(paramInt1, 12)))
      {
        a(paramd.a(ae.class), paramSet, paramInt1 + 12, paramInt2, paramd, parama);
        return;
      }
      if ("AOC\000".equals(str3))
      {
        a(paramd.a(f.class), paramSet, paramInt1 + 6, paramInt1, paramd, parama);
        return;
      }
    } while ((str1 == null) || ((!str1.toUpperCase().startsWith("PENTAX")) && (!str1.toUpperCase().startsWith("ASAHI"))));
    a(paramd.a(ag.class), paramSet, paramInt1, paramInt1, paramd, parama);
  }
  
  private void a(com.drew.metadata.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i = 0;
    switch (paramInt4)
    {
    default: 
      paramb.c("Unknown format code " + paramInt4 + " for tag " + paramInt1);
    case 7: 
    case 2: 
    case 10: 
    case 5: 
      do
      {
        do
        {
          return;
          paramb.a(paramInt1, parama.m(paramInt2, paramInt3));
          return;
          paramb.setString(paramInt1, parama.n(paramInt2, paramInt3));
          return;
          if (paramInt3 == 1)
          {
            paramb.a(paramInt1, new Rational(parama.S(paramInt2), parama.S(paramInt2 + 4)));
            return;
          }
        } while (paramInt3 <= 1);
        localObject = new Rational[paramInt3];
        paramInt4 = i;
        while (paramInt4 < paramInt3)
        {
          localObject[paramInt4] = new Rational(parama.S(paramInt4 * 8 + paramInt2), parama.S(paramInt2 + 4 + paramInt4 * 8));
          paramInt4 += 1;
        }
        paramb.a(paramInt1, (Rational[])localObject);
        return;
        if (paramInt3 == 1)
        {
          paramb.a(paramInt1, new Rational(parama.R(paramInt2), parama.R(paramInt2 + 4)));
          return;
        }
      } while (paramInt3 <= 1);
      localObject = new Rational[paramInt3];
      paramInt4 = j;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = new Rational(parama.R(paramInt4 * 8 + paramInt2), parama.R(paramInt2 + 4 + paramInt4 * 8));
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (Rational[])localObject);
      return;
    case 11: 
      if (paramInt3 == 1)
      {
        paramb.setFloat(paramInt1, parama.V(paramInt2));
        return;
      }
      localObject = new float[paramInt3];
      paramInt4 = k;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = parama.V(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (float[])localObject);
      return;
    case 12: 
      if (paramInt3 == 1)
      {
        paramb.setDouble(paramInt1, parama.W(paramInt2));
        return;
      }
      localObject = new double[paramInt3];
      paramInt4 = m;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = parama.W(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (double[])localObject);
      return;
    case 6: 
      if (paramInt3 == 1)
      {
        paramb.setInt(paramInt1, parama.O(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = n;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = parama.O(paramInt2 + paramInt4);
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (int[])localObject);
      return;
    case 1: 
      if (paramInt3 == 1)
      {
        paramb.setInt(paramInt1, parama.N(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = i1;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = parama.N(paramInt2 + paramInt4);
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (int[])localObject);
      return;
    case 3: 
      if (paramInt3 == 1)
      {
        paramb.setInt(paramInt1, parama.P(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = i2;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = parama.P(paramInt4 * 2 + paramInt2);
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (int[])localObject);
      return;
    case 8: 
      if (paramInt3 == 1)
      {
        paramb.setInt(paramInt1, parama.Q(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = i3;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = parama.Q(paramInt4 * 2 + paramInt2);
        paramInt4 += 1;
      }
      paramb.a(paramInt1, (int[])localObject);
      return;
    }
    if (paramInt3 == 1)
    {
      paramb.setInt(paramInt1, parama.S(paramInt2));
      return;
    }
    Object localObject = new int[paramInt3];
    paramInt4 = i4;
    while (paramInt4 < paramInt3)
    {
      localObject[paramInt4] = parama.S(paramInt4 * 4 + paramInt2);
      paramInt4 += 1;
    }
    paramb.a(paramInt1, (int[])localObject);
  }
  
  private void a(com.drew.metadata.b paramb, Set<Integer> paramSet, int paramInt1, int paramInt2, com.drew.metadata.d paramd, a parama)
  {
    if (paramSet.contains(Integer.valueOf(paramInt1))) {}
    int i;
    label311:
    do
    {
      do
      {
        return;
        paramSet.add(Integer.valueOf(paramInt1));
        if ((paramInt1 >= parama.getLength()) || (paramInt1 < 0))
        {
          paramb.c("Ignored directory marked to start outside data segment");
          return;
        }
        int k = parama.P(paramInt1);
        if (k * 12 + 2 + 4 + paramInt1 > parama.getLength())
        {
          paramb.c("Illegally sized directory");
          return;
        }
        i = 0;
        if (i < k)
        {
          int j = p(paramInt1, i);
          int m = parama.P(j);
          int n = parama.P(j + 2);
          if ((n < 1) || (n > 12))
          {
            paramb.c("Invalid TIFF tag format code: " + n);
            return;
          }
          int i1 = parama.S(j + 4);
          if (i1 < 0) {
            paramb.c("Negative TIFF tag component count");
          }
          for (;;)
          {
            i += 1;
            break;
            int i2 = i1 * gd[n];
            if (i2 > 4)
            {
              j = parama.S(j + 8);
              if (j + i2 > parama.getLength()) {
                paramb.c("Illegal TIFF tag pointer offset");
              } else {
                j = paramInt2 + j;
              }
            }
            else
            {
              for (;;)
              {
                if ((j >= 0) && (j <= parama.getLength())) {
                  break label311;
                }
                paramb.c("Illegal TIFF tag pointer offset");
                break;
                j += 8;
              }
              if ((i2 < 0) || (j + i2 > parama.getLength())) {
                paramb.c("Illegal number of bytes: " + i2);
              } else {
                switch (m)
                {
                default: 
                  a(paramb, m, j, i1, n, parama);
                  break;
                case 34665: 
                  j = parama.S(j);
                  a(paramd.a(m.class), paramSet, paramInt2 + j, paramInt2, paramd, parama);
                  break;
                case 40965: 
                  j = parama.S(j);
                  a(paramd.a(j.class), paramSet, paramInt2 + j, paramInt2, paramd, parama);
                  break;
                case 34853: 
                  j = parama.S(j);
                  a(paramd.a(s.class), paramSet, paramInt2 + j, paramInt2, paramd, parama);
                  break;
                case 37500: 
                  a(j, paramSet, paramInt2, paramd, parama);
                }
              }
            }
          }
        }
        i = parama.S(p(paramInt1, k));
      } while (i == 0);
      i += paramInt2;
    } while ((i >= parama.getLength()) || (i < paramInt1));
    a((o)paramd.a(o.class), paramSet, i, paramInt2, paramd, parama);
  }
  
  private void a(com.drew.metadata.d paramd, h paramh, int paramInt, a parama)
  {
    Object localObject = parama.getString(paramInt, 2);
    int i;
    if ("MM".equals(localObject))
    {
      parama.f(true);
      i = parama.P(paramInt + 2);
      if ((i == 42) || (i == 20306) || (i == 85)) {
        break label141;
      }
      paramh.c("Unexpected TIFF marker after byte order identifier: 0x" + Integer.toHexString(i));
    }
    label141:
    Integer localInteger;
    do
    {
      do
      {
        return;
        if ("II".equals(localObject))
        {
          parama.f(false);
          break;
        }
        paramh.c("Unclear distinction between Motorola/Intel byte ordering: " + (String)localObject);
        return;
        int j = parama.S(paramInt + 4) + paramInt;
        i = j;
        if (j >= parama.getLength() - 1L)
        {
          paramh.c("First exif directory offset is beyond end of Exif data segment");
          i = 14;
        }
        a(paramh, new HashSet(), i, paramInt, paramd, parama);
        paramd = (o)paramd.b(o.class);
      } while ((paramd == null) || (!paramd.Y(259)));
      localObject = paramd.Z(513);
      localInteger = paramd.Z(514);
    } while ((localObject == null) || (localInteger == null));
    try
    {
      paramd.a(parama.m(((Integer)localObject).intValue() + paramInt, localInteger.intValue()));
      return;
    }
    catch (BufferBoundsException paramd)
    {
      paramh.c("Invalid thumbnail data specification: " + paramd.getMessage());
    }
  }
  
  private int p(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  public void a(a parama, com.drew.metadata.d paramd)
  {
    m localm = (m)paramd.a(m.class);
    if (parama.getLength() <= 14L)
    {
      localm.c("Exif data segment must contain at least 14 bytes");
      return;
    }
    try
    {
      if (!parama.getString(0, 6).equals("Exif\000\000"))
      {
        localm.c("Exif data segment doesn't begin with 'Exif'");
        return;
      }
    }
    catch (BufferBoundsException parama)
    {
      localm.c("Exif data segment ended prematurely");
      return;
    }
    a(paramd, (h)paramd.a(h.class), 6, parama);
  }
  
  public void b(a parama, com.drew.metadata.d paramd)
  {
    h localh = (h)paramd.a(h.class);
    try
    {
      a(paramd, localh, 0, parama);
      return;
    }
    catch (BufferBoundsException parama)
    {
      localh.c("Exif data segment ended prematurely");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */