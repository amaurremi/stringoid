package com.quoord.xmlrpc;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

class JSONEntity
        extends StringEntity {
    public JSONEntity(JSONObject paramJSONObject)
            throws UnsupportedEncodingException {
        super(paramJSONObject.toString());
    }

    public JSONEntity(JSONObject paramJSONObject, String paramString)
            throws UnsupportedEncodingException {
        super(paramJSONObject.toString(), paramString);
        setContentEncoding(paramString);
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "application/json");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/JSONEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */