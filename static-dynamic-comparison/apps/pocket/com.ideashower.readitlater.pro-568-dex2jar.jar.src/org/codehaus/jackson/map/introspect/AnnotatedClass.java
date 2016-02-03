package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ClassIntrospector.MixInResolver;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.ClassUtil;

public final class AnnotatedClass
  extends Annotated
{
  private static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final Class _class;
  protected AnnotationMap _classAnnotations;
  protected List _constructors;
  protected List _creatorMethods;
  protected AnnotatedConstructor _defaultConstructor;
  protected List _fields;
  protected AnnotatedMethodMap _memberMethods;
  protected final ClassIntrospector.MixInResolver _mixInResolver;
  protected final Class _primaryMixIn;
  protected final List _superTypes;
  
  private AnnotatedClass(Class paramClass, List paramList, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver, AnnotationMap paramAnnotationMap)
  {
    this._class = paramClass;
    this._superTypes = paramList;
    this._annotationIntrospector = paramAnnotationIntrospector;
    this._mixInResolver = paramMixInResolver;
    if (this._mixInResolver == null) {}
    for (paramClass = null;; paramClass = this._mixInResolver.findMixInClassFor(this._class))
    {
      this._primaryMixIn = paramClass;
      this._classAnnotations = paramAnnotationMap;
      return;
    }
  }
  
  private AnnotationMap _emptyAnnotationMap()
  {
    return new AnnotationMap();
  }
  
  private AnnotationMap[] _emptyAnnotationMaps(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = NO_ANNOTATION_MAPS;
      return (AnnotationMap[])localObject;
    }
    AnnotationMap[] arrayOfAnnotationMap = new AnnotationMap[paramInt];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfAnnotationMap;
      if (i >= paramInt) {
        break;
      }
      arrayOfAnnotationMap[i] = _emptyAnnotationMap();
      i += 1;
    }
  }
  
  private boolean _isIncludableField(Field paramField)
  {
    if (paramField.isSynthetic()) {}
    int i;
    do
    {
      return false;
      i = paramField.getModifiers();
    } while ((Modifier.isStatic(i)) || (Modifier.isTransient(i)));
    return true;
  }
  
  public static AnnotatedClass construct(Class paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    paramClass = new AnnotatedClass(paramClass, ClassUtil.findSuperTypes(paramClass, null), paramAnnotationIntrospector, paramMixInResolver, null);
    paramClass.resolveClassAnnotations();
    return paramClass;
  }
  
  public static AnnotatedClass constructWithoutSuperTypes(Class paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    paramClass = new AnnotatedClass(paramClass, Collections.emptyList(), paramAnnotationIntrospector, paramMixInResolver, null);
    paramClass.resolveClassAnnotations();
    return paramClass;
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class paramClass)
  {
    if (this._mixInResolver != null) {
      _addClassMixIns(paramAnnotationMap, paramClass, this._mixInResolver.findMixInClassFor(paramClass));
    }
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class paramClass1, Class paramClass2)
  {
    if (paramClass2 == null) {
      return;
    }
    Annotation[] arrayOfAnnotation = paramClass2.getDeclaredAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      if (this._annotationIntrospector.isHandled(localAnnotation)) {
        paramAnnotationMap.addIfNotPresent(localAnnotation);
      }
      i += 1;
    }
    paramClass1 = ClassUtil.findSuperTypes(paramClass2, paramClass1).iterator();
    while (paramClass1.hasNext())
    {
      paramClass2 = ((Class)paramClass1.next()).getDeclaredAnnotations();
      j = paramClass2.length;
      i = 0;
      while (i < j)
      {
        arrayOfAnnotation = paramClass2[i];
        if (this._annotationIntrospector.isHandled(arrayOfAnnotation)) {
          paramAnnotationMap.addIfNotPresent(arrayOfAnnotation);
        }
        i += 1;
      }
    }
  }
  
  protected void _addConstructorMixIns(Class paramClass)
  {
    int i;
    int j;
    label24:
    Constructor localConstructor;
    Object localObject;
    if (this._constructors == null)
    {
      i = 0;
      Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
      int m = arrayOfConstructor.length;
      j = 0;
      paramClass = null;
      if (j >= m) {
        break label220;
      }
      localConstructor = arrayOfConstructor[j];
      if (localConstructor.getParameterTypes().length != 0) {
        break label92;
      }
      localObject = paramClass;
      if (this._defaultConstructor != null)
      {
        _addMixOvers(localConstructor, this._defaultConstructor, false);
        localObject = paramClass;
      }
    }
    for (;;)
    {
      j += 1;
      paramClass = (Class)localObject;
      break label24;
      i = this._constructors.size();
      break;
      label92:
      if (paramClass == null)
      {
        localObject = new MemberKey[i];
        k = 0;
        for (;;)
        {
          paramClass = (Class)localObject;
          if (k >= i) {
            break;
          }
          localObject[k] = new MemberKey(((AnnotatedConstructor)this._constructors.get(k)).getAnnotated());
          k += 1;
        }
      }
      localObject = new MemberKey(localConstructor);
      int k = 0;
      for (;;)
      {
        if (k < i) {
          if (!((MemberKey)localObject).equals(paramClass[k]))
          {
            k += 1;
          }
          else
          {
            _addMixOvers(localConstructor, (AnnotatedConstructor)this._constructors.get(k), true);
            localObject = paramClass;
            break;
            label220:
            return;
          }
        }
      }
      localObject = paramClass;
    }
  }
  
  protected void _addFactoryMixIns(Class paramClass)
  {
    Object localObject = null;
    int k = this._creatorMethods.size();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int m = arrayOfMethod.length;
    int i = 0;
    paramClass = (Class)localObject;
    Method localMethod;
    if (i < m)
    {
      localMethod = arrayOfMethod[i];
      if (!Modifier.isStatic(localMethod.getModifiers())) {
        localObject = paramClass;
      }
    }
    for (;;)
    {
      i += 1;
      paramClass = (Class)localObject;
      break;
      localObject = paramClass;
      if (localMethod.getParameterTypes().length != 0)
      {
        if (paramClass == null)
        {
          localObject = new MemberKey[k];
          j = 0;
          for (;;)
          {
            paramClass = (Class)localObject;
            if (j >= k) {
              break;
            }
            localObject[j] = new MemberKey(((AnnotatedMethod)this._creatorMethods.get(j)).getAnnotated());
            j += 1;
          }
        }
        localObject = new MemberKey(localMethod);
        int j = 0;
        for (;;)
        {
          if (j < k) {
            if (!((MemberKey)localObject).equals(paramClass[j]))
            {
              j += 1;
            }
            else
            {
              _addMixOvers(localMethod, (AnnotatedMethod)this._creatorMethods.get(j), true);
              localObject = paramClass;
              break;
              return;
            }
          }
        }
        localObject = paramClass;
      }
    }
  }
  
  protected void _addFieldMixIns(Class paramClass, Map paramMap)
  {
    paramClass = paramClass.getDeclaredFields();
    int k = paramClass.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramClass[i];
      if (!_isIncludableField((Field)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        AnnotatedField localAnnotatedField = (AnnotatedField)paramMap.get(((Field)localObject).getName());
        if (localAnnotatedField != null)
        {
          localObject = ((Field)localObject).getDeclaredAnnotations();
          int m = localObject.length;
          int j = 0;
          while (j < m)
          {
            Annotation localAnnotation = localObject[j];
            if (this._annotationIntrospector.isHandled(localAnnotation)) {
              localAnnotatedField.addOrOverride(localAnnotation);
            }
            j += 1;
          }
        }
      }
    }
  }
  
  protected void _addFields(Map paramMap, Class paramClass)
  {
    Object localObject = paramClass.getSuperclass();
    if (localObject != null)
    {
      _addFields(paramMap, (Class)localObject);
      localObject = paramClass.getDeclaredFields();
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Field localField = localObject[i];
        if (!_isIncludableField(localField)) {}
        for (;;)
        {
          i += 1;
          break;
          paramMap.put(localField.getName(), _constructField(localField));
        }
      }
      if (this._mixInResolver != null)
      {
        paramClass = this._mixInResolver.findMixInClassFor(paramClass);
        if (paramClass != null) {
          _addFieldMixIns(paramClass, paramMap);
        }
      }
    }
  }
  
  protected void _addMemberMethods(Class paramClass1, MethodFilter paramMethodFilter, AnnotatedMethodMap paramAnnotatedMethodMap1, Class paramClass2, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    if (paramClass2 != null) {
      _addMethodMixIns(paramMethodFilter, paramAnnotatedMethodMap1, paramClass2, paramAnnotatedMethodMap2);
    }
    if (paramClass1 == null) {
      return;
    }
    paramClass1 = paramClass1.getDeclaredMethods();
    int j = paramClass1.length;
    int i = 0;
    label32:
    if (i < j)
    {
      paramClass2 = paramClass1[i];
      if (_isIncludableMethod(paramClass2, paramMethodFilter)) {
        break label64;
      }
    }
    for (;;)
    {
      i += 1;
      break label32;
      break;
      label64:
      AnnotatedMethod localAnnotatedMethod = paramAnnotatedMethodMap1.find(paramClass2);
      if (localAnnotatedMethod == null)
      {
        localAnnotatedMethod = _constructMethod(paramClass2);
        paramAnnotatedMethodMap1.add(localAnnotatedMethod);
        paramClass2 = paramAnnotatedMethodMap2.remove(paramClass2);
        if (paramClass2 != null) {
          _addMixOvers(paramClass2.getAnnotated(), localAnnotatedMethod, false);
        }
      }
      else
      {
        _addMixUnders(paramClass2, localAnnotatedMethod);
        if ((localAnnotatedMethod.getDeclaringClass().isInterface()) && (!paramClass2.getDeclaringClass().isInterface())) {
          paramAnnotatedMethodMap1.add(localAnnotatedMethod.withMethod(paramClass2));
        }
      }
    }
  }
  
  protected void _addMethodMixIns(MethodFilter paramMethodFilter, AnnotatedMethodMap paramAnnotatedMethodMap1, Class paramClass, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Method localMethod = paramClass[i];
      if (!_isIncludableMethod(localMethod, paramMethodFilter)) {}
      for (;;)
      {
        i += 1;
        break;
        AnnotatedMethod localAnnotatedMethod = paramAnnotatedMethodMap1.find(localMethod);
        if (localAnnotatedMethod != null) {
          _addMixUnders(localMethod, localAnnotatedMethod);
        } else {
          paramAnnotatedMethodMap2.add(_constructMethod(localMethod));
        }
      }
    }
  }
  
  protected void _addMixOvers(Constructor paramConstructor, AnnotatedConstructor paramAnnotatedConstructor, boolean paramBoolean)
  {
    Annotation[] arrayOfAnnotation = paramConstructor.getDeclaredAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      if (this._annotationIntrospector.isHandled(localAnnotation)) {
        paramAnnotatedConstructor.addOrOverride(localAnnotation);
      }
      i += 1;
    }
    if (paramBoolean)
    {
      paramConstructor = paramConstructor.getParameterAnnotations();
      int k = paramConstructor.length;
      i = 0;
      while (i < k)
      {
        arrayOfAnnotation = paramConstructor[i];
        int m = arrayOfAnnotation.length;
        j = 0;
        while (j < m)
        {
          paramAnnotatedConstructor.addOrOverrideParam(i, arrayOfAnnotation[j]);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void _addMixOvers(Method paramMethod, AnnotatedMethod paramAnnotatedMethod, boolean paramBoolean)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getDeclaredAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      if (this._annotationIntrospector.isHandled(localAnnotation)) {
        paramAnnotatedMethod.addOrOverride(localAnnotation);
      }
      i += 1;
    }
    if (paramBoolean)
    {
      paramMethod = paramMethod.getParameterAnnotations();
      int k = paramMethod.length;
      i = 0;
      while (i < k)
      {
        arrayOfAnnotation = paramMethod[i];
        int m = arrayOfAnnotation.length;
        j = 0;
        while (j < m)
        {
          paramAnnotatedMethod.addOrOverrideParam(i, arrayOfAnnotation[j]);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void _addMixUnders(Method paramMethod, AnnotatedMethod paramAnnotatedMethod)
  {
    paramMethod = paramMethod.getDeclaredAnnotations();
    int j = paramMethod.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = paramMethod[i];
      if (this._annotationIntrospector.isHandled(localAnnotation)) {
        paramAnnotatedMethod.addIfNotPresent(localAnnotation);
      }
      i += 1;
    }
  }
  
  protected AnnotationMap _collectRelevantAnnotations(Annotation[] paramArrayOfAnnotation)
  {
    AnnotationMap localAnnotationMap = new AnnotationMap();
    if (paramArrayOfAnnotation != null)
    {
      int j = paramArrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        if (this._annotationIntrospector.isHandled(localAnnotation)) {
          localAnnotationMap.add(localAnnotation);
        }
        i += 1;
      }
    }
    return localAnnotationMap;
  }
  
  protected AnnotationMap[] _collectRelevantAnnotations(Annotation[][] paramArrayOfAnnotation)
  {
    int j = paramArrayOfAnnotation.length;
    AnnotationMap[] arrayOfAnnotationMap = new AnnotationMap[j];
    int i = 0;
    while (i < j)
    {
      arrayOfAnnotationMap[i] = _collectRelevantAnnotations(paramArrayOfAnnotation[i]);
      i += 1;
    }
    return arrayOfAnnotationMap;
  }
  
  protected AnnotatedConstructor _constructConstructor(Constructor paramConstructor, boolean paramBoolean)
  {
    if (this._annotationIntrospector == null) {
      return new AnnotatedConstructor(paramConstructor, _emptyAnnotationMap(), _emptyAnnotationMaps(paramConstructor.getParameterTypes().length));
    }
    if (paramBoolean) {
      return new AnnotatedConstructor(paramConstructor, _collectRelevantAnnotations(paramConstructor.getDeclaredAnnotations()), null);
    }
    Object localObject2 = paramConstructor.getParameterAnnotations();
    int i = paramConstructor.getParameterTypes().length;
    Object localObject1;
    Object localObject3;
    if (i != localObject2.length)
    {
      localObject1 = paramConstructor.getDeclaringClass();
      if (!((Class)localObject1).isMemberClass()) {
        break label283;
      }
      if (i == localObject2.length + 1)
      {
        localObject1 = new Annotation[localObject2.length + 1][];
        System.arraycopy(localObject2, 0, localObject1, 1, localObject2.length);
        localObject3 = _collectRelevantAnnotations((Annotation[][])localObject1);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        throw new IllegalStateException("Internal error: constructor for " + paramConstructor.getDeclaringClass().getName() + " has mismatch: " + i + " parameters; " + localObject2.length + " sets of annotations");
        if ((((Class)localObject1).isEnum()) && (i == localObject2.length + 2))
        {
          localObject3 = new Annotation[localObject2.length + 2][];
          System.arraycopy(localObject2, 0, localObject3, 2, localObject2.length);
          localObject1 = _collectRelevantAnnotations((Annotation[][])localObject3);
          localObject2 = localObject3;
          continue;
          localObject3 = _collectRelevantAnnotations((Annotation[][])localObject2);
        }
      }
      else
      {
        return new AnnotatedConstructor(paramConstructor, _collectRelevantAnnotations(paramConstructor.getDeclaredAnnotations()), (AnnotationMap[])localObject3);
      }
      label283:
      localObject1 = null;
    }
  }
  
  protected AnnotatedMethod _constructCreatorMethod(Method paramMethod)
  {
    if (this._annotationIntrospector == null) {
      return new AnnotatedMethod(paramMethod, _emptyAnnotationMap(), _emptyAnnotationMaps(paramMethod.getParameterTypes().length));
    }
    return new AnnotatedMethod(paramMethod, _collectRelevantAnnotations(paramMethod.getDeclaredAnnotations()), _collectRelevantAnnotations(paramMethod.getParameterAnnotations()));
  }
  
  protected AnnotatedField _constructField(Field paramField)
  {
    if (this._annotationIntrospector == null) {
      return new AnnotatedField(paramField, _emptyAnnotationMap());
    }
    return new AnnotatedField(paramField, _collectRelevantAnnotations(paramField.getDeclaredAnnotations()));
  }
  
  protected AnnotatedMethod _constructMethod(Method paramMethod)
  {
    if (this._annotationIntrospector == null) {
      return new AnnotatedMethod(paramMethod, _emptyAnnotationMap(), null);
    }
    return new AnnotatedMethod(paramMethod, _collectRelevantAnnotations(paramMethod.getDeclaredAnnotations()), null);
  }
  
  protected boolean _isIncludableMethod(Method paramMethod, MethodFilter paramMethodFilter)
  {
    if ((paramMethodFilter != null) && (!paramMethodFilter.includeMethod(paramMethod))) {}
    while ((paramMethod.isSynthetic()) || (paramMethod.isBridge())) {
      return false;
    }
    return true;
  }
  
  public Iterable fields()
  {
    if (this._fields == null) {
      return Collections.emptyList();
    }
    return this._fields;
  }
  
  public AnnotatedMethod findMethod(String paramString, Class[] paramArrayOfClass)
  {
    return this._memberMethods.find(paramString, paramArrayOfClass);
  }
  
  protected AnnotationMap getAllAnnotations()
  {
    return this._classAnnotations;
  }
  
  public Class getAnnotated()
  {
    return this._class;
  }
  
  public Annotation getAnnotation(Class paramClass)
  {
    if (this._classAnnotations == null) {
      return null;
    }
    return this._classAnnotations.get(paramClass);
  }
  
  public Annotations getAnnotations()
  {
    return this._classAnnotations;
  }
  
  public List getConstructors()
  {
    if (this._constructors == null) {
      return Collections.emptyList();
    }
    return this._constructors;
  }
  
  public AnnotatedConstructor getDefaultConstructor()
  {
    return this._defaultConstructor;
  }
  
  public int getFieldCount()
  {
    if (this._fields == null) {
      return 0;
    }
    return this._fields.size();
  }
  
  public Type getGenericType()
  {
    return this._class;
  }
  
  public int getMemberMethodCount()
  {
    return this._memberMethods.size();
  }
  
  public int getModifiers()
  {
    return this._class.getModifiers();
  }
  
  public String getName()
  {
    return this._class.getName();
  }
  
  public Class getRawType()
  {
    return this._class;
  }
  
  public List getStaticMethods()
  {
    if (this._creatorMethods == null) {
      return Collections.emptyList();
    }
    return this._creatorMethods;
  }
  
  public boolean hasAnnotations()
  {
    return this._classAnnotations.size() > 0;
  }
  
  public Iterable memberMethods()
  {
    return this._memberMethods;
  }
  
  public void resolveClassAnnotations()
  {
    this._classAnnotations = new AnnotationMap();
    if (this._annotationIntrospector == null) {
      return;
    }
    if (this._primaryMixIn != null) {
      _addClassMixIns(this._classAnnotations, this._class, this._primaryMixIn);
    }
    Object localObject1 = this._class.getDeclaredAnnotations();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (this._annotationIntrospector.isHandled((Annotation)localObject2)) {
        this._classAnnotations.addIfNotPresent((Annotation)localObject2);
      }
      i += 1;
    }
    localObject1 = this._superTypes.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Class)((Iterator)localObject1).next();
      _addClassMixIns(this._classAnnotations, (Class)localObject2);
      localObject2 = ((Class)localObject2).getDeclaredAnnotations();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        Annotation localAnnotation = localObject2[i];
        if (this._annotationIntrospector.isHandled(localAnnotation)) {
          this._classAnnotations.addIfNotPresent(localAnnotation);
        }
        i += 1;
      }
    }
    _addClassMixIns(this._classAnnotations, Object.class);
  }
  
  public void resolveCreators(boolean paramBoolean)
  {
    this._constructors = null;
    Object localObject = this._class.getDeclaredConstructors();
    int j = localObject.length;
    int i = 0;
    Constructor localConstructor;
    if (i < j)
    {
      localConstructor = localObject[i];
      if (localConstructor.getParameterTypes().length == 0) {
        this._defaultConstructor = _constructConstructor(localConstructor, true);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramBoolean)
        {
          if (this._constructors == null) {
            this._constructors = new ArrayList(Math.max(10, localObject.length));
          }
          this._constructors.add(_constructConstructor(localConstructor, false));
        }
      }
    }
    if ((this._primaryMixIn != null) && ((this._defaultConstructor != null) || (this._constructors != null))) {
      _addConstructorMixIns(this._primaryMixIn);
    }
    if (this._annotationIntrospector != null)
    {
      if ((this._defaultConstructor != null) && (this._annotationIntrospector.isIgnorableConstructor(this._defaultConstructor))) {
        this._defaultConstructor = null;
      }
      if (this._constructors != null) {
        i = this._constructors.size();
      }
    }
    for (;;)
    {
      i -= 1;
      if (i >= 0)
      {
        if (this._annotationIntrospector.isIgnorableConstructor((AnnotatedConstructor)this._constructors.get(i))) {
          this._constructors.remove(i);
        }
      }
      else
      {
        this._creatorMethods = null;
        if (paramBoolean)
        {
          localObject = this._class.getDeclaredMethods();
          j = localObject.length;
          i = 0;
          if (i < j)
          {
            localConstructor = localObject[i];
            if (!Modifier.isStatic(localConstructor.getModifiers())) {}
            for (;;)
            {
              i += 1;
              break;
              if (localConstructor.getParameterTypes().length >= 1)
              {
                if (this._creatorMethods == null) {
                  this._creatorMethods = new ArrayList(8);
                }
                this._creatorMethods.add(_constructCreatorMethod(localConstructor));
              }
            }
          }
          if ((this._primaryMixIn != null) && (this._creatorMethods != null)) {
            _addFactoryMixIns(this._primaryMixIn);
          }
          if ((this._annotationIntrospector != null) && (this._creatorMethods != null)) {
            i = this._creatorMethods.size();
          }
        }
        for (;;)
        {
          i -= 1;
          if (i >= 0)
          {
            if (this._annotationIntrospector.isIgnorableMethod((AnnotatedMethod)this._creatorMethods.get(i))) {
              this._creatorMethods.remove(i);
            }
          }
          else {
            return;
          }
        }
      }
    }
  }
  
  public void resolveFields()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    _addFields(localLinkedHashMap, this._class);
    if (localLinkedHashMap.isEmpty())
    {
      this._fields = Collections.emptyList();
      return;
    }
    this._fields = new ArrayList(localLinkedHashMap.size());
    this._fields.addAll(localLinkedHashMap.values());
  }
  
  @Deprecated
  public void resolveFields(boolean paramBoolean)
  {
    resolveFields();
  }
  
  public void resolveMemberMethods(MethodFilter paramMethodFilter)
  {
    this._memberMethods = new AnnotatedMethodMap();
    Object localObject2 = new AnnotatedMethodMap();
    _addMemberMethods(this._class, paramMethodFilter, this._memberMethods, this._primaryMixIn, (AnnotatedMethodMap)localObject2);
    Iterator localIterator = this._superTypes.iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (this._mixInResolver == null) {}
      for (localObject1 = null;; localObject1 = this._mixInResolver.findMixInClassFor(localClass))
      {
        _addMemberMethods(localClass, paramMethodFilter, this._memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
        break;
      }
    }
    if (this._mixInResolver != null)
    {
      localObject1 = this._mixInResolver.findMixInClassFor(Object.class);
      if (localObject1 != null) {
        _addMethodMixIns(paramMethodFilter, this._memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
      }
    }
    if ((this._annotationIntrospector != null) && (!((AnnotatedMethodMap)localObject2).isEmpty()))
    {
      paramMethodFilter = ((AnnotatedMethodMap)localObject2).iterator();
      while (paramMethodFilter.hasNext())
      {
        localObject1 = (AnnotatedMethod)paramMethodFilter.next();
        try
        {
          localObject2 = Object.class.getDeclaredMethod(((AnnotatedMethod)localObject1).getName(), ((AnnotatedMethod)localObject1).getParameterClasses());
          if (localObject2 != null)
          {
            localObject2 = _constructMethod((Method)localObject2);
            _addMixOvers(((AnnotatedMethod)localObject1).getAnnotated(), (AnnotatedMethod)localObject2, false);
            this._memberMethods.add((AnnotatedMethod)localObject2);
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  @Deprecated
  public void resolveMemberMethods(MethodFilter paramMethodFilter, boolean paramBoolean)
  {
    resolveMemberMethods(paramMethodFilter);
  }
  
  public String toString()
  {
    return "[AnnotedClass " + this._class.getName() + "]";
  }
  
  public AnnotatedClass withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedClass(this._class, this._superTypes, this._annotationIntrospector, this._mixInResolver, paramAnnotationMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/AnnotatedClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */