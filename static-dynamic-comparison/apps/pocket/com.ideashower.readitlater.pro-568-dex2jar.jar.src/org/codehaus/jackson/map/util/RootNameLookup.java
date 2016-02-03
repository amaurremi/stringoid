package org.codehaus.jackson.map.util;

import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class RootNameLookup
{
  protected LRUMap _rootNames;
  
  public SerializedString findRootName(Class paramClass, MapperConfig paramMapperConfig)
  {
    for (;;)
    {
      try
      {
        ClassKey localClassKey = new ClassKey(paramClass);
        Object localObject;
        if (this._rootNames == null)
        {
          this._rootNames = new LRUMap(20, 200);
          localObject = (BasicBeanDescription)paramMapperConfig.introspectClassAnnotations(paramClass);
          paramMapperConfig = paramMapperConfig.getAnnotationIntrospector().findRootName(((BasicBeanDescription)localObject).getClassInfo());
          if (paramMapperConfig == null)
          {
            paramClass = paramClass.getSimpleName();
            paramClass = new SerializedString(paramClass);
            this._rootNames.put(localClassKey, paramClass);
            return paramClass;
          }
        }
        else
        {
          localObject = (SerializedString)this._rootNames.get(localClassKey);
          if (localObject == null) {
            continue;
          }
          paramClass = (Class)localObject;
          continue;
        }
        paramClass = paramMapperConfig;
      }
      finally {}
    }
  }
  
  public SerializedString findRootName(JavaType paramJavaType, MapperConfig paramMapperConfig)
  {
    return findRootName(paramJavaType.getRawClass(), paramMapperConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/RootNameLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */