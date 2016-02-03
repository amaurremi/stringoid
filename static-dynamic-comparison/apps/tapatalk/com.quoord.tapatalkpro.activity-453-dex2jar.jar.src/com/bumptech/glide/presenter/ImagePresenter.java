package com.bumptech.glide.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.loader.image.ImageLoader;
import com.bumptech.glide.loader.image.ImageLoader.ImageReadyCallback;
import com.bumptech.glide.loader.model.ModelLoader;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.loader.transformation.None;
import com.bumptech.glide.loader.transformation.TransformationLoader;
import com.bumptech.glide.presenter.target.ImageViewTarget;
import com.bumptech.glide.presenter.target.Target;
import com.bumptech.glide.presenter.target.Target.SizeReadyCallback;
import com.bumptech.glide.resize.load.Transformation;

public class ImagePresenter<T> {
    private static final String TAG = "ImagePresenter";
    private final ImagePresenterCoordinator coordinator;
    private int currentCount;
    private T currentModel;
    private final Drawable errorDrawable;
    private final ExceptionHandler<T> exceptionHandler;
    private final ImageLoader imageLoader;
    private final ImageReadyCallback<T> imageReadyCallback;
    private Object imageToken;
    private boolean isErrorSet = false;
    private boolean isImageSet = false;
    private boolean loadedFromCache = false;
    private final ModelLoader<T> modelLoader;
    private final Drawable placeholderDrawable;
    private final Target target;
    private final TransformationLoader<T> transformationLoader;

    protected ImagePresenter(Builder<T> paramBuilder) {
        this.imageLoader = paramBuilder.imageLoader;
        this.transformationLoader = paramBuilder.transformationLoader;
        Resources localResources = paramBuilder.context.getResources();
        if (paramBuilder.placeholderResourceId != 0) {
            this.placeholderDrawable = localResources.getDrawable(paramBuilder.placeholderResourceId);
            if (paramBuilder.errorResourceId == 0) {
                break label133;
            }
        }
        label133:
        for (this.errorDrawable = localResources.getDrawable(paramBuilder.errorResourceId); ; this.errorDrawable = paramBuilder.errorDrawable) {
            this.coordinator = paramBuilder.coordinator;
            this.imageReadyCallback = paramBuilder.imageReadyCallback;
            this.exceptionHandler = paramBuilder.exceptionHandler;
            this.modelLoader = paramBuilder.modelLoader;
            this.target = paramBuilder.target;
            return;
            this.placeholderDrawable = paramBuilder.placeholderDrawable;
            break;
        }
    }

    private boolean canSetImage() {
        return (this.coordinator == null) || (this.coordinator.canSetImage(this));
    }

    private boolean canSetPlaceholder() {
        return (this.coordinator == null) || (this.coordinator.canSetPlaceholder(this));
    }

    private void fetchImage(final T paramT, int paramInt1, int paramInt2, final int paramInt3) {
        this.imageLoader.clear();
        String str = this.modelLoader.getId(paramT);
        StreamLoader localStreamLoader = this.modelLoader.getStreamLoader(paramT, paramInt1, paramInt2);
        if ((str == null) || (localStreamLoader == null)) {
            if (Log.isLoggable("ImagePresenter", 4)) {
                Log.i("ImagePresenter", "got null model id or stream loader model=" + paramT + " id=" + str + " stream loader=" + localStreamLoader);
            }
            clear();
            return;
        }
        Transformation localTransformation = this.transformationLoader.getTransformation(paramT);
        this.imageToken = this.imageLoader.fetchImage(str, localStreamLoader, localTransformation, paramInt1, paramInt2, new ImageLoader.ImageReadyCallback() {
            public void onException(Exception paramAnonymousException) {
                if (paramInt3 == ImagePresenter.this.currentCount) {
                }
                for (boolean bool = true; ; bool = false) {
                    if ((bool) && (ImagePresenter.this.canSetPlaceholder()) && (ImagePresenter.this.errorDrawable != null)) {
                        ImagePresenter.this.isErrorSet = true;
                        ImagePresenter.this.target.setPlaceholder(ImagePresenter.this.errorDrawable);
                    }
                    if (ImagePresenter.this.exceptionHandler != null) {
                        ImagePresenter.this.exceptionHandler.onException(paramAnonymousException, paramT, bool);
                    }
                    return;
                }
            }

            public boolean onImageReady(Bitmap paramAnonymousBitmap) {
                if ((paramInt3 != ImagePresenter.this.currentCount) || (!ImagePresenter.this.canSetImage()) || (paramAnonymousBitmap == null)) {
                    return false;
                }
                ImagePresenter.this.target.onImageReady(paramAnonymousBitmap);
                if (ImagePresenter.this.imageReadyCallback != null) {
                    ImagePresenter.this.imageReadyCallback.onImageReady(paramT, ImagePresenter.this.target, ImagePresenter.this.loadedFromCache);
                }
                ImagePresenter.this.isImageSet = true;
                return true;
            }
        });
    }

    public void clear() {
        this.currentCount += 1;
        resetPlaceHolder();
        this.currentModel = null;
        this.isImageSet = false;
        this.isErrorSet = false;
        this.imageLoader.clear();
    }

    protected boolean isImageSet() {
        return this.isImageSet;
    }

    public void resetPlaceHolder() {
        if (!canSetPlaceholder()) {
            return;
        }
        this.target.setPlaceholder(this.placeholderDrawable);
    }

