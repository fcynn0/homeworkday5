package com.fcynn.homeworkday.business.abstracts;

import com.fcynn.homeworkday.business.requests.CreateProgrammingLanguageRequest;
import com.fcynn.homeworkday.business.requests.UpdateProgrammingLanguageRequest;
import com.fcynn.homeworkday.business.responses.GetAllProgrammingLanguageResponse;
import com.fcynn.homeworkday.business.responses.GetByIdProgrammingLanguageResponse;
import com.fcynn.homeworkday.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguageResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id);
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
    void delete(int id);


}
