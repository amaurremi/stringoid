package com.vladium.emma.report;

public abstract interface IItemMetadata
{
  public static final int TYPE_ID_ALL = 0;
  public static final int TYPE_ID_CLASS = 3;
  public static final int TYPE_ID_METHOD = 4;
  public static final int TYPE_ID_PACKAGE = 1;
  public static final int TYPE_ID_SRCFILE = 2;
  
  public abstract long getAttributeIDs();
  
  public abstract int getTypeID();
  
  public abstract String getTypeName();
  
  public static abstract class Factory
  {
    private static final IItemMetadata[] METADATA = { AllItem.getTypeMetadata(), PackageItem.getTypeMetadata(), SrcFileItem.getTypeMetadata(), ClassItem.getTypeMetadata(), MethodItem.getTypeMetadata() };
    
    public static IItemMetadata[] getAllTypes()
    {
      return METADATA;
    }
    
    public static IItemMetadata getTypeMetadata(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 4)) {
        throw new IllegalArgumentException("invalid type ID: " + paramInt);
      }
      return METADATA[paramInt];
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IItemMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */