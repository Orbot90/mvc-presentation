package ru.mbkcapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mbkcapital.dto.SimpleFormDto;
import ru.mbkcapital.model.CoolEntity;
import ru.mbkcapital.repository.CoolRepository;

import java.util.List;

/**
 * Created by orbot on 02.04.16.
 */
@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private CoolRepository coolRepository;

    @Override
    public SimpleFormDto getSomeDto(SimpleFormDto dto) {
        dto.setName(dto.getName() + " after process");
        dto.setEmail(dto.getEmail() + " after process");
        return dto;
    }

    @Override
    public void saveEntity(CoolEntity entity) {
        coolRepository.save(entity);
    }

    @Override
    public List<CoolEntity> getEntities() {
        return coolRepository.findAll();
    }
}
