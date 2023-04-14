package com.spangles.orgdepartmentmanagement.repositoty;

import com.spangles.orgdepartmentmanagement.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Long> {
    @Query(value = "SELECT s FROM Semester s WHERE s.semesterId=?1")
    public Semester getSemester(Long semesterId);
    @Query(value = "SELECT s FROM Semester s WHERE s.semesterCode=?1")
    public Semester getSemesterBySemesterCode(Long semesterCode);
    @Query(value = "SELECT s FROM Semester s WHERE s.semesterName=?1")
    public Semester getSemesterBySemesterName(String semesterName);
}
