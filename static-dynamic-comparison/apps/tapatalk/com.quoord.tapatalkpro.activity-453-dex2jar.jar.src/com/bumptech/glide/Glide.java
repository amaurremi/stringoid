package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.bumptech.glide.loader.image.ImageManagerLoader;
import com.bumptech.glide.loader.model.FileLoader.Factory;
import com.bumptech.glide.loader.model.GenericLoaderFactory;
import com.bumptech.glide.loader.model.ModelLoader;
import com.bumptech.glide.loader.model.ModelLoaderFactory;
import com.bumptech.glide.loader.model.ResourceLoader.Factory;
import com.bumptech.glide.loader.model.StringLoader.Factory;
import com.bumptech.glide.loader.model.UriLoader.Factory;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.loader.transformation.CenterCrop;
import com.bumptech.glide.loader.transformation.FitCenter;
import com.bumptech.glide.loader.transformation.MultiTransformationLoader;
import com.bumptech.glide.loader.transformation.None;
import com.bumptech.glide.loader.transformation.TransformationLoader;
import com.bumptech.glide.presenter.ImagePresenter;
import com.bumptech.glide.presenter.ImagePresenter.Builder;
import com.bumptech.glide.presenter.ImagePresenter.ExceptionHandler;
import com.bumptech.glide.presenter.ImagePresenter.ImageReadyCallback;
import com.bumptech.glide.presenter.target.ImageViewTarget;
import com.bumptech.glide.presenter.target.Target;
import com.bumptech.glide.resize.ImageManager;
import com.bumptech.glide.resize.ImageManager.Builder;
import com.bumptech.glide.resize.load.Downsampler;
import com.bumptech.glide.resize.load.Transformation;
import com.bumptech.glide.volley.VolleyUrlLoader.Factory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class Glide {
    private static final Glide GLIDE = new Glide();
    private static final String TAG = "Glide";
    private ImageManager imageManager = null;
    private final GenericLoaderFactory loaderFactory = new GenericLoaderFactory();
    private final Map<Target, Metadata> metadataTracker = new WeakHashMap();

    protected Glide() {
        this.loaderFactory.register(File.class, new FileLoader.Factory());
        this.loaderFactory.register(Integer.class, new ResourceLoader.Factory());
        this.loaderFactory.register(String.class, new StringLoader.Factory());
        this.loaderFactory.register(Uri.class, new UriLoader.Factory());
        try {
            Class.forName("com.bumptech.glide.volley.VolleyUrlLoader$Factory");
            this.loaderFactory.register(URL.class, new VolleyUrlLoader.Factory());
            return;
        } catch (ClassNotFoundException localClassNotFoundException) {
            if (Log.isLoggable("Glide", 3)) {
                Log.d("Glide", "Volley not found, missing url loader");
            }
            this.loaderFactory.register(URL.class, new ModelLoaderFactory() {
                ModelLoader<URL> errorUrlLoader = new ModelLoader() {
                    public String getId(URL paramAnonymous2URL) {
                        throw new IllegalArgumentException("No ModelLoaderFactory for urls registered with Glide");
                    }

                    public StreamLoader getStreamLoader(URL paramAnonymous2URL, int paramAnonymous2Int1, int paramAnonymous2Int2) {
                        throw new IllegalArgumentException("No ModelLoaderFactory for urls registered with Glide");
                    }
                };

                public ModelLoader<URL> build(Context paramAnonymousContext, GenericLoaderFactory paramAnonymousGenericLoaderFactory) {
                    return this.errorUrlLoader;
                }

                public Class<? extends ModelLoader<URL>> loaderClass() {
                    return this.errorUrlLoader.getClass();
                }

                public void teardown() {
                }
            });
        }
    }

    public static <T> ModelLoader<T> buildModelLoader(Class<T> paramClass, Context paramContext) {
        return GLIDE.loaderFactory.buildModelLoader(paramClass, paramContext);
    }

    public static boolean cancel(ImageView paramImageView) {
        paramImageView = GLIDE.getImageViewTarget(paramImageView);
        return (paramImageView != null) && (cancel(paramImageView));
    }

    public static boolean cancel(Target paramTarget) {
        paramTarget = paramTarget.getImagePresenter();
        if (paramTarget != null) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool) {
                paramTarget.clear();
            }
            return bool;
        }
    }

    public static Glide get() {
        return GLIDE;
    }

    private <T> ModelLoaderFactory<T> getFactory(T paramT) {
        return this.loaderFactory.getFactory(paramT.getClass());
    }

    private ImageViewTarget getImageViewTarget(ImageView paramImageView) {
        Object localObject3 = paramImageView.getTag();
        Object localObject1;
        if ((localObject3 instanceof ImageViewTarget)) {
            localObject1 = (ImageViewTarget) localObject3;
        }
        do {
            Object localObject2;
            do {
                return (ImageViewTarget) localObject1;
                localObject2 = null;
                localObject1 = localObject2;
            } while (localObject3 == null);
            localObject1 = localObject2;
        } while (!Log.isLoggable("Glide", 4));
        Log.i("Glide", "Replacing existing tag=" + localObject3 + " on view=" + paramImageView + " with an ImageViewTarget");
        return null;
    }

    private ImageViewTarget getImageViewTargetOrSet(ImageView paramImageView) {
        ImageViewTarget localImageViewTarget2 = getImageViewTarget(paramImageView);
        ImageViewTarget localImageViewTarget1 = localImageViewTarget2;
        if (localImageViewTarget2 == null) {
            localImageViewTarget1 = new ImageViewTarget(paramImageView);
            paramImageView.setTag(localImageViewTarget1);
        }
        return localImageViewTarget1;
    }

    public static Request<Uri> load(Uri paramUri) {
        return new Request(paramUri, null);
    }

    public static Request<File> load(File paramFile) {
        return new Request(paramFile, null);
    }

    public static Request<Integer> load(Integer paramInteger) {
        return new Request(paramInteger, null);
    }

    public static <T> Request<T> load(T paramT) {
        return new Request(paramT, null);
    }

    public static Request<String> load(String paramString) {
        return new Request(paramString, null);
    }

    public static Request<URL> load(URL paramURL) {
        return new Request(paramURL, null);
    }

    public static <T> ModelRequest<T> using(ModelLoader<T> paramModelLoader) {
        new ModelRequest(new ModelLoaderFactory() {
            public ModelLoader<T> build(Context paramAnonymousContext, GenericLoaderFactory paramAnonymousGenericLoaderFactory) {
                return Glide.this;
            }

            public Class<? extends ModelLoader<T>> loaderClass() {
                return Glide.this.getClass();
            }

            public void teardown() {
            }
        }, null);
    }

    public static <T> ModelRequest<T> using(ModelLoaderFactory<T> paramModelLoaderFactory) {
        return new ModelRequest(paramModelLoaderFactory, null);
    }

    public ImageManager getImageManager(Context paramContext) {
        if (!isImageManagerSet()) {
            setImageManager(new ImageManager.Builder(paramContext));
        }
        return this.imageManager;
    }

    public boolean isImageManagerSet() {
        return this.imageManager != null;
    }

    public <T> void register(Class<T> paramClass, ModelLoaderFactory<T> paramModelLoaderFactory) {
        paramClass = this.loaderFactory.register(paramClass, paramModelLoaderFactory);
        if (paramClass != null) {
            paramClass.teardown();
        }
    }

    public void setImageManager(ImageManager.Builder paramBuilder) {
        setImageManager(paramBuilder.build());
    }

    public void setImageManager(ImageManager paramImageManager) {
        this.imageManager = paramImageManager;
    }

    public static class ContextRequest {
        private final Glide.Request request;
        private final Target target;

        private ContextRequest(Glide.Request paramRequest, Target paramTarget) {
            this.request = paramRequest;
            this.target = paramTarget;
        }

        public void with(Context paramContext) {
            Glide.Request.access$2(this.request, paramContext, this.target);
        }
    }

    private static class Metadata {
        public final int animationId;
        private final String downsamplerId;
        public final int errorId;
        public final Class modelClass;
        public final Class modelLoaderClass;
        public final int placeholderId;
        private final Class requestListenerClass;
        private final String transformationId;

        public Metadata(Glide.Request paramRequest) {
            this.modelClass = Glide.Request.access$3(paramRequest).getClass();
            this.modelLoaderClass = Glide.Request.access$4(paramRequest).loaderClass();
            this.downsamplerId = Glide.Request.access$5(paramRequest).getId();
            this.transformationId = Glide.Request.access$6(paramRequest);
            this.animationId = Glide.Request.access$7(paramRequest);
            this.placeholderId = Glide.Request.access$8(paramRequest);
            this.errorId = Glide.Request.access$9(paramRequest);
            if (Glide.Request.access$1(paramRequest) != null) {
            }
            for (paramRequest = Glide.Request.access$1(paramRequest).getClass(); ; paramRequest = null) {
                this.requestListenerClass = paramRequest;
                return;
            }
        }

        public boolean isIdenticalTo(Metadata paramMetadata) {
            if (paramMetadata == null) {
            }
            do {
                do {
                    return false;
                }
                while ((this.animationId != paramMetadata.animationId) || (this.errorId != paramMetadata.errorId) || (this.placeholderId != paramMetadata.placeholderId) || (!this.downsamplerId.equals(paramMetadata.downsamplerId)) || (!this.modelClass.equals(paramMetadata.modelClass)) || (!this.modelLoaderClass.equals(paramMetadata.modelLoaderClass)) || (!this.transformationId.equals(paramMetadata.transformationId)));
                if (this.requestListenerClass != null) {
                    break;
                }
            } while (paramMetadata.requestListenerClass != null);
            while (this.requestListenerClass.equals(paramMetadata.requestListenerClass)) {
                return true;
            }
            return false;
        }
    }

    public static class ModelRequest<T> {
        private final ModelLoaderFactory<T> factory;

        private ModelRequest(ModelLoaderFactory<T> paramModelLoaderFactory) {
            this.factory = paramModelLoaderFactory;
        }

        public Glide.Request<T> load(T paramT) {
            return new Glide.Request(paramT, this.factory, null);
        }
    }

    public static class Request<T> {
        private int animationId = -1;
        private Context context;
        private Downsampler downsampler = Downsampler.AT_LEAST;
        private int errorId = -1;
        private final T model;
        private ModelLoaderFactory<T> modelLoaderFactory;
        private int placeholderId = -1;
        private Glide.RequestListener<T> requestListener;
        private Target target;
        private ArrayList<TransformationLoader<T>> transformationLoaders = new ArrayList();

        private Request(T paramT) {
            this(paramT, Glide.GLIDE.getFactory(paramT));
        }

        private Request(T paramT, ModelLoaderFactory<T> paramModelLoaderFactory) {
            if (paramT == null) {
                throw new IllegalArgumentException("Model can't be null");
            }
            this.model = paramT;
            if (paramModelLoaderFactory == null) {
                throw new IllegalArgumentException("No ModelLoaderFactory registered for class=" + paramT.getClass());
            }
            this.modelLoaderFactory = paramModelLoaderFactory;
        }

        private ImagePresenter<T> buildImagePresenter(final Target paramTarget) {
            final Object localObject = getFinalTransformationLoader();
            ImagePresenter.Builder localBuilder = new ImagePresenter.Builder().setTarget(paramTarget, this.context).setModelLoader(this.modelLoaderFactory.build(this.context, Glide.GLIDE.loaderFactory)).setImageLoader(new ImageManagerLoader(this.context, this.downsampler)).setTransformationLoader((TransformationLoader) localObject);
            if ((this.animationId != -1) || (this.requestListener != null)) {
                if (this.animationId == -1) {
                    break label174;
                }
            }
            label174:
            for (localObject = AnimationUtils.loadAnimation(this.context, this.animationId); ; localObject = null) {
                localBuilder.setImageReadyCallback(new ImagePresenter.ImageReadyCallback() {
                    public void onImageReady(T paramAnonymousT, Target paramAnonymousTarget, boolean paramAnonymousBoolean) {
                        if ((localObject != null) && (!paramAnonymousBoolean)) {
                            paramAnonymousTarget.startAnimation(localObject);
                        }
                        if (Glide.Request.this.requestListener != null) {
                            Glide.Request.this.requestListener.onImageReady(null, paramAnonymousTarget);
                        }
                    }
                });
                if (this.placeholderId != -1) {
                    localBuilder.setPlaceholderResource(this.placeholderId);
                }
                if (this.errorId != -1) {
                    localBuilder.setErrorResource(this.errorId);
                }
                if (this.requestListener != null) {
                    localBuilder.setExceptionHandler(new ImagePresenter.ExceptionHandler() {
                        public void onException(Exception paramAnonymousException, T paramAnonymousT, boolean paramAnonymousBoolean) {
                            if (paramAnonymousBoolean) {
                                Glide.Request.this.requestListener.onException(paramAnonymousException, paramAnonymousT, paramTarget);
                            }
                        }
                    });
                }
                return localBuilder.build();
            }
        }

        private void finish(Context paramContext, Target paramTarget) {
            this.context = paramContext;
            this.target = paramTarget;
            getImagePresenter(paramTarget).setModel(this.model);
        }

        private String getFinalTransformationId() {
            StringBuilder localStringBuilder;
            Iterator localIterator;
            switch (this.transformationLoaders.size()) {
                default:
                    localStringBuilder = new StringBuilder();
                    localIterator = this.transformationLoaders.iterator();
            }
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    return localStringBuilder.toString();
                    return Transformation.NONE.getId();
                    return ((TransformationLoader) this.transformationLoaders.get(0)).getId();
                }
                localStringBuilder.append(((TransformationLoader) localIterator.next()).getId());
            }
        }

        private TransformationLoader<T> getFinalTransformationLoader() {
            switch (this.transformationLoaders.size()) {
                default:
                    return new MultiTransformationLoader(this.transformationLoaders);
                case 0:
                    return new None();
            }
            return (TransformationLoader) this.transformationLoaders.get(0);
        }

        private ImagePresenter<T> getImagePresenter(Target paramTarget) {
            ImagePresenter localImagePresenter = paramTarget.getImagePresenter();
            Object localObject2 = (Glide.Metadata) Glide.GLIDE.metadataTracker.get(paramTarget);
            Glide.Metadata localMetadata = new Glide.Metadata(this);
            Object localObject1 = localObject2;
            if (localObject2 != null) {
                localObject1 = localObject2;
                if (localImagePresenter == null) {
                    localObject1 = null;
                }
            }
            localObject2 = localImagePresenter;
            if (!localMetadata.isIdenticalTo((Glide.Metadata) localObject1)) {
                if (localImagePresenter != null) {
                    localImagePresenter.clear();
                }
                localObject2 = buildImagePresenter(paramTarget);
                paramTarget.setImagePresenter((ImagePresenter) localObject2);
                Glide.GLIDE.metadataTracker.put(paramTarget, localMetadata);
            }
            return (ImagePresenter<T>) localObject2;
        }

        public Request<T> animate(int paramInt) {
            this.animationId = paramInt;
            return this;
        }

        public Request<T> approximate() {
            return downsample(Downsampler.AT_LEAST);
        }

        public Request<T> asIs() {
            return downsample(Downsampler.NONE);
        }

        public Request<T> centerCrop() {
            return transform(new CenterCrop());
        }

        public Request<T> downsample(Downsampler paramDownsampler) {
            this.downsampler = paramDownsampler;
            return this;
        }

        public Request<T> error(int paramInt) {
            this.errorId = paramInt;
            return this;
        }

        public Request<T> fitCenter() {
            return transform(new FitCenter());
        }

        public Glide.ContextRequest into(Target paramTarget) {
            return new Glide.ContextRequest(this, paramTarget, null);
        }

        public void into(ImageView paramImageView) {
            ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
            if ((localLayoutParams != null) && ((localLayoutParams.width == -2) || (localLayoutParams.height == -2))) {
                this.downsampler = Downsampler.NONE;
            }
            finish(paramImageView.getContext(), Glide.GLIDE.getImageViewTargetOrSet(paramImageView));
        }

        public Request<T> listener(Glide.RequestListener<T> paramRequestListener) {
            this.requestListener = paramRequestListener;
            return this;
        }

        public Request<T> placeholder(int paramInt) {
            this.placeholderId = paramInt;
            return this;
        }

        public Request<T> transform(TransformationLoader<T> paramTransformationLoader) {
            this.transformationLoaders.add(paramTransformationLoader);
            return this;
        }

        public Request<T> transform(final Transformation paramTransformation) {
            transform(new TransformationLoader() {
                public String getId() {
                    return paramTransformation.getId();
                }

                public Transformation getTransformation(T paramAnonymousT) {
                    return paramTransformation;
                }
            });
        }
    }

    public static abstract interface RequestListener<T> {
        public abstract void onException(Exception paramException, T paramT, Target paramTarget);

        public abstract void onImageReady(T paramT, Target paramTarget);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/Glide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */