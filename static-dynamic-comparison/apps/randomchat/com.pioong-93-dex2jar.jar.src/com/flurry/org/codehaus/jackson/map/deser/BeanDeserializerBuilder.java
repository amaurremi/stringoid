package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.BeanPropertyDefinition;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import com.flurry.org.codehaus.jackson.map.deser.impl.ValueInjector;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.util.Annotations;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class BeanDeserializerBuilder
{
  protected SettableAnyProperty _anySetter;
  protected HashMap<String, SettableBeanProperty> _backRefProperties;
  protected final BasicBeanDescription _beanDesc;
  protected HashSet<String> _ignorableProps;
  protected boolean _ignoreAllUnknown;
  protected List<ValueInjector> _injectables;
  protected final HashMap<String, SettableBeanProperty> _properties = new LinkedHashMap();
  protected ValueInstantiator _valueInstantiator;
  
  protected BeanDeserializerBuilder(BeanDeserializerBuilder paramBeanDeserializerBuilder)
  {
    this._beanDesc = paramBeanDeserializerBuilder._beanDesc;
    this._anySetter = paramBeanDeserializerBuilder._anySetter;
    this._ignoreAllUnknown = paramBeanDeserializerBuilder._ignoreAllUnknown;
    this._properties.putAll(paramBeanDeserializerBuilder._properties);
    this._backRefProperties = _copy(paramBeanDeserializerBuilder._backRefProperties);
    this._ignorableProps = paramBeanDeserializerBuilder._ignorableProps;
    this._valueInstantiator = paramBeanDeserializerBuilder._valueInstantiator;
  }
  
  public BeanDeserializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    this._beanDesc = paramBasicBeanDescription;
  }
  
  private static HashMap<String, SettableBeanProperty> _copy(HashMap<String, SettableBeanProperty> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    return new HashMap(paramHashMap);
  }
  
  public void addBackReferenceProperty(String paramString, SettableBeanProperty paramSettableBeanProperty)
  {
    if (this._backRefProperties == null) {
      this._backRefProperties = new HashMap(4);
    }
    this._backRefProperties.put(paramString, paramSettableBeanProperty);
    if (this._properties != null) {
      this._properties.remove(paramSettableBeanProperty.getName());
    }
  }
  
  public void addCreatorProperty(BeanPropertyDefinition paramBeanPropertyDefinition) {}
  
  public void addIgnorable(String paramString)
  {
    if (this._ignorableProps == null) {
      this._ignorableProps = new HashSet();
    }
    this._ignorableProps.add(paramString);
  }
  
  public void addInjectable(String paramString, JavaType paramJavaType, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember, Object paramObject)
  {
    if (this._injectables == null) {
      this._injectables = new ArrayList();
    }
    this._injectables.add(new ValueInjector(paramString, paramJavaType, paramAnnotations, paramAnnotatedMember, paramObject));
  }
  
  public void addOrReplaceProperty(SettableBeanProperty paramSettableBeanProperty, boolean paramBoolean)
  {
    this._properties.put(paramSettableBeanProperty.getName(), paramSettableBeanProperty);
  }
  
  public void addProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)this._properties.put(paramSettableBeanProperty.getName(), paramSettableBeanProperty);
    if ((localSettableBeanProperty != null) && (localSettableBeanProperty != paramSettableBeanProperty)) {
      throw new IllegalArgumentException("Duplicate property '" + paramSettableBeanProperty.getName() + "' for " + this._beanDesc.getType());
    }
  }
  
  public JsonDeserializer<?> build(BeanProperty paramBeanProperty)
  {
    BeanPropertyMap localBeanPropertyMap = new BeanPropertyMap(this._properties.values());
    localBeanPropertyMap.assignIndexes();
    return new BeanDeserializer(this._beanDesc, paramBeanProperty, this._valueInstantiator, localBeanPropertyMap, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, this._anySetter, this._injectables);
  }
  
  public Iterator<SettableBeanProperty> getProperties()
  {
    return this._properties.values().iterator();
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return this._valueInstantiator;
  }
  
  public boolean hasProperty(String paramString)
  {
    return this._properties.containsKey(paramString);
  }
  
  public SettableBeanProperty removeProperty(String paramString)
  {
    return (SettableBeanProperty)this._properties.remove(paramString);
  }
  
  public void setAnySetter(SettableAnyProperty paramSettableAnyProperty)
  {
    if ((this._anySetter != null) && (paramSettableAnyProperty != null)) {
      throw new IllegalStateException("_anySetter already set to non-null");
    }
    this._anySetter = paramSettableAnyProperty;
  }
  
  public void setIgnoreUnknownProperties(boolean paramBoolean)
  {
    this._ignoreAllUnknown = paramBoolean;
  }
  
  public void setValueInstantiator(ValueInstantiator paramValueInstantiator)
  {
    this._valueInstantiator = paramValueInstantiator;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/BeanDeserializerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */