package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class wd
  extends wv<StackTraceElement>
{
  public wd()
  {
    super(StackTraceElement.class);
  }
  
  public StackTraceElement b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject = paramow.e();
    if (localObject == pb.b)
    {
      localObject = "";
      String str1 = "";
      String str2 = "";
      int i = -1;
      for (;;)
      {
        pb localpb = paramow.c();
        if (localpb == pb.c) {
          break;
        }
        String str3 = paramow.g();
        if ("className".equals(str3)) {
          localObject = paramow.k();
        } else if ("fileName".equals(str3)) {
          str2 = paramow.k();
        } else if ("lineNumber".equals(str3))
        {
          if (localpb.c()) {
            i = paramow.t();
          } else {
            throw qw.a(paramow, "Non-numeric token (" + localpb + ") for property 'lineNumber'");
          }
        }
        else if ("methodName".equals(str3)) {
          str1 = paramow.k();
        } else if (!"nativeMethod".equals(str3)) {
          a(paramow, paramqm, this.q, str3);
        }
      }
      return new StackTraceElement((String)localObject, str1, str2, i);
    }
    throw paramqm.a(this.q, (pb)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */