package com.millennialmedia.android;

import org.json.JSONException;
import org.json.JSONObject;

class MMJSResponse {
    String a;
    String b;
    int c;
    Object d;
    byte[] e;

    static MMJSResponse a() {
        return a("Success.");
    }

    static MMJSResponse a(String paramString) {
        MMJSResponse localMMJSResponse = new MMJSResponse();
        localMMJSResponse.c = 1;
        localMMJSResponse.d = paramString;
        return localMMJSResponse;
    }

    static MMJSResponse b() {
        return b("An unknown error occured.");
    }

    static MMJSResponse b(String paramString) {
        MMJSResponse localMMJSResponse = new MMJSResponse();
        localMMJSResponse.c = 0;
        localMMJSResponse.d = paramString;
        return localMMJSResponse;
    }

    String c() {
        try {
            JSONObject localJSONObject = new JSONObject();
            if (this.a != null) {
                localJSONObject.put("class", this.a);
            }
            if (this.b != null) {
                localJSONObject.put("call", this.b);
            }
            localJSONObject.put("result", this.c);
            if (this.d != null) {
                localJSONObject.put("response", this.d);
            }
            for (; ; ) {
                return localJSONObject.toString();
                if (this.e == null) {
                    break;
                }
                localJSONObject.put("response", Base64.encodeToString(this.e, false));
            }
            return "";
        } catch (JSONException localJSONException) {
            MMLog.e("MMJSResponse", localJSONException.getMessage());
            return "";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMJSResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */