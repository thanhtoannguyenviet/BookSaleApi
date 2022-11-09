package com.springbook.booksale.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "invoice", schema = "bookstore", catalog = "")
public class InvoiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "Created")
    private Timestamp created;
    @Basic
    @Column(name = "Status")
    private String status;
    @Basic
    @Column(name = "Total")
    private int total;
    @Basic
    @Column(name = "Updated")
    private Timestamp updated;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @Basic
    @Column(name = "Address")
    private String address;
    @Basic
    @Column(name = "shippingFee")
    private int shippingFee;
    @Basic
    @Column(name = "paymentCode")
    private String paymentCode;
    @Basic
    @Column(name = "isDel")
    private boolean isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
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

        InvoiceEntity that = (InvoiceEntity) o;

        if (id != that.id) return false;
        if (total != that.total) return false;
        if (shippingFee != that.shippingFee) return false;
        if (isDel != that.isDel) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (paymentCode != null ? !paymentCode.equals(that.paymentCode) : that.paymentCode != null) return false;

        return true;
    }
}
