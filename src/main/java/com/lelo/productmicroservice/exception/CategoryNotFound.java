package com.lelo.productmicroservice.exception;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "No Category Found!")
public class CategoryNotFound extends RuntimeException {

}
