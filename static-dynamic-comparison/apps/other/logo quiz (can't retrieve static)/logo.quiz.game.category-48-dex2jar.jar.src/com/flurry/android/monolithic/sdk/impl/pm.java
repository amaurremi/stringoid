package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.Reader;

public final class pm
  extends ph
{
  protected Reader I;
  protected char[] J;
  protected pc K;
  protected final afj L;
  protected boolean M = false;
  
  public pm(pq parampq, int paramInt, Reader paramReader, pc parampc, afj paramafj)
  {
    super(parampq, paramInt);
    this.I = paramReader;
    this.J = parampq.d();
    this.K = parampc;
    this.L = paramafj;
  }
  
  private final pb a(boolean paramBoolean)
    throws IOException, ov
  {
    int i5 = 0;
    Object localObject2 = this.p.k();
    if (paramBoolean) {
      localObject2[0] = 45;
    }
    for (int k = 1;; k = 0)
    {
      Object localObject1;
      int m;
      int i;
      label80:
      int n;
      int i1;
      if (this.f < this.g)
      {
        localObject1 = this.J;
        m = this.f;
        this.f = (m + 1);
        i = localObject1[m];
        int j = i;
        if (i == 48) {
          j = ad();
        }
        m = 0;
        i = j;
        if ((i < 48) || (i > 57)) {
          break label860;
        }
        m += 1;
        n = k;
        localObject1 = localObject2;
        if (k >= localObject2.length)
        {
          localObject1 = this.p.m();
          n = 0;
        }
        k = n + 1;
        localObject1[n] = i;
        if ((this.f < this.g) || (E())) {
          break label625;
        }
        n = 1;
        i = 0;
        i1 = m;
        m = k;
      }
      for (k = n;; k = n)
      {
        if (i1 == 0) {
          b("Missing integer part (next char " + c(i) + ")");
        }
        label251:
        int i2;
        if (i == 46)
        {
          localObject1[m] = i;
          m += 1;
          n = 0;
          if ((this.f >= this.g) && (!E()))
          {
            k = 1;
            if (n == 0) {
              a(i, "Decimal point not followed by a digit");
            }
            i2 = n;
            n = m;
            m = k;
            localObject2 = localObject1;
            k = n;
          }
        }
        for (;;)
        {
          label372:
          label404:
          label447:
          label456:
          int i3;
          label543:
          int i4;
          if ((i == 101) || (i == 69))
          {
            n = k;
            localObject1 = localObject2;
            if (k >= localObject2.length)
            {
              localObject1 = this.p.m();
              n = 0;
            }
            k = n + 1;
            localObject1[n] = i;
            if (this.f < this.g)
            {
              localObject2 = this.J;
              n = this.f;
              this.f = (n + 1);
              i = localObject2[n];
              if ((i != 45) && (i != 43)) {
                break label815;
              }
              if (k < localObject1.length) {
                break label812;
              }
              localObject1 = this.p.m();
              k = 0;
              localObject1[k] = i;
              if (this.f >= this.g) {
                break label754;
              }
              localObject2 = this.J;
              n = this.f;
              this.f = (n + 1);
              i = localObject2[n];
              k += 1;
              n = 0;
              if ((i > 57) || (i < 48)) {
                break label797;
              }
              n += 1;
              i3 = k;
              localObject2 = localObject1;
              if (k >= localObject1.length)
              {
                localObject2 = this.p.m();
                i3 = 0;
              }
              k = i3 + 1;
              localObject2[i3] = i;
              if ((this.f < this.g) || (E())) {
                break label764;
              }
              i3 = 1;
              m = k;
              k = i3;
              i3 = k;
              i4 = m;
              i5 = n;
              if (n == 0)
              {
                a(i, "Exponent indicator not followed by a digit");
                i5 = n;
                i4 = m;
                i3 = k;
              }
              label579:
              if (i3 == 0) {
                this.f -= 1;
              }
              this.p.a(i4);
              return a(paramBoolean, i1, i2, i5);
              i = e("No digit following minus sign");
              break;
              label625:
              localObject2 = this.J;
              n = this.f;
              this.f = (n + 1);
              i = localObject2[n];
              localObject2 = localObject1;
              break label80;
              localObject2 = this.J;
              i2 = this.f;
              this.f = (i2 + 1);
              i = localObject2[i2];
              if (i < 48) {
                break label835;
              }
              if (i > 57) {
                break label251;
              }
              n += 1;
              if (m < localObject1.length) {
                break label832;
              }
              localObject1 = this.p.m();
              m = 0;
            }
          }
          label754:
          label764:
          label797:
          label812:
          label815:
          label832:
          for (;;)
          {
            i2 = m + 1;
            localObject1[m] = i;
            m = i2;
            break;
            i = e("expected a digit for number exponent");
            break label372;
            i = e("expected a digit for number exponent");
            break label447;
            localObject1 = this.J;
            i3 = this.f;
            this.f = (i3 + 1);
            i = localObject1[i3];
            localObject1 = localObject2;
            break label456;
            i3 = k;
            k = m;
            m = i3;
            break label543;
            break label404;
            n = 0;
            break label456;
            i3 = m;
            i4 = k;
            break label579;
          }
          label835:
          break label251;
          i2 = 0;
          n = k;
          k = m;
          localObject2 = localObject1;
          m = n;
        }
        label860:
        n = 0;
        i1 = m;
        localObject1 = localObject2;
        m = k;
      }
    }
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, ov
  {
    this.p.a(this.J, paramInt1, this.f - paramInt1);
    Object localObject = this.p.j();
    paramInt1 = this.p.l();
    for (;;)
    {
      if ((this.f >= this.g) && (!E())) {
        c(": was expecting closing '" + (char)paramInt3 + "' for name");
      }
      char[] arrayOfChar = this.J;
      int k = this.f;
      this.f = (k + 1);
      int j = arrayOfChar[k];
      if (j <= 92) {
        if (j != 92) {}
      }
      for (int i = Q();; i = j)
      {
        paramInt2 = paramInt2 * 31 + j;
        k = paramInt1 + 1;
        localObject[paramInt1] = i;
        if (k < localObject.length) {
          break label250;
        }
        localObject = this.p.m();
        paramInt1 = 0;
        break;
        if (j <= paramInt3)
        {
          if (j == paramInt3)
          {
            this.p.a(paramInt1);
            localObject = this.p;
            arrayOfChar = ((afy)localObject).e();
            paramInt1 = ((afy)localObject).d();
            paramInt3 = ((afy)localObject).c();
            return this.L.a(arrayOfChar, paramInt1, paramInt3, paramInt2);
          }
          if (j < 32) {
            c(j, "name");
          }
        }
      }
      label250:
      paramInt1 = k;
    }
  }
  
  private String a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    throws IOException, ov
  {
    this.p.a(this.J, paramInt1, this.f - paramInt1);
    char[] arrayOfChar = this.p.j();
    paramInt1 = this.p.l();
    int k = paramArrayOfInt.length;
    for (;;)
    {
      if ((this.f >= this.g) && (!E())) {}
      int j;
      for (;;)
      {
        this.p.a(paramInt1);
        paramArrayOfInt = this.p;
        arrayOfChar = paramArrayOfInt.e();
        paramInt1 = paramArrayOfInt.d();
        j = paramArrayOfInt.c();
        return this.L.a(arrayOfChar, paramInt1, j, paramInt2);
        int i = this.J[this.f];
        if (i <= k)
        {
          if (paramArrayOfInt[i] != 0) {}
        }
        else {
          while (Character.isJavaIdentifierPart(i))
          {
            this.f += 1;
            paramInt2 = paramInt2 * 31 + i;
            j = paramInt1 + 1;
            arrayOfChar[paramInt1] = i;
            if (j < arrayOfChar.length) {
              break label188;
            }
            arrayOfChar = this.p.m();
            paramInt1 = 0;
            break;
          }
        }
      }
      label188:
      paramInt1 = j;
    }
  }
  
  private final pb ac()
  {
    this.r = false;
    pb localpb = this.o;
    this.o = null;
    if (localpb == pb.d) {
      this.n = this.n.b(this.l, this.m);
    }
    for (;;)
    {
      this.b = localpb;
      return localpb;
      if (localpb == pb.b) {
        this.n = this.n.c(this.l, this.m);
      }
    }
  }
  
  private final char ad()
    throws IOException, ov
  {
    if ((this.f >= this.g) && (!E())) {}
    char c2;
    do
    {
      for (char c1 = '0'; (this.f >= this.g) && (!E()); c1 = c2) {
        do
        {
          return c1;
          c2 = this.J[this.f];
          if ((c2 < '0') || (c2 > '9')) {
            return '0';
          }
          if (!a(ox.g)) {
            b("Leading zeroes not allowed");
          }
          this.f += 1;
          c1 = c2;
        } while (c2 != '0');
      }
      c2 = this.J[this.f];
      if ((c2 < '0') || (c2 > '9')) {
        return '0';
      }
      this.f += 1;
      c1 = c2;
    } while (c2 == '0');
    return c2;
  }
  
  private final int ae()
    throws IOException, ov
  {
    while ((this.f < this.g) || (E()))
    {
      char[] arrayOfChar = this.J;
      int i = this.f;
      this.f = (i + 1);
      i = arrayOfChar[i];
      if (i > 32)
      {
        if (i != 47) {
          return i;
        }
        ag();
      }
      else if (i != 32)
      {
        if (i == 10) {
          ab();
        } else if (i == 13) {
          aa();
        } else if (i != 9) {
          b(i);
        }
      }
    }
    throw a("Unexpected end-of-input within/between " + this.n.d() + " entries");
  }
  
  private final int af()
    throws IOException, ov
  {
    while ((this.f < this.g) || (E()))
    {
      char[] arrayOfChar = this.J;
      i = this.f;
      this.f = (i + 1);
      int j = arrayOfChar[i];
      if (j > 32)
      {
        i = j;
        if (j != 47) {
          return i;
        }
        ag();
      }
      else if (j != 32)
      {
        if (j == 10) {
          ab();
        } else if (j == 13) {
          aa();
        } else if (j != 9) {
          b(j);
        }
      }
    }
    H();
    int i = -1;
    return i;
  }
  
  private final void ag()
    throws IOException, ov
  {
    if (!a(ox.b)) {
      b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((this.f >= this.g) && (!E())) {
      c(" in a comment");
    }
    char[] arrayOfChar = this.J;
    int i = this.f;
    this.f = (i + 1);
    i = arrayOfChar[i];
    if (i == 47)
    {
      ai();
      return;
    }
    if (i == 42)
    {
      ah();
      return;
    }
    b(i, "was expecting either '*' or '/' for a comment");
  }
  
  private final void ah()
    throws IOException, ov
  {
    for (;;)
    {
      int i;
      if ((this.f < this.g) || (E()))
      {
        char[] arrayOfChar = this.J;
        i = this.f;
        this.f = (i + 1);
        i = arrayOfChar[i];
        if (i > 42) {
          continue;
        }
        if (i != 42) {
          break label101;
        }
        if ((this.f < this.g) || (E())) {}
      }
      else
      {
        c(" in a comment");
        return;
      }
      if (this.J[this.f] == '/')
      {
        this.f += 1;
        return;
        label101:
        if (i < 32) {
          if (i == 10) {
            ab();
          } else if (i == 13) {
            aa();
          } else if (i != 9) {
            b(i);
          }
        }
      }
    }
  }
  
  private final void ai()
    throws IOException, ov
  {
    for (;;)
    {
      int i;
      if ((this.f < this.g) || (E()))
      {
        char[] arrayOfChar = this.J;
        i = this.f;
        this.f = (i + 1);
        i = arrayOfChar[i];
        if (i >= 32) {
          continue;
        }
        if (i == 10) {
          ab();
        }
      }
      else
      {
        return;
      }
      if (i == 13)
      {
        aa();
        return;
      }
      if (i != 9) {
        b(i);
      }
    }
  }
  
  protected final boolean E()
    throws IOException
  {
    boolean bool2 = false;
    this.h += this.g;
    this.j -= this.g;
    boolean bool1 = bool2;
    int i;
    if (this.I != null)
    {
      i = this.I.read(this.J, 0, this.J.length);
      if (i <= 0) {
        break label74;
      }
      this.f = 0;
      this.g = i;
      bool1 = true;
    }
    label74:
    do
    {
      return bool1;
      F();
      bool1 = bool2;
    } while (i != 0);
    throw new IOException("Reader returned 0 characters when trying to read " + this.g);
  }
  
  protected void F()
    throws IOException
  {
    if (this.I != null)
    {
      if ((this.d.b()) || (a(ox.a))) {
        this.I.close();
      }
      this.I = null;
    }
  }
  
  protected void G()
    throws IOException
  {
    super.G();
    char[] arrayOfChar = this.J;
    if (arrayOfChar != null)
    {
      this.J = null;
      this.d.a(arrayOfChar);
    }
  }
  
  protected final char Q()
    throws IOException, ov
  {
    int j = 0;
    if ((this.f >= this.g) && (!E())) {
      c(" in character escape sequence");
    }
    char[] arrayOfChar = this.J;
    int i = this.f;
    this.f = (i + 1);
    char c2 = arrayOfChar[i];
    char c1 = c2;
    switch (c2)
    {
    default: 
      c1 = a(c2);
    case '"': 
    case '/': 
    case '\\': 
      return c1;
    case 'b': 
      return '\b';
    case 't': 
      return '\t';
    case 'n': 
      return '\n';
    case 'f': 
      return '\f';
    case 'r': 
      return '\r';
    }
    i = 0;
    while (i < 4)
    {
      if ((this.f >= this.g) && (!E())) {
        c(" in character escape sequence");
      }
      arrayOfChar = this.J;
      int k = this.f;
      this.f = (k + 1);
      k = arrayOfChar[k];
      int m = afr.a(k);
      if (m < 0) {
        b(k, "expected a hex-digit for character escape sequence");
      }
      j = j << 4 | m;
      i += 1;
    }
    return (char)j;
  }
  
  protected final String V()
    throws IOException, ov
  {
    int k = this.f;
    int i = 0;
    int m = 0;
    int n = this.g;
    int j = k;
    if (k < n)
    {
      int[] arrayOfInt = afr.a();
      int i1 = arrayOfInt.length;
      j = k;
      i = m;
      k = this.J[j];
      if (k == 39)
      {
        k = this.f;
        this.f = (j + 1);
        return this.L.a(this.J, k, j - k, i);
      }
      if ((k >= i1) || (arrayOfInt[k] == 0)) {
        break label113;
      }
    }
    for (;;)
    {
      k = this.f;
      this.f = j;
      return a(k, i, 39);
      label113:
      m = i * 31 + k;
      k = j + 1;
      i = m;
      j = k;
      if (k < n) {
        break;
      }
      i = m;
      j = k;
    }
  }
  
  protected final pb W()
    throws IOException, ov
  {
    char[] arrayOfChar1 = this.p.k();
    int k = this.p.l();
    if ((this.f >= this.g) && (!E())) {
      c(": was expecting closing quote for a string value");
    }
    char[] arrayOfChar2 = this.J;
    int m = this.f;
    this.f = (m + 1);
    int j = arrayOfChar2[m];
    int i = j;
    if (j <= 92)
    {
      if (j == 92) {
        i = Q();
      }
    }
    else
    {
      label87:
      if (k < arrayOfChar1.length) {
        break label168;
      }
      arrayOfChar1 = this.p.m();
      k = 0;
    }
    label168:
    for (;;)
    {
      m = k + 1;
      arrayOfChar1[k] = i;
      k = m;
      break;
      i = j;
      if (j > 39) {
        break label87;
      }
      if (j == 39)
      {
        this.p.a(k);
        return pb.h;
      }
      i = j;
      if (j >= 32) {
        break label87;
      }
      c(j, "string value");
      i = j;
      break label87;
    }
  }
  
  protected void X()
    throws IOException, ov
  {
    int i = this.f;
    int k = this.g;
    int j = i;
    if (i < k)
    {
      int[] arrayOfInt = afr.a();
      int m = arrayOfInt.length;
      do
      {
        int n = this.J[i];
        if ((n < m) && (arrayOfInt[n] != 0))
        {
          j = i;
          if (n != 34) {
            break;
          }
          this.p.a(this.J, this.f, i - this.f);
          this.f = (i + 1);
          return;
        }
        j = i + 1;
        i = j;
      } while (j < k);
    }
    this.p.b(this.J, this.f, j - this.f);
    this.f = j;
    Y();
  }
  
  protected void Y()
    throws IOException, ov
  {
    char[] arrayOfChar1 = this.p.j();
    int k = this.p.l();
    if ((this.f >= this.g) && (!E())) {
      c(": was expecting closing quote for a string value");
    }
    char[] arrayOfChar2 = this.J;
    int m = this.f;
    this.f = (m + 1);
    int j = arrayOfChar2[m];
    int i = j;
    if (j <= 92)
    {
      if (j == 92) {
        i = Q();
      }
    }
    else
    {
      label87:
      if (k < arrayOfChar1.length) {
        break label165;
      }
      arrayOfChar1 = this.p.m();
      k = 0;
    }
    label165:
    for (;;)
    {
      m = k + 1;
      arrayOfChar1[k] = i;
      k = m;
      break;
      i = j;
      if (j > 34) {
        break label87;
      }
      if (j == 34)
      {
        this.p.a(k);
        return;
      }
      i = j;
      if (j >= 32) {
        break label87;
      }
      c(j, "string value");
      i = j;
      break label87;
    }
  }
  
  protected void Z()
    throws IOException, ov
  {
    this.M = false;
    int i = this.f;
    int j = this.g;
    char[] arrayOfChar = this.J;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i >= j)
      {
        this.f = i;
        if (!E()) {
          c(": was expecting closing quote for a string value");
        }
        m = this.f;
        k = this.g;
      }
      i = m + 1;
      j = arrayOfChar[m];
      if (j <= 92)
      {
        if (j == 92)
        {
          this.f = i;
          Q();
          i = this.f;
          j = this.g;
          continue;
        }
        if (j <= 34)
        {
          if (j == 34)
          {
            this.f = i;
            return;
          }
          if (j < 32)
          {
            this.f = i;
            c(j, "string value");
          }
        }
      }
      j = k;
    }
  }
  
  protected pb a(int paramInt, boolean paramBoolean)
    throws IOException, ov
  {
    double d = Double.NEGATIVE_INFINITY;
    int i = paramInt;
    Object localObject;
    if (paramInt == 73)
    {
      if ((this.f >= this.g) && (!E())) {
        T();
      }
      localObject = this.J;
      paramInt = this.f;
      this.f = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt != 78) {
        break label162;
      }
      if (paramBoolean)
      {
        localObject = "-INF";
        a((String)localObject, 3);
        if (!a(ox.h)) {
          break label117;
        }
        if (!paramBoolean) {
          break label110;
        }
      }
      for (;;)
      {
        return a((String)localObject, d);
        localObject = "+INF";
        break;
        label110:
        d = Double.POSITIVE_INFINITY;
      }
      label117:
      d("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      i = paramInt;
    }
    for (;;)
    {
      a(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
      return null;
      label162:
      i = paramInt;
      if (paramInt == 110)
      {
        if (paramBoolean)
        {
          localObject = "-Infinity";
          a((String)localObject, 3);
          if (!a(ox.h)) {
            break label224;
          }
          if (!paramBoolean) {
            break label217;
          }
        }
        for (;;)
        {
          return a((String)localObject, d);
          localObject = "+Infinity";
          break;
          label217:
          d = Double.POSITIVE_INFINITY;
        }
        label224:
        d("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        i = paramInt;
      }
    }
  }
  
  public pc a()
  {
    return this.K;
  }
  
  protected final String a(pb parampb)
  {
    if (parampb == null) {
      return null;
    }
    switch (pn.a[parampb.ordinal()])
    {
    default: 
      return parampb.a();
    case 1: 
      return this.n.h();
    }
    return this.p.f();
  }
  
  protected final void a(String paramString, int paramInt)
    throws IOException, ov
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((this.f >= this.g) && (!E())) {
        T();
      }
      if (this.J[this.f] != paramString.charAt(paramInt)) {
        a(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      this.f += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((this.f >= this.g) && (!E())) {}
    char c;
    do
    {
      return;
      c = this.J[this.f];
    } while ((c < '0') || (c == ']') || (c == '}') || (!Character.isJavaIdentifierPart(c)));
    this.f += 1;
    a(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
  }
  
  protected void a(String paramString1, String paramString2)
    throws IOException, ov
  {
    paramString1 = new StringBuilder(paramString1);
    for (;;)
    {
      if ((this.f >= this.g) && (!E())) {}
      char c;
      do
      {
        d("Unrecognized token '" + paramString1.toString() + "': was expecting ");
        return;
        c = this.J[this.f];
      } while (!Character.isJavaIdentifierPart(c));
      this.f += 1;
      paramString1.append(c);
    }
  }
  
  public byte[] a(on paramon)
    throws IOException, ov
  {
    if ((this.b != pb.h) && ((this.b != pb.g) || (this.t == null))) {
      d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    if (this.M) {}
    for (;;)
    {
      try
      {
        this.t = b(paramon);
        this.M = false;
        return this.t;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw a("Failed to decode VALUE_STRING as base64 (" + paramon + "): " + localIllegalArgumentException.getMessage());
      }
      if (this.t == null)
      {
        afq localafq = I();
        a(k(), localafq, paramon);
        this.t = localafq.b();
      }
    }
  }
  
  protected final void aa()
    throws IOException
  {
    if (((this.f < this.g) || (E())) && (this.J[this.f] == '\n')) {
      this.f += 1;
    }
    this.i += 1;
    this.j = this.f;
  }
  
  protected final void ab()
    throws IOException
  {
    this.i += 1;
    this.j = this.f;
  }
  
  public pb b()
    throws IOException, ov
  {
    this.y = 0;
    if (this.b == pb.f) {
      return ac();
    }
    if (this.M) {
      Z();
    }
    int j = af();
    if (j < 0)
    {
      close();
      this.b = null;
      return null;
    }
    this.k = (this.h + this.f - 1L);
    this.l = this.i;
    this.m = (this.f - this.j - 1);
    this.t = null;
    Object localObject;
    if (j == 93)
    {
      if (!this.n.a()) {
        a(j, '}');
      }
      this.n = this.n.i();
      localObject = pb.e;
      this.b = ((pb)localObject);
      return (pb)localObject;
    }
    if (j == 125)
    {
      if (!this.n.c()) {
        a(j, ']');
      }
      this.n = this.n.i();
      localObject = pb.c;
      this.b = ((pb)localObject);
      return (pb)localObject;
    }
    int i = j;
    if (this.n.j())
    {
      if (j != 44) {
        b(j, "was expecting comma to separate " + this.n.d() + " entries");
      }
      i = ae();
    }
    boolean bool = this.n.c();
    j = i;
    if (bool)
    {
      localObject = e(i);
      this.n.a((String)localObject);
      this.b = pb.f;
      i = ae();
      if (i != 58) {
        b(i, "was expecting a colon to separate field name and value");
      }
      j = ae();
    }
    switch (j)
    {
    default: 
      localObject = g(j);
    }
    while (bool)
    {
      this.o = ((pb)localObject);
      return this.b;
      this.M = true;
      localObject = pb.h;
      continue;
      if (!bool) {
        this.n = this.n.b(this.l, this.m);
      }
      localObject = pb.d;
      continue;
      if (!bool) {
        this.n = this.n.c(this.l, this.m);
      }
      localObject = pb.b;
      continue;
      b(j, "expected a value");
      a("true", 1);
      localObject = pb.k;
      continue;
      a("false", 1);
      localObject = pb.l;
      continue;
      a("null", 1);
      localObject = pb.m;
      continue;
      localObject = d(j);
    }
    this.b = ((pb)localObject);
    return (pb)localObject;
  }
  
  protected byte[] b(on paramon)
    throws IOException, ov
  {
    afq localafq = I();
    for (;;)
    {
      if (this.f >= this.g) {
        D();
      }
      char[] arrayOfChar = this.J;
      int i = this.f;
      this.f = (i + 1);
      char c = arrayOfChar[i];
      if (c > ' ')
      {
        int j = paramon.b(c);
        i = j;
        if (j < 0)
        {
          if (c == '"') {
            return localafq.b();
          }
          i = a(paramon, c, 0);
          if (i < 0) {}
        }
        else
        {
          if (this.f >= this.g) {
            D();
          }
          arrayOfChar = this.J;
          j = this.f;
          this.f = (j + 1);
          c = arrayOfChar[j];
          int k = paramon.b(c);
          j = k;
          if (k < 0) {
            j = a(paramon, c, 1);
          }
          int m = j | i << 6;
          if (this.f >= this.g) {
            D();
          }
          arrayOfChar = this.J;
          i = this.f;
          this.f = (i + 1);
          c = arrayOfChar[i];
          j = paramon.b(c);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((c == '"') && (!paramon.a()))
              {
                localafq.a(m >> 4);
                return localafq.b();
              }
              i = a(paramon, c, 2);
            }
            k = i;
            if (i == -2)
            {
              if (this.f >= this.g) {
                D();
              }
              arrayOfChar = this.J;
              i = this.f;
              this.f = (i + 1);
              c = arrayOfChar[i];
              if (!paramon.a(c)) {
                throw a(paramon, c, 3, "expected padding character '" + paramon.b() + "'");
              }
              localafq.a(m >> 4);
              continue;
            }
          }
          m = m << 6 | k;
          if (this.f >= this.g) {
            D();
          }
          arrayOfChar = this.J;
          i = this.f;
          this.f = (i + 1);
          c = arrayOfChar[i];
          j = paramon.b(c);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((c == '"') && (!paramon.a()))
              {
                localafq.b(m >> 2);
                return localafq.b();
              }
              i = a(paramon, c, 3);
            }
            k = i;
            if (i == -2)
            {
              localafq.b(m >> 2);
              continue;
            }
          }
          localafq.c(k | m << 6);
        }
      }
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this.L.b();
  }
  
  protected final pb d(int paramInt)
    throws IOException, ov
  {
    int k = 1;
    int n = 0;
    int i3 = 0;
    boolean bool;
    int i;
    int i2;
    int i4;
    if (paramInt == 45)
    {
      bool = true;
      i = this.f;
      i2 = i - 1;
      i4 = this.g;
      if (!bool) {
        break label123;
      }
      if (i < this.g) {
        break label75;
      }
    }
    label57:
    label75:
    char[] arrayOfChar;
    int j;
    int m;
    for (;;)
    {
      if (bool)
      {
        paramInt = i2 + 1;
        this.f = paramInt;
        return a(bool);
        bool = false;
        break;
        arrayOfChar = this.J;
        j = i + 1;
        m = arrayOfChar[i];
        if (m <= 57)
        {
          paramInt = j;
          i = m;
          if (m >= 48) {}
        }
        else
        {
          this.f = j;
          return a(m, true);
          label123:
          j = i;
          i = paramInt;
          paramInt = j;
        }
        if (i != 48)
        {
          i = paramInt;
          label137:
          if (i < this.g)
          {
            arrayOfChar = this.J;
            paramInt = i + 1;
            j = arrayOfChar[i];
            if ((j < 48) || (j > 57))
            {
              if (j != 46) {
                break label438;
              }
              i = 0;
              j = paramInt;
              paramInt = i;
              label184:
              if (j >= i4) {
                break label359;
              }
              arrayOfChar = this.J;
              i = j + 1;
              j = arrayOfChar[j];
              if ((j >= 48) && (j <= 57)) {
                break label352;
              }
              if (paramInt == 0) {
                a(j, "Decimal point not followed by a digit");
              }
              m = paramInt;
              paramInt = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i1;
      if (j != 101)
      {
        i1 = paramInt;
        if (j != 69) {}
      }
      else
      {
        if (paramInt >= i4) {
          break;
        }
        arrayOfChar = this.J;
        i = paramInt + 1;
        j = arrayOfChar[paramInt];
        if ((j != 45) && (j != 43)) {
          break label430;
        }
        if (i >= i4) {
          break;
        }
        arrayOfChar = this.J;
        paramInt = i + 1;
        j = arrayOfChar[i];
        i = i3;
      }
      for (;;)
      {
        if ((j <= 57) && (j >= 48))
        {
          i += 1;
          if (paramInt >= i4) {
            break;
          }
          j = this.J[paramInt];
          paramInt += 1;
          continue;
          k += 1;
          i = paramInt;
          break label137;
          break;
          label352:
          paramInt += 1;
          j = i;
          break label184;
          label359:
          break;
        }
        n = i;
        i1 = paramInt;
        if (i == 0)
        {
          a(j, "Exponent indicator not followed by a digit");
          i1 = paramInt;
          n = i;
        }
        paramInt = i1 - 1;
        this.f = paramInt;
        this.p.a(this.J, i2, paramInt - i2);
        return a(bool, k, m, n);
        paramInt = i2;
        break label57;
        label430:
        paramInt = i;
        i = i3;
      }
      label438:
      m = 0;
    }
  }
  
  protected char e(String paramString)
    throws IOException, ov
  {
    if ((this.f >= this.g) && (!E())) {
      c(paramString);
    }
    paramString = this.J;
    int i = this.f;
    this.f = (i + 1);
    return paramString[i];
  }
  
  protected final String e(int paramInt)
    throws IOException, ov
  {
    if (paramInt != 34) {
      return f(paramInt);
    }
    paramInt = this.f;
    int k = 0;
    int i = 0;
    int m = this.g;
    int j = paramInt;
    if (paramInt < m)
    {
      int[] arrayOfInt = afr.a();
      int n = arrayOfInt.length;
      do
      {
        int i1 = this.J[paramInt];
        if ((i1 < n) && (arrayOfInt[i1] != 0))
        {
          k = i;
          j = paramInt;
          if (i1 != 34) {
            break;
          }
          j = this.f;
          this.f = (paramInt + 1);
          return this.L.a(this.J, j, paramInt - j, i);
        }
        k = i * 31 + i1;
        j = paramInt + 1;
        i = k;
        paramInt = j;
      } while (j < m);
    }
    paramInt = this.f;
    this.f = j;
    return a(paramInt, k, 34);
  }
  
  protected final String f(int paramInt)
    throws IOException, ov
  {
    int j = 0;
    int k = 0;
    if ((paramInt == 39) && (a(ox.d))) {
      return V();
    }
    if (!a(ox.c)) {
      b(paramInt, "was expecting double-quote to start field name");
    }
    int[] arrayOfInt = afr.b();
    int m = arrayOfInt.length;
    boolean bool;
    int n;
    if (paramInt < m) {
      if ((arrayOfInt[paramInt] == 0) && ((paramInt < 48) || (paramInt > 57)))
      {
        bool = true;
        if (!bool) {
          b(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        i = this.f;
        n = this.g;
        paramInt = i;
        if (i >= n) {
          break label246;
        }
        paramInt = k;
      }
    }
    label219:
    do
    {
      j = this.J[i];
      if (j < m)
      {
        if (arrayOfInt[j] == 0) {
          break label219;
        }
        j = this.f - 1;
        this.f = i;
        return this.L.a(this.J, j, i - j, paramInt);
        bool = false;
        break;
        bool = Character.isJavaIdentifierPart((char)paramInt);
        break;
      }
      if (!Character.isJavaIdentifierPart((char)j))
      {
        j = this.f - 1;
        this.f = i;
        return this.L.a(this.J, j, i - j, paramInt);
      }
      j = paramInt * 31 + j;
      k = i + 1;
      i = k;
      paramInt = j;
    } while (k < n);
    paramInt = k;
    label246:
    int i = this.f;
    this.f = paramInt;
    return a(i - 1, j, arrayOfInt);
  }
  
  protected final pb g(int paramInt)
    throws IOException, ov
  {
    switch (paramInt)
    {
    default: 
    case 39: 
    case 78: 
      for (;;)
      {
        b(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
        if (a(ox.d))
        {
          return W();
          a("NaN", 1);
          if (a(ox.h)) {
            return a("NaN", NaN.0D);
          }
          d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
    }
    if ((this.f >= this.g) && (!E())) {
      T();
    }
    char[] arrayOfChar = this.J;
    paramInt = this.f;
    this.f = (paramInt + 1);
    return a(arrayOfChar[paramInt], false);
  }
  
  public final String k()
    throws IOException, ov
  {
    pb localpb = this.b;
    if (localpb == pb.h)
    {
      if (this.M)
      {
        this.M = false;
        X();
      }
      return this.p.f();
    }
    return a(localpb);
  }
  
  public char[] l()
    throws IOException, ov
  {
    if (this.b != null)
    {
      switch (pn.a[this.b.ordinal()])
      {
      default: 
        return this.b.b();
      case 1: 
        String str;
        int i;
        if (!this.r)
        {
          str = this.n.h();
          i = str.length();
          if (this.q != null) {
            break label116;
          }
          this.q = this.d.a(i);
        }
        for (;;)
        {
          str.getChars(0, i, this.q, 0);
          this.r = true;
          return this.q;
          if (this.q.length < i) {
            this.q = new char[i];
          }
        }
      case 2: 
        label116:
        if (this.M)
        {
          this.M = false;
          X();
        }
        break;
      }
      return this.p.e();
    }
    return null;
  }
  
  public int m()
    throws IOException, ov
  {
    int i = 0;
    if (this.b != null) {}
    switch (pn.a[this.b.ordinal()])
    {
    default: 
      i = this.b.b().length;
      return i;
    case 1: 
      return this.n.h().length();
    case 2: 
      if (this.M)
      {
        this.M = false;
        X();
      }
      break;
    }
    return this.p.c();
  }
  
  public int n()
    throws IOException, ov
  {
    if (this.b != null) {}
    switch (pn.a[this.b.ordinal()])
    {
    case 1: 
    default: 
      return 0;
    case 2: 
      if (this.M)
      {
        this.M = false;
        X();
      }
      break;
    }
    return this.p.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */