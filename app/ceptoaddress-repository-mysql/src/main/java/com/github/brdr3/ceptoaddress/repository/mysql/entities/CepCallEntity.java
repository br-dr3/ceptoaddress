package com.github.brdr3.ceptoaddress.repository.mysql.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "cep_calls")
public class CepCallEntity {
    @Id
    @Column(name = "id_call", nullable = false, updatable = false, unique = true)
    private UUID idCall;

    @Column(name = "created_at", columnDefinition = "datetime default current_timestamp", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "url", columnDefinition = "text", nullable = false)
    private String url;

    @Column(name = "response", columnDefinition = "text", nullable = false)
    private String response;

    @Column(name = "response_status", columnDefinition = "text", nullable = false)
    private String responseStatus;

    @Column(name = "response_time", columnDefinition = "bigint", nullable = false)
    private BigInteger responseTime;
}