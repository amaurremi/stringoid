package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.thinICE.icedatacollector.Sample;

import java.util.List;

public abstract interface PayloadCreator {
    public abstract String toPayloadString(List<Sample> paramList, List<ActivityRecognitionSampler.ActivitySample> paramList1, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/PayloadCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */