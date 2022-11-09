package com.springbook.booksale.entity;

import javax.persistence.*;

@Entity
@Table(name = "chatroom", schema = "bookstore", catalog = "")
public class ChatroomEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdChat")
    private int idChat;
    @Basic
    @Column(name = "IdUser")
    private int idUser;
    @Basic
    @Column(name = "isDel")
    private byte isDel;

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
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

        if (idChat != that.idChat) return false;
        if (idUser != that.idUser) return false;
        if (isDel != that.isDel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idChat;
        result = 31 * result + idUser;
        result = 31 * result + (int) isDel;
        return result;
    }
}
