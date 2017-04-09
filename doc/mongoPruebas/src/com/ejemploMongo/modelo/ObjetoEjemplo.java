package com.ejemploMongo.modelo;

import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 2/04/17.
 */

@Entity("ObjetosEjemplo")
@Indexes(
        @Index(value = "clavePrimaria", fields = @Field("clavePrimaria"))
)
public class ObjetoEjemplo{

    @Id
    private String clavePrimaria;
    private float valor;
    private boolean caracteristica;
    private List<ObjetoEjemplo> asociados;

    @Override
    public String toString() {
        return "com.ejemploMongo.modelo.ObjetoEjemplo{" +
                "clavePrimaria='" + clavePrimaria + '\'' +
                ", valor=" + valor +
                ", caracteristica=" + caracteristica +
                ", asociados=" + asociados +
                '}';
    }

    public ObjetoEjemplo(){
        this.asociados = new ArrayList<>();
    }

    public ObjetoEjemplo(String clavePrimaria, float valor, boolean caracteristica) {
        this.clavePrimaria = clavePrimaria;
        this.valor = valor;
        this.caracteristica = caracteristica;
        this.asociados = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjetoEjemplo that = (ObjetoEjemplo) o;

        return clavePrimaria != null ? clavePrimaria.equals(that.clavePrimaria) : that.clavePrimaria == null;
    }

    @Override
    public int hashCode() {
        return clavePrimaria != null ? clavePrimaria.hashCode() : 0;
    }

    public String getClavePrimaria() {
        return clavePrimaria;
    }

    public void setClavePrimaria(String clavePrimaria) {
        this.clavePrimaria = clavePrimaria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(boolean caracteristica) {
        this.caracteristica = caracteristica;
    }

    public List<ObjetoEjemplo> getAsociados() {
        return asociados;
    }

    public void setAsociados(List<ObjetoEjemplo> asociados) {
        this.asociados = asociados;
    }
}
