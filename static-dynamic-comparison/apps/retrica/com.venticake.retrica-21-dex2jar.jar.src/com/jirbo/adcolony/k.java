package com.jirbo.adcolony;

import java.io.PrintStream;

class k
{
  static z a = new z();
  
  static int a(int paramInt)
  {
    if ((paramInt >= 48) && (paramInt <= 57)) {
      return paramInt - 48;
    }
    if ((paramInt >= 97) && (paramInt <= 102)) {
      return paramInt - 97 + 10;
    }
    if ((paramInt >= 65) && (paramInt <= 70)) {
      return paramInt - 65 + 10;
    }
    return 0;
  }
  
  static ADCData.i a(f paramf)
  {
    paramf = paramf.b();
    if (paramf == null) {
      return null;
    }
    return a(paramf);
  }
  
  static ADCData.i a(s params)
  {
    b(params);
    int i = params.b();
    if (i == 123) {
      return c(params);
    }
    if (i == 91) {
      return d(params);
    }
    if (i == 45) {
      return h(params);
    }
    if ((i >= 48) && (i <= 57)) {
      return h(params);
    }
    if ((i == 34) || (i == 39))
    {
      params = e(params);
      if (params.length() == 0) {
        return new ADCData.f("");
      }
      i = params.charAt(0);
      if ((i == 116) && (params.equals("true"))) {
        return ADCData.a;
      }
      if ((i == 102) && (params.equals("false"))) {
        return ADCData.b;
      }
      if ((i == 110) && (params.equals("null"))) {
        return ADCData.c;
      }
      return new ADCData.f(params);
    }
    if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 95) || (i == 36))
    {
      params = g(params);
      if (params.length() == 0) {
        return new ADCData.f("");
      }
      i = params.charAt(0);
      if ((i == 116) && (params.equals("true"))) {
        return ADCData.a;
      }
      if ((i == 102) && (params.equals("false"))) {
        return ADCData.b;
      }
      if ((i == 110) && (params.equals("null"))) {
        return ADCData.c;
      }
      return new ADCData.f(params);
    }
    return null;
  }
  
  static ADCData.i a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return a(new s(paramString));
  }
  
  static void a(f paramf, ADCData.c paramc)
  {
    paramf = paramf.a();
    if (paramc != null)
    {
      paramc.a(paramf);
      paramf.d();
    }
    for (;;)
    {
      paramf.b();
      return;
      l.b.b("Saving empty property list.");
      paramf.b("[]");
    }
  }
  
  static void a(f paramf, ADCData.g paramg)
  {
    paramf = paramf.a();
    if (paramg != null)
    {
      paramg.a(paramf);
      paramf.d();
    }
    for (;;)
    {
      paramf.b();
      return;
      l.b.b("Saving empty property table.");
      paramf.b("{}");
    }
  }
  
  static void a(f paramf, ADCData.i parami)
  {
    paramf = paramf.a();
    if (parami == null) {
      paramf.b("null");
    }
    for (;;)
    {
      paramf.b();
      return;
      parami.a(paramf);
      paramf.d();
    }
  }
  
  public static void a(String[] paramArrayOfString)
  {
    System.out.println("==== ADCJSON Test ====");
    b(new f("test.txt"));
    a(new f("test2.txt"), a(new f("test.txt")));
    a(new f("test3.txt"), a(new f("test2.txt")));
  }
  
  static ADCData.g b(f paramf)
  {
    paramf = a(paramf);
    if ((paramf == null) || (!paramf.m())) {
      return null;
    }
    return paramf.n();
  }
  
  static ADCData.g b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (!paramString.m())) {
      return null;
    }
    return paramString.n();
  }
  
  static void b(s params)
  {
    for (int i = params.b(); (params.a()) && ((i <= 32) || (i > 126)); i = params.b()) {
      params.c();
    }
  }
  
  static ADCData.c c(f paramf)
  {
    paramf = a(paramf);
    if ((paramf == null) || (!paramf.f())) {
      return null;
    }
    return paramf.h();
  }
  
  static ADCData.c c(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (!paramString.f())) {
      return null;
    }
    return paramString.h();
  }
  
  static ADCData.g c(s params)
  {
    b(params);
    if (!params.a('{')) {}
    ADCData.g localg;
    do
    {
      return null;
      b(params);
      localg = new ADCData.g();
      if (params.a('}')) {
        return localg;
      }
      int i = 1;
      if ((i != 0) || (params.a(',')))
      {
        i = 0;
        String str = g(params);
        b(params);
        if (!params.a(':')) {
          localg.b(str, true);
        }
        for (;;)
        {
          b(params);
          break;
          b(params);
          localg.a(str, a(params));
        }
      }
    } while (!params.a('}'));
    return localg;
  }
  
  static ADCData.c d(s params)
  {
    b(params);
    if (!params.a('[')) {}
    ADCData.c localc;
    do
    {
      return null;
      b(params);
      localc = new ADCData.c();
      if (params.a(']')) {
        return localc;
      }
      int i = 1;
      while ((i != 0) || (params.a(',')))
      {
        i = 0;
        localc.a(a(params));
        b(params);
      }
    } while (!params.a(']'));
    return localc;
  }
  
  static String e(s params)
  {
    int i = 34;
    b(params);
    if (params.a('"')) {}
    while (!params.a())
    {
      return "";
      if (params.a('\'')) {
        i = 39;
      }
    }
    a.a();
    char c = params.c();
    if ((params.a()) && (c != i))
    {
      if (c == '\\')
      {
        c = params.c();
        if (c == 'b') {
          a.b('\b');
        }
      }
      for (;;)
      {
        c = params.c();
        break;
        if (c == 'f')
        {
          a.b('\f');
        }
        else if (c == 'n')
        {
          a.b('\n');
        }
        else if (c == 'r')
        {
          a.b('\r');
        }
        else if (c == 't')
        {
          a.b('\t');
        }
        else if (c == 'u')
        {
          a.b(f(params));
        }
        else
        {
          a.b(c);
          continue;
          a.b(c);
        }
      }
    }
    return a.toString();
  }
  
  static char f(s params)
  {
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      int k = j;
      if (params.a()) {
        k = j << 4 | a(params.c());
      }
      i += 1;
      j = k;
    }
    return (char)j;
  }
  
  static String g(s params)
  {
    b(params);
    int i = params.b();
    if ((i == 34) || (i == 39)) {
      return e(params);
    }
    a.a();
    int j = 0;
    while ((j == 0) && (params.a())) {
      if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 95) || (i == 36))
      {
        params.c();
        a.b((char)i);
        i = params.b();
      }
      else
      {
        j = 1;
      }
    }
    return a.toString();
  }
  
  static ADCData.i h(s params)
  {
    b(params);
    double d3 = 1.0D;
    if (params.a('-'))
    {
      d3 = -1.0D;
      b(params);
    }
    double d1 = 0.0D;
    for (int i = params.b(); (params.a()) && (i >= 48) && (i <= 57); i = params.b())
    {
      params.c();
      d1 = d1 * 10.0D + (i - 48);
    }
    i = 0;
    double d2 = d1;
    if (params.a('.'))
    {
      double d4 = 0.0D;
      d2 = 0.0D;
      for (i = params.b(); (params.a()) && (i >= 48) && (i <= 57); i = params.b())
      {
        params.c();
        d4 = d4 * 10.0D + (i - 48);
        d2 += 1.0D;
      }
      d2 = d1 + d4 / Math.pow(10.0D, d2);
      i = 1;
    }
    if (!params.a('e'))
    {
      d1 = d2;
      if (!params.a('E')) {}
    }
    else
    {
      int k = 0;
      int j = k;
      if (!params.a('+'))
      {
        j = k;
        if (params.a('-')) {
          j = 1;
        }
      }
      d1 = 0.0D;
      for (k = params.b(); (params.a()) && (k >= 48) && (k <= 57); k = params.b())
      {
        params.c();
        d1 = d1 * 10.0D + (k - 48);
      }
      if (j == 0) {
        break label326;
      }
    }
    label326:
    for (d1 = d2 / Math.pow(10.0D, d1);; d1 = d2 * Math.pow(10.0D, d1))
    {
      d1 *= d3;
      if ((i == 0) && (d1 == (int)d1)) {
        break;
      }
      return new ADCData.e(d1);
    }
    return new ADCData.b((int)d1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */