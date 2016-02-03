package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import com.quoord.DialogUtil.UploadDialog;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadAdapter
        extends BaseAdapter {
    public ByteArrayOutputStream buffer;
    public Uri fileUri;
    public int height;
    public String imageName;
    public int image_quality = 0;
    public boolean isFromGallery;
    public boolean isLogin;
    public String mAttachmentId;
    private Activity mContext;
    private Bitmap mImage;
    private int mRotate;
    public int mSize;
    public UploadDialog mUploadDialog;
    private Uri mUri = null;
    public int maxJpgSize;
    public String mimeType;
    public int newSize;
    public int realSize;
    public int width;

    public UploadAdapter(Activity paramActivity) {
        this.mContext = paramActivity;
    }

    public UploadAdapter(Activity paramActivity, int paramInt) {
        this.mContext = paramActivity;
        this.maxJpgSize = paramInt;
    }

    public void closeByteStream() {
        if (this.buffer != null) {
        }
        try {
            this.buffer.close();
            return;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
    }

    public int getAUID() {
        return Prefs.get(this.mContext).getInt("tapatalk_auid", 0);
    }

    public ByteArrayOutputStream getAvatarByteStream(ForumStatus paramForumStatus) {
        Object localObject = this.buffer.toByteArray();
        int i = localObject.length / 70000;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = ((int) Math.sqrt(i) + 1);
        this.mImage = BitmapFactory.decodeByteArray((byte[]) localObject, 0, localObject.length, localOptions);
        localObject = new Matrix();
        i = this.mImage.getWidth();
        int j = this.mImage.getHeight();
        float f;
        if ((paramForumStatus.isXF()) || (paramForumStatus.isIP())) {
            if (i > j) {
                f = 256.0F / i;
            }
        }
        for (; ; ) {
            if (this.mRotate != 0) {
                ((Matrix) localObject).postRotate(-this.mRotate);
            }
            ((Matrix) localObject).postScale(f, f);
            this.mImage = Bitmap.createBitmap(this.mImage, 0, 0, i, j, (Matrix) localObject, true);
            paramForumStatus = new ByteArrayOutputStream();
            this.mImage.compress(Bitmap.CompressFormat.JPEG, 90, paramForumStatus);
            this.realSize = paramForumStatus.size();
            return paramForumStatus;
            f = 256.0F / j;
            continue;
            if (i > j) {
                f = 90.0F / i;
            } else {
                f = 90.0F / j;
            }
        }
    }

    public ByteArrayOutputStream getByteStream() {
        if (this.buffer == null) {
            this.buffer = new ByteArrayOutputStream();
            this.mImage.compress(Bitmap.CompressFormat.JPEG, 90, this.buffer);
        }
        this.realSize = this.buffer.size();
        return this.buffer;
    }

    public int getCount() {
        return 1;
    }

    public ByteArrayOutputStream getFileStream() {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte['Ѐ'];
        for (; ; ) {
            try {
                InputStream localInputStream = this.mContext.getContentResolver().openInputStream(this.fileUri);
                i = localInputStream.read(arrayOfByte, 0, arrayOfByte.length);
                if (i != -1) {
                    continue;
                }
                localByteArrayOutputStream.flush();
            } catch (FileNotFoundException localFileNotFoundException) {
                int i;
                localFileNotFoundException.printStackTrace();
                continue;
            } catch (IOException localIOException) {
                localIOException.printStackTrace();
                continue;
            }
            this.mSize = localByteArrayOutputStream.size();
            this.realSize = localByteArrayOutputStream.size();
            return localByteArrayOutputStream;
            localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
    }

    public Bitmap getImage() {
        return this.mImage;
    }

    public InputStream getInputStream() {
        try {
            InputStream localInputStream = this.mContext.getContentResolver().openInputStream(this.fileUri);
            return localInputStream;
        } catch (FileNotFoundException localFileNotFoundException) {
            localFileNotFoundException.printStackTrace();
            return null;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return null;
    }

    public Object getItem(int paramInt) {
        return null;
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public ByteArrayOutputStream getTkByteStream() {
        if (this.buffer.size() < 300000) {
            this.realSize = this.buffer.size();
            return this.buffer;
        }
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options) localObject).inSampleSize = ((int) Math.ceil(Math.cbrt(this.buffer.size() / 300000 + 1)));
        byte[] arrayOfByte = this.buffer.toByteArray();
        try {
            this.buffer.close();
        } catch (IOException localIOException) {
            try {
                for (; ; ) {
                    this.mImage = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, (BitmapFactory.Options) localObject);
                    localObject = new ByteArrayOutputStream();
                    this.mImage.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream) localObject);
                    this.realSize = ((ByteArrayOutputStream) localObject).size();
                    return (ByteArrayOutputStream) localObject;
                    localIOException = localIOException;
                    localIOException.printStackTrace();
                }
            } catch (OutOfMemoryError localOutOfMemoryError) {
                for (; ; ) {
                    System.gc();
                    localOutOfMemoryError.printStackTrace();
                }
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                }
            }
        }
    }

    public Uri getUri() {
        return this.mUri;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = this.mContext.getLayoutInflater().inflate(2130903419, null);
        ((ImageView) paramView.findViewById(2131231034)).setImageBitmap(this.mImage);
        return paramView;
    }

    public View getView(boolean paramBoolean) {
        View localView = this.mContext.getLayoutInflater().inflate(2130903419, null);
        ((ImageView) localView.findViewById(2131231034)).setImageBitmap(this.mImage);
        ((RadioGroup) localView.findViewById(2131231706)).setVisibility(8);
        return localView;
    }

    public void recycle() {
        if (this.mImage != null) {
            this.mImage.recycle();
        }
        if (this.buffer != null) {
        }
        try {
            this.buffer.close();
            return;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
    }

    public void recycleAll() {
        try {
            this.mImage.recycle();
            return;
        } catch (Exception localException) {
        }
    }

    public void resizeImigeForAvatar() {
        this.mImage = Bitmap.createBitmap(this.mImage, 0, 0, 90, 90);
    }

    public void setUri(Uri paramUri, int paramInt) {
        this.fileUri = paramUri;
        this.isFromGallery = true;
        this.mRotate = paramInt;
        this.mUri = paramUri;
        Object localObject1 = this.mContext.managedQuery(paramUri, new String[]{"mime_type", "_display_name", "_size"}, null, null, null);
        if ((localObject1 != null) && (((Cursor) localObject1).moveToFirst())) {
            this.mimeType = ((Cursor) localObject1).getString(0);
            this.imageName = ((Cursor) localObject1).getString(1);
            if (this.mSize == 0) {
                this.mSize = ((Cursor) localObject1).getInt(2);
            }
        }
        for (; ; ) {
            int i;
            int j;
            try {
                localObject1 = this.mContext.getContentResolver().openInputStream(paramUri);
                try {
                    if (this.mImage != null) {
                        this.mImage.recycle();
                    }
                    this.buffer = new ByteArrayOutputStream();
                    if (this.mSize < 100000) {
                        this.mImage = BitmapFactory.decodeStream((InputStream) localObject1);
                        if (paramInt != 0) {
                            paramUri = new Matrix();
                            i = this.mImage.getWidth();
                            j = this.mImage.getHeight();
                            paramUri.postRotate(-paramInt);
                            this.mImage = Bitmap.createBitmap(this.mImage, 0, 0, i, j, paramUri, true);
                        }
                        this.mImage.compress(Bitmap.CompressFormat.JPEG, 85, this.buffer);
                        this.width = this.mImage.getWidth();
                        this.height = this.mImage.getHeight();
                        ((InputStream) localObject1).close();
                        return;
                    }
                } catch (Exception localException) {
                    localException.printStackTrace();
                    continue;
                }
                localObject2 = new BitmapFactory.Options();
            } catch (Exception paramUri) {
                paramUri.printStackTrace();
                return;
            }
            Object localObject2;
            ((BitmapFactory.Options) localObject2).inSampleSize = ((int) Math.sqrt(this.mSize / 70000) + 1);
            this.mImage = BitmapFactory.decodeStream((InputStream) localObject1, null, (BitmapFactory.Options) localObject2);
            if (paramInt != 0) {
                localObject2 = new Matrix();
                i = this.mImage.getWidth();
                j = this.mImage.getHeight();
                ((Matrix) localObject2).postRotate(-paramInt);
                this.mImage = Bitmap.createBitmap(this.mImage, 0, 0, i, j, (Matrix) localObject2, true);
            }
            ((InputStream) localObject1).close();
            InputStream localInputStream = this.mContext.getContentResolver().openInputStream(paramUri);
            if ((this.mSize > this.maxJpgSize) && (this.maxJpgSize < 300000) && (this.maxJpgSize > 1)) {
                localObject1 = Util.decodeLocalImageUri(this.mContext, paramUri, 1024, 1024);
                if (this.buffer != null) {
                    this.buffer.close();
                }
                this.buffer = new ByteArrayOutputStream();
                paramUri = (Uri) localObject1;
                if (paramInt != 0) {
                    paramUri = new Matrix();
                    i = ((Bitmap) localObject1).getWidth();
                    j = ((Bitmap) localObject1).getHeight();
                    paramUri.postRotate(-paramInt);
                    paramUri = Bitmap.createBitmap((Bitmap) localObject1, 0, 0, i, j, paramUri, true);
                }
                paramUri.compress(Bitmap.CompressFormat.JPEG, 70, this.buffer);
                this.width = paramUri.getWidth();
                this.height = paramUri.getHeight();
                paramUri.recycle();
                localObject1 = localInputStream;
            } else {
                localObject1 = Util.decodeLocalImageUri(this.mContext, paramUri, 1024, 1024);
                paramUri = (Uri) localObject1;
                if (paramInt != 0) {
                    paramUri = new Matrix();
                    i = ((Bitmap) localObject1).getWidth();
                    j = ((Bitmap) localObject1).getHeight();
                    paramUri.postRotate(-paramInt);
                    paramUri = Bitmap.createBitmap((Bitmap) localObject1, 0, 0, i, j, paramUri, true);
                }
                this.width = paramUri.getWidth();
                this.height = paramUri.getHeight();
                localObject1 = Double.valueOf(1.0D);
                if (paramUri.getHeight() > 1024) {
                    localObject1 = Double.valueOf(1024.0D / paramUri.getHeight());
                }
                localObject2 = localObject1;
                if (paramUri.getWidth() > 1024) {
                    localObject2 = localObject1;
                    if (((Double) localObject1).doubleValue() > 1024 / paramUri.getWidth()) {
                        localObject2 = Double.valueOf(1024.0D / paramUri.getWidth());
                    }
                }
                localObject1 = paramUri;
                if (((Double) localObject2).doubleValue() < 1.0D) {
                    localObject1 = Bitmap.createScaledBitmap(paramUri, (int) Math.round(paramUri.getWidth() * ((Double) localObject2).doubleValue()), (int) Math.round(paramUri.getHeight() * ((Double) localObject2).doubleValue()), true);
                }
                if (this.buffer != null) {
                    this.buffer.close();
                }
                this.buffer = new ByteArrayOutputStream();
                ((Bitmap) localObject1).compress(Bitmap.CompressFormat.JPEG, 70, this.buffer);
                this.width = ((Bitmap) localObject1).getWidth();
                this.height = ((Bitmap) localObject1).getHeight();
                ((Bitmap) localObject1).recycle();
                localObject1 = localInputStream;
            }
        }
    }

    public void setUri(Uri paramUri, int paramInt1, int paramInt2) {
        this.mSize = paramInt1;
        setUri(paramUri, paramInt2);
        this.isFromGallery = false;
    }

    public void setUri2(Uri paramUri, int paramInt) {
        this.fileUri = paramUri;
        this.isFromGallery = true;
        this.mRotate = paramInt;
        this.mUri = paramUri;
    }

    public void updateProgress(int paramInt) {
        if (this.mUploadDialog != null) {
            this.mUploadDialog.updateDialog(paramInt);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/UploadAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */