package com.lelo.productmicroservice.exception;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Category Name already Exists")
public class CategoryAlreadyExists extends RuntimeException {
}
