package pojos;

public class Restfull_expPojo {
/*
Response Body // expected data
 {
    “bookingid”: 24,
    “booking”: {
        “firstname”: “Ahmet”,
        “lastname”: “Bulut”,
        “totalprice”: 500,
        “depositpaid”: false,
        “bookingdates”: {
            “checkin”: “2021-06-01",
            “checkout”: “2021-06-10"
        },
        “additionalneeds”: “wi-fi”
    }

}
 */
    private int bookingid;
    private Restfull_reqPojo booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Restfull_reqPojo getBooking() {
        return booking;
    }

    public void setBooking(Restfull_reqPojo booking) {
        this.booking = booking;
    }


    public Restfull_expPojo(int bookingid, Restfull_reqPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Restfull_expPojo() {
    }

    @Override
    public String toString() {
        return "Restfull_expPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
