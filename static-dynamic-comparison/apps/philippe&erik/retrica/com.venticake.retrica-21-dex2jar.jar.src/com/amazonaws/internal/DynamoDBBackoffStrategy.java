package com.amazonaws.internal;

public class DynamoDBBackoffStrategy
  extends CustomBackoffStrategy
{
  public static final CustomBackoffStrategy DEFAULT = new DynamoDBBackoffStrategy();
  
  public int getBackoffPeriod(int paramInt)
  {
    if (paramInt <= 0) {
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      i = (int)Math.pow(2.0D, paramInt - 1) * 50;
      paramInt = i;
    } while (i >= 0);
    return Integer.MAX_VALUE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/DynamoDBBackoffStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */