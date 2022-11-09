package com.springbook.booksale.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoicedetail", schema = "bookstore", catalog = "")
public class InvoicedetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "id_invoice")
    private int idInvoice;
    @Basic
    @Column(name = "is_del", columnDefinition = "bit default false")
    private boolean isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
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

        InvoicedetailEntity that = (InvoicedetailEntity) o;

        if (id != that.id) return false;
        if (idProduct != that.idProduct) return false;
        if (price != that.price) return false;
        if (quantity != that.quantity) return false;
        if (idInvoice != that.idInvoice) return false;
        if (isDel != that.isDel) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }
}
