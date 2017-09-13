package ar.com.reservation.app.restaurant.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * @author jclagoria
 */
public class Table extends BaseEntity<BigInteger> {

    private int capacity;

    public Table(@JsonProperty("name") String name, @JsonProperty("id") BigInteger id,
                 @JsonProperty("capacity") int capacity) {
        super(id, name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Table{");
        sb.append("capacity=").append(capacity).append(", id=").append(id)
                .append(", name='").append(name).append('}');
        return sb.toString();
    }
}
