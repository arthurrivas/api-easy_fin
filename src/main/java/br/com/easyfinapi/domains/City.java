package br.com.easyfinapi.domains;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> address = new HashSet<>();
    
    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="id_state")
    private State state;
    
    public City() {
    }
    public City(Integer id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
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

    public Set<Address> getAddress() {
        return address;
    }
    public void setAddress(Set<Address> address) {
        this.address = address;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", address=" + address + ", state=" + state + "]";
    }

}
