package section7;

import java.util.ArrayList;

public class OracleHashMap<K, V> {

    private class Holder<K2, V2> {
        private K2 key;

        private V2 value;

        public Holder(K2 key, V2 value) {
            this.key = key;
            this.value = value;
        }
    }

    public static interface HashProvider<K> {
        int getHash(K key);
    }

    private ArrayList<Holder<K, V>>[] values; // [ArrayList], [ArrayList], [ArrayList]

    private HashProvider<K> provider;

    public OracleHashMap(HashProvider<K> provider) {
        values = new ArrayList[1000];
        for (int i = 0; i < values.length; i++) {
            values[i] = new ArrayList<Holder<K, V>>();
        }
        this.provider = provider;
    }

    public void put(K key, V value) {
        Holder<K, V> itemInBucket = getHolder(key);
        if (itemInBucket != null) {
            itemInBucket.value = value;
        } else {
            getBucket(key).add(new Holder<>(key, value));
        }
    }

    public V get(K key) {
        Holder<K, V> holder = getHolder(key);
        if (holder != null) {
            return holder.value;
        }
        return null;
    }

    private int getHash(K key) {
        return provider.getHash(key) % values.length;
    }

    private Holder<K, V> getHolder(K key) {
        ArrayList<Holder<K, V>> bucket = getBucket(key);
        for (int i = 0; i < bucket.size(); i++) {
            Holder<K, V> item = bucket.get(i);
            if (item.key == key) {
                return item;
            }
        }
        return null;
    }

    private ArrayList<Holder<K, V>> getBucket(K key) {
        int index = getHash(key);
        return values[index];
    }
}
