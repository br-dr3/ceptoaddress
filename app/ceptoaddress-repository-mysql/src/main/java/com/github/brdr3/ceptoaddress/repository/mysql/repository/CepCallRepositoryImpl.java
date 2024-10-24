package com.github.brdr3.ceptoaddress.repository.mysql.repository;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.github.brdr3.ceptoaddress.core.service.Repo;
import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.CepCall;
import com.github.brdr3.ceptoaddress.repository.mysql.entities.CepCallEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CepCallRepositoryImpl implements Repo<CepCall> {

    @PersistenceContext
    private EntityManager entityManager;
    private final JsonMapper jsonMapper;

    @Override
    @Transactional
    public void persist(final CepCall element) {
        final CepCallEntity entity = new CepCallEntity();
        entity.setIdCall(UUID.randomUUID());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUrl(element.getUrl());
        entity.setResponse(getAddress(element.getResponse()));
        entity.setResponseStatus(element.getResponseStatus());
        entity.setResponseTime(element.getResponseTime());

        entityManager.merge(entity);
    }

    private String getAddress(final Address address) {
        try {
            return jsonMapper.writeValueAsString(address);
        } catch (Exception e) {
            throw new RuntimeException("Could not write address as string", e);
        }
    }
}
