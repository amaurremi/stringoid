package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class e
  extends m<Date>
{
  public static final n afz = new n()
  {
    public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.zZ() == Date.class) {
        return new e();
      }
      return null;
    }
  };
  private final DateFormat afE = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat afF = DateFormat.getDateTimeInstance(2, 2);
  private final DateFormat afG = zM();
  
  private Date cK(String paramString)
  {
    try
    {
      Date localDate1 = this.afF.parse(paramString);
      paramString = localDate1;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        Date localDate2 = this.afE.parse(paramString);
        paramString = localDate2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Date localDate3 = this.afG.parse(paramString);
          paramString = localDate3;
        }
        catch (ParseException localParseException3)
        {
          throw new JsonSyntaxException(paramString, localParseException3);
        }
      }
    }
    finally {}
    return paramString;
  }
  
  private static DateFormat zM()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }
  
  public void a(b paramb, Date paramDate)
  {
    if (paramDate == null) {}
    for (;;)
    {
      try
      {
        paramb.zX();
        return;
      }
      finally {}
      paramb.cM(this.afE.format(paramDate));
    }
  }
  
  public Date i(com.google.gson.stream.a parama)
  {
    if (parama.zN() == JsonToken.ahQ)
    {
      parama.nextNull();
      return null;
    }
    return cK(parama.nextString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */