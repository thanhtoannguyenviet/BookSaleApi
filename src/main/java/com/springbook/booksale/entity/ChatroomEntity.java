package com.springbook.booksale.entity;

import javax.persistence.*;

@Entity
@Table(name = "chatroom", schema = "bookstore", catalog = "")
public class ChatroomEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "isDel")
    private byte isDel;

    public long getId() {
        return id;
    }

    public void setId(long idChat) {
        this.id = idChat;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public byte getIsDel() {
        return isDel;
    }

    public void setIsDel(byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatroomEntity that = (ChatroomEntity) o;

        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        if (isDel != that.isDel) return false;

        return true;
    }
}
