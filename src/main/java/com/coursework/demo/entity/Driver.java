package com.coursework.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "drivers")
public class Driver implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinColumn(name = "position_id")
    private Licence licence;

    @OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;
}
