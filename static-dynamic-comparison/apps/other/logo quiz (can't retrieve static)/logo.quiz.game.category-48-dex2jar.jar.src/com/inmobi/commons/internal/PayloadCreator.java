package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import java.util.List;

public abstract interface PayloadCreator
{
  public abstract String toPayloadString(List<Sample> paramList, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/PayloadCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */