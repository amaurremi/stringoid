package com.google.android.gms.fitness.data;

public class DataTypes
{
  public static final DataType ACTIVITY_EDGE;
  public static final DataType ACTIVITY_SAMPLE;
  public static final DataType ACTIVITY_SEGMENT;
  public static final DataType CALORIES_CONSUMED;
  public static final DataType CALORIES_EXPENDED;
  public static final DataType CYCLING_PEDALING_CADENCE;
  public static final DataType CYCLING_PEDALING_CUMULATIVE;
  public static final DataType CYCLING_WHEEL_REVOLUTION;
  public static final DataType CYCLING_WHEEL_RPM;
  public static final DataType DISTANCE_CUMULATIVE;
  public static final DataType DISTANCE_DELTA;
  public static final DataType HEART_RATE_BPM;
  public static final DataType HEIGHT;
  public static final DataType LOCATION_SAMPLE;
  public static final DataType POWER_SAMPLE;
  public static final DataType SO;
  public static final DataType SP;
  public static final DataType SPEED;
  public static final DataType STEP_COUNT_CADENCE;
  public static final DataType STEP_COUNT_CUMULATIVE;
  public static final DataType STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", new Field[] { Fields.STEPS });
  public static final DataType[] Sm = { SO, ACTIVITY_EDGE, ACTIVITY_SAMPLE, ACTIVITY_SEGMENT, CALORIES_CONSUMED, CALORIES_EXPENDED, CYCLING_PEDALING_CADENCE, CYCLING_PEDALING_CUMULATIVE, CYCLING_WHEEL_REVOLUTION, CYCLING_WHEEL_RPM, DISTANCE_CUMULATIVE, DISTANCE_DELTA, HEART_RATE_BPM, HEIGHT, SP, LOCATION_SAMPLE, POWER_SAMPLE, SPEED, STEP_COUNT_CADENCE, STEP_COUNT_CUMULATIVE, STEP_COUNT_DELTA, WEIGHT };
  public static final String[] Sn = { SO.getName(), ACTIVITY_EDGE.getName(), ACTIVITY_SAMPLE.getName(), ACTIVITY_SEGMENT.getName(), CALORIES_CONSUMED.getName(), CALORIES_EXPENDED.getName(), CYCLING_PEDALING_CADENCE.getName(), CYCLING_PEDALING_CUMULATIVE.getName(), CYCLING_WHEEL_REVOLUTION.getName(), CYCLING_WHEEL_RPM.getName(), DISTANCE_CUMULATIVE.getName(), DISTANCE_DELTA.getName(), HEART_RATE_BPM.getName(), HEIGHT.getName(), SP.getName(), LOCATION_SAMPLE.getName(), POWER_SAMPLE.getName(), SPEED.getName(), STEP_COUNT_CADENCE.getName(), STEP_COUNT_CUMULATIVE.getName(), STEP_COUNT_DELTA.getName(), WEIGHT.getName() };
  public static final DataType WEIGHT;
  
  static
  {
    STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", new Field[] { Fields.STEPS });
    STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", new Field[] { Fields.RPM });
    ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", new Field[] { Fields.ACTIVITY });
    CALORIES_CONSUMED = new DataType("com.google.calories.consumed", new Field[] { Fields.CALORIES });
    CALORIES_EXPENDED = new DataType("com.google.calories.expended", new Field[] { Fields.CALORIES });
    POWER_SAMPLE = new DataType("com.google.power.sample", new Field[] { Fields.WATTS });
    ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", new Field[] { Fields.ACTIVITY, Fields.CONFIDENCE });
    ACTIVITY_EDGE = new DataType("com.google.activity.edge", new Field[] { Fields.ACTIVITY, Fields.SU });
    SO = new DataType("com.google.accelerometer", new Field[] { Fields.SV, Fields.SW, Fields.SX });
    HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", new Field[] { Fields.BPM });
    LOCATION_SAMPLE = new DataType("com.google.location.sample", new Field[] { Fields.LATITUDE, Fields.LONGITUDE, Fields.ACCURACY, Fields.ALTITUDE });
    SP = new DataType("com.google.location", new Field[] { Fields.LATITUDE, Fields.LONGITUDE, Fields.ACCURACY });
    DISTANCE_DELTA = new DataType("com.google.distance.delta", new Field[] { Fields.DISTANCE });
    DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", new Field[] { Fields.DISTANCE });
    SPEED = new DataType("com.google.speed", new Field[] { Fields.SPEED });
    CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", new Field[] { Fields.REVOLUTIONS });
    CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", new Field[] { Fields.RPM });
    CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", new Field[] { Fields.REVOLUTIONS });
    CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", new Field[] { Fields.RPM });
    HEIGHT = new DataType("com.google.height", new Field[] { Fields.HEIGHT });
    WEIGHT = new DataType("com.google.weight", new Field[] { Fields.WEIGHT });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/DataTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */