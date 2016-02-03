package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;

public abstract interface Person$Urls
  extends Freezable<Urls>
{
  public abstract String getLabel();
  
  public abstract int getType();
  
  public abstract String getValue();
  
  public abstract boolean hasLabel();
  
  public abstract boolean hasType();
  
  public abstract boolean hasValue();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/people/Person$Urls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */