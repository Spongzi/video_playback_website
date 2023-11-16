package com.spongzi.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 条件异常
 *
 * @author spong
 * @date 2023/11/16
 */
@Getter
@Setter
public class ConditionException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 3090305017804944706L;

    private String code;

    public ConditionException(String code, String name) {
        super(name);
        this.code = code;
    }

    public ConditionException(String name) {
        super(name);
        this.code = "500";
    }
}
