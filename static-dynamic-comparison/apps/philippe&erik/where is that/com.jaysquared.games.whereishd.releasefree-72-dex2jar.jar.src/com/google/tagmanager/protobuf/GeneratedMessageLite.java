package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite
  extends AbstractMessageLite
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  protected GeneratedMessageLite() {}
  
  protected GeneratedMessageLite(Builder paramBuilder) {}
  
  static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      throw new RuntimeException("Generated message class \"" + paramClass.getName() + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  protected static MutableMessageLite internalMutableDefault(String paramString)
  {
    try
    {
      paramString = (MutableMessageLite)invokeOrDie(getMethodOrDie(Class.forName(paramString), "getDefaultInstance", new Class[0]), null, new Object[0]);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new UnsupportedOperationException("Cannot load the corresponding mutable class. Please add necessary dependencies.");
    }
  }
  
  static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType paramContainingType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean, Class paramClass)
  {
    return new GeneratedExtension(paramContainingType, Collections.emptyList(), paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, true, paramBoolean), paramClass);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, Class paramClass)
  {
    return new GeneratedExtension(paramContainingType, paramType, paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, false, false), paramClass);
  }
  
  private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> paramFieldSet, MessageType paramMessageType, CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
    throws IOException
  {
    int k = WireFormat.getTagWireType(paramInt);
    GeneratedExtension localGeneratedExtension = paramExtensionRegistryLite.findLiteExtensionByNumber(paramMessageType, WireFormat.getTagFieldNumber(paramInt));
    int j = 0;
    int i = 0;
    if (localGeneratedExtension == null) {
      j = 1;
    }
    while (j != 0)
    {
      return paramCodedInputStream.skipField(paramInt, paramCodedOutputStream);
      if (k == FieldSet.getWireFormatForFieldType(localGeneratedExtension.descriptor.getLiteType(), false)) {
        i = 0;
      } else if ((localGeneratedExtension.descriptor.isRepeated) && (localGeneratedExtension.descriptor.type.isPackable()) && (k == FieldSet.getWireFormatForFieldType(localGeneratedExtension.descriptor.getLiteType(), true))) {
        i = 1;
      } else {
        j = 1;
      }
    }
    if (i != 0)
    {
      paramInt = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
      if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
        while (paramCodedInputStream.getBytesUntilLimit() > 0)
        {
          i = paramCodedInputStream.readEnum();
          paramMessageType = localGeneratedExtension.descriptor.getEnumType().findValueByNumber(i);
          if (paramMessageType == null) {
            return true;
          }
          paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
        }
      }
      while (paramCodedInputStream.getBytesUntilLimit() > 0)
      {
        paramMessageType = FieldSet.readPrimitiveField(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
        paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, paramMessageType);
      }
      paramCodedInputStream.popLimit(paramInt);
    }
    for (;;)
    {
      return true;
      switch (localGeneratedExtension.descriptor.getLiteJavaType())
      {
      default: 
        paramMessageType = FieldSet.readPrimitiveField(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
      }
      for (;;)
      {
        if (localGeneratedExtension.descriptor.isRepeated())
        {
          paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
          break;
          paramCodedOutputStream = null;
          paramMessageType = paramCodedOutputStream;
          if (!localGeneratedExtension.descriptor.isRepeated())
          {
            MessageLite localMessageLite = (MessageLite)paramFieldSet.getField(localGeneratedExtension.descriptor);
            paramMessageType = paramCodedOutputStream;
            if (localMessageLite != null) {
              paramMessageType = localMessageLite.toBuilder();
            }
          }
          paramCodedOutputStream = paramMessageType;
          if (paramMessageType == null) {
            paramCodedOutputStream = localGeneratedExtension.getMessageDefaultInstance().newBuilderForType();
          }
          if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
            paramCodedInputStream.readGroup(localGeneratedExtension.getNumber(), paramCodedOutputStream, paramExtensionRegistryLite);
          }
          for (;;)
          {
            paramMessageType = paramCodedOutputStream.build();
            break;
            paramCodedInputStream.readMessage(paramCodedOutputStream, paramExtensionRegistryLite);
          }
          i = paramCodedInputStream.readEnum();
          paramCodedInputStream = localGeneratedExtension.descriptor.getEnumType().findValueByNumber(i);
          paramMessageType = paramCodedInputStream;
          if (paramCodedInputStream == null)
          {
            paramCodedOutputStream.writeRawVarint32(paramInt);
            paramCodedOutputStream.writeUInt32NoTag(i);
            return true;
          }
        }
      }
      paramFieldSet.setField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
    }
  }
  
  public Parser<? extends MessageLite> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected MutableMessageLite internalMutableDefault()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void makeExtensionsImmutable() {}
  
  public MutableMessageLite mutableCopy()
  {
    MutableMessageLite localMutableMessageLite = internalMutableDefault().newMessageForType();
    if (this == getDefaultInstanceForType()) {
      return localMutableMessageLite;
    }
    localMutableMessageLite.mergeFrom(CodedInputStream.newInstance(toByteArray()));
    return localMutableMessageLite;
  }
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
    throws IOException
  {
    return paramCodedInputStream.skipField(paramInt, paramCodedOutputStream);
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return new SerializedForm(this);
  }
  
  public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder>
    extends AbstractMessageLite.Builder<BuilderType>
  {
    private ByteString unknownFields = ByteString.EMPTY;
    
    public BuilderType clear()
    {
      this.unknownFields = ByteString.EMPTY;
      return this;
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public abstract MessageType getDefaultInstanceForType();
    
    public final ByteString getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public abstract BuilderType mergeFrom(MessageType paramMessageType);
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      return paramCodedInputStream.skipField(paramInt, paramCodedOutputStream);
    }
    
    public final BuilderType setUnknownFields(ByteString paramByteString)
    {
      this.unknownFields = paramByteString;
      return this;
    }
  }
  
  public static abstract class ExtendableBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
    extends GeneratedMessageLite.Builder<MessageType, BuilderType>
    implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
  {
    private FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.emptySet();
    private boolean extensionsIsMutable;
    
    private FieldSet<GeneratedMessageLite.ExtensionDescriptor> buildExtensions()
    {
      this.extensions.makeImmutable();
      this.extensionsIsMutable = false;
      return this.extensions;
    }
    
    private void ensureExtensionsIsMutable()
    {
      if (!this.extensionsIsMutable)
      {
        this.extensions = this.extensions.clone();
        this.extensionsIsMutable = true;
      }
    }
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> BuilderType addExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, Type paramType)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.addRepeatedField(paramGeneratedExtension.descriptor, paramGeneratedExtension.singularToFieldSetType(paramType));
      return this;
    }
    
    public BuilderType clear()
    {
      this.extensions.clear();
      this.extensionsIsMutable = false;
      return (ExtendableBuilder)super.clear();
    }
    
    public final <Type> BuilderType clearExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.clearField(paramGeneratedExtension.descriptor);
      return this;
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    protected boolean extensionsAreInitialized()
    {
      return this.extensions.isInitialized();
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      Object localObject = this.extensions.getField(paramGeneratedExtension.descriptor);
      if (localObject == null) {
        return (Type)paramGeneratedExtension.defaultValue;
      }
      return (Type)paramGeneratedExtension.fromFieldSetType(localObject);
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return (Type)paramGeneratedExtension.singularFromFieldSetType(this.extensions.getRepeatedField(paramGeneratedExtension.descriptor, paramInt));
    }
    
    public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.getRepeatedFieldCount(paramGeneratedExtension.descriptor);
    }
    
    public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.hasField(paramGeneratedExtension.descriptor);
    }
    
    void internalSetExtensionSet(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet)
    {
      this.extensions = paramFieldSet;
    }
    
    protected final void mergeExtensionFields(MessageType paramMessageType)
    {
      ensureExtensionsIsMutable();
      this.extensions.mergeFrom(GeneratedMessageLite.ExtendableMessage.access$200(paramMessageType));
    }
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      ensureExtensionsIsMutable();
      return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), paramCodedInputStream, paramCodedOutputStream, paramExtensionRegistryLite, paramInt);
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt, Type paramType)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.setRepeatedField(paramGeneratedExtension.descriptor, paramInt, paramGeneratedExtension.singularToFieldSetType(paramType));
      return this;
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension, Type paramType)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.setField(paramGeneratedExtension.descriptor, paramGeneratedExtension.toFieldSetType(paramType));
      return this;
    }
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>>
    extends GeneratedMessageLite
    implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
  {
    private final FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions;
    
    protected ExtendableMessage()
    {
      this.extensions = FieldSet.newFieldSet();
    }
    
    protected ExtendableMessage(GeneratedMessageLite.ExtendableBuilder<MessageType, ?> paramExtendableBuilder)
    {
      this.extensions = paramExtendableBuilder.buildExtensions();
    }
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    protected boolean extensionsAreInitialized()
    {
      return this.extensions.isInitialized();
    }
    
    protected int extensionsSerializedSize()
    {
      return this.extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet()
    {
      return this.extensions.getMessageSetSerializedSize();
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      Object localObject = this.extensions.getField(paramGeneratedExtension.descriptor);
      if (localObject == null) {
        return (Type)paramGeneratedExtension.defaultValue;
      }
      return (Type)paramGeneratedExtension.fromFieldSetType(localObject);
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return (Type)paramGeneratedExtension.singularFromFieldSetType(this.extensions.getRepeatedField(paramGeneratedExtension.descriptor, paramInt));
    }
    
    public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.getRepeatedFieldCount(paramGeneratedExtension.descriptor);
    }
    
    public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.hasField(paramGeneratedExtension.descriptor);
    }
    
    protected void makeExtensionsImmutable()
    {
      this.extensions.makeImmutable();
    }
    
    public MutableMessageLite mutableCopy()
    {
      GeneratedMutableMessageLite.ExtendableMutableMessage localExtendableMutableMessage = (GeneratedMutableMessageLite.ExtendableMutableMessage)super.mutableCopy();
      localExtendableMutableMessage.internalSetExtensionSet(this.extensions.cloneWithAllFieldsToMutable());
      return localExtendableMutableMessage;
    }
    
    protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter()
    {
      return new ExtensionWriter(false, null);
    }
    
    protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter()
    {
      return new ExtensionWriter(true, null);
    }
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), paramCodedInputStream, paramCodedOutputStream, paramExtensionRegistryLite, paramInt);
    }
    
    protected class ExtensionWriter
    {
      private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMessageLite.ExtendableMessage.this.extensions.iterator();
      private final boolean messageSetWireFormat;
      private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
      
      private ExtensionWriter(boolean paramBoolean)
      {
        if (this.iter.hasNext()) {
          this.next = ((Map.Entry)this.iter.next());
        }
        this.messageSetWireFormat = paramBoolean;
      }
      
      public void writeUntil(int paramInt, CodedOutputStream paramCodedOutputStream)
        throws IOException
      {
        while ((this.next != null) && (((GeneratedMessageLite.ExtensionDescriptor)this.next.getKey()).getNumber() < paramInt))
        {
          GeneratedMessageLite.ExtensionDescriptor localExtensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor)this.next.getKey();
          if ((this.messageSetWireFormat) && (localExtensionDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localExtensionDescriptor.isRepeated())) {
            paramCodedOutputStream.writeMessageSetExtension(localExtensionDescriptor.getNumber(), (MessageLite)this.next.getValue());
          }
          for (;;)
          {
            if (!this.iter.hasNext()) {
              break label131;
            }
            this.next = ((Map.Entry)this.iter.next());
            break;
            FieldSet.writeField(localExtensionDescriptor, this.next.getValue(), paramCodedOutputStream);
          }
          label131:
          this.next = null;
        }
      }
    }
  }
  
  public static abstract interface ExtendableMessageOrBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage>
    extends MessageLiteOrBuilder
  {
    public abstract <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
    
    public abstract <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt);
    
    public abstract <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension);
    
    public abstract <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
  }
  
  static final class ExtensionDescriptor
    implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
  {
    final Internal.EnumLiteMap<?> enumTypeMap;
    final boolean isPacked;
    final boolean isRepeated;
    final int number;
    final WireFormat.FieldType type;
    
    ExtensionDescriptor(Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.enumTypeMap = paramEnumLiteMap;
      this.number = paramInt;
      this.type = paramFieldType;
      this.isRepeated = paramBoolean1;
      this.isPacked = paramBoolean2;
    }
    
    public int compareTo(ExtensionDescriptor paramExtensionDescriptor)
    {
      return this.number - paramExtensionDescriptor.number;
    }
    
    public Internal.EnumLiteMap<?> getEnumType()
    {
      return this.enumTypeMap;
    }
    
    public WireFormat.JavaType getLiteJavaType()
    {
      return this.type.getJavaType();
    }
    
    public WireFormat.FieldType getLiteType()
    {
      return this.type;
    }
    
    public int getNumber()
    {
      return this.number;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite)
    {
      return ((GeneratedMessageLite.Builder)paramBuilder).mergeFrom((GeneratedMessageLite)paramMessageLite);
    }
    
    public MutableMessageLite internalMergeFrom(MutableMessageLite paramMutableMessageLite1, MutableMessageLite paramMutableMessageLite2)
    {
      return ((GeneratedMutableMessageLite)paramMutableMessageLite1).mergeFrom((GeneratedMutableMessageLite)paramMutableMessageLite2);
    }
    
    public boolean isPacked()
    {
      return this.isPacked;
    }
    
    public boolean isRepeated()
    {
      return this.isRepeated;
    }
  }
  
  public static class GeneratedExtension<ContainingType extends MessageLite, Type>
  {
    final ContainingType containingTypeDefaultInstance;
    final Type defaultValue;
    final GeneratedMessageLite.ExtensionDescriptor descriptor;
    final Method enumValueOf;
    final MessageLite messageDefaultInstance;
    final Class singularType;
    
    GeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, GeneratedMessageLite.ExtensionDescriptor paramExtensionDescriptor, Class paramClass)
    {
      if (paramContainingType == null) {
        throw new IllegalArgumentException("Null containingTypeDefaultInstance");
      }
      if ((paramExtensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE) && (paramMessageLite == null)) {
        throw new IllegalArgumentException("Null messageDefaultInstance");
      }
      this.containingTypeDefaultInstance = paramContainingType;
      this.defaultValue = paramType;
      this.messageDefaultInstance = paramMessageLite;
      this.descriptor = paramExtensionDescriptor;
      this.singularType = paramClass;
      if (Internal.EnumLite.class.isAssignableFrom(paramClass))
      {
        this.enumValueOf = GeneratedMessageLite.getMethodOrDie(paramClass, "valueOf", new Class[] { Integer.TYPE });
        return;
      }
      this.enumValueOf = null;
    }
    
    Object fromFieldSetType(Object paramObject)
    {
      if (this.descriptor.isRepeated())
      {
        if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((List)paramObject).iterator();
          for (;;)
          {
            paramObject = localArrayList;
            if (!localIterator.hasNext()) {
              break;
            }
            localArrayList.add(singularFromFieldSetType(localIterator.next()));
          }
        }
        return paramObject;
      }
      return singularFromFieldSetType(paramObject);
    }
    
    public ContainingType getContainingTypeDefaultInstance()
    {
      return this.containingTypeDefaultInstance;
    }
    
    public MessageLite getMessageDefaultInstance()
    {
      return this.messageDefaultInstance;
    }
    
    public int getNumber()
    {
      return this.descriptor.getNumber();
    }
    
    Object singularFromFieldSetType(Object paramObject)
    {
      Object localObject = paramObject;
      if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
        localObject = GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[] { (Integer)paramObject });
      }
      return localObject;
    }
    
    Object singularToFieldSetType(Object paramObject)
    {
      Object localObject = paramObject;
      if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
        localObject = Integer.valueOf(((Internal.EnumLite)paramObject).getNumber());
      }
      return localObject;
    }
    
    Object toFieldSetType(Object paramObject)
    {
      if (this.descriptor.isRepeated())
      {
        if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((List)paramObject).iterator();
          for (;;)
          {
            paramObject = localArrayList;
            if (!localIterator.hasNext()) {
              break;
            }
            localArrayList.add(singularToFieldSetType(localIterator.next()));
          }
        }
        return paramObject;
      }
      return singularToFieldSetType(paramObject);
    }
  }
  
  static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private byte[] asBytes;
    private String messageClassName;
    
    SerializedForm(MessageLite paramMessageLite)
    {
      this.messageClassName = paramMessageLite.getClass().getName();
      this.asBytes = paramMessageLite.toByteArray();
    }
    
    protected Object readResolve()
      throws ObjectStreamException
    {
      try
      {
        Object localObject = (MessageLite.Builder)Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
        ((MessageLite.Builder)localObject).mergeFrom(this.asBytes);
        localObject = ((MessageLite.Builder)localObject).buildPartial();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class", localClassNotFoundException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException("Unable to find newBuilder method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call newBuilder method", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Error calling newBuilder", localInvocationTargetException.getCause());
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        throw new RuntimeException("Unable to understand proto buffer", localInvalidProtocolBufferException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/GeneratedMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */