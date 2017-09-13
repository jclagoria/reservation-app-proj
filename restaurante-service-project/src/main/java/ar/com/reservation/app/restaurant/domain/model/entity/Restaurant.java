package ar.com.reservation.app.restaurant.domain.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<Table>();
    private String address;

    /**
     *
     * @param id
     * @param name
     * @param address
     * @param tables
     */
    public Restaurant(String id, String name, String address, List<Table> tables) {
        super(id, name);
        this.address = address;
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurant{");
        sb.append("tables=").append(tables).append(", address='").append(address)
                .append(", id=").append(id).append(", name='").append(name).append('}');
        return sb.toString();
    }
}
