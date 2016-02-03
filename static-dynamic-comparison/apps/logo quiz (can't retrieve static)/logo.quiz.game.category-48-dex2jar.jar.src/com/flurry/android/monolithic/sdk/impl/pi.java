package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class pi
  extends ow
{
  protected pi() {}
  
  protected pi(int paramInt)
  {
    super(paramInt);
  }
  
  protected static final String c(int paramInt)
  {
    char c = (char)paramInt;
    if (Character.isISOControl(c)) {
      return "(CTRL-CHAR, code " + paramInt + ")";
    }
    if (paramInt > 255) {
      return "'" + c + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
    }
    return "'" + c + "' (code " + paramInt + ")";
  }
  
  protected abstract void H()
    throws ov;
  
  protected void R()
    throws ov
  {
    throw a("Unexpected end-of-String in base64 content");
  }
  
  protected void S()
    throws ov
  {
    c(" in " + this.b);
  }
  
  protected void T()
    throws ov
  {
    c(" in a value");
  }
  
  protected final void U()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  protected char a(char paramChar)
    throws oz
  {
    if (a(ox.f)) {}
    while ((paramChar == '\'') && (a(ox.d))) {
      return paramChar;
    }
    d("Unrecognized character escape " + c(paramChar));
    return paramChar;
  }
  
  protected void a(on paramon, char paramChar, int paramInt, String paramString)
    throws ov
  {
    if (paramChar <= ' ') {
      paramon = "Illegal white space character (code 0x" + Integer.toHexString(paramChar) + ") as character #" + (paramInt + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramon;
      if (paramString != null) {
        localObject = paramon + ": " + paramString;
      }
      throw a((String)localObject);
      if (paramon.a(paramChar)) {
        paramon = "Unexpected padding character ('" + paramon.b() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
        paramon = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      } else {
        paramon = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      }
    }
  }
  
  protected void a(String paramString, afq paramafq, on paramon)
    throws IOException, ov
  {
    int k = paramString.length();
    int i = 0;
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      char c = paramString.charAt(i);
      if (j >= k) {
        return;
      }
      if (c > ' ')
      {
        int m = paramon.b(c);
        if (m < 0) {
          a(paramon, c, 0, null);
        }
        if (j >= k) {
          R();
        }
        i = j + 1;
        c = paramString.charAt(j);
        j = paramon.b(c);
        if (j < 0) {
          a(paramon, c, 1, null);
        }
        m = m << 6 | j;
        if (i >= k)
        {
          if (!paramon.a())
          {
            paramafq.a(m >> 4);
            return;
          }
          R();
        }
        j = i + 1;
        c = paramString.charAt(i);
        i = paramon.b(c);
        if (i < 0)
        {
          if (i != -2) {
            a(paramon, c, 2, null);
          }
          if (j >= k) {
            R();
          }
          i = j + 1;
          c = paramString.charAt(j);
          if (!paramon.a(c)) {
            a(paramon, c, 3, "expected padding character '" + paramon.b() + "'");
          }
          paramafq.a(m >> 4);
          break;
        }
        m = m << 6 | i;
        if (j >= k)
        {
          if (!paramon.a())
          {
            paramafq.b(m >> 2);
            return;
          }
          R();
        }
        i = j + 1;
        c = paramString.charAt(j);
        j = paramon.b(c);
        if (j < 0)
        {
          if (j != -2) {
            a(paramon, c, 3, null);
          }
          paramafq.b(m >> 2);
          break;
        }
        paramafq.c(m << 6 | j);
        break;
      }
      i = j;
    }
  }
  
  protected final void a(String paramString, Throwable paramThrowable)
    throws ov
  {
    throw b(paramString, paramThrowable);
  }
  
  protected final ov b(String paramString, Throwable paramThrowable)
  {
    return new ov(paramString, i(), paramThrowable);
  }
  
  public abstract pb b()
    throws IOException, ov;
  
  protected void b(int paramInt)
    throws ov
  {
    paramInt = (char)paramInt;
    d("Illegal character (" + c(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
  }
  
  protected void b(int paramInt, String paramString)
    throws ov
  {
    String str2 = "Unexpected character (" + c(paramInt) + ")";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    d(str1);
  }
  
  protected void c(int paramInt, String paramString)
    throws ov
  {
    if ((!a(ox.e)) || (paramInt >= 32))
    {
      paramInt = (char)paramInt;
      d("Illegal unquoted character (" + c(paramInt) + "): has to be escaped using backslash to be included in " + paramString);
    }
  }
  
  protected void c(String paramString)
    throws ov
  {
    d("Unexpected end-of-input" + paramString);
  }
  
  public ow d()
    throws IOException, ov
  {
    if ((this.b != pb.b) && (this.b != pb.d)) {
      return this;
    }
    int i = 1;
    int j;
    do
    {
      for (;;)
      {
        pb localpb = b();
        if (localpb == null)
        {
          H();
          return this;
        }
        switch (pj.a[localpb.ordinal()])
        {
        default: 
          break;
        case 1: 
        case 2: 
          i += 1;
        }
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    return this;
  }
  
  protected final void d(String paramString)
    throws ov
  {
    throw a(paramString);
  }
  
  public abstract String k()
    throws IOException, ov;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */