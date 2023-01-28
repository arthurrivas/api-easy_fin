package br.com.easyfinapi.dtos;

public class AddressDTO {
    
    private Integer id;
    private Integer number;
    private Integer idCity;
    private Integer idState;

    public AddressDTO() {
    }

    public AddressDTO(Integer id, Integer number, Integer idCity, Integer idState) {
        this.id = id;
        this.number = number;
        this.idCity = idCity;
        this.idState = idState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    
        
}
