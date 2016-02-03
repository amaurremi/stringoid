package org.codehaus.jackson.map.introspect;

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
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.util.BeanUtil;
import org.codehaus.jackson.type.JavaType;

public class POJOPropertiesCollector
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected LinkedList _anyGetters = null;
  protected LinkedList _anySetters = null;
  protected final AnnotatedClass _classDef;
  protected final MapperConfig _config;
  protected LinkedList _creatorProperties = null;
  protected final boolean _forSerialization;
  protected Set _ignoredPropertyNames;
  protected Set _ignoredPropertyNamesForDeser;
  protected LinkedHashMap _injectables;
  protected LinkedList _jsonValueGetters = null;
  protected final LinkedHashMap _properties = new LinkedHashMap();
  protected final JavaType _type;
  protected final VisibilityChecker _visibilityChecker;
  
  protected POJOPropertiesCollector(MapperConfig paramMapperConfig, boolean paramBoolean, JavaType paramJavaType, AnnotatedClass paramAnnotatedClass)
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
  
  private Set addToSet(Set paramSet, String paramString)
  {
    Object localObject = paramSet;
    if (paramSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramString);
    return (Set)localObject;
  }
  
  protected void _addCreators()
  {
    AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
    if (localAnnotationIntrospector == null) {
      return;
    }
    Iterator localIterator = this._classDef.getConstructors().iterator();
    Object localObject;
    int j;
    int i;
    AnnotatedParameter localAnnotatedParameter;
    String str;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    while (localIterator.hasNext())
    {
      localObject = (AnnotatedConstructor)localIterator.next();
      if (this._creatorProperties == null) {
        this._creatorProperties = new LinkedList();
      }
      j = ((AnnotatedConstructor)localObject).getParameterCount();
      i = 0;
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
      j = ((AnnotatedMethod)localObject).getParameterCount();
      i = 0;
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
          break label167;
        }
        localObject = str;
      }
    }
    label74:
    label164:
    label167:
    for (;;)
    {
      boolean bool1;
      if (localObject != null)
      {
        bool1 = true;
        if (bool1) {
          break label164;
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
            localObject = localAnnotationIntrospector.findSerializablePropertyName(localAnnotatedField);
            break label56;
          }
          localObject = localAnnotationIntrospector.findDeserializablePropertyName(localAnnotatedField);
          break label56;
          bool1 = false;
          break label74;
        }
        return;
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
      Object localObject3;
      boolean bool1;
      Object localObject2;
      label206:
      boolean bool2;
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
            break label266;
          }
          localObject3 = BeanUtil.okNameForRegularGetter(localAnnotatedMethod, localAnnotatedMethod.getName());
          if (localObject3 != null) {
            break label243;
          }
          localObject3 = BeanUtil.okNameForIsGetter(localAnnotatedMethod, localAnnotatedMethod.getName());
          if (localObject3 == null) {
            continue;
          }
          bool1 = this._visibilityChecker.isIsGetterVisible(localAnnotatedMethod);
          localObject2 = localObject1;
          localObject1 = localObject3;
          if (localAnnotationIntrospector != null) {
            break label318;
          }
        }
        label243:
        label266:
        label318:
        for (bool2 = false;; bool2 = localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedMethod))
        {
          _property((String)localObject1).addGetter(localAnnotatedMethod, (String)localObject2, bool1, bool2);
          break;
          localObject1 = localAnnotationIntrospector.findGettablePropertyName(localAnnotatedMethod);
          break label147;
          bool1 = this._visibilityChecker.isGetterVisible(localAnnotatedMethod);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label206;
          localObject3 = BeanUtil.okNameForGetter(localAnnotatedMethod);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localAnnotatedMethod.getName();
          }
          localObject3 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject3 = localObject2;
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
          bool1 = true;
          break label206;
        }
      }
      else if (i == 1)
      {
        if (localAnnotationIntrospector == null)
        {
          localObject1 = null;
          label342:
          if (localObject1 != null) {
            break label416;
          }
          localObject3 = BeanUtil.okNameForSetter(localAnnotatedMethod);
          if (localObject3 == null) {
            continue;
          }
          bool1 = this._visibilityChecker.isSetterVisible(localAnnotatedMethod);
          localObject2 = localObject1;
          localObject1 = localObject3;
          label379:
          if (localAnnotationIntrospector != null) {
            break label468;
          }
        }
        label416:
        label468:
        for (bool2 = false;; bool2 = localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedMethod))
        {
          _property((String)localObject1).addSetter(localAnnotatedMethod, (String)localObject2, bool1, bool2);
          break;
          localObject1 = localAnnotationIntrospector.findSettablePropertyName(localAnnotatedMethod);
          break label342;
          localObject3 = BeanUtil.okNameForSetter(localAnnotatedMethod);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localAnnotatedMethod.getName();
          }
          localObject3 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject3 = localObject2;
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
          bool1 = true;
          break label379;
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
    String str;
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        str = arrayOfString[i];
        localObject2 = (POJOPropertyBuilder)((Map)localObject1).get(str);
        if (localObject2 != null) {
          break label383;
        }
        Iterator localIterator = this._properties.values().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (POJOPropertyBuilder)localIterator.next();
          if (str.equals(((POJOPropertyBuilder)localObject3).getInternalName()))
          {
            str = ((POJOPropertyBuilder)localObject3).getName();
            localObject2 = localObject3;
          }
        }
      }
    }
    label383:
    for (Object localObject3 = str;; localObject3 = str)
    {
      if (localObject2 != null) {
        localLinkedHashMap.put(localObject3, localObject2);
      }
      i += 1;
      break;
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
  
  public MapperConfig getConfig()
  {
    return this._config;
  }
  
  public Set getIgnoredPropertyNames()
  {
    return this._ignoredPropertyNames;
  }
  
  public Set getIgnoredPropertyNamesForDeser()
  {
    return this._ignoredPropertyNamesForDeser;
  }
  
  public Map getInjectables()
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
  
  public List getProperties()
  {
    return new ArrayList(this._properties.values());
  }
  
  protected Map getPropertyMap()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/POJOPropertiesCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */