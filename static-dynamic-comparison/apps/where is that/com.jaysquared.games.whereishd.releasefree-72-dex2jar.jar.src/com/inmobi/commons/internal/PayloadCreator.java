package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import java.util.List;

public abstract interface PayloadCreator
{
  public abstract String toPayloadString(List<Sample> paramList, List<ActivityRecognitionSampler.ActivitySample> paramList1, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/PayloadCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */