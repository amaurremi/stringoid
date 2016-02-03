package com.uservoice.uservoicesdk.model;

import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

public class Ticket
        extends BaseModel {
    public static void createTicket(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, final Callback<Ticket> paramCallback) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ticket[message]", paramString1);
        if (paramString2 != null) {
            localHashMap.put("email", paramString2);
        }
        if (paramString3 != null) {
            localHashMap.put("display_name", paramString3);
        }
        if (Babayaga.getUvts() != null) {
            localHashMap.put("uvts", Babayaga.getUvts());
        }
        paramString1 = getSession().getExternalIds().entrySet().iterator();
        while (paramString1.hasNext()) {
            paramString2 = (Map.Entry) paramString1.next();
            localHashMap.put(String.format("created_by[external_ids][%s]", new Object[]{paramString2.getKey()}), paramString2.getValue());
        }
        if (getConfig().getCustomFields() != null) {
            paramString1 = getConfig().getCustomFields().entrySet().iterator();
            while (paramString1.hasNext()) {
                paramString2 = (Map.Entry) paramString1.next();
                localHashMap.put(String.format("ticket[custom_field_values][%s]", new Object[]{paramString2.getKey()}), paramString2.getValue());
            }
        }
        if (paramMap != null) {
            paramString1 = paramMap.entrySet().iterator();
            while (paramString1.hasNext()) {
                paramString2 = (Map.Entry) paramString1.next();
                localHashMap.put(String.format("ticket[custom_field_values][%s]", new Object[]{paramString2.getKey()}), paramString2.getValue());
            }
        }
        doPost(apiPath("/tickets.json", new Object[0]), localHashMap, new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramCallback.onModel(BaseModel.deserializeObject(paramAnonymousJSONObject, "ticket", Ticket.class));
            }
        });
    }

    public static void createTicket(String paramString, Map<String, String> paramMap, Callback<Ticket> paramCallback) {
        createTicket(paramString, null, null, paramMap, paramCallback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/Ticket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */