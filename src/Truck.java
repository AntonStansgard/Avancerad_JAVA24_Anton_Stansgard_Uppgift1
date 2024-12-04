//Klass som ärver egenskaperna från Vehicle och implementerar metoderna från Rentable
public class Truck extends Vehicle {
    private int numberOfDoors;
    private boolean isRented;

    //Konstruktor för Truck extenden från abstracta klassen Vehicle
    public Truck(String model, int price, String regPlate,int numberOfDoors) {

        //Super referar till abstrakta klassens egenskaper
        super(model, price, regPlate);

        this.numberOfDoors = numberOfDoors;

        //Tilldelar värdet false till isRented
        this.isRented = false;
    }

    //Metod för att hyra ut Truck,implementerad från interface
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

    //Metod för att retunera Truck,implementerad från interface
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

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}
