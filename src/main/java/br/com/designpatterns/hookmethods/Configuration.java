package br.com.designpatterns.hookmethods;

public abstract class Configuration {
    public final void configure(){
        // logica comun
        hookMethod();
        // logica comun
    }
    protected abstract void hookMethod();
}
