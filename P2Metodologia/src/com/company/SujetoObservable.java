package com.company;

public interface SujetoObservable {

    void notificar();//avisar cuando el usuario inicie sesion de que hay foros con nuevas entradas
    void addObserver(Observador observador);
    void deleteObserver(Observador observador);

}
