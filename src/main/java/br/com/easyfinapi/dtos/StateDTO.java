package br.com.easyfinapi.dtos;

public class StateDTO {
    
    private Integer id;
    private String name;
    private String acronym;
    
    public StateDTO() {
    }
    
    public StateDTO(Integer id, String name, String acronym) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    
}
