package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.dto.EmployeesDTO;
import com.northwind.northwindbackend.model.Employee;
import com.northwind.northwindbackend.repo.IEmployeeRepo;
import com.northwind.northwindbackend.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepo repo;


    @Override
    public Integer registrarDTO(EmployeesDTO obj) {
        return repo.registrarDTO(obj.getEmployee_id(),obj.getLast_name(),obj.getFirst_name(),
                obj.getTitle(),obj.getTitle_of_courtesy(),obj.getBirth_date(),obj.getHire_date(),
                obj.getAddress(),obj.getCity(),obj.getRegion(),obj.getPostal_code(),obj.getCountry(),
                obj.getHome_phone(),obj.getExtension(),obj.getPhoto(),obj.getNotes(),obj.getReportsTo(),
                obj.getPhoto_path());
    }

    @Override
    public Integer modificarDTO(EmployeesDTO obj) {
        return repo.updateDTO(obj.getEmployee_id(),obj.getLast_name(),obj.getFirst_name(),
                obj.getTitle(),obj.getTitle_of_courtesy(),obj.getBirth_date(),obj.getHire_date(),
                obj.getAddress(),obj.getCity(),obj.getRegion(),obj.getPostal_code(),obj.getCountry(),
                obj.getHome_phone(),obj.getExtension(),obj.getPhoto(),obj.getNotes(),obj.getReportsTo(),
                obj.getPhoto_path());
    }

    @Override
    public List<Employee> listar() {
        return repo.findAll();
    }

    @Override
    public Employee listarPorId(Integer id) {
        return repo.findById(id).orElseGet(Employee::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Employee> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
