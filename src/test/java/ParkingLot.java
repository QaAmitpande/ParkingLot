import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParkingLot {
    @Setter
    private int twoWheelerCapacity;
    @Setter
    private int fourWheelerCapacity;
    private List<Vehicle> vehicles;
    private int twoWheelerParkingPrice;
    private int fourWheelerParkingPrice;
    private int twoWheelerParkingSaturdayPrice;
    private int twoWheelerParkingSundayPrice;
    private int fourWheelerParkingSaturdayPrice;
    private int fourWheelerParkingSundayPrice;

    public ParkingLot(Builder builder) {
        this.twoWheelerCapacity = builder.twoWheelerCapacity;
        this.fourWheelerCapacity = builder.fourWheelerCapacity;
        this.twoWheelerParkingPrice = builder.twoWheelerParkingPrice;
        this.fourWheelerParkingPrice = builder.fourWheelerParkingPrice;
        this.twoWheelerParkingSaturdayPrice = builder.twoWheelerParkingSaturdayPrice;
        this.twoWheelerParkingSundayPrice = builder.twoWheelerParkingSundayPrice;
        this.fourWheelerParkingSaturdayPrice = builder.fourWheelerParkingSaturdayPrice;
        this.fourWheelerParkingSundayPrice = builder.fourWheelerParkingSundayPrice;
        this.vehicles = new ArrayList<>();
    }

    public static class Builder {
        private int twoWheelerCapacity;
        private int fourWheelerCapacity;
        private int twoWheelerParkingPrice;
        private int fourWheelerParkingPrice;
        private int twoWheelerParkingSaturdayPrice;
        private int twoWheelerParkingSundayPrice;
        private int fourWheelerParkingSaturdayPrice;
        private int fourWheelerParkingSundayPrice;

        public Builder() {
            this.twoWheelerCapacity = 100;
            this.fourWheelerCapacity = 50;
            this.twoWheelerParkingPrice = 10;
            this.fourWheelerParkingPrice = 20;
            this.twoWheelerParkingSaturdayPrice = 15;
            this.twoWheelerParkingSundayPrice = 20;
            this.fourWheelerParkingSaturdayPrice = 30;
            this.fourWheelerParkingSundayPrice = 40;

        }


        public ParkingLot build() {

            return new ParkingLot(this);
        }

    }

}
