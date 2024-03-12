package com.fcynn.homeworkday.dataAccess;

import com.fcynn.homeworkday.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {

}
