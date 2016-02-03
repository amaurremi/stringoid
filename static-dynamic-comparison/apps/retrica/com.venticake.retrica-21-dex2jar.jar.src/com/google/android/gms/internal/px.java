package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus.a;
import com.google.android.gms.plus.model.people.PersonBuffer;

abstract class px
  extends Plus.a<People.LoadPeopleResult>
{
  public People.LoadPeopleResult a(final Status paramStatus)
  {
    new People.LoadPeopleResult()
    {
      public String getNextPageToken()
      {
        return null;
      }
      
      public PersonBuffer getPersonBuffer()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/px.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */