package com.google.android.gms.plus.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class i
{
  private String Dd;
  private final ArrayList<String> alA = new ArrayList();
  private String[] alB;
  private String[] alu;
  private String alv;
  private String alw;
  private String alx;
  private PlusCommonExtras alz;
  
  public i(Context paramContext)
  {
    this.alw = paramContext.getPackageName();
    this.alv = paramContext.getPackageName();
    this.alz = new PlusCommonExtras();
    this.alA.add("https://www.googleapis.com/auth/plus.login");
  }
  
  public i ce(String paramString)
  {
    this.Dd = paramString;
    return this;
  }
  
  public i g(String... paramVarArgs)
  {
    this.alA.clear();
    this.alA.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public i h(String... paramVarArgs)
  {
    this.alB = paramVarArgs;
    return this;
  }
  
  public i nn()
  {
    this.alA.clear();
    return this;
  }
  
  public h no()
  {
    if (this.Dd == null) {
      this.Dd = "<<default account>>";
    }
    String[] arrayOfString = (String[])this.alA.toArray(new String[this.alA.size()]);
    return new h(this.Dd, arrayOfString, this.alB, this.alu, this.alv, this.alw, this.alx, this.alz);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */