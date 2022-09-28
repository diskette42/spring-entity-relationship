package com.diskette42.SpringBoot.tutorial.service;

import com.diskette42.SpringBoot.tutorial.entity.Department;
import com.diskette42.SpringBoot.tutorial.error.DepartmentNotFoundException;
import com.diskette42.SpringBoot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department saveDepartment(Department d) {
        System.out.println("save");
        return departmentRepository.save(d);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department d) {
        Department existedDepartment = departmentRepository.findById(departmentId).get();

//        if(Objects.nonNull(existedDepartment)){
//            return "department not found";
//        }

        if(Objects.nonNull(d.getDepartmentName()) && !"".equalsIgnoreCase(d.getDepartmentName())){
            existedDepartment.setDepartmentName(d.getDepartmentName());
        }

        if(Objects.nonNull(d.getDepartmentName()) && !"".equalsIgnoreCase(d.getDepartmentName())){
            existedDepartment.setDepartmentName(d.getDepartmentName());
        }

        if(Objects.nonNull(d.getDepartmentName()) && !"".equalsIgnoreCase(d.getDepartmentName())){
            existedDepartment.setDepartmentName(d.getDepartmentName());
        }

        return departmentRepository.save(existedDepartment);

    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }


}
