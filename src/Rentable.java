public interface Rentable {
    //Metoder som kommer alla bilar kommer implementera
    String rentOut();

    String returnRent();

    double calculateBill(int days);

    boolean isAvailable();
}
