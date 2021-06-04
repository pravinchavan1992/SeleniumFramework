package model;

import enums.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingBuilder {
    private String email;
    private String country;
    private String password;
    private String budget;
    private RoomType roomType;
    private Boolean newsletter;
    private String roomDescription;

    public BookingBuilder getBookingData(){
        return new BookingDetails().createBookingData();
    }
}
