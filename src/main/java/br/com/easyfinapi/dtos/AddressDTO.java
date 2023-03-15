package br.com.easyfinapi.dtos;

public class AddressDTO {
    
    private Integer id;
    private Integer number;
    private CityDTO city;

    public AddressDTO() {
    }

    public AddressDTO(Integer id, Integer number, CityDTO city) {
        this.id = id;
        this.number = number;
        this.city = city;
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

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

}
