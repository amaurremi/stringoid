package com.quoord.tools.uploadanddownload;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import com.quoord.tapatalkpro.activity.UploadActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;

import java.io.File;

public class UploadImage {
    public static final String API_KEY = "xxxxx";
    public static String SD_CARD_TEMP_DIR = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";

    public static void startUpload(Activity paramActivity, Uri paramUri, ForumStatus paramForumStatus, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("uri", paramUri);
        localBundle.putSerializable("forumstatus", paramForumStatus);
        if ((paramString1 != null) && (!paramString1.equals(""))) {
            localBundle.putSerializable("forumId", paramString1);
        }
        if ((paramString2 != null) && (!paramString2.equals(""))) {
            localBundle.putSerializable("groupId", paramString2);
        }
        localBundle.putSerializable("round", Integer.valueOf(0));
        localBundle.putBoolean("isAvatar", paramBoolean1);
        localBundle.putBoolean("isConver", paramBoolean2);
        localBundle.putBoolean("canUpload", paramBoolean3);
        localBundle.putInt("size", paramInt);
        paramUri = new Intent();
        paramUri.putExtras(localBundle);
        paramUri.setClass(paramActivity, UploadActivity.class);
        paramActivity.startActivityForResult(paramUri, 7);
    }

    public static void uploadForumCamera(Activity paramActivity) {
        File localFile = new File(SD_CARD_TEMP_DIR);
        try {
            Uri.parse(MediaStore.Images.Media.insertImage(paramActivity.getContentResolver(), localFile.getAbsolutePath(), null, null));
            localFile.delete();
            System.gc();
            return;
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
        }
    }

    public static void uploadForumGallery(Activity paramActivity, Uri paramUri) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/uploadanddownload/UploadImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */