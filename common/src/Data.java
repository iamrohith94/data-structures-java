/**
 * @author rohith reddy
 * @date 08/10/19
 */

class Data<T extends Comparable>  {

    private T value;

    Data(T value) {
        this.value = value;
    }

    T getValue() {
        return this.value;
    }

    void setValue(T value) {
        this.value = value;
    }

    int compareTo(Data<T> data) {
        return getValue().compareTo(data.getValue());
    }

    int compareTo(T value) {
        return getValue().compareTo(value);
    }
}
