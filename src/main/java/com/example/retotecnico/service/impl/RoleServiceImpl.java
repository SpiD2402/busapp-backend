package com.example.retotecnico.service.impl;

import com.example.retotecnico.dto.RoleDTO;
import com.example.retotecnico.exception.ResourceNotFoundException;
import com.example.retotecnico.mapper.RoleMapper;
import com.example.retotecnico.model.Role;
import com.example.retotecnico.repository.RoleRepository;
import com.example.retotecnico.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl  implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleDTO> obtenerTodasLosRoles() {
        return roleRepository.findAll().stream()
                .map(RoleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public RoleDTO obtenerRolePorId(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        return RoleMapper.toDTO(role);
    }

    @Transactional
    @Override
    public RoleDTO crearRole(RoleDTO roleDTO) {
        Role role = RoleMapper.toEntity(roleDTO);
        Role roleSaved = roleRepository.save(role);
        return RoleMapper.toDTO(roleSaved);
    }

    @Transactional
    @Override
    public RoleDTO actualizarRole(Long id, RoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        existingRole.setNombre(roleDTO.getNombre());
        return RoleMapper.toDTO(existingRole);
    }

    @Transactional
    @Override
    public void eliminarRole(Long id) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        roleRepository.delete(existingRole);
    }
}
