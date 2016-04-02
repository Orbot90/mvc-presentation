package ru.mbkcapital.service;

import ru.mbkcapital.dto.SimpleFormDto;
import ru.mbkcapital.model.CoolEntity;

import java.util.List;

/**
 * Created by orbot on 02.04.16.
 */
public interface ToDoService {
    SimpleFormDto getSomeDto(SimpleFormDto dto);

    void saveEntity(CoolEntity entity);

    List<CoolEntity> getEntities();
}
