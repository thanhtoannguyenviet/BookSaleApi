package com.springbook.booksale.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book", schema = "bookstore", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Image")
    private String image;
    @Basic
    @Column(name = "Description")
    private String description;
    @Basic
    @Column(name = "Price")
    private int price;
    @Basic
    @Column(name = "Quantity")
    private int quantity;
    @Basic
    @Column(name = "PublicationDate")
    private Date publicationDate;
    @Basic
    @Column(name = "Page")
    private int page;
    @Basic
    @Column(name = "IdTopic")
    private int idTopic;
    @Basic
    @Column(name = "IdPrice")
    private String idPrice;
    @Basic
    @Column(name = "IdAuthor")
    private int idAuthor;
    @Basic
    @Column(name = "isDel")
    private boolean isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getIdPrice() {
        return idPrice;
    }

    public void setIdPrice(String idPrice) {
        this.idPrice = idPrice;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(boolean isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (quantity != that.quantity) return false;
        if (page != that.page) return false;
        if (idTopic != that.idTopic) return false;
        if (idAuthor != that.idAuthor) return false;
        if (isDel != that.isDel) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (publicationDate != null ? !publicationDate.equals(that.publicationDate) : that.publicationDate != null)
            return false;
        if (idPrice != null ? !idPrice.equals(that.idPrice) : that.idPrice != null) return false;

        return true;
    }
}
