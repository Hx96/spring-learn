package org.hx.java.adt;

import com.hx.common.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private Order order = new Order();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Order {
    Integer orderId;
    Integer orderName;
}
//region generic

interface Set1<E> {

    // ...

    /**
     * Test for membership.
     * @param e an element
     * @return true iff this set contains e
     */
    public boolean contains(E e);

    /**
     * Modifies this set by adding e to the set.
     * @param e element to add
     */
    public void add(E e);

    // ...
}

class CharSet1 implements Set1<Character> {
    private String s = "";
    // ...

    @Override
    public boolean contains(Character e) {
        return s.indexOf(e) != -1;
    }

    @Override
    public void add(Character e) {
        if (!contains(e)) {
            s += e;
        }
    }

    @Override
    public String toString() {
        return "CharSet1{" +
                "s='" + s + '\'' +
                '}';
    }

    // ...
}
//endregion

/**
 * @author kyle
 */
public class GneraticClient {

    public static final String ORDER = "{\n" +
            "    \"order\": {\n" +
            "        \"orderId\": 0,\n" +
            "        \"orderName\": 0\n" +
            "    }\n" +
            "}";
    public static void main(String[] args) {
        User user = JSON.parseObject(ORDER, User.class);
        System.out.println(user);

        CharSet1 charSet1 = new CharSet1();
        charSet1.add('x');
        charSet1.add('y');
        charSet1.add('z');
        System.out.println(charSet1);
    }
}
