package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class CharRange
        implements Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    public CharRange(char paramChar) {
        this(paramChar, paramChar, false);
    }

    public CharRange(char paramChar1, char paramChar2) {
        this(paramChar1, paramChar2, false);
    }

    public CharRange(char paramChar1, char paramChar2, boolean paramBoolean) {
        char c2 = paramChar1;
        char c1 = paramChar2;
        if (paramChar1 > paramChar2) {
            c1 = paramChar1;
            c2 = paramChar2;
        }
        this.start = c2;
        this.end = c1;
        this.negated = paramBoolean;
    }

    public CharRange(char paramChar, boolean paramBoolean) {
        this(paramChar, paramChar, paramBoolean);
    }

    public static CharRange is(char paramChar) {
        return new CharRange(paramChar, paramChar, false);
    }

    public static CharRange isIn(char paramChar1, char paramChar2) {
        return new CharRange(paramChar1, paramChar2, false);
    }

    public static CharRange isNot(char paramChar) {
        return new CharRange(paramChar, paramChar, true);
    }

    public static CharRange isNotIn(char paramChar1, char paramChar2) {
        return new CharRange(paramChar1, paramChar2, true);
    }

    public boolean contains(char paramChar) {
        if ((paramChar >= this.start) && (paramChar <= this.end)) {
        }
        for (int i = 1; i != this.negated; i = 0) {
            return true;
        }
        return false;
    }

    public boolean contains(CharRange paramCharRange) {
        boolean bool = false;
        if (paramCharRange == null) {
            throw new IllegalArgumentException("The Range must not be null");
        }
        if (this.negated) {
            if (paramCharRange.negated) {
                if ((this.start < paramCharRange.start) || (this.end > paramCharRange.end)) {
                }
            }
        }
        do {
            do {
                return true;
                return false;
                if ((paramCharRange.end < this.start) || (paramCharRange.start > this.end)) {
                    bool = true;
                }
                return bool;
                if (!paramCharRange.negated) {
                    break;
                }
            } while ((this.start == 0) && (this.end == 65535));
            return false;
        } while ((this.start <= paramCharRange.start) && (this.end >= paramCharRange.end));
        return false;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof CharRange)) {
                return false;
            }
            paramObject = (CharRange) paramObject;
        }
        while ((this.start == ((CharRange) paramObject).start) && (this.end == ((CharRange) paramObject).end) && (this.negated == ((CharRange) paramObject).negated));
        return false;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        int j = this.start;
        int k = this.end;
        if (this.negated) {
        }
        for (int i = 1; ; i = 0) {
            return i + (k * 7 + (j + 83));
        }
    }

    public boolean isNegated() {
        return this.negated;
    }

    public Iterator iterator() {
        return new CharacterIterator(this, null);
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuffer localStringBuffer = new StringBuffer(4);
            if (isNegated()) {
                localStringBuffer.append('^');
            }
            localStringBuffer.append(this.start);
            if (this.start != this.end) {
                localStringBuffer.append('-');
                localStringBuffer.append(this.end);
            }
            this.iToString = localStringBuffer.toString();
        }
        return this.iToString;
    }

    private static class CharacterIterator
            implements Iterator {
        private char current;
        private boolean hasNext;
        private CharRange range;

        private CharacterIterator(CharRange paramCharRange) {
            this.range = paramCharRange;
            this.hasNext = true;
            if (this.range.negated) {
                if (this.range.start == 0) {
                    if (this.range.end == 65535) {
                        this.hasNext = false;
                        return;
                    }
                    this.current = ((char) (this.range.end + '\001'));
                    return;
                }
                this.current = '\000';
                return;
            }
            this.current = this.range.start;
        }

        CharacterIterator(CharRange paramCharRange, CharRange.1param1) {
            this(paramCharRange);
        }

        private void prepareNext() {
            if (this.range.negated) {
                if (this.current == 65535) {
                    this.hasNext = false;
                    return;
                }
                if (this.current + '\001' == this.range.start) {
                    if (this.range.end == 65535) {
                        this.hasNext = false;
                        return;
                    }
                    this.current = ((char) (this.range.end + '\001'));
                    return;
                }
                this.current = ((char) (this.current + '\001'));
                return;
            }
            if (this.current < this.range.end) {
                this.current = ((char) (this.current + '\001'));
                return;
            }
            this.hasNext = false;
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public Object next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            char c = this.current;
            prepareNext();
            return new Character(c);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/CharRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */