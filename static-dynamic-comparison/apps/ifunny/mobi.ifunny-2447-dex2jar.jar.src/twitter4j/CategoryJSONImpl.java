package twitter4j;

import java.io.Serializable;

import twitter4j.conf.Configuration;

final class CategoryJSONImpl
        implements Serializable, Category {
    private static final long serialVersionUID = 3811335888122469876L;
    private String name;
    private int size;
    private String slug;

    CategoryJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    static ResponseList<Category> createCategoriesList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        return createCategoriesList(paramHttpResponse.asJSONArray(), paramHttpResponse, paramConfiguration);
    }

    static ResponseList<Category> createCategoriesList(JSONArray paramJSONArray, HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.clearThreadLocalMap();
                }
                paramHttpResponse = new ResponseListImpl(paramJSONArray.length(), paramHttpResponse);
                i = 0;
                if (i < paramJSONArray.length()) {
                    JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                    CategoryJSONImpl localCategoryJSONImpl = new CategoryJSONImpl(localJSONObject);
                    paramHttpResponse.add(localCategoryJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localCategoryJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(paramHttpResponse, paramJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramJSONArray) {
                throw new TwitterException(paramJSONArray);
            }
            i += 1;
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (CategoryJSONImpl) paramObject;
            if (this.size != ((CategoryJSONImpl) paramObject).size) {
                return false;
            }
            if (this.name != null) {
                if (this.name.equals(((CategoryJSONImpl) paramObject).name)) {
                }
            } else {
                while (((CategoryJSONImpl) paramObject).name != null) {
                    return false;
                }
            }
            if (this.slug == null) {
                break;
            }
        } while (this.slug.equals(((CategoryJSONImpl) paramObject).slug));
        for (; ; ) {
            return false;
            if (((CategoryJSONImpl) paramObject).slug == null) {
                break;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public String getSlug() {
        return this.slug;
    }

    public int hashCode() {
        int j = 0;
        if (this.name != null) {
        }
        for (int i = this.name.hashCode(); ; i = 0) {
            if (this.slug != null) {
                j = this.slug.hashCode();
            }
            return (i * 31 + j) * 31 + this.size;
        }
    }

    void init(JSONObject paramJSONObject) {
        this.name = paramJSONObject.getString("name");
        this.slug = paramJSONObject.getString("slug");
        this.size = ParseUtil.getInt("size", paramJSONObject);
    }

    public String toString() {
        return "CategoryJSONImpl{name='" + this.name + '\'' + ", slug='" + this.slug + '\'' + ", size=" + this.size + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/CategoryJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */