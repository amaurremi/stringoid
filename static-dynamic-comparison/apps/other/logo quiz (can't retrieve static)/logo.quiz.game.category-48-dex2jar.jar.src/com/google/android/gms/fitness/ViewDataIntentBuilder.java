package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;

public class ViewDataIntentBuilder
{
  private long KL;
  private DataSource Sh;
  private long Si;
  private String Sj;
  private final Context mContext;
  
  public ViewDataIntentBuilder(Context paramContext)
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
    boolean bool2 = true;
    if (this.Sh != null)
    {
      bool1 = true;
      n.a(bool1, "Data source must be set");
      if (this.KL <= 0L) {
        break label122;
      }
      bool1 = true;
      label28:
      n.a(bool1, "Start time must be set");
      if (this.Si <= this.KL) {
        break label127;
      }
    }
    label122:
    label127:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      n.a(bool1, "End time must be set and after start time");
      Intent localIntent = new Intent("vnd.google.fitness.VIEW");
      localIntent.setType(FitnessIntents.getDataTypeMimeType(this.Sh.getDataType()));
      localIntent.putExtra("vnd.google.fitness.start_time", this.KL);
      localIntent.putExtra("vnd.google.fitness.end_time", this.Si);
      c.a(this.Sh, localIntent, "vnd.google.fitness.data_source");
      return i(localIntent);
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public ViewDataIntentBuilder setDataSource(DataSource paramDataSource)
  {
    this.Sh = paramDataSource;
    return this;
  }
  
  public ViewDataIntentBuilder setPreferredApplication(String paramString)
  {
    this.Sj = paramString;
    return this;
  }
  
  public ViewDataIntentBuilder setTimeInterval(long paramLong1, long paramLong2)
  {
    this.KL = paramLong1;
    this.Si = paramLong2;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/ViewDataIntentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */