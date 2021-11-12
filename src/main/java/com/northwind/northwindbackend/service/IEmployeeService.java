package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.dto.EmployeesDTO;
import com.northwind.northwindbackend.model.Employee;

public interface IEmployeeService extends IREADDELETE<Employee,Integer>,ICREATEUPDATEDTO<EmployeesDTO> {
}
