package com.google.android.gms.fitness.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AggregateDataTypes
{
  public static final DataType ACTIVITY_SUMMARY;
  public static final DataType DISTANCE_DELTA;
  public static final DataType HEART_RATE_SUMMARY;
  public static final Set<DataType> INPUT_TYPES = new HashSet(Arrays.asList(new DataType[] { DataTypes.STEP_COUNT_DELTA, DataTypes.DISTANCE_DELTA, DataTypes.ACTIVITY_SEGMENT, DataTypes.SPEED, DataTypes.HEART_RATE_BPM, DataTypes.WEIGHT, DataTypes.LOCATION_SAMPLE }));
  public static final DataType LOCATION_BOUNDING_BOX;
  public static final DataType POWER_SUMMARY;
  public static final DataType SPEED_SUMMARY;
  public static final DataType STEP_COUNT_DELTA = DataTypes.STEP_COUNT_DELTA;
  public static final DataType[] Sm = { ACTIVITY_SUMMARY, DISTANCE_DELTA, HEART_RATE_SUMMARY, LOCATION_BOUNDING_BOX, POWER_SUMMARY, SPEED_SUMMARY, STEP_COUNT_DELTA, WEIGHT_SUMMARY };
  public static final String[] Sn = { ACTIVITY_SUMMARY.getName(), DISTANCE_DELTA.getName(), HEART_RATE_SUMMARY.getName(), LOCATION_BOUNDING_BOX.getName(), POWER_SUMMARY.getName(), SPEED_SUMMARY.getName(), STEP_COUNT_DELTA.getName(), WEIGHT_SUMMARY.getName() };
  private static final Map<DataType, List<DataType>> So = new HashMap() {};
  public static final DataType WEIGHT_SUMMARY;
  
  static
  {
    ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", new Field[] { Fields.ACTIVITY, Fields.DURATION, Fields.NUM_SEGMENTS });
    DISTANCE_DELTA = DataTypes.DISTANCE_DELTA;
    HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", new Field[] { Fields.AVERAGE, Fields.MAX, Fields.MIN });
    LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", new Field[] { Fields.LOW_LATITUDE, Fields.LOW_LONGITUDE, Fields.HIGH_LATITUDE, Fields.HIGH_LONGITUDE });
    POWER_SUMMARY = new DataType("com.google.power.summary", new Field[] { Fields.AVERAGE, Fields.MAX, Fields.MIN });
    SPEED_SUMMARY = new DataType("com.google.speed.summary", new Field[] { Fields.AVERAGE, Fields.MAX, Fields.MIN });
    WEIGHT_SUMMARY = new DataType("com.google.weight.summary", new Field[] { Fields.AVERAGE, Fields.MAX, Fields.MIN });
  }
  
  public static List<DataType> getForInput(DataType paramDataType)
  {
    paramDataType = (List)So.get(paramDataType);
    if (paramDataType == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(paramDataType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/AggregateDataTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */