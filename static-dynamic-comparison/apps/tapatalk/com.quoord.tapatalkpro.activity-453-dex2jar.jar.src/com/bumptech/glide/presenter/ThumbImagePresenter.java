package com.bumptech.glide.presenter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ThumbImagePresenter<A, B>
        implements ImagePresenter.ImagePresenterCoordinator {
    private final ImagePresenter<A> fullPresenter;
    private final ImagePresenter<B> thumbPresenter;

    private ThumbImagePresenter(Builder<A, B> paramBuilder) {
        ImagePresenter.Builder localBuilder = paramBuilder.fullPresenterBuilder.setImagePresenterCoordinator(this).setImageView(paramBuilder.imageView).setPlaceholderResource(0);
        if (paramBuilder.placeholderDrawable == null) {
        }
        for (Drawable localDrawable = paramBuilder.imageView.getResources().getDrawable(paramBuilder.placeholderResourceId); ; localDrawable = paramBuilder.placeholderDrawable) {
            this.fullPresenter = localBuilder.setPlaceholderDrawable(localDrawable).build();
            this.thumbPresenter = paramBuilder.thumbPresenterBuilder.setImagePresenterCoordinator(this).setImageView(paramBuilder.imageView).setPlaceholderDrawable(null).setPlaceholderResource(0).build();
            return;
        }
    }

    public boolean canSetImage(ImagePresenter paramImagePresenter) {
        return (paramImagePresenter == this.fullPresenter) || (!this.fullPresenter.isImageSet());
    }

    public boolean canSetPlaceholder(ImagePresenter paramImagePresenter) {
        return paramImagePresenter == this.fullPresenter;
    }

    public void clear() {
        this.fullPresenter.clear();
        this.thumbPresenter.clear();
    }

    public void resetPlaceholder() {
        this.fullPresenter.resetPlaceHolder();
    }

    public void setModels(A paramA, B paramB) {
        this.fullPresenter.setModel(paramA);
        if (!this.fullPresenter.isImageSet()) {
            this.thumbPresenter.setModel(paramB);
        }
    }

    public static class Builder<A, B> {
        private ImagePresenter.Builder<A> fullPresenterBuilder;
        private ImageView imageView;
        private Drawable placeholderDrawable;
        private int placeholderResourceId;
        private ImagePresenter.Builder<B> thumbPresenterBuilder;

        public ThumbImagePresenter<A, B> build() {
            if (this.fullPresenterBuilder == null) {
                throw new IllegalArgumentException("you must include a builder for the full image presenter");
            }
            if (this.thumbPresenterBuilder == null) {
                throw new IllegalArgumentException("you must include a builder for the thumb image presenter");
            }
            if (this.imageView == null) {
                throw new IllegalArgumentException("cannot create presenter without an image view");
            }
            return new ThumbImagePresenter(this, null);
        }

        public Builder<A, B> setFullPresenterBuilder(ImagePresenter.Builder<A> paramBuilder) {
            this.fullPresenterBuilder = paramBuilder;
            return this;
        }

        public Builder<A, B> setImageView(ImageView paramImageView) {
            this.imageView = paramImageView;
            return this;
        }

        public Builder<A, B> setPlaceholderDrawable(Drawable paramDrawable) {
            if ((paramDrawable != null) && (this.placeholderResourceId != 0)) {
                throw new IllegalArgumentException("Can't set both a placeholder drawable and a placeholder resource");
            }
            this.placeholderDrawable = paramDrawable;
            return this;
        }

        public Builder<A, B> setPlaceholderResource(int paramInt) {
            if ((paramInt != 0) && (this.placeholderDrawable != null)) {
                throw new IllegalArgumentException("Can't set both a placeholder drawable and a placeholder resource");
            }
            this.placeholderResourceId = paramInt;
            return this;
        }

        public Builder<A, B> setThumbPresenterBuilder(ImagePresenter.Builder<B> paramBuilder) {
            this.thumbPresenterBuilder = paramBuilder;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/presenter/ThumbImagePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */