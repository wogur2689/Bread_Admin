package com.example.bread.web.log.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogLevel {
    INFO,       //기본   (local, dev, prod)
    DEBUG,      //디버그 (local, dev)
    ERROR       //에러   (dev, prod)
}
