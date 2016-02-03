package org.codehaus.jackson.map.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ISO8601DateFormat
  extends DateFormat
{
  private static Calendar CALENDAR = new GregorianCalendar();
  private static NumberFormat NUMBER_FORMAT = new DecimalFormat();
  private static final long serialVersionUID = 1L;
  
  public ISO8601DateFormat()
  {
    this.numberFormat = NUMBER_FORMAT;
    this.calendar = CALENDAR;
  }
  
  public Object clone()
  {
    return this;
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    paramStringBuffer.append(ISO8601Utils.format(paramDate));
    return paramStringBuffer;
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(paramString.length());
    return ISO8601Utils.parse(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/ISO8601DateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */