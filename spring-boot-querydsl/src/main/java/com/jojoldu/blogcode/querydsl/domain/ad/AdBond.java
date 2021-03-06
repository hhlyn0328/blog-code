package com.jojoldu.blogcode.querydsl.domain.ad;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class AdBond{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long amount;
    private LocalDate txDate;
    private String orderType;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_ad_bond_customer"))
    private Customer customer;

    @Builder
    public AdBond(long amount, LocalDate txDate, String orderType, Customer customer) {
        this.amount = amount;
        this.txDate = txDate;
        this.orderType = orderType;
        setCustomer(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
