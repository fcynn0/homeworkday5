package com.fcynn.homeworkday.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubTechnologyResponse {
    private int id;
    private String name;
    private String programmingLanguageName;
}
