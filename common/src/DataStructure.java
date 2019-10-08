import java.util.Date;

/**
 * @author rohith reddy
 * @date 08/10/19
 */

public interface DataStructure<T extends Comparable> {

    void insert(T data);

    boolean search(T data);

    void delete(T data);

    boolean isValid();
}
