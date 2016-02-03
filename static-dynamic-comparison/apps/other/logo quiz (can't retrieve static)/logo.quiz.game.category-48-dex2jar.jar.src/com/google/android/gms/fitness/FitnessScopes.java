package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class FitnessScopes
{
  public static final Scope SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
  public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
  public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
  public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
  public static final Scope SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
  public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
  
  public static String bp(String paramString)
  {
    String str;
    if (paramString.equals("https://www.googleapis.com/auth/fitness.activity.read")) {
      str = "https://www.googleapis.com/auth/fitness.activity.write";
    }
    do
    {
      return str;
      if (paramString.equals("https://www.googleapis.com/auth/fitness.location.read")) {
        return "https://www.googleapis.com/auth/fitness.location.write";
      }
      str = paramString;
    } while (!paramString.equals("https://www.googleapis.com/auth/fitness.body.read"));
    return "https://www.googleapis.com/auth/fitness.body.write";
  }
  
  public static String[] d(List<String> paramList)
  {
    HashSet localHashSet = new HashSet(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = bp(str1);
      if ((str2.equals(str1)) || (!paramList.contains(str2))) {
        localHashSet.add(str1);
      }
    }
    return (String[])localHashSet.toArray(new String[localHashSet.size()]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/FitnessScopes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */