package com.flurry.org.codehaus.jackson.map.util;

import com.flurry.org.codehaus.jackson.io.SerializedString;
import com.flurry.org.codehaus.jackson.map.MapperConfig;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import com.flurry.org.codehaus.jackson.type.JavaType;

public class RootNameLookup
{
  protected LRUMap<ClassKey, SerializedString> _rootNames;
  
  public SerializedString findRootName(JavaType paramJavaType, MapperConfig<?> paramMapperConfig)
  {
    return findRootName(paramJavaType.getRawClass(), paramMapperConfig);
  }
  
  /* Error */
  public SerializedString findRootName(Class<?> paramClass, MapperConfig<?> paramMapperConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 27	com/flurry/org/codehaus/jackson/map/type/ClassKey
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 30	com/flurry/org/codehaus/jackson/map/type/ClassKey:<init>	(Ljava/lang/Class;)V
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 32	com/flurry/org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lcom/flurry/org/codehaus/jackson/map/util/LRUMap;
    //   16: ifnonnull +75 -> 91
    //   19: aload_0
    //   20: new 34	com/flurry/org/codehaus/jackson/map/util/LRUMap
    //   23: dup
    //   24: bipush 20
    //   26: sipush 200
    //   29: invokespecial 37	com/flurry/org/codehaus/jackson/map/util/LRUMap:<init>	(II)V
    //   32: putfield 32	com/flurry/org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lcom/flurry/org/codehaus/jackson/map/util/LRUMap;
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 43	com/flurry/org/codehaus/jackson/map/MapperConfig:introspectClassAnnotations	(Ljava/lang/Class;)Lcom/flurry/org/codehaus/jackson/map/BeanDescription;
    //   40: checkcast 45	com/flurry/org/codehaus/jackson/map/introspect/BasicBeanDescription
    //   43: astore_3
    //   44: aload_2
    //   45: invokevirtual 49	com/flurry/org/codehaus/jackson/map/MapperConfig:getAnnotationIntrospector	()Lcom/flurry/org/codehaus/jackson/map/AnnotationIntrospector;
    //   48: aload_3
    //   49: invokevirtual 53	com/flurry/org/codehaus/jackson/map/introspect/BasicBeanDescription:getClassInfo	()Lcom/flurry/org/codehaus/jackson/map/introspect/AnnotatedClass;
    //   52: invokevirtual 58	com/flurry/org/codehaus/jackson/map/AnnotationIntrospector:findRootName	(Lcom/flurry/org/codehaus/jackson/map/introspect/AnnotatedClass;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnonnull +8 -> 67
    //   62: aload_1
    //   63: invokevirtual 64	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   66: astore_2
    //   67: new 66	com/flurry/org/codehaus/jackson/io/SerializedString
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 69	com/flurry/org/codehaus/jackson/io/SerializedString:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 32	com/flurry/org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lcom/flurry/org/codehaus/jackson/map/util/LRUMap;
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 73	com/flurry/org/codehaus/jackson/map/util/LRUMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: areturn
    //   91: aload_0
    //   92: getfield 32	com/flurry/org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lcom/flurry/org/codehaus/jackson/map/util/LRUMap;
    //   95: aload 4
    //   97: invokevirtual 77	com/flurry/org/codehaus/jackson/map/util/LRUMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 66	com/flurry/org/codehaus/jackson/io/SerializedString
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull -70 -> 35
    //   108: aload_3
    //   109: astore_1
    //   110: goto -23 -> 87
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	RootNameLookup
    //   0	118	1	paramClass	Class<?>
    //   0	118	2	paramMapperConfig	MapperConfig<?>
    //   43	66	3	localObject	Object
    //   10	86	4	localClassKey	ClassKey
    // Exception table:
    //   from	to	target	type
    //   2	35	113	finally
    //   35	56	113	finally
    //   62	67	113	finally
    //   67	87	113	finally
    //   91	104	113	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/RootNameLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */