package oo;

public class Person {
	private String id;
	private String name;
    private String email;
    private String phone;
    private String password;

    public Person(String id, String name,String email,String phone,String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getPassword() {
        return password;
    }
}
