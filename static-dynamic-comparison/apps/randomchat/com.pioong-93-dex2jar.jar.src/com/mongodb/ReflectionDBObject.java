package com.mongodb;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.bson.BSONObject;

public abstract class ReflectionDBObject
  implements DBObject
{
  private static final Set<String> IGNORE_FIELDS;
  private static final Map<Class, JavaWrapper> _wrappers = Collections.synchronizedMap(new HashMap());
  Object _id;
  JavaWrapper _wrapper;
  
  static
  {
    IGNORE_FIELDS = new HashSet();
    IGNORE_FIELDS.add("Int");
  }
  
  public static JavaWrapper getWrapper(Class paramClass)
  {
    JavaWrapper localJavaWrapper2 = (JavaWrapper)_wrappers.get(paramClass);
    JavaWrapper localJavaWrapper1 = localJavaWrapper2;
    if (localJavaWrapper2 == null)
    {
      localJavaWrapper1 = new JavaWrapper(paramClass);
      _wrappers.put(paramClass, localJavaWrapper1);
    }
    return localJavaWrapper1;
  }
  
  public static JavaWrapper getWrapperIfReflectionObject(Class paramClass)
  {
    if (ReflectionDBObject.class.isAssignableFrom(paramClass)) {
      return getWrapper(paramClass);
    }
    return null;
  }
  
  public boolean containsField(String paramString)
  {
    return getWrapper().containsKey(paramString);
  }
  
  @Deprecated
  public boolean containsKey(String paramString)
  {
    return containsField(paramString);
  }
  
  public Object get(String paramString)
  {
    return getWrapper().get(this, paramString);
  }
  
  JavaWrapper getWrapper()
  {
    if (this._wrapper != null) {
      return this._wrapper;
    }
    this._wrapper = getWrapper(getClass());
    return this._wrapper;
  }
  
  public Object get_id()
  {
    return this._id;
  }
  
  public boolean isPartialObject()
  {
    return false;
  }
  
  public Set<String> keySet()
  {
    return getWrapper().keySet();
  }
  
  public void markAsPartialObject()
  {
    throw new RuntimeException("ReflectionDBObjects can't be partial");
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return getWrapper().set(this, paramString, paramObject);
  }
  
  public void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey().toString(), localEntry.getValue());
    }
  }
  
  public void putAll(BSONObject paramBSONObject)
  {
    Iterator localIterator = paramBSONObject.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      put(str, paramBSONObject.get(str));
    }
  }
  
  public Object removeField(String paramString)
  {
    throw new RuntimeException("can't remove from a ReflectionDBObject");
  }
  
  public void set_id(Object paramObject)
  {
    this._id = paramObject;
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localHashMap.put(localObject, get(localObject + ""));
    }
    return localHashMap;
  }
  
  static class FieldInfo
  {
    final Class _class;
    Method _getter;
    final String _name;
    Method _setter;
    
    FieldInfo(String paramString, Class paramClass)
    {
      this._name = paramString;
      this._class = paramClass;
    }
    
    boolean ok()
    {
      return (this._getter != null) && (this._setter != null);
    }
  }
  
  public static class JavaWrapper
  {
    final Class _class;
    final Map<String, ReflectionDBObject.FieldInfo> _fields;
    final Set<String> _keys;
    final String _name;
    
    JavaWrapper(Class paramClass)
    {
      this._class = paramClass;
      this._name = paramClass.getName();
      this._fields = new TreeMap();
      Method[] arrayOfMethod = paramClass.getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      Object localObject;
      if (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((!localMethod.getName().startsWith("get")) && (!localMethod.getName().startsWith("set"))) {}
        for (;;)
        {
          i += 1;
          break;
          String str = localMethod.getName().substring(3);
          if ((str.length() != 0) && (!ReflectionDBObject.IGNORE_FIELDS.contains(str)))
          {
            if (localMethod.getName().startsWith("get")) {}
            for (paramClass = localMethod.getReturnType();; paramClass = localMethod.getParameterTypes()[0])
            {
              ReflectionDBObject.FieldInfo localFieldInfo = (ReflectionDBObject.FieldInfo)this._fields.get(str);
              localObject = localFieldInfo;
              if (localFieldInfo == null)
              {
                localObject = new ReflectionDBObject.FieldInfo(str, paramClass);
                this._fields.put(str, localObject);
              }
              if (!localMethod.getName().startsWith("get")) {
                break label220;
              }
              ((ReflectionDBObject.FieldInfo)localObject)._getter = localMethod;
              break;
            }
            label220:
            ((ReflectionDBObject.FieldInfo)localObject)._setter = localMethod;
          }
        }
      }
      paramClass = new HashSet(this._fields.keySet()).iterator();
      while (paramClass.hasNext())
      {
        localObject = (String)paramClass.next();
        if (!((ReflectionDBObject.FieldInfo)this._fields.get(localObject)).ok()) {
          this._fields.remove(localObject);
        }
      }
      this._keys = Collections.unmodifiableSet(this._fields.keySet());
    }
    
    @Deprecated
    public boolean containsKey(String paramString)
    {
      return this._keys.contains(paramString);
    }
    
    public Object get(ReflectionDBObject paramReflectionDBObject, String paramString)
    {
      ReflectionDBObject.FieldInfo localFieldInfo = (ReflectionDBObject.FieldInfo)this._fields.get(paramString);
      if (localFieldInfo == null) {
        return null;
      }
      try
      {
        paramReflectionDBObject = localFieldInfo._getter.invoke(paramReflectionDBObject, new Object[0]);
        return paramReflectionDBObject;
      }
      catch (Exception paramReflectionDBObject)
      {
        throw new RuntimeException("could not invoke getter for [" + paramString + "] on [" + this._name + "]", paramReflectionDBObject);
      }
    }
    
    Class getInternalClass(String paramString)
    {
      String str2 = paramString;
      String str1 = null;
      int i = paramString.indexOf(".");
      if (i >= 0)
      {
        str2 = paramString.substring(0, i);
        str1 = paramString.substring(i + 1);
      }
      paramString = (ReflectionDBObject.FieldInfo)this._fields.get(str2);
      if (paramString == null) {}
      do
      {
        return null;
        if (str1 == null) {
          return paramString._class;
        }
        paramString = ReflectionDBObject.getWrapperIfReflectionObject(paramString._class);
      } while (paramString == null);
      return paramString.getInternalClass(str1);
    }
    
    public Set<String> keySet()
    {
      return this._keys;
    }
    
    public Object set(ReflectionDBObject paramReflectionDBObject, String paramString, Object paramObject)
    {
      ReflectionDBObject.FieldInfo localFieldInfo = (ReflectionDBObject.FieldInfo)this._fields.get(paramString);
      if (localFieldInfo == null) {
        throw new IllegalArgumentException("no field [" + paramString + "] on [" + this._name + "]");
      }
      try
      {
        paramReflectionDBObject = localFieldInfo._setter.invoke(paramReflectionDBObject, new Object[] { paramObject });
        return paramReflectionDBObject;
      }
      catch (Exception paramReflectionDBObject)
      {
        throw new RuntimeException("could not invoke setter for [" + paramString + "] on [" + this._name + "]", paramReflectionDBObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/ReflectionDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */