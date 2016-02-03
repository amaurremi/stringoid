package twitter4j;

public abstract interface PagableResponseList<T extends TwitterResponse>
        extends CursorSupport, ResponseList<T> {
    public abstract long getNextCursor();

    public abstract long getPreviousCursor();

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/PagableResponseList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */