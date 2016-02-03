package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Paging
        implements Serializable {
    static final String COUNT = "count";
    private static final HttpParameter[] NULL_PARAMETER_ARRAY = new HttpParameter[0];
    private static final List<HttpParameter> NULL_PARAMETER_LIST = new ArrayList(0);
    static final String PER_PAGE = "per_page";
    static final char[] S = {'s'};
    static final char[] SMCP = {115, 109, 99, 112};
    private static final long serialVersionUID = -7226113618341047983L;
    private int count = -1;
    private long maxId = -1L;
    private int page = -1;
    private long sinceId = -1L;

    public Paging() {
    }

    public Paging(int paramInt) {
        setPage(paramInt);
    }

    public Paging(int paramInt1, int paramInt2) {
        this(paramInt1);
        setCount(paramInt2);
    }

    public Paging(int paramInt1, int paramInt2, long paramLong) {
        this(paramInt1, paramInt2);
        setSinceId(paramLong);
    }

    public Paging(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
        this(paramInt1, paramInt2, paramLong1);
        setMaxId(paramLong2);
    }

    public Paging(int paramInt, long paramLong) {
        this(paramInt);
        setSinceId(paramLong);
    }

    public Paging(long paramLong) {
        setSinceId(paramLong);
    }

    private void addPostParameter(char[] paramArrayOfChar, char paramChar, List<HttpParameter> paramList, String paramString, long paramLong) {
        int k = 0;
        int m = paramArrayOfChar.length;
        int i = 0;
        for (; ; ) {
            int j = k;
            if (i < m) {
                if (paramArrayOfChar[i] == paramChar) {
                    j = 1;
                }
            } else {
                if ((j != 0) || (-1L == paramLong)) {
                    break;
                }
                throw new IllegalStateException("Paging parameter [" + paramString + "] is not supported with this operation.");
            }
            i += 1;
        }
        if (-1L != paramLong) {
            paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
        }
    }

    HttpParameter[] asPostParameterArray() {
        List localList = asPostParameterList(SMCP, "count");
        if (localList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) localList.toArray(new HttpParameter[localList.size()]);
    }

    HttpParameter[] asPostParameterArray(char[] paramArrayOfChar, String paramString) {
        ArrayList localArrayList = new ArrayList(paramArrayOfChar.length);
        addPostParameter(paramArrayOfChar, 's', localArrayList, "since_id", getSinceId());
        addPostParameter(paramArrayOfChar, 'm', localArrayList, "max_id", getMaxId());
        addPostParameter(paramArrayOfChar, 'c', localArrayList, paramString, getCount());
        addPostParameter(paramArrayOfChar, 'p', localArrayList, "page", getPage());
        if (localArrayList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) localArrayList.toArray(new HttpParameter[localArrayList.size()]);
    }

    List<HttpParameter> asPostParameterList() {
        return asPostParameterList(SMCP, "count");
    }

    List<HttpParameter> asPostParameterList(char[] paramArrayOfChar) {
        return asPostParameterList(paramArrayOfChar, "count");
    }

    List<HttpParameter> asPostParameterList(char[] paramArrayOfChar, String paramString) {
        ArrayList localArrayList = new ArrayList(paramArrayOfChar.length);
        addPostParameter(paramArrayOfChar, 's', localArrayList, "since_id", getSinceId());
        addPostParameter(paramArrayOfChar, 'm', localArrayList, "max_id", getMaxId());
        addPostParameter(paramArrayOfChar, 'c', localArrayList, paramString, getCount());
        addPostParameter(paramArrayOfChar, 'p', localArrayList, "page", getPage());
        paramArrayOfChar = localArrayList;
        if (localArrayList.size() == 0) {
            paramArrayOfChar = NULL_PARAMETER_LIST;
        }
        return paramArrayOfChar;
    }

    public Paging count(int paramInt) {
        setCount(paramInt);
        return this;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Paging)) {
                return false;
            }
            paramObject = (Paging) paramObject;
            if (this.count != ((Paging) paramObject).count) {
                return false;
            }
            if (this.maxId != ((Paging) paramObject).maxId) {
                return false;
            }
            if (this.page != ((Paging) paramObject).page) {
                return false;
            }
        } while (this.sinceId == ((Paging) paramObject).sinceId);
        return false;
    }

    public int getCount() {
        return this.count;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public int getPage() {
        return this.page;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public int hashCode() {
        return ((this.page * 31 + this.count) * 31 + (int) (this.sinceId ^ this.sinceId >>> 32)) * 31 + (int) (this.maxId ^ this.maxId >>> 32);
    }

    public Paging maxId(long paramLong) {
        setMaxId(paramLong);
        return this;
    }

    public void setCount(int paramInt) {
        if (paramInt < 1) {
            throw new IllegalArgumentException("count should be positive integer. passed:" + paramInt);
        }
        this.count = paramInt;
    }

    public void setMaxId(long paramLong) {
        if (paramLong < 1L) {
            throw new IllegalArgumentException("max_id should be positive integer. passed:" + paramLong);
        }
        this.maxId = paramLong;
    }

    public void setPage(int paramInt) {
        if (paramInt < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + paramInt);
        }
        this.page = paramInt;
    }

    public void setSinceId(long paramLong) {
        if (paramLong < 1L) {
            throw new IllegalArgumentException("since_id should be positive integer. passed:" + paramLong);
        }
        this.sinceId = paramLong;
    }

    public Paging sinceId(long paramLong) {
        setSinceId(paramLong);
        return this;
    }

    public String toString() {
        return "Paging{page=" + this.page + ", count=" + this.count + ", sinceId=" + this.sinceId + ", maxId=" + this.maxId + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/Paging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */