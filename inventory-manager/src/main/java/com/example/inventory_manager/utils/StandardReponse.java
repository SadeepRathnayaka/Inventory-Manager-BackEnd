package com.example.inventory_manager.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardReponse {

    private int code;
    private String message;
    private Object data;
}
