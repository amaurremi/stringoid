package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.DataPoint;

public abstract interface DataSourceListener
{
  public abstract void onEvent(DataPoint paramDataPoint);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/DataSourceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */