package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Streams;
import com.mopub.mobileads.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdAlertReporter {
    private static final String BODY_SEPARATOR = "\n=================\n";
    private static final String DATE_FORMAT_PATTERN = "M/d/yy hh:mm:ss a z";
    private static final String EMAIL_RECIPIENT = "creative-review@mopub.com";
    private static final String EMAIL_SCHEME = "mailto:";
    private static final int IMAGE_QUALITY = 25;
    private static final String MARKUP_FILENAME = "mp_adalert_markup.html";
    private static final String PARAMETERS_FILENAME = "mp_adalert_parameters.txt";
    private static final String SCREEN_SHOT_FILENAME = "mp_adalert_screenshot.png";
    private final AdConfiguration mAdConfiguration;
    private final Context mContext;
    private final String mDateString;
    private ArrayList<Uri> mEmailAttachments;
    private Intent mEmailIntent;
    private String mParameters;
    private String mResponse;
    private final View mView;

    public AdAlertReporter(Context paramContext, View paramView, AdConfiguration paramAdConfiguration) {
        this.mView = paramView;
        this.mContext = paramContext;
        this.mAdConfiguration = paramAdConfiguration;
        this.mEmailAttachments = new ArrayList();
        this.mDateString = new SimpleDateFormat("M/d/yy hh:mm:ss a z").format(DateAndTime.now());
        initEmailIntent();
        paramContext = takeScreenShot();
        paramView = convertBitmapInWEBPToBase64EncodedString(paramContext);
        this.mParameters = formParameters();
        this.mResponse = getResponseString();
        addEmailSubject();
        addEmailBody(new String[]{this.mParameters, this.mResponse, paramView});
        addTextAttachment("mp_adalert_parameters.txt", this.mParameters);
        addTextAttachment("mp_adalert_markup.html", this.mResponse);
        addImageAttachment("mp_adalert_screenshot.png", paramContext);
    }

    private void addEmailBody(String... paramVarArgs) {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < paramVarArgs.length) {
            localStringBuilder.append(paramVarArgs[i]);
            if (i != paramVarArgs.length - 1) {
                localStringBuilder.append("\n=================\n");
            }
            i += 1;
        }
        this.mEmailIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
    }

    private void addEmailSubject() {
        this.mEmailIntent.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.mDateString);
    }

    private void addImageAttachment(String paramString, Bitmap paramBitmap) {
        Object localObject1 = null;
        if ((paramString == null) || (paramBitmap == null)) {
            return;
        }
        try {
            FileOutputStream localFileOutputStream = this.mContext.openFileOutput(paramString, 1);
            localObject1 = localFileOutputStream;
            Object localObject2 = localFileOutputStream;
            Streams.closeStream((Closeable) localObject2);
        } catch (Exception paramBitmap) {
            try {
                paramBitmap.compress(Bitmap.CompressFormat.PNG, 25, localFileOutputStream);
                localObject1 = localFileOutputStream;
                localObject2 = localFileOutputStream;
                paramBitmap = Uri.fromFile(new File(this.mContext.getFilesDir() + File.separator + paramString));
                localObject1 = localFileOutputStream;
                localObject2 = localFileOutputStream;
                this.mEmailAttachments.add(paramBitmap);
                Streams.closeStream(localFileOutputStream);
                return;
            } finally {
                for (; ; ) {
                }
            }
            paramBitmap = paramBitmap;
            localObject2 = localObject1;
            MoPubLog.d("Unable to write text attachment to file: " + paramString);
            Streams.closeStream((Closeable) localObject1);
            return;
        } finally {
            paramString =finally;
            localObject2 = null;
        }
        throw paramString;
    }

    private void addTextAttachment(String paramString1, String paramString2) {
        Object localObject1 = null;
        if ((paramString1 == null) || (paramString2 == null)) {
            return;
        }
        try {
            FileOutputStream localFileOutputStream = this.mContext.openFileOutput(paramString1, 1);
            localObject1 = localFileOutputStream;
            Object localObject2 = localFileOutputStream;
            Streams.closeStream((Closeable) localObject2);
        } catch (Exception paramString2) {
            try {
                localFileOutputStream.write(paramString2.getBytes());
                localObject1 = localFileOutputStream;
                localObject2 = localFileOutputStream;
                paramString2 = Uri.fromFile(new File(this.mContext.getFilesDir() + File.separator + paramString1));
                localObject1 = localFileOutputStream;
                localObject2 = localFileOutputStream;
                this.mEmailAttachments.add(paramString2);
                Streams.closeStream(localFileOutputStream);
                return;
            } finally {
                for (; ; ) {
                }
            }
            paramString2 = paramString2;
            localObject2 = localObject1;
            MoPubLog.d("Unable to write text attachment to file: " + paramString1);
            Streams.closeStream((Closeable) localObject1);
            return;
        } finally {
            paramString1 =finally;
            localObject2 = null;
        }
        throw paramString1;
    }

    private void appendKeyValue(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
        paramStringBuilder.append(paramString1);
        paramStringBuilder.append(" : ");
        paramStringBuilder.append(paramString2);
        paramStringBuilder.append("\n");
    }

    private String convertBitmapInWEBPToBase64EncodedString(Bitmap paramBitmap) {
        Object localObject = null;
        if (paramBitmap != null) {
        }
        try {
            localObject = new ByteArrayOutputStream();
            paramBitmap.compress(Bitmap.CompressFormat.JPEG, 25, (OutputStream) localObject);
            localObject = Base64.encodeToString(((ByteArrayOutputStream) localObject).toByteArray(), 0);
            return (String) localObject;
        } catch (Exception paramBitmap) {
        }
        return null;
    }

    private String formParameters() {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.mAdConfiguration != null) {
            appendKeyValue(localStringBuilder, "sdk_version", this.mAdConfiguration.getSdkVersion());
            appendKeyValue(localStringBuilder, "creative_id", this.mAdConfiguration.getDspCreativeId());
            appendKeyValue(localStringBuilder, "platform_version", Integer.toString(this.mAdConfiguration.getPlatformVersion()));
            appendKeyValue(localStringBuilder, "device_model", this.mAdConfiguration.getDeviceModel());
            appendKeyValue(localStringBuilder, "ad_unit_id", this.mAdConfiguration.getAdUnitId());
            appendKeyValue(localStringBuilder, "device_locale", this.mAdConfiguration.getDeviceLocale());
            appendKeyValue(localStringBuilder, "device_id", this.mAdConfiguration.getHashedUdid());
            appendKeyValue(localStringBuilder, "network_type", this.mAdConfiguration.getNetworkType());
            appendKeyValue(localStringBuilder, "platform", this.mAdConfiguration.getPlatform());
            appendKeyValue(localStringBuilder, "timestamp", getFormattedTimeStamp(this.mAdConfiguration.getTimeStamp()));
            appendKeyValue(localStringBuilder, "ad_type", this.mAdConfiguration.getAdType());
            appendKeyValue(localStringBuilder, "ad_size", "{" + this.mAdConfiguration.getWidth() + ", " + this.mAdConfiguration.getHeight() + "}");
        }
        return localStringBuilder.toString();
    }

    private String getFormattedTimeStamp(long paramLong) {
        if (paramLong != -1L) {
            return new SimpleDateFormat("M/d/yy hh:mm:ss a z").format(new Date(paramLong));
        }
        return null;
    }

    private String getResponseString() {
        if (this.mAdConfiguration != null) {
            return this.mAdConfiguration.getResponseString();
        }
        return "";
    }

    private void initEmailIntent() {
        this.mEmailIntent = new Intent("android.intent.action.SEND_MULTIPLE", Uri.parse("mailto:"));
        this.mEmailIntent.setType("plain/text");
        this.mEmailIntent.putExtra("android.intent.extra.EMAIL", new String[]{"creative-review@mopub.com"});
    }

    private Bitmap takeScreenShot() {
        if ((this.mView == null) || (this.mView.getRootView() == null)) {
        }
        View localView;
        boolean bool;
        do {
            return null;
            localView = this.mView.getRootView();
            bool = localView.isDrawingCacheEnabled();
            localView.setDrawingCacheEnabled(true);
            localBitmap = localView.getDrawingCache();
        } while (localBitmap == null);
        Bitmap localBitmap = Bitmap.createBitmap(localBitmap);
        localView.setDrawingCacheEnabled(bool);
        return localBitmap;
    }

    @Deprecated
    ArrayList<Uri> getEmailAttachments() {
        return this.mEmailAttachments;
    }

    @Deprecated
    Intent getEmailIntent() {
        return this.mEmailIntent;
    }

    @Deprecated
    String getParameters() {
        return this.mParameters;
    }

    @Deprecated
    String getResponse() {
        return this.mResponse;
    }

    public void send() {
        this.mEmailIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mEmailAttachments);
        Intent localIntent = Intent.createChooser(this.mEmailIntent, "Send Email...");
        localIntent.addFlags(268435456);
        this.mContext.startActivity(localIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdAlertReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */