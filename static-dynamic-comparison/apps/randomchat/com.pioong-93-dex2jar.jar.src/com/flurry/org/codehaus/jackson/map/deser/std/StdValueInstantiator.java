package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.deser.impl.CreatorProperty;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedWithParams;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

public class StdValueInstantiator
  extends ValueInstantiator
{
  protected final boolean _cfgEmptyStringsAsObjects;
  protected CreatorProperty[] _constructorArguments;
  protected AnnotatedWithParams _defaultCreator;
  protected AnnotatedWithParams _delegateCreator;
  protected JavaType _delegateType;
  protected AnnotatedWithParams _fromBooleanCreator;
  protected AnnotatedWithParams _fromDoubleCreator;
  protected AnnotatedWithParams _fromIntCreator;
  protected AnnotatedWithParams _fromLongCreator;
  protected AnnotatedWithParams _fromStringCreator;
  protected final String _valueTypeDesc;
  protected AnnotatedWithParams _withArgsCreator;
  
  public StdValueInstantiator(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    boolean bool;
    if (paramDeserializationConfig == null)
    {
      bool = false;
      this._cfgEmptyStringsAsObjects = bool;
      if (paramJavaType != null) {
        break label39;
      }
    }
    label39:
    for (paramDeserializationConfig = "UNKNOWN TYPE";; paramDeserializationConfig = paramJavaType.toString())
    {
      this._valueTypeDesc = paramDeserializationConfig;
      return;
      bool = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
      break;
    }
  }
  
  public StdValueInstantiator(DeserializationConfig paramDeserializationConfig, Class<?> paramClass)
  {
    boolean bool;
    if (paramDeserializationConfig == null)
    {
      bool = false;
      this._cfgEmptyStringsAsObjects = bool;
      if (paramClass != null) {
        break label39;
      }
    }
    label39:
    for (paramDeserializationConfig = "UNKNOWN TYPE";; paramDeserializationConfig = paramClass.getName())
    {
      this._valueTypeDesc = paramDeserializationConfig;
      return;
      bool = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
      break;
    }
  }
  
  protected StdValueInstantiator(StdValueInstantiator paramStdValueInstantiator)
  {
    this._cfgEmptyStringsAsObjects = paramStdValueInstantiator._cfgEmptyStringsAsObjects;
    this._valueTypeDesc = paramStdValueInstantiator._valueTypeDesc;
    this._defaultCreator = paramStdValueInstantiator._defaultCreator;
    this._constructorArguments = paramStdValueInstantiator._constructorArguments;
    this._withArgsCreator = paramStdValueInstantiator._withArgsCreator;
    this._delegateType = paramStdValueInstantiator._delegateType;
    this._delegateCreator = paramStdValueInstantiator._delegateCreator;
    this._fromStringCreator = paramStdValueInstantiator._fromStringCreator;
    this._fromIntCreator = paramStdValueInstantiator._fromIntCreator;
    this._fromLongCreator = paramStdValueInstantiator._fromLongCreator;
    this._fromDoubleCreator = paramStdValueInstantiator._fromDoubleCreator;
    this._fromBooleanCreator = paramStdValueInstantiator._fromBooleanCreator;
  }
  
  protected Object _createFromStringFallbacks(String paramString)
    throws IOException, JsonProcessingException
  {
    if (this._fromBooleanCreator != null)
    {
      String str = paramString.trim();
      if ("true".equals(str)) {
        return createFromBoolean(true);
      }
      if ("false".equals(str)) {
        return createFromBoolean(false);
      }
    }
    if ((this._cfgEmptyStringsAsObjects) && (paramString.length() == 0)) {
      return null;
    }
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON String; no single-String constructor/factory method");
  }
  
  public boolean canCreateFromBoolean()
  {
    return this._fromBooleanCreator != null;
  }
  
  public boolean canCreateFromDouble()
  {
    return this._fromDoubleCreator != null;
  }
  
  public boolean canCreateFromInt()
  {
    return this._fromIntCreator != null;
  }
  
  public boolean canCreateFromLong()
  {
    return this._fromLongCreator != null;
  }
  
  public boolean canCreateFromObjectWith()
  {
    return this._withArgsCreator != null;
  }
  
  public boolean canCreateFromString()
  {
    return this._fromStringCreator != null;
  }
  
  public boolean canCreateUsingDefault()
  {
    return this._defaultCreator != null;
  }
  
  public void configureFromBooleanCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._fromBooleanCreator = paramAnnotatedWithParams;
  }
  
  public void configureFromDoubleCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._fromDoubleCreator = paramAnnotatedWithParams;
  }
  
  public void configureFromIntCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._fromIntCreator = paramAnnotatedWithParams;
  }
  
  public void configureFromLongCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._fromLongCreator = paramAnnotatedWithParams;
  }
  
  public void configureFromObjectSettings(AnnotatedWithParams paramAnnotatedWithParams1, AnnotatedWithParams paramAnnotatedWithParams2, JavaType paramJavaType, AnnotatedWithParams paramAnnotatedWithParams3, CreatorProperty[] paramArrayOfCreatorProperty)
  {
    this._defaultCreator = paramAnnotatedWithParams1;
    this._delegateCreator = paramAnnotatedWithParams2;
    this._delegateType = paramJavaType;
    this._withArgsCreator = paramAnnotatedWithParams3;
    this._constructorArguments = paramArrayOfCreatorProperty;
  }
  
  public void configureFromStringCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._fromStringCreator = paramAnnotatedWithParams;
  }
  
  public Object createFromBoolean(boolean paramBoolean)
    throws IOException, JsonProcessingException
  {
    try
    {
      if (this._fromBooleanCreator != null)
      {
        Object localObject = this._fromBooleanCreator.call1(Boolean.valueOf(paramBoolean));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw wrapException(localException);
    }
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method");
  }
  
  public Object createFromDouble(double paramDouble)
    throws IOException, JsonProcessingException
  {
    try
    {
      if (this._fromDoubleCreator != null)
      {
        Object localObject = this._fromDoubleCreator.call1(Double.valueOf(paramDouble));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw wrapException(localException);
    }
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON floating-point number; no one-double/Double-arg constructor/factory method");
  }
  
  public Object createFromInt(int paramInt)
    throws IOException, JsonProcessingException
  {
    try
    {
      if (this._fromIntCreator != null) {
        return this._fromIntCreator.call1(Integer.valueOf(paramInt));
      }
      if (this._fromLongCreator != null)
      {
        Object localObject = this._fromLongCreator.call1(Long.valueOf(paramInt));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw wrapException(localException);
    }
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON integral number; no single-int-arg constructor/factory method");
  }
  
  public Object createFromLong(long paramLong)
    throws IOException, JsonProcessingException
  {
    try
    {
      if (this._fromLongCreator != null)
      {
        Object localObject = this._fromLongCreator.call1(Long.valueOf(paramLong));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw wrapException(localException);
    }
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON long integral number; no single-long-arg constructor/factory method");
  }
  
  public Object createFromObjectWith(Object[] paramArrayOfObject)
    throws IOException, JsonProcessingException
  {
    if (this._withArgsCreator == null) {
      throw new IllegalStateException("No with-args constructor for " + getValueTypeDesc());
    }
    try
    {
      paramArrayOfObject = this._withArgsCreator.call(paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ExceptionInInitializerError paramArrayOfObject)
    {
      throw wrapException(paramArrayOfObject);
    }
    catch (Exception paramArrayOfObject)
    {
      throw wrapException(paramArrayOfObject);
    }
  }
  
  public Object createFromString(String paramString)
    throws IOException, JsonProcessingException
  {
    if (this._fromStringCreator != null) {
      try
      {
        paramString = this._fromStringCreator.call1(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        throw wrapException(paramString);
      }
    }
    return _createFromStringFallbacks(paramString);
  }
  
  public Object createUsingDefault()
    throws IOException, JsonProcessingException
  {
    if (this._defaultCreator == null) {
      throw new IllegalStateException("No default constructor for " + getValueTypeDesc());
    }
    try
    {
      Object localObject = this._defaultCreator.call();
      return localObject;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      throw wrapException(localExceptionInInitializerError);
    }
    catch (Exception localException)
    {
      throw wrapException(localException);
    }
  }
  
  public Object createUsingDelegate(Object paramObject)
    throws IOException, JsonProcessingException
  {
    if (this._delegateCreator == null) {
      throw new IllegalStateException("No delegate constructor for " + getValueTypeDesc());
    }
    try
    {
      paramObject = this._delegateCreator.call1(paramObject);
      return paramObject;
    }
    catch (ExceptionInInitializerError paramObject)
    {
      throw wrapException((Throwable)paramObject);
    }
    catch (Exception paramObject)
    {
      throw wrapException((Throwable)paramObject);
    }
  }
  
  public AnnotatedWithParams getDefaultCreator()
  {
    return this._defaultCreator;
  }
  
  public AnnotatedWithParams getDelegateCreator()
  {
    return this._delegateCreator;
  }
  
  public JavaType getDelegateType()
  {
    return this._delegateType;
  }
  
  public SettableBeanProperty[] getFromObjectArguments()
  {
    return this._constructorArguments;
  }
  
  public String getValueTypeDesc()
  {
    return this._valueTypeDesc;
  }
  
  public AnnotatedWithParams getWithArgsCreator()
  {
    return this._withArgsCreator;
  }
  
  protected JsonMappingException wrapException(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return new JsonMappingException("Instantiation of " + getValueTypeDesc() + " value failed: " + paramThrowable.getMessage(), paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/StdValueInstantiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */