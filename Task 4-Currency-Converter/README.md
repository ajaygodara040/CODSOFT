# Currency Converter

A console-based Java program that converts an amount from one currency to another using **real-time exchange rates** fetched from a live currency API.

## How It Works

- The program asks for:
  - **Base currency code** (e.g., USD)
  - **Target currency code** (e.g., INR)
  - **Amount** to convert
- It sends an HTTP request to the [ExchangeRate-API](https://www.exchangerate-api.com/) to fetch the latest exchange rates for the base currency.
- It extracts the exchange rate for the target currency from the JSON response using regex pattern matching.
- It calculates the converted amount: `amount × exchange rate`.
- The result is displayed along with the exchange rate used.

## Features

- Real-time currency conversion using a live API (no hardcoded rates).
- Supports any currency code supported by the API (USD, INR, EUR, GBP, JPY, etc.).
- Handles invalid currency codes gracefully (shows an error message).
- Handles network/connection errors gracefully.

## Requirements

- Java JDK 11 or above (required for `java.net.http.HttpClient`).
- An active internet connection (required to fetch live exchange rates).

## How to Run

1. Save the file as `CurrencyConverter.java`.
2. Open a terminal in the folder containing the file.
3. Compile the program:
   ```
   javac CurrencyConverter.java
   ```
4. Run the program:
   ```
   java CurrencyConverter
   ```

## Sample Run

```
Enter base currency code (e.g. USD): USD
Enter target currency code (e.g. INR): INR
Enter amount to convert: 100

=== Conversion Result ===
100.00 USD = 8312.00 INR
Exchange Rate Used: 1 USD = 83.12 INR
```

## How Exchange Rates Are Fetched

The program calls this API endpoint:
```
https://api.exchangerate-api.com/v4/latest/{base_currency}
```
It then searches the JSON response for the target currency's rate using a regex pattern like `"INR":83.12` and extracts the numeric value.

## Possible Improvements

- Use a proper JSON library (e.g., Jackson or Gson) instead of regex for parsing.
- Add support for converting between multiple currencies at once.
- Cache exchange rates locally to reduce API calls.
- Add a list/menu of common currency codes for easier input.
- Add retry logic for failed API requests.
- Display rate update timestamp from the API response.

## Author
AJAY KUMAR