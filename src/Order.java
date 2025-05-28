import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item){
        items.add(item);
    }

    public double getTotal(){
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public String getSummary(){
        StringBuilder sb = new StringBuilder("order summary:\n");
        items.forEach(item -> {
            if(item instanceof Sandwich){
                sb.append(((Sandwich) item).getDetails());
            }else{
                sb.append(" ").append(item.getName()).append(" -$").append(String.format("%.2f", item.getPrice())).append("\n");
            }
            });
            sb.append("Total: $").append(String.format("%.2f", getTotal())).append(String.format("%.2f", getTotal())).append("\n");
            return sb.toString();
        }

        public void saveReceipt(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Path dir = Paths.get("receipts");
        try{
            Files.createDirectories(dir);
            Path file = dir.resolve(timestamp + ".txt");
            Files.write(file,getSummary().getBytes());
            System.out.println("Receipt saved: " + file);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
        }

        public void clear(){
            items.clear();
        }
}
