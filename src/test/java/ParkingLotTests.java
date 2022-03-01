import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTests{
Vehicle twoWheelerVehicle;
        Vehicle fourWheelerVehicle;
        Multiplex multiplex;
        ParkingLotService parkingLotService;

@BeforeTest
public void initialVehicleToParkingLotInMultiplex() {

       twoWheelerVehicle = new TwoWheelerVehicle();
        fourWheelerVehicle = new FourWheelerVehicle();

        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
        vehicleList.add(new TwoWheelerVehicle());
        }
        ParkingLot parkingLot = new ParkingLot.Builder().build();

        multiplex = Multiplex.builder().parkingLot(parkingLot).build();
        parkingLotService = new ParkingLotService(multiplex.parkingLot);
        }

@Test
public void shouldNotHaveTwoWheelersMoreThanCapacity() {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
        vehicleList.add(new TwoWheelerVehicle());
        }
        ParkingLotService parkingLotService = new ParkingLotService(multiplex.parkingLot);
        String msg = parkingLotService.incomingTwoWheelerVehicleInParkingLot(vehicleList);
        Assert.assertEquals(msg, "Two wheeler parking capacity is full");
        }

@Test
public void shouldAddTwoWheelers() {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
        vehicleList.add(new TwoWheelerVehicle());
        }

        String msg = parkingLotService.incomingTwoWheelerVehicleInParkingLot(vehicleList);
        Assert.assertEquals(msg, "Two wheeler added in parking");
        Assert.assertEquals(multiplex.parkingLot.getVehicles().size(), 30);
        }

@Test
public void shouldAddFourWheelers() {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
        vehicleList.add(new FourWheelerVehicle());
        }
        ParkingLotService parkingLotService = new ParkingLotService(multiplex.parkingLot);
        String msg = parkingLotService.incomingFourWheelerVehicleInParkingLot(vehicleList);
        Assert.assertEquals(msg, "Four wheeler added in parking");
        Assert.assertEquals(multiplex.parkingLot.getVehicles().size(), 15);
        }

@Test
public void shouldNotRemoveTwoWheelersMoreThanEnteredVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
        vehicleList.add(new TwoWheelerVehicle());
        }
        ParkingLotService parkingLotService = new ParkingLotService(multiplex.parkingLot);
        String msg = parkingLotService.exitTwoWheelersFromParkingLot(vehicleList);
        Assert.assertEquals(msg, "Two Wheelers can not exits more than parking lot capacity");
        }
        }
