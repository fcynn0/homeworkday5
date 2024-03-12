package com.fcynn.homeworkday.business.concretes;

import com.fcynn.homeworkday.business.abstracts.SubTechnologyService;
import com.fcynn.homeworkday.business.requests.CreateSubTechnologyRequest;
import com.fcynn.homeworkday.business.requests.UpdateSubTechnologyRequest;
import com.fcynn.homeworkday.business.responses.GetAllSubTechnologyResponse;
import com.fcynn.homeworkday.core.utilities.mapper.ModelMapperService;
import com.fcynn.homeworkday.dataAccess.SubTechnologyRepository;
import com.fcynn.homeworkday.entities.concretes.SubTechnology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {
    private SubTechnologyRepository subTechnologyRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllSubTechnologyResponse> getAll() {
        List<SubTechnology> subTechnologies=this.subTechnologyRepository.findAll();
        List<GetAllSubTechnologyResponse> getAllSubTechnologyResponses=subTechnologies.stream()
                .map(subTechnology -> this.modelMapperService.forResponse()
                .map(subTechnology, GetAllSubTechnologyResponse.class)).collect(Collectors.toList());
        return getAllSubTechnologyResponses;
    }

    @Override
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
        SubTechnology subTechnology=this.modelMapperService.forRequest().map(createSubTechnologyRequest,SubTechnology.class);
        this.subTechnologyRepository.save(subTechnology);

    }

    @Override
    public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        SubTechnology subTechnology=this.modelMapperService.forRequest().map(updateSubTechnologyRequest,SubTechnology.class);
        this.subTechnologyRepository.save(subTechnology);


    }

    @Override
    public void delete(int id) {
        this.subTechnologyRepository.deleteById(id);

    }
}
