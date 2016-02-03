package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.HashSet;

@JacksonStdImpl
@Deprecated
public class MapSerializer
  extends com.flurry.org.codehaus.jackson.map.ser.std.MapSerializer
{
  protected MapSerializer()
  {
    this((HashSet)null, null, null, false, null, null, null, null);
  }
  
  @Deprecated
  protected MapSerializer(HashSet<String> paramHashSet, JavaType paramJavaType1, JavaType paramJavaType2, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer, BeanProperty paramBeanProperty)
  {
    super(paramHashSet, paramJavaType1, paramJavaType2, paramBoolean, paramTypeSerializer, paramJsonSerializer, null, paramBeanProperty);
  }
  
  protected MapSerializer(HashSet<String> paramHashSet, JavaType paramJavaType1, JavaType paramJavaType2, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer1, JsonSerializer<Object> paramJsonSerializer2, BeanProperty paramBeanProperty)
  {
    super(paramHashSet, paramJavaType1, paramJavaType2, paramBoolean, paramTypeSerializer, paramJsonSerializer1, paramJsonSerializer2, paramBeanProperty);
  }
  
  @Deprecated
  protected MapSerializer(HashSet<String> paramHashSet, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer)
  {
    super(paramHashSet, UNSPECIFIED_TYPE, paramJavaType, paramBoolean, paramTypeSerializer, null, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */