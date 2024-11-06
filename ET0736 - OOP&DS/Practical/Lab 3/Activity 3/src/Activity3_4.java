public class Activity3_4 {
    public static void main(String[] args) {
        PC pc = new PC("Crucial T705", "2TB", "Intel");
        System.out.println(pc.toString());
    }
    static class PC {
        SSD ssd;
        CPU cpu;
        PC(String ssd_brand, String ssd_capacity, String cpu_brand) {
            ssd = new SSD(ssd_brand, ssd_capacity);
            cpu = new CPU(cpu_brand);
        }
        public String toString() {
            return ("PC with CPU " + cpu.brand + " and SSD " + ssd.brand +
                    " with " + ssd.capacity + " of storage space");
        }
    }
    static class CPU {
        String brand;
        CPU(String brand) {
            this.brand = brand;
        }
    }
    static class SSD {
        String brand;
        String capacity;
        SSD(String brand, String capacity) {
            this.brand = brand;
            this.capacity = capacity;
        }
    }
}
