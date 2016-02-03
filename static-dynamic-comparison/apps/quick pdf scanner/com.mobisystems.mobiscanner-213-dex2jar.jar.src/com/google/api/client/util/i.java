package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class i
{
  public static final Boolean adj = new Boolean(true);
  public static final String adk = new String();
  public static final Character adl = new Character('\000');
  public static final Byte adm = new Byte((byte)0);
  public static final Short adn = new Short((short)0);
  public static final Integer ado = new Integer(0);
  public static final Float adp = new Float(0.0F);
  public static final Long adq = new Long(0L);
  public static final Double adr = new Double(0.0D);
  public static final BigInteger ads = new BigInteger("0");
  public static final BigDecimal adt = new BigDecimal("0");
  public static final DateTime adu = new DateTime(0L);
  private static final ConcurrentHashMap<Class<?>, Object> adv = new ConcurrentHashMap();
  
  static
  {
    adv.put(Boolean.class, adj);
    adv.put(String.class, adk);
    adv.put(Character.class, adl);
    adv.put(Byte.class, adm);
    adv.put(Short.class, adn);
    adv.put(Integer.class, ado);
    adv.put(Float.class, adp);
    adv.put(Long.class, adq);
    adv.put(Double.class, adr);
    adv.put(BigInteger.class, ads);
    adv.put(BigDecimal.class, adt);
    adv.put(DateTime.class, adu);
  }
  
  public static Object a(Type paramType, String paramString)
  {
    Class localClass;
    Object localObject;
    if ((paramType instanceof Class))
    {
      localClass = (Class)paramType;
      if ((paramType != null) && (localClass == null)) {
        break label301;
      }
      if (localClass != Void.class) {
        break label35;
      }
      localObject = null;
    }
    label35:
    do
    {
      do
      {
        do
        {
          return localObject;
          localClass = null;
          break;
          localObject = paramString;
        } while (paramString == null);
        localObject = paramString;
      } while (localClass == null);
      localObject = paramString;
    } while (localClass.isAssignableFrom(String.class));
    if ((localClass == Character.class) || (localClass == Character.TYPE))
    {
      if (paramString.length() != 1) {
        throw new IllegalArgumentException("expected type Character/char but got " + localClass);
      }
      return Character.valueOf(paramString.charAt(0));
    }
    if ((localClass == Boolean.class) || (localClass == Boolean.TYPE)) {
      return Boolean.valueOf(paramString);
    }
    if ((localClass == Byte.class) || (localClass == Byte.TYPE)) {
      return Byte.valueOf(paramString);
    }
    if ((localClass == Short.class) || (localClass == Short.TYPE)) {
      return Short.valueOf(paramString);
    }
    if ((localClass == Integer.class) || (localClass == Integer.TYPE)) {
      return Integer.valueOf(paramString);
    }
    if ((localClass == Long.class) || (localClass == Long.TYPE)) {
      return Long.valueOf(paramString);
    }
    if ((localClass == Float.class) || (localClass == Float.TYPE)) {
      return Float.valueOf(paramString);
    }
    if ((localClass == Double.class) || (localClass == Double.TYPE)) {
      return Double.valueOf(paramString);
    }
    if (localClass == DateTime.class) {
      return DateTime.ct(paramString);
    }
    if (localClass == BigInteger.class) {
      return new BigInteger(paramString);
    }
    if (localClass == BigDecimal.class) {
      return new BigDecimal(paramString);
    }
    if (localClass.isEnum()) {
      return h.i(localClass).cs(paramString).yR();
    }
    label301:
    throw new IllegalArgumentException("expected primitive class, but got: " + paramType);
  }
  
  public static Type a(List<Type> paramList, Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ae.a((WildcardType)paramType);
    }
    for (;;)
    {
      if ((paramType instanceof TypeVariable))
      {
        Type localType = ae.a(paramList, (TypeVariable)paramType);
        if (localType == null) {
          break label64;
        }
        paramType = localType;
      }
      label64:
      for (;;)
      {
        if ((paramType instanceof TypeVariable))
        {
          paramType = ((TypeVariable)paramType).getBounds()[0];
          break;
          return paramType;
        }
        break;
      }
    }
  }
  
  public static boolean a(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ae.a((WildcardType)paramType);
    }
    for (;;)
    {
      if (!(paramType instanceof Class)) {
        return false;
      }
      paramType = (Class)paramType;
      if ((paramType.isPrimitive()) || (paramType == Character.class) || (paramType == String.class) || (paramType == Integer.class) || (paramType == Long.class) || (paramType == Short.class) || (paramType == Byte.class) || (paramType == Float.class) || (paramType == Double.class) || (paramType == BigInteger.class) || (paramType == BigDecimal.class) || (paramType == DateTime.class) || (paramType == Boolean.class)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public static boolean ag(Object paramObject)
  {
    return (paramObject != null) && (paramObject == adv.get(paramObject.getClass()));
  }
  
  public static Map<String, Object> ah(Object paramObject)
  {
    if ((paramObject == null) || (ag(paramObject))) {
      return Collections.emptyMap();
    }
    if ((paramObject instanceof Map)) {
      return (Map)paramObject;
    }
    return new j(paramObject, false);
  }
  
  public static boolean ai(Object paramObject)
  {
    return (paramObject == null) || (a(paramObject.getClass()));
  }
  
  public static Collection<Object> b(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ae.a((WildcardType)paramType);
    }
    for (;;)
    {
      if ((paramType instanceof ParameterizedType)) {
        paramType = ((ParameterizedType)paramType).getRawType();
      }
      for (;;)
      {
        if ((paramType instanceof Class)) {}
        for (Class localClass = (Class)paramType; (paramType == null) || ((paramType instanceof GenericArrayType)) || ((localClass != null) && ((localClass.isArray()) || (localClass.isAssignableFrom(ArrayList.class)))); localClass = null) {
          return new ArrayList();
        }
        if (localClass == null) {
          throw new IllegalArgumentException("unable to create new instance of type: " + paramType);
        }
        if (localClass.isAssignableFrom(HashSet.class)) {
          return new HashSet();
        }
        if (localClass.isAssignableFrom(TreeSet.class)) {
          return new TreeSet();
        }
        return (Collection)ae.l(localClass);
      }
    }
  }
  
  public static <T> T clone(T paramT)
  {
    if ((paramT == null) || (a(paramT.getClass()))) {
      return paramT;
    }
    if ((paramT instanceof GenericData)) {
      return ((GenericData)paramT).clone();
    }
    Object localObject = paramT.getClass();
    if (((Class)localObject).isArray()) {
      localObject = Array.newInstance(((Class)localObject).getComponentType(), Array.getLength(paramT));
    }
    for (;;)
    {
      i(paramT, localObject);
      return (T)localObject;
      if ((paramT instanceof a)) {
        localObject = ((a)paramT).yD();
      } else {
        localObject = ae.l((Class)localObject);
      }
    }
  }
  
  public static void i(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = true;
    int i = 0;
    int j = 0;
    Object localObject1 = paramObject1.getClass();
    if (localObject1 == paramObject2.getClass())
    {
      bool1 = true;
      x.av(bool1);
      if (!((Class)localObject1).isArray()) {
        break label112;
      }
      if (Array.getLength(paramObject1) != Array.getLength(paramObject2)) {
        break label106;
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      x.av(bool1);
      paramObject1 = ae.ak(paramObject1).iterator();
      i = j;
      while (((Iterator)paramObject1).hasNext())
      {
        Array.set(paramObject2, i, clone(((Iterator)paramObject1).next()));
        i += 1;
      }
      bool1 = false;
      break;
    }
    label112:
    if (Collection.class.isAssignableFrom((Class)localObject1))
    {
      paramObject1 = (Collection)paramObject1;
      if (ArrayList.class.isAssignableFrom((Class)localObject1)) {
        ((ArrayList)paramObject2).ensureCapacity(((Collection)paramObject1).size());
      }
      paramObject2 = (Collection)paramObject2;
      paramObject1 = ((Collection)paramObject1).iterator();
      while (((Iterator)paramObject1).hasNext()) {
        ((Collection)paramObject2).add(clone(((Iterator)paramObject1).next()));
      }
    }
    bool1 = GenericData.class.isAssignableFrom((Class)localObject1);
    if ((bool1) || (!Map.class.isAssignableFrom((Class)localObject1)))
    {
      if (bool1) {}
      for (localObject1 = ((GenericData)paramObject1).abf;; localObject1 = h.i((Class)localObject1))
      {
        Iterator localIterator = ((h)localObject1).adh.iterator();
        while (localIterator.hasNext())
        {
          l locall = ((h)localObject1).cs((String)localIterator.next());
          if ((!locall.yQ()) && ((!bool1) || (!locall.isPrimitive())))
          {
            Object localObject2 = locall.aj(paramObject1);
            if (localObject2 != null) {
              locall.j(paramObject2, clone(localObject2));
            }
          }
        }
      }
    }
    if (a.class.isAssignableFrom((Class)localObject1))
    {
      paramObject2 = (a)paramObject2;
      paramObject1 = (a)paramObject1;
      j = ((a)paramObject1).size();
      while (i < j)
      {
        ((a)paramObject2).set(i, clone(((a)paramObject1).eM(i)));
        i += 1;
      }
    }
    paramObject2 = (Map)paramObject2;
    paramObject1 = ((Map)paramObject1).entrySet().iterator();
    while (((Iterator)paramObject1).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)paramObject1).next();
      ((Map)paramObject2).put(((Map.Entry)localObject1).getKey(), clone(((Map.Entry)localObject1).getValue()));
    }
  }
  
  public static <T> T j(Class<?> paramClass)
  {
    int i = 0;
    Object localObject1 = adv.get(paramClass);
    if (localObject1 == null) {
      synchronized (adv)
      {
        Object localObject2 = adv.get(paramClass);
        localObject1 = localObject2;
        int j;
        if (localObject2 == null)
        {
          if (!paramClass.isArray()) {
            break label94;
          }
          localObject1 = paramClass;
          do
          {
            localObject2 = ((Class)localObject1).getComponentType();
            j = i + 1;
            localObject1 = localObject2;
            i = j;
          } while (((Class)localObject2).isArray());
        }
        for (localObject1 = Array.newInstance((Class)localObject2, new int[j]);; localObject1 = ((l)localObject1).yR())
        {
          adv.put(paramClass, localObject1);
          return (T)localObject1;
          label94:
          if (!paramClass.isEnum()) {
            break;
          }
          localObject1 = h.i(paramClass).cs(null);
          x.a(localObject1, "enum missing constant with @NullValue annotation: %s", new Object[] { paramClass });
        }
        localObject1 = ae.l(paramClass);
      }
    }
    return (T)localObject1;
  }
  
  public static Map<String, Object> k(Class<?> paramClass)
  {
    if ((paramClass == null) || (paramClass.isAssignableFrom(a.class))) {
      return a.yC();
    }
    if (paramClass.isAssignableFrom(TreeMap.class)) {
      return new TreeMap();
    }
    return (Map)ae.l(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */