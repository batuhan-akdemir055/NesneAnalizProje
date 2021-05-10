package com.company;

public interface ISubject {

     void attach(IObserver o);
     void detach(IObserver o);
     void notify(String m);
}
