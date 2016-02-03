package com.google.android.gms.fitness;

import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class FitnessIntents
{
  public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
  public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
  public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
  public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
  public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
  public static final String EXTRA_SESSION = "vnd.google.fitness.session";
  public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
  public static final String EXTRA_STATUS = "actionStatus";
  public static final String MIME_TYPE_ACTIVITY_PREFIX = "vnd.google.fitness.activity/";
  public static final String MIME_TYPE_DATA_TYPE_PREFIX = "vnd.google.fitness.data_type/";
  public static final String MIME_TYPE_SESSION_PREFIX = "vnd.google.fitness.session/";
  public static final String STATUS_ACTIVE = "ActiveActionStatus";
  public static final String STATUS_COMPLETED = "CompletedActionStatus";
  
  public static String getActivityMimeType(int paramInt)
  {
    return "vnd.google.fitness.activity/" + FitnessActivities.getName(paramInt);
  }
  
  public static DataSource getDataSource(Intent paramIntent)
  {
    return (DataSource)c.a(paramIntent, "vnd.google.fitness.data_source", DataSource.CREATOR);
  }
  
  public static String getDataTypeMimeType(DataType paramDataType)
  {
    return "vnd.google.fitness.data_type/" + paramDataType.getName();
  }
  
  public static long getEndTime(Intent paramIntent)
  {
    return paramIntent.getLongExtra("vnd.google.fitness.end_time", -1L);
  }
  
  public static String getSessionMimeType(int paramInt)
  {
    return "vnd.google.fitness.session/" + FitnessActivities.getName(paramInt);
  }
  
  public static long getStartTime(Intent paramIntent)
  {
    return paramIntent.getLongExtra("vnd.google.fitness.start_time", -1L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/FitnessIntents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */