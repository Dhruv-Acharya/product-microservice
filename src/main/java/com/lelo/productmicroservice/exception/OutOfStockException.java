package com.lelo.productmicroservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Out of Stock!")
public class OutOfStockException extends RuntimeException {
}
