package com.ecoplan.erp.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    VEHICLE_NOT_FOUND("차량을 찾을 수 없습니다."),
    DUPLICATE_VEHICLE_NUMBER("이미 등록된 차량번호입니다."),
    INTERNAL_SERVER_ERROR("서버 오류가 발생했습니다.");

    private final String message;

}