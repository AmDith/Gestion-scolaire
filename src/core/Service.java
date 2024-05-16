package core;

import java.util.List;

public interface Service<T> {
    boolean save (T objet);
    List<T> show();
    void liste(List<T> objeTs);
    void liste(T objeTs);
    T verfId(List<T> objeTs, int id);  
}
