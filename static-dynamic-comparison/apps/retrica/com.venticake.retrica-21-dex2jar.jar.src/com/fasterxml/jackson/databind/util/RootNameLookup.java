package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

public class RootNameLookup
  implements Serializable
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
    //   2: new 29	com/fasterxml/jackson/databind/type/ClassKey
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 32	com/fasterxml/jackson/databind/type/ClassKey:<init>	(Ljava/lang/Class;)V
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 34	com/fasterxml/jackson/databind/util/RootNameLookup:_rootNames	Lcom/fasterxml/jackson/databind/util/LRUMap;
    //   16: ifnonnull +77 -> 93
    //   19: aload_0
    //   20: new 36	com/fasterxml/jackson/databind/util/LRUMap
    //   23: dup
    //   24: bipush 20
    //   26: sipush 200
    //   29: invokespecial 39	com/fasterxml/jackson/databind/util/LRUMap:<init>	(II)V
    //   32: putfield 34	com/fasterxml/jackson/databind/util/RootNameLookup:_rootNames	Lcom/fasterxml/jackson/databind/util/LRUMap;
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 45	com/fasterxml/jackson/databind/cfg/MapperConfig:introspectClassAnnotations	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/BeanDescription;
    //   40: astore_3
    //   41: aload_2
    //   42: invokevirtual 49	com/fasterxml/jackson/databind/cfg/MapperConfig:getAnnotationIntrospector	()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    //   45: aload_3
    //   46: invokevirtual 55	com/fasterxml/jackson/databind/BeanDescription:getClassInfo	()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    //   49: invokevirtual 60	com/fasterxml/jackson/databind/AnnotationIntrospector:findRootName	(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;)Lcom/fasterxml/jackson/databind/PropertyName;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +10 -> 64
    //   57: aload_2
    //   58: invokevirtual 66	com/fasterxml/jackson/databind/PropertyName:hasSimpleName	()Z
    //   61: ifne +54 -> 115
    //   64: aload_1
    //   65: invokevirtual 72	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   68: astore_1
    //   69: new 74	com/fasterxml/jackson/core/io/SerializedString
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 77	com/fasterxml/jackson/core/io/SerializedString:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 34	com/fasterxml/jackson/databind/util/RootNameLookup:_rootNames	Lcom/fasterxml/jackson/databind/util/LRUMap;
    //   82: aload 4
    //   84: aload_1
    //   85: invokevirtual 81	com/fasterxml/jackson/databind/util/LRUMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: areturn
    //   93: aload_0
    //   94: getfield 34	com/fasterxml/jackson/databind/util/RootNameLookup:_rootNames	Lcom/fasterxml/jackson/databind/util/LRUMap;
    //   97: aload 4
    //   99: invokevirtual 85	com/fasterxml/jackson/databind/util/LRUMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 74	com/fasterxml/jackson/core/io/SerializedString
    //   105: astore_3
    //   106: aload_3
    //   107: ifnull -72 -> 35
    //   110: aload_3
    //   111: astore_1
    //   112: goto -23 -> 89
    //   115: aload_2
    //   116: invokevirtual 86	com/fasterxml/jackson/databind/PropertyName:getSimpleName	()Ljava/lang/String;
    //   119: astore_1
    //   120: goto -51 -> 69
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	RootNameLookup
    //   0	128	1	paramClass	Class<?>
    //   0	128	2	paramMapperConfig	MapperConfig<?>
    //   40	71	3	localObject	Object
    //   10	88	4	localClassKey	ClassKey
    // Exception table:
    //   from	to	target	type
    //   2	35	123	finally
    //   35	53	123	finally
    //   57	64	123	finally
    //   64	69	123	finally
    //   69	89	123	finally
    //   93	106	123	finally
    //   115	120	123	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/RootNameLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */