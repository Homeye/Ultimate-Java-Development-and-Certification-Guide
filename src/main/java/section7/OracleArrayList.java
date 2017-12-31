package section7;

public class OracleArrayList<T> {

    private T[] items;

    private int filledSpots;

    public OracleArrayList() {
        items = (T[]) new Object[10];
    }

    public void add(T item) {
        if (filledSpots < items.length) {
            items[filledSpots] = item;
            filledSpots++;
        } else {
            T[] copy = items;
            items = (T[]) new Object[items.length + 10];
            for (int i = 0; i < copy.length; i++) {
                items[i] = copy[i];
            }
            add(item);
        }
    }

    public T get(int index) {
        return items[index];
    }

    public int size() {
        return items.length;
    }
}
