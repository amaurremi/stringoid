package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.Serializable;

public class DeserializerFactoryConfig
  implements Serializable
{
  protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
  protected static final Deserializers[] NO_DESERIALIZERS = new Deserializers[0];
  protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
  protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
  protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
  protected final AbstractTypeResolver[] _abstractTypeResolvers;
  protected final Deserializers[] _additionalDeserializers;
  protected final KeyDeserializers[] _additionalKeyDeserializers;
  protected final BeanDeserializerModifier[] _modifiers;
  protected final ValueInstantiators[] _valueInstantiators;
  
  public DeserializerFactoryConfig()
  {
    this(null, null, null, null, null);
  }
  
  protected DeserializerFactoryConfig(Deserializers[] paramArrayOfDeserializers, KeyDeserializers[] paramArrayOfKeyDeserializers, BeanDeserializerModifier[] paramArrayOfBeanDeserializerModifier, AbstractTypeResolver[] paramArrayOfAbstractTypeResolver, ValueInstantiators[] paramArrayOfValueInstantiators)
  {
    Deserializers[] arrayOfDeserializers = paramArrayOfDeserializers;
    if (paramArrayOfDeserializers == null) {
      arrayOfDeserializers = NO_DESERIALIZERS;
    }
    this._additionalDeserializers = arrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfKeyDeserializers;
    if (paramArrayOfKeyDeserializers == null) {
      paramArrayOfDeserializers = NO_KEY_DESERIALIZERS;
    }
    this._additionalKeyDeserializers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfBeanDeserializerModifier;
    if (paramArrayOfBeanDeserializerModifier == null) {
      paramArrayOfDeserializers = NO_MODIFIERS;
    }
    this._modifiers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfAbstractTypeResolver;
    if (paramArrayOfAbstractTypeResolver == null) {
      paramArrayOfDeserializers = NO_ABSTRACT_TYPE_RESOLVERS;
    }
    this._abstractTypeResolvers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfValueInstantiators;
    if (paramArrayOfValueInstantiators == null) {
      paramArrayOfDeserializers = NO_VALUE_INSTANTIATORS;
    }
    this._valueInstantiators = paramArrayOfDeserializers;
  }
  
  public Iterable<AbstractTypeResolver> abstractTypeResolvers()
  {
    return ArrayBuilders.arrayAsIterable(this._abstractTypeResolvers);
  }
  
  public Iterable<BeanDeserializerModifier> deserializerModifiers()
  {
    return ArrayBuilders.arrayAsIterable(this._modifiers);
  }
  
  public Iterable<Deserializers> deserializers()
  {
    return ArrayBuilders.arrayAsIterable(this._additionalDeserializers);
  }
  
  public boolean hasAbstractTypeResolvers()
  {
    return this._abstractTypeResolvers.length > 0;
  }
  
  public boolean hasDeserializerModifiers()
  {
    return this._modifiers.length > 0;
  }
  
  public boolean hasKeyDeserializers()
  {
    return this._additionalKeyDeserializers.length > 0;
  }
  
  public boolean hasValueInstantiators()
  {
    return this._valueInstantiators.length > 0;
  }
  
  public Iterable<KeyDeserializers> keyDeserializers()
  {
    return ArrayBuilders.arrayAsIterable(this._additionalKeyDeserializers);
  }
  
  public Iterable<ValueInstantiators> valueInstantiators()
  {
    return ArrayBuilders.arrayAsIterable(this._valueInstantiators);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */