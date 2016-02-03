package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Constructor;
import java.util.Collection;

@Deprecated
public class CollectionDeserializer
  extends com.flurry.org.codehaus.jackson.map.deser.std.CollectionDeserializer
{
  protected CollectionDeserializer(CollectionDeserializer paramCollectionDeserializer)
  {
    super(paramCollectionDeserializer);
  }
  
  public CollectionDeserializer(JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer, ValueInstantiator paramValueInstantiator)
  {
    super(paramJavaType, paramJsonDeserializer, paramTypeDeserializer, paramValueInstantiator);
  }
  
  @Deprecated
  public CollectionDeserializer(JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer, Constructor<Collection<Object>> paramConstructor)
  {
    super(paramJavaType, paramJsonDeserializer, paramTypeDeserializer, paramConstructor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/CollectionDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */