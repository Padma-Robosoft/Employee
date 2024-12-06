package com.employee.Employee.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO<T>{

        private int status;
        private int code;
        private String message;
        private T data;

        public static <T> APIResponseDTO<T> success(int status, int code, String message, T data) {
            return new APIResponseDTO<>(status, code, message, data);

    }

}
