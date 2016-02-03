package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.map.SerializerFactory.Config;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.util.ArrayBuilders;

public class BeanSerializerFactory$ConfigImpl
  extends SerializerFactory.Config
{
  protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
  protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
  protected final Serializers[] _additionalKeySerializers;
  protected final Serializers[] _additionalSerializers;
  protected final BeanSerializerModifier[] _modifiers;
  
  public BeanSerializerFactory$ConfigImpl()
  {
    this(null, null, null);
  }
  
  protected BeanSerializerFactory$ConfigImpl(Serializers[] paramArrayOfSerializers1, Serializers[] paramArrayOfSerializers2, BeanSerializerModifier[] paramArrayOfBeanSerializerModifier)
  {
    Serializers[] arrayOfSerializers = paramArrayOfSerializers1;
    if (paramArrayOfSerializers1 == null) {
      arrayOfSerializers = NO_SERIALIZERS;
    }
    this._additionalSerializers = arrayOfSerializers;
    paramArrayOfSerializers1 = paramArrayOfSerializers2;
    if (paramArrayOfSerializers2 == null) {
      paramArrayOfSerializers1 = NO_SERIALIZERS;
    }
    this._additionalKeySerializers = paramArrayOfSerializers1;
    paramArrayOfSerializers1 = paramArrayOfBeanSerializerModifier;
    if (paramArrayOfBeanSerializerModifier == null) {
      paramArrayOfSerializers1 = NO_MODIFIERS;
    }
    this._modifiers = paramArrayOfSerializers1;
  }
  
  public boolean hasKeySerializers()
  {
    return this._additionalKeySerializers.length > 0;
  }
  
  public boolean hasSerializerModifiers()
  {
    return this._modifiers.length > 0;
  }
  
  public boolean hasSerializers()
  {
    return this._additionalSerializers.length > 0;
  }
  
  public Iterable keySerializers()
  {
    return ArrayBuilders.arrayAsIterable(this._additionalKeySerializers);
  }
  
  public Iterable serializerModifiers()
  {
    return ArrayBuilders.arrayAsIterable(this._modifiers);
  }
  
  public Iterable serializers()
  {
    return ArrayBuilders.arrayAsIterable(this._additionalSerializers);
  }
  
  public SerializerFactory.Config withAdditionalKeySerializers(Serializers paramSerializers)
  {
    if (paramSerializers == null) {
      throw new IllegalArgumentException("Can not pass null Serializers");
    }
    paramSerializers = (Serializers[])ArrayBuilders.insertInListNoDup(this._additionalKeySerializers, paramSerializers);
    return new ConfigImpl(this._additionalSerializers, paramSerializers, this._modifiers);
  }
  
  public SerializerFactory.Config withAdditionalSerializers(Serializers paramSerializers)
  {
    if (paramSerializers == null) {
      throw new IllegalArgumentException("Can not pass null Serializers");
    }
    return new ConfigImpl((Serializers[])ArrayBuilders.insertInListNoDup(this._additionalSerializers, paramSerializers), this._additionalKeySerializers, this._modifiers);
  }
  
  public SerializerFactory.Config withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    if (paramBeanSerializerModifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    paramBeanSerializerModifier = (BeanSerializerModifier[])ArrayBuilders.insertInListNoDup(this._modifiers, paramBeanSerializerModifier);
    return new ConfigImpl(this._additionalSerializers, this._additionalKeySerializers, paramBeanSerializerModifier);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/BeanSerializerFactory$ConfigImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */