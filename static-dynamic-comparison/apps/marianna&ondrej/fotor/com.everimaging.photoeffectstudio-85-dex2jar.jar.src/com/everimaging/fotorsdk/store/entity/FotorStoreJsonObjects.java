package com.everimaging.fotorsdk.store.entity;

import com.everimaging.fotorsdk.store.StatusAssistant.StatusInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FotorStoreJsonObjects {
    public static class AdvsJsonObject
            extends FotorStoreJsonObjects.ResPackBaseJsonObject {
        public String description;
        public String previewImg;
        public String publishDate;
        public int resourceId;
        public String url;

        public void parseFromJsonStr(String paramString) {
            paramString = (AdvsJsonObject) new GsonBuilder().create().fromJson(paramString, AdvsJsonObject.class);
            this.id = paramString.id;
            this.previewImg = paramString.previewImg;
            this.url = paramString.url;
            this.resourceId = paramString.resourceId;
            this.publishDate = paramString.publishDate;
            this.type = paramString.type;
            this.description = paramString.description;
            this.count = paramString.count;
            this.name = paramString.name;
        }
    }

    public static class BundleDetailsJsonObject
            extends FotorStoreJsonObjects.DetailsBaseJsonObject {
        public List<FotorStoreJsonObjects.ResPackageJsonObject> resources;

        public void parseFromJsonStr(String paramString) {
            paramString = (BundleDetailsJsonObject) new GsonBuilder().create().fromJson(paramString, BundleDetailsJsonObject.class);
            this.count = paramString.count;
            this.description = paramString.description;
            this.id = paramString.id;
            this.name = paramString.name;
            this.price = paramString.price;
            this.resources = paramString.resources;
            this.detailThumb = paramString.detailThumb;
        }
    }

    public static class CommonDetailsJsonObject
            extends FotorStoreJsonObjects.ResourceDetailsJsonObject {
        public String previewImg;

        public void parseFromJsonStr(String paramString) {
            paramString = (CommonDetailsJsonObject) new GsonBuilder().create().fromJson(paramString, CommonDetailsJsonObject.class);
            this.count = paramString.count;
            this.description = paramString.description;
            this.id = paramString.id;
            this.name = paramString.name;
            this.price = paramString.price;
            this.detailThumb = paramString.detailThumb;
            this.trialUrl = paramString.trialUrl;
            this.url = paramString.url;
            this.bundleId = paramString.bundleId;
            this.promotionMsg = paramString.promotionMsg;
            this.previewImg = paramString.previewImg;
            this.pkgName = paramString.pkgName;
        }
    }

    public static abstract class DetailsBaseJsonObject
            extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject {
        public String description;
        public String detailThumb;
    }

    public static class EffectsBoredersDetailsJsonObject
            extends FotorStoreJsonObjects.ResourceDetailsJsonObject {
        public void parseFromJsonStr(String paramString) {
            paramString = (EffectsBoredersDetailsJsonObject) new GsonBuilder().create().fromJson(paramString, EffectsBoredersDetailsJsonObject.class);
            this.count = paramString.count;
            this.description = paramString.description;
            this.id = paramString.id;
            this.name = paramString.name;
            this.price = paramString.price;
            this.detailThumb = paramString.detailThumb;
            this.trialUrl = paramString.trialUrl;
            this.url = paramString.url;
            this.bundleId = paramString.bundleId;
            this.promotionMsg = paramString.promotionMsg;
            this.pkgName = paramString.pkgName;
        }
    }

    public static class ModulesJsonObject
            extends FotorStoreJsonObjects.StoreBaseJsonObject {
        public List<ModuleInfo> modules;
        public List<PurchaseResourceInfo> resources;

        public void parseFromJsonStr(String paramString) {
            paramString = (ModulesJsonObject) new GsonBuilder().create().fromJson(paramString, ModulesJsonObject.class);
            this.modules = paramString.modules;
            this.resources = paramString.resources;
        }

        public static class ModuleInfo {
            public String moduleName;
            public String type;
        }

        public static class PurchaseResourceInfo {
            public int id;
            public String productId;
            public String realPrice;
            public String type;

            public String toString() {
                return "PurchaseResourceInfo(productID=" + this.productId + ",realPrice=" + this.realPrice + ",id=" + this.id + ")";
            }
        }
    }

    public static class NewPkgNumJsonObject
            extends FotorStoreJsonObjects.StoreBaseJsonObject {
        public int datetime;
        public int num;
        public String type;

        public void parseFromJsonStr(String paramString) {
            paramString = (NewPkgNumJsonObject) new GsonBuilder().create().fromJson(paramString, NewPkgNumJsonObject.class);
            this.type = paramString.type;
            this.num = paramString.num;
            this.datetime = paramString.datetime;
        }
    }

    public static class PurchasablePackBaseJsonObject
            extends FotorStoreJsonObjects.ResPackBaseJsonObject {
        public float price;

        public void parseFromJsonStr(String paramString) {
        }
    }

    public static class RecommendPkgJsonObject
            extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject {
        public String description;
        public String highDefault;
        public String highPressed;
        public String lowDefault;
        public String lowPressed;
        public String pkgName;
        public String publishDate;

        public void parseFromJsonStr(String paramString) {
            paramString = (RecommendPkgJsonObject) new GsonBuilder().create().fromJson(paramString, RecommendPkgJsonObject.class);
            this.id = paramString.id;
            this.name = paramString.name;
            this.type = paramString.type;
            this.highDefault = paramString.highDefault;
            this.highPressed = paramString.highPressed;
            this.lowDefault = paramString.lowDefault;
            this.lowPressed = paramString.lowPressed;
            this.publishDate = paramString.publishDate;
            this.pkgName = paramString.pkgName;
            this.description = paramString.description;
            this.count = paramString.count;
            this.price = paramString.price;
        }
    }

    public static class ResPackBaseJsonObject
            extends FotorStoreJsonObjects.StoreBaseJsonObject {
        public int count;
        public int id;
        public String name;
        public String type;

        public String getPackID() {
            return this.type + "_" + this.name;
        }

        public void parseFromJsonStr(String paramString) {
            paramString = (ResPackBaseJsonObject) new GsonBuilder().create().fromJson(paramString, ResPackBaseJsonObject.class);
            this.id = paramString.id;
            this.count = paramString.count;
            this.name = paramString.name;
            this.type = paramString.type;
        }
    }

    public static class ResPackageJsonObject
            extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject {
        public String description;
        public String newStatus;
        public String pkgName;
        public String promotionStatus;
        public String publishDate;
        public List<FotorStoreJsonObjects.PurchasablePackBaseJsonObject> resources;
        public StatusAssistant.StatusInfo statusInfo;
        public String thumb;

        public void parseFromJsonStr(String paramString) {
            paramString = (ResPackageJsonObject) new GsonBuilder().create().fromJson(paramString, ResPackageJsonObject.class);
            this.id = paramString.id;
            this.name = paramString.name;
            this.count = paramString.count;
            this.thumb = paramString.thumb;
            this.price = paramString.price;
            this.promotionStatus = paramString.promotionStatus;
            this.newStatus = paramString.newStatus;
            this.publishDate = paramString.publishDate;
            this.pkgName = paramString.pkgName;
            this.description = paramString.description;
            this.type = paramString.type;
            if (paramString.resources != null) {
                this.resources = new ArrayList(paramString.resources);
            }
        }
    }

    public static abstract class ResourceDetailsJsonObject
            extends FotorStoreJsonObjects.DetailsBaseJsonObject {
        public int bundleId;
        public String pkgName;
        public String promotionMsg;
        public String trialUrl;
        public String url;
    }

    public static abstract class ResposeBaseJsonObject<T> {
        public String msg;
        public PageInfoJsonObject pageinfo;
        public boolean status;

        protected static ParameterizedType type(Class paramClass, final Type... paramVarArgs) {
            new ParameterizedType() {
                public Type[] getActualTypeArguments() {
                    return paramVarArgs;
                }

                public Type getOwnerType() {
                    return FotorStoreJsonObjects.class;
                }

                public Type getRawType() {
                    return this.val$raw;
                }
            };
        }

        public abstract void parseFromJsonStr(String paramString, Class<T> paramClass);

        public abstract String toJsonStr(Class<T> paramClass);

        public static class PageInfoJsonObject {
            public String index;
            public int num;
            public String size;
        }
    }

    public static class ResposeDataJsonObject<T>
            extends FotorStoreJsonObjects.ResposeBaseJsonObject<T> {
        public T data;

        public void parseFromJsonStr(String paramString, Class<T> paramClass) {
            paramString = (ResposeDataJsonObject) new GsonBuilder().create().fromJson(paramString, type(ResposeDataJsonObject.class, new Type[]{paramClass}));
            this.status = paramString.status;
            this.msg = paramString.msg;
            this.pageinfo = paramString.pageinfo;
            this.data = paramString.data;
        }

        public String toJsonStr(Class<T> paramClass) {
            return new GsonBuilder().create().toJson(this, type(ResposeDataJsonObject.class, new Type[]{paramClass}));
        }
    }

    public static class ResposeListJsonObject<T>
            extends FotorStoreJsonObjects.ResposeBaseJsonObject<T> {
        public List<T> data;

        public void parseFromJsonStr(String paramString, Class<T> paramClass) {
            paramString = (ResposeListJsonObject) new GsonBuilder().create().fromJson(paramString, type(ResposeListJsonObject.class, new Type[]{paramClass}));
            this.status = paramString.status;
            this.msg = paramString.msg;
            this.pageinfo = paramString.pageinfo;
            this.data = paramString.data;
        }

        public String toJsonStr(Class<T> paramClass) {
            return new GsonBuilder().create().toJson(this, type(ResposeListJsonObject.class, new Type[]{paramClass}));
        }
    }

    public static abstract class StoreBaseJsonObject {
        public String getPackID() {
            return "";
        }

        public abstract void parseFromJsonStr(String paramString);

        public String toJsonStr() {
            return new GsonBuilder().create().toJson(this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/entity/FotorStoreJsonObjects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */