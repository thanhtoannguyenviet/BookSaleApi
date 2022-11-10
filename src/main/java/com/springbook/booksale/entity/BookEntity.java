package com.springbook.booksale.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "book", schema = "bookstore", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "description", columnDefinition = "varchar(1000)")
    private String description;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "publication_date")
    private Date publicationDate;
    @Basic
    @Column(name = "page")
    private int page;

    @Basic
    @Column(name = "is_del", columnDefinition = "bit default false")
    private boolean isDel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private AuthorEntity authorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topic")
    private TopicEntity topicEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        if (isDel != that.isDel) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (publicationDate != null ? !publicationDate.equals(that.publicationDate) : that.publicationDate != null)
            return false;
        return true;
    }
}
