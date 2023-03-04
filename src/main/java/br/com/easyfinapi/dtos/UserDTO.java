package br.com.easyfinapi.dtos;

public class UserDTO {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Integer codProfile;

	private AddressDTO address;
	
	public UserDTO() {
	}

	public UserDTO(Integer id, String name, String email, String phone, String password, Integer codProfile, AddressDTO address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.codProfile = codProfile;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCodProfile() {
		return codProfile;
	}

	public void setCodProfile(Integer codProfile) {
		this.codProfile = codProfile;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				", codProfile=" + codProfile +
				", addressDTO=" + address +
				'}';
	}
}
