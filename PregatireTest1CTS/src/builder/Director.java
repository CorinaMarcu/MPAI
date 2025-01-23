package builder;

public class Director {

    private HolidayPackage.HolidayPackageBuilder builder;

    public Director(HolidayPackage.HolidayPackageBuilder builder) {
        this.builder = builder;
    }

    public HolidayPackage createholidayPackage1()
    {
            builder.addPrice(50)
                    .addHotelRanking(10)
                    .addRoomType("Single");
            return builder.build();

    }
}
