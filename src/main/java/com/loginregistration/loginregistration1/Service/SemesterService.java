package com.loginregistration.loginregistration1.Service;

import com.loginregistration.loginregistration1.DataModels.Semester;
import com.loginregistration.loginregistration1.Repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {
    @Autowired
    private SemesterRepository semesterRepository;

    public Semester save(Semester semester) {
        return semesterRepository.save(semester);
    }

    public List<Semester> getAll() {
        return semesterRepository.findAll();
    }

    public Optional<Semester> getSemesterById(Long id) {
        return semesterRepository.findById(id);
    }

    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }
}
