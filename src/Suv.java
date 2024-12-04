//Klass som ärver egenskaperna från Vehicle och implementerar metoderna från Rentable
public class Suv extends Vehicle {
    private double milesRun;
    private boolean isRented;

    //Den urspungliga konstruktor alla fordron kommer ärva
    public Suv(String model, int price, String regPlate,double milesRun) {

        //Super referar till abstrakta klassens egenskaper
        super(model, price, regPlate);


        this.milesRun = milesRun;

        //Tilldelar värdet false till isRented
        this.isRented = false;
    }

    //Metod för att retunera Suv,implementerad från interface
    @Override
    public String rentOut() {

        //Ifall isRented är false kommer output skrivas ut
        if (isRented) {
            return "Fordonet är redan uthyrd";
        }

        //Ifall isRented är sann kommer följande uppmaning skrivas ut
        this.isRented = true;
        return "Grattis du har hyrt bilen";

    }

    //Metod för att retunera Suv,implementerad från interface
    @Override
    public String returnRent() {

        //Om isRented är sann kommer följande uppmaning skrivas ut
        if (!isRented) {
            return "Bilen är inte uthyrd";
        }

        //Ifall bilen inte är uthyrd(vilket innebär retunerad) kommer följande uppmaning skrivas ut
        this.isRented = false;
        return "Bilen är nu returnerad!";
    }

    //Metod för att räkna ut kostnaden för att hyra Trucken,implementerad från interface
    @Override
    public double calculateBill(int days) {

        //Retunerar produkten av antal dagar samt pris
        return days * getPrice();
    }

    @Override
    public boolean isAvailable() {
        return this.isRented;
    }

    public double getMilesRun() {
        return milesRun;
    }
}

