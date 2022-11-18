package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

}
