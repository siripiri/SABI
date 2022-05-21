package com.siripiri.api.boostrap;

import com.siripiri.api.domain.*;
import com.siripiri.api.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadData implements CommandLineRunner {
    private final LorryRepository lorryRepository;
    private final DriverRepository driverRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final TripRepository tripRepository;
    private final LocationRepository locationRepository;
    private final ExpensesRepository expensesRepository;
    private final CylinderDetailsRepository cylinderDetailsRepository;
    private final CylinderCountRepository cylinderCountRepository;
    private final FuelRepository fuelRepository;

    public LoadData(LorryRepository lorryRepository, DriverRepository driverRepository, PhoneNumberRepository phoneNumberRepository, TripRepository tripRepository, LocationRepository locationRepository, ExpensesRepository expensesRepository, CylinderDetailsRepository cylinderDetailsRepository, CylinderCountRepository cylinderCountRepository, FuelRepository fuelRepository) {
        this.lorryRepository = lorryRepository;
        this.driverRepository = driverRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.tripRepository = tripRepository;
        this.locationRepository = locationRepository;
        this.expensesRepository = expensesRepository;
        this.cylinderDetailsRepository = cylinderDetailsRepository;
        this.cylinderCountRepository = cylinderCountRepository;
        this.fuelRepository = fuelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTripDriver();
        loadFuel();
    }

    public void loadTripDriver() {
        // lorry details
        Lorry lorry1 = new Lorry();
        lorry1.setId(1L);
        lorry1.setNumberPlate("TN 36 N 5959");

        // driver details
        Driver driver1 = new Driver();
        driver1.setId(1L);
        driver1.setAge(28);
        driver1.setName("sudha");
        driver1.setAddress("I2/218 staff quarters, IRTT college, vasavi po, Erode-638316");
        driver1.setChildrenDetails("1 son 2 daughter");

        // phone number
        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setId(1L);
        phoneNumber1.setHouse("+91 7558174283");
        phoneNumber1.setPersonal("+91 9788774532");
        phoneNumber1.setOffice("+91 9788774531");

        driver1.setPhoneNumber(phoneNumber1);
        driver1.getLorry().add(lorry1);

        lorryRepository.save(lorry1);


        // Trip details
        Trip trip1 = new Trip();
        trip1.setId(1L);
        trip1.setDate(LocalDate.now());
        trip1.setPlantToDistributor(10L);
        trip1.setDistributorToPlant(10L);

        // Location
        Location location = new Location();
        location.setId(1L);
        location.setName("Periyakullam");
        location.setKilometer(100L);

        trip1.setLocation(location);

        // Cap Shortage
        Expenses capSortage = new Expenses();
        capSortage.setId(1L);
        capSortage.setDate(LocalDate.now());
        capSortage.setCost(100L);
        capSortage.setExpensesType("CapSortage");
        capSortage.setDescription("For each cap shortage we need to pay $10");
        expensesRepository.save(capSortage);

        trip1.setCapShortage(capSortage);

        // salary details
        Expenses salaryDriver = new Expenses();
        salaryDriver.setId(2L);
        salaryDriver.setDate(LocalDate.now());
        salaryDriver.setDescription("Salary for this trip");
        salaryDriver.setCost(800L);
        salaryDriver.setExpensesType("SALARY");

        trip1.setSalary(salaryDriver);
        expensesRepository.save(salaryDriver);
        driver1.getTrips().add(trip1);
        driverRepository.save(driver1);

        trip1.setDriver(driver1);
        tripRepository.save(trip1);

        // commercial cylinder
        CylinderDetails commercialCylinder = new CylinderDetails();
        commercialCylinder.setId(1L);
        commercialCylinder.setName("COMMERCIAL CYLINDER");
        commercialCylinder.setWeight(50);
        cylinderDetailsRepository.save(commercialCylinder);


        // normal cylinder
        CylinderDetails normalCylinder = new CylinderDetails();
        normalCylinder.setId(2L);
        normalCylinder.setName("NORMAL CYLINDER");
        normalCylinder.setWeight(25);
        cylinderDetailsRepository.save(normalCylinder);

        // Cylinder Count for commercial cylinder
        CylinderCount cylinderCountCommercial = new CylinderCount();
        cylinderCountCommercial.setId(1L);
        cylinderCountCommercial.setCount(10);
        cylinderCountCommercial.setTrip(trip1);
        cylinderCountCommercial.setCylinderType(commercialCylinder);

        cylinderCountRepository.save(cylinderCountCommercial);

        // Cylinder count for normal cylinder
        CylinderCount cylinderCountNormal = new CylinderCount();
        cylinderCountNormal.setId(2L);
        cylinderCountNormal.setCount(20);
        cylinderCountNormal.setTrip(trip1);
        cylinderCountNormal.setCylinderType(normalCylinder);

        cylinderCountRepository.save(cylinderCountNormal);
    }

    public void loadFuel() {
        // fuel expenses
        Expenses fuelExpenses = new Expenses();
        fuelExpenses.setId(3L);
        fuelExpenses.setExpensesType("FUEL EXPENSES");
        fuelExpenses.setCost(200L);
        fuelExpenses.setDescription("FUEL EXPENSES");
        fuelExpenses.setDate(LocalDate.now());
        expensesRepository.save(fuelExpenses);

        // fuel details
        Fuel fuel = new Fuel();
        fuel.setId(1L);
        fuel.setCurrentFuelPrice(200L);
        fuel.setExpenses(fuelExpenses);
        fuel.setPaymentMode("CARD");
        fuel.setLiterFilled(100L);
        fuelRepository.save(fuel);
    }
}
