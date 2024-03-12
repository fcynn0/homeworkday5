package com.fcynn.homeworkday.business.abstracts;

import com.fcynn.homeworkday.business.requests.CreateSubTechnologyRequest;
import com.fcynn.homeworkday.business.requests.UpdateSubTechnologyRequest;
import com.fcynn.homeworkday.business.responses.GetAllSubTechnologyResponse;

import java.util.List;

public interface SubTechnologyService {
    List<GetAllSubTechnologyResponse> getAll();
    void add(CreateSubTechnologyRequest createSubTechnologyRequest);
    void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);
    void delete(int id);

}
