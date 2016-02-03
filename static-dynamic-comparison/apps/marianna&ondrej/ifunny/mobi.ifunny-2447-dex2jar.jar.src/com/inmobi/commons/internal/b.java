package com.inmobi.commons.internal;

import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEListener;

import java.util.List;

final class b
        implements ThinICEListener {
    public void onSamplingTerminated(List<Sample> paramList) {
        ThinICE.a(paramList);
        IceDataCollector.stop();
        ActivityRecognitionSampler.stop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */