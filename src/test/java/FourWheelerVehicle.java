import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class FourWheelerVehicle implements Vehicle {

    String VehicleType = "FourWheeler";
    @Setter
    List<Vehicle> VehicleList;

    @Override
    public String getVehicleType() {

        return this.VehicleType;
    }

}