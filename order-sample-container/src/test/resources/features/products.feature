Feature: Products Scenarios

  Scenario: Get all products
    When we call "/api/v1/products"
    Then we receive a status OK_200 and:
    """
      - name: "Socket"
        price: 2500.5
      - name: "Sneaker"
        price: 9900.0
    """