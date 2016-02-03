package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public abstract interface People
{
  public abstract Person getCurrentPerson(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<LoadPeopleResult> load(GoogleApiClient paramGoogleApiClient, Collection<String> paramCollection);
  
  public abstract PendingResult<LoadPeopleResult> load(GoogleApiClient paramGoogleApiClient, String... paramVarArgs);
  
  public abstract PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient paramGoogleApiClient, int paramInt, String paramString);
  
  public abstract PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public static abstract interface LoadPeopleResult
    extends Releasable, Result
  {
    public abstract String getNextPageToken();
    
    public abstract PersonBuffer getPersonBuffer();
  }
  
  public static abstract interface OrderBy
  {
    public static final int ALPHABETICAL = 0;
    public static final int BEST = 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/People.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */