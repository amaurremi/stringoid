package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$2
{
  FieldNamingPolicy$2()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$100(paramField.getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/FieldNamingPolicy$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */