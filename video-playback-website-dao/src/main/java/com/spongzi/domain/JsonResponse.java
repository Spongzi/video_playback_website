package com.spongzi.domain;

import lombok.Data;

/**
 * JSON响应
 *
 * @author spong
 * @date 2023/11/16
 */
@Data
public class JsonResponse<T> {

    private Integer code;

    private String message;

    private T data;

    /**
     * 成功
     *
     * @return {@link JsonResponse}<{@link T}>
     */
    public static <T> JsonResponse<T> success() {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(0);
        response.setMessage("响应成功");
        return response;
    }

    /**
     * 成功
     *
     * @return {@link JsonResponse}<{@link T}>
     */
    public static <T> JsonResponse<T> success(T data) {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(0);
        response.setMessage("响应成功");
        response.setData(data);
        return response;
    }


    /**
     * 成功
     *
     * @return {@link JsonResponse}<{@link T}>
     */
    public static <T> JsonResponse<T> success(Integer code, String message, T data) {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    /**
     * 失败
     *
     * @return {@link JsonResponse}<{@link T}>
     */
    public static <T> JsonResponse<T> fail() {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(1);
        response.setMessage("响应失败");
        return response;
    }

    /**
     * 失败
     *
     * @return {@link JsonResponse}<{@link T}>
     */
    public static <T> JsonResponse<T> fail(T data) {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(1);
        response.setMessage("响应失败");
        response.setData(data);
        return response;
    }


    /**
     * 失败
     *
     * @return {@link JsonResponse}<{@link T}>
     */
    public static <T> JsonResponse<T> fail(Integer code, String message, T data) {
        JsonResponse<T> response = new JsonResponse<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
