package ar.com.reservation.app.user.domain.model.entity;

public class User extends BaseEntity<String> {

    private String address;
    private String city;
    private String phoneNo;

    /**
     *
     * @param id
     * @param name
     * @param address
     * @param city
     * @param phoneNo
     */
    public User(String id, String name, String address, String city, String phoneNo) {
        super(id, name);
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("address='").append(address).append(", city='").append(city)
                .append(", phoneNo='").append(phoneNo).append(", id=").append(id)
                .append(", name='").append(name).append('}');
        return sb.toString();
    }
}
