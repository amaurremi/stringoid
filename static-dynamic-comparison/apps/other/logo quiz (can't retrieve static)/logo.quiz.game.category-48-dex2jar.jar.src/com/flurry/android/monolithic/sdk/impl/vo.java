package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Date;

public abstract class vo<T>
  extends qu<T>
{
  protected final Class<?> q;
  
  protected vo(afm paramafm)
  {
    if (paramafm == null) {}
    for (paramafm = null;; paramafm = paramafm.p())
    {
      this.q = paramafm;
      return;
    }
  }
  
  protected vo(Class<?> paramClass)
  {
    this.q = paramClass;
  }
  
  protected static final double b(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return 2.2250738585072014E-308D;
    }
    return Double.parseDouble(paramString);
  }
  
  protected final double A(ow paramow, qm paramqm)
    throws IOException, oz
  {
    double d = 0.0D;
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      d = paramow.x();
    }
    do
    {
      do
      {
        return d;
        if (localpb != pb.h) {
          break;
        }
        paramow = paramow.k().trim();
      } while (paramow.length() == 0);
      switch (paramow.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          d = b(paramow);
          return d;
        }
        catch (IllegalArgumentException paramow)
        {
          throw paramqm.b(this.q, "not a valid double value");
        }
        if (("Infinity".equals(paramow)) || ("INF".equals(paramow)))
        {
          return Double.POSITIVE_INFINITY;
          if ("NaN".equals(paramow))
          {
            return NaN.0D;
            if (("-Infinity".equals(paramow)) || ("-INF".equals(paramow))) {
              return Double.NEGATIVE_INFINITY;
            }
          }
        }
      }
    } while (localpb == pb.m);
    throw paramqm.a(this.q, localpb);
  }
  
  protected Date B(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.i) {
      return new Date(paramow.u());
    }
    if (localpb == pb.m) {
      return (Date)b();
    }
    if (localpb == pb.h) {
      try
      {
        paramow = paramow.k().trim();
        if (paramow.length() == 0) {
          return (Date)c();
        }
        paramow = paramqm.a(paramow);
        return paramow;
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid representation (error: " + paramow.getMessage() + ")");
      }
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected qu<Object> a(qk paramqk, qq paramqq, afm paramafm, qc paramqc)
    throws qw
  {
    return paramqq.a(paramqk, paramafm, paramqc);
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.d(paramow, paramqm);
  }
  
  protected void a(ow paramow, qm paramqm, Object paramObject, String paramString)
    throws IOException, oz
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = f();
    }
    if (paramqm.a(paramow, this, localObject, paramString)) {
      return;
    }
    a(paramqm, localObject, paramString);
    paramow.d();
  }
  
  protected void a(qm paramqm, Object paramObject, String paramString)
    throws IOException, oz
  {
    if (paramqm.a(ql.k)) {
      throw paramqm.a(paramObject, paramString);
    }
  }
  
  protected boolean a(qu<?> paramqu)
  {
    return (paramqu != null) && (paramqu.getClass().getAnnotation(rz.class) != null);
  }
  
  public Class<?> f()
  {
    return this.q;
  }
  
  protected final boolean n(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.k) {}
    label65:
    do
    {
      do
      {
        return true;
        if (localpb == pb.l) {
          return false;
        }
        if (localpb == pb.m) {
          return false;
        }
        if (localpb != pb.i) {
          break label65;
        }
        if (paramow.q() != oy.a) {
          break;
        }
      } while (paramow.t() != 0);
      return false;
      return p(paramow, paramqm);
      if (localpb != pb.h) {
        break;
      }
      paramow = paramow.k().trim();
    } while ("true".equals(paramow));
    if (("false".equals(paramow)) || (paramow.length() == 0)) {
      return Boolean.FALSE.booleanValue();
    }
    throw paramqm.b(this.q, "only \"true\" or \"false\" recognized");
    throw paramqm.a(this.q, localpb);
  }
  
  protected final Boolean o(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.k) {
      return Boolean.TRUE;
    }
    if (localpb == pb.l) {
      return Boolean.FALSE;
    }
    if (localpb == pb.i)
    {
      if (paramow.q() == oy.a)
      {
        if (paramow.t() == 0) {
          return Boolean.FALSE;
        }
        return Boolean.TRUE;
      }
      return Boolean.valueOf(p(paramow, paramqm));
    }
    if (localpb == pb.m) {
      return (Boolean)b();
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      if ("true".equals(paramow)) {
        return Boolean.TRUE;
      }
      if ("false".equals(paramow)) {
        return Boolean.FALSE;
      }
      if (paramow.length() == 0) {
        return (Boolean)c();
      }
      throw paramqm.b(this.q, "only \"true\" or \"false\" recognized");
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected final boolean p(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.q() == oy.b)
    {
      if (paramow.u() == 0L) {}
      for (paramow = Boolean.FALSE;; paramow = Boolean.TRUE) {
        return paramow.booleanValue();
      }
    }
    paramow = paramow.k();
    if (("0.0".equals(paramow)) || ("0".equals(paramow))) {
      return Boolean.FALSE.booleanValue();
    }
    return Boolean.TRUE.booleanValue();
  }
  
  protected Byte q(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return Byte.valueOf(paramow.r());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      int i;
      try
      {
        if (paramow.length() == 0) {
          return (Byte)c();
        }
        i = pt.a(paramow);
        if ((i < -128) || (i > 127)) {
          throw paramqm.b(this.q, "overflow, value can not be represented as 8-bit value");
        }
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid Byte value");
      }
      return Byte.valueOf((byte)i);
    }
    if (localpb == pb.m) {
      return (Byte)b();
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected Short r(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return Short.valueOf(paramow.s());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      int i;
      try
      {
        if (paramow.length() == 0) {
          return (Short)c();
        }
        i = pt.a(paramow);
        if ((i < 32768) || (i > 32767)) {
          throw paramqm.b(this.q, "overflow, value can not be represented as 16-bit value");
        }
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid Short value");
      }
      return Short.valueOf((short)i);
    }
    if (localpb == pb.m) {
      return (Short)b();
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected final short s(ow paramow, qm paramqm)
    throws IOException, oz
  {
    int i = t(paramow, paramqm);
    if ((i < 32768) || (i > 32767)) {
      throw paramqm.b(this.q, "overflow, value can not be represented as 16-bit value");
    }
    return (short)i;
  }
  
  protected final int t(ow paramow, qm paramqm)
    throws IOException, oz
  {
    int i = 0;
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      i = paramow.t();
    }
    do
    {
      int j;
      do
      {
        return i;
        if (localpb != pb.h) {
          break;
        }
        paramow = paramow.k().trim();
        long l;
        try
        {
          j = paramow.length();
          if (j <= 9) {
            continue;
          }
          l = Long.parseLong(paramow);
          if ((l < -2147483648L) || (l > 2147483647L)) {
            throw paramqm.b(this.q, "Overflow: numeric value (" + paramow + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
        }
        catch (IllegalArgumentException paramow)
        {
          throw paramqm.b(this.q, "not a valid int value");
        }
        return (int)l;
      } while (j == 0);
      i = pt.a(paramow);
      return i;
    } while (localpb == pb.m);
    throw paramqm.a(this.q, localpb);
  }
  
  protected final Integer u(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return Integer.valueOf(paramow.t());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      long l;
      try
      {
        i = paramow.length();
        if (i <= 9) {
          break label161;
        }
        l = Long.parseLong(paramow);
        if ((l < -2147483648L) || (l > 2147483647L)) {
          throw paramqm.b(this.q, "Overflow: numeric value (" + paramow + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
        }
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid Integer value");
      }
      int i = (int)l;
      return Integer.valueOf(i);
      label161:
      if (i == 0) {
        return (Integer)c();
      }
      i = pt.a(paramow);
      return Integer.valueOf(i);
    }
    if (localpb == pb.m) {
      return (Integer)b();
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected final Long v(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return Long.valueOf(paramow.u());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      if (paramow.length() == 0) {
        return (Long)c();
      }
      try
      {
        long l = pt.b(paramow);
        return Long.valueOf(l);
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid Long value");
      }
    }
    if (localpb == pb.m) {
      return (Long)b();
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected final long w(ow paramow, qm paramqm)
    throws IOException, oz
  {
    long l = 0L;
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      l = paramow.u();
    }
    do
    {
      do
      {
        return l;
        if (localpb != pb.h) {
          break;
        }
        paramow = paramow.k().trim();
      } while (paramow.length() == 0);
      try
      {
        l = pt.b(paramow);
        return l;
      }
      catch (IllegalArgumentException paramow)
      {
        throw paramqm.b(this.q, "not a valid long value");
      }
    } while (localpb == pb.m);
    throw paramqm.a(this.q, localpb);
  }
  
  protected final Float x(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return Float.valueOf(paramow.w());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      if (paramow.length() == 0) {
        return (Float)c();
      }
      switch (paramow.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          float f = Float.parseFloat(paramow);
          return Float.valueOf(f);
        }
        catch (IllegalArgumentException paramow)
        {
          throw paramqm.b(this.q, "not a valid Float value");
        }
        if (("Infinity".equals(paramow)) || ("INF".equals(paramow)))
        {
          return Float.valueOf(Float.POSITIVE_INFINITY);
          if ("NaN".equals(paramow))
          {
            return Float.valueOf(NaN.0F);
            if (("-Infinity".equals(paramow)) || ("-INF".equals(paramow))) {
              return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
          }
        }
      }
    }
    if (localpb == pb.m) {
      return (Float)b();
    }
    throw paramqm.a(this.q, localpb);
  }
  
  protected final float y(ow paramow, qm paramqm)
    throws IOException, oz
  {
    float f = 0.0F;
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      f = paramow.w();
    }
    do
    {
      do
      {
        return f;
        if (localpb != pb.h) {
          break;
        }
        paramow = paramow.k().trim();
      } while (paramow.length() == 0);
      switch (paramow.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          f = Float.parseFloat(paramow);
          return f;
        }
        catch (IllegalArgumentException paramow)
        {
          throw paramqm.b(this.q, "not a valid float value");
        }
        if (("Infinity".equals(paramow)) || ("INF".equals(paramow)))
        {
          return Float.POSITIVE_INFINITY;
          if ("NaN".equals(paramow))
          {
            return NaN.0F;
            if (("-Infinity".equals(paramow)) || ("-INF".equals(paramow))) {
              return Float.NEGATIVE_INFINITY;
            }
          }
        }
      }
    } while (localpb == pb.m);
    throw paramqm.a(this.q, localpb);
  }
  
  protected final Double z(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb == pb.i) || (localpb == pb.j)) {
      return Double.valueOf(paramow.x());
    }
    if (localpb == pb.h)
    {
      paramow = paramow.k().trim();
      if (paramow.length() == 0) {
        return (Double)c();
      }
      switch (paramow.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          double d = b(paramow);
          return Double.valueOf(d);
        }
        catch (IllegalArgumentException paramow)
        {
          throw paramqm.b(this.q, "not a valid Double value");
        }
        if (("Infinity".equals(paramow)) || ("INF".equals(paramow)))
        {
          return Double.valueOf(Double.POSITIVE_INFINITY);
          if ("NaN".equals(paramow))
          {
            return Double.valueOf(NaN.0D);
            if (("-Infinity".equals(paramow)) || ("-INF".equals(paramow))) {
              return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
          }
        }
      }
    }
    if (localpb == pb.m) {
      return (Double)b();
    }
    throw paramqm.a(this.q, localpb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */