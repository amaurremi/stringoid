package com.google.android.gms.fitness.data;

import java.util.List;

public class t
{
  public static <T> int a(T paramT, List<T> paramList)
  {
    int i;
    if (paramT == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramList.indexOf(paramT);
      i = j;
    } while (j >= 0);
    paramList.add(paramT);
    return paramList.size() - 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */