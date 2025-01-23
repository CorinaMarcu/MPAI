package builder;

import java.util.Arrays;

public class HolidayPackage implements AbstractHolidayPackage, Cloneable{

    String transportType;
    int nightsOfAcomodation;
    String roomType;
    int hotelRanking;
    String[] extraActivities;
    float price;

    private HolidayPackage() {

    }
    public HolidayPackage(String transportType, int nightsOfAcomodation, String roomType, int hotelRanking, String[] extraActivities, float price) {
        this.transportType = transportType;
        this.nightsOfAcomodation = nightsOfAcomodation;
        this.roomType = roomType;
        this.hotelRanking = hotelRanking;
        this.extraActivities = extraActivities;
        this.price = price;
    }


    @Override
    public String toString() {
        return "HolidayPackage{" +
                "transportType='" + transportType + '\'' +
                ", nightsOfAcomodation=" + nightsOfAcomodation +
                ", roomType='" + roomType + '\'' +
                ", hotelRanking=" + hotelRanking +
                ", extraActivities=" + Arrays.toString(extraActivities) +
                ", price=" + price +
                '}';
    }

    @Override
    public String getTransportType() {
        return transportType;
    }

    @Override
    public int getNightsOfAccommodation() {
        return nightsOfAcomodation;
    }

    @Override
    public String getRoomType() {
        return roomType;
    }

    @Override
    public int getHotelRanking() {
        return hotelRanking;
    }

    @Override
    public String[] getExtraActivities() {
        return extraActivities;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HolidayPackage copy=(HolidayPackage) super.clone();
        copy.extraActivities=extraActivities;
        copy.hotelRanking=hotelRanking;
        copy.nightsOfAcomodation=nightsOfAcomodation;
        copy.price=price;
        copy.roomType=roomType;
        copy.transportType=transportType;
        return copy;
    }

    public static class HolidayPackageBuilder{
        private HolidayPackage holidayPackage= new HolidayPackage();

        public HolidayPackageBuilder addTransportType(String transportType)
        {
            holidayPackage.transportType=transportType;
            return this;
        }
        public HolidayPackageBuilder addNightsOfAccomodation(int nightsOfAcomodation){
            holidayPackage.nightsOfAcomodation=nightsOfAcomodation;
            return this;
        }

        public HolidayPackageBuilder addRoomType(String roomType){
            holidayPackage.roomType=roomType;
            return this;
        }

        public HolidayPackageBuilder addHotelRanking(int hotelRanking){
            holidayPackage.hotelRanking=hotelRanking;
            return this;
        }

        public HolidayPackageBuilder addExtraActivities(String[] extraActivities){
            holidayPackage.extraActivities=extraActivities;
            return this;
        }

        public HolidayPackageBuilder addPrice(float price){
            holidayPackage.price=price;
            return this;
        }
        public HolidayPackage build() {
            try{
                HolidayPackage copy = (HolidayPackage) holidayPackage.clone();
                holidayPackage= new HolidayPackage();
                return copy;
            } catch(CloneNotSupportedException e){
                e.printStackTrace();
                return null;
            }



        }
    }
}
