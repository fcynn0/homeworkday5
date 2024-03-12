package com.fcynn.homeworkday.webApi.controller;

import com.fcynn.homeworkday.business.abstracts.SubTechnologyService;
import com.fcynn.homeworkday.business.requests.CreateSubTechnologyRequest;
import com.fcynn.homeworkday.business.requests.UpdateSubTechnologyRequest;
import com.fcynn.homeworkday.business.responses.GetAllSubTechnologyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtechnology")
@AllArgsConstructor
public class SubTechnologyController {
    private SubTechnologyService subTechnologyService;

    @GetMapping()
    public List<GetAllSubTechnologyResponse> getAll(){
        return this.subTechnologyService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest){
        this.subTechnologyService.add(createSubTechnologyRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest){
        this.subTechnologyService.update(updateSubTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.subTechnologyService.delete(id);
    }


}
