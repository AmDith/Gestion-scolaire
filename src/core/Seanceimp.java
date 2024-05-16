package core;

import java.time.LocalDate;
import java.util.List;

import entities.Statut;

public interface Seanceimp<T,N,M> {
    List<T> show();
    T verfId(N objeTs, int id);
    void liste(N objeTs,Statut statut);
    void liste(N objeTs,LocalDate date);
    
}
