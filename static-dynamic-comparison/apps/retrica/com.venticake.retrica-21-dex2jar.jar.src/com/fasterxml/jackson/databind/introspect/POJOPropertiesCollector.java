package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class POJOPropertiesCollector
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected LinkedList<AnnotatedMember> _anyGetters = null;
  protected LinkedList<AnnotatedMethod> _anySetters = null;
  protected final AnnotatedClass _classDef;
  protected final MapperConfig<?> _config;
  protected LinkedList<POJOPropertyBuilder> _creatorProperties = null;
  protected final boolean _forSerialization;
  protected HashSet<String> _ignoredPropertyNames;
  protected LinkedHashMap<Object, AnnotatedMember> _injectables;
  protected LinkedList<AnnotatedMethod> _jsonValueGetters = null;
  protected final String _mutatorPrefix;
  protected final LinkedHashMap<String, POJOPropertyBuilder> _properties = new LinkedHashMap();
  protected final JavaType _type;
  protected final VisibilityChecker<?> _visibilityChecker;
  
  protected POJOPropertiesCollector(MapperConfig<?> paramMapperConfig, boolean paramBoolean, JavaType paramJavaType, AnnotatedClass paramAnnotatedClass, String paramString)
  {
    this._config = paramMapperConfig;
    this._forSerialization = paramBoolean;
    this._type = paramJavaType;
    this._classDef = paramAnnotatedClass;
    paramJavaType = paramString;
    if (paramString == null) {
      paramJavaType = "set";
    }
    this._mutatorPrefix = paramJavaType;
    paramJavaType = (JavaType)localObject;
    if (paramMapperConfig.isAnnotationProcessingEnabled()) {
      paramJavaType = this._config.getAnnotationIntrospector();
    }
    this._annotationIntrospector = paramJavaType;
    if (this._annotationIntrospector == null)
    {
      this._visibilityChecker = this._config.getDefaultVisibilityChecker();
      return;
    }
    this._visibilityChecker = this._annotationIntrospector.findAutoDetectVisibility(paramAnnotatedClass, this._config.getDefaultVisibilityChecker());
  }
  
  private void _addIgnored(String paramString)
  {
    if (!this._forSerialization)
    {
      if (this._ignoredPropertyNames == null) {
        this._ignoredPropertyNames = new HashSet();
      }
      this._ignoredPropertyNames.add(paramString);
    }
  }
  
  private PropertyNamingStrategy _findNamingStrategy()
  {
    if (this._annotationIntrospector == null) {}
    for (Object localObject = null; localObject == null; localObject = this._annotationIntrospector.findNamingStrategy(this._classDef)) {
      return this._config.getPropertyNamingStrategy();
    }
    if ((localObject instanceof PropertyNamingStrategy)) {
      return (PropertyNamingStrategy)localObject;
    }
    if (!(localObject instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + localObject.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
    }
    localObject = (Class)localObject;
    if (!PropertyNamingStrategy.class.isAssignableFrom((Class)localObject)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)localObject).getName() + "; expected Class<PropertyNamingStrategy>");
    }
    HandlerInstantiator localHandlerInstantiator = this._config.getHandlerInstantiator();
    if (localHandlerInstantiator != null) {
      return localHandlerInstantiator.namingStrategyInstance(this._config, this._classDef, (Class)localObject);
    }
    return (PropertyNamingStrategy)ClassUtil.createInstance((Class)localObject, this._config.canOverrideAccessModifiers());
  }
  
  protected void _addCreators()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    if (localAnnotationIntrospector == null) {}
    Iterator localIterator;
    label74:
    AnnotatedParameter localAnnotatedParameter;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    label139:
    do
    {
      return;
      localIterator = this._classDef.getConstructors().iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (AnnotatedConstructor)localIterator.next();
        if (this._creatorProperties == null) {
          this._creatorProperties = new LinkedList();
        }
        j = ((AnnotatedConstructor)localObject2).getParameterCount();
        i = 0;
        if (i < j)
        {
          localAnnotatedParameter = ((AnnotatedConstructor)localObject2).getParameter(i);
          localObject1 = localAnnotationIntrospector.findNameForDeserialization(localAnnotatedParameter);
          if (localObject1 != null) {
            break label139;
          }
        }
        for (localObject1 = null;; localObject1 = ((PropertyName)localObject1).getSimpleName())
        {
          if (localObject1 != null)
          {
            localPOJOPropertyBuilder = _property((String)localObject1);
            localPOJOPropertyBuilder.addCtor(localAnnotatedParameter, (String)localObject1, true, false);
            this._creatorProperties.add(localPOJOPropertyBuilder);
          }
          i += 1;
          break label74;
          break;
        }
      }
      localIterator = this._classDef.getStaticMethods().iterator();
    } while (!localIterator.hasNext());
    Object localObject2 = (AnnotatedMethod)localIterator.next();
    if (this._creatorProperties == null) {
      this._creatorProperties = new LinkedList();
    }
    int j = ((AnnotatedMethod)localObject2).getParameterCount();
    int i = 0;
    label209:
    if (i < j)
    {
      localAnnotatedParameter = ((AnnotatedMethod)localObject2).getParameter(i);
      localObject1 = localAnnotationIntrospector.findNameForDeserialization(localAnnotatedParameter);
      if (localObject1 != null) {
        break label274;
      }
    }
    label274:
    for (Object localObject1 = null;; localObject1 = ((PropertyName)localObject1).getSimpleName())
    {
      if (localObject1 != null)
      {
        localPOJOPropertyBuilder = _property((String)localObject1);
        localPOJOPropertyBuilder.addCtor(localAnnotatedParameter, (String)localObject1, true, false);
        this._creatorProperties.add(localPOJOPropertyBuilder);
      }
      i += 1;
      break label209;
      break;
    }
  }
  
  protected void _addFields()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    Iterator localIterator = this._classDef.fields().iterator();
    AnnotatedField localAnnotatedField;
    String str;
    Object localObject;
    if (localIterator.hasNext())
    {
      localAnnotatedField = (AnnotatedField)localIterator.next();
      str = localAnnotatedField.getName();
      if (localAnnotationIntrospector == null)
      {
        localObject = null;
        label56:
        if (!"".equals(localObject)) {
          break label195;
        }
        localObject = str;
      }
    }
    label74:
    label192:
    label195:
    for (;;)
    {
      boolean bool1;
      if (localObject != null)
      {
        bool1 = true;
        if (bool1) {
          break label192;
        }
        bool1 = this._visibilityChecker.isFieldVisible(localAnnotatedField);
      }
      for (;;)
      {
        if ((localAnnotationIntrospector != null) && (localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedField))) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          _property(str).addField(localAnnotatedField, (String)localObject, bool1, bool2);
          break;
          if (this._forSerialization)
          {
            localObject = localAnnotationIntrospector.findNameForSerialization(localAnnotatedField);
            if (localObject == null)
            {
              localObject = null;
              break label56;
            }
            localObject = ((PropertyName)localObject).getSimpleName();
            break label56;
          }
          localObject = localAnnotationIntrospector.findNameForDeserialization(localAnnotatedField);
          if (localObject == null)
          {
            localObject = null;
            break label56;
          }
          localObject = ((PropertyName)localObject).getSimpleName();
          break label56;
          bool1 = false;
          break label74;
        }
        return;
      }
    }
  }
  
  protected void _addGetterMethod(AnnotatedMethod paramAnnotatedMethod, AnnotationIntrospector paramAnnotationIntrospector)
  {
    Object localObject2 = null;
    if (paramAnnotationIntrospector != null) {
      if (paramAnnotationIntrospector.hasAnyGetterAnnotation(paramAnnotatedMethod))
      {
        if (this._anyGetters == null) {
          this._anyGetters = new LinkedList();
        }
        this._anyGetters.add(paramAnnotatedMethod);
      }
    }
    label95:
    Object localObject3;
    do
    {
      return;
      if (paramAnnotationIntrospector.hasAsValueAnnotation(paramAnnotatedMethod))
      {
        if (this._jsonValueGetters == null) {
          this._jsonValueGetters = new LinkedList();
        }
        this._jsonValueGetters.add(paramAnnotatedMethod);
        return;
      }
      if (paramAnnotationIntrospector != null) {
        break;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label182;
      }
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label214;
      }
      localObject3 = BeanUtil.okNameForRegularGetter(paramAnnotatedMethod, paramAnnotatedMethod.getName());
      if (localObject3 != null) {
        break label192;
      }
      localObject3 = BeanUtil.okNameForIsGetter(paramAnnotatedMethod, paramAnnotatedMethod.getName());
    } while (localObject3 == null);
    boolean bool1 = this._visibilityChecker.isIsGetterVisible(paramAnnotatedMethod);
    localObject2 = localObject1;
    Object localObject1 = localObject3;
    label149:
    if (paramAnnotationIntrospector == null) {}
    for (boolean bool2 = false;; bool2 = paramAnnotationIntrospector.hasIgnoreMarker(paramAnnotatedMethod))
    {
      _property((String)localObject1).addGetter(paramAnnotatedMethod, (String)localObject2, bool1, bool2);
      return;
      localObject1 = paramAnnotationIntrospector.findNameForSerialization(paramAnnotatedMethod);
      break;
      label182:
      localObject1 = ((PropertyName)localObject1).getSimpleName();
      break label95;
      label192:
      bool1 = this._visibilityChecker.isGetterVisible(paramAnnotatedMethod);
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label149;
      label214:
      localObject3 = BeanUtil.okNameForGetter(paramAnnotatedMethod);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = paramAnnotatedMethod.getName();
      }
      localObject3 = localObject1;
      if (((String)localObject1).length() == 0) {
        localObject3 = localObject2;
      }
      bool1 = true;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label149;
    }
  }
  
  protected void _addInjectables()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    if (localAnnotationIntrospector == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this._classDef.fields().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (AnnotatedField)localIterator.next();
        _doAddInjectable(localAnnotationIntrospector.findInjectableValueId((AnnotatedMember)localObject), (AnnotatedMember)localObject);
      }
      localIterator = this._classDef.memberMethods().iterator();
      while (localIterator.hasNext())
      {
        localObject = (AnnotatedMethod)localIterator.next();
        if (((AnnotatedMethod)localObject).getParameterCount() == 1) {
          _doAddInjectable(localAnnotationIntrospector.findInjectableValueId((AnnotatedMember)localObject), (AnnotatedMember)localObject);
        }
      }
    }
  }
  
  protected void _addMethods()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    Iterator localIterator = this._classDef.memberMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      int i = localAnnotatedMethod.getParameterCount();
      if (i == 0)
      {
        _addGetterMethod(localAnnotatedMethod, localAnnotationIntrospector);
      }
      else if (i == 1)
      {
        _addSetterMethod(localAnnotatedMethod, localAnnotationIntrospector);
      }
      else if ((i == 2) && (localAnnotationIntrospector != null) && (localAnnotationIntrospector.hasAnySetterAnnotation(localAnnotatedMethod)))
      {
        if (this._anySetters == null) {
          this._anySetters = new LinkedList();
        }
        this._anySetters.add(localAnnotatedMethod);
      }
    }
  }
  
  protected void _addSetterMethod(AnnotatedMethod paramAnnotatedMethod, AnnotationIntrospector paramAnnotationIntrospector)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramAnnotationIntrospector == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label50;
      }
      localObject1 = localObject2;
    }
    label50:
    boolean bool1;
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = BeanUtil.okNameForMutator(paramAnnotatedMethod, this._mutatorPrefix);
        if (localObject2 == null)
        {
          return;
          localObject1 = paramAnnotationIntrospector.findNameForDeserialization(paramAnnotatedMethod);
          break;
          localObject1 = ((PropertyName)localObject1).getSimpleName();
          continue;
        }
        bool1 = this._visibilityChecker.isSetterVisible(paramAnnotatedMethod);
        localObject3 = localObject1;
        localObject1 = localObject2;
        if (paramAnnotationIntrospector != null) {
          break label152;
        }
      }
    }
    label152:
    for (boolean bool2 = false;; bool2 = paramAnnotationIntrospector.hasIgnoreMarker(paramAnnotatedMethod))
    {
      _property((String)localObject1).addSetter(paramAnnotatedMethod, (String)localObject3, bool1, bool2);
      return;
      localObject3 = BeanUtil.okNameForMutator(paramAnnotatedMethod, this._mutatorPrefix);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = paramAnnotatedMethod.getName();
      }
      localObject3 = localObject1;
      if (((String)localObject1).length() == 0) {
        localObject3 = localObject2;
      }
      bool1 = true;
      localObject1 = localObject2;
      break;
    }
  }
  
  protected void _doAddInjectable(Object paramObject, AnnotatedMember paramAnnotatedMember)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (this._injectables == null) {
        this._injectables = new LinkedHashMap();
      }
    } while ((AnnotatedMember)this._injectables.put(paramObject, paramAnnotatedMember) == null);
    if (paramObject == null) {}
    for (paramAnnotatedMember = "[null]";; paramAnnotatedMember = paramObject.getClass().getName()) {
      throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(paramObject) + "' (of type " + paramAnnotatedMember + ")");
    }
  }
  
  protected POJOPropertyBuilder _property(String paramString)
  {
    POJOPropertyBuilder localPOJOPropertyBuilder2 = (POJOPropertyBuilder)this._properties.get(paramString);
    POJOPropertyBuilder localPOJOPropertyBuilder1 = localPOJOPropertyBuilder2;
    if (localPOJOPropertyBuilder2 == null)
    {
      localPOJOPropertyBuilder1 = new POJOPropertyBuilder(paramString, this._annotationIntrospector, this._forSerialization);
      this._properties.put(paramString, localPOJOPropertyBuilder1);
    }
    return localPOJOPropertyBuilder1;
  }
  
  protected void _removeUnwantedProperties()
  {
    Iterator localIterator = this._properties.entrySet().iterator();
    while (localIterator.hasNext())
    {
      POJOPropertyBuilder localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map.Entry)localIterator.next()).getValue();
      if (!localPOJOPropertyBuilder.anyVisible())
      {
        localIterator.remove();
      }
      else
      {
        if (localPOJOPropertyBuilder.anyIgnorals())
        {
          if (!localPOJOPropertyBuilder.isExplicitlyIncluded())
          {
            localIterator.remove();
            _addIgnored(localPOJOPropertyBuilder.getName());
            continue;
          }
          localPOJOPropertyBuilder.removeIgnored();
          if ((!this._forSerialization) && (!localPOJOPropertyBuilder.couldDeserialize())) {
            _addIgnored(localPOJOPropertyBuilder.getName());
          }
        }
        localPOJOPropertyBuilder.removeNonVisible();
      }
    }
  }
  
  protected void _renameProperties()
  {
    Object localObject3 = this._properties.entrySet().iterator();
    Object localObject1 = null;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map.Entry)((Iterator)localObject3).next()).getValue();
      String str = localPOJOPropertyBuilder.findNewName();
      if (str != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new LinkedList();
        }
        ((LinkedList)localObject2).add(localPOJOPropertyBuilder.withName(str));
        ((Iterator)localObject3).remove();
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (POJOPropertyBuilder)((Iterator)localObject1).next();
        localObject3 = ((POJOPropertyBuilder)localObject2).getName();
        localPOJOPropertyBuilder = (POJOPropertyBuilder)this._properties.get(localObject3);
        if (localPOJOPropertyBuilder == null) {
          this._properties.put(localObject3, localObject2);
        } else {
          localPOJOPropertyBuilder.addAll((POJOPropertyBuilder)localObject2);
        }
      }
    }
  }
  
  protected void _renameUsing(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    POJOPropertyBuilder[] arrayOfPOJOPropertyBuilder = (POJOPropertyBuilder[])this._properties.values().toArray(new POJOPropertyBuilder[this._properties.size()]);
    this._properties.clear();
    int j = arrayOfPOJOPropertyBuilder.length;
    int i = 0;
    POJOPropertyBuilder localPOJOPropertyBuilder2;
    String str;
    if (i < j)
    {
      localPOJOPropertyBuilder2 = arrayOfPOJOPropertyBuilder[i];
      str = localPOJOPropertyBuilder2.getName();
      if (this._forSerialization) {
        if (localPOJOPropertyBuilder2.hasGetter()) {
          str = paramPropertyNamingStrategy.nameForGetterMethod(this._config, localPOJOPropertyBuilder2.getGetter(), str);
        }
      }
    }
    label90:
    label305:
    for (;;)
    {
      POJOPropertyBuilder localPOJOPropertyBuilder1 = localPOJOPropertyBuilder2;
      if (!str.equals(localPOJOPropertyBuilder2.getName())) {
        localPOJOPropertyBuilder1 = localPOJOPropertyBuilder2.withName(str);
      }
      localPOJOPropertyBuilder2 = (POJOPropertyBuilder)this._properties.get(str);
      if (localPOJOPropertyBuilder2 == null) {
        this._properties.put(str, localPOJOPropertyBuilder1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!localPOJOPropertyBuilder2.hasField()) {
          break label305;
        }
        str = paramPropertyNamingStrategy.nameForField(this._config, localPOJOPropertyBuilder2.getField(), str);
        break label90;
        if (localPOJOPropertyBuilder2.hasSetter())
        {
          str = paramPropertyNamingStrategy.nameForSetterMethod(this._config, localPOJOPropertyBuilder2.getSetter(), str);
          break label90;
        }
        if (localPOJOPropertyBuilder2.hasConstructorParameter())
        {
          str = paramPropertyNamingStrategy.nameForConstructorParameter(this._config, localPOJOPropertyBuilder2.getConstructorParameter(), str);
          break label90;
        }
        if (localPOJOPropertyBuilder2.hasField())
        {
          str = paramPropertyNamingStrategy.nameForField(this._config, localPOJOPropertyBuilder2.getField(), str);
          break label90;
        }
        if (!localPOJOPropertyBuilder2.hasGetter()) {
          break label305;
        }
        str = paramPropertyNamingStrategy.nameForGetterMethod(this._config, localPOJOPropertyBuilder2.getGetter(), str);
        break label90;
        localPOJOPropertyBuilder2.addAll(localPOJOPropertyBuilder1);
      }
      return;
    }
  }
  
  protected void _renameWithWrappers()
  {
    Object localObject3 = this._properties.entrySet().iterator();
    Object localObject1 = null;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map.Entry)((Iterator)localObject3).next()).getValue();
      localObject2 = localPOJOPropertyBuilder.getPrimaryMember();
      if (localObject2 != null)
      {
        localObject2 = this._annotationIntrospector.findWrapperName((Annotated)localObject2);
        if ((localObject2 != null) && (((PropertyName)localObject2).hasSimpleName()))
        {
          String str = ((PropertyName)localObject2).getSimpleName();
          if (!str.equals(localPOJOPropertyBuilder.getName()))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new LinkedList();
            }
            ((LinkedList)localObject2).add(localPOJOPropertyBuilder.withName(str));
            ((Iterator)localObject3).remove();
            localObject1 = localObject2;
          }
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (POJOPropertyBuilder)((Iterator)localObject1).next();
        localObject3 = ((POJOPropertyBuilder)localObject2).getName();
        localPOJOPropertyBuilder = (POJOPropertyBuilder)this._properties.get(localObject3);
        if (localPOJOPropertyBuilder == null) {
          this._properties.put(localObject3, localObject2);
        } else {
          localPOJOPropertyBuilder.addAll((POJOPropertyBuilder)localObject2);
        }
      }
    }
  }
  
  protected void _sortProperties()
  {
    Object localObject2 = this._annotationIntrospector;
    boolean bool;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label66;
      }
      bool = this._config.shouldSortPropertiesAlphabetically();
      label27:
      if (localObject2 != null) {
        break label75;
      }
    }
    label66:
    label75:
    for (Object localObject1 = null;; localObject1 = ((AnnotationIntrospector)localObject2).findSerializationPropertyOrder(this._classDef))
    {
      if ((bool) || (this._creatorProperties != null) || (localObject1 != null)) {
        break label89;
      }
      return;
      localObject1 = ((AnnotationIntrospector)localObject2).findSerializationSortAlphabetically(this._classDef);
      break;
      bool = ((Boolean)localObject1).booleanValue();
      break label27;
    }
    label89:
    int i = this._properties.size();
    if (bool) {}
    Object localObject3;
    for (localObject2 = new TreeMap();; localObject2 = new LinkedHashMap(i + i))
    {
      localObject3 = this._properties.values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (POJOPropertyBuilder)((Iterator)localObject3).next();
        ((Map)localObject2).put(((POJOPropertyBuilder)localObject4).getName(), localObject4);
      }
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(i + i);
    Object localObject5;
    if (localObject1 != null)
    {
      int j = localObject1.length;
      i = 0;
      if (i < j)
      {
        localObject5 = localObject1[i];
        localObject3 = (POJOPropertyBuilder)((Map)localObject2).get(localObject5);
        if (localObject3 != null) {
          break label402;
        }
        Iterator localIterator = this._properties.values().iterator();
        while (localIterator.hasNext())
        {
          localObject4 = (POJOPropertyBuilder)localIterator.next();
          if (((String)localObject5).equals(((POJOPropertyBuilder)localObject4).getInternalName()))
          {
            localObject5 = ((POJOPropertyBuilder)localObject4).getName();
            localObject3 = localObject4;
          }
        }
      }
    }
    label402:
    for (Object localObject4 = localObject5;; localObject4 = localObject5)
    {
      if (localObject3 != null) {
        localLinkedHashMap.put(localObject4, localObject3);
      }
      i += 1;
      break;
      if (this._creatorProperties != null)
      {
        localObject1 = this._creatorProperties.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (POJOPropertyBuilder)((Iterator)localObject1).next();
          localLinkedHashMap.put(((POJOPropertyBuilder)localObject3).getName(), localObject3);
        }
      }
      localLinkedHashMap.putAll((Map)localObject2);
      this._properties.clear();
      this._properties.putAll(localLinkedHashMap);
      return;
    }
  }
  
  public POJOPropertiesCollector collect()
  {
    this._properties.clear();
    _addFields();
    _addMethods();
    _addCreators();
    _addInjectables();
    _removeUnwantedProperties();
    _renameProperties();
    Object localObject = _findNamingStrategy();
    if (localObject != null) {
      _renameUsing((PropertyNamingStrategy)localObject);
    }
    localObject = this._properties.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((POJOPropertyBuilder)((Iterator)localObject).next()).trimByVisibility();
    }
    localObject = this._properties.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((POJOPropertyBuilder)((Iterator)localObject).next()).mergeAnnotations(this._forSerialization);
    }
    if (this._config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
      _renameWithWrappers();
    }
    _sortProperties();
    return this;
  }
  
  public AnnotatedMember getAnyGetter()
  {
    if (this._anyGetters != null)
    {
      if (this._anyGetters.size() > 1) {
        reportProblem("Multiple 'any-getters' defined (" + this._anyGetters.get(0) + " vs " + this._anyGetters.get(1) + ")");
      }
      return (AnnotatedMember)this._anyGetters.getFirst();
    }
    return null;
  }
  
  public AnnotatedMethod getAnySetterMethod()
  {
    if (this._anySetters != null)
    {
      if (this._anySetters.size() > 1) {
        reportProblem("Multiple 'any-setters' defined (" + this._anySetters.get(0) + " vs " + this._anySetters.get(1) + ")");
      }
      return (AnnotatedMethod)this._anySetters.getFirst();
    }
    return null;
  }
  
  public AnnotatedClass getClassDef()
  {
    return this._classDef;
  }
  
  public MapperConfig<?> getConfig()
  {
    return this._config;
  }
  
  public Set<String> getIgnoredPropertyNames()
  {
    return this._ignoredPropertyNames;
  }
  
  public Map<Object, AnnotatedMember> getInjectables()
  {
    return this._injectables;
  }
  
  public AnnotatedMethod getJsonValueMethod()
  {
    if (this._jsonValueGetters != null)
    {
      if (this._jsonValueGetters.size() > 1) {
        reportProblem("Multiple value properties defined (" + this._jsonValueGetters.get(0) + " vs " + this._jsonValueGetters.get(1) + ")");
      }
      return (AnnotatedMethod)this._jsonValueGetters.get(0);
    }
    return null;
  }
  
  public ObjectIdInfo getObjectIdInfo()
  {
    Object localObject;
    if (this._annotationIntrospector == null) {
      localObject = null;
    }
    ObjectIdInfo localObjectIdInfo;
    do
    {
      return (ObjectIdInfo)localObject;
      localObjectIdInfo = this._annotationIntrospector.findObjectIdInfo(this._classDef);
      localObject = localObjectIdInfo;
    } while (localObjectIdInfo == null);
    return this._annotationIntrospector.findObjectReferenceInfo(this._classDef, localObjectIdInfo);
  }
  
  public List<BeanPropertyDefinition> getProperties()
  {
    return new ArrayList(this._properties.values());
  }
  
  public JavaType getType()
  {
    return this._type;
  }
  
  protected void reportProblem(String paramString)
  {
    throw new IllegalArgumentException("Problem with definition of " + this._classDef + ": " + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/POJOPropertiesCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */