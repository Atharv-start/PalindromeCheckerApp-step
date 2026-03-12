public class statement8 {
    private String[] spots = new String[500]; // Open Addressing Array

    public int parkVehicle(String licensePlate) {
        int hash = Math.abs(licensePlate.hashCode() % 500);
        int current = hash;

        while (spots[current] != null) {
            current = (current + 1) % 500; // Linear Probing
            if (current == hash) return -1; // Full
        }
        spots[current] = licensePlate;
        return current;
    }
}