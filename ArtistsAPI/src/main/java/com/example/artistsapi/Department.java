package com.example.artistsapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    private Long departmentId;
    @Column(name = "Display_name")
    private String displayName;


    //private Logger logger = Logger.getLogger("DepartmentClass");

    public Department(Long departmentId, String displayName){
        this.departmentId = departmentId;
        this.displayName = displayName;
    }
    protected Department(){}

    public Long setDepartmentId(Long departmentId){
        return this.departmentId = departmentId;
    }

    public Long getDepartmentId(){
        return departmentId;
    }

    public String setDisplayName(String displayName){
        return this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }

        public void getDepartmentsFromMOMA() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String momaURL = "https://collectionapi.metmuseum.org/public/collection/v1/departments";
        ResponseEntity<String> response = restTemplate.getForEntity(momaURL, String.class);
//        Assertions.assertThat(response.getStatusCode(), HttpStatus.OK);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("name");

//        List<Department> listDepartment = mapper.readValue(root,
//                new TypeReference<List<Department>>(){});
//        Assertions.assertNotNull(name.asText());
    }


}
