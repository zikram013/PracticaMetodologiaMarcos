package com.company.Comentarios;

import java.io.Serializable;

public class Comentarios implements Serializable {
    private static final long serialVersionUID = 1L;
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
