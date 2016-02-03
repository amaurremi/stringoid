package com.facebook.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class FacebookDialog$PhotoDialogBuilderBase<CONCRETE extends PhotoDialogBuilderBase<?>>
        extends FacebookDialog.Builder<CONCRETE> {
    static int MAXIMUM_PHOTO_COUNT = 6;
    private ArrayList<String> friends;
    private ArrayList<String> imageAttachmentUrls = new ArrayList();
    private String place;

    public FacebookDialog$PhotoDialogBuilderBase(Activity paramActivity) {
        super(paramActivity);
    }

    public CONCRETE addPhotoFiles(Collection<File> paramCollection) {
        this.imageAttachmentUrls.addAll(addImageAttachmentFiles(paramCollection));
        return this;
    }

    public CONCRETE addPhotos(Collection<Bitmap> paramCollection) {
        this.imageAttachmentUrls.addAll(addImageAttachments(paramCollection));
        return this;
    }

    abstract int getMaximumNumberOfPhotos();

    protected Bundle getMethodArguments() {
        Bundle localBundle = new Bundle();
        putExtra(localBundle, "PLACE", this.place);
        localBundle.putStringArrayList("PHOTOS", this.imageAttachmentUrls);
        if (!Utility.isNullOrEmpty(this.friends)) {
            localBundle.putStringArrayList("FRIENDS", this.friends);
        }
        return localBundle;
    }

    protected Bundle setBundleExtras(Bundle paramBundle) {
        putExtra(paramBundle, "com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        putExtra(paramBundle, "com.facebook.platform.extra.APPLICATION_NAME", this.applicationName);
        putExtra(paramBundle, "com.facebook.platform.extra.PLACE", this.place);
        paramBundle.putStringArrayList("com.facebook.platform.extra.PHOTOS", this.imageAttachmentUrls);
        if (!Utility.isNullOrEmpty(this.friends)) {
            paramBundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", this.friends);
        }
        return paramBundle;
    }

    public CONCRETE setFriends(List<String> paramList) {
        this.friends = new ArrayList(paramList);
        return this;
    }

    public CONCRETE setPlace(String paramString) {
        this.place = paramString;
        return this;
    }

    void validate() {
        super.validate();
        if (this.imageAttachmentUrls.isEmpty()) {
            throw new FacebookException("Must specify at least one photo.");
        }
        if (this.imageAttachmentUrls.size() > getMaximumNumberOfPhotos()) {
            throw new FacebookException(String.format("Cannot add more than %d photos.", new Object[]{Integer.valueOf(getMaximumNumberOfPhotos())}));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$PhotoDialogBuilderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */