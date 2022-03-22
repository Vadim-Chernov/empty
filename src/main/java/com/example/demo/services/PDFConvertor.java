package com.example.demo.services;

import lombok.NonNull;

public interface PDFConvertor {
    String convert(@NonNull String str);
}
