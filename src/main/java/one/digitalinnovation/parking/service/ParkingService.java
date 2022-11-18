package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.exceptions.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    public List<Parking> findAll(){
        return new ArrayList<>(parkingMap.values());
    }

    static{
        var id  = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "BA", "XC60", "AZUL");
        parkingMap.put(id, parking);
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(@PathVariable String id) {
        Parking parking = parkingMap.get(id);
        if(parking == null) throw new ParkingNotFoundException(id);
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}
