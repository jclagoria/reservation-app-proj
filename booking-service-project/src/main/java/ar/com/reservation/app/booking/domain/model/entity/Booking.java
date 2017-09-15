package ar.com.reservation.app.booking.domain.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking extends BaseEntity<String> {

    private String restaurantId;
    private String userId;
    private LocalDate date;
    private LocalTime time;
    private String tableId;

    /**
     *
     * @param id
     * @param name
     * @param restaurantId
     * @param tableId
     * @param userId
     * @param date
     * @param time
     */
    public Booking(String id, String name, String restaurantId, String tableId,
                   String userId, LocalDate date, LocalTime time) {
        super(id, name);
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Booking{");
        sb.append("restaurantId='").append(restaurantId).append(", userId='").append(userId)
                .append(", date=").append(date).append(", time=").append(time).append(", tableId='").append(tableId)
                .append(", id=").append(id).append(", name='").append(name).append('}');
        return sb.toString();
    }
}
