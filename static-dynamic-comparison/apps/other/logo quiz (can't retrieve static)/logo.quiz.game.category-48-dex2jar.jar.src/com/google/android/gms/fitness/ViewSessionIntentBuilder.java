package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Session;

public class ViewSessionIntentBuilder
{
  private String Sj;
  private Session Sk;
  private boolean Sl = false;
  private final Context mContext;
  
  public ViewSessionIntentBuilder(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Intent i(Intent paramIntent)
  {
    int i = 0;
    if (this.Sj == null) {}
    Intent localIntent;
    do
    {
      return paramIntent;
      localIntent = new Intent(paramIntent).setPackage(this.Sj);
      if (this.mContext.getPackageManager().resolveActivity(localIntent, 0) != null) {
        i = 1;
      }
    } while (i == 0);
    return localIntent;
  }
  
  public Intent build()
  {
    if (this.Sk != null) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Session must be set");
      Intent localIntent = new Intent("vnd.google.fitness.VIEW");
      localIntent.setType(FitnessIntents.getSessionMimeType(this.Sk.getActivity()));
      c.a(this.Sk, localIntent, "vnd.google.fitness.session");
      if (!this.Sl) {
        this.Sj = this.Sk.getAppPackageName();
      }
      return i(localIntent);
    }
  }
  
  public ViewSessionIntentBuilder setPreferredApplication(String paramString)
  {
    this.Sj = paramString;
    this.Sl = true;
    return this;
  }
  
  public ViewSessionIntentBuilder setSession(Session paramSession)
  {
    this.Sk = paramSession;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/ViewSessionIntentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */