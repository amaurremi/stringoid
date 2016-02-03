package com.facebook.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class FacebookDialog$OpenGraphDialogBuilderBase<CONCRETE extends OpenGraphDialogBuilderBase<?>>
        extends FacebookDialog.Builder<CONCRETE> {
    private OpenGraphAction action;
    private String actionType;
    private boolean dataErrorsFatal;
    private String previewPropertyName;

    public FacebookDialog$OpenGraphDialogBuilderBase(Activity paramActivity, OpenGraphAction paramOpenGraphAction, String paramString) {
        super(paramActivity);
        Validate.notNull(paramOpenGraphAction, "action");
        Validate.notNullOrEmpty(paramOpenGraphAction.getType(), "action.getType()");
        Validate.notNullOrEmpty(paramString, "previewPropertyName");
        if (paramOpenGraphAction.getProperty(paramString) == null) {
            throw new IllegalArgumentException("A property named \"" + paramString + "\" was not found on the action.  The name of " + "the preview property must match the name of an action property.");
        }
        this.action = paramOpenGraphAction;
        this.actionType = paramOpenGraphAction.getType();
        this.previewPropertyName = paramString;
    }

    @Deprecated
    public FacebookDialog$OpenGraphDialogBuilderBase(Activity paramActivity, OpenGraphAction paramOpenGraphAction, String paramString1, String paramString2) {
        super(paramActivity);
        Validate.notNull(paramOpenGraphAction, "action");
        Validate.notNullOrEmpty(paramString1, "actionType");
        Validate.notNullOrEmpty(paramString2, "previewPropertyName");
        if (paramOpenGraphAction.getProperty(paramString2) == null) {
            throw new IllegalArgumentException("A property named \"" + paramString2 + "\" was not found on the action.  The name of " + "the preview property must match the name of an action property.");
        }
        paramActivity = paramOpenGraphAction.getType();
        if ((!Utility.isNullOrEmpty(paramActivity)) && (!paramActivity.equals(paramString1))) {
            throw new IllegalArgumentException("'actionType' must match the type of 'action' if it is specified. Consider using OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction action, String previewPropertyName) instead.");
        }
        this.action = paramOpenGraphAction;
        this.actionType = paramString1;
        this.previewPropertyName = paramString2;
    }

    private JSONObject flattenChildrenOfGraphObject(JSONObject paramJSONObject) {
        try {
            paramJSONObject = new JSONObject(paramJSONObject.toString());
            Iterator localIterator = paramJSONObject.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                if (!str.equalsIgnoreCase("image")) {
                    paramJSONObject.put(str, flattenObject(paramJSONObject.get(str)));
                }
            }
            return paramJSONObject;
        } catch (JSONException paramJSONObject) {
            throw new FacebookException(paramJSONObject);
        }
    }

    private Object flattenObject(Object paramObject) {
        if (paramObject == null) {
            localObject = null;
        }
        do {
            JSONObject localJSONObject;
            do {
                do {
                    return localObject;
                    if (!(paramObject instanceof JSONObject)) {
                        break;
                    }
                    localJSONObject = (JSONObject) paramObject;
                    localObject = paramObject;
                } while (localJSONObject.optBoolean("fbsdk:create_object"));
                if (localJSONObject.has("id")) {
                    return localJSONObject.getString("id");
                }
                localObject = paramObject;
            } while (!localJSONObject.has("url"));
            return localJSONObject.getString("url");
            localObject = paramObject;
        } while (!(paramObject instanceof JSONArray));
        paramObject = (JSONArray) paramObject;
        Object localObject = new JSONArray();
        int j = ((JSONArray) paramObject).length();
        int i = 0;
        while (i < j) {
            ((JSONArray) localObject).put(flattenObject(((JSONArray) paramObject).get(i)));
            i += 1;
        }
        return localObject;
    }

    private void updateActionAttachmentUrls(List<String> paramList, boolean paramBoolean) {
        Object localObject = this.action.getImage();
        if (localObject == null) {
            localObject = new ArrayList(paramList.size());
        }
        for (; ; ) {
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                String str = (String) paramList.next();
                JSONObject localJSONObject = new JSONObject();
                try {
                    localJSONObject.put("url", str);
                    if (paramBoolean) {
                        localJSONObject.put("user_generated", true);
                    }
                    ((List) localObject).add(localJSONObject);
                } catch (JSONException paramList) {
                    throw new FacebookException("Unable to attach images", paramList);
                }
            }
            this.action.setImage((List) localObject);
            return;
        }
    }

    protected Bundle getMethodArguments() {
        Bundle localBundle = new Bundle();
        putExtra(localBundle, "PREVIEW_PROPERTY_NAME", this.previewPropertyName);
        putExtra(localBundle, "ACTION_TYPE", this.actionType);
        localBundle.putBoolean("DATA_FAILURES_FATAL", this.dataErrorsFatal);
        putExtra(localBundle, "ACTION", flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
        return localBundle;
    }

    protected Bundle setBundleExtras(Bundle paramBundle) {
        putExtra(paramBundle, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", this.previewPropertyName);
        putExtra(paramBundle, "com.facebook.platform.extra.ACTION_TYPE", this.actionType);
        paramBundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", this.dataErrorsFatal);
        putExtra(paramBundle, "com.facebook.platform.extra.ACTION", flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
        return paramBundle;
    }

    public CONCRETE setDataErrorsFatal(boolean paramBoolean) {
        this.dataErrorsFatal = paramBoolean;
        return this;
    }

    public CONCRETE setImageAttachmentFilesForAction(List<File> paramList) {
        return setImageAttachmentFilesForAction(paramList, false);
    }

    public CONCRETE setImageAttachmentFilesForAction(List<File> paramList, boolean paramBoolean) {
        Validate.containsNoNulls(paramList, "bitmapFiles");
        if (this.action == null) {
            throw new FacebookException("Can not set attachments prior to setting action.");
        }
        updateActionAttachmentUrls(addImageAttachmentFiles(paramList), paramBoolean);
        return this;
    }

    public CONCRETE setImageAttachmentFilesForObject(String paramString, List<File> paramList) {
        return setImageAttachmentFilesForObject(paramString, paramList, false);
    }

    public CONCRETE setImageAttachmentFilesForObject(String paramString, List<File> paramList, boolean paramBoolean) {
        Validate.notNull(paramString, "objectProperty");
        Validate.containsNoNulls(paramList, "bitmapFiles");
        if (this.action == null) {
            throw new FacebookException("Can not set attachments prior to setting action.");
        }
        updateObjectAttachmentUrls(paramString, addImageAttachmentFiles(paramList), paramBoolean);
        return this;
    }

    public CONCRETE setImageAttachmentsForAction(List<Bitmap> paramList) {
        return setImageAttachmentsForAction(paramList, false);
    }

    public CONCRETE setImageAttachmentsForAction(List<Bitmap> paramList, boolean paramBoolean) {
        Validate.containsNoNulls(paramList, "bitmaps");
        if (this.action == null) {
            throw new FacebookException("Can not set attachments prior to setting action.");
        }
        updateActionAttachmentUrls(addImageAttachments(paramList), paramBoolean);
        return this;
    }

    public CONCRETE setImageAttachmentsForObject(String paramString, List<Bitmap> paramList) {
        return setImageAttachmentsForObject(paramString, paramList, false);
    }

    public CONCRETE setImageAttachmentsForObject(String paramString, List<Bitmap> paramList, boolean paramBoolean) {
        Validate.notNull(paramString, "objectProperty");
        Validate.containsNoNulls(paramList, "bitmaps");
        if (this.action == null) {
            throw new FacebookException("Can not set attachments prior to setting action.");
        }
        updateObjectAttachmentUrls(paramString, addImageAttachments(paramList), paramBoolean);
        return this;
    }

    void updateObjectAttachmentUrls(String paramString, List<String> paramList, boolean paramBoolean) {
        OpenGraphObject localOpenGraphObject;
        try {
            localOpenGraphObject = (OpenGraphObject) this.action.getPropertyAs(paramString, OpenGraphObject.class);
            if (localOpenGraphObject == null) {
                throw new IllegalArgumentException("Action does not contain a property '" + paramString + "'");
            }
        } catch (FacebookGraphObjectException paramList) {
            throw new IllegalArgumentException("Property '" + paramString + "' is not a graph object");
        }
        if (!localOpenGraphObject.getCreateObject()) {
            throw new IllegalArgumentException("The Open Graph object in '" + paramString + "' is not marked for creation");
        }
        paramString = localOpenGraphObject.getImage();
        if (paramString == null) {
            paramString = GraphObject.Factory.createList(GraphObject.class);
        }
        for (; ; ) {
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                String str = (String) paramList.next();
                GraphObject localGraphObject = GraphObject.Factory.create();
                localGraphObject.setProperty("url", str);
                if (paramBoolean) {
                    localGraphObject.setProperty("user_generated", Boolean.valueOf(true));
                }
                paramString.add(localGraphObject);
            }
            localOpenGraphObject.setImage(paramString);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$OpenGraphDialogBuilderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */