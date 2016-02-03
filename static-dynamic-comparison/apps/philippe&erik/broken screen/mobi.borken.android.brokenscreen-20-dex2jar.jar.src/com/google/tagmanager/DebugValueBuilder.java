package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.MacroEvaluationInfo;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;

class DebugValueBuilder
  implements ValueBuilder
{
  private TypeSystem.Value value;
  
  public DebugValueBuilder(TypeSystem.Value paramValue)
  {
    this.value = paramValue;
  }
  
  public static TypeSystem.Value copyImmutableValue(TypeSystem.Value paramValue)
  {
    TypeSystem.Value localValue = new TypeSystem.Value();
    try
    {
      MessageNano.mergeFrom(localValue, MessageNano.toByteArray(paramValue));
      return localValue;
    }
    catch (InvalidProtocolBufferNanoException paramValue)
    {
      Log.e("Failed to copy runtime value into debug value");
    }
    return localValue;
  }
  
  private void validateType(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != paramInt2) {
      throw new TypeMismatchException(paramString, paramInt2);
    }
  }
  
  public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension()
  {
    validateType(4, this.value.type, "set macro evaluation extension");
    Debug.MacroEvaluationInfo localMacroEvaluationInfo = new Debug.MacroEvaluationInfo();
    this.value.setExtension(Debug.MacroEvaluationInfo.macro, localMacroEvaluationInfo);
    return new DebugMacroEvaluationInfoBuilder(localMacroEvaluationInfo);
  }
  
  public ValueBuilder getListItem(int paramInt)
  {
    validateType(2, this.value.type, "add new list item");
    return new DebugValueBuilder(this.value.listItem[paramInt]);
  }
  
  public ValueBuilder getMapKey(int paramInt)
  {
    validateType(3, this.value.type, "add new map key");
    return new DebugValueBuilder(this.value.mapKey[paramInt]);
  }
  
  public ValueBuilder getMapValue(int paramInt)
  {
    validateType(3, this.value.type, "add new map value");
    return new DebugValueBuilder(this.value.mapValue[paramInt]);
  }
  
  public ValueBuilder getTemplateToken(int paramInt)
  {
    validateType(7, this.value.type, "add template token");
    return new DebugValueBuilder(this.value.templateToken[paramInt]);
  }
  
  private static class TypeMismatchException
    extends IllegalStateException
  {
    public TypeMismatchException(String paramString, int paramInt)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugValueBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */