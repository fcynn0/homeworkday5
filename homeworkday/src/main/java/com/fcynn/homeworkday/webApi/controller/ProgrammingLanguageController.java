package com.fcynn.homeworkday.webApi.controller;

import com.fcynn.homeworkday.business.abstracts.ProgrammingLanguageService;
import com.fcynn.homeworkday.business.requests.CreateProgrammingLanguageRequest;
import com.fcynn.homeworkday.business.requests.UpdateProgrammingLanguageRequest;
import com.fcynn.homeworkday.business.responses.GetAllProgrammingLanguageResponse;
import com.fcynn.homeworkday.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programminglanguage")
@AllArgsConstructor
public class ProgrammingLanguageController {
    private ProgrammingLanguageService programmingLanguageService;

    @GetMapping
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return this.programmingLanguageService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdProgrammingLanguageResponse getById(@PathVariable int id){
        return this.programmingLanguageService.getById(id);

    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
        this.programmingLanguageService.add(createProgrammingLanguageRequest);

    }
    @PutMapping
    public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        this.programmingLanguageService.update(updateProgrammingLanguageRequest);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.programmingLanguageService.delete(id);
    }

}
