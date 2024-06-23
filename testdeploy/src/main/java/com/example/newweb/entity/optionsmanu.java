package com.example.newweb.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class optionsmanu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionsmanuId;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private menuitem menuItem;

    @Column
    private String optionName;

    @ElementCollection
    @Column(name = "optionsdetail")
    private List<String> optionsdetail;
}
