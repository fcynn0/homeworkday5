package com.fcynn.homeworkday.business.concretes;

import com.fcynn.homeworkday.business.abstracts.ProgrammingLanguageService;
import com.fcynn.homeworkday.business.requests.CreateProgrammingLanguageRequest;
import com.fcynn.homeworkday.business.requests.UpdateProgrammingLanguageRequest;
import com.fcynn.homeworkday.business.responses.GetAllProgrammingLanguageResponse;
import com.fcynn.homeworkday.business.responses.GetByIdProgrammingLanguageResponse;
import com.fcynn.homeworkday.core.utilities.mapper.ModelMapperService;
import com.fcynn.homeworkday.dataAccess.ProgrammingLanguageRepository;
import com.fcynn.homeworkday.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages=this.programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguageResponse> getAllProgrammingLanguageResponses=programmingLanguages.stream()
                .map(programmingLanguage -> this.modelMapperService.forResponse()
                        .map(programmingLanguage,GetAllProgrammingLanguageResponse.class)).collect(Collectors.toList());

        return getAllProgrammingLanguageResponses;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage programmingLanguage=this.programmingLanguageRepository.findById(id).orElseThrow();
        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse=this.modelMapperService.forResponse().map(programmingLanguage,GetByIdProgrammingLanguageResponse.class);
        return getByIdProgrammingLanguageResponse;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage=this.modelMapperService.forRequest().map(createProgrammingLanguageRequest,ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);


    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage=this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest,ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);


    }

    @Override
    public void delete(int id) {
        this.programmingLanguageRepository.deleteById(id);

    }
}
