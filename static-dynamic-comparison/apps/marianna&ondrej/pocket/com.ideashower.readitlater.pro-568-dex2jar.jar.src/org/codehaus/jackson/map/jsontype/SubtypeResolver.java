package org.codehaus.jackson.map.jsontype;

import java.util.Collection;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMember;

public abstract class SubtypeResolver
{
  public abstract Collection collectAndResolveSubtypes(AnnotatedClass paramAnnotatedClass, MapperConfig paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract Collection collectAndResolveSubtypes(AnnotatedMember paramAnnotatedMember, MapperConfig paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract void registerSubtypes(Class... paramVarArgs);
  
  public abstract void registerSubtypes(NamedType... paramVarArgs);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/SubtypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */