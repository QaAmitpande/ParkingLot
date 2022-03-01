import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String incomingTwoWheelerVehicleInParkingLot(List<Vehicle> vehicles) {
        int twoWheeler = getVehicleCount(vehicles, "TwoWheeler");
        if (twoWheeler > parkingLot.getTwoWheelerCapacity()) {
            return "Two wheeler parking capacity is full";
        }
        setCapacityAfterTwoWheelersEntry(twoWheeler);
        addVehicle(vehicles);
        return "Two wheeler added in parking";
    }


    public String incomingFourWheelerVehicleInParkingLot(List<Vehicle> vehicles) {
        int fourWheelersEntering = getVehicleCount(vehicles, "FourWheeler");

        if (fourWheelersEntering > parkingLot.getFourWheelerCapacity()) {
            return "Four wheeler parking capacity is full";
        }
        setCapacityAfterFourWheelersEntry(fourWheelersEntering);
        addVehicle(vehicles);
        return "Four wheeler added in parking";
    }


    public String exitFourWheelersFromParkingLot(List<Vehicle> vehicle) {
        if (vehicle.size() > parkingLot.getFourWheelerCapacity()) {
            return "Four Wheelers can not exits more than parking lot capacity";
        }
        int vehicleCount = getVehicleCount(parkingLot.getVehicles(), "FourWheeler");
        setCapacityAfterFourWheelersExit(vehicleCount);
        addVehicle(vehicle);
        return "Four Wheeler exits";
    }

    public String exitTwoWheelersFromParkingLot(List<Vehicle> vehicle) {
        if (vehicle.size() > parkingLot.getTwoWheelerCapacity()) {
            return "Two Wheelers can not exits more than parking lot capacity";
        }
        int vehicleCount = getVehicleCount(parkingLot.getVehicles(), "TwoWheeler");
        setCapacityAfterTwoWheelersExit(vehicleCount);
        removeVehicle(vehicle);
        return "Two Wheeler exits";
    }

    private int getVehicleCount(List<Vehicle> parkingLot, String vehicleType) {
        return parkingLot.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .collect(Collectors.toList()).size();
    }

    public void setCapacityAfterTwoWheelersEntry(int vehiclesAdded) {
        int capacity = parkingLot.getTwoWheelerCapacity();
        capacity -= vehiclesAdded;
        parkingLot.setTwoWheelerCapacity(capacity);
    }

    public void setCapacityAfterFourWheelersEntry(int vehiclesAdded) {
        int capacity = parkingLot.getTwoWheelerCapacity();
        capacity -= vehiclesAdded;
        parkingLot.setTwoWheelerCapacity(capacity);
    }

    public void setCapacityAfterTwoWheelersExit(int vehiclesAdded) {
        int capacity = parkingLot.getTwoWheelerCapacity();
        capacity -= vehiclesAdded;
        parkingLot.setTwoWheelerCapacity(capacity);
    }

    public void setCapacityAfterFourWheelersExit(int vehiclesAdded) {
        int capacity = parkingLot.getTwoWheelerCapacity();
        capacity -= vehiclesAdded;
        parkingLot.setTwoWheelerCapacity(capacity);
    }


    public List<Vehicle> addTwoVehicles(int noOfVehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < noOfVehicle; i++) {
            vehicles.add(new TwoWheelerVehicle());
        }
        parkingLot.getVehicles().addAll(vehicles);
        return vehicles;
    }

    public List<Vehicle> addFourVehicles(int noOfVehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < noOfVehicle; i++) {
            vehicles.add(new FourWheelerVehicle());
        }
        parkingLot.getVehicles().addAll(vehicles);
        return vehicles;
    }

    public List<Vehicle> removeVehicle(List<Vehicle> vehicles) {
        parkingLot.getVehicles().removeAll(vehicles);
        return vehicles;
    }

    public void addVehicle(List<Vehicle> vehicle) {

        parkingLot.getVehicles().addAll(vehicle);
    }
}
