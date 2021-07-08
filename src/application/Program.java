
package application;

import Entities.CarRental;
import Entities.Vehicle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

    public static void main(String args[]) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        
        System.out.println("Entrer rental data: ");
        System.out.print("Car model: ");
        String model = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        Date start = sdf.parse(sc.nextLine());
        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        Date finish = sdf.parse(sc.nextLine());
        
        CarRental cr = new CarRental(start, finish, new Vehicle(model));
        
        System.out.print("Entre price per hour: ");
        double pricePerhour = sc.nextDouble();
        System.out.print("Entre price per day: ");
        double pricePerDay = sc.nextDouble();
        
        RentalService rentalService = new RentalService(pricePerDay, pricePerhour, new BrazilTaxService());
        
        rentalService.processInvoice(cr);
        System.out.println("");
        System.out.println("INVOICE: ");
        System.out.println("Basic payment: "+String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: "+String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: "+String.format("%.2f", cr.getInvoice().getTotalPayment()));
        
        sc.close();
    }
}
