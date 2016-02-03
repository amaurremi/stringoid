package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMutableMessageLite<MessageType extends GeneratedMutableMessageLite<MessageType>>
  extends AbstractMutableMessageLite
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected ByteString unknownFields = ByteString.EMPTY;
  
  static MessageLite.Builder internalCopyToBuilder(MutableMessageLite paramMutableMessageLite, MessageLite paramMessageLite)
  {
    paramMessageLite = paramMessageLite.newBuilderForType();
    try
    {
      paramMessageLite.mergeFrom(paramMutableMessageLite.toByteArray());
      return paramMessageLite;
    }
    catch (InvalidProtocolBufferException paramMutableMessageLite)
    {
      throw new RuntimeException("Failed to parse serialized bytes (should not happen)");
    }
  }
  
  protected static MessageLite internalImmutableDefault(String paramString)
  {
    try
    {
      paramString = (MessageLite)GeneratedMessageLite.invokeOrDie(GeneratedMessageLite.getMethodOrDie(Class.forName(paramString), "getDefaultInstance", new Class[0]), null, new Object[0]);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new UnsupportedOperationException("Cannot load the corresponding immutable class. Please add necessary dependencies.");
    }
  }
  
  static <MessageType extends MutableMessageLite> boolean parseUnknownField(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet, MessageType paramMessageType, CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
    throws IOException
  {
    int k = WireFormat.getTagWireType(paramInt);
    GeneratedMessageLite.GeneratedExtension localGeneratedExtension = paramExtensionRegistryLite.findLiteExtensionByNumber(paramMessageType, WireFormat.getTagFieldNumber(paramInt));
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
        paramMessageType = FieldSet.readPrimitiveFieldForMutable(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
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
        paramMessageType = FieldSet.readPrimitiveFieldForMutable(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
      }
      for (;;)
      {
        if (localGeneratedExtension.descriptor.isRepeated())
        {
          paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
          break;
          paramMessageType = ((MutableMessageLite)localGeneratedExtension.messageDefaultInstance).newMessageForType();
          if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
            paramCodedInputStream.readGroup(localGeneratedExtension.getNumber(), paramMessageType, paramExtensionRegistryLite);
          }
          for (;;)
          {
            break;
            paramCodedInputStream.readMessage(paramMessageType, paramExtensionRegistryLite);
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
  
  public MessageType clear()
  {
    assertMutable();
    this.unknownFields = ByteString.EMPTY;
    return this;
  }
  
  public abstract MessageType getDefaultInstanceForType();
  
  public Parser<MessageType> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public MessageLite immutableCopy()
  {
    MessageLite localMessageLite = internalImmutableDefault();
    if (this == getDefaultInstanceForType()) {
      return localMessageLite;
    }
    return internalCopyToBuilder(this, localMessageLite).buildPartial();
  }
  
  protected abstract MessageLite internalImmutableDefault();
  
  public abstract MessageType mergeFrom(MessageType paramMessageType);
  
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
  
  public static abstract class ExtendableMutableMessage<MessageType extends ExtendableMutableMessage<MessageType>>
    extends GeneratedMutableMessageLite<MessageType>
  {
    private FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.emptySet();
    
    private void ensureExtensionsIsMutable()
    {
      if (this.extensions.isImmutable()) {
        this.extensions = this.extensions.clone();
      }
    }
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      if (paramGeneratedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> MessageType addExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, Type paramType)
    {
      assertMutable();
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.addRepeatedField(paramGeneratedExtension.descriptor, paramGeneratedExtension.singularToFieldSetType(paramType));
      return this;
    }
    
    public MessageType clear()
    {
      assertMutable();
      this.extensions = FieldSet.emptySet();
      return (ExtendableMutableMessage)super.clear();
    }
    
    public final <Type> MessageType clearExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
    {
      assertMutable();
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.clearField(paramGeneratedExtension.descriptor);
      return this;
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
      if (paramGeneratedExtension.descriptor.isRepeated) {
        return Collections.unmodifiableList((List)paramGeneratedExtension.fromFieldSetType(localObject));
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
    
    public final <Type extends MutableMessageLite> Type getMutableExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      assertMutable();
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      Object localObject = paramGeneratedExtension.descriptor;
      if (((GeneratedMessageLite.ExtensionDescriptor)localObject).getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
        throw new UnsupportedOperationException("getMutableExtension() called on a non-Message type.");
      }
      if (((GeneratedMessageLite.ExtensionDescriptor)localObject).isRepeated()) {
        throw new UnsupportedOperationException("getMutableExtension() called on a repeated type.");
      }
      localObject = this.extensions.getField(paramGeneratedExtension.descriptor);
      if (localObject == null)
      {
        localObject = ((MutableMessageLite)paramGeneratedExtension.defaultValue).newMessageForType();
        this.extensions.setField(paramGeneratedExtension.descriptor, localObject);
        return (Type)localObject;
      }
      return (MutableMessageLite)localObject;
    }
    
    public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
    {
      verifyExtensionContainingType(paramGeneratedExtension);
      return this.extensions.hasField(paramGeneratedExtension.descriptor);
    }
    
    public MessageLite immutableCopy()
    {
      GeneratedMessageLite.ExtendableBuilder localExtendableBuilder = (GeneratedMessageLite.ExtendableBuilder)internalCopyToBuilder(this, internalImmutableDefault());
      localExtendableBuilder.internalSetExtensionSet(this.extensions.cloneWithAllFieldsToImmutable());
      return localExtendableBuilder.buildPartial();
    }
    
    void internalSetExtensionSet(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet)
    {
      this.extensions = paramFieldSet;
    }
    
    protected final void mergeExtensionFields(MessageType paramMessageType)
    {
      ensureExtensionsIsMutable();
      this.extensions.mergeFrom(paramMessageType.extensions);
    }
    
    protected ExtendableMutableMessage<MessageType>.ExtensionWriter newExtensionWriter()
    {
      return new ExtensionWriter(false, null);
    }
    
    protected ExtendableMutableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter()
    {
      return new ExtensionWriter(true, null);
    }
    
    protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
      throws IOException
    {
      ensureExtensionsIsMutable();
      return GeneratedMutableMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), paramCodedInputStream, paramCodedOutputStream, paramExtensionRegistryLite, paramInt);
    }
    
    public final <Type> MessageType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt, Type paramType)
    {
      assertMutable();
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.setRepeatedField(paramGeneratedExtension.descriptor, paramInt, paramGeneratedExtension.singularToFieldSetType(paramType));
      return this;
    }
    
    public final <Type> MessageType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension, Type paramType)
    {
      assertMutable();
      verifyExtensionContainingType(paramGeneratedExtension);
      ensureExtensionsIsMutable();
      this.extensions.setField(paramGeneratedExtension.descriptor, paramGeneratedExtension.toFieldSetType(paramType));
      return this;
    }
    
    protected class ExtensionWriter
    {
      private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMutableMessageLite.ExtendableMutableMessage.this.extensions.iterator();
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
  
  static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private byte[] asBytes;
    private String messageClassName;
    
    SerializedForm(MutableMessageLite paramMutableMessageLite)
    {
      this.messageClassName = paramMutableMessageLite.getClass().getName();
      this.asBytes = paramMutableMessageLite.toByteArray();
    }
    
    protected Object readResolve()
      throws ObjectStreamException
    {
      try
      {
        MutableMessageLite localMutableMessageLite = (MutableMessageLite)Class.forName(this.messageClassName).getMethod("newMessage", new Class[0]).invoke(null, new Object[0]);
        if (!localMutableMessageLite.mergeFrom(CodedInputStream.newInstance(this.asBytes))) {
          throw new RuntimeException("Unable to understand proto buffer");
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class", localClassNotFoundException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException("Unable to find newMessage method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call newMessage method", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Error calling newMessage", localInvocationTargetException.getCause());
      }
      return localInvocationTargetException;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/GeneratedMutableMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */