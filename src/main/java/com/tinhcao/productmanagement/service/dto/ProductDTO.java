package com.tinhcao.productmanagement.service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String entryDate;
    private String itemCode;
    private String itemName;
    private String itemQuantity;
    private String upc;
    private String ean;
    private String sku;
    private String isbn;
    private String mpc;
    private String sStatus;
}
