package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class AnnotatedClass
  extends Annotated
{
  private static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final Class<?> _class;
  protected AnnotationMap _classAnnotations;
  protected List<AnnotatedConstructor> _constructors;
  protected List<AnnotatedMethod> _creatorMethods;
  protected boolean _creatorsResolved = false;
  protected AnnotatedConstructor _defaultConstructor;
  protected List<AnnotatedField> _fields;
  protected AnnotatedMethodMap _memberMethods;
  protected final ClassIntrospector.MixInResolver _mixInResolver;
  protected final Class<?> _primaryMixIn;
  protected final List<Class<?>> _superTypes;
  
  private AnnotatedClass(Class<?> paramClass, List<Class<?>> paramList, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver, AnnotationMap paramAnnotationMap)
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
  
  private void _addAnnotationsIfNotPresent(AnnotatedMember paramAnnotatedMember, Annotation[] paramArrayOfAnnotation)
  {
    if (paramArrayOfAnnotation != null)
    {
      int j = paramArrayOfAnnotation.length;
      Object localObject1 = null;
      int i = 0;
      if (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        if (_isAnnotationBundle(localAnnotation))
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new LinkedList();
          }
          ((List)localObject2).add(localAnnotation.annotationType().getDeclaredAnnotations());
          localObject1 = localObject2;
        }
        for (;;)
        {
          i += 1;
          break;
          paramAnnotatedMember.addIfNotPresent(localAnnotation);
        }
      }
      if (localObject1 != null)
      {
        paramArrayOfAnnotation = ((List)localObject1).iterator();
        while (paramArrayOfAnnotation.hasNext()) {
          _addAnnotationsIfNotPresent(paramAnnotatedMember, (Annotation[])paramArrayOfAnnotation.next());
        }
      }
    }
  }
  
  private void _addAnnotationsIfNotPresent(AnnotationMap paramAnnotationMap, Annotation[] paramArrayOfAnnotation)
  {
    if (paramArrayOfAnnotation != null)
    {
      int j = paramArrayOfAnnotation.length;
      Object localObject1 = null;
      int i = 0;
      if (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        if (_isAnnotationBundle(localAnnotation))
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new LinkedList();
          }
          ((List)localObject2).add(localAnnotation.annotationType().getDeclaredAnnotations());
          localObject1 = localObject2;
        }
        for (;;)
        {
          i += 1;
          break;
          paramAnnotationMap.addIfNotPresent(localAnnotation);
        }
      }
      if (localObject1 != null)
      {
        paramArrayOfAnnotation = ((List)localObject1).iterator();
        while (paramArrayOfAnnotation.hasNext()) {
          _addAnnotationsIfNotPresent(paramAnnotationMap, (Annotation[])paramArrayOfAnnotation.next());
        }
      }
    }
  }
  
  private void _addOrOverrideAnnotations(AnnotatedMember paramAnnotatedMember, Annotation[] paramArrayOfAnnotation)
  {
    if (paramArrayOfAnnotation != null)
    {
      int j = paramArrayOfAnnotation.length;
      Object localObject1 = null;
      int i = 0;
      if (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        if (_isAnnotationBundle(localAnnotation))
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new LinkedList();
          }
          ((List)localObject2).add(localAnnotation.annotationType().getDeclaredAnnotations());
          localObject1 = localObject2;
        }
        for (;;)
        {
          i += 1;
          break;
          paramAnnotatedMember.addOrOverride(localAnnotation);
        }
      }
      if (localObject1 != null)
      {
        paramArrayOfAnnotation = ((List)localObject1).iterator();
        while (paramArrayOfAnnotation.hasNext()) {
          _addOrOverrideAnnotations(paramAnnotatedMember, (Annotation[])paramArrayOfAnnotation.next());
        }
      }
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
  
  private final boolean _isAnnotationBundle(Annotation paramAnnotation)
  {
    return (this._annotationIntrospector != null) && (this._annotationIntrospector.isAnnotationBundle(paramAnnotation));
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
  
  public static AnnotatedClass construct(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return new AnnotatedClass(paramClass, ClassUtil.findSuperTypes(paramClass, null), paramAnnotationIntrospector, paramMixInResolver, null);
  }
  
  public static AnnotatedClass constructWithoutSuperTypes(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return new AnnotatedClass(paramClass, Collections.emptyList(), paramAnnotationIntrospector, paramMixInResolver, null);
  }
  
  private void resolveClassAnnotations()
  {
    this._classAnnotations = new AnnotationMap();
    if (this._annotationIntrospector != null)
    {
      if (this._primaryMixIn != null) {
        _addClassMixIns(this._classAnnotations, this._class, this._primaryMixIn);
      }
      _addAnnotationsIfNotPresent(this._classAnnotations, this._class.getDeclaredAnnotations());
      Iterator localIterator = this._superTypes.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        _addClassMixIns(this._classAnnotations, localClass);
        _addAnnotationsIfNotPresent(this._classAnnotations, localClass.getDeclaredAnnotations());
      }
      _addClassMixIns(this._classAnnotations, Object.class);
    }
  }
  
  private void resolveCreators()
  {
    int j = 0;
    Object localObject3 = this._class.getDeclaredConstructors();
    int k = localObject3.length;
    int i = 0;
    Object localObject1 = null;
    Constructor localConstructor;
    Object localObject2;
    if (i < k)
    {
      localConstructor = localObject3[i];
      if (localConstructor.getParameterTypes().length == 0) {
        this._defaultConstructor = _constructConstructor(localConstructor, true);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(Math.max(10, localObject3.length));
        }
        ((List)localObject2).add(_constructConstructor(localConstructor, false));
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null)
    {
      this._constructors = Collections.emptyList();
      if ((this._primaryMixIn != null) && ((this._defaultConstructor != null) || (!this._constructors.isEmpty()))) {
        _addConstructorMixIns(this._primaryMixIn);
      }
      if (this._annotationIntrospector == null) {
        break label256;
      }
      if ((this._defaultConstructor != null) && (this._annotationIntrospector.hasIgnoreMarker(this._defaultConstructor))) {
        this._defaultConstructor = null;
      }
      if (this._constructors == null) {
        break label256;
      }
      i = this._constructors.size();
    }
    label256:
    label448:
    for (;;)
    {
      i -= 1;
      if (i >= 0)
      {
        if (!this._annotationIntrospector.hasIgnoreMarker((AnnotatedMember)this._constructors.get(i))) {
          break label448;
        }
        this._constructors.remove(i);
        continue;
        this._constructors = ((List)localObject1);
        break;
      }
      localObject3 = this._class.getDeclaredMethods();
      k = localObject3.length;
      localObject1 = null;
      i = j;
      if (i < k)
      {
        localConstructor = localObject3[i];
        if (!Modifier.isStatic(localConstructor.getModifiers())) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList(8);
          }
          ((List)localObject2).add(_constructCreatorMethod(localConstructor));
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null) {
        this._creatorMethods = Collections.emptyList();
      }
      do
      {
        this._creatorsResolved = true;
        return;
        this._creatorMethods = ((List)localObject1);
        if (this._primaryMixIn != null) {
          _addFactoryMixIns(this._primaryMixIn);
        }
      } while (this._annotationIntrospector == null);
      i = this._creatorMethods.size();
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          break;
        }
        if (this._annotationIntrospector.hasIgnoreMarker((AnnotatedMember)this._creatorMethods.get(i))) {
          this._creatorMethods.remove(i);
        }
      }
    }
  }
  
  private void resolveFields()
  {
    Map localMap = _findFields(this._class, null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      this._fields = Collections.emptyList();
      return;
    }
    this._fields = new ArrayList(localMap.size());
    this._fields.addAll(localMap.values());
  }
  
  private void resolveMemberMethods()
  {
    this._memberMethods = new AnnotatedMethodMap();
    Object localObject2 = new AnnotatedMethodMap();
    _addMemberMethods(this._class, this._memberMethods, this._primaryMixIn, (AnnotatedMethodMap)localObject2);
    Object localObject3 = this._superTypes.iterator();
    Object localObject1;
    if (((Iterator)localObject3).hasNext())
    {
      Class localClass = (Class)((Iterator)localObject3).next();
      if (this._mixInResolver == null) {}
      for (localObject1 = null;; localObject1 = this._mixInResolver.findMixInClassFor(localClass))
      {
        _addMemberMethods(localClass, this._memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
        break;
      }
    }
    if (this._mixInResolver != null)
    {
      localObject1 = this._mixInResolver.findMixInClassFor(Object.class);
      if (localObject1 != null) {
        _addMethodMixIns(this._class, this._memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
      }
    }
    if ((this._annotationIntrospector != null) && (!((AnnotatedMethodMap)localObject2).isEmpty()))
    {
      localObject1 = ((AnnotatedMethodMap)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AnnotatedMethod)((Iterator)localObject1).next();
        try
        {
          localObject3 = Object.class.getDeclaredMethod(((AnnotatedMethod)localObject2).getName(), ((AnnotatedMethod)localObject2).getRawParameterTypes());
          if (localObject3 != null)
          {
            localObject3 = _constructMethod((Method)localObject3);
            _addMixOvers(((AnnotatedMethod)localObject2).getAnnotated(), (AnnotatedMethod)localObject3, false);
            this._memberMethods.add((AnnotatedMethod)localObject3);
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class<?> paramClass)
  {
    if (this._mixInResolver != null) {
      _addClassMixIns(paramAnnotationMap, paramClass, this._mixInResolver.findMixInClassFor(paramClass));
    }
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == null) {}
    for (;;)
    {
      return;
      _addAnnotationsIfNotPresent(paramAnnotationMap, paramClass2.getDeclaredAnnotations());
      paramClass1 = ClassUtil.findSuperTypes(paramClass2, paramClass1).iterator();
      while (paramClass1.hasNext()) {
        _addAnnotationsIfNotPresent(paramAnnotationMap, ((Class)paramClass1.next()).getDeclaredAnnotations());
      }
    }
  }
  
  protected void _addConstructorMixIns(Class<?> paramClass)
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
      paramClass = (Class<?>)localObject;
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
          paramClass = (Class<?>)localObject;
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
  
  protected void _addFactoryMixIns(Class<?> paramClass)
  {
    Object localObject = null;
    int k = this._creatorMethods.size();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int m = arrayOfMethod.length;
    int i = 0;
    paramClass = (Class<?>)localObject;
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
      paramClass = (Class<?>)localObject;
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
            paramClass = (Class<?>)localObject;
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
  
  protected void _addFieldMixIns(Class<?> paramClass1, Class<?> paramClass2, Map<String, AnnotatedField> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramClass2);
    ClassUtil.findSuperTypes(paramClass2, paramClass1, localArrayList);
    paramClass1 = localArrayList.iterator();
    if (paramClass1.hasNext())
    {
      paramClass2 = ((Class)paramClass1.next()).getDeclaredFields();
      int j = paramClass2.length;
      int i = 0;
      label63:
      if (i < j)
      {
        localArrayList = paramClass2[i];
        if (_isIncludableField(localArrayList)) {
          break label94;
        }
      }
      for (;;)
      {
        i += 1;
        break label63;
        break;
        label94:
        AnnotatedField localAnnotatedField = (AnnotatedField)paramMap.get(localArrayList.getName());
        if (localAnnotatedField != null) {
          _addOrOverrideAnnotations(localAnnotatedField, localArrayList.getDeclaredAnnotations());
        }
      }
    }
  }
  
  protected void _addMemberMethods(Class<?> paramClass1, AnnotatedMethodMap paramAnnotatedMethodMap1, Class<?> paramClass2, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    if (paramClass2 != null) {
      _addMethodMixIns(paramClass1, paramAnnotatedMethodMap1, paramClass2, paramAnnotatedMethodMap2);
    }
    if (paramClass1 == null) {
      return;
    }
    paramClass1 = paramClass1.getDeclaredMethods();
    int j = paramClass1.length;
    int i = 0;
    label30:
    if (i < j)
    {
      paramClass2 = paramClass1[i];
      if (_isIncludableMemberMethod(paramClass2)) {
        break label59;
      }
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      label59:
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
  
  protected void _addMethodMixIns(Class<?> paramClass1, AnnotatedMethodMap paramAnnotatedMethodMap1, Class<?> paramClass2, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramClass2);
    ClassUtil.findSuperTypes(paramClass2, paramClass1, localArrayList);
    paramClass1 = localArrayList.iterator();
    if (paramClass1.hasNext())
    {
      paramClass2 = ((Class)paramClass1.next()).getDeclaredMethods();
      int j = paramClass2.length;
      int i = 0;
      label63:
      if (i < j)
      {
        localArrayList = paramClass2[i];
        if (_isIncludableMemberMethod(localArrayList)) {
          break label94;
        }
      }
      for (;;)
      {
        i += 1;
        break label63;
        break;
        label94:
        AnnotatedMethod localAnnotatedMethod = paramAnnotatedMethodMap1.find(localArrayList);
        if (localAnnotatedMethod != null) {
          _addMixUnders(localArrayList, localAnnotatedMethod);
        } else {
          paramAnnotatedMethodMap2.add(_constructMethod(localArrayList));
        }
      }
    }
  }
  
  protected void _addMixOvers(Constructor<?> paramConstructor, AnnotatedConstructor paramAnnotatedConstructor, boolean paramBoolean)
  {
    _addOrOverrideAnnotations(paramAnnotatedConstructor, paramConstructor.getDeclaredAnnotations());
    if (paramBoolean)
    {
      paramConstructor = paramConstructor.getParameterAnnotations();
      int k = paramConstructor.length;
      int i = 0;
      while (i < k)
      {
        Object localObject = paramConstructor[i];
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          paramAnnotatedConstructor.addOrOverrideParam(i, localObject[j]);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void _addMixOvers(Method paramMethod, AnnotatedMethod paramAnnotatedMethod, boolean paramBoolean)
  {
    _addOrOverrideAnnotations(paramAnnotatedMethod, paramMethod.getDeclaredAnnotations());
    if (paramBoolean)
    {
      paramMethod = paramMethod.getParameterAnnotations();
      int k = paramMethod.length;
      int i = 0;
      while (i < k)
      {
        Object localObject = paramMethod[i];
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          paramAnnotatedMethod.addOrOverrideParam(i, localObject[j]);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void _addMixUnders(Method paramMethod, AnnotatedMethod paramAnnotatedMethod)
  {
    _addAnnotationsIfNotPresent(paramAnnotatedMethod, paramMethod.getDeclaredAnnotations());
  }
  
  protected AnnotationMap _collectRelevantAnnotations(Annotation[] paramArrayOfAnnotation)
  {
    AnnotationMap localAnnotationMap = new AnnotationMap();
    _addAnnotationsIfNotPresent(localAnnotationMap, paramArrayOfAnnotation);
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
  
  protected AnnotatedConstructor _constructConstructor(Constructor<?> paramConstructor, boolean paramBoolean)
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
      if ((((Class)localObject1).isEnum()) && (i == localObject2.length + 2))
      {
        localObject1 = new Annotation[localObject2.length + 2][];
        System.arraycopy(localObject2, 0, localObject1, 2, localObject2.length);
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
        if ((((Class)localObject1).isMemberClass()) && (i == localObject2.length + 1))
        {
          localObject3 = new Annotation[localObject2.length + 1][];
          System.arraycopy(localObject2, 0, localObject3, 1, localObject2.length);
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
  
  protected Map<String, AnnotatedField> _findFields(Class<?> paramClass, Map<String, AnnotatedField> paramMap)
  {
    Class localClass = paramClass.getSuperclass();
    if (localClass != null)
    {
      paramMap = _findFields(localClass, paramMap);
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if (!_isIncludableField(localField)) {}
        for (;;)
        {
          i += 1;
          break;
          Object localObject = paramMap;
          if (paramMap == null) {
            localObject = new LinkedHashMap();
          }
          ((Map)localObject).put(localField.getName(), _constructField(localField));
          paramMap = (Map<String, AnnotatedField>)localObject;
        }
      }
      if (this._mixInResolver != null)
      {
        paramClass = this._mixInResolver.findMixInClassFor(paramClass);
        if (paramClass != null) {
          _addFieldMixIns(localClass, paramClass, paramMap);
        }
      }
      return paramMap;
    }
    return paramMap;
  }
  
  protected boolean _isIncludableMemberMethod(Method paramMethod)
  {
    if (Modifier.isStatic(paramMethod.getModifiers())) {}
    while ((paramMethod.isSynthetic()) || (paramMethod.isBridge()) || (paramMethod.getParameterTypes().length > 2)) {
      return false;
    }
    return true;
  }
  
  public Iterable<AnnotatedField> fields()
  {
    if (this._fields == null) {
      resolveFields();
    }
    return this._fields;
  }
  
  public AnnotatedMethod findMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (this._memberMethods == null) {
      resolveMemberMethods();
    }
    return this._memberMethods.find(paramString, paramArrayOfClass);
  }
  
  public Class<?> getAnnotated()
  {
    return this._class;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (this._classAnnotations == null) {
      resolveClassAnnotations();
    }
    return this._classAnnotations.get(paramClass);
  }
  
  public Annotations getAnnotations()
  {
    if (this._classAnnotations == null) {
      resolveClassAnnotations();
    }
    return this._classAnnotations;
  }
  
  public List<AnnotatedConstructor> getConstructors()
  {
    if (!this._creatorsResolved) {
      resolveCreators();
    }
    return this._constructors;
  }
  
  public AnnotatedConstructor getDefaultConstructor()
  {
    if (!this._creatorsResolved) {
      resolveCreators();
    }
    return this._defaultConstructor;
  }
  
  public Type getGenericType()
  {
    return this._class;
  }
  
  public String getName()
  {
    return this._class.getName();
  }
  
  public Class<?> getRawType()
  {
    return this._class;
  }
  
  public List<AnnotatedMethod> getStaticMethods()
  {
    if (!this._creatorsResolved) {
      resolveCreators();
    }
    return this._creatorMethods;
  }
  
  public boolean hasAnnotations()
  {
    if (this._classAnnotations == null) {
      resolveClassAnnotations();
    }
    return this._classAnnotations.size() > 0;
  }
  
  public Iterable<AnnotatedMethod> memberMethods()
  {
    if (this._memberMethods == null) {
      resolveMemberMethods();
    }
    return this._memberMethods;
  }
  
  public String toString()
  {
    return "[AnnotedClass " + this._class.getName() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/AnnotatedClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */