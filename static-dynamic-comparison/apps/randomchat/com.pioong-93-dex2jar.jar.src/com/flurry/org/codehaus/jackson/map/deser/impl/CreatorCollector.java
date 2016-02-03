package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.deser.std.StdValueInstantiator;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedWithParams;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.type.TypeBindings;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import java.lang.reflect.Member;
import java.util.HashMap;

public class CreatorCollector
{
  final BasicBeanDescription _beanDesc;
  protected AnnotatedWithParams _booleanCreator;
  final boolean _canFixAccess;
  protected AnnotatedConstructor _defaultConstructor;
  protected AnnotatedWithParams _delegateCreator;
  protected AnnotatedWithParams _doubleCreator;
  protected AnnotatedWithParams _intCreator;
  protected AnnotatedWithParams _longCreator;
  protected CreatorProperty[] _propertyBasedArgs = null;
  protected AnnotatedWithParams _propertyBasedCreator;
  protected AnnotatedWithParams _stringCreator;
  
  public CreatorCollector(BasicBeanDescription paramBasicBeanDescription, boolean paramBoolean)
  {
    this._beanDesc = paramBasicBeanDescription;
    this._canFixAccess = paramBoolean;
  }
  
  public void addBooleanCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._booleanCreator = verifyNonDup(paramAnnotatedWithParams, this._booleanCreator, "boolean");
  }
  
  public void addDelegatingCreator(AnnotatedWithParams paramAnnotatedWithParams)
  {
    this._delegateCreator = verifyNonDup(paramAnnotatedWithParams, this._delegateCreator, "delegate");
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
      int i = 0;
      int j = paramArrayOfCreatorProperty.length;
      while (i < j)
      {
        String str = paramArrayOfCreatorProperty[i].getName();
        Integer localInteger = (Integer)paramAnnotatedWithParams.put(str, Integer.valueOf(i));
        if (localInteger != null) {
          throw new IllegalArgumentException("Duplicate creator property \"" + str + "\" (index " + localInteger + " vs " + i + ")");
        }
        i += 1;
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
    if (this._delegateCreator == null) {}
    for (paramDeserializationConfig = null;; paramDeserializationConfig = this._beanDesc.bindingsForBeanType().resolveType(this._delegateCreator.getParameterType(0)))
    {
      localStdValueInstantiator.configureFromObjectSettings(this._defaultConstructor, this._delegateCreator, paramDeserializationConfig, this._propertyBasedCreator, this._propertyBasedArgs);
      localStdValueInstantiator.configureFromStringCreator(this._stringCreator);
      localStdValueInstantiator.configureFromIntCreator(this._intCreator);
      localStdValueInstantiator.configureFromLongCreator(this._longCreator);
      localStdValueInstantiator.configureFromDoubleCreator(this._doubleCreator);
      localStdValueInstantiator.configureFromBooleanCreator(this._booleanCreator);
      return localStdValueInstantiator;
    }
  }
  
  public void setDefaultConstructor(AnnotatedConstructor paramAnnotatedConstructor)
  {
    this._defaultConstructor = paramAnnotatedConstructor;
  }
  
  protected AnnotatedWithParams verifyNonDup(AnnotatedWithParams paramAnnotatedWithParams1, AnnotatedWithParams paramAnnotatedWithParams2, String paramString)
  {
    if ((paramAnnotatedWithParams2 != null) && (paramAnnotatedWithParams2.getClass() == paramAnnotatedWithParams1.getClass())) {
      throw new IllegalArgumentException("Conflicting " + paramString + " creators: already had " + paramAnnotatedWithParams2 + ", encountered " + paramAnnotatedWithParams1);
    }
    if (this._canFixAccess) {
      ClassUtil.checkAndFixAccess((Member)paramAnnotatedWithParams1.getAnnotated());
    }
    return paramAnnotatedWithParams1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/impl/CreatorCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */