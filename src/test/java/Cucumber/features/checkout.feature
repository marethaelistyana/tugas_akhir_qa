Feature: Checkout Product

  Scenario: User melakukan checkout product
    Given user berada di halaman Your Cart
    When user klik button Checkout
    And user input informasi Checkout
    And user klik button continue
    And user klik button finish
    Then menampilkan halaman Checkout Complete


