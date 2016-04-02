package ru.mbkcapital.service;

import org.springframework.stereotype.Service;
import ru.mbkcapital.dto.SimpleFormDto;

/**
 * Created by orbot on 02.04.16.
 */
@Service
public class ToDoServiceImpl implements ToDoService {
    @Override
    public SimpleFormDto getSomeDto(SimpleFormDto dto) {
        dto.setName(dto.getName() + " after process");
        dto.setEmail(dto.getEmail() + " after process");
        return dto;
    }
}
