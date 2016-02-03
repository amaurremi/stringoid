package com.google.tagmanager.protobuf;

public final class WireFormat
{
  static final int akM = D(1, 3);
  static final int akN = D(1, 4);
  static final int akO = D(2, 0);
  static final int akP = D(3, 2);
  
  static int D(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static int fA(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  static int fz(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static enum FieldType
  {
    private final WireFormat.JavaType javaType;
    private final int wireType;
    
    private FieldType(WireFormat.JavaType paramJavaType, int paramInt)
    {
      this.javaType = paramJavaType;
      this.wireType = paramInt;
    }
    
    public WireFormat.JavaType Cr()
    {
      return this.javaType;
    }
    
    public int Cs()
    {
      return this.wireType;
    }
    
    public boolean Ct()
    {
      return true;
    }
  }
  
  public static enum JavaType
  {
    private final Object defaultDefault;
    
    private JavaType(Object paramObject)
    {
      this.defaultDefault = paramObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/WireFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */