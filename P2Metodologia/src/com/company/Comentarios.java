package com.company;

import java.io.Serializable;

public class Comentarios implements Serializable {

    private String comentario;

    public Comentarios(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
