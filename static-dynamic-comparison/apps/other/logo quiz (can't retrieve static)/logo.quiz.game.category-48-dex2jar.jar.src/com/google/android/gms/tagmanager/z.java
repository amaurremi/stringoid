package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class z
  extends aj
{
  private static final String ID = a.Z.toString();
  private final Context mContext;
  
  public z(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    paramMap = X(this.mContext);
    if (paramMap == null) {
      return di.pI();
    }
    return di.u(paramMap);
  }
  
  protected String X(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */