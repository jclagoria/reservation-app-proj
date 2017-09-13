package ar.com.reservation.app.restaurant.domain.vaueobject;

import ar.com.reservation.app.restaurant.domain.model.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class RestaurantVO {

    private List<Table> tables = new ArrayList<Table>();
    private String name;
    private String id;
    private String address;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RestaurantVO{");
        sb.append("tables=").append(tables).append(", name='").append(name)
                .append(", id='").append(id).append(", address='").append(address).append('}');
        return sb.toString();
    }
}
