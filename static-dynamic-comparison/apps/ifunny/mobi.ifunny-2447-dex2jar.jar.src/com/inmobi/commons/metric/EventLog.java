package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;
import org.json.JSONObject;

public class EventLog {
    private EventType a;
    private JSONObject b;

    public EventLog(EventType paramEventType, JSONObject paramJSONObject) {
        this.a = paramEventType;
        this.b = paramJSONObject;
    }

    public String toString() {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("t", this.a.getValue());
            localJSONObject.put("v", this.b);
            return localJSONObject.toString();
        } catch (Exception localException) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "Unable to log json.", localException);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/metric/EventLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */