package Mod4PA3;

public class MyList<E> {
    E element;
    MyList<E> next;
    MyList<E> previous;

    public MyList(E e) {
        element = e;
        next = null;
        previous = null;
    }
}
