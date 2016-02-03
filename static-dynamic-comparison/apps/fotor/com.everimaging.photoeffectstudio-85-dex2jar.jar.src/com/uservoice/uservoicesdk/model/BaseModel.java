package com.uservoice.uservoicesdk.model;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Html;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.rest.RestMethod;
import com.uservoice.uservoicesdk.rest.RestTask;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseModel {
    protected int id;

    protected static String apiPath(String paramString, Object... paramVarArgs) {
        return "/api/v1" + String.format(paramString, paramVarArgs);
    }

    protected static List<BaseModel> deserializeHeterogenousList(JSONObject paramJSONObject, String paramString)
            throws JSONException {
        if (!paramJSONObject.has(paramString)) {
            return null;
        }
        paramString = paramJSONObject.getJSONArray(paramString);
        ArrayList localArrayList = new ArrayList(paramString.length());
        int i = 0;
        if (i < paramString.length()) {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            paramJSONObject = localJSONObject.getString("type");
            if (paramJSONObject.equals("suggestion")) {
            }
            for (paramJSONObject = new Suggestion(); ; paramJSONObject = new Article()) {
                paramJSONObject.load(localJSONObject);
                localArrayList.add(paramJSONObject);
                do {
                    i += 1;
                    break;
                } while (!paramJSONObject.equals("article"));
            }
        }
        return localArrayList;
    }

    protected static <T extends BaseModel> List<T> deserializeList(JSONObject paramJSONObject, String paramString, Class<T> paramClass)
            throws JSONException {
        if (!paramJSONObject.has(paramString)) {
            return null;
        }
        try {
            paramJSONObject = paramJSONObject.getJSONArray(paramString);
            paramString = new ArrayList(paramJSONObject.length());
            int i = 0;
            while (i < paramJSONObject.length()) {
                BaseModel localBaseModel = (BaseModel) paramClass.newInstance();
                localBaseModel.load(paramJSONObject.getJSONObject(i));
                paramString.add(localBaseModel);
                i += 1;
            }
            return paramString;
        } catch (IllegalArgumentException paramJSONObject) {
            throw new JSONException("Reflection failed trying to call load on " + paramClass + " " + paramJSONObject.getMessage());
        } catch (IllegalAccessException paramJSONObject) {
            throw new JSONException("Reflection failed trying to call load on " + paramClass + " " + paramJSONObject.getMessage());
        } catch (InstantiationException paramJSONObject) {
            throw new JSONException("Reflection failed trying to instantiate " + paramClass + " " + paramJSONObject.getMessage());
        }
    }

    protected static <T extends BaseModel> T deserializeObject(JSONObject paramJSONObject, String paramString, Class<T> paramClass)
            throws JSONException {
        if (!paramJSONObject.has(paramString)) {
            return null;
        }
        try {
            paramString = paramJSONObject.getJSONObject(paramString);
            BaseModel localBaseModel = (BaseModel) paramClass.newInstance();
            localBaseModel.load(paramString);
            paramString = (BaseModel) paramClass.cast(localBaseModel);
            return paramString;
        } catch (JSONException paramString) {
            throw new JSONException("JSON deserialization failure for " + paramClass + " " + paramString.getMessage() + " JSON: " + paramJSONObject.toString());
        } catch (IllegalArgumentException paramJSONObject) {
            throw new JSONException("Reflection failed trying to call load on " + paramClass + " " + paramJSONObject.getMessage());
        } catch (IllegalAccessException paramJSONObject) {
            throw new JSONException("Reflection failed trying to call load on " + paramClass + " " + paramJSONObject.getMessage());
        } catch (InstantiationException paramJSONObject) {
            throw new JSONException("Reflection failed trying to instantiate " + paramClass + " " + paramJSONObject.getMessage());
        }
    }

    protected static RestTask doDelete(String paramString, RestTaskCallback paramRestTaskCallback) {
        return doDelete(paramString, null, paramRestTaskCallback);
    }

    protected static RestTask doDelete(String paramString, Map<String, String> paramMap, RestTaskCallback paramRestTaskCallback) {
        paramString = new RestTask(RestMethod.DELETE, paramString, paramMap, paramRestTaskCallback);
        paramString.execute(new String[0]);
        return paramString;
    }

    protected static RestTask doGet(String paramString, RestTaskCallback paramRestTaskCallback) {
        return doGet(paramString, null, paramRestTaskCallback);
    }

    protected static RestTask doGet(String paramString, Map<String, String> paramMap, RestTaskCallback paramRestTaskCallback) {
        paramString = new RestTask(RestMethod.GET, paramString, paramMap, paramRestTaskCallback);
        paramString.execute(new String[0]);
        return paramString;
    }

    protected static RestTask doPost(String paramString, RestTaskCallback paramRestTaskCallback) {
        return doPost(paramString, null, paramRestTaskCallback);
    }

    protected static RestTask doPost(String paramString, Map<String, String> paramMap, RestTaskCallback paramRestTaskCallback) {
        paramString = new RestTask(RestMethod.POST, paramString, paramMap, paramRestTaskCallback);
        paramString.execute(new String[0]);
        return paramString;
    }

    protected static RestTask doPut(String paramString, RestTaskCallback paramRestTaskCallback) {
        return doPut(paramString, null, paramRestTaskCallback);
    }

    protected static RestTask doPut(String paramString, Map<String, String> paramMap, RestTaskCallback paramRestTaskCallback) {
        paramString = new RestTask(RestMethod.PUT, paramString, paramMap, paramRestTaskCallback);
        paramString.execute(new String[0]);
        return paramString;
    }

    protected static ClientConfig getClientConfig() {
        return getSession().getClientConfig();
    }

    protected static Config getConfig() {
        return getSession().getConfig();
    }

    protected static Session getSession() {
        return Session.getInstance();
    }

    public static <T extends BaseModel> T load(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, Class<T> paramClass) {
        try {
            paramSharedPreferences = deserializeObject(new JSONObject(paramSharedPreferences.getString(paramString1, "{}")), paramString2, paramClass);
            return paramSharedPreferences;
        } catch (JSONException paramSharedPreferences) {
        }
        return null;
    }

    @SuppressLint({"SimpleDateFormat"})
    protected Date getDate(JSONObject paramJSONObject, String paramString)
            throws JSONException {
        paramJSONObject = getString(paramJSONObject, paramString);
        paramString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z");
        try {
            paramString = paramString.parse(paramJSONObject);
            return paramString;
        } catch (ParseException paramString) {
            throw new JSONException("Could not parse date: " + paramJSONObject);
        }
    }

    protected String getHtml(JSONObject paramJSONObject, String paramString)
            throws JSONException {
        if (paramJSONObject.isNull(paramString)) {
            return null;
        }
        return paramJSONObject.getString(paramString);
    }

    public int getId() {
        return this.id;
    }

    protected String getString(JSONObject paramJSONObject, String paramString)
            throws JSONException {
        if (paramJSONObject.isNull(paramString)) {
            return null;
        }
        return Html.fromHtml(paramJSONObject.getString(paramString)).toString().trim();
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        this.id = paramJSONObject.getInt("id");
    }

    public boolean persist(SharedPreferences paramSharedPreferences, String paramString1, String paramString2) {
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        try {
            save(localJSONObject2);
            localJSONObject1.put(paramString2, localJSONObject2);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putString(paramString1, localJSONObject1.toString());
            return paramSharedPreferences.commit();
        } catch (JSONException paramSharedPreferences) {
        }
        return false;
    }

    public void save(JSONObject paramJSONObject)
            throws JSONException {
        paramJSONObject.put("id", this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/BaseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */