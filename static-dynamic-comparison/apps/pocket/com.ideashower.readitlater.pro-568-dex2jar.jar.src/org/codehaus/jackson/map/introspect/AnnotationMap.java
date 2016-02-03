package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.codehaus.jackson.map.util.Annotations;

public final class AnnotationMap
  implements Annotations
{
  protected HashMap _annotations;
  
  public AnnotationMap() {}
  
  private AnnotationMap(HashMap paramHashMap)
  {
    this._annotations = paramHashMap;
  }
  
  public static AnnotationMap merge(AnnotationMap paramAnnotationMap1, AnnotationMap paramAnnotationMap2)
  {
    if ((paramAnnotationMap1 == null) || (paramAnnotationMap1._annotations == null) || (paramAnnotationMap1._annotations.isEmpty())) {
      localObject = paramAnnotationMap2;
    }
    do
    {
      do
      {
        do
        {
          return (AnnotationMap)localObject;
          localObject = paramAnnotationMap1;
        } while (paramAnnotationMap2 == null);
        localObject = paramAnnotationMap1;
      } while (paramAnnotationMap2._annotations == null);
      localObject = paramAnnotationMap1;
    } while (paramAnnotationMap2._annotations.isEmpty());
    Object localObject = new HashMap();
    paramAnnotationMap2 = paramAnnotationMap2._annotations.values().iterator();
    while (paramAnnotationMap2.hasNext())
    {
      Annotation localAnnotation = (Annotation)paramAnnotationMap2.next();
      ((HashMap)localObject).put(localAnnotation.annotationType(), localAnnotation);
    }
    paramAnnotationMap1 = paramAnnotationMap1._annotations.values().iterator();
    while (paramAnnotationMap1.hasNext())
    {
      paramAnnotationMap2 = (Annotation)paramAnnotationMap1.next();
      ((HashMap)localObject).put(paramAnnotationMap2.annotationType(), paramAnnotationMap2);
    }
    return new AnnotationMap((HashMap)localObject);
  }
  
  protected final void _add(Annotation paramAnnotation)
  {
    if (this._annotations == null) {
      this._annotations = new HashMap();
    }
    this._annotations.put(paramAnnotation.annotationType(), paramAnnotation);
  }
  
  public void add(Annotation paramAnnotation)
  {
    _add(paramAnnotation);
  }
  
  public void addIfNotPresent(Annotation paramAnnotation)
  {
    if ((this._annotations == null) || (!this._annotations.containsKey(paramAnnotation.annotationType()))) {
      _add(paramAnnotation);
    }
  }
  
  public Annotation get(Class paramClass)
  {
    if (this._annotations == null) {
      return null;
    }
    return (Annotation)this._annotations.get(paramClass);
  }
  
  public int size()
  {
    if (this._annotations == null) {
      return 0;
    }
    return this._annotations.size();
  }
  
  public String toString()
  {
    if (this._annotations == null) {
      return "[null]";
    }
    return this._annotations.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/AnnotationMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */