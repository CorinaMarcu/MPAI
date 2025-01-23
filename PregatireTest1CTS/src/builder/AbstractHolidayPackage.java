package builder;

public interface AbstractHolidayPackage {
    String getTransportType();
    int getNightsOfAccommodation();
    String getRoomType();
    int getHotelRanking();
    String[] getExtraActivities();
    float getPrice();
}
