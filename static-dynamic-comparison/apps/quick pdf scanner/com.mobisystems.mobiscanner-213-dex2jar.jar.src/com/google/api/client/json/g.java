package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.ae;
import com.google.api.client.util.l;
import com.google.api.client.util.x;
import com.google.api.client.util.y;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class g
{
  private static WeakHashMap<Class<?>, Field> acr = new WeakHashMap();
  private static final Lock acs = new ReentrantLock();
  
  private final Object a(Field paramField, Type paramType, ArrayList<Type> paramArrayList, Object paramObject, a parama, boolean paramBoolean)
  {
    Type localType = com.google.api.client.util.i.a(paramArrayList, paramType);
    Object localObject2;
    if ((localType instanceof Class))
    {
      paramType = (Class)localType;
      localObject2 = paramType;
      if ((localType instanceof ParameterizedType)) {
        localObject2 = ae.a((ParameterizedType)localType);
      }
      if (localObject2 != Void.class) {
        break label65;
      }
      yp();
      paramObject = null;
    }
    label65:
    boolean bool;
    label274:
    Object localObject1;
    label342:
    label410:
    Field localField;
    label438:
    int i;
    label485:
    label498:
    int j;
    label548:
    label569:
    label578:
    do
    {
      return paramObject;
      paramType = null;
      break;
      paramType = yn();
      try
      {
        switch (1.act[yn().ordinal()])
        {
        case 2: 
          throw new IllegalArgumentException("unexpected JSON node type: " + paramType);
        }
      }
      catch (IllegalArgumentException paramType)
      {
        paramArrayList = new StringBuilder();
        paramObject = yo();
        if (paramObject != null) {
          paramArrayList.append("key ").append((String)paramObject);
        }
        if (paramField != null)
        {
          if (paramObject != null) {
            paramArrayList.append(", ");
          }
          paramArrayList.append("field ").append(paramField);
        }
        throw new IllegalArgumentException(paramArrayList.toString(), paramType);
      }
      bool = ae.c(localType);
      if ((localType == null) || (bool)) {
        break label1249;
      }
      if ((localObject2 == null) || (!ae.a((Class)localObject2, Collection.class))) {
        break label1255;
      }
      break label1249;
      x.b(paramBoolean, "expected collection or array type but got %s", new Object[] { localType });
      localObject1 = null;
      paramType = (Type)localObject1;
      if (parama != null)
      {
        paramType = (Type)localObject1;
        if (paramField != null) {
          paramType = parama.a(paramObject, paramField);
        }
      }
      paramObject = paramType;
      if (paramType == null) {
        paramObject = com.google.api.client.util.i.b(localType);
      }
      if (bool) {}
      for (paramType = ae.d(localType);; paramType = ae.e(localType))
      {
        paramType = com.google.api.client.util.i.a(paramArrayList, paramType);
        a(paramField, (Collection)paramObject, paramType, paramArrayList, parama);
        if (!bool) {
          break label1261;
        }
        return ae.a((Collection)paramObject, ae.b(paramArrayList, paramType));
        if ((localObject2 == null) || (!Iterable.class.isAssignableFrom((Class)localObject2))) {
          break;
        }
      }
      if (ae.c(localType)) {
        break label1264;
      }
      bool = true;
      x.b(bool, "expected object or map type but got %s", new Object[] { localType });
      if (!paramBoolean) {
        break label1270;
      }
      localField = h((Class)localObject2);
      paramType = null;
      localObject1 = paramType;
      if (localObject2 != null)
      {
        localObject1 = paramType;
        if (parama != null) {
          localObject1 = parama.a(paramObject, (Class)localObject2);
        }
      }
      if ((localObject2 == null) || (!ae.a((Class)localObject2, Map.class))) {
        break label1276;
      }
      i = 1;
      if (localField == null) {
        break label1282;
      }
      paramType = new b();
      for (;;)
      {
        j = paramArrayList.size();
        if (localType != null) {
          paramArrayList.add(localType);
        }
        if ((i == 0) || (GenericData.class.isAssignableFrom((Class)localObject2))) {
          break;
        }
        if (!Map.class.isAssignableFrom((Class)localObject2)) {
          break label1303;
        }
        paramObject = ae.f(localType);
        if (paramObject == null) {
          break;
        }
        a(paramField, (Map)paramType, (Type)paramObject, paramArrayList, parama);
        return paramType;
        paramType = com.google.api.client.util.i.k((Class)localObject2);
        continue;
        paramType = ae.l((Class)localObject2);
      }
      a(paramArrayList, paramType, parama);
      if (localType != null) {
        paramArrayList.remove(j);
      }
      paramObject = paramType;
    } while (localField == null);
    paramObject = ((b)paramType).get(localField.getName());
    if (paramObject != null)
    {
      paramBoolean = true;
      label637:
      x.d(paramBoolean, "No value specified for @JsonPolymorphicTypeMap field");
      localObject1 = paramObject.toString();
      paramObject = (h)localField.getAnnotation(h.class);
      parama = null;
      localObject2 = ((h)paramObject).yy();
      j = localObject2.length;
      i = 0;
      label683:
      paramObject = parama;
      if (i < j)
      {
        paramObject = localObject2[i];
        if (!((h.a)paramObject).yz().equals(localObject1)) {
          break label1326;
        }
        paramObject = ((h.a)paramObject).yA();
        break label1309;
        label728:
        x.d(paramBoolean, "No TypeDef annotation found with key: " + (String)localObject1);
        parama = getFactory();
        paramType = parama.co(parama.toString(paramType));
        paramType.yw();
        return paramType.a(paramField, (Type)paramObject, paramArrayList, null, null, false);
        if ((localType == null) || (localObject2 == Boolean.TYPE)) {
          break label1341;
        }
        if ((localObject2 == null) || (!((Class)localObject2).isAssignableFrom(Boolean.class))) {
          break label1349;
        }
        break label1341;
        label819:
        x.b(paramBoolean, "expected type Boolean or boolean but got %s", new Object[] { localType });
        if (paramType == JsonToken.acC)
        {
          paramType = Boolean.TRUE;
          paramField = paramType;
          break label1347;
        }
        paramType = Boolean.FALSE;
        paramField = paramType;
        break label1347;
        if (paramField == null) {
          break label1355;
        }
        if (paramField.getAnnotation(i.class) != null) {
          break label1361;
        }
        break label1355;
        label878:
        x.d(paramBoolean, "number type formatted as a JSON number cannot use @JsonString annotation");
        if ((localObject2 == null) || (((Class)localObject2).isAssignableFrom(BigDecimal.class))) {
          return yv();
        }
        if (localObject2 == BigInteger.class) {
          return yu();
        }
        if ((localObject2 == Double.class) || (localObject2 == Double.TYPE)) {
          return Double.valueOf(yt());
        }
        if ((localObject2 == Long.class) || (localObject2 == Long.TYPE)) {
          return Long.valueOf(ys());
        }
        if ((localObject2 == Float.class) || (localObject2 == Float.TYPE)) {
          return Float.valueOf(getFloatValue());
        }
        if ((localObject2 == Integer.class) || (localObject2 == Integer.TYPE)) {
          return Integer.valueOf(getIntValue());
        }
        if ((localObject2 == Short.class) || (localObject2 == Short.TYPE)) {
          return Short.valueOf(yr());
        }
        if ((localObject2 == Byte.class) || (localObject2 == Byte.TYPE)) {
          return Byte.valueOf(yq());
        }
        throw new IllegalArgumentException("expected numeric type but got " + localType);
        if ((localObject2 == null) || (!Number.class.isAssignableFrom((Class)localObject2))) {
          break label1367;
        }
        if ((paramField == null) || (paramField.getAnnotation(i.class) == null)) {
          break label1373;
        }
        break label1367;
        label1126:
        x.d(paramBoolean, "number field formatted as a JSON string must use the @JsonString annotation");
        return com.google.api.client.util.i.a(localType, getText());
        if (localObject2 == null) {
          break label1379;
        }
        if (((Class)localObject2).isPrimitive()) {
          break label1385;
        }
        break label1379;
      }
    }
    for (;;)
    {
      x.d(paramBoolean, "primitive number field but found a JSON null");
      if ((localObject2 != null) && ((((Class)localObject2).getModifiers() & 0x600) != 0))
      {
        if (ae.a((Class)localObject2, Collection.class)) {
          return com.google.api.client.util.i.j(com.google.api.client.util.i.b(localType).getClass());
        }
        if (ae.a((Class)localObject2, Map.class)) {
          return com.google.api.client.util.i.j(com.google.api.client.util.i.k((Class)localObject2).getClass());
        }
      }
      paramType = com.google.api.client.util.i.j(ae.b(paramArrayList, localType));
      return paramType;
      paramType = null;
      break label342;
      break;
      label1249:
      paramBoolean = true;
      break label274;
      label1255:
      paramBoolean = false;
      break label274;
      label1261:
      return paramObject;
      label1264:
      bool = false;
      break label410;
      label1270:
      localField = null;
      break label438;
      label1276:
      i = 0;
      break label485;
      label1282:
      paramType = (Type)localObject1;
      if (localObject1 != null) {
        break label498;
      }
      if (i != 0) {
        break label569;
      }
      if (localObject2 != null) {
        break label578;
      }
      break label569;
      label1303:
      paramObject = null;
      break label548;
      label1309:
      if (paramObject != null)
      {
        paramBoolean = true;
        break label728;
        paramBoolean = false;
        break label637;
        label1326:
        i += 1;
        break label683;
      }
      paramBoolean = false;
      break label728;
      label1341:
      paramBoolean = true;
      break label819;
      label1347:
      return paramField;
      label1349:
      paramBoolean = false;
      break label819;
      label1355:
      paramBoolean = true;
      break label878;
      label1361:
      paramBoolean = false;
      break label878;
      label1367:
      paramBoolean = true;
      break label1126;
      label1373:
      paramBoolean = false;
      break label1126;
      label1379:
      paramBoolean = true;
      continue;
      label1385:
      paramBoolean = false;
    }
  }
  
  private <T> void a(Field paramField, Collection<T> paramCollection, Type paramType, ArrayList<Type> paramArrayList, a parama)
  {
    for (JsonToken localJsonToken = yx(); localJsonToken != JsonToken.acv; localJsonToken = ym()) {
      paramCollection.add(a(paramField, paramType, paramArrayList, paramCollection, parama, true));
    }
  }
  
  private void a(Field paramField, Map<String, Object> paramMap, Type paramType, ArrayList<Type> paramArrayList, a parama)
  {
    for (Object localObject = yx();; localObject = ym())
    {
      if (localObject == JsonToken.acy)
      {
        localObject = getText();
        ym();
        if ((parama == null) || (!parama.a(paramMap, (String)localObject))) {}
      }
      else
      {
        return;
      }
      paramMap.put(localObject, a(paramField, paramType, paramArrayList, paramMap, parama, true));
    }
  }
  
  private void a(ArrayList<Type> paramArrayList, Object paramObject, a parama)
  {
    if ((paramObject instanceof b)) {
      ((b)paramObject).setFactory(getFactory());
    }
    Object localObject2 = yx();
    Class localClass = paramObject.getClass();
    com.google.api.client.util.h localh = com.google.api.client.util.h.i(localClass);
    boolean bool = GenericData.class.isAssignableFrom(localClass);
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (Map.class.isAssignableFrom(localClass))
      {
        a(null, (Map)paramObject, ae.f(localClass), paramArrayList, parama);
        return;
        label86:
        localObject2 = ((l)localObject1).yP();
        int i = paramArrayList.size();
        paramArrayList.add(((Field)localObject2).getGenericType());
        localObject2 = a((Field)localObject2, ((l)localObject1).getGenericType(), paramArrayList, paramObject, parama, true);
        paramArrayList.remove(i);
        ((l)localObject1).j(paramObject, localObject2);
      }
    }
    for (;;)
    {
      localObject1 = ym();
      if (localObject1 != JsonToken.acy) {
        break;
      }
      localObject2 = getText();
      ym();
      if ((parama != null) && (parama.a(paramObject, (String)localObject2))) {
        break;
      }
      localObject1 = localh.cs((String)localObject2);
      if (localObject1 != null)
      {
        if ((!((l)localObject1).yQ()) || (((l)localObject1).isPrimitive())) {
          break label86;
        }
        throw new IllegalArgumentException("final array/object fields are not supported");
      }
      if (bool)
      {
        ((GenericData)paramObject).set((String)localObject2, a(null, null, paramArrayList, paramObject, parama, true));
      }
      else
      {
        if (parama != null) {
          parama.b(paramObject, (String)localObject2);
        }
        yp();
      }
    }
  }
  
  private static Field h(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    acs.lock();
    label280:
    label285:
    label290:
    for (;;)
    {
      Field localField;
      try
      {
        if (acr.containsKey(paramClass))
        {
          paramClass = (Field)acr.get(paramClass);
          return paramClass;
        }
        Iterator localIterator = com.google.api.client.util.h.i(paramClass).yI().iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localField = ((l)localIterator.next()).yP();
          Object localObject2 = (h)localField.getAnnotation(h.class);
          if (localObject2 == null) {
            break label290;
          }
          if (localObject1 != null) {
            break label280;
          }
          bool = true;
          x.b(bool, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", new Object[] { paramClass });
          x.b(com.google.api.client.util.i.a(localField.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", new Object[] { paramClass, localField.getType() });
          localObject1 = ((h)localObject2).yy();
          localObject2 = y.yU();
          if (localObject1.length <= 0) {
            break label285;
          }
          bool = true;
          x.d(bool, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            Object localObject3 = localObject1[i];
            x.b(((HashSet)localObject2).add(((h.a)localObject3).yz()), "Class contains two @TypeDef annotations with identical key: %s", new Object[] { ((h.a)localObject3).yz() });
            i += 1;
            continue;
          }
        }
        else
        {
          acr.put(paramClass, localObject1);
          return (Field)localObject1;
        }
      }
      finally
      {
        acs.unlock();
      }
      Object localObject1 = localField;
      break label290;
      boolean bool = false;
      continue;
      bool = false;
    }
  }
  
  private JsonToken yw()
  {
    JsonToken localJsonToken = yn();
    if (localJsonToken == null) {
      localJsonToken = ym();
    }
    for (;;)
    {
      if (localJsonToken != null) {}
      for (boolean bool = true;; bool = false)
      {
        x.d(bool, "no JSON input found");
        return localJsonToken;
      }
    }
  }
  
  private JsonToken yx()
  {
    JsonToken localJsonToken = yw();
    switch (1.act[localJsonToken.ordinal()])
    {
    default: 
      return localJsonToken;
    case 1: 
      localJsonToken = ym();
      if ((localJsonToken == JsonToken.acy) || (localJsonToken == JsonToken.acx)) {}
      for (boolean bool = true;; bool = false)
      {
        x.d(bool, localJsonToken);
        return localJsonToken;
      }
    }
    return ym();
  }
  
  public final <T> T a(Class<T> paramClass, a parama)
  {
    try
    {
      paramClass = b(paramClass, parama);
      return paramClass;
    }
    finally
    {
      close();
    }
  }
  
  public Object a(Type paramType, boolean paramBoolean)
  {
    return a(paramType, paramBoolean, null);
  }
  
  public Object a(Type paramType, boolean paramBoolean, a parama)
  {
    try
    {
      if (!Void.class.equals(paramType)) {
        yw();
      }
      paramType = a(null, paramType, new ArrayList(), null, parama, true);
      return paramType;
    }
    finally
    {
      if (paramBoolean) {
        close();
      }
    }
  }
  
  public final <T> T b(Class<T> paramClass, a parama)
  {
    return (T)a(paramClass, false, parama);
  }
  
  public final String c(Set<String> paramSet)
  {
    for (Object localObject = yx(); localObject == JsonToken.acy; localObject = ym())
    {
      localObject = getText();
      ym();
      if (paramSet.contains(localObject)) {
        return (String)localObject;
      }
      yp();
    }
    return null;
  }
  
  public abstract void close();
  
  public final void cq(String paramString)
  {
    c(Collections.singleton(paramString));
  }
  
  public final <T> T g(Class<T> paramClass)
  {
    return (T)a(paramClass, null);
  }
  
  public abstract d getFactory();
  
  public abstract float getFloatValue();
  
  public abstract int getIntValue();
  
  public abstract String getText();
  
  public abstract JsonToken ym();
  
  public abstract JsonToken yn();
  
  public abstract String yo();
  
  public abstract g yp();
  
  public abstract byte yq();
  
  public abstract short yr();
  
  public abstract long ys();
  
  public abstract double yt();
  
  public abstract BigInteger yu();
  
  public abstract BigDecimal yv();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */