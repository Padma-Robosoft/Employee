package com.employee.Employee.util;
import com.employee.Employee.dto.APIResponseDTO;

import com.employee.Employee.dto.APIResponseDTO;

public class APIResponseUtil {
    public static <T> APIResponseDTO<T> successResponse(T data) {
        return new APIResponseDTO<>(0, Integer.parseInt(System.getProperty("status.success", "200")),
                System.getProperty("response.success", "Success"), data);
    }


    public static APIResponseDTO<String> successResponse(String message) {
        return new APIResponseDTO<>(0, Integer.parseInt(System.getProperty("status.success", "200")),
                message, null);
    }


    public static APIResponseDTO<Object> errorResponse(String message) {
        return new APIResponseDTO<>(-1, Integer.parseInt(System.getProperty("status.internalservererror", "500")),
                message, null);
    }


    public static <T> APIResponseDTO<T> createResponse(int status, int code, String message, T data) {
        return new APIResponseDTO<>(status, code, message, data);
    }
}
