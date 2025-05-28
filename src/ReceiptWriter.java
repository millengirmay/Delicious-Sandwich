import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order) {
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        File dir = new File("receipts");
        if (!dir.exists()) dir.mkdir();
        File receipt = new File(dir, filename);
        try (PrintWriter writer = new PrintWriter(receipt)) {
            writer.println(order.getOrderSummary());
            System.out.println("Receipt saved: " + receipt.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}

