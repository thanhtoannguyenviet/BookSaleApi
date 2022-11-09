package com.springbook.booksale.entity;

import javax.persistence.*;

@Entity
@Table(name = "chatdetail", schema = "bookstore", catalog = "")
public class ChatdetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "IdUser")
    private int idUser;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "idChatRoom")
    private int idChatRoom;
    @Basic
    @Column(name = "isDel")
    private byte isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdChatRoom() {
        return idChatRoom;
    }

    public void setIdChatRoom(int idChatRoom) {
        this.idChatRoom = idChatRoom;
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

        ChatdetailEntity that = (ChatdetailEntity) o;

        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        if (idChatRoom != that.idChatRoom) return false;
        if (isDel != that.isDel) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUser;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + idChatRoom;
        result = 31 * result + (int) isDel;
        return result;
    }
}
