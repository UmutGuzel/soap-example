# SOAP Service Documentation

## Basic Concepts

### What is SOAP?
SOAP (Simple Object Access Protocol) is a protocol for exchanging structured information in web services. It uses XML to format messages and typically operates over HTTP. SOAP provides a standardized way to communicate between different systems, regardless of their underlying technology.

### What is XSD?
XSD (XML Schema Definition) is a language used to define the structure and data types of XML documents. In this project, XSD files (`countries.xsd` and `payment.xsd`) define the structure of the SOAP messages, specifying what data can be sent and received.

### What is WSDL?
WSDL (Web Services Description Language) is an XML-based language that describes the functionality offered by a web service. It defines:
- The operations available
- The messages that can be sent and received
- The data types used
- The communication protocols and endpoints

### About This Example
This is a basic SOAP web service example that demonstrates:
- How to create SOAP endpoints using Spring Boot
- How to define service contracts using XSD
- How to expose WSDL definitions
- Basic request/response patterns

The example includes two simple services:
1. A Country service that returns basic country information
2. A Payment service that simulates payment processing

This implementation serves as a starting point for understanding SOAP web services and can be extended for more complex scenarios.

## Overview
This project is a Spring Boot application that provides two SOAP web services:
1. **Country Service**: Allows querying country information by name.
2. **Payment Service**: Processes payment requests with support for credit card and PayPal payment methods.

## Prerequisites
- Java 21
- Maven 3.x

## Project Structure
- **src/main/java/com/umut/soap**: Contains the main application code.
  - **endpoint**: SOAP endpoint classes (CountryEndpoint, PaymentEndpoint).
  - **service**: Business logic classes (CountryService, PaymentService).
  - **config**: Configuration classes (WebServiceConfig).
- **src/main/resources/schemas**: Contains XSD files defining the SOAP service contracts.
  - **countries.xsd**: Defines the country service schema.
  - **payment.xsd**: Defines the payment service schema.

## Setup and Running the Application
1. Clone the repository.
2. Navigate to the project root directory.
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
   The application will start and expose the SOAP services at `http://localhost:8080/ws`.

## Available SOAP Endpoints

### Country Service
- **WSDL URL**: `http://localhost:8080/ws/countries.wsdl`
- **Namespace**: `http://example.com/countries`
- **Operation**: `getCountry`
  - **Request**: Provide a country name.
  - **Response**: Returns country details (name, capital, population).

### Payment Service
- **WSDL URL**: `http://localhost:8080/ws/payment.wsdl`
- **Namespace**: `http://example.com/payment`
- **Operation**: `processPayment`
  - **Request**: Provide payment details including transaction ID, amount, currency, payment method (credit card or PayPal), and customer details.
  - **Response**: Returns a result code, message, and authorization ID if successful.

## Example Usage

### Country Service Example
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cou="http://example.com/countries">
   <soapenv:Header/>
   <soapenv:Body>
      <cou:getCountryRequest>
         <cou:name>United Kingdom</cou:name>
      </cou:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Payment Service Example
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pay="http://example.com/payment">
   <soapenv:Header/>
   <soapenv:Body>
      <pay:paymentRequest>
         <pay:transactionId>12345</pay:transactionId>
         <pay:amount>100.00</pay:amount>
         <pay:currency>USD</pay:currency>
         <pay:paymentMethod>
            <pay:creditCard>
               <pay:cardNumber>4111111111111111</pay:cardNumber>
               <pay:expiryDate>12/25</pay:expiryDate>
               <pay:cvv>123</pay:cvv>
            </pay:creditCard>
         </pay:paymentMethod>
         <pay:customerDetails>
            <pay:customerId>cust123</pay:customerId>
            <pay:email>customer@example.com</pay:email>
         </pay:customerDetails>
      </pay:paymentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## Additional Resources
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Web Services Documentation](https://docs.spring.io/spring-ws/docs/current/reference/html/)
- [Maven Documentation](https://maven.apache.org/guides/index.html) 