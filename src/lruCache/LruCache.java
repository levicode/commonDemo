package lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache implements Cache {
    private final Cache delegate;
    // todo keyMap何时清除无用key
    private Map<Object, Object> keyMap;

    private Object eldestKey;

    private static final int KEY_MAX_SIZE = 1024;

    private static final float KEY_LOAD_FACTOR = 0.75F;

    public LruCache(Cache delegate) {
        this.delegate = delegate;
        setSize(KEY_MAX_SIZE);
    }

    public void setSize(final int size) {
        keyMap = new LinkedHashMap<Object, Object>(size, KEY_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                boolean tooBig = size() > size;
                if (tooBig) {
                    eldestKey = eldest.getKey();
                }
                return tooBig;
            }
        };
    }

    @Override
    public String getId() {
        return delegate.getId();
    }

    @Override
    public void putObject(Object key, Object value) {
        delegate.putObject(key, value);
        cycleKeyList(key);
    }

    @Override
    public Object getObject(Object key) {
        keyMap.get(key);
        return delegate.getObject(key);
    }

    @Override
    public Object removeObject(Object key) {
        return delegate.removeObject(key);
    }

    @Override
    public int getSize() {
        return delegate.getSize();
    }

    @Override
    public void clear() {
        delegate.clear();
        keyMap.clear();
    }

    private void cycleKeyList(Object key) {
        keyMap.put(key, key);
        if (eldestKey != null) {
            delegate.removeObject(key);
            eldestKey = null;
        }
    }
}
