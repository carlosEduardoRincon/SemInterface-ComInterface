
package model.services;

import Entities.CarRental;
import Entities.Invoice;

public class RentalService {
    
    private Double pricePerDay;
    private Double pricePerHour;
    
    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }
    
    public void processInvoice(CarRental carRental){
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double)(t2-t1) / 1000 / 60 / 60;       
        
        double basicPayment;
        if (hours <= 12.0){
            basicPayment = Math.ceil(hours)*pricePerHour;
        }
        else {
            basicPayment = Math.ceil(hours/24)*pricePerDay;
        }
        
        double tax = taxService.tax(basicPayment);
        
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
