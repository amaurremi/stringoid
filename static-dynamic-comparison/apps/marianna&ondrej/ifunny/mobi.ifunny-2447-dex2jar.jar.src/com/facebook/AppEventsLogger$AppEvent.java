package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

class AppEventsLogger$AppEvent
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final HashSet<String> validatedIdentifiers = new HashSet();
    private boolean isImplicit;
    private JSONObject jsonObject;
    private String name;

    public AppEventsLogger$AppEvent(Context paramContext, String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean) {
        try {
            validateIdentifier(paramString);
            this.name = paramString;
            this.isImplicit = paramBoolean;
            this.jsonObject = new JSONObject();
            this.jsonObject.put("_eventName", paramString);
            this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000L);
            this.jsonObject.put("_ui", Utility.getActivityName(paramContext));
            if (paramDouble != null) {
                this.jsonObject.put("_valueToSum", paramDouble.doubleValue());
            }
            if (this.isImplicit) {
                this.jsonObject.put("_implicitlyLogged", "1");
            }
            paramContext = Settings.getAppVersion();
            if (paramContext != null) {
                this.jsonObject.put("_appVersion", paramContext);
            }
            if (paramBundle == null) {
                break label287;
            }
            paramContext = paramBundle.keySet().iterator();
        } catch (JSONException paramContext) {
            for (; ; ) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[]{paramContext.toString()});
                this.jsonObject = null;
                return;
                this.jsonObject.put(paramString, paramDouble.toString());
            }
        } catch (FacebookException paramContext) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", new Object[]{paramContext.toString()});
            this.jsonObject = null;
            return;
        }
        if (paramContext.hasNext()) {
            paramString = (String) paramContext.next();
            validateIdentifier(paramString);
            paramDouble = paramBundle.get(paramString);
            if ((!(paramDouble instanceof String)) && (!(paramDouble instanceof Number))) {
                throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{paramDouble, paramString}));
            }
        }
        label287:
        while (this.isImplicit) {
        }
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", new Object[]{this.jsonObject.toString()});
    }

    private AppEventsLogger$AppEvent(String paramString, boolean paramBoolean) {
        this.jsonObject = new JSONObject(paramString);
        this.isImplicit = paramBoolean;
    }

    private void validateIdentifier(String paramString) {
        if ((paramString == null) || (paramString.length() == 0) || (paramString.length() > 40)) {
            ???=paramString;
            if (paramString == null) {
                ???="<None Provided>";
            }
            throw new FacebookException(String.format("Identifier '%s' must be less than %d characters", new Object[]{ ? ? ?,
            Integer.valueOf(40)}));
        }
        synchronized (validatedIdentifiers) {
            boolean bool = validatedIdentifiers.contains(paramString);
            if (!bool) {
                if (!paramString.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                    break label114;
                }
            }
        }
        synchronized (validatedIdentifiers) {
            validatedIdentifiers.add(paramString);
            return;
            paramString =finally;
            throw paramString;
        }
        label114:
        throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{paramString}));
    }

    private Object writeReplace() {
        return new AppEventsLogger.AppEvent.SerializationProxyV1(this.jsonObject.toString(), this.isImplicit, null);
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$AppEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */