package org.json.simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.a;
import org.json.simple.c;

public class JSONParser {
    public static final int S_END = 6;
    public static final int S_INIT = 0;
    public static final int S_IN_ARRAY = 3;
    public static final int S_IN_ERROR = -1;
    public static final int S_IN_FINISHED_VALUE = 1;
    public static final int S_IN_OBJECT = 2;
    public static final int S_IN_PAIR_VALUE = 5;
    public static final int S_PASSED_PAIR_KEY = 4;
    private LinkedList handlerStatusStack;
    private Yylex lexer = new Yylex((Reader) null);
    private int status = 0;
    private Yytoken token = null;

    private List createArrayContainer(ContainerFactory paramContainerFactory) {
        if (paramContainerFactory == null) {
            paramContainerFactory = new a();
        }
        List localList;
        do {
            return paramContainerFactory;
            localList = paramContainerFactory.creatArrayContainer();
            paramContainerFactory = localList;
        } while (localList != null);
        return new a();
    }

    private Map createObjectContainer(ContainerFactory paramContainerFactory) {
        if (paramContainerFactory == null) {
            paramContainerFactory = new c();
        }
        Map localMap;
        do {
            return paramContainerFactory;
            localMap = paramContainerFactory.createObjectContainer();
            paramContainerFactory = localMap;
        } while (localMap != null);
        return new c();
    }

    private void nextToken() {
        this.token = this.lexer.yylex();
        if (this.token == null) {
            this.token = new Yytoken(-1, null);
        }
    }

    private int peekStatus(LinkedList paramLinkedList) {
        if (paramLinkedList.size() == 0) {
            return -1;
        }
        return ((Integer) paramLinkedList.getFirst()).intValue();
    }

    public int getPosition() {
        return this.lexer.getPosition();
    }

    public Object parse(Reader paramReader) {
        return parse(paramReader, (ContainerFactory) null);
    }

    public Object parse(Reader paramReader, ContainerFactory paramContainerFactory) {
        reset(paramReader);
        paramReader = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        label68:
        label132:
        label320:
        label476:
        Object localObject1;
        Object localObject2;
        for (; ; ) {
            try {
                nextToken();
                switch (this.status) {
                    case 0:
                        if (this.status != -1) {
                            break label931;
                        }
                        throw new ParseException(getPosition(), 1, this.token);
                }
            } catch (IOException paramReader) {
                throw paramReader;
            }
            switch (this.token.type) {
                case 2:
                    this.status = -1;
                    break;
                case 0:
                    this.status = 1;
                    paramReader.addFirst(new Integer(this.status));
                    localLinkedList.addFirst(this.token.value);
                    break;
                case 1:
                    this.status = 2;
                    paramReader.addFirst(new Integer(this.status));
                    localLinkedList.addFirst(createObjectContainer(paramContainerFactory));
                    break;
                case 3:
                    this.status = 3;
                    paramReader.addFirst(new Integer(this.status));
                    localLinkedList.addFirst(createArrayContainer(paramContainerFactory));
                    continue;
                    if (this.token.type == -1) {
                        return localLinkedList.removeFirst();
                    }
                    throw new ParseException(getPosition(), 1, this.token);
                    switch (this.token.type) {
                        case 5:
                        case 1:
                        case 3:
                        case 4:
                            this.status = -1;
                            break;
                        case 0:
                            if ((this.token.value instanceof String)) {
                                localLinkedList.addFirst((String) this.token.value);
                                this.status = 4;
                                paramReader.addFirst(new Integer(this.status));
                            } else {
                                this.status = -1;
                            }
                            break;
                        case 2:
                            if (localLinkedList.size() > 1) {
                                paramReader.removeFirst();
                                localLinkedList.removeFirst();
                                this.status = peekStatus(paramReader);
                            } else {
                                this.status = 1;
                                continue;
                                Object localObject3;
                                switch (this.token.type) {
                                    case 6:
                                    case 2:
                                    case 4:
                                    case 5:
                                        this.status = -1;
                                        break;
                                    case 0:
                                        paramReader.removeFirst();
                                        localObject1 = (String) localLinkedList.removeFirst();
                                        ((Map) localLinkedList.getFirst()).put(localObject1, this.token.value);
                                        this.status = peekStatus(paramReader);
                                        break;
                                    case 3:
                                        paramReader.removeFirst();
                                        localObject1 = (String) localLinkedList.removeFirst();
                                        localObject2 = (Map) localLinkedList.getFirst();
                                        localObject3 = createArrayContainer(paramContainerFactory);
                                        ((Map) localObject2).put(localObject1, localObject3);
                                        this.status = 3;
                                        paramReader.addFirst(new Integer(this.status));
                                        localLinkedList.addFirst(localObject3);
                                        break;
                                    case 1:
                                        paramReader.removeFirst();
                                        localObject1 = (String) localLinkedList.removeFirst();
                                        localObject2 = (Map) localLinkedList.getFirst();
                                        localObject3 = createObjectContainer(paramContainerFactory);
                                        ((Map) localObject2).put(localObject1, localObject3);
                                        this.status = 2;
                                        paramReader.addFirst(new Integer(this.status));
                                        localLinkedList.addFirst(localObject3);
                                        continue;
                                        switch (this.token.type) {
                                        }
                                        break;
                                }
                            }
                            break;
                    }
                    break;
            }
        }
        for (; ; ) {
            this.status = -1;
            break label68;
            ((List) localLinkedList.getFirst()).add(this.token.value);
            break label68;
            if (localLinkedList.size() > 1) {
                paramReader.removeFirst();
                localLinkedList.removeFirst();
                this.status = peekStatus(paramReader);
                break label68;
            }
            this.status = 1;
            break label68;
            localObject1 = (List) localLinkedList.getFirst();
            localObject2 = createObjectContainer(paramContainerFactory);
            ((List) localObject1).add(localObject2);
            this.status = 2;
            paramReader.addFirst(new Integer(this.status));
            localLinkedList.addFirst(localObject2);
            break label68;
            localObject1 = (List) localLinkedList.getFirst();
            localObject2 = createArrayContainer(paramContainerFactory);
            ((List) localObject1).add(localObject2);
            this.status = 3;
            paramReader.addFirst(new Integer(this.status));
            localLinkedList.addFirst(localObject2);
            break label68;
            throw new ParseException(getPosition(), 1, this.token);
            label931:
            int i = this.token.type;
            if (i != -1) {
                break;
            }
            throw new ParseException(getPosition(), 1, this.token);
            break label68;
            break label132;
            break label320;
            break label476;
        }
    }

    public Object parse(String paramString) {
        return parse(paramString, (ContainerFactory) null);
    }

    public Object parse(String paramString, ContainerFactory paramContainerFactory) {
        paramString = new StringReader(paramString);
        try {
            paramString = parse(paramString, paramContainerFactory);
            return paramString;
        } catch (IOException paramString) {
            throw new ParseException(-1, 2, paramString);
        }
    }

    public void parse(Reader paramReader, ContentHandler paramContentHandler) {
        parse(paramReader, paramContentHandler, false);
    }

    public void parse(Reader paramReader, ContentHandler paramContentHandler, boolean paramBoolean) {
        if (!paramBoolean) {
            reset(paramReader);
            this.handlerStatusStack = new LinkedList();
            paramReader = this.handlerStatusStack;
        }
        label76:
        label184:
        label412:
        label580:
        do {
            do {
                do {
                    do {
                        for (; ; ) {
                            try {
                                switch (this.status) {
                                    case 0:
                                        if (this.status != -1) {
                                            break label938;
                                        }
                                        throw new ParseException(getPosition(), 1, this.token);
                                }
                            } catch (IOException paramReader) {
                                this.status = -1;
                                throw paramReader;
                                if (this.handlerStatusStack != null) {
                                    break;
                                }
                                reset(paramReader);
                                this.handlerStatusStack = new LinkedList();
                                break;
                                paramContentHandler.startJSON();
                                nextToken();
                                switch (this.token.type) {
                                    case 2:
                                        this.status = -1;
                                        continue;
                                }
                            } catch (ParseException paramReader) {
                                this.status = -1;
                                throw paramReader;
                                this.status = 1;
                                paramReader.addFirst(new Integer(this.status));
                                if (paramContentHandler.primitive(this.token.value)) {
                                    continue;
                                }
                                return;
                                this.status = 2;
                                paramReader.addFirst(new Integer(this.status));
                                if (paramContentHandler.startObject()) {
                                    continue;
                                }
                                return;
                                this.status = 3;
                                paramReader.addFirst(new Integer(this.status));
                                if (paramContentHandler.startArray()) {
                                    continue;
                                }
                                return;
                                nextToken();
                                if (this.token.type == -1) {
                                    paramContentHandler.endJSON();
                                    this.status = 6;
                                    return;
                                }
                            } catch (RuntimeException paramReader) {
                                this.status = -1;
                                throw paramReader;
                                this.status = -1;
                                throw new ParseException(getPosition(), 1, this.token);
                            } catch (Error paramReader) {
                                this.status = -1;
                                throw paramReader;
                            }
                            nextToken();
                            switch (this.token.type) {
                                case 5:
                                case 1:
                                case 3:
                                case 4:
                                    this.status = -1;
                                    break;
                                case 0:
                                    if ((this.token.value instanceof String)) {
                                        String str = (String) this.token.value;
                                        this.status = 4;
                                        paramReader.addFirst(new Integer(this.status));
                                        if (paramContentHandler.startObjectEntry(str)) {
                                        }
                                    } else {
                                        this.status = -1;
                                    }
                                    break;
                                case 2:
                                    if (paramReader.size() > 1) {
                                        paramReader.removeFirst();
                                    }
                                    for (this.status = peekStatus(paramReader); !paramContentHandler.endObject(); this.status = 1) {
                                        return;
                                    }
                                    nextToken();
                                    switch (this.token.type) {
                                        case 6:
                                        case 2:
                                        case 4:
                                        case 5:
                                            this.status = -1;
                                    }
                                    break;
                            }
                        }
                        paramReader.removeFirst();
                        this.status = peekStatus(paramReader);
                        if (!paramContentHandler.primitive(this.token.value)) {
                            break label981;
                        }
                    } while (paramContentHandler.endObjectEntry());
                    return;
                    paramReader.removeFirst();
                    paramReader.addFirst(new Integer(5));
                    this.status = 3;
                    paramReader.addFirst(new Integer(this.status));
                } while (paramContentHandler.startArray());
                return;
                paramReader.removeFirst();
                paramReader.addFirst(new Integer(5));
                this.status = 2;
                paramReader.addFirst(new Integer(this.status));
            } while (paramContentHandler.startObject());
            return;
            paramReader.removeFirst();
            this.status = peekStatus(paramReader);
        } while (paramContentHandler.endObjectEntry());
        return;
        nextToken();
        switch (this.token.type) {
        }
        for (; ; ) {
            this.status = -1;
            break label76;
            if (paramContentHandler.primitive(this.token.value)) {
                break label76;
            }
            return;
            if (paramReader.size() > 1) {
                paramReader.removeFirst();
            }
            for (this.status = peekStatus(paramReader); !paramContentHandler.endArray(); this.status = 1) {
                return;
            }
            this.status = 2;
            paramReader.addFirst(new Integer(this.status));
            if (paramContentHandler.startObject()) {
                break label76;
            }
            return;
            this.status = 3;
            paramReader.addFirst(new Integer(this.status));
            if (paramContentHandler.startArray()) {
                break label76;
            }
            return;
            throw new ParseException(getPosition(), 1, this.token);
            label938:
            int i = this.token.type;
            if (i != -1) {
                break;
            }
            this.status = -1;
            throw new ParseException(getPosition(), 1, this.token);
            break label76;
            break label184;
            label981:
            return;
            break label412;
            break label580;
        }
    }

    public void parse(String paramString, ContentHandler paramContentHandler) {
        parse(paramString, paramContentHandler, false);
    }

    public void parse(String paramString, ContentHandler paramContentHandler, boolean paramBoolean) {
        paramString = new StringReader(paramString);
        try {
            parse(paramString, paramContentHandler, paramBoolean);
            return;
        } catch (IOException paramString) {
            throw new ParseException(-1, 2, paramString);
        }
    }

    public void reset() {
        this.token = null;
        this.status = 0;
        this.handlerStatusStack = null;
    }

    public void reset(Reader paramReader) {
        this.lexer.yyreset(paramReader);
        reset();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/parser/JSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */