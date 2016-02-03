package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import java.util.Collection;

public class yw
  implements yj<yw>
{
  protected JsonTypeInfo.Id a;
  protected JsonTypeInfo.As b;
  protected String c;
  protected Class<?> d;
  protected yi e;
  
  public static yw b()
  {
    return new yw().b(JsonTypeInfo.Id.NONE, null);
  }
  
  public rw a(qk paramqk, afm paramafm, Collection<yg> paramCollection, qc paramqc)
  {
    if (this.a == JsonTypeInfo.Id.NONE) {
      return null;
    }
    paramqk = a(paramqk, paramafm, paramCollection, false, true);
    switch (yx.a[this.b.ordinal()])
    {
    default: 
      throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
    case 1: 
      return new yk(paramafm, paramqk, paramqc, this.d);
    case 2: 
      return new yo(paramafm, paramqk, paramqc, this.d, this.c);
    case 3: 
      return new yr(paramafm, paramqk, paramqc, this.d);
    }
    return new ym(paramafm, paramqk, paramqc, this.d, this.c);
  }
  
  public rx a(rq paramrq, afm paramafm, Collection<yg> paramCollection, qc paramqc)
  {
    if (this.a == JsonTypeInfo.Id.NONE) {
      return null;
    }
    paramrq = a(paramrq, paramafm, paramCollection, true, false);
    switch (yx.a[this.b.ordinal()])
    {
    default: 
      throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
    case 1: 
      return new yl(paramrq, paramqc);
    case 2: 
      return new yq(paramrq, paramqc, this.c);
    case 3: 
      return new ys(paramrq, paramqc);
    }
    return new yn(paramrq, paramqc, this.c);
  }
  
  protected yi a(rf<?> paramrf, afm paramafm, Collection<yg> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      return this.e;
    }
    if (this.a == null) {
      throw new IllegalStateException("Can not build, 'init()' not yet called");
    }
    switch (yx.b[this.a.ordinal()])
    {
    default: 
      throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.a);
    case 1: 
      return new yt(paramafm, paramrf.m());
    case 2: 
      return new yu(paramafm, paramrf.m());
    case 3: 
      return za.a(paramrf, paramafm, paramCollection, paramBoolean1, paramBoolean2);
    }
    return null;
  }
  
  public Class<?> a()
  {
    return this.d;
  }
  
  public yw b(JsonTypeInfo.As paramAs)
  {
    if (paramAs == null) {
      throw new IllegalArgumentException("includeAs can not be null");
    }
    this.b = paramAs;
    return this;
  }
  
  public yw b(JsonTypeInfo.Id paramId, yi paramyi)
  {
    if (paramId == null) {
      throw new IllegalArgumentException("idType can not be null");
    }
    this.a = paramId;
    this.e = paramyi;
    this.c = paramId.getDefaultPropertyName();
    return this;
  }
  
  public yw b(Class<?> paramClass)
  {
    this.d = paramClass;
    return this;
  }
  
  public yw b(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = this.a.getDefaultPropertyName();
    }
    this.c = str;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */