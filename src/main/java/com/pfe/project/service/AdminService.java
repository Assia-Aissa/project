package com.pfe.project.service;

import com.pfe.project.dto.AdminRequestDto;
import com.pfe.project.dto.AdminResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface AdminService {
    AdminResponseDto save(AdminRequestDto adminRequestDto);
    AdminResponseDto findById(Integer id);
    void delete(Integer id);
    AdminResponseDto update(AdminRequestDto adminRequestDto, Integer id) throws ChangeSetPersister.NotFoundException;
}
