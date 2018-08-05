
public class Company {
	String name;
	String code;
	String birthday;
	String sex;
	String address;
	String duty;
	String salary;
	String tel;
	String motel;
	String department;
	public Company(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMotel() {
		return motel;
	}
	public void setMotel(String motel) {
		this.motel = motel;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", code=" + code + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + ", duty=" + duty + ", salary=" + salary + ", tel=" + tel + ", motel=" + motel
				+ ", department=" + department + "]";
	}
	
	
}
