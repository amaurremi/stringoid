package com.uservoice.uservoicesdk.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomField
        extends BaseModel {
    private String name;
    private List<String> predefinedValues;
    private boolean required;

    public String getName() {
        return this.name;
    }

    public List<String> getPredefinedValues() {
        return this.predefinedValues;
    }

    public boolean isPredefined() {
        return this.predefinedValues.size() > 0;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        int i = 0;
        super.load(paramJSONObject);
        this.name = getString(paramJSONObject, "name");
        if (!paramJSONObject.getBoolean("allow_blank")) {
        }
        for (boolean bool = true; ; bool = false) {
            this.required = bool;
            this.predefinedValues = new ArrayList();
            if (!paramJSONObject.has("possible_values")) {
                break;
            }
            paramJSONObject = paramJSONObject.getJSONArray("possible_values");
            while (i < paramJSONObject.length()) {
                JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
                this.predefinedValues.add(getString(localJSONObject, "value"));
                i += 1;
            }
        }
    }

    public void save(JSONObject paramJSONObject)
            throws JSONException {
        super.save(paramJSONObject);
        paramJSONObject.put("name", this.name);
        if (!this.required) {
        }
        JSONArray localJSONArray;
        for (boolean bool = true; ; bool = false) {
            paramJSONObject.put("allow_blank", bool);
            localJSONArray = new JSONArray();
            Iterator localIterator = this.predefinedValues.iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("value", str);
                localJSONArray.put(localJSONObject);
            }
        }
        paramJSONObject.put("possible_values", localJSONArray);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/CustomField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */