package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Member;
import java.util.HashMap;

public class CreatorCollector
{
  protected final BeanDescription _beanDesc;
  protected AnnotatedWithParams _booleanCreator;
  protected final boolean _canFixAccess;
  protected AnnotatedWithParams _defaultConstructor;
  protected CreatorProperty[] _delegateArgs;
  protected AnnotatedWithParams _delegateCreator;
  protected AnnotatedWithParams _doubleCreator;
  protected AnnotatedWithParams _intCreator;
  protected AnnotatedWithParams _longCreator;
  protected CreatorProperty[] _propertyBasedArgs = null;
  protected AnnotatedWithParams _propertyBasedCreator;
  protected AnnotatedWithParams _stringCreator;
  
  public CreatorCollector(BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    this._beanDesc = paramBeanDescription;
    this._canFixAccess = paramBoolean;
  }
  
  private <T extends AnnotatedMember> T _fixAccess(T paramT)
  {
    if ((paramT != null) && (this._canFixAccess)) {
      ClassUtil.checkAndFixAccess((Member)paramT.getAnnotated());
    }
    return paramT;
  }
  
  public void addBooleanCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._booleanCreator = verifyNonDup(paramAnnotatedWithParams, this._booleanCreator, "boolean");
  }
  
  public void addDelegatingCreator(AnnotatedWithParams paramAnnotatedWithParams, CreatorProperty[] paramArrayOfCreatorProperty)
  {
    this._delegateCreator = verifyNonDup(paramAnnotatedWithParams, this._delegateCreator, "delegate");
    this._delegateArgs = paramArrayOfCreatorProperty;
  }
  
  public void addDoubleCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._doubleCreator = verifyNonDup(paramAnnotatedWithParams, this._doubleCreator, "double");
  }
  
  public void addIntCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._intCreator = verifyNonDup(paramAnnotatedWithParams, this._intCreator, "int");
  }
  
  public void addLongCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._longCreator = verifyNonDup(paramAnnotatedWithParams, this._longCreator, "long");
  }
  
  public void addPropertyCreator(AnnotatedWithParams paramAnnotatedWithParams, CreatorProperty[] paramArrayOfCreatorProperty)
  {
    this._propertyBasedCreator = verifyNonDup(paramAnnotatedWithParams, this._propertyBasedCreator, "property-based");
    if (paramArrayOfCreatorProperty.length > 1)
    {
      paramAnnotatedWithParams = new HashMap();
      int j = paramArrayOfCreatorProperty.length;
      int i = 0;
      if (i < j)
      {
        String str = paramArrayOfCreatorProperty[i].getName();
        if ((str.length() == 0) && (paramArrayOfCreatorProperty[i].getInjectableValueId() != null)) {}
        Integer localInteger;
        do
        {
          i += 1;
          break;
          localInteger = (Integer)paramAnnotatedWithParams.put(str, Integer.valueOf(i));
        } while (localInteger == null);
        throw new IllegalArgumentException("Duplicate creator property \"" + str + "\" (index " + localInteger + " vs " + i + ")");
      }
    }
    this._propertyBasedArgs = paramArrayOfCreatorProperty;
  }
  
  public void addStringCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._stringCreator = verifyNonDup(paramAnnotatedWithParams, this._stringCreator, "String");
  }
  
  public ValueInstantiator constructValueInstantiator(DeserializationConfig paramDeserializationConfig)
  {
    StdValueInstantiator localStdValueInstantiator = new StdValueInstantiator(paramDeserializationConfig, this._beanDesc.getType());
    if (this._delegateCreator == null)
    {
      paramDeserializationConfig = null;
      localStdValueInstantiator.configureFromObjectSettings(this._defaultConstructor, this._delegateCreator, paramDeserializationConfig, this._delegateArgs, this._propertyBasedCreator, this._propertyBasedArgs);
      localStdValueInstantiator.configureFromStringCreator(this._stringCreator);
      localStdValueInstantiator.configureFromIntCreator(this._intCreator);
      localStdValueInstantiator.configureFromLongCreator(this._longCreator);
      localStdValueInstantiator.configureFromDoubleCreator(this._doubleCreator);
      localStdValueInstantiator.configureFromBooleanCreator(this._booleanCreator);
      return localStdValueInstantiator;
    }
    int i;
    if (this._delegateArgs != null)
    {
      int j = this._delegateArgs.length;
      i = 0;
      label115:
      if (i < j) {
        if (this._delegateArgs[i] != null) {}
      }
    }
    for (;;)
    {
      paramDeserializationConfig = this._beanDesc.bindingsForBeanType().resolveType(this._delegateCreator.getGenericParameterType(i));
      break;
      i += 1;
      break label115;
      i = 0;
    }
  }
  
  public boolean hasDefaultCreator()
  {
    return this._defaultConstructor != null;
  }
  
  @Deprecated
  public void setDefaultConstructor(AnnotatedConstructor paramAnnotatedConstructor)
  {
    this._defaultConstructor = ((AnnotatedWithParams)_fixAccess(paramAnnotatedConstructor));
  }
  
  public void setDefaultCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    if ((paramAnnotatedWithParams instanceof AnnotatedConstructor))
    {
      setDefaultConstructor((AnnotatedConstructor)paramAnnotatedWithParams);
      return;
    }
    this._defaultConstructor = ((AnnotatedWithParams)_fixAccess(paramAnnotatedWithParams));
  }
  
  protected AnnotatedWithParams verifyNonDup(AnnotatedWithParams paramAnnotatedWithParams1, AnnotatedWithParams paramAnnotatedWithParams2, String paramString)
  {
    if ((paramAnnotatedWithParams2 != null) && (paramAnnotatedWithParams2.getClass() == paramAnnotatedWithParams1.getClass())) {
      throw new IllegalArgumentException("Conflicting " + paramString + " creators: already had " + paramAnnotatedWithParams2 + ", encountered " + paramAnnotatedWithParams1);
    }
    return (AnnotatedWithParams)_fixAccess(paramAnnotatedWithParams1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/CreatorCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */