
package Entities;

import java.util.Date;

public class CarRental {
    
    private Date start;
    private Date finish;
    
    private Vehicle vecicle;
    private Invoice invoice;

    public CarRental() {
    }

    public CarRental(Date start, Date finish, Vehicle vecicle) {
        this.start = start;
        this.finish = finish;
        this.vecicle = vecicle;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    public Vehicle getVecicle() {
        return vecicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public void setVecicle(Vehicle vecicle) {
        this.vecicle = vecicle;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
}
