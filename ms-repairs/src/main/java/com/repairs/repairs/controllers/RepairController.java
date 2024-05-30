package com.repairs.repairs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import usach.tingeso.entities.RepairEntity;
//import usach.tingeso.repositories.RepairRepository;
//import usach.tingeso.services.RepairService;
import com.repairs.repairs.entities.RepairEntity;
import com.repairs.repairs.repositories.RepairRepository;
import com.repairs.repairs.services.RepairService;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("api/v1/repair")
@CrossOrigin(origins = "*")
public class RepairController {

    @Autowired
    RepairService repairService;
    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("/{id}")
    public ResponseEntity<RepairEntity> getRepairById(@PathVariable Long id){
        RepairEntity repair = repairService.getRepairById(id);
        if (repair == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(repair);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RepairEntity> saveRepair(@RequestBody RepairEntity repair){
        System.out.println("EJECUTANDO SAVEREPAIR");
        if (repair == null) {
            System.out.println("Error");
            System.out.println("Error");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("EJECUTANDO SAVEREPAIR");
        System.out.println(repair.toString());
        return ResponseEntity.ok(repairService.saveRepair(repair));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepair(@PathVariable Long id){
        RepairEntity repair = repairService.getRepairById(id);
        if (repair == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repairService.deleteRepair(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<RepairEntity> updateRepair(@RequestBody RepairEntity repair){
        if (repair == null || repairService.getRepairById(repair.getIdRepair()) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(repairService.updateRepair(repair));
    }

    @GetMapping("/")
    public ResponseEntity<List<RepairEntity>> getAllRepairs(){
        List<RepairEntity> repairs = repairService.getAllRepairs();
        if (repairs == null || repairs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(repairs);
    }

    @GetMapping("/byticket/{idTicket}")
    public ResponseEntity<List<RepairEntity>> getRepairsByTicket(@PathVariable("idTicket") Long id){
        List<RepairEntity> repairs = repairService.getRepairsByTicket(id);
        if (repairs == null || repairs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(repairs);
    }



    // Por ahora quedarán así, pero tengo que modificarlos para que se hagan en un llamado y en base al microservicio de ticket

    // Base Price
    @PutMapping("/setBasePrice")
    public ResponseEntity<Integer> setBasePrice(@RequestBody RepairEntity repair){
        int engine = 1; // MUST modify this to use the microservice
        int basePrice = repairService.calculateBasePrice(repair, engine);
        return ResponseEntity.ok(basePrice);
    }


    @PutMapping("/calculateKMSurcharge/{percentage}")
    public ResponseEntity<Integer> calculateKMSurcharge(@RequestBody RepairEntity repair, @PathVariable double percentage){
        return ResponseEntity.ok(repairService.calculateKMSurcharge(repair, percentage));
    }

    @PutMapping("/calculateAgeSurcharge/{percentage}")
    public ResponseEntity<Integer> calculateAgeSurcharge(@RequestBody RepairEntity repair, @PathVariable double percentage){
        return ResponseEntity.ok(repairService.calculateAgeSurcharge(repair, percentage));
    }

    @PutMapping("/calculateDelaySurcharge/{percentage}")
    public ResponseEntity<Integer> calculateDelaySurcharge(@RequestBody RepairEntity repair, @PathVariable double percentage){
        return ResponseEntity.ok(repairService.calculateDelaySurcharge(repair, percentage));
    }

    @PutMapping("/calculateDayDiscount/{percentage}")
    public ResponseEntity<Integer> calculateDayDiscount(@RequestBody RepairEntity repair, @PathVariable double percentage){
        return ResponseEntity.ok(repairService.calculateDayDiscount(repair, percentage));
    }

    @PutMapping("/calculateRepairsDiscount/{percentage}")
    public ResponseEntity<Integer> calculateRepairsDiscount(@RequestBody RepairEntity repair, @PathVariable double percentage){
        return ResponseEntity.ok(repairService.calculateRepairsDiscount(repair, percentage));
    }

    @PutMapping("/calculateTotalPrice")
    public ResponseEntity<Integer> calculateTotalPrice(@RequestBody RepairEntity repair){
        return ResponseEntity.ok(repairService.calculateTotalPrice(repair));
    }





}