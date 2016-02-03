package com.google.android.gms.plus;

import com.google.android.gms.internal.hm;
import java.util.HashSet;
import java.util.Set;

public final class Plus$PlusOptions$Builder
{
  String abr;
  final Set<String> abs = new HashSet();
  
  public Builder addActivityTypes(String... paramVarArgs)
  {
    hm.b(paramVarArgs, "activityTypes may not be null.");
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.abs.add(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public Plus.PlusOptions build()
  {
    return new Plus.PlusOptions(this, null);
  }
  
  public Builder setServerClientId(String paramString)
  {
    this.abr = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/Plus$PlusOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */