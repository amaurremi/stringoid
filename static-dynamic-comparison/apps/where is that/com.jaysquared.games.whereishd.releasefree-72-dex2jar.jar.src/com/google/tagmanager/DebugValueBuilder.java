package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.MacroEvaluationInfo;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.Type;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

class DebugValueBuilder
  implements ValueBuilder
{
  private MutableTypeSystem.Value value;
  
  public DebugValueBuilder(MutableTypeSystem.Value paramValue)
  {
    this.value = paramValue;
  }
  
  public static MutableTypeSystem.Value copyImmutableValue(TypeSystem.Value paramValue)
  {
    MutableTypeSystem.Value localValue = MutableTypeSystem.Value.newMessage();
    if (!localValue.mergeFrom(paramValue.toByteArray())) {
      Log.e("Failed to copy runtime value into debug value");
    }
    return localValue;
  }
  
  private void validateType(MutableTypeSystem.Value.Type paramType1, MutableTypeSystem.Value.Type paramType2, String paramString)
  {
    if (!paramType1.equals(paramType2)) {
      throw new TypeMismatchException(paramString, paramType2);
    }
  }
  
  public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension()
  {
    validateType(MutableTypeSystem.Value.Type.MACRO_REFERENCE, this.value.getType(), "set macro evaluation extension");
    return new DebugMacroEvaluationInfoBuilder((MutableDebug.MacroEvaluationInfo)this.value.getMutableExtension(MutableDebug.MacroEvaluationInfo.macro));
  }
  
  public ValueBuilder getListItem(int paramInt)
  {
    validateType(MutableTypeSystem.Value.Type.LIST, this.value.getType(), "add new list item");
    return new DebugValueBuilder(this.value.getListItem(paramInt));
  }
  
  public ValueBuilder getMapKey(int paramInt)
  {
    validateType(MutableTypeSystem.Value.Type.MAP, this.value.getType(), "add new map key");
    return new DebugValueBuilder(this.value.getMapKey(paramInt));
  }
  
  public ValueBuilder getMapValue(int paramInt)
  {
    validateType(MutableTypeSystem.Value.Type.MAP, this.value.getType(), "add new map value");
    return new DebugValueBuilder(this.value.getMapValue(paramInt));
  }
  
  public ValueBuilder getTemplateToken(int paramInt)
  {
    validateType(MutableTypeSystem.Value.Type.TEMPLATE, this.value.getType(), "add template token");
    return new DebugValueBuilder(this.value.getTemplateToken(paramInt));
  }
  
  private static class TypeMismatchException
    extends IllegalStateException
  {
    public TypeMismatchException(String paramString, MutableTypeSystem.Value.Type paramType)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugValueBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */