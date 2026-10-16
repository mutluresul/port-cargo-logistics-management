import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("=== LIMAN KARGO SISTEMI TESTI ===\n");

        // 1. Polimorfizm Testi: Cargo tipinde bir liste oluşturuyoruz
        List<Cargo> cargoList = new ArrayList<>();

        try {
            // Farklı kargo tiplerinden nesneler türetiyoruz
            LiquidCargo liquid = new LiquidCargo("C101", "Chemical Liquid", 1500.0, "Nordic Chem", 2000.0, true);
            BulkCargo bulk = new BulkCargo("C102", "Wheat Bulk", 5000.0, "AgriCorp", false);
            ContainerCargo container = new ContainerCargo("C103", "Electronics", 2300.0, "TechWorld", "CONT-9988");

            cargoList.add(liquid);
            cargoList.add(bulk);
            cargoList.add(container);

            // 2. Detay Gösterimi ve Ücret Hesaplama (Polymorphism)
            System.out.println("--- KARGO DETAYLARI VE UCRET HESAPLAMA ---");
            for (Cargo cargo : cargoList) {
                cargo.displayDetails();
                System.out.println("-----------------------------------");
            }

            // 3. Inspectable Arayüzü Testi (Interface Check)
            System.out.println("\n--- DENETIM (INSPECTION) TESTI ---");
            for (Cargo cargo : cargoList) {
                if (cargo instanceof Inspectable) {
                    Inspectable inspectableCargo = (Inspectable) cargo;
                    System.out.println("Kargo ID: " + cargo.getId() + " - Denetim Oncesi: " + inspectableCargo.isInspected());
                    inspectableCargo.inspect();
                    System.out.println("Kargo ID: " + cargo.getId() + " - Denetim Sonrasi: " + inspectableCargo.isInspected());
                    System.out.println("-----------------------------------");
                }
            }

        } catch (Exception e) {
            System.err.println("Beklenmeyen hata: " + e.getMessage());
        }

        // 4. Veri Doğrulama (Validation) Testi
        System.out.println("\n--- VALIDATION (GIRDI DOGRULAMA) TESTI ---");
        try {
            System.out.println("Negatif agırlık testi yapılıyor...");
            LiquidCargo invalidCargo = new LiquidCargo("C999", "Invalid", -500.0, "Test Corp", 1000.0, false);
        } catch (IllegalArgumentException e) {
            System.out.println("YALAN/HATALI GIRDI YAKALANDI: " + e.getMessage());
        }
    }
}