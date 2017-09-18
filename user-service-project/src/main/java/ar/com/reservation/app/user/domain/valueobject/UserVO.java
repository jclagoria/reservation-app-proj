package ar.com.reservation.app.user.domain.valueobject;

public class UserVO {

    private String name;
    private String id;
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
    public UserVO(String id, String name, String address, String city, String phoneNo) {
       this.id = id;
       this.name = name;
       this.address = address;
       this.city = city;
       this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        final StringBuilder sb = new StringBuilder("UserVO{");
        sb.append("name='").append(name).append(", id='").append(id)
                .append(", address='").append(address).append(", city='").append(city)
                .append(", phoneNo='").append(phoneNo).append('}');
        return sb.toString();
    }
}
