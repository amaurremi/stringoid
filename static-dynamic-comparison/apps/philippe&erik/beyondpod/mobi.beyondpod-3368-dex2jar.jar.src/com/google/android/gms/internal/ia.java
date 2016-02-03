package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.a;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class ia
  implements People
{
  private final Api.b<hs> Ea;
  
  public ia(Api.b<hs> paramb)
  {
    this.Ea = paramb;
  }
  
  public Person getCurrentPerson(GoogleApiClient paramGoogleApiClient)
  {
    return Plus.a(paramGoogleApiClient, this.Ea).getCurrentPerson();
  }
  
  public PendingResult<People.LoadPeopleResult> load(GoogleApiClient paramGoogleApiClient, final Collection<String> paramCollection)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.a(this, paramCollection);
      }
    });
  }
  
  public PendingResult<People.LoadPeopleResult> load(GoogleApiClient paramGoogleApiClient, final String... paramVarArgs)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.a(this, paramVarArgs);
      }
    });
  }
  
  public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.k(this);
      }
    });
  }
  
  public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient paramGoogleApiClient, final int paramInt, final String paramString)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.a(this, paramInt, paramString);
      }
    });
  }
  
  public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new a(this.Ea)
    {
      protected void a(hs paramAnonymoushs)
      {
        paramAnonymoushs.i(this, paramString);
      }
    });
  }
  
  private static abstract class a
    extends Plus.a<People.LoadPeopleResult>
  {
    a(Api.b<hs> paramb)
    {
      super();
    }
    
    public People.LoadPeopleResult L(final Status paramStatus)
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */