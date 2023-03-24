package com.spangles.orgdepartmentmanagement.repositoty;

import com.spangles.orgdepartmentmanagement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query(value = "SELECT s FROM Subject s WHERE s.subjectId=?1")
    public Subject getSubject(Long subjectId);
    @Query(value = "SELECT s FROM Subject s WHERE s.subjectCode = ?1")
    public Subject getSubjectBySubjectCode(String subjectCode);
    @Query(value = "SELECT s FROM Subject s WHERE s.subjectName = ?1")
    public Subject getSubjectBySubjectName(String subjectName);
}
