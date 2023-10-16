import java.util.Iterator;

public class MyCollection <T> implements Iterable<T> {
    private Object[] array;
    private int currentAddIndex;


    public MyCollection(int initialSize) {
        array = new Object[initialSize];
        currentAddIndex = 0;
    }

    public MyCollection() {
        this(10);
    }

    public void add(T newElement) {
        if (currentAddIndex >= array.length) {
            enlarge();
        }
        array[currentAddIndex] = newElement;
        currentAddIndex++;
    }

    private void enlarge() {
        int newLength = (int) (array.length * 1.5);
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public T get(int index) {
        if (index < 0 || index >= currentAddIndex) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d when bounds are 0 and %d in MyCollection", index, currentAddIndex));
        }
        return (T) array[index];
    }

    public int find(T toFind) {
        for (int i = 0; i < currentAddIndex; i++) {
            if (array[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T toRemove) {
        int pos = find(toRemove);
        if (pos == -1) {
            return;
        }
        for (int i = pos; i < currentAddIndex - 1; i++) {
            array[i] = array[i + 1];
        }
        currentAddIndex--;
    }

    public int length() {
        return currentAddIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0 ; i < currentAddIndex - 1; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }
        if (currentAddIndex > 0) {
            sb.append(array[currentAddIndex - 1]);
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;


            @Override
            public boolean hasNext() {
                return index < currentAddIndex;
            }

            @Override
            public T next() {
                return (T)array[index++];
            }
        };
    }
}
