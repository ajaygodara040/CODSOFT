import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base currency code (e.g. USD): ");
        String fromCurrency = sc.next().trim().toUpperCase();

        System.out.print("Enter target currency code (e.g. INR): ");
        String toCurrency = sc.next().trim().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        try {
            double rate = getExchangeRate(fromCurrency, toCurrency);

            if (rate == -1) {
                System.out.println("Could not find exchange rate for " + toCurrency
                        + ". Please check the currency code and try again.");
                sc.close();
                return;
            }

            double convertedAmount = amount * rate;

            System.out.println("\n=== Conversion Result ===");
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            System.out.println("Exchange Rate Used: 1 " + fromCurrency + " = " + rate + " " + toCurrency);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching exchange rate. Please check your internet connection.");
        }

        sc.close();
    }

    // Fetches the real-time exchange rate from base currency to target currency
    static double getExchangeRate(String base, String target) throws IOException, InterruptedException {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            return -1;
        }

        String responseBody = response.body();

        // Extract the rate for the target currency from the JSON response
        // Looks for a pattern like "INR":83.12
        Pattern pattern = Pattern.compile("\"" + target + "\":(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        }

        return -1;
    }
}