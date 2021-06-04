package model;

import com.github.javafaker.Faker;
import enums.RoomType;

import java.util.Random;

public class BookingDetails {
    private final Faker faker;

    public BookingDetails() {
        faker = new Faker();
    }

    public BookingBuilder createBookingData(){
        BookingBuilder bookingBuilder = new BookingBuilder();
        bookingBuilder.setEmail(faker.internet().emailAddress());
        bookingBuilder.setPassword(faker.internet().password());
        bookingBuilder.setCountry(returnRandomCountry());
        bookingBuilder.setBudget(returnDailyBudget());
        bookingBuilder.setRoomType(RoomType.getRandom());
        bookingBuilder.setRoomDescription(faker.lorem().paragraph());
        return bookingBuilder;
    }
    private String returnRandomCountry() {
        return returnRandomItemOnArray(new String[]{"Belgium", "Brazil", "Netherlands"});
    }

    private String returnDailyBudget() {
        return returnRandomItemOnArray(new String[]{"$100", "$100 - $499", "$499 - $999", "$999+"});
    }

    private String returnRandomItemOnArray(String[] array) {
        return array[(new Random().nextInt(array.length))];
    }
}
