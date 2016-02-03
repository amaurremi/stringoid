package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.DeserializerFactory.Config;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.util.ArrayBuilders;

public class BeanDeserializerFactory$ConfigImpl
  extends DeserializerFactory.Config
{
  protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
  protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
  protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
  protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
  protected final AbstractTypeResolver[] _abstractTypeResolvers;
  protected final Deserializers[] _additionalDeserializers;
  protected final KeyDeserializers[] _additionalKeyDeserializers;
  protected final BeanDeserializerModifier[] _modifiers;
  protected final ValueInstantiators[] _valueInstantiators;
  
  public BeanDeserializerFactory$ConfigImpl()
  {
    this(null, null, null, null, null);
  }
  
  protected BeanDeserializerFactory$ConfigImpl(Deserializers[] paramArrayOfDeserializers, KeyDeserializers[] paramArrayOfKeyDeserializers, BeanDeserializerModifier[] paramArrayOfBeanDeserializerModifier, AbstractTypeResolver[] paramArrayOfAbstractTypeResolver, ValueInstantiators[] paramArrayOfValueInstantiators)
  {
    Deserializers[] arrayOfDeserializers = paramArrayOfDeserializers;
    if (paramArrayOfDeserializers == null) {
      arrayOfDeserializers = BeanDeserializerFactory.access$000();
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
  
  public Iterable abstractTypeResolvers()
  {
    return ArrayBuilders.arrayAsIterable(this._abstractTypeResolvers);
  }
  
  public Iterable deserializerModifiers()
  {
    return ArrayBuilders.arrayAsIterable(this._modifiers);
  }
  
  public Iterable deserializers()
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
  
  public boolean hasDeserializers()
  {
    return this._additionalDeserializers.length > 0;
  }
  
  public boolean hasKeyDeserializers()
  {
    return this._additionalKeyDeserializers.length > 0;
  }
  
  public boolean hasValueInstantiators()
  {
    return this._valueInstantiators.length > 0;
  }
  
  public Iterable keyDeserializers()
  {
    return ArrayBuilders.arrayAsIterable(this._additionalKeyDeserializers);
  }
  
  public Iterable valueInstantiators()
  {
    return ArrayBuilders.arrayAsIterable(this._valueInstantiators);
  }
  
  public DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    if (paramAbstractTypeResolver == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    paramAbstractTypeResolver = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(this._abstractTypeResolvers, paramAbstractTypeResolver);
    return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, paramAbstractTypeResolver, this._valueInstantiators);
  }
  
  public DeserializerFactory.Config withAdditionalDeserializers(Deserializers paramDeserializers)
  {
    if (paramDeserializers == null) {
      throw new IllegalArgumentException("Can not pass null Deserializers");
    }
    return new ConfigImpl((Deserializers[])ArrayBuilders.insertInListNoDup(this._additionalDeserializers, paramDeserializers), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
  }
  
  public DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    if (paramKeyDeserializers == null) {
      throw new IllegalArgumentException("Can not pass null KeyDeserializers");
    }
    paramKeyDeserializers = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(this._additionalKeyDeserializers, paramKeyDeserializers);
    return new ConfigImpl(this._additionalDeserializers, paramKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
  }
  
  public DeserializerFactory.Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    if (paramBeanDeserializerModifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    paramBeanDeserializerModifier = (BeanDeserializerModifier[])ArrayBuilders.insertInListNoDup(this._modifiers, paramBeanDeserializerModifier);
    return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, paramBeanDeserializerModifier, this._abstractTypeResolvers, this._valueInstantiators);
  }
  
  public DeserializerFactory.Config withValueInstantiators(ValueInstantiators paramValueInstantiators)
  {
    if (paramValueInstantiators == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    paramValueInstantiators = (ValueInstantiators[])ArrayBuilders.insertInListNoDup(this._valueInstantiators, paramValueInstantiators);
    return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, paramValueInstantiators);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/BeanDeserializerFactory$ConfigImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */