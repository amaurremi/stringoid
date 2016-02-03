package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tools.ForumHttpStatus;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class AvatarTool {
    public static final int TYPE_AVATAR = 0;
    public static final int TYPE_BANNER = 7;
    public static final int TYPE_BLOG = 6;
    public static final int TYPE_FORUM_LOGO = 5;
    public static final int TYPE_SUBFORUM = 3;
    public static final int TYPE_TOPIC_IMAGE = 11;
    public static AsyncBitmapLoader asyncLoader = new AsyncBitmapLoader();

    public static String getLocalUrl(Context paramContext, int paramInt, String paramString) {
        if (paramInt == 5) {
            return AppCacheManager.getFavForumLogoCacheDir(paramContext) + paramString.hashCode() + ".0";
        }
        return AppCacheManager.getRemoteImageCacheDir(paramContext) + "/" + paramString.hashCode();
    }

    public static void setAvater(Context paramContext, GifImageView paramGifImageView, CustomBitmapWithType paramCustomBitmapWithType, String paramString) {
        paramString = new File(getLocalUrl(paramContext, 0, paramString));
        if (!paramString.exists()) {
            setDefaultAvaterBitmap(paramGifImageView, paramContext);
            return;
        }
        if (paramCustomBitmapWithType.imageType.equals(ImageItem.GIF)) {
        }
        try {
            paramContext = new FileInputStream(paramString);
            if (paramContext == null) {
                break label86;
            }
            try {
                if (paramContext.available() <= 30000) {
                    break label86;
                }
                paramContext.close();
                setAvaterBitmap(paramGifImageView, paramCustomBitmapWithType.tempBitmap);
                return;
            } catch (Exception paramContext) {
            }
        } catch (Exception paramContext) {
            for (; ; ) {
            }
        }
        setAvaterBitmap(paramGifImageView, paramCustomBitmapWithType.tempBitmap);
        return;
        label86:
        paramGifImageView.setIs(paramContext);
        return;
        setAvaterBitmap(paramGifImageView, paramCustomBitmapWithType.tempBitmap);
    }

    public static void setAvaterBitmap(GifImageView paramGifImageView, Bitmap paramBitmap) {
        paramGifImageView.setIcon(paramBitmap);
        paramGifImageView.invalidate();
    }

    public static void setBannerBitmap(ImageView paramImageView, CustomBitmapWithType paramCustomBitmapWithType) {
        paramImageView.setVisibility(0);
        paramImageView.setImageBitmap(paramCustomBitmapWithType.tempBitmap);
        paramImageView.invalidate();
    }

    public static void setBlogLogo(Context paramContext, ImageView paramImageView, CustomBitmapWithType paramCustomBitmapWithType, String paramString) {
        if (!new File(getLocalUrl(paramContext, 6, paramString)).exists()) {
            setDefaultBitMap(paramImageView, 6, paramContext);
            return;
        }
        float f = paramCustomBitmapWithType.tempBitmap.getWidth();
        if (paramCustomBitmapWithType.tempBitmap.getHeight() > paramContext.getResources().getDimensionPixelOffset(2131427356) + 180) {
            paramImageView.setScaleType(ImageView.ScaleType.CENTER);
        }
        for (; ; ) {
            paramImageView.setImageBitmap(paramCustomBitmapWithType.tempBitmap);
            return;
            paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public static void setDefaultAvaterBitmap(GifImageView paramGifImageView, Context paramContext) {
        paramGifImageView.setRes(ThemeUtil.getDialogDrawableId("default_avatar", paramContext));
        paramGifImageView.invalidate();
    }

    public static void setDefaultBitMap(ImageView paramImageView, int paramInt, Context paramContext) {
        if (paramInt == 3) {
            paramImageView.setImageResource(2130837860);
            return;
        }
        paramImageView.setImageDrawable(null);
    }

    public static void setForumLogo(Context paramContext, ImageView paramImageView, CustomBitmapWithType paramCustomBitmapWithType, String paramString) {
        if (!new File(getLocalUrl(paramContext, 5, paramString)).exists()) {
            setDefaultBitMap(paramImageView, 5, paramContext);
            return;
        }
        int i = paramCustomBitmapWithType.tempBitmap.getWidth();
        int j = paramCustomBitmapWithType.tempBitmap.getHeight();
        if ((i / j > 1.5D) || (j / i > 1.5D)) {
            paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        for (; ; ) {
            paramImageView.setImageBitmap(paramCustomBitmapWithType.tempBitmap);
            return;
            paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public static void setForumLogoFromFavUnread(Context paramContext, ImageView paramImageView, CustomBitmapWithType paramCustomBitmapWithType, String paramString) {
        if (!new File(getLocalUrl(paramContext, 5, paramString)).exists()) {
            setDefaultBitMap(paramImageView, 5, paramContext);
            return;
        }
        paramCustomBitmapWithType.tempBitmap.getWidth();
        paramCustomBitmapWithType.tempBitmap.getHeight();
        paramImageView.setScaleType(ImageView.ScaleType.CENTER);
        paramImageView.setImageBitmap(paramCustomBitmapWithType.tempBitmap);
    }

    public static void setSubForumLogo(Context paramContext, ImageView paramImageView, CustomBitmapWithType paramCustomBitmapWithType, String paramString) {
        if (!new File(getLocalUrl(paramContext, 3, paramString)).exists()) {
            setDefaultBitMap(paramImageView, 3, paramContext);
            return;
        }
        paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramImageView.setImageBitmap(paramCustomBitmapWithType.tempBitmap);
    }

    public static void setTopicImageAvater(Context paramContext, GifImageView paramGifImageView, CustomBitmapWithType paramCustomBitmapWithType, String paramString) {
        if (!new File(getLocalUrl(paramContext, 0, paramString)).exists()) {
            setDefaultAvaterBitmap(paramGifImageView, paramContext);
        }
        do {
            return;
            paramContext = paramCustomBitmapWithType.tempBitmap;
            float f1 = paramContext.getWidth();
            float f2 = paramContext.getHeight();
            paramCustomBitmapWithType = new Matrix();
            paramCustomBitmapWithType.postScale(120.0F / f1, 120.0F / f2);
            paramContext = Bitmap.createBitmap(paramContext, 0, 0, (int) f1, (int) f2, paramCustomBitmapWithType, true);
        } while (paramContext == null);
        paramGifImageView.setBackgroundDrawable(new BitmapDrawable(Util.getRoundCornerBitmap(paramContext, 70.0F)));
        paramGifImageView.invalidate();
    }

    public static void showAvatar(final Context paramContext, ForumHttpStatus paramForumHttpStatus, GifImageView paramGifImageView, String paramString, int paramInt) {
        if ((paramGifImageView.getTag() != null) && (paramGifImageView.getTag().equals(paramString))) {
            return;
        }
        paramGifImageView.setTag(paramString);
        if ((paramString == null) || (paramString.length() == 0)) {
            setDefaultAvaterBitmap(paramGifImageView, paramContext);
            return;
        }
        paramForumHttpStatus = asyncLoader.loadBitmap(paramContext, paramForumHttpStatus, paramGifImageView, paramString, new AsyncBitmapLoader.ImageCallBack() {
            public void imageLoad(View paramAnonymousView, CustomBitmapWithType paramAnonymousCustomBitmapWithType, String paramAnonymousString) {
                if ((paramAnonymousView.getTag() != null) && (paramAnonymousView.getTag().toString().equals(paramAnonymousString))) {
                    if (this.val$type == 11) {
                        AvatarTool.setTopicImageAvater(paramContext, (GifImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType, paramAnonymousString);
                    }
                } else {
                    return;
                }
                AvatarTool.setAvater(paramContext, (GifImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType, paramAnonymousString);
            }
        }, 0);
        if (paramForumHttpStatus == null) {
            setDefaultAvaterBitmap(paramGifImageView, paramContext);
            return;
        }
        if (paramInt == 11) {
            setTopicImageAvater(paramContext, paramGifImageView, paramForumHttpStatus, paramString);
            return;
        }
        setAvater(paramContext, paramGifImageView, paramForumHttpStatus, paramString);
    }

    public static void showLogo(final Context paramContext, ImageView paramImageView, String paramString, int paramInt) {
        if ((paramImageView.getTag() != null) && (paramImageView.getTag().equals(paramString))) {
            return;
        }
        paramImageView.setTag(paramString);
        if ((paramString == null) || (paramString.length() == 0)) {
            setDefaultBitMap(paramImageView, paramInt, paramContext);
            return;
        }
        CustomBitmapWithType localCustomBitmapWithType = asyncLoader.loadBitmap(paramContext, paramImageView, paramString, new AsyncBitmapLoader.ImageCallBack() {
            public void imageLoad(View paramAnonymousView, CustomBitmapWithType paramAnonymousCustomBitmapWithType, String paramAnonymousString) {
                if ((paramAnonymousView.getTag() != null) && (paramAnonymousView.getTag().toString().equals(paramAnonymousString))) {
                    if (this.val$type == 5) {
                        AvatarTool.setForumLogo(paramContext, (ImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType, paramAnonymousString);
                    }
                } else {
                    return;
                }
                if (this.val$type == 3) {
                    AvatarTool.setSubForumLogo(paramContext, (ImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType, paramAnonymousString);
                    return;
                }
                if (this.val$type == 7) {
                    AvatarTool.setBannerBitmap((ImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType);
                    return;
                }
                AvatarTool.setBlogLogo(paramContext, (ImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType, paramAnonymousString);
            }
        }, paramInt);
        if (localCustomBitmapWithType == null) {
            setDefaultBitMap(paramImageView, paramInt, paramContext);
            return;
        }
        if (paramInt == 5) {
            setForumLogo(paramContext, paramImageView, localCustomBitmapWithType, paramString);
            return;
        }
        if (paramInt == 3) {
            setSubForumLogo(paramContext, paramImageView, localCustomBitmapWithType, paramString);
            return;
        }
        if (paramInt == 7) {
            setBannerBitmap(paramImageView, localCustomBitmapWithType);
            return;
        }
        setBlogLogo(paramContext, paramImageView, localCustomBitmapWithType, paramString);
    }

    public static void showTrendingTopicLogo(Context paramContext, ForumHttpStatus paramForumHttpStatus, ImageView paramImageView1, String paramString, TextView paramTextView, ImageView paramImageView2) {
        if ((paramImageView1.getTag() != null) && (paramImageView1.getTag().equals(paramString))) {
            return;
        }
        paramImageView1.setTag(paramString);
        if ((paramString == null) || (paramString.length() == 0)) {
            paramTextView.setVisibility(0);
            paramImageView2.setVisibility(8);
            return;
        }
        paramTextView.setVisibility(8);
        paramImageView2.setVisibility(0);
        paramForumHttpStatus = asyncLoader.loadBitmap(paramContext, paramImageView1, paramString, new AsyncBitmapLoader.ImageCallBack() {
            public void imageLoad(View paramAnonymousView, CustomBitmapWithType paramAnonymousCustomBitmapWithType, String paramAnonymousString) {
                if ((paramAnonymousView.getTag() != null) && (paramAnonymousView.getTag().toString().equals(paramAnonymousString))) {
                    AvatarTool.setForumLogo(AvatarTool.this, (ImageView) paramAnonymousView, paramAnonymousCustomBitmapWithType, paramAnonymousString);
                }
            }
        }, 5);
        if (paramForumHttpStatus == null) {
            paramTextView.setVisibility(0);
            paramImageView2.setVisibility(8);
            return;
        }
        setForumLogo(paramContext, paramImageView1, paramForumHttpStatus, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/AvatarTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */