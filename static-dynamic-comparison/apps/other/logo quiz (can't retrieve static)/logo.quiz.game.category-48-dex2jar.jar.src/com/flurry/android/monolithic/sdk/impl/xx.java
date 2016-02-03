package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.org.codehaus.jackson.annotate.JsonAnyGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAnySetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonBackReference;
import com.flurry.org.codehaus.jackson.annotate.JsonCreator;
import com.flurry.org.codehaus.jackson.annotate.JsonGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnore;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreType;
import com.flurry.org.codehaus.jackson.annotate.JsonManagedReference;
import com.flurry.org.codehaus.jackson.annotate.JsonProperty;
import com.flurry.org.codehaus.jackson.annotate.JsonPropertyOrder;
import com.flurry.org.codehaus.jackson.annotate.JsonRawValue;
import com.flurry.org.codehaus.jackson.annotate.JsonSetter;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes.Type;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.None;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeName;
import com.flurry.org.codehaus.jackson.annotate.JsonUnwrapped;
import com.flurry.org.codehaus.jackson.annotate.JsonValue;
import com.flurry.org.codehaus.jackson.annotate.JsonWriteNullProperties;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class xx
  extends py
{
  public pz a(xk paramxk)
  {
    JsonManagedReference localJsonManagedReference = (JsonManagedReference)paramxk.a(JsonManagedReference.class);
    if (localJsonManagedReference != null) {
      return pz.a(localJsonManagedReference.value());
    }
    paramxk = (JsonBackReference)paramxk.a(JsonBackReference.class);
    if (paramxk != null) {
      return pz.b(paramxk.value());
    }
    return null;
  }
  
  public sf a(xg paramxg, sf paramsf)
  {
    se localse = (se)paramxg.a(se.class);
    if (localse != null) {
      return localse.h();
    }
    paramxg = (JsonWriteNullProperties)paramxg.a(JsonWriteNullProperties.class);
    if (paramxg != null)
    {
      if (paramxg.value()) {
        return sf.a;
      }
      return sf.b;
    }
    return paramsf;
  }
  
  public ye<?> a(xh paramxh, ye<?> paramye)
  {
    paramxh = (JsonAutoDetect)paramxh.a(JsonAutoDetect.class);
    if (paramxh == null) {
      return paramye;
    }
    return paramye.a(paramxh);
  }
  
  protected yj<?> a(rf<?> paramrf, xg paramxg, afm paramafm)
  {
    Object localObject2 = null;
    JsonTypeInfo localJsonTypeInfo = (JsonTypeInfo)paramxg.a(JsonTypeInfo.class);
    Object localObject1 = (si)paramxg.a(si.class);
    sh localsh;
    if (localObject1 != null)
    {
      if (localJsonTypeInfo == null) {
        return null;
      }
      localObject1 = paramrf.d(paramxg, ((si)localObject1).a());
      localsh = (sh)paramxg.a(sh.class);
      if (localsh != null) {
        break label205;
      }
    }
    label205:
    for (paramrf = (rf<?>)localObject2;; paramrf = paramrf.e(paramxg, localsh.a()))
    {
      if (paramrf != null) {
        paramrf.a(paramafm);
      }
      localObject1 = ((yj)localObject1).a(localJsonTypeInfo.use(), paramrf);
      paramafm = localJsonTypeInfo.include();
      paramrf = paramafm;
      if (paramafm == JsonTypeInfo.As.EXTERNAL_PROPERTY)
      {
        paramrf = paramafm;
        if ((paramxg instanceof xh)) {
          paramrf = JsonTypeInfo.As.PROPERTY;
        }
      }
      paramrf = ((yj)localObject1).a(paramrf).a(localJsonTypeInfo.property());
      paramxg = localJsonTypeInfo.defaultImpl();
      if (paramxg == JsonTypeInfo.None.class) {
        return paramrf;
      }
      return paramrf.a(paramxg);
      if (localJsonTypeInfo == null) {
        return null;
      }
      if (localJsonTypeInfo.use() == JsonTypeInfo.Id.NONE) {
        return c();
      }
      localObject1 = b();
      break;
    }
    return paramrf;
  }
  
  public yj<?> a(rf<?> paramrf, xh paramxh, afm paramafm)
  {
    return a(paramrf, paramxh, paramafm);
  }
  
  public yj<?> a(rf<?> paramrf, xk paramxk, afm paramafm)
  {
    if (paramafm.f()) {
      return null;
    }
    return a(paramrf, paramxk, paramafm);
  }
  
  public Boolean a(xh paramxh)
  {
    paramxh = (sa)paramxh.a(sa.class);
    if (paramxh == null) {
      return null;
    }
    if (paramxh.a()) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public Class<?> a(xg paramxg, afm paramafm)
  {
    paramxg = (se)paramxg.a(se.class);
    if (paramxg != null)
    {
      paramxg = paramxg.e();
      if (paramxg != sl.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Class<?> a(xg paramxg, afm paramafm, String paramString)
  {
    paramxg = (sb)paramxg.a(sb.class);
    if (paramxg != null)
    {
      paramxg = paramxg.d();
      if (paramxg != sl.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public String a(xn paramxn)
  {
    if (paramxn != null)
    {
      paramxn = (JsonProperty)paramxn.a(JsonProperty.class);
      if (paramxn != null) {
        return paramxn.value();
      }
    }
    return null;
  }
  
  public String a(Enum<?> paramEnum)
  {
    return paramEnum.name();
  }
  
  public List<yg> a(xg paramxg)
  {
    paramxg = (JsonSubTypes)paramxg.a(JsonSubTypes.class);
    if (paramxg == null)
    {
      paramxg = null;
      return paramxg;
    }
    JsonSubTypes.Type[] arrayOfType = paramxg.value();
    ArrayList localArrayList = new ArrayList(arrayOfType.length);
    int j = arrayOfType.length;
    int i = 0;
    for (;;)
    {
      paramxg = localArrayList;
      if (i >= j) {
        break;
      }
      paramxg = arrayOfType[i];
      localArrayList.add(new yg(paramxg.value(), paramxg.name()));
      i += 1;
    }
  }
  
  public boolean a(xi paramxi)
  {
    return m(paramxi);
  }
  
  public boolean a(xj paramxj)
  {
    return m(paramxj);
  }
  
  public boolean a(xl paramxl)
  {
    return m(paramxl);
  }
  
  public boolean a(Annotation paramAnnotation)
  {
    return paramAnnotation.annotationType().getAnnotation(JacksonAnnotation.class) != null;
  }
  
  public yj<?> b(rf<?> paramrf, xk paramxk, afm paramafm)
  {
    if (!paramafm.f()) {
      throw new IllegalArgumentException("Must call method with a container type (got " + paramafm + ")");
    }
    return a(paramrf, paramxk, paramafm);
  }
  
  protected yw b()
  {
    return new yw();
  }
  
  public Boolean b(xk paramxk)
  {
    paramxk = (JsonUnwrapped)paramxk.a(JsonUnwrapped.class);
    if ((paramxk != null) && (paramxk.enabled())) {
      return Boolean.TRUE;
    }
    return null;
  }
  
  public Class<?> b(xg paramxg, afm paramafm)
  {
    paramxg = (se)paramxg.a(se.class);
    if (paramxg != null)
    {
      paramxg = paramxg.f();
      if (paramxg != sl.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Class<?> b(xg paramxg, afm paramafm, String paramString)
  {
    paramxg = (sb)paramxg.a(sb.class);
    if (paramxg != null)
    {
      paramxg = paramxg.e();
      if (paramxg != sl.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Object b(xg paramxg)
  {
    Object localObject = (se)paramxg.a(se.class);
    if (localObject != null)
    {
      localObject = ((se)localObject).a();
      if (localObject != rb.class) {
        return localObject;
      }
    }
    localObject = (JsonRawValue)paramxg.a(JsonRawValue.class);
    if ((localObject != null) && (((JsonRawValue)localObject).value())) {
      return new abp(paramxg.d());
    }
    return null;
  }
  
  public String b(xh paramxh)
  {
    paramxh = (sd)paramxh.a(sd.class);
    if (paramxh == null) {
      return null;
    }
    return paramxh.a();
  }
  
  public String b(xj paramxj)
  {
    JsonProperty localJsonProperty = (JsonProperty)paramxj.a(JsonProperty.class);
    if (localJsonProperty != null) {
      return localJsonProperty.value();
    }
    if ((paramxj.b(se.class)) || (paramxj.b(sk.class))) {
      return "";
    }
    return null;
  }
  
  public String b(xl paramxl)
  {
    Object localObject = (JsonProperty)paramxl.a(JsonProperty.class);
    if (localObject != null) {
      return ((JsonProperty)localObject).value();
    }
    localObject = (JsonGetter)paramxl.a(JsonGetter.class);
    if (localObject != null) {
      return ((JsonGetter)localObject).value();
    }
    if ((paramxl.b(se.class)) || (paramxl.b(sk.class))) {
      return "";
    }
    return null;
  }
  
  protected yw c()
  {
    return yw.b();
  }
  
  public Class<? extends ra<?>> c(xg paramxg)
  {
    paramxg = (se)paramxg.a(se.class);
    if (paramxg != null)
    {
      paramxg = paramxg.c();
      if (paramxg != rb.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Class<?> c(xg paramxg, afm paramafm, String paramString)
  {
    paramxg = (sb)paramxg.a(sb.class);
    if (paramxg != null)
    {
      paramxg = paramxg.f();
      if (paramxg != sl.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public String c(xj paramxj)
  {
    JsonProperty localJsonProperty = (JsonProperty)paramxj.a(JsonProperty.class);
    if (localJsonProperty != null) {
      return localJsonProperty.value();
    }
    if ((paramxj.b(sb.class)) || (paramxj.b(sk.class)) || (paramxj.b(JsonBackReference.class)) || (paramxj.b(JsonManagedReference.class))) {
      return "";
    }
    return null;
  }
  
  public boolean c(xk paramxk)
  {
    return m(paramxk);
  }
  
  public boolean c(xl paramxl)
  {
    paramxl = (JsonValue)paramxl.a(JsonValue.class);
    return (paramxl != null) && (paramxl.value());
  }
  
  public String[] c(xh paramxh)
  {
    paramxh = (JsonIgnoreProperties)paramxh.a(JsonIgnoreProperties.class);
    if (paramxh == null) {
      return null;
    }
    return paramxh.value();
  }
  
  public Boolean d(xh paramxh)
  {
    paramxh = (JsonIgnoreProperties)paramxh.a(JsonIgnoreProperties.class);
    if (paramxh == null) {
      return null;
    }
    return Boolean.valueOf(paramxh.ignoreUnknown());
  }
  
  public Class<? extends ra<?>> d(xg paramxg)
  {
    paramxg = (se)paramxg.a(se.class);
    if (paramxg != null)
    {
      paramxg = paramxg.b();
      if (paramxg != rb.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Object d(xk paramxk)
  {
    Object localObject = (ry)paramxk.a(ry.class);
    if (localObject == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ((ry)localObject).a();
      localObject = str;
    } while (str.length() != 0);
    if (!(paramxk instanceof xl)) {
      return paramxk.d().getName();
    }
    localObject = (xl)paramxk;
    if (((xl)localObject).f() == 0) {
      return paramxk.d().getName();
    }
    return ((xl)localObject).a(0).getName();
  }
  
  public String d(xl paramxl)
  {
    Object localObject = (JsonProperty)paramxl.a(JsonProperty.class);
    if (localObject != null) {
      return ((JsonProperty)localObject).value();
    }
    localObject = (JsonSetter)paramxl.a(JsonSetter.class);
    if (localObject != null) {
      return ((JsonSetter)localObject).value();
    }
    if ((paramxl.b(sb.class)) || (paramxl.b(sk.class)) || (paramxl.b(JsonBackReference.class)) || (paramxl.b(JsonManagedReference.class))) {
      return "";
    }
    return null;
  }
  
  public Boolean e(xh paramxh)
  {
    paramxh = (JsonIgnoreType)paramxh.a(JsonIgnoreType.class);
    if (paramxh == null) {
      return null;
    }
    return Boolean.valueOf(paramxh.value());
  }
  
  public Class<?> e(xg paramxg)
  {
    paramxg = (se)paramxg.a(se.class);
    if (paramxg != null)
    {
      paramxg = paramxg.d();
      if (paramxg != sl.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public boolean e(xl paramxl)
  {
    return paramxl.b(JsonAnySetter.class);
  }
  
  public sg f(xg paramxg)
  {
    paramxg = (se)paramxg.a(se.class);
    if (paramxg == null) {
      return null;
    }
    return paramxg.g();
  }
  
  public Object f(xh paramxh)
  {
    paramxh = (sc)paramxh.a(sc.class);
    if (paramxh != null)
    {
      paramxh = paramxh.a();
      if (paramxh.length() > 0) {
        return paramxh;
      }
    }
    return null;
  }
  
  public boolean f(xl paramxl)
  {
    return paramxl.b(JsonAnyGetter.class);
  }
  
  public String g(xh paramxh)
  {
    paramxh = (JsonTypeName)paramxh.a(JsonTypeName.class);
    if (paramxh == null) {
      return null;
    }
    return paramxh.value();
  }
  
  public Class<?>[] g(xg paramxg)
  {
    paramxg = (sk)paramxg.a(sk.class);
    if (paramxg == null) {
      return null;
    }
    return paramxg.a();
  }
  
  public String[] h(xh paramxh)
  {
    paramxh = (JsonPropertyOrder)paramxh.a(JsonPropertyOrder.class);
    if (paramxh == null) {
      return null;
    }
    return paramxh.value();
  }
  
  public Boolean i(xh paramxh)
  {
    paramxh = (JsonPropertyOrder)paramxh.a(JsonPropertyOrder.class);
    if (paramxh == null) {
      return null;
    }
    return Boolean.valueOf(paramxh.alphabetic());
  }
  
  public Class<? extends rc> i(xg paramxg)
  {
    paramxg = (sb)paramxg.a(sb.class);
    if (paramxg != null)
    {
      paramxg = paramxg.c();
      if (paramxg != rd.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Class<? extends qu<?>> j(xg paramxg)
  {
    paramxg = (sb)paramxg.a(sb.class);
    if (paramxg != null)
    {
      paramxg = paramxg.b();
      if (paramxg != qv.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  public Object j(xh paramxh)
  {
    paramxh = (sj)paramxh.a(sj.class);
    if (paramxh == null) {
      return null;
    }
    return paramxh.a();
  }
  
  public boolean k(xg paramxg)
  {
    return paramxg.b(JsonCreator.class);
  }
  
  public Class<? extends qu<?>> l(xg paramxg)
  {
    paramxg = (sb)paramxg.a(sb.class);
    if (paramxg != null)
    {
      paramxg = paramxg.a();
      if (paramxg != qv.class) {
        return paramxg;
      }
    }
    return null;
  }
  
  protected boolean m(xg paramxg)
  {
    paramxg = (JsonIgnore)paramxg.a(JsonIgnore.class);
    return (paramxg != null) && (paramxg.value());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */