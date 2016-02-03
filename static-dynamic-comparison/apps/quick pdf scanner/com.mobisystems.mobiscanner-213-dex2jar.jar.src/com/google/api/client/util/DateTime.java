package com.google.api.client.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class DateTime
  implements Serializable
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  private static final long serialVersionUID = 1L;
  private final boolean dateOnly;
  private final int tzShift;
  private final long value;
  
  public DateTime(long paramLong)
  {
    this(false, paramLong, null);
  }
  
  public DateTime(boolean paramBoolean, long paramLong, Integer paramInteger)
  {
    this.dateOnly = paramBoolean;
    this.value = paramLong;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      this.tzShift = i;
      return;
      if (paramInteger == null) {
        i = TimeZone.getDefault().getOffset(paramLong) / 60000;
      } else {
        i = paramInteger.intValue();
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0)
    {
      paramStringBuilder.append('-');
      i = -paramInt1;
    }
    paramInt1 = i;
    while (paramInt1 > 0)
    {
      paramInt1 /= 10;
      paramInt2 -= 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramStringBuilder.append('0');
      paramInt1 += 1;
    }
    if (i != 0) {
      paramStringBuilder.append(i);
    }
  }
  
  public static DateTime ct(String paramString)
  {
    for (;;)
    {
      int i;
      int m;
      try
      {
        i1 = Integer.parseInt(paramString.substring(0, 4));
        i2 = Integer.parseInt(paramString.substring(5, 7));
        i3 = Integer.parseInt(paramString.substring(8, 10));
        i4 = paramString.length();
        if (i4 <= 10) {
          break label317;
        }
        if (Character.toUpperCase(paramString.charAt(10)) == 'T') {
          break label341;
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
      {
        int i1;
        int i2;
        int i3;
        int i4;
        Object localObject1;
        long l;
        throw new NumberFormatException("Invalid date/time format: " + paramString);
      }
      localObject1 = new GregorianCalendar(GMT);
      int n;
      ((Calendar)localObject1).set(i1, i2 - 1, i3, i, m, n);
      ((Calendar)localObject1).set(14, k);
      l = ((Calendar)localObject1).getTimeInMillis();
      boolean bool;
      if (i4 > j)
      {
        if (Character.toUpperCase(paramString.charAt(j)) == 'Z')
        {
          i = 0;
          localObject1 = Integer.valueOf(i);
          return new DateTime(bool, l, (Integer)localObject1);
          label152:
          i = Integer.parseInt(paramString.substring(11, 13));
          m = Integer.parseInt(paramString.substring(14, 16));
          n = Integer.parseInt(paramString.substring(17, 19));
          if (paramString.charAt(19) == '.')
          {
            k = Integer.parseInt(paramString.substring(20, 23));
            j = 23;
          }
        }
        else
        {
          k = Integer.parseInt(paramString.substring(j + 1, j + 3)) * 60 + Integer.parseInt(paramString.substring(j + 4, j + 6));
          j = paramString.charAt(j);
          i = k;
          if (j == 45) {
            i = -k;
          }
          l -= i * 60000L;
          continue;
        }
      }
      else
      {
        Object localObject2 = null;
        continue;
        label317:
        label341:
        for (bool = true;; bool = false)
        {
          m = 0;
          n = 0;
          if (!bool) {
            break label152;
          }
          k = 0;
          i = 0;
          j = Integer.MAX_VALUE;
          break;
        }
      }
      int k = 0;
      int j = 19;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof DateTime)) {
        return false;
      }
      paramObject = (DateTime)paramObject;
    } while ((this.dateOnly == ((DateTime)paramObject).dateOnly) && (this.value == ((DateTime)paramObject).value) && (this.tzShift == ((DateTime)paramObject).tzShift));
    return false;
  }
  
  public int hashCode()
  {
    long l2 = this.value;
    if (this.dateOnly) {}
    for (long l1 = 1L;; l1 = 0L) {
      return Arrays.hashCode(new long[] { l2, l1, this.tzShift });
    }
  }
  
  public String toString()
  {
    return yL();
  }
  
  public String yL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(GMT);
    localGregorianCalendar.setTimeInMillis(this.value + this.tzShift * 60000L);
    a(localStringBuilder, localGregorianCalendar.get(1), 4);
    localStringBuilder.append('-');
    a(localStringBuilder, localGregorianCalendar.get(2) + 1, 2);
    localStringBuilder.append('-');
    a(localStringBuilder, localGregorianCalendar.get(5), 2);
    if (!this.dateOnly)
    {
      localStringBuilder.append('T');
      a(localStringBuilder, localGregorianCalendar.get(11), 2);
      localStringBuilder.append(':');
      a(localStringBuilder, localGregorianCalendar.get(12), 2);
      localStringBuilder.append(':');
      a(localStringBuilder, localGregorianCalendar.get(13), 2);
      if (localGregorianCalendar.isSet(14))
      {
        localStringBuilder.append('.');
        a(localStringBuilder, localGregorianCalendar.get(14), 3);
      }
      if (this.tzShift == 0) {
        localStringBuilder.append('Z');
      }
    }
    else
    {
      return localStringBuilder.toString();
    }
    int i = this.tzShift;
    if (this.tzShift > 0) {
      localStringBuilder.append('+');
    }
    for (;;)
    {
      a(localStringBuilder, i / 60, 2);
      localStringBuilder.append(':');
      a(localStringBuilder, i % 60, 2);
      break;
      localStringBuilder.append('-');
      i = -i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/DateTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */