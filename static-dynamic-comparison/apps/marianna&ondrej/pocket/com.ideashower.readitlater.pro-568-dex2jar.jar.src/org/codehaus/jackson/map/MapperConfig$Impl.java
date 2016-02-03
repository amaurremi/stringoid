package org.codehaus.jackson.map;

import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.type.TypeFactory;

abstract class MapperConfig$Impl
  extends MapperConfig
{
  protected int _featureFlags;
  
  protected MapperConfig$Impl(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker paramVisibilityChecker, SubtypeResolver paramSubtypeResolver, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, HandlerInstantiator paramHandlerInstantiator, int paramInt)
  {
    super(paramClassIntrospector, paramAnnotationIntrospector, paramVisibilityChecker, paramSubtypeResolver, paramPropertyNamingStrategy, paramTypeFactory, paramHandlerInstantiator);
    this._featureFlags = paramInt;
  }
  
  protected MapperConfig$Impl(Impl paramImpl)
  {
    super(paramImpl);
    this._featureFlags = paramImpl._featureFlags;
  }
  
  protected MapperConfig$Impl(Impl paramImpl, int paramInt)
  {
    super(paramImpl);
    this._featureFlags = paramInt;
  }
  
  protected MapperConfig$Impl(Impl paramImpl, MapperConfig.Base paramBase, SubtypeResolver paramSubtypeResolver)
  {
    super(paramImpl, paramBase, paramSubtypeResolver);
    this._featureFlags = paramImpl._featureFlags;
  }
  
  static int collectFeatureDefaults(Class paramClass)
  {
    paramClass = (Enum[])paramClass.getEnumConstants();
    int k = paramClass.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject = paramClass[j];
      if (!((MapperConfig.ConfigFeature)localObject).enabledByDefault()) {
        break label60;
      }
      i = ((MapperConfig.ConfigFeature)localObject).getMask() | i;
    }
    label60:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @Deprecated
  public void disable(MapperConfig.ConfigFeature paramConfigFeature)
  {
    this._featureFlags &= (paramConfigFeature.getMask() ^ 0xFFFFFFFF);
  }
  
  @Deprecated
  public void enable(MapperConfig.ConfigFeature paramConfigFeature)
  {
    this._featureFlags |= paramConfigFeature.getMask();
  }
  
  public boolean isEnabled(MapperConfig.ConfigFeature paramConfigFeature)
  {
    return (this._featureFlags & paramConfigFeature.getMask()) != 0;
  }
  
  @Deprecated
  public void set(MapperConfig.ConfigFeature paramConfigFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      enable(paramConfigFeature);
      return;
    }
    disable(paramConfigFeature);
  }
  
  public abstract Impl with(MapperConfig.ConfigFeature... paramVarArgs);
  
  public abstract Impl without(MapperConfig.ConfigFeature... paramVarArgs);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/MapperConfig$Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */