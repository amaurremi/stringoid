package com.uservoice.uservoicesdk.model;

import android.content.SharedPreferences;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTaskCallback;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientConfig
        extends BaseModel {
    private String accountName;
    private List<CustomField> customFields;
    private int defaultForumId;
    private String defaultSort;
    private boolean feedbackEnabled;
    private String key;
    private String secret;
    private String subdomainId;
    private boolean ticketsEnabled;
    private boolean whiteLabel;

    public static void loadClientConfig(final Callback<ClientConfig> paramCallback) {
        if (Session.getInstance().getConfig().getKey() == null) {
        }
        final String str2;
        final SharedPreferences localSharedPreferences;
        for (String str1 = "/clients/default.json"; ; str1 = "/client.json") {
            str2 = String.format("uv-client-%s-%s", new Object[]{Session.getInstance().getConfig().getSite(), Session.getInstance().getConfig().getKey()});
            localSharedPreferences = Session.getInstance().getSharedPreferences();
            ClientConfig localClientConfig = (ClientConfig) load(localSharedPreferences, str2, "client", ClientConfig.class);
            if (localClientConfig == null) {
                break;
            }
            paramCallback.onModel(localClientConfig);
            doGet(apiPath(str1, new Object[0]), new RestTaskCallback(paramCallback) {
                public void onComplete(JSONObject paramAnonymousJSONObject)
                        throws JSONException {
                    ((ClientConfig) BaseModel.deserializeObject(paramAnonymousJSONObject, "client", ClientConfig.class)).persist(localSharedPreferences, str2, "client");
                }
            });
            return;
        }
        doGet(apiPath(str1, new Object[0]), new RestTaskCallback(paramCallback) {
            public void onComplete(JSONObject paramAnonymousJSONObject)
                    throws JSONException {
                paramAnonymousJSONObject = (ClientConfig) BaseModel.deserializeObject(paramAnonymousJSONObject, "client", ClientConfig.class);
                paramAnonymousJSONObject.persist(localSharedPreferences, str2, "client");
                paramCallback.onModel(paramAnonymousJSONObject);
            }
        });
    }

    public String getAccountName() {
        return this.accountName;
    }

    public List<CustomField> getCustomFields() {
        return this.customFields;
    }

    public int getDefaultForumId() {
        return this.defaultForumId;
    }

    public String getKey() {
        return this.key;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getSubdomainId() {
        return this.subdomainId;
    }

    public String getSuggestionSort() {
        if (this.defaultSort.equals("new")) {
            return "newest";
        }
        if (this.defaultSort.equals("hot")) {
            return "hot";
        }
        return "votes";
    }

    public boolean isFeedbackEnabled() {
        return this.feedbackEnabled;
    }

    public boolean isTicketSystemEnabled() {
        return this.ticketsEnabled;
    }

    public boolean isWhiteLabel() {
        return this.whiteLabel;
    }

    public void load(JSONObject paramJSONObject)
            throws JSONException {
        super.load(paramJSONObject);
        this.ticketsEnabled = paramJSONObject.getBoolean("tickets_enabled");
        this.feedbackEnabled = paramJSONObject.getBoolean("feedback_enabled");
        this.whiteLabel = paramJSONObject.getBoolean("white_label");
        this.defaultForumId = paramJSONObject.getJSONObject("forum").getInt("id");
        this.customFields = deserializeList(paramJSONObject, "custom_fields", CustomField.class);
        this.defaultSort = getString(paramJSONObject.getJSONObject("subdomain"), "default_sort");
        this.subdomainId = getString(paramJSONObject.getJSONObject("subdomain"), "id");
        this.accountName = getString(paramJSONObject.getJSONObject("subdomain"), "name");
        this.key = paramJSONObject.getString("key");
        if (paramJSONObject.has("secret")) {
        }
        for (paramJSONObject = paramJSONObject.getString("secret"); ; paramJSONObject = null) {
            this.secret = paramJSONObject;
            return;
        }
    }

    public void save(JSONObject paramJSONObject)
            throws JSONException {
        super.save(paramJSONObject);
        paramJSONObject.put("tickets_enabled", this.ticketsEnabled);
        paramJSONObject.put("feedback_enabled", this.feedbackEnabled);
        paramJSONObject.put("white_label", this.whiteLabel);
        Object localObject = new JSONObject();
        ((JSONObject) localObject).put("id", this.defaultForumId);
        paramJSONObject.put("forum", localObject);
        localObject = new JSONArray();
        Iterator localIterator = this.customFields.iterator();
        while (localIterator.hasNext()) {
            CustomField localCustomField = (CustomField) localIterator.next();
            JSONObject localJSONObject = new JSONObject();
            localCustomField.save(localJSONObject);
            ((JSONArray) localObject).put(localJSONObject);
        }
        paramJSONObject.put("custom_fields", localObject);
        localObject = new JSONObject();
        ((JSONObject) localObject).put("id", this.subdomainId);
        ((JSONObject) localObject).put("default_sort", this.defaultSort);
        ((JSONObject) localObject).put("name", this.accountName);
        paramJSONObject.put("subdomain", localObject);
        paramJSONObject.put("key", this.key);
        if (this.secret != null) {
            paramJSONObject.put("secret", this.secret);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/model/ClientConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */