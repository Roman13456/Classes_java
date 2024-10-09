import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a clothing item with various attributes.
 */
class Clothing {
    private String name;      // Name of the clothing item
    private String size;      // Size of the clothing item
    private String color;     // Color of the clothing item
    private String material;  // Material of the clothing item
    private int price;        // Price of the clothing item

    /**
     * Constructs a Clothing object with specified attributes.
     *
     * @param name     the name of the clothing item
     * @param size     the size of the clothing item
     * @param color    the color of the clothing item
     * @param material the material of the clothing item
     * @param price    the price of the clothing item
     */
    public Clothing(String name, String size, String color, String material, int price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.material = material;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Checks if two Clothing objects are equal based on their attributes.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return price == clothing.price &&
                Objects.equals(name, clothing.name) &&
                Objects.equals(size, clothing.size) &&
                Objects.equals(color, clothing.color) &&
                Objects.equals(material, clothing.material);
    }

    /**
     * Returns a hash code for the Clothing object based on its attributes.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, material, price);
    }

    /**
     * Returns a string representation of the Clothing object.
     *
     * @return a string representation of the Clothing object
     */
    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }
}

/**
 * The main class to run the clothing sorting and searching program.
 */
public class classes {
    public static void main(String[] args) {
        // Create a target clothing object to search for
        Clothing targetClothing = new Clothing("T-shirt", "L", "White", "Cotton", 500);

        // Create an array of Clothing objects
        Clothing[] clothes = {
                new Clothing("T-shirt", "L", "White", "Cotton", 500),
                new Clothing("Pants", "M", "Blue", "Denim", 1000),
                new Clothing("Pants", "L", "Blue", "Denim", 1000),
                new Clothing("Jacket", "XL", "Black", "Leather", 3000),
                new Clothing("Skirt", "S", "Red", "Silk", 700),
                new Clothing("Shirt", "M", "Green", "Linen", 800)
        };

        // Create a comparator for sorting by size
        Comparator<Clothing> sizeComparator = (c1, c2) -> {
            String[] sizes = {"S", "M", "L", "XL"};
            int index1 = Arrays.asList(sizes).indexOf(c1.getSize());
            int index2 = Arrays.asList(sizes).indexOf(c2.getSize());
            return Integer.compare(index1, index2);
        };

        // Print the initial clothing array
        System.out.println("Initial clothing array:");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }      

        // Sort the clothing array by price (ascending) and size (descending)
        Arrays.sort(clothes, Comparator.comparingInt(Clothing::getPrice)
                .thenComparing(sizeComparator.reversed()));  

        // Print the sorted clothing array
        System.out.println("\nSorted clothing array:");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }

        // Search for the target clothing object in the sorted array
        boolean found = false;
        for (Clothing clothing : clothes) {
            if (clothing.equals(targetClothing)) {
                found = true;
                System.out.println("\nFound identical object: " + clothing);
                break;
            }
        }

        // Print the result of the search
        if (!found) {
            System.out.println("\nIdentical object not found");
        }
    }
}
