package com.amazon.inapp.purchasing;

import java.util.Date;

public final class SubscriptionPeriod
{
  private static final String TO_STRING_FORMAT = "(%s, startDate: \"%s\", endDate: \"%s\")";
  final Date _endDate;
  final Date _startDate;
  
  SubscriptionPeriod(Date paramDate1, Date paramDate2)
  {
    this._startDate = paramDate1;
    this._endDate = paramDate2;
  }
  
  public Date getEndDate()
  {
    return this._endDate;
  }
  
  public Date getStartDate()
  {
    return this._startDate;
  }
  
  public String toString()
  {
    return String.format("(%s, startDate: \"%s\", endDate: \"%s\")", new Object[] { super.toString(), this._startDate, this._endDate });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/SubscriptionPeriod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */