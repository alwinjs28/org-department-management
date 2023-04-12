package com.spangles.orgdepartmentmanagement.repositoty;

import com.spangles.orgdepartmentmanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "SELECT d FROM Department d WHERE d.departmentId=?1")
    public Department getDepartment(Long departmentId);

    @Query(value = "SELECT d FROM Department d WHERE d.departmentCode = ?1")
    public Department getDepartmentByDepartmentCode(String departmentCode);
    @Query(value = "SELECT d FROM Department d WHERE d.departmentName = ?1")
    public Department getDepartmentByDepartmentName(String departmentName);
}
