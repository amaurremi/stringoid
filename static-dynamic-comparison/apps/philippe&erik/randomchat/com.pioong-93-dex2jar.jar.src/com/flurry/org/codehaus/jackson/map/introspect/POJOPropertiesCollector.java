package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.BeanPropertyDefinition;
import com.flurry.org.codehaus.jackson.map.MapperConfig;
import com.flurry.org.codehaus.jackson.map.PropertyNamingStrategy;
import com.flurry.org.codehaus.jackson.map.util.BeanUtil;
import com.flurry.org.codehaus.jackson.type.JavaType;
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
  protected LinkedList<AnnotatedMethod> _anyGetters = null;
  protected LinkedList<AnnotatedMethod> _anySetters = null;
  protected final AnnotatedClass _classDef;
  protected final MapperConfig<?> _config;
  protected LinkedList<POJOPropertyBuilder> _creatorProperties = null;
  protected final boolean _forSerialization;
  protected Set<String> _ignoredPropertyNames;
  protected Set<String> _ignoredPropertyNamesForDeser;
  protected LinkedHashMap<Object, AnnotatedMember> _injectables;
  protected LinkedList<AnnotatedMethod> _jsonValueGetters = null;
  protected final LinkedHashMap<String, POJOPropertyBuilder> _properties = new LinkedHashMap();
  protected final JavaType _type;
  protected final VisibilityChecker<?> _visibilityChecker;
  
  protected POJOPropertiesCollector(MapperConfig<?> paramMapperConfig, boolean paramBoolean, JavaType paramJavaType, AnnotatedClass paramAnnotatedClass)
  {
    this._config = paramMapperConfig;
    this._forSerialization = paramBoolean;
    this._type = paramJavaType;
    this._classDef = paramAnnotatedClass;
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
  
  private void _addIgnored(POJOPropertyBuilder paramPOJOPropertyBuilder)
  {
    if (this._forSerialization) {}
    String str;
    do
    {
      return;
      str = paramPOJOPropertyBuilder.getName();
      this._ignoredPropertyNames = addToSet(this._ignoredPropertyNames, str);
    } while (!paramPOJOPropertyBuilder.anyDeserializeIgnorals());
    this._ignoredPropertyNamesForDeser = addToSet(this._ignoredPropertyNamesForDeser, str);
  }
  
  private Set<String> addToSet(Set<String> paramSet, String paramString)
  {
    Object localObject = paramSet;
    if (paramSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramString);
    return (Set<String>)localObject;
  }
  
  protected void _addCreators()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    if (localAnnotationIntrospector == null) {
      return;
    }
    Iterator localIterator = this._classDef.getConstructors().iterator();
    Object localObject;
    int i;
    int j;
    AnnotatedParameter localAnnotatedParameter;
    String str;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    while (localIterator.hasNext())
    {
      localObject = (AnnotatedConstructor)localIterator.next();
      if (this._creatorProperties == null) {
        this._creatorProperties = new LinkedList();
      }
      i = 0;
      j = ((AnnotatedConstructor)localObject).getParameterCount();
      while (i < j)
      {
        localAnnotatedParameter = ((AnnotatedConstructor)localObject).getParameter(i);
        str = localAnnotationIntrospector.findPropertyNameForParam(localAnnotatedParameter);
        if (str != null)
        {
          localPOJOPropertyBuilder = _property(str);
          localPOJOPropertyBuilder.addCtor(localAnnotatedParameter, str, true, false);
          this._creatorProperties.add(localPOJOPropertyBuilder);
        }
        i += 1;
      }
    }
    localIterator = this._classDef.getStaticMethods().iterator();
    while (localIterator.hasNext())
    {
      localObject = (AnnotatedMethod)localIterator.next();
      if (this._creatorProperties == null) {
        this._creatorProperties = new LinkedList();
      }
      i = 0;
      j = ((AnnotatedMethod)localObject).getParameterCount();
      while (i < j)
      {
        localAnnotatedParameter = ((AnnotatedMethod)localObject).getParameter(i);
        str = localAnnotationIntrospector.findPropertyNameForParam(localAnnotatedParameter);
        if (str != null)
        {
          localPOJOPropertyBuilder = _property(str);
          localPOJOPropertyBuilder.addCtor(localAnnotatedParameter, str, true, false);
          this._creatorProperties.add(localPOJOPropertyBuilder);
        }
        i += 1;
      }
    }
  }
  
  protected void _addFields()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    Iterator localIterator = this._classDef.fields().iterator();
    if (localIterator.hasNext())
    {
      AnnotatedField localAnnotatedField = (AnnotatedField)localIterator.next();
      String str = localAnnotatedField.getName();
      Object localObject1;
      label56:
      Object localObject2;
      label79:
      boolean bool2;
      if (localAnnotationIntrospector == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if ("".equals(localObject1)) {
          localObject2 = str;
        }
        if (localObject2 == null) {
          break label161;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          bool2 = this._visibilityChecker.isFieldVisible(localAnnotatedField);
        }
        if ((localAnnotationIntrospector == null) || (!localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedField))) {
          break label166;
        }
      }
      label161:
      label166:
      for (boolean bool1 = true;; bool1 = false)
      {
        _property(str).addField(localAnnotatedField, (String)localObject2, bool2, bool1);
        break;
        if (this._forSerialization)
        {
          localObject1 = localAnnotationIntrospector.findSerializablePropertyName(localAnnotatedField);
          break label56;
        }
        localObject1 = localAnnotationIntrospector.findDeserializablePropertyName(localAnnotatedField);
        break label56;
        bool1 = false;
        break label79;
      }
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
      Object localObject1;
      label147:
      Object localObject2;
      boolean bool1;
      label198:
      boolean bool2;
      label235:
      label250:
      Object localObject3;
      if (i == 0)
      {
        if (localAnnotationIntrospector != null)
        {
          if (localAnnotationIntrospector.hasAnyGetterAnnotation(localAnnotatedMethod))
          {
            if (this._anyGetters == null) {
              this._anyGetters = new LinkedList();
            }
            this._anyGetters.add(localAnnotatedMethod);
            continue;
          }
          if (localAnnotationIntrospector.hasAsValueAnnotation(localAnnotatedMethod))
          {
            if (this._jsonValueGetters == null) {
              this._jsonValueGetters = new LinkedList();
            }
            this._jsonValueGetters.add(localAnnotatedMethod);
            continue;
          }
        }
        if (localAnnotationIntrospector == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label250;
          }
          localObject2 = BeanUtil.okNameForRegularGetter(localAnnotatedMethod, localAnnotatedMethod.getName());
          if (localObject2 != null) {
            break label235;
          }
          localObject2 = BeanUtil.okNameForIsGetter(localAnnotatedMethod, localAnnotatedMethod.getName());
          if (localObject2 == null) {
            continue;
          }
          bool1 = this._visibilityChecker.isIsGetterVisible(localAnnotatedMethod);
          if (localAnnotationIntrospector != null) {
            break label298;
          }
        }
        label298:
        for (bool2 = false;; bool2 = localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedMethod))
        {
          _property((String)localObject2).addGetter(localAnnotatedMethod, (String)localObject1, bool1, bool2);
          break;
          localObject1 = localAnnotationIntrospector.findGettablePropertyName(localAnnotatedMethod);
          break label147;
          bool1 = this._visibilityChecker.isGetterVisible(localAnnotatedMethod);
          break label198;
          localObject3 = BeanUtil.okNameForGetter(localAnnotatedMethod);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localAnnotatedMethod.getName();
          }
          localObject3 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject3 = localObject2;
          }
          bool1 = true;
          localObject1 = localObject3;
          break label198;
        }
      }
      else if (i == 1)
      {
        if (localAnnotationIntrospector == null)
        {
          localObject1 = null;
          label322:
          if (localObject1 != null) {
            break label388;
          }
          localObject2 = BeanUtil.okNameForSetter(localAnnotatedMethod);
          if (localObject2 == null) {
            continue;
          }
          bool1 = this._visibilityChecker.isSetterVisible(localAnnotatedMethod);
          label351:
          if (localAnnotationIntrospector != null) {
            break label436;
          }
        }
        label388:
        label436:
        for (bool2 = false;; bool2 = localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedMethod))
        {
          _property((String)localObject2).addSetter(localAnnotatedMethod, (String)localObject1, bool1, bool2);
          break;
          localObject1 = localAnnotationIntrospector.findSettablePropertyName(localAnnotatedMethod);
          break label322;
          localObject3 = BeanUtil.okNameForSetter(localAnnotatedMethod);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localAnnotatedMethod.getName();
          }
          localObject3 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject3 = localObject2;
          }
          bool1 = true;
          localObject1 = localObject3;
          break label351;
        }
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
      localPOJOPropertyBuilder1 = new POJOPropertyBuilder(paramString);
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
      else if (localPOJOPropertyBuilder.anyIgnorals())
      {
        _addIgnored(localPOJOPropertyBuilder);
        if (!localPOJOPropertyBuilder.anyExplicitNames()) {
          localIterator.remove();
        } else {
          localPOJOPropertyBuilder.removeIgnored();
        }
      }
      else
      {
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
    if (i < j)
    {
      POJOPropertyBuilder localPOJOPropertyBuilder = arrayOfPOJOPropertyBuilder[i];
      Object localObject2 = localPOJOPropertyBuilder.getName();
      Object localObject1;
      if (this._forSerialization) {
        if (localPOJOPropertyBuilder.hasGetter())
        {
          localObject1 = paramPropertyNamingStrategy.nameForGetterMethod(this._config, localPOJOPropertyBuilder.getGetter(), (String)localObject2);
          label90:
          localObject2 = localPOJOPropertyBuilder;
          if (!((String)localObject1).equals(localPOJOPropertyBuilder.getName())) {
            localObject2 = localPOJOPropertyBuilder.withName((String)localObject1);
          }
          localPOJOPropertyBuilder = (POJOPropertyBuilder)this._properties.get(localObject1);
          if (localPOJOPropertyBuilder != null) {
            break label302;
          }
          this._properties.put(localObject1, localObject2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = localObject2;
        if (!localPOJOPropertyBuilder.hasField()) {
          break label90;
        }
        localObject1 = paramPropertyNamingStrategy.nameForField(this._config, localPOJOPropertyBuilder.getField(), (String)localObject2);
        break label90;
        if (localPOJOPropertyBuilder.hasSetter())
        {
          localObject1 = paramPropertyNamingStrategy.nameForSetterMethod(this._config, localPOJOPropertyBuilder.getSetter(), (String)localObject2);
          break label90;
        }
        if (localPOJOPropertyBuilder.hasConstructorParameter())
        {
          localObject1 = paramPropertyNamingStrategy.nameForConstructorParameter(this._config, localPOJOPropertyBuilder.getConstructorParameter(), (String)localObject2);
          break label90;
        }
        if (localPOJOPropertyBuilder.hasField())
        {
          localObject1 = paramPropertyNamingStrategy.nameForField(this._config, localPOJOPropertyBuilder.getField(), (String)localObject2);
          break label90;
        }
        localObject1 = localObject2;
        if (!localPOJOPropertyBuilder.hasGetter()) {
          break label90;
        }
        localObject1 = paramPropertyNamingStrategy.nameForGetterMethod(this._config, localPOJOPropertyBuilder.getGetter(), (String)localObject2);
        break label90;
        label302:
        localPOJOPropertyBuilder.addAll((POJOPropertyBuilder)localObject2);
      }
    }
  }
  
  protected void _sortProperties()
  {
    Object localObject1 = this._config.getAnnotationIntrospector();
    Object localObject2 = ((AnnotationIntrospector)localObject1).findSerializationSortAlphabetically(this._classDef);
    if (localObject2 == null) {}
    String[] arrayOfString;
    for (boolean bool = this._config.shouldSortPropertiesAlphabetically();; bool = ((Boolean)localObject2).booleanValue())
    {
      arrayOfString = ((AnnotationIntrospector)localObject1).findSerializationPropertyOrder(this._classDef);
      if ((bool) || (this._creatorProperties != null) || (arrayOfString != null)) {
        break;
      }
      return;
    }
    int i = this._properties.size();
    if (bool) {}
    Object localObject3;
    for (localObject1 = new TreeMap();; localObject1 = new LinkedHashMap(i + i))
    {
      localObject2 = this._properties.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (POJOPropertyBuilder)((Iterator)localObject2).next();
        ((Map)localObject1).put(((POJOPropertyBuilder)localObject3).getName(), localObject3);
      }
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(i + i);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        POJOPropertyBuilder localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map)localObject1).get(str);
        localObject3 = str;
        localObject2 = localPOJOPropertyBuilder;
        if (localPOJOPropertyBuilder == null)
        {
          Iterator localIterator = this._properties.values().iterator();
          do
          {
            localObject3 = str;
            localObject2 = localPOJOPropertyBuilder;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (POJOPropertyBuilder)localIterator.next();
          } while (!str.equals(((POJOPropertyBuilder)localObject3).getInternalName()));
          localObject2 = localObject3;
          localObject3 = ((POJOPropertyBuilder)localObject3).getName();
        }
        if (localObject2 != null) {
          localLinkedHashMap.put(localObject3, localObject2);
        }
        i += 1;
      }
    }
    if (this._creatorProperties != null)
    {
      localObject2 = this._creatorProperties.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (POJOPropertyBuilder)((Iterator)localObject2).next();
        localLinkedHashMap.put(((POJOPropertyBuilder)localObject3).getName(), localObject3);
      }
    }
    localLinkedHashMap.putAll((Map)localObject1);
    this._properties.clear();
    this._properties.putAll(localLinkedHashMap);
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
    Object localObject = this._config.getPropertyNamingStrategy();
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
    _sortProperties();
    return this;
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._annotationIntrospector;
  }
  
  public AnnotatedMethod getAnyGetterMethod()
  {
    if (this._anyGetters != null)
    {
      if (this._anyGetters.size() > 1) {
        reportProblem("Multiple 'any-getters' defined (" + this._anyGetters.get(0) + " vs " + this._anyGetters.get(1) + ")");
      }
      return (AnnotatedMethod)this._anyGetters.getFirst();
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
  
  public Set<String> getIgnoredPropertyNamesForDeser()
  {
    return this._ignoredPropertyNamesForDeser;
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
  
  public List<BeanPropertyDefinition> getProperties()
  {
    return new ArrayList(this._properties.values());
  }
  
  protected Map<String, POJOPropertyBuilder> getPropertyMap()
  {
    return this._properties;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/introspect/POJOPropertiesCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */