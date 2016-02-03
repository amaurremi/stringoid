package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.ByteString.Output;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableDebug
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramExtensionRegistryLite.add(MacroEvaluationInfo.macro);
  }
  
  public static final class DataLayerEventEvaluationInfo
    extends GeneratedMutableMessageLite<DataLayerEventEvaluationInfo>
    implements MutableMessageLite
  {
    public static Parser<DataLayerEventEvaluationInfo> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int RESULTS_FIELD_NUMBER = 2;
    public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
    private static final DataLayerEventEvaluationInfo defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private List<MutableDebug.ResolvedFunctionCall> results_ = null;
    private MutableDebug.RuleEvaluationStepInfo rulesEvaluation_;
    
    static
    {
      defaultInstance = new DataLayerEventEvaluationInfo(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private DataLayerEventEvaluationInfo()
    {
      initFields();
    }
    
    private DataLayerEventEvaluationInfo(boolean paramBoolean) {}
    
    private void ensureResultsInitialized()
    {
      if (this.results_ == null) {
        this.results_ = new ArrayList();
      }
    }
    
    private void ensureRulesEvaluationInitialized()
    {
      if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
        this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
      }
    }
    
    public static DataLayerEventEvaluationInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.getDefaultInstance();
    }
    
    public static DataLayerEventEvaluationInfo newMessage()
    {
      return new DataLayerEventEvaluationInfo();
    }
    
    public DataLayerEventEvaluationInfo addAllResults(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureResultsInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.results_);
      return this;
    }
    
    public DataLayerEventEvaluationInfo addResults(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureResultsInitialized();
      this.results_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addResults()
    {
      assertMutable();
      ensureResultsInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.results_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public DataLayerEventEvaluationInfo clear()
    {
      assertMutable();
      super.clear();
      if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
        this.rulesEvaluation_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFE;
      this.results_ = null;
      return this;
    }
    
    public DataLayerEventEvaluationInfo clearResults()
    {
      assertMutable();
      this.results_ = null;
      return this;
    }
    
    public DataLayerEventEvaluationInfo clearRulesEvaluation()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
        this.rulesEvaluation_.clear();
      }
      return this;
    }
    
    public DataLayerEventEvaluationInfo clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof DataLayerEventEvaluationInfo)) {
        return super.equals(paramObject);
      }
      paramObject = (DataLayerEventEvaluationInfo)paramObject;
      int i;
      int j;
      if ((1 != 0) && (hasRulesEvaluation() == ((DataLayerEventEvaluationInfo)paramObject).hasRulesEvaluation()))
      {
        i = 1;
        j = i;
        if (hasRulesEvaluation())
        {
          if ((i == 0) || (!getRulesEvaluation().equals(((DataLayerEventEvaluationInfo)paramObject).getRulesEvaluation()))) {
            break label102;
          }
          j = 1;
        }
        label71:
        if ((j == 0) || (!getResultsList().equals(((DataLayerEventEvaluationInfo)paramObject).getResultsList()))) {
          break label107;
        }
      }
      label102:
      label107:
      for (boolean bool = true;; bool = false)
      {
        return bool;
        i = 0;
        break;
        j = 0;
        break label71;
      }
    }
    
    public final DataLayerEventEvaluationInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableResults(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.results_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableResultsList()
    {
      assertMutable();
      ensureResultsInitialized();
      return this.results_;
    }
    
    public MutableDebug.RuleEvaluationStepInfo getMutableRulesEvaluation()
    {
      assertMutable();
      ensureRulesEvaluationInitialized();
      this.bitField0_ |= 0x1;
      return this.rulesEvaluation_;
    }
    
    public Parser<DataLayerEventEvaluationInfo> getParserForType()
    {
      return PARSER;
    }
    
    public MutableDebug.ResolvedFunctionCall getResults(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.results_.get(paramInt);
    }
    
    public int getResultsCount()
    {
      if (this.results_ == null) {
        return 0;
      }
      return this.results_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getResultsList()
    {
      if (this.results_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.results_);
    }
    
    public MutableDebug.RuleEvaluationStepInfo getRulesEvaluation()
    {
      return this.rulesEvaluation_;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeMessageSize(1, this.rulesEvaluation_);
      }
      int k = i;
      if (this.results_ != null)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.results_.size()) {
            break;
          }
          i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.results_.get(j));
          j += 1;
        }
      }
      i = k + this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public boolean hasRulesEvaluation()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public int hashCode()
    {
      int i = 41;
      if (hasRulesEvaluation()) {
        i = 80454 + getRulesEvaluation().hashCode();
      }
      int j = i;
      if (getResultsCount() > 0) {
        j = (i * 37 + 2) * 53 + getResultsList().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DataLayerEventEvaluationInfo");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      if ((hasRulesEvaluation()) && (!getRulesEvaluation().isInitialized())) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= getResultsCount()) {
          break label47;
        }
        if (!getResults(i).isInitialized()) {
          break;
        }
        i += 1;
      }
      label47:
      return true;
    }
    
    public DataLayerEventEvaluationInfo mergeFrom(DataLayerEventEvaluationInfo paramDataLayerEventEvaluationInfo)
    {
      if (this == paramDataLayerEventEvaluationInfo) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramDataLayerEventEvaluationInfo == getDefaultInstance()) {
        return this;
      }
      if (paramDataLayerEventEvaluationInfo.hasRulesEvaluation())
      {
        ensureRulesEvaluationInitialized();
        this.rulesEvaluation_.mergeFrom(paramDataLayerEventEvaluationInfo.getRulesEvaluation());
        this.bitField0_ |= 0x1;
      }
      if ((paramDataLayerEventEvaluationInfo.results_ != null) && (!paramDataLayerEventEvaluationInfo.results_.isEmpty()))
      {
        ensureResultsInitialized();
        AbstractMutableMessageLite.addAll(paramDataLayerEventEvaluationInfo.results_, this.results_);
      }
      this.unknownFields = this.unknownFields.concat(paramDataLayerEventEvaluationInfo.unknownFields);
      return this;
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          case 18: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label150;
              }
              i = 1;
              break;
              if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
              }
              this.bitField0_ |= 0x1;
              paramCodedInputStream.readMessage(this.rulesEvaluation_, paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addResults(), paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label150:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public DataLayerEventEvaluationInfo newMessageForType()
    {
      return new DataLayerEventEvaluationInfo();
    }
    
    public DataLayerEventEvaluationInfo setResults(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureResultsInitialized();
      this.results_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public DataLayerEventEvaluationInfo setRulesEvaluation(MutableDebug.RuleEvaluationStepInfo paramRuleEvaluationStepInfo)
    {
      assertMutable();
      if (paramRuleEvaluationStepInfo == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.rulesEvaluation_ = paramRuleEvaluationStepInfo;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessageWithCachedSizes(1, this.rulesEvaluation_);
      }
      if (this.results_ != null)
      {
        i = 0;
        while (i < this.results_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite)this.results_.get(i));
          i += 1;
        }
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != i - j) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
  
  public static final class DebugEvents
    extends GeneratedMutableMessageLite<DebugEvents>
    implements MutableMessageLite
  {
    public static final int EVENT_FIELD_NUMBER = 1;
    public static Parser<DebugEvents> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    private static final DebugEvents defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private List<MutableDebug.EventInfo> event_ = null;
    
    static
    {
      defaultInstance = new DebugEvents(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private DebugEvents()
    {
      initFields();
    }
    
    private DebugEvents(boolean paramBoolean) {}
    
    private void ensureEventInitialized()
    {
      if (this.event_ == null) {
        this.event_ = new ArrayList();
      }
    }
    
    public static DebugEvents getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields() {}
    
    public static DebugEvents newMessage()
    {
      return new DebugEvents();
    }
    
    public DebugEvents addAllEvent(Iterable<? extends MutableDebug.EventInfo> paramIterable)
    {
      assertMutable();
      ensureEventInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.event_);
      return this;
    }
    
    public DebugEvents addEvent(MutableDebug.EventInfo paramEventInfo)
    {
      assertMutable();
      if (paramEventInfo == null) {
        throw new NullPointerException();
      }
      ensureEventInitialized();
      this.event_.add(paramEventInfo);
      return this;
    }
    
    public MutableDebug.EventInfo addEvent()
    {
      assertMutable();
      ensureEventInitialized();
      MutableDebug.EventInfo localEventInfo = MutableDebug.EventInfo.newMessage();
      this.event_.add(localEventInfo);
      return localEventInfo;
    }
    
    public DebugEvents clear()
    {
      assertMutable();
      super.clear();
      this.event_ = null;
      return this;
    }
    
    public DebugEvents clearEvent()
    {
      assertMutable();
      this.event_ = null;
      return this;
    }
    
    public DebugEvents clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof DebugEvents)) {
        return super.equals(paramObject);
      }
      paramObject = (DebugEvents)paramObject;
      if ((1 != 0) && (getEventList().equals(((DebugEvents)paramObject).getEventList()))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final DebugEvents getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableDebug.EventInfo getEvent(int paramInt)
    {
      return (MutableDebug.EventInfo)this.event_.get(paramInt);
    }
    
    public int getEventCount()
    {
      if (this.event_ == null) {
        return 0;
      }
      return this.event_.size();
    }
    
    public List<MutableDebug.EventInfo> getEventList()
    {
      if (this.event_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.event_);
    }
    
    public MutableDebug.EventInfo getMutableEvent(int paramInt)
    {
      return (MutableDebug.EventInfo)this.event_.get(paramInt);
    }
    
    public List<MutableDebug.EventInfo> getMutableEventList()
    {
      assertMutable();
      ensureEventInitialized();
      return this.event_;
    }
    
    public Parser<DebugEvents> getParserForType()
    {
      return PARSER;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      int i = 0;
      if (this.event_ != null)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.event_.size()) {
            break;
          }
          i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.event_.get(j));
          j += 1;
        }
      }
      i = k + this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int i = 41;
      if (getEventCount() > 0) {
        i = 80454 + getEventList().hashCode();
      }
      return i * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DebugEvents");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      while (i < getEventCount())
      {
        if (!getEvent(i).isInitialized()) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    
    public DebugEvents mergeFrom(DebugEvents paramDebugEvents)
    {
      if (this == paramDebugEvents) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramDebugEvents == getDefaultInstance()) {
        return this;
      }
      if ((paramDebugEvents.event_ != null) && (!paramDebugEvents.event_.isEmpty()))
      {
        ensureEventInitialized();
        AbstractMutableMessageLite.addAll(paramDebugEvents.event_, this.event_);
      }
      this.unknownFields = this.unknownFields.concat(paramDebugEvents.unknownFields);
      return this;
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label103;
              }
              i = 1;
              break;
              paramCodedInputStream.readMessage(addEvent(), paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label103:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public DebugEvents newMessageForType()
    {
      return new DebugEvents();
    }
    
    public DebugEvents setEvent(int paramInt, MutableDebug.EventInfo paramEventInfo)
    {
      assertMutable();
      if (paramEventInfo == null) {
        throw new NullPointerException();
      }
      ensureEventInitialized();
      this.event_.set(paramInt, paramEventInfo);
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (this.event_ != null)
      {
        i = 0;
        while (i < this.event_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite)this.event_.get(i));
          i += 1;
        }
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != i - j) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
  
  public static final class EventInfo
    extends GeneratedMutableMessageLite<EventInfo>
    implements MutableMessageLite
  {
    public static final int CONTAINER_ID_FIELD_NUMBER = 3;
    public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
    public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int KEY_FIELD_NUMBER = 4;
    public static final int MACRO_RESULT_FIELD_NUMBER = 6;
    public static Parser<EventInfo> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    private static final EventInfo defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private Object containerId_ = Internal.EMPTY_BYTE_ARRAY;
    private Object containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
    private MutableDebug.DataLayerEventEvaluationInfo dataLayerEventResult_;
    private EventType eventType_ = EventType.DATA_LAYER_EVENT;
    private Object key_ = Internal.EMPTY_BYTE_ARRAY;
    private MutableDebug.MacroEvaluationInfo macroResult_;
    
    static
    {
      defaultInstance = new EventInfo(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private EventInfo()
    {
      initFields();
    }
    
    private EventInfo(boolean paramBoolean) {}
    
    private void ensureDataLayerEventResultInitialized()
    {
      if (this.dataLayerEventResult_ == MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
        this.dataLayerEventResult_ = MutableDebug.DataLayerEventEvaluationInfo.newMessage();
      }
    }
    
    private void ensureMacroResultInitialized()
    {
      if (this.macroResult_ == MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
        this.macroResult_ = MutableDebug.MacroEvaluationInfo.newMessage();
      }
    }
    
    public static EventInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.eventType_ = EventType.DATA_LAYER_EVENT;
      this.macroResult_ = MutableDebug.MacroEvaluationInfo.getDefaultInstance();
      this.dataLayerEventResult_ = MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance();
    }
    
    public static EventInfo newMessage()
    {
      return new EventInfo();
    }
    
    public EventInfo clear()
    {
      assertMutable();
      super.clear();
      this.eventType_ = EventType.DATA_LAYER_EVENT;
      this.bitField0_ &= 0xFFFFFFFE;
      this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
      this.bitField0_ &= 0xFFFFFFFD;
      this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
      this.bitField0_ &= 0xFFFFFFFB;
      this.key_ = Internal.EMPTY_BYTE_ARRAY;
      this.bitField0_ &= 0xFFFFFFF7;
      if (this.macroResult_ != MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
        this.macroResult_.clear();
      }
      this.bitField0_ &= 0xFFFFFFEF;
      if (this.dataLayerEventResult_ != MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
        this.dataLayerEventResult_.clear();
      }
      this.bitField0_ &= 0xFFFFFFDF;
      return this;
    }
    
    public EventInfo clearContainerId()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFB;
      this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
      return this;
    }
    
    public EventInfo clearContainerVersion()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFD;
      this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
      return this;
    }
    
    public EventInfo clearDataLayerEventResult()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFDF;
      if (this.dataLayerEventResult_ != MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
        this.dataLayerEventResult_.clear();
      }
      return this;
    }
    
    public EventInfo clearEventType()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      this.eventType_ = EventType.DATA_LAYER_EVENT;
      return this;
    }
    
    public EventInfo clearKey()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFF7;
      this.key_ = Internal.EMPTY_BYTE_ARRAY;
      return this;
    }
    
    public EventInfo clearMacroResult()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFEF;
      if (this.macroResult_ != MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
        this.macroResult_.clear();
      }
      return this;
    }
    
    public EventInfo clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof EventInfo)) {
        return super.equals(paramObject);
      }
      paramObject = (EventInfo)paramObject;
      int i;
      int j;
      label68:
      label85:
      label114:
      label131:
      label160:
      label177:
      label206:
      label223:
      label252:
      boolean bool1;
      if ((1 != 0) && (hasEventType() == ((EventInfo)paramObject).hasEventType()))
      {
        i = 1;
        j = i;
        if (hasEventType())
        {
          if ((i == 0) || (getEventType() != ((EventInfo)paramObject).getEventType())) {
            break label311;
          }
          j = 1;
        }
        if ((j == 0) || (hasContainerVersion() != ((EventInfo)paramObject).hasContainerVersion())) {
          break label316;
        }
        i = 1;
        j = i;
        if (hasContainerVersion())
        {
          if ((i == 0) || (!getContainerVersion().equals(((EventInfo)paramObject).getContainerVersion()))) {
            break label321;
          }
          j = 1;
        }
        if ((j == 0) || (hasContainerId() != ((EventInfo)paramObject).hasContainerId())) {
          break label326;
        }
        i = 1;
        j = i;
        if (hasContainerId())
        {
          if ((i == 0) || (!getContainerId().equals(((EventInfo)paramObject).getContainerId()))) {
            break label331;
          }
          j = 1;
        }
        if ((j == 0) || (hasKey() != ((EventInfo)paramObject).hasKey())) {
          break label336;
        }
        i = 1;
        j = i;
        if (hasKey())
        {
          if ((i == 0) || (!getKey().equals(((EventInfo)paramObject).getKey()))) {
            break label341;
          }
          j = 1;
        }
        if ((j == 0) || (hasMacroResult() != ((EventInfo)paramObject).hasMacroResult())) {
          break label346;
        }
        i = 1;
        j = i;
        if (hasMacroResult())
        {
          if ((i == 0) || (!getMacroResult().equals(((EventInfo)paramObject).getMacroResult()))) {
            break label351;
          }
          j = 1;
        }
        if ((j == 0) || (hasDataLayerEventResult() != ((EventInfo)paramObject).hasDataLayerEventResult())) {
          break label356;
        }
        bool1 = true;
        label270:
        bool2 = bool1;
        if (hasDataLayerEventResult()) {
          if ((!bool1) || (!getDataLayerEventResult().equals(((EventInfo)paramObject).getDataLayerEventResult()))) {
            break label362;
          }
        }
      }
      label311:
      label316:
      label321:
      label326:
      label331:
      label336:
      label341:
      label346:
      label351:
      label356:
      label362:
      for (boolean bool2 = true;; bool2 = false)
      {
        return bool2;
        i = 0;
        break;
        j = 0;
        break label68;
        i = 0;
        break label85;
        j = 0;
        break label114;
        i = 0;
        break label131;
        j = 0;
        break label160;
        i = 0;
        break label177;
        j = 0;
        break label206;
        i = 0;
        break label223;
        j = 0;
        break label252;
        bool1 = false;
        break label270;
      }
    }
    
    public String getContainerId()
    {
      Object localObject = this.containerId_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (byte[])localObject;
      String str = Internal.toStringUtf8((byte[])localObject);
      if (Internal.isValidUtf8((byte[])localObject)) {
        this.containerId_ = str;
      }
      return str;
    }
    
    public byte[] getContainerIdAsBytes()
    {
      Object localObject = this.containerId_;
      if ((localObject instanceof String))
      {
        localObject = Internal.toByteArray((String)localObject);
        this.containerId_ = localObject;
        return (byte[])localObject;
      }
      return (byte[])localObject;
    }
    
    public String getContainerVersion()
    {
      Object localObject = this.containerVersion_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (byte[])localObject;
      String str = Internal.toStringUtf8((byte[])localObject);
      if (Internal.isValidUtf8((byte[])localObject)) {
        this.containerVersion_ = str;
      }
      return str;
    }
    
    public byte[] getContainerVersionAsBytes()
    {
      Object localObject = this.containerVersion_;
      if ((localObject instanceof String))
      {
        localObject = Internal.toByteArray((String)localObject);
        this.containerVersion_ = localObject;
        return (byte[])localObject;
      }
      return (byte[])localObject;
    }
    
    public MutableDebug.DataLayerEventEvaluationInfo getDataLayerEventResult()
    {
      return this.dataLayerEventResult_;
    }
    
    public final EventInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public EventType getEventType()
    {
      return this.eventType_;
    }
    
    public String getKey()
    {
      Object localObject = this.key_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (byte[])localObject;
      String str = Internal.toStringUtf8((byte[])localObject);
      if (Internal.isValidUtf8((byte[])localObject)) {
        this.key_ = str;
      }
      return str;
    }
    
    public byte[] getKeyAsBytes()
    {
      Object localObject = this.key_;
      if ((localObject instanceof String))
      {
        localObject = Internal.toByteArray((String)localObject);
        this.key_ = localObject;
        return (byte[])localObject;
      }
      return (byte[])localObject;
    }
    
    public MutableDebug.MacroEvaluationInfo getMacroResult()
    {
      return this.macroResult_;
    }
    
    public MutableDebug.DataLayerEventEvaluationInfo getMutableDataLayerEventResult()
    {
      assertMutable();
      ensureDataLayerEventResultInitialized();
      this.bitField0_ |= 0x20;
      return this.dataLayerEventResult_;
    }
    
    public MutableDebug.MacroEvaluationInfo getMutableMacroResult()
    {
      assertMutable();
      ensureMacroResultInitialized();
      this.bitField0_ |= 0x10;
      return this.macroResult_;
    }
    
    public Parser<EventInfo> getParserForType()
    {
      return PARSER;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeEnumSize(1, this.eventType_.getNumber());
      }
      int i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeByteArraySize(2, getContainerVersionAsBytes());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeByteArraySize(3, getContainerIdAsBytes());
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeByteArraySize(4, getKeyAsBytes());
      }
      j = i;
      if ((this.bitField0_ & 0x10) == 16) {
        j = i + CodedOutputStream.computeMessageSize(6, this.macroResult_);
      }
      i = j;
      if ((this.bitField0_ & 0x20) == 32) {
        i = j + CodedOutputStream.computeMessageSize(7, this.dataLayerEventResult_);
      }
      i += this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public boolean hasContainerId()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasContainerVersion()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasDataLayerEventResult()
    {
      return (this.bitField0_ & 0x20) == 32;
    }
    
    public boolean hasEventType()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasKey()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasMacroResult()
    {
      return (this.bitField0_ & 0x10) == 16;
    }
    
    public int hashCode()
    {
      int j = 41;
      if (hasEventType()) {
        j = 80454 + Internal.hashEnum(getEventType());
      }
      int i = j;
      if (hasContainerVersion()) {
        i = (j * 37 + 2) * 53 + getContainerVersion().hashCode();
      }
      j = i;
      if (hasContainerId()) {
        j = (i * 37 + 3) * 53 + getContainerId().hashCode();
      }
      i = j;
      if (hasKey()) {
        i = (j * 37 + 4) * 53 + getKey().hashCode();
      }
      j = i;
      if (hasMacroResult()) {
        j = (i * 37 + 6) * 53 + getMacroResult().hashCode();
      }
      i = j;
      if (hasDataLayerEventResult()) {
        i = (j * 37 + 7) * 53 + getDataLayerEventResult().hashCode();
      }
      return i * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$EventInfo");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      if ((hasMacroResult()) && (!getMacroResult().isInitialized())) {}
      while ((hasDataLayerEventResult()) && (!getDataLayerEventResult().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public EventInfo mergeFrom(EventInfo paramEventInfo)
    {
      if (this == paramEventInfo) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramEventInfo == getDefaultInstance()) {
        return this;
      }
      if (paramEventInfo.hasEventType()) {
        setEventType(paramEventInfo.getEventType());
      }
      if (paramEventInfo.hasContainerVersion())
      {
        this.bitField0_ |= 0x2;
        if ((paramEventInfo.containerVersion_ instanceof String)) {
          this.containerVersion_ = paramEventInfo.containerVersion_;
        }
      }
      else
      {
        if (paramEventInfo.hasContainerId())
        {
          this.bitField0_ |= 0x4;
          if (!(paramEventInfo.containerId_ instanceof String)) {
            break label260;
          }
          this.containerId_ = paramEventInfo.containerId_;
        }
        label115:
        if (paramEventInfo.hasKey())
        {
          this.bitField0_ |= 0x8;
          if (!(paramEventInfo.key_ instanceof String)) {
            break label284;
          }
        }
      }
      byte[] arrayOfByte;
      for (this.key_ = paramEventInfo.key_;; this.key_ = Arrays.copyOf(arrayOfByte, arrayOfByte.length))
      {
        if (paramEventInfo.hasMacroResult())
        {
          ensureMacroResultInitialized();
          this.macroResult_.mergeFrom(paramEventInfo.getMacroResult());
          this.bitField0_ |= 0x10;
        }
        if (paramEventInfo.hasDataLayerEventResult())
        {
          ensureDataLayerEventResultInitialized();
          this.dataLayerEventResult_.mergeFrom(paramEventInfo.getDataLayerEventResult());
          this.bitField0_ |= 0x20;
        }
        this.unknownFields = this.unknownFields.concat(paramEventInfo.unknownFields);
        return this;
        arrayOfByte = (byte[])paramEventInfo.containerVersion_;
        this.containerVersion_ = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
        break;
        label260:
        arrayOfByte = (byte[])paramEventInfo.containerId_;
        this.containerId_ = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
        break label115;
        label284:
        arrayOfByte = (byte[])paramEventInfo.key_;
      }
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 8: 
          case 18: 
          case 26: 
          case 34: 
          case 50: 
          case 58: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label329;
              }
              i = 1;
              break;
              int k = paramCodedInputStream.readEnum();
              EventType localEventType = EventType.valueOf(k);
              if (localEventType == null)
              {
                localCodedOutputStream.writeRawVarint32(j);
                localCodedOutputStream.writeRawVarint32(k);
                break;
              }
              this.bitField0_ |= 0x1;
              this.eventType_ = localEventType;
              break;
              this.bitField0_ |= 0x2;
              this.containerVersion_ = paramCodedInputStream.readByteArray();
              break;
              this.bitField0_ |= 0x4;
              this.containerId_ = paramCodedInputStream.readByteArray();
              break;
              this.bitField0_ |= 0x8;
              this.key_ = paramCodedInputStream.readByteArray();
              break;
              if (this.macroResult_ == MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
                this.macroResult_ = MutableDebug.MacroEvaluationInfo.newMessage();
              }
              this.bitField0_ |= 0x10;
              paramCodedInputStream.readMessage(this.macroResult_, paramExtensionRegistryLite);
              break;
              if (this.dataLayerEventResult_ == MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
                this.dataLayerEventResult_ = MutableDebug.DataLayerEventEvaluationInfo.newMessage();
              }
              this.bitField0_ |= 0x20;
              paramCodedInputStream.readMessage(this.dataLayerEventResult_, paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label329:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public EventInfo newMessageForType()
    {
      return new EventInfo();
    }
    
    public EventInfo setContainerId(String paramString)
    {
      assertMutable();
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.containerId_ = paramString;
      return this;
    }
    
    public EventInfo setContainerIdAsBytes(byte[] paramArrayOfByte)
    {
      assertMutable();
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.containerId_ = paramArrayOfByte;
      return this;
    }
    
    public EventInfo setContainerVersion(String paramString)
    {
      assertMutable();
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.containerVersion_ = paramString;
      return this;
    }
    
    public EventInfo setContainerVersionAsBytes(byte[] paramArrayOfByte)
    {
      assertMutable();
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.containerVersion_ = paramArrayOfByte;
      return this;
    }
    
    public EventInfo setDataLayerEventResult(MutableDebug.DataLayerEventEvaluationInfo paramDataLayerEventEvaluationInfo)
    {
      assertMutable();
      if (paramDataLayerEventEvaluationInfo == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x20;
      this.dataLayerEventResult_ = paramDataLayerEventEvaluationInfo;
      return this;
    }
    
    public EventInfo setEventType(EventType paramEventType)
    {
      assertMutable();
      if (paramEventType == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.eventType_ = paramEventType;
      return this;
    }
    
    public EventInfo setKey(String paramString)
    {
      assertMutable();
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x8;
      this.key_ = paramString;
      return this;
    }
    
    public EventInfo setKeyAsBytes(byte[] paramArrayOfByte)
    {
      assertMutable();
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x8;
      this.key_ = paramArrayOfByte;
      return this;
    }
    
    public EventInfo setMacroResult(MutableDebug.MacroEvaluationInfo paramMacroEvaluationInfo)
    {
      assertMutable();
      if (paramMacroEvaluationInfo == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x10;
      this.macroResult_ = paramMacroEvaluationInfo;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeEnum(1, this.eventType_.getNumber());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeByteArray(2, getContainerVersionAsBytes());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeByteArray(3, getContainerIdAsBytes());
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeByteArray(4, getKeyAsBytes());
      }
      if ((this.bitField0_ & 0x10) == 16) {
        paramCodedOutputStream.writeMessageWithCachedSizes(6, this.macroResult_);
      }
      if ((this.bitField0_ & 0x20) == 32) {
        paramCodedOutputStream.writeMessageWithCachedSizes(7, this.dataLayerEventResult_);
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != j - i) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
    
    public static enum EventType
      implements Internal.EnumLite
    {
      DATA_LAYER_EVENT(0, 1),  MACRO_REFERENCE(1, 2);
      
      public static final int DATA_LAYER_EVENT_VALUE = 1;
      public static final int MACRO_REFERENCE_VALUE = 2;
      private static Internal.EnumLiteMap<EventType> internalValueMap = new Internal.EnumLiteMap()
      {
        public MutableDebug.EventInfo.EventType findValueByNumber(int paramAnonymousInt)
        {
          return MutableDebug.EventInfo.EventType.valueOf(paramAnonymousInt);
        }
      };
      private final int value;
      
      private EventType(int paramInt1, int paramInt2)
      {
        this.value = paramInt2;
      }
      
      public static Internal.EnumLiteMap<EventType> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static EventType valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return DATA_LAYER_EVENT;
        }
        return MACRO_REFERENCE;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static final class MacroEvaluationInfo
    extends GeneratedMutableMessageLite<MacroEvaluationInfo>
    implements MutableMessageLite
  {
    public static final int MACRO_FIELD_NUMBER = 47497405;
    public static Parser<MacroEvaluationInfo> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int RESULT_FIELD_NUMBER = 3;
    public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
    private static final MacroEvaluationInfo defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    public static final GeneratedMessageLite.GeneratedExtension<MutableTypeSystem.Value, MacroEvaluationInfo> macro = GeneratedMessageLite.newSingularGeneratedExtension(MutableTypeSystem.Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 47497405, WireFormat.FieldType.MESSAGE, MacroEvaluationInfo.class);
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private MutableDebug.ResolvedFunctionCall result_;
    private MutableDebug.RuleEvaluationStepInfo rulesEvaluation_;
    
    static
    {
      defaultInstance = new MacroEvaluationInfo(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private MacroEvaluationInfo()
    {
      initFields();
    }
    
    private MacroEvaluationInfo(boolean paramBoolean) {}
    
    private void ensureResultInitialized()
    {
      if (this.result_ == MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
        this.result_ = MutableDebug.ResolvedFunctionCall.newMessage();
      }
    }
    
    private void ensureRulesEvaluationInitialized()
    {
      if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
        this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
      }
    }
    
    public static MacroEvaluationInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.getDefaultInstance();
      this.result_ = MutableDebug.ResolvedFunctionCall.getDefaultInstance();
    }
    
    public static MacroEvaluationInfo newMessage()
    {
      return new MacroEvaluationInfo();
    }
    
    public MacroEvaluationInfo clear()
    {
      assertMutable();
      super.clear();
      if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
        this.rulesEvaluation_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.result_ != MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
        this.result_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFD;
      return this;
    }
    
    public MacroEvaluationInfo clearResult()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFD;
      if (this.result_ != MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
        this.result_.clear();
      }
      return this;
    }
    
    public MacroEvaluationInfo clearRulesEvaluation()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
        this.rulesEvaluation_.clear();
      }
      return this;
    }
    
    public MacroEvaluationInfo clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof MacroEvaluationInfo)) {
        return super.equals(paramObject);
      }
      paramObject = (MacroEvaluationInfo)paramObject;
      int i;
      int j;
      label71:
      boolean bool1;
      if ((1 != 0) && (hasRulesEvaluation() == ((MacroEvaluationInfo)paramObject).hasRulesEvaluation()))
      {
        i = 1;
        j = i;
        if (hasRulesEvaluation())
        {
          if ((i == 0) || (!getRulesEvaluation().equals(((MacroEvaluationInfo)paramObject).getRulesEvaluation()))) {
            break label130;
          }
          j = 1;
        }
        if ((j == 0) || (hasResult() != ((MacroEvaluationInfo)paramObject).hasResult())) {
          break label135;
        }
        bool1 = true;
        label89:
        bool2 = bool1;
        if (hasResult()) {
          if ((!bool1) || (!getResult().equals(((MacroEvaluationInfo)paramObject).getResult()))) {
            break label141;
          }
        }
      }
      label130:
      label135:
      label141:
      for (boolean bool2 = true;; bool2 = false)
      {
        return bool2;
        i = 0;
        break;
        j = 0;
        break label71;
        bool1 = false;
        break label89;
      }
    }
    
    public final MacroEvaluationInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableResult()
    {
      assertMutable();
      ensureResultInitialized();
      this.bitField0_ |= 0x2;
      return this.result_;
    }
    
    public MutableDebug.RuleEvaluationStepInfo getMutableRulesEvaluation()
    {
      assertMutable();
      ensureRulesEvaluationInitialized();
      this.bitField0_ |= 0x1;
      return this.rulesEvaluation_;
    }
    
    public Parser<MacroEvaluationInfo> getParserForType()
    {
      return PARSER;
    }
    
    public MutableDebug.ResolvedFunctionCall getResult()
    {
      return this.result_;
    }
    
    public MutableDebug.RuleEvaluationStepInfo getRulesEvaluation()
    {
      return this.rulesEvaluation_;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeMessageSize(1, this.rulesEvaluation_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(3, this.result_);
      }
      i = j + this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public boolean hasResult()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasRulesEvaluation()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public int hashCode()
    {
      int i = 41;
      if (hasRulesEvaluation()) {
        i = 80454 + getRulesEvaluation().hashCode();
      }
      int j = i;
      if (hasResult()) {
        j = (i * 37 + 3) * 53 + getResult().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$MacroEvaluationInfo");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      if ((hasRulesEvaluation()) && (!getRulesEvaluation().isInitialized())) {}
      while ((hasResult()) && (!getResult().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public MacroEvaluationInfo mergeFrom(MacroEvaluationInfo paramMacroEvaluationInfo)
    {
      if (this == paramMacroEvaluationInfo) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramMacroEvaluationInfo == getDefaultInstance()) {
        return this;
      }
      if (paramMacroEvaluationInfo.hasRulesEvaluation())
      {
        ensureRulesEvaluationInitialized();
        this.rulesEvaluation_.mergeFrom(paramMacroEvaluationInfo.getRulesEvaluation());
        this.bitField0_ |= 0x1;
      }
      if (paramMacroEvaluationInfo.hasResult())
      {
        ensureResultInitialized();
        this.result_.mergeFrom(paramMacroEvaluationInfo.getResult());
        this.bitField0_ |= 0x2;
      }
      this.unknownFields = this.unknownFields.concat(paramMacroEvaluationInfo.unknownFields);
      return this;
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          case 26: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label177;
              }
              i = 1;
              break;
              if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
              }
              this.bitField0_ |= 0x1;
              paramCodedInputStream.readMessage(this.rulesEvaluation_, paramExtensionRegistryLite);
              break;
              if (this.result_ == MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
                this.result_ = MutableDebug.ResolvedFunctionCall.newMessage();
              }
              this.bitField0_ |= 0x2;
              paramCodedInputStream.readMessage(this.result_, paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label177:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public MacroEvaluationInfo newMessageForType()
    {
      return new MacroEvaluationInfo();
    }
    
    public MacroEvaluationInfo setResult(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.result_ = paramResolvedFunctionCall;
      return this;
    }
    
    public MacroEvaluationInfo setRulesEvaluation(MutableDebug.RuleEvaluationStepInfo paramRuleEvaluationStepInfo)
    {
      assertMutable();
      if (paramRuleEvaluationStepInfo == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.rulesEvaluation_ = paramRuleEvaluationStepInfo;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessageWithCachedSizes(1, this.rulesEvaluation_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessageWithCachedSizes(3, this.result_);
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != j - i) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
  
  public static final class ResolvedFunctionCall
    extends GeneratedMutableMessageLite<ResolvedFunctionCall>
    implements MutableMessageLite
  {
    public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
    public static Parser<ResolvedFunctionCall> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int PROPERTIES_FIELD_NUMBER = 1;
    public static final int RESULT_FIELD_NUMBER = 2;
    private static final ResolvedFunctionCall defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private Object associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
    private int bitField0_;
    private List<MutableDebug.ResolvedProperty> properties_ = null;
    private MutableTypeSystem.Value result_;
    
    static
    {
      defaultInstance = new ResolvedFunctionCall(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private ResolvedFunctionCall()
    {
      initFields();
    }
    
    private ResolvedFunctionCall(boolean paramBoolean) {}
    
    private void ensurePropertiesInitialized()
    {
      if (this.properties_ == null) {
        this.properties_ = new ArrayList();
      }
    }
    
    private void ensureResultInitialized()
    {
      if (this.result_ == MutableTypeSystem.Value.getDefaultInstance()) {
        this.result_ = MutableTypeSystem.Value.newMessage();
      }
    }
    
    public static ResolvedFunctionCall getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.result_ = MutableTypeSystem.Value.getDefaultInstance();
    }
    
    public static ResolvedFunctionCall newMessage()
    {
      return new ResolvedFunctionCall();
    }
    
    public ResolvedFunctionCall addAllProperties(Iterable<? extends MutableDebug.ResolvedProperty> paramIterable)
    {
      assertMutable();
      ensurePropertiesInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.properties_);
      return this;
    }
    
    public ResolvedFunctionCall addProperties(MutableDebug.ResolvedProperty paramResolvedProperty)
    {
      assertMutable();
      if (paramResolvedProperty == null) {
        throw new NullPointerException();
      }
      ensurePropertiesInitialized();
      this.properties_.add(paramResolvedProperty);
      return this;
    }
    
    public MutableDebug.ResolvedProperty addProperties()
    {
      assertMutable();
      ensurePropertiesInitialized();
      MutableDebug.ResolvedProperty localResolvedProperty = MutableDebug.ResolvedProperty.newMessage();
      this.properties_.add(localResolvedProperty);
      return localResolvedProperty;
    }
    
    public ResolvedFunctionCall clear()
    {
      assertMutable();
      super.clear();
      this.properties_ = null;
      if (this.result_ != MutableTypeSystem.Value.getDefaultInstance()) {
        this.result_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFE;
      this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
      this.bitField0_ &= 0xFFFFFFFD;
      return this;
    }
    
    public ResolvedFunctionCall clearAssociatedRuleName()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFD;
      this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
      return this;
    }
    
    public ResolvedFunctionCall clearProperties()
    {
      assertMutable();
      this.properties_ = null;
      return this;
    }
    
    public ResolvedFunctionCall clearResult()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.result_ != MutableTypeSystem.Value.getDefaultInstance()) {
        this.result_.clear();
      }
      return this;
    }
    
    public ResolvedFunctionCall clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof ResolvedFunctionCall)) {
        return super.equals(paramObject);
      }
      paramObject = (ResolvedFunctionCall)paramObject;
      int i;
      label64:
      int j;
      label93:
      boolean bool1;
      if ((1 != 0) && (getPropertiesList().equals(((ResolvedFunctionCall)paramObject).getPropertiesList())))
      {
        i = 1;
        if ((i == 0) || (hasResult() != ((ResolvedFunctionCall)paramObject).hasResult())) {
          break label152;
        }
        i = 1;
        j = i;
        if (hasResult())
        {
          if ((i == 0) || (!getResult().equals(((ResolvedFunctionCall)paramObject).getResult()))) {
            break label157;
          }
          j = 1;
        }
        if ((j == 0) || (hasAssociatedRuleName() != ((ResolvedFunctionCall)paramObject).hasAssociatedRuleName())) {
          break label162;
        }
        bool1 = true;
        label111:
        bool2 = bool1;
        if (hasAssociatedRuleName()) {
          if ((!bool1) || (!getAssociatedRuleName().equals(((ResolvedFunctionCall)paramObject).getAssociatedRuleName()))) {
            break label168;
          }
        }
      }
      label152:
      label157:
      label162:
      label168:
      for (boolean bool2 = true;; bool2 = false)
      {
        return bool2;
        i = 0;
        break;
        i = 0;
        break label64;
        j = 0;
        break label93;
        bool1 = false;
        break label111;
      }
    }
    
    public String getAssociatedRuleName()
    {
      Object localObject = this.associatedRuleName_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (byte[])localObject;
      String str = Internal.toStringUtf8((byte[])localObject);
      if (Internal.isValidUtf8((byte[])localObject)) {
        this.associatedRuleName_ = str;
      }
      return str;
    }
    
    public byte[] getAssociatedRuleNameAsBytes()
    {
      Object localObject = this.associatedRuleName_;
      if ((localObject instanceof String))
      {
        localObject = Internal.toByteArray((String)localObject);
        this.associatedRuleName_ = localObject;
        return (byte[])localObject;
      }
      return (byte[])localObject;
    }
    
    public final ResolvedFunctionCall getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableDebug.ResolvedProperty getMutableProperties(int paramInt)
    {
      return (MutableDebug.ResolvedProperty)this.properties_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedProperty> getMutablePropertiesList()
    {
      assertMutable();
      ensurePropertiesInitialized();
      return this.properties_;
    }
    
    public MutableTypeSystem.Value getMutableResult()
    {
      assertMutable();
      ensureResultInitialized();
      this.bitField0_ |= 0x1;
      return this.result_;
    }
    
    public Parser<ResolvedFunctionCall> getParserForType()
    {
      return PARSER;
    }
    
    public MutableDebug.ResolvedProperty getProperties(int paramInt)
    {
      return (MutableDebug.ResolvedProperty)this.properties_.get(paramInt);
    }
    
    public int getPropertiesCount()
    {
      if (this.properties_ == null) {
        return 0;
      }
      return this.properties_.size();
    }
    
    public List<MutableDebug.ResolvedProperty> getPropertiesList()
    {
      if (this.properties_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.properties_);
    }
    
    public MutableTypeSystem.Value getResult()
    {
      return this.result_;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      if (this.properties_ != null)
      {
        int k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.properties_.size()) {
            break;
          }
          j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.properties_.get(k));
          k += 1;
        }
      }
      j = i;
      if ((this.bitField0_ & 0x1) == 1) {
        j = i + CodedOutputStream.computeMessageSize(2, this.result_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeByteArraySize(3, getAssociatedRuleNameAsBytes());
      }
      i += this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public boolean hasAssociatedRuleName()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasResult()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public int hashCode()
    {
      int j = 41;
      if (getPropertiesCount() > 0) {
        j = 80454 + getPropertiesList().hashCode();
      }
      int i = j;
      if (hasResult()) {
        i = (j * 37 + 2) * 53 + getResult().hashCode();
      }
      j = i;
      if (hasAssociatedRuleName()) {
        j = (i * 37 + 3) * 53 + getAssociatedRuleName().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedFunctionCall");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      if (i < getPropertiesCount()) {
        if (getProperties(i).isInitialized()) {}
      }
      while ((hasResult()) && (!getResult().isInitialized()))
      {
        return false;
        i += 1;
        break;
      }
      return true;
    }
    
    public ResolvedFunctionCall mergeFrom(ResolvedFunctionCall paramResolvedFunctionCall)
    {
      if (this == paramResolvedFunctionCall) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramResolvedFunctionCall == getDefaultInstance()) {
        return this;
      }
      if ((paramResolvedFunctionCall.properties_ != null) && (!paramResolvedFunctionCall.properties_.isEmpty()))
      {
        ensurePropertiesInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedFunctionCall.properties_, this.properties_);
      }
      if (paramResolvedFunctionCall.hasResult())
      {
        ensureResultInitialized();
        this.result_.mergeFrom(paramResolvedFunctionCall.getResult());
        this.bitField0_ |= 0x1;
      }
      if (paramResolvedFunctionCall.hasAssociatedRuleName())
      {
        this.bitField0_ |= 0x2;
        if (!(paramResolvedFunctionCall.associatedRuleName_ instanceof String)) {
          break label148;
        }
      }
      label148:
      byte[] arrayOfByte;
      for (this.associatedRuleName_ = paramResolvedFunctionCall.associatedRuleName_;; this.associatedRuleName_ = Arrays.copyOf(arrayOfByte, arrayOfByte.length))
      {
        this.unknownFields = this.unknownFields.concat(paramResolvedFunctionCall.unknownFields);
        return this;
        arrayOfByte = (byte[])paramResolvedFunctionCall.associatedRuleName_;
      }
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          case 18: 
          case 26: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label179;
              }
              i = 1;
              break;
              paramCodedInputStream.readMessage(addProperties(), paramExtensionRegistryLite);
              break;
              if (this.result_ == MutableTypeSystem.Value.getDefaultInstance()) {
                this.result_ = MutableTypeSystem.Value.newMessage();
              }
              this.bitField0_ |= 0x1;
              paramCodedInputStream.readMessage(this.result_, paramExtensionRegistryLite);
              break;
              this.bitField0_ |= 0x2;
              this.associatedRuleName_ = paramCodedInputStream.readByteArray();
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label179:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public ResolvedFunctionCall newMessageForType()
    {
      return new ResolvedFunctionCall();
    }
    
    public ResolvedFunctionCall setAssociatedRuleName(String paramString)
    {
      assertMutable();
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.associatedRuleName_ = paramString;
      return this;
    }
    
    public ResolvedFunctionCall setAssociatedRuleNameAsBytes(byte[] paramArrayOfByte)
    {
      assertMutable();
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.associatedRuleName_ = paramArrayOfByte;
      return this;
    }
    
    public ResolvedFunctionCall setProperties(int paramInt, MutableDebug.ResolvedProperty paramResolvedProperty)
    {
      assertMutable();
      if (paramResolvedProperty == null) {
        throw new NullPointerException();
      }
      ensurePropertiesInitialized();
      this.properties_.set(paramInt, paramResolvedProperty);
      return this;
    }
    
    public ResolvedFunctionCall setResult(MutableTypeSystem.Value paramValue)
    {
      assertMutable();
      if (paramValue == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.result_ = paramValue;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (this.properties_ != null)
      {
        i = 0;
        while (i < this.properties_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite)this.properties_.get(i));
          i += 1;
        }
      }
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessageWithCachedSizes(2, this.result_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeByteArray(3, getAssociatedRuleNameAsBytes());
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != i - j) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
  
  public static final class ResolvedProperty
    extends GeneratedMutableMessageLite<ResolvedProperty>
    implements MutableMessageLite
  {
    public static final int KEY_FIELD_NUMBER = 1;
    public static Parser<ResolvedProperty> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final ResolvedProperty defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private Object key_ = Internal.EMPTY_BYTE_ARRAY;
    private MutableTypeSystem.Value value_;
    
    static
    {
      defaultInstance = new ResolvedProperty(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private ResolvedProperty()
    {
      initFields();
    }
    
    private ResolvedProperty(boolean paramBoolean) {}
    
    private void ensureValueInitialized()
    {
      if (this.value_ == MutableTypeSystem.Value.getDefaultInstance()) {
        this.value_ = MutableTypeSystem.Value.newMessage();
      }
    }
    
    public static ResolvedProperty getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.value_ = MutableTypeSystem.Value.getDefaultInstance();
    }
    
    public static ResolvedProperty newMessage()
    {
      return new ResolvedProperty();
    }
    
    public ResolvedProperty clear()
    {
      assertMutable();
      super.clear();
      this.key_ = Internal.EMPTY_BYTE_ARRAY;
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.value_ != MutableTypeSystem.Value.getDefaultInstance()) {
        this.value_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFD;
      return this;
    }
    
    public ResolvedProperty clearKey()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      this.key_ = Internal.EMPTY_BYTE_ARRAY;
      return this;
    }
    
    public ResolvedProperty clearValue()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFD;
      if (this.value_ != MutableTypeSystem.Value.getDefaultInstance()) {
        this.value_.clear();
      }
      return this;
    }
    
    public ResolvedProperty clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof ResolvedProperty)) {
        return super.equals(paramObject);
      }
      paramObject = (ResolvedProperty)paramObject;
      int i;
      int j;
      label71:
      boolean bool1;
      if ((1 != 0) && (hasKey() == ((ResolvedProperty)paramObject).hasKey()))
      {
        i = 1;
        j = i;
        if (hasKey())
        {
          if ((i == 0) || (!getKey().equals(((ResolvedProperty)paramObject).getKey()))) {
            break label130;
          }
          j = 1;
        }
        if ((j == 0) || (hasValue() != ((ResolvedProperty)paramObject).hasValue())) {
          break label135;
        }
        bool1 = true;
        label89:
        bool2 = bool1;
        if (hasValue()) {
          if ((!bool1) || (!getValue().equals(((ResolvedProperty)paramObject).getValue()))) {
            break label141;
          }
        }
      }
      label130:
      label135:
      label141:
      for (boolean bool2 = true;; bool2 = false)
      {
        return bool2;
        i = 0;
        break;
        j = 0;
        break label71;
        bool1 = false;
        break label89;
      }
    }
    
    public final ResolvedProperty getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getKey()
    {
      Object localObject = this.key_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (byte[])localObject;
      String str = Internal.toStringUtf8((byte[])localObject);
      if (Internal.isValidUtf8((byte[])localObject)) {
        this.key_ = str;
      }
      return str;
    }
    
    public byte[] getKeyAsBytes()
    {
      Object localObject = this.key_;
      if ((localObject instanceof String))
      {
        localObject = Internal.toByteArray((String)localObject);
        this.key_ = localObject;
        return (byte[])localObject;
      }
      return (byte[])localObject;
    }
    
    public MutableTypeSystem.Value getMutableValue()
    {
      assertMutable();
      ensureValueInitialized();
      this.bitField0_ |= 0x2;
      return this.value_;
    }
    
    public Parser<ResolvedProperty> getParserForType()
    {
      return PARSER;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeByteArraySize(1, getKeyAsBytes());
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(2, this.value_);
      }
      i = j + this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public MutableTypeSystem.Value getValue()
    {
      return this.value_;
    }
    
    public boolean hasKey()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasValue()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public int hashCode()
    {
      int i = 41;
      if (hasKey()) {
        i = 80454 + getKey().hashCode();
      }
      int j = i;
      if (hasValue()) {
        j = (i * 37 + 2) * 53 + getValue().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedProperty");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      return (!hasValue()) || (getValue().isInitialized());
    }
    
    public ResolvedProperty mergeFrom(ResolvedProperty paramResolvedProperty)
    {
      if (this == paramResolvedProperty) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramResolvedProperty == getDefaultInstance()) {
        return this;
      }
      if (paramResolvedProperty.hasKey())
      {
        this.bitField0_ |= 0x1;
        if (!(paramResolvedProperty.key_ instanceof String)) {
          break label113;
        }
      }
      label113:
      byte[] arrayOfByte;
      for (this.key_ = paramResolvedProperty.key_;; this.key_ = Arrays.copyOf(arrayOfByte, arrayOfByte.length))
      {
        if (paramResolvedProperty.hasValue())
        {
          ensureValueInitialized();
          this.value_.mergeFrom(paramResolvedProperty.getValue());
          this.bitField0_ |= 0x2;
        }
        this.unknownFields = this.unknownFields.concat(paramResolvedProperty.unknownFields);
        return this;
        arrayOfByte = (byte[])paramResolvedProperty.key_;
      }
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          case 18: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label159;
              }
              i = 1;
              break;
              this.bitField0_ |= 0x1;
              this.key_ = paramCodedInputStream.readByteArray();
              break;
              if (this.value_ == MutableTypeSystem.Value.getDefaultInstance()) {
                this.value_ = MutableTypeSystem.Value.newMessage();
              }
              this.bitField0_ |= 0x2;
              paramCodedInputStream.readMessage(this.value_, paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label159:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public ResolvedProperty newMessageForType()
    {
      return new ResolvedProperty();
    }
    
    public ResolvedProperty setKey(String paramString)
    {
      assertMutable();
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.key_ = paramString;
      return this;
    }
    
    public ResolvedProperty setKeyAsBytes(byte[] paramArrayOfByte)
    {
      assertMutable();
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.key_ = paramArrayOfByte;
      return this;
    }
    
    public ResolvedProperty setValue(MutableTypeSystem.Value paramValue)
    {
      assertMutable();
      if (paramValue == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.value_ = paramValue;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeByteArray(1, getKeyAsBytes());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessageWithCachedSizes(2, this.value_);
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != j - i) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
  
  public static final class ResolvedRule
    extends GeneratedMutableMessageLite<ResolvedRule>
    implements MutableMessageLite
  {
    public static final int ADD_MACROS_FIELD_NUMBER = 5;
    public static final int ADD_TAGS_FIELD_NUMBER = 3;
    public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
    public static Parser<ResolvedRule> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
    public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
    public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
    public static final int RESULT_FIELD_NUMBER = 7;
    private static final ResolvedRule defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private List<MutableDebug.ResolvedFunctionCall> addMacros_ = null;
    private List<MutableDebug.ResolvedFunctionCall> addTags_ = null;
    private int bitField0_;
    private List<MutableDebug.ResolvedFunctionCall> negativePredicates_ = null;
    private List<MutableDebug.ResolvedFunctionCall> positivePredicates_ = null;
    private List<MutableDebug.ResolvedFunctionCall> removeMacros_ = null;
    private List<MutableDebug.ResolvedFunctionCall> removeTags_ = null;
    private MutableTypeSystem.Value result_;
    
    static
    {
      defaultInstance = new ResolvedRule(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private ResolvedRule()
    {
      initFields();
    }
    
    private ResolvedRule(boolean paramBoolean) {}
    
    private void ensureAddMacrosInitialized()
    {
      if (this.addMacros_ == null) {
        this.addMacros_ = new ArrayList();
      }
    }
    
    private void ensureAddTagsInitialized()
    {
      if (this.addTags_ == null) {
        this.addTags_ = new ArrayList();
      }
    }
    
    private void ensureNegativePredicatesInitialized()
    {
      if (this.negativePredicates_ == null) {
        this.negativePredicates_ = new ArrayList();
      }
    }
    
    private void ensurePositivePredicatesInitialized()
    {
      if (this.positivePredicates_ == null) {
        this.positivePredicates_ = new ArrayList();
      }
    }
    
    private void ensureRemoveMacrosInitialized()
    {
      if (this.removeMacros_ == null) {
        this.removeMacros_ = new ArrayList();
      }
    }
    
    private void ensureRemoveTagsInitialized()
    {
      if (this.removeTags_ == null) {
        this.removeTags_ = new ArrayList();
      }
    }
    
    private void ensureResultInitialized()
    {
      if (this.result_ == MutableTypeSystem.Value.getDefaultInstance()) {
        this.result_ = MutableTypeSystem.Value.newMessage();
      }
    }
    
    public static ResolvedRule getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.result_ = MutableTypeSystem.Value.getDefaultInstance();
    }
    
    public static ResolvedRule newMessage()
    {
      return new ResolvedRule();
    }
    
    public MutableDebug.ResolvedFunctionCall addAddMacros()
    {
      assertMutable();
      ensureAddMacrosInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.addMacros_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public ResolvedRule addAddMacros(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureAddMacrosInitialized();
      this.addMacros_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addAddTags()
    {
      assertMutable();
      ensureAddTagsInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.addTags_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public ResolvedRule addAddTags(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureAddTagsInitialized();
      this.addTags_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule addAllAddMacros(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureAddMacrosInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.addMacros_);
      return this;
    }
    
    public ResolvedRule addAllAddTags(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureAddTagsInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.addTags_);
      return this;
    }
    
    public ResolvedRule addAllNegativePredicates(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureNegativePredicatesInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.negativePredicates_);
      return this;
    }
    
    public ResolvedRule addAllPositivePredicates(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensurePositivePredicatesInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.positivePredicates_);
      return this;
    }
    
    public ResolvedRule addAllRemoveMacros(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureRemoveMacrosInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.removeMacros_);
      return this;
    }
    
    public ResolvedRule addAllRemoveTags(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureRemoveTagsInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.removeTags_);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addNegativePredicates()
    {
      assertMutable();
      ensureNegativePredicatesInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.negativePredicates_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public ResolvedRule addNegativePredicates(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureNegativePredicatesInitialized();
      this.negativePredicates_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addPositivePredicates()
    {
      assertMutable();
      ensurePositivePredicatesInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.positivePredicates_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public ResolvedRule addPositivePredicates(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensurePositivePredicatesInitialized();
      this.positivePredicates_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addRemoveMacros()
    {
      assertMutable();
      ensureRemoveMacrosInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.removeMacros_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public ResolvedRule addRemoveMacros(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureRemoveMacrosInitialized();
      this.removeMacros_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addRemoveTags()
    {
      assertMutable();
      ensureRemoveTagsInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.removeTags_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public ResolvedRule addRemoveTags(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureRemoveTagsInitialized();
      this.removeTags_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule clear()
    {
      assertMutable();
      super.clear();
      this.positivePredicates_ = null;
      this.negativePredicates_ = null;
      this.addTags_ = null;
      this.removeTags_ = null;
      this.addMacros_ = null;
      this.removeMacros_ = null;
      if (this.result_ != MutableTypeSystem.Value.getDefaultInstance()) {
        this.result_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFE;
      return this;
    }
    
    public ResolvedRule clearAddMacros()
    {
      assertMutable();
      this.addMacros_ = null;
      return this;
    }
    
    public ResolvedRule clearAddTags()
    {
      assertMutable();
      this.addTags_ = null;
      return this;
    }
    
    public ResolvedRule clearNegativePredicates()
    {
      assertMutable();
      this.negativePredicates_ = null;
      return this;
    }
    
    public ResolvedRule clearPositivePredicates()
    {
      assertMutable();
      this.positivePredicates_ = null;
      return this;
    }
    
    public ResolvedRule clearRemoveMacros()
    {
      assertMutable();
      this.removeMacros_ = null;
      return this;
    }
    
    public ResolvedRule clearRemoveTags()
    {
      assertMutable();
      this.removeTags_ = null;
      return this;
    }
    
    public ResolvedRule clearResult()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.result_ != MutableTypeSystem.Value.getDefaultInstance()) {
        this.result_.clear();
      }
      return this;
    }
    
    public ResolvedRule clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof ResolvedRule)) {
        return super.equals(paramObject);
      }
      paramObject = (ResolvedRule)paramObject;
      int i;
      label69:
      label91:
      label113:
      label135:
      label157:
      boolean bool1;
      if ((1 != 0) && (getPositivePredicatesList().equals(((ResolvedRule)paramObject).getPositivePredicatesList())))
      {
        i = 1;
        if ((i == 0) || (!getNegativePredicatesList().equals(((ResolvedRule)paramObject).getNegativePredicatesList()))) {
          break label213;
        }
        i = 1;
        if ((i == 0) || (!getAddTagsList().equals(((ResolvedRule)paramObject).getAddTagsList()))) {
          break label218;
        }
        i = 1;
        if ((i == 0) || (!getRemoveTagsList().equals(((ResolvedRule)paramObject).getRemoveTagsList()))) {
          break label223;
        }
        i = 1;
        if ((i == 0) || (!getAddMacrosList().equals(((ResolvedRule)paramObject).getAddMacrosList()))) {
          break label228;
        }
        i = 1;
        if ((i == 0) || (!getRemoveMacrosList().equals(((ResolvedRule)paramObject).getRemoveMacrosList()))) {
          break label233;
        }
        i = 1;
        if ((i == 0) || (hasResult() != ((ResolvedRule)paramObject).hasResult())) {
          break label238;
        }
        bool1 = true;
        label174:
        bool2 = bool1;
        if (hasResult()) {
          if ((!bool1) || (!getResult().equals(((ResolvedRule)paramObject).getResult()))) {
            break label243;
          }
        }
      }
      label213:
      label218:
      label223:
      label228:
      label233:
      label238:
      label243:
      for (boolean bool2 = true;; bool2 = false)
      {
        return bool2;
        i = 0;
        break;
        i = 0;
        break label69;
        i = 0;
        break label91;
        i = 0;
        break label113;
        i = 0;
        break label135;
        i = 0;
        break label157;
        bool1 = false;
        break label174;
      }
    }
    
    public MutableDebug.ResolvedFunctionCall getAddMacros(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.addMacros_.get(paramInt);
    }
    
    public int getAddMacrosCount()
    {
      if (this.addMacros_ == null) {
        return 0;
      }
      return this.addMacros_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getAddMacrosList()
    {
      if (this.addMacros_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.addMacros_);
    }
    
    public MutableDebug.ResolvedFunctionCall getAddTags(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.addTags_.get(paramInt);
    }
    
    public int getAddTagsCount()
    {
      if (this.addTags_ == null) {
        return 0;
      }
      return this.addTags_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getAddTagsList()
    {
      if (this.addTags_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.addTags_);
    }
    
    public final ResolvedRule getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableAddMacros(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.addMacros_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableAddMacrosList()
    {
      assertMutable();
      ensureAddMacrosInitialized();
      return this.addMacros_;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableAddTags(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.addTags_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableAddTagsList()
    {
      assertMutable();
      ensureAddTagsInitialized();
      return this.addTags_;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableNegativePredicates(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.negativePredicates_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableNegativePredicatesList()
    {
      assertMutable();
      ensureNegativePredicatesInitialized();
      return this.negativePredicates_;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutablePositivePredicates(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.positivePredicates_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutablePositivePredicatesList()
    {
      assertMutable();
      ensurePositivePredicatesInitialized();
      return this.positivePredicates_;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableRemoveMacros(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.removeMacros_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableRemoveMacrosList()
    {
      assertMutable();
      ensureRemoveMacrosInitialized();
      return this.removeMacros_;
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableRemoveTags(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.removeTags_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableRemoveTagsList()
    {
      assertMutable();
      ensureRemoveTagsInitialized();
      return this.removeTags_;
    }
    
    public MutableTypeSystem.Value getMutableResult()
    {
      assertMutable();
      ensureResultInitialized();
      this.bitField0_ |= 0x1;
      return this.result_;
    }
    
    public MutableDebug.ResolvedFunctionCall getNegativePredicates(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.negativePredicates_.get(paramInt);
    }
    
    public int getNegativePredicatesCount()
    {
      if (this.negativePredicates_ == null) {
        return 0;
      }
      return this.negativePredicates_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getNegativePredicatesList()
    {
      if (this.negativePredicates_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.negativePredicates_);
    }
    
    public Parser<ResolvedRule> getParserForType()
    {
      return PARSER;
    }
    
    public MutableDebug.ResolvedFunctionCall getPositivePredicates(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.positivePredicates_.get(paramInt);
    }
    
    public int getPositivePredicatesCount()
    {
      if (this.positivePredicates_ == null) {
        return 0;
      }
      return this.positivePredicates_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getPositivePredicatesList()
    {
      if (this.positivePredicates_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.positivePredicates_);
    }
    
    public MutableDebug.ResolvedFunctionCall getRemoveMacros(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.removeMacros_.get(paramInt);
    }
    
    public int getRemoveMacrosCount()
    {
      if (this.removeMacros_ == null) {
        return 0;
      }
      return this.removeMacros_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getRemoveMacrosList()
    {
      if (this.removeMacros_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.removeMacros_);
    }
    
    public MutableDebug.ResolvedFunctionCall getRemoveTags(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.removeTags_.get(paramInt);
    }
    
    public int getRemoveTagsCount()
    {
      if (this.removeTags_ == null) {
        return 0;
      }
      return this.removeTags_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getRemoveTagsList()
    {
      if (this.removeTags_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.removeTags_);
    }
    
    public MutableTypeSystem.Value getResult()
    {
      return this.result_;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      int k;
      if (this.positivePredicates_ != null)
      {
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.positivePredicates_.size()) {
            break;
          }
          j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.positivePredicates_.get(k));
          k += 1;
        }
      }
      j = i;
      if (this.negativePredicates_ != null)
      {
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.negativePredicates_.size()) {
            break;
          }
          i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.negativePredicates_.get(k));
          k += 1;
        }
      }
      i = j;
      if (this.addTags_ != null)
      {
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.addTags_.size()) {
            break;
          }
          j += CodedOutputStream.computeMessageSize(3, (MessageLite)this.addTags_.get(k));
          k += 1;
        }
      }
      j = i;
      if (this.removeTags_ != null)
      {
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.removeTags_.size()) {
            break;
          }
          i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.removeTags_.get(k));
          k += 1;
        }
      }
      i = j;
      if (this.addMacros_ != null)
      {
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.addMacros_.size()) {
            break;
          }
          j += CodedOutputStream.computeMessageSize(5, (MessageLite)this.addMacros_.get(k));
          k += 1;
        }
      }
      j = i;
      if (this.removeMacros_ != null)
      {
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.removeMacros_.size()) {
            break;
          }
          i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.removeMacros_.get(k));
          k += 1;
        }
      }
      i = j;
      if ((this.bitField0_ & 0x1) == 1) {
        i = j + CodedOutputStream.computeMessageSize(7, this.result_);
      }
      i += this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public boolean hasResult()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public int hashCode()
    {
      int j = 41;
      if (getPositivePredicatesCount() > 0) {
        j = 80454 + getPositivePredicatesList().hashCode();
      }
      int i = j;
      if (getNegativePredicatesCount() > 0) {
        i = (j * 37 + 2) * 53 + getNegativePredicatesList().hashCode();
      }
      j = i;
      if (getAddTagsCount() > 0) {
        j = (i * 37 + 3) * 53 + getAddTagsList().hashCode();
      }
      i = j;
      if (getRemoveTagsCount() > 0) {
        i = (j * 37 + 4) * 53 + getRemoveTagsList().hashCode();
      }
      j = i;
      if (getAddMacrosCount() > 0) {
        j = (i * 37 + 5) * 53 + getAddMacrosList().hashCode();
      }
      i = j;
      if (getRemoveMacrosCount() > 0) {
        i = (j * 37 + 6) * 53 + getRemoveMacrosList().hashCode();
      }
      j = i;
      if (hasResult()) {
        j = (i * 37 + 7) * 53 + getResult().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedRule");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      if (i < getPositivePredicatesCount()) {
        if (getPositivePredicates(i).isInitialized()) {}
      }
      label58:
      label86:
      label114:
      label142:
      label170:
      do
      {
        return false;
        i += 1;
        break;
        i = 0;
        for (;;)
        {
          if (i >= getNegativePredicatesCount()) {
            break label58;
          }
          if (!getNegativePredicates(i).isInitialized()) {
            break;
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          if (i >= getAddTagsCount()) {
            break label86;
          }
          if (!getAddTags(i).isInitialized()) {
            break;
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          if (i >= getRemoveTagsCount()) {
            break label114;
          }
          if (!getRemoveTags(i).isInitialized()) {
            break;
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          if (i >= getAddMacrosCount()) {
            break label142;
          }
          if (!getAddMacros(i).isInitialized()) {
            break;
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          if (i >= getRemoveMacrosCount()) {
            break label170;
          }
          if (!getRemoveMacros(i).isInitialized()) {
            break;
          }
          i += 1;
        }
      } while ((hasResult()) && (!getResult().isInitialized()));
      return true;
    }
    
    public ResolvedRule mergeFrom(ResolvedRule paramResolvedRule)
    {
      if (this == paramResolvedRule) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramResolvedRule == getDefaultInstance()) {
        return this;
      }
      if ((paramResolvedRule.positivePredicates_ != null) && (!paramResolvedRule.positivePredicates_.isEmpty()))
      {
        ensurePositivePredicatesInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedRule.positivePredicates_, this.positivePredicates_);
      }
      if ((paramResolvedRule.negativePredicates_ != null) && (!paramResolvedRule.negativePredicates_.isEmpty()))
      {
        ensureNegativePredicatesInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedRule.negativePredicates_, this.negativePredicates_);
      }
      if ((paramResolvedRule.addTags_ != null) && (!paramResolvedRule.addTags_.isEmpty()))
      {
        ensureAddTagsInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedRule.addTags_, this.addTags_);
      }
      if ((paramResolvedRule.removeTags_ != null) && (!paramResolvedRule.removeTags_.isEmpty()))
      {
        ensureRemoveTagsInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedRule.removeTags_, this.removeTags_);
      }
      if ((paramResolvedRule.addMacros_ != null) && (!paramResolvedRule.addMacros_.isEmpty()))
      {
        ensureAddMacrosInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedRule.addMacros_, this.addMacros_);
      }
      if ((paramResolvedRule.removeMacros_ != null) && (!paramResolvedRule.removeMacros_.isEmpty()))
      {
        ensureRemoveMacrosInitialized();
        AbstractMutableMessageLite.addAll(paramResolvedRule.removeMacros_, this.removeMacros_);
      }
      if (paramResolvedRule.hasResult())
      {
        ensureResultInitialized();
        this.result_.mergeFrom(paramResolvedRule.getResult());
        this.bitField0_ |= 0x1;
      }
      this.unknownFields = this.unknownFields.concat(paramResolvedRule.unknownFields);
      return this;
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          case 18: 
          case 26: 
          case 34: 
          case 42: 
          case 50: 
          case 58: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label250;
              }
              i = 1;
              break;
              paramCodedInputStream.readMessage(addPositivePredicates(), paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addNegativePredicates(), paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addAddTags(), paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addRemoveTags(), paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addAddMacros(), paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addRemoveMacros(), paramExtensionRegistryLite);
              break;
              if (this.result_ == MutableTypeSystem.Value.getDefaultInstance()) {
                this.result_ = MutableTypeSystem.Value.newMessage();
              }
              this.bitField0_ |= 0x1;
              paramCodedInputStream.readMessage(this.result_, paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label250:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public ResolvedRule newMessageForType()
    {
      return new ResolvedRule();
    }
    
    public ResolvedRule setAddMacros(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureAddMacrosInitialized();
      this.addMacros_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule setAddTags(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureAddTagsInitialized();
      this.addTags_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule setNegativePredicates(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureNegativePredicatesInitialized();
      this.negativePredicates_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule setPositivePredicates(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensurePositivePredicatesInitialized();
      this.positivePredicates_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule setRemoveMacros(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureRemoveMacrosInitialized();
      this.removeMacros_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule setRemoveTags(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureRemoveTagsInitialized();
      this.removeTags_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public ResolvedRule setResult(MutableTypeSystem.Value paramValue)
    {
      assertMutable();
      if (paramValue == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.result_ = paramValue;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (this.positivePredicates_ != null)
      {
        i = 0;
        while (i < this.positivePredicates_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite)this.positivePredicates_.get(i));
          i += 1;
        }
      }
      if (this.negativePredicates_ != null)
      {
        i = 0;
        while (i < this.negativePredicates_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite)this.negativePredicates_.get(i));
          i += 1;
        }
      }
      if (this.addTags_ != null)
      {
        i = 0;
        while (i < this.addTags_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(3, (MutableMessageLite)this.addTags_.get(i));
          i += 1;
        }
      }
      if (this.removeTags_ != null)
      {
        i = 0;
        while (i < this.removeTags_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(4, (MutableMessageLite)this.removeTags_.get(i));
          i += 1;
        }
      }
      if (this.addMacros_ != null)
      {
        i = 0;
        while (i < this.addMacros_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(5, (MutableMessageLite)this.addMacros_.get(i));
          i += 1;
        }
      }
      if (this.removeMacros_ != null)
      {
        i = 0;
        while (i < this.removeMacros_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(6, (MutableMessageLite)this.removeMacros_.get(i));
          i += 1;
        }
      }
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessageWithCachedSizes(7, this.result_);
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != i - j) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
  
  public static final class RuleEvaluationStepInfo
    extends GeneratedMutableMessageLite<RuleEvaluationStepInfo>
    implements MutableMessageLite
  {
    public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
    public static Parser<RuleEvaluationStepInfo> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int RULES_FIELD_NUMBER = 1;
    private static final RuleEvaluationStepInfo defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private List<MutableDebug.ResolvedFunctionCall> enabledFunctions_ = null;
    private List<MutableDebug.ResolvedRule> rules_ = null;
    
    static
    {
      defaultInstance = new RuleEvaluationStepInfo(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private RuleEvaluationStepInfo()
    {
      initFields();
    }
    
    private RuleEvaluationStepInfo(boolean paramBoolean) {}
    
    private void ensureEnabledFunctionsInitialized()
    {
      if (this.enabledFunctions_ == null) {
        this.enabledFunctions_ = new ArrayList();
      }
    }
    
    private void ensureRulesInitialized()
    {
      if (this.rules_ == null) {
        this.rules_ = new ArrayList();
      }
    }
    
    public static RuleEvaluationStepInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields() {}
    
    public static RuleEvaluationStepInfo newMessage()
    {
      return new RuleEvaluationStepInfo();
    }
    
    public RuleEvaluationStepInfo addAllEnabledFunctions(Iterable<? extends MutableDebug.ResolvedFunctionCall> paramIterable)
    {
      assertMutable();
      ensureEnabledFunctionsInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.enabledFunctions_);
      return this;
    }
    
    public RuleEvaluationStepInfo addAllRules(Iterable<? extends MutableDebug.ResolvedRule> paramIterable)
    {
      assertMutable();
      ensureRulesInitialized();
      AbstractMutableMessageLite.addAll(paramIterable, this.rules_);
      return this;
    }
    
    public MutableDebug.ResolvedFunctionCall addEnabledFunctions()
    {
      assertMutable();
      ensureEnabledFunctionsInitialized();
      MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
      this.enabledFunctions_.add(localResolvedFunctionCall);
      return localResolvedFunctionCall;
    }
    
    public RuleEvaluationStepInfo addEnabledFunctions(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureEnabledFunctionsInitialized();
      this.enabledFunctions_.add(paramResolvedFunctionCall);
      return this;
    }
    
    public MutableDebug.ResolvedRule addRules()
    {
      assertMutable();
      ensureRulesInitialized();
      MutableDebug.ResolvedRule localResolvedRule = MutableDebug.ResolvedRule.newMessage();
      this.rules_.add(localResolvedRule);
      return localResolvedRule;
    }
    
    public RuleEvaluationStepInfo addRules(MutableDebug.ResolvedRule paramResolvedRule)
    {
      assertMutable();
      if (paramResolvedRule == null) {
        throw new NullPointerException();
      }
      ensureRulesInitialized();
      this.rules_.add(paramResolvedRule);
      return this;
    }
    
    public RuleEvaluationStepInfo clear()
    {
      assertMutable();
      super.clear();
      this.rules_ = null;
      this.enabledFunctions_ = null;
      return this;
    }
    
    public RuleEvaluationStepInfo clearEnabledFunctions()
    {
      assertMutable();
      this.enabledFunctions_ = null;
      return this;
    }
    
    public RuleEvaluationStepInfo clearRules()
    {
      assertMutable();
      this.rules_ = null;
      return this;
    }
    
    public RuleEvaluationStepInfo clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof RuleEvaluationStepInfo)) {
        return super.equals(paramObject);
      }
      paramObject = (RuleEvaluationStepInfo)paramObject;
      int i;
      if ((1 != 0) && (getRulesList().equals(((RuleEvaluationStepInfo)paramObject).getRulesList())))
      {
        i = 1;
        if ((i == 0) || (!getEnabledFunctionsList().equals(((RuleEvaluationStepInfo)paramObject).getEnabledFunctionsList()))) {
          break label76;
        }
      }
      label76:
      for (boolean bool = true;; bool = false)
      {
        return bool;
        i = 0;
        break;
      }
    }
    
    public final RuleEvaluationStepInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableDebug.ResolvedFunctionCall getEnabledFunctions(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.enabledFunctions_.get(paramInt);
    }
    
    public int getEnabledFunctionsCount()
    {
      if (this.enabledFunctions_ == null) {
        return 0;
      }
      return this.enabledFunctions_.size();
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getEnabledFunctionsList()
    {
      if (this.enabledFunctions_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.enabledFunctions_);
    }
    
    public MutableDebug.ResolvedFunctionCall getMutableEnabledFunctions(int paramInt)
    {
      return (MutableDebug.ResolvedFunctionCall)this.enabledFunctions_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedFunctionCall> getMutableEnabledFunctionsList()
    {
      assertMutable();
      ensureEnabledFunctionsInitialized();
      return this.enabledFunctions_;
    }
    
    public MutableDebug.ResolvedRule getMutableRules(int paramInt)
    {
      return (MutableDebug.ResolvedRule)this.rules_.get(paramInt);
    }
    
    public List<MutableDebug.ResolvedRule> getMutableRulesList()
    {
      assertMutable();
      ensureRulesInitialized();
      return this.rules_;
    }
    
    public Parser<RuleEvaluationStepInfo> getParserForType()
    {
      return PARSER;
    }
    
    public MutableDebug.ResolvedRule getRules(int paramInt)
    {
      return (MutableDebug.ResolvedRule)this.rules_.get(paramInt);
    }
    
    public int getRulesCount()
    {
      if (this.rules_ == null) {
        return 0;
      }
      return this.rules_.size();
    }
    
    public List<MutableDebug.ResolvedRule> getRulesList()
    {
      if (this.rules_ == null) {
        return Collections.emptyList();
      }
      return Collections.unmodifiableList(this.rules_);
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      if (this.rules_ != null)
      {
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.rules_.size()) {
            break;
          }
          j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.rules_.get(k));
          k += 1;
        }
      }
      int k = i;
      if (this.enabledFunctions_ != null)
      {
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.enabledFunctions_.size()) {
            break;
          }
          i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.enabledFunctions_.get(j));
          j += 1;
        }
      }
      i = k + this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int i = 41;
      if (getRulesCount() > 0) {
        i = 80454 + getRulesList().hashCode();
      }
      int j = i;
      if (getEnabledFunctionsCount() > 0) {
        j = (i * 37 + 2) * 53 + getEnabledFunctionsList().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$RuleEvaluationStepInfo");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      while (i < getRulesCount())
      {
        if (!getRules(i).isInitialized()) {
          return false;
        }
        i += 1;
      }
      i = 0;
      for (;;)
      {
        if (i >= getEnabledFunctionsCount()) {
          break label58;
        }
        if (!getEnabledFunctions(i).isInitialized()) {
          break;
        }
        i += 1;
      }
      label58:
      return true;
    }
    
    public RuleEvaluationStepInfo mergeFrom(RuleEvaluationStepInfo paramRuleEvaluationStepInfo)
    {
      if (this == paramRuleEvaluationStepInfo) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramRuleEvaluationStepInfo == getDefaultInstance()) {
        return this;
      }
      if ((paramRuleEvaluationStepInfo.rules_ != null) && (!paramRuleEvaluationStepInfo.rules_.isEmpty()))
      {
        ensureRulesInitialized();
        AbstractMutableMessageLite.addAll(paramRuleEvaluationStepInfo.rules_, this.rules_);
      }
      if ((paramRuleEvaluationStepInfo.enabledFunctions_ != null) && (!paramRuleEvaluationStepInfo.enabledFunctions_.isEmpty()))
      {
        ensureEnabledFunctionsInitialized();
        AbstractMutableMessageLite.addAll(paramRuleEvaluationStepInfo.enabledFunctions_, this.enabledFunctions_);
      }
      this.unknownFields = this.unknownFields.concat(paramRuleEvaluationStepInfo.unknownFields);
      return this;
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 10: 
          case 18: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label123;
              }
              i = 1;
              break;
              paramCodedInputStream.readMessage(addRules(), paramExtensionRegistryLite);
              break;
              paramCodedInputStream.readMessage(addEnabledFunctions(), paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label123:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public RuleEvaluationStepInfo newMessageForType()
    {
      return new RuleEvaluationStepInfo();
    }
    
    public RuleEvaluationStepInfo setEnabledFunctions(int paramInt, MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
    {
      assertMutable();
      if (paramResolvedFunctionCall == null) {
        throw new NullPointerException();
      }
      ensureEnabledFunctionsInitialized();
      this.enabledFunctions_.set(paramInt, paramResolvedFunctionCall);
      return this;
    }
    
    public RuleEvaluationStepInfo setRules(int paramInt, MutableDebug.ResolvedRule paramResolvedRule)
    {
      assertMutable();
      if (paramResolvedRule == null) {
        throw new NullPointerException();
      }
      ensureRulesInitialized();
      this.rules_.set(paramInt, paramResolvedRule);
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (this.rules_ != null)
      {
        i = 0;
        while (i < this.rules_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite)this.rules_.get(i));
          i += 1;
        }
      }
      if (this.enabledFunctions_ != null)
      {
        i = 0;
        while (i < this.enabledFunctions_.size())
        {
          paramCodedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite)this.enabledFunctions_.get(i));
          i += 1;
        }
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int i = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != i - j) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/containertag/proto/MutableDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */