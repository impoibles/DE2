package com.electronicregion.de2.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class addedEmployee {
    private String FIO;
    private Long Snils;
    private String Organization;
    private String employeeDolhnost;
    private String ReasonOfDismissal;
    private int region_id;
}