    public void setModel(final T paramT) {
        if (paramT == null) {
            clear();
        }
        do {
            do {
                return;
            } while (paramT.equals(this.currentModel));
            this.loadedFromCache = true;
            final int i = this.currentCount + 1;
            this.currentCount = i;
            this.currentModel = paramT;
            this.isImageSet = false;
            this.isErrorSet = false;
            this.target.getSize(new Target.SizeReadyCallback() {
                public void onSizeReady(int paramAnonymousInt1, int paramAnonymousInt2) {
                    ImagePresenter.this.fetchImage(paramT, paramAnonymousInt1, paramAnonymousInt2, i);
                }
            });
            this.loadedFromCache = false;
        } while ((this.isImageSet) || (this.isErrorSet));
        resetPlaceHolder();
    }

    public static class Builder<T> {
        private Context context;
        private ImagePresenter.ImagePresenterCoordinator coordinator;
        private Drawable errorDrawable;
        private int errorResourceId;
        private ImagePresenter.ExceptionHandler<T> exceptionHandler = new ImagePresenter.ExceptionHandler() {
            public void onException(Exception paramAnonymousException, T paramAnonymousT, boolean paramAnonymousBoolean) {
                if (Log.isLoggable("ImagePresenter", 6)) {
                    Log.e("ImagePresenter", "onImageLoadException model= " + paramAnonymousT, paramAnonymousException);
                }
            }
        };
        private ImageLoader imageLoader;
        private ImagePresenter.ImageReadyCallback<T> imageReadyCallback;
        private ModelLoader<T> modelLoader;
        private Drawable placeholderDrawable;
        private int placeholderResourceId;
        private Target target;
        private TransformationLoader<T> transformationLoader;

        public ImagePresenter<T> build() {
            if (this.target == null) {
                throw new IllegalArgumentException("cannot create presenter without a target");
            }
            if (this.imageLoader == null) {
                throw new IllegalArgumentException("cannot create presenter without an image loader");
            }
            if (this.modelLoader == null) {
                throw new IllegalArgumentException("cannot create presenter without a model loader");
            }
            if (this.transformationLoader == null) {
                this.transformationLoader = new None();
            }
            return new ImagePresenter(this);
        }

        public Builder<T> setErrorDrawable(Drawable paramDrawable) {
            if ((this.errorResourceId != 0) && (paramDrawable != null)) {
                throw new IllegalArgumentException("Can't set both an error drawable and an error resource");
            }
            this.errorDrawable = paramDrawable;
            return this;
        }

        public Builder<T> setErrorResource(int paramInt) {
            if ((paramInt != 0) && (this.errorDrawable != null)) {
                throw new IllegalArgumentException("Can't set both an error drawable and an error resource");
            }
            this.errorResourceId = paramInt;
            return this;
        }

        public Builder<T> setExceptionHandler(ImagePresenter.ExceptionHandler<T> paramExceptionHandler) {
            this.exceptionHandler = paramExceptionHandler;
            return this;
        }

        public Builder<T> setImageLoader(ImageLoader paramImageLoader) {
            this.imageLoader = paramImageLoader;
            return this;
        }

        public Builder<T> setImagePresenterCoordinator(ImagePresenter.ImagePresenterCoordinator paramImagePresenterCoordinator) {
            this.coordinator = paramImagePresenterCoordinator;
            return this;
        }

        public Builder<T> setImageReadyCallback(ImagePresenter.ImageReadyCallback<T> paramImageReadyCallback) {
            this.imageReadyCallback = paramImageReadyCallback;
            return this;
        }

        public Builder<T> setImageView(ImageView paramImageView) {
            setTarget(new ImageViewTarget(paramImageView), paramImageView.getContext());
            return this;
        }

        public Builder<T> setModelLoader(ModelLoader<T> paramModelLoader) {
            this.modelLoader = paramModelLoader;
            return this;
        }

        public Builder<T> setPlaceholderDrawable(Drawable paramDrawable) {
            if ((paramDrawable != null) && (this.placeholderResourceId != 0)) {
                throw new IllegalArgumentException("Can't set both a placeholder drawable and a placeholder resource");
            }
            this.placeholderDrawable = paramDrawable;
            return this;
        }

        public Builder<T> setPlaceholderResource(int paramInt) {
            if ((paramInt != 0) && (this.placeholderDrawable != null)) {
                throw new IllegalArgumentException("Can't set both a placeholder drawable and a placeholder resource");
            }
            this.placeholderResourceId = paramInt;
            return this;
        }

        public Builder<T> setTarget(Target paramTarget, Context paramContext) {
            this.target = paramTarget;
            this.context = paramContext;
            return this;
        }

        public Builder<T> setTransformationLoader(TransformationLoader<T> paramTransformationLoader) {
            this.transformationLoader = paramTransformationLoader;
            return this;
        }
    }

    public static abstract interface ExceptionHandler<T> {
        public abstract void onException(Exception paramException, T paramT, boolean paramBoolean);
    }

    public static abstract interface ImagePresenterCoordinator {
        public abstract boolean canSetImage(ImagePresenter paramImagePresenter);

        public abstract boolean canSetPlaceholder(ImagePresenter paramImagePresenter);
    }

    public static abstract interface ImageReadyCallback<T> {
        public abstract void onImageReady(T paramT, Target paramTarget, boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/presenter/ImagePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */