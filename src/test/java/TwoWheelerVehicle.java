import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class TwoWheelerVehicle implements Vehicle {


    String VehicleType = "TwoWheeler";
    @Setter
    List<Vehicle> VehicleList;

    @Override
    public String getVehicleType() {
        return this.VehicleType;
    }
}